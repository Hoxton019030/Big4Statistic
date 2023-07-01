import axios from "axios";
import {useEffect, useState} from "react";

function CompanyList() {
    const baseURL=process.env.REACT_APP_API_PORT
    const url = baseURL+"company"
    const [firms, setFirms] = useState([]);
    const [searchValue, setSearchValue] = useState('');
    useEffect(() => {
        loadFirms();
    }, [])
    const loadFirms = async () => {
        const result = await axios.get(url);
        setFirms(result.data)
        setFirms(result.data.sort((a, b) => b.companyList.length - a.companyList.length))
    }

    const handleButtonClick = () => {
        setSearchValue('');
    };


    return (


        <div>

            <div className="input-group rounded">
                <input type="search" className="form-control rounded" placeholder="懶得做搜尋功能了" value={searchValue}
                       onChange={(e) => {
                           setSearchValue(e.target.value)
                       }} aria-label="Search"
                       aria-describedby="search-addon"/>
                <span className="input-group-text border-0" id="search-addon"/>
                <button type="button" className="btn btn-primary" onClick={handleButtonClick}>
                    搜尋
                </button>
            </div>


            <div className="accordion" id="accordionExample">

                {firms.map((value, index, array) => (<div className="card" key={index}>
                    <div className="card-header" id="headingOne">
                        <h2 className="mb-1">
                            <button className="btn btn-link btn-block text-left" type="button"
                                    data-toggle="collapse"
                                    data-target={`#collapseOne${index}`} aria-expanded="true"
                                    aria-controls="collapseOne"
                            >
                                {value.auditingAccountingFirm}({value.companyList.length})
                            </button>
                        </h2>
                    </div>

                    <div id={`collapseOne${index}`} className="collapse" aria-labelledby="headingOne"
                         data-parent="#accordionExample">
                        <div className="card-body">
                            <table className="table table-sm">
                                <thead>
                                <tr>
                                    <th scope="col">編號</th>
                                    <th scope="col">公司名稱</th>
                                    <th scope="col">簽證會計師1</th>
                                    <th scope="col">簽證會計師2</th>
                                </tr>
                                </thead>
                                <tbody>
                                {value.companyList.map((value, index) =>
                                    (
                                        <tr key={index + 1}>
                                            <th scope="row">{index + 1}</th>
                                            <td>{value.companyName} </td>
                                            <td>{value.signingAuditor1}</td>
                                            <td>{value.signingAuditor2}</td>
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

export default CompanyList