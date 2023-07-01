import {useEffect, useState} from "react";
import axios from "axios";


function CompanyVisa() {
    const baseURL = process.env.REACT_APP_API_PORT
    let url = baseURL + "company"

    const [firms, setFirms] = useState([]);
    useEffect(() => {
        loadUFirms();
    }, [])

    const loadUFirms = async () => {
        const result = await axios.get(url);
        setFirms(result.data.sort((a, b) => b.companyList.length - a.companyList.length))
        // setFirms(result.data)
    }


    return (
        <div>
            <h1>會計師事務所上市公司/公開發行簽證數量</h1>

            <table className="table">
                <thead>
                <tr>
                    <th scope="col">編號</th>
                    <th scope="col">名稱</th>
                    <th scope="col">簽證公司數量</th>
                </tr>
                </thead>
                <tbody>
                {
                    firms.map((firm, index) => (
                        <tr key={index}>
                            <th scope="row">{index + 1}</th>
                            <td>{firm.auditingAccountingFirm}</td>
                            <td>{firm.companyList.length}</td>
                        </tr>
                    ))
                }
                </tbody>
            </table>
        </div>
    )
}

export default CompanyVisa