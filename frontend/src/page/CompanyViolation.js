import axios from "axios";
import {useEffect, useState} from "react";

function CompanyViolation() {

    const baseURL=process.env.REACT_APP_API_PORT
    const url = baseURL+"punish"

    const [firms, setFirms] = useState([])

    useEffect(() => {
        loadFirms();
    }, [])
    const loadFirms = async () => {
        const result = await axios.get(url);
        // setFirms(result.data)
        setFirms(result.data.sort((a, b) => b.punishEventList.length - a.punishEventList.length))
    }


    return (
        <div>
            <h1>經證券期貨局裁罰案件與違反資訊申報、重大訊息及說明記者會規定</h1>
            <div className="accordion" id="accordionExample">

                {firms.map((value, index, array) => (<div className="card" key={index}>
                    <div className="card-header" id="headingOne">
                        <h2 className="mb-1">
                            <button className="btn btn-link btn-block text-left" type="button"
                                    data-toggle="collapse"
                                    data-target={`#collapseOne${index}`} aria-expanded="true"
                                    aria-controls="collapseOne"
                            >
                                {value.auditingAccountingFirm}({value.punishEventList.length})
                            </button>
                        </h2>
                    </div>

                    <div id={`collapseOne${index}`} className="collapse" aria-labelledby="headingOne"
                         data-parent="#accordionExample">
                        <div className="card-body">
                            <table className="table ">
                                <thead>
                                <tr>
                                    <th scope="col">編號</th>
                                    <th scope="col">公司名稱</th>
                                    <th scope="col">違規事由</th>
                                    <th scope="col">發函日期</th>
                                </tr>
                                </thead>
                                <tbody>
                                {value.punishEventList.map((value, index) =>
                                    (
                                        <tr key={index + 1}>
                                            <th className="col-xl-1" scope="row">{index + 1}</th>
                                            <td className="col-xl-1">{value.companyName} </td>
                                            <td>{value.violationReason}</td>
                                            <td className="col-xl-1">{value.letterDate}</td>
                                        </tr>
                                    ))}
                                </tbody>

                            </table>

                        </div>
                    </div>
                </div>))}
            </div>
        </div>)
}

export default CompanyViolation;