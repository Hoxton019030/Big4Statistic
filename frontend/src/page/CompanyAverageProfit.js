import axios from "axios";
import {useEffect, useState} from "react";

function CompanyAverageProfit() {

    const baseURL=process.env.REACT_APP_API_PORT
    const profitURL = baseURL+"profit"

    const [firms, setFirms] = useState([])

    useEffect(() => {
        loadFirms()
    }, [])

    const loadFirms = async () => {
        const response = await axios.get(profitURL);
        setFirms(response.data.sort((a, b) => b.companyProfitList.length - a.companyProfitList.length))
    }

    return (
        <div>
            <h1>各事務所簽約公司獲利能力</h1>
            <div className="accordion" id="accordionExample">

                {firms.map((value, index, array) => (<div className="card" key={index}>
                    <div className="card-header" id="headingOne">
                        <h2 className="mb-1">
                            <button className="btn btn-link btn-block text-left" type="button"
                                    data-toggle="collapse"
                                    data-target={`#collapseOne${index}`} aria-expanded="true"
                                    aria-controls="collapseOne"
                            >
                                {value.auditingAccountingFirm}({value.companyProfitList.length})
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
                                    <th scope="col">營業收入(以百萬計)</th>
                                    <th scope="col">稅前收入毛利率</th>
                                    <th scope="col">稅後收入毛利率</th>
                                    <th scope="col">財報日期</th>
                                </tr>
                                </thead>
                                <tbody>
                                {value.companyProfitList.sort((a, b) => b.operatingRevenue - a.operatingRevenue).map((value, index) =>
                                    (
                                        <tr key={index + 1}>
                                            <th className="col-xl-1" scope="row">{index + 1}</th>
                                            <td className="col-xl-1">{value.companyName} </td>
                                            <td>{value.operatingRevenue.toLocaleString()}</td>
                                            <td>{value.preTaxNetProfitMargin}%</td>
                                            <td>{value.afterTaxNetProfitMargin}%</td>
                                            <td className="col-xl-1">{value.reportDate}</td>
                                        </tr>
                                    ))}
                                </tbody>

                            </table>

                        </div>
                    </div>
                </div>))}
            </div>
        </div>
    )
}

export default CompanyAverageProfit;