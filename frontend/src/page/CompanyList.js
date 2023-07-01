import axios from "axios";
import {useEffect, useState} from "react";

function CompanyList() {
    const url = "http://localhost:8080/company"

    const [firms, setFirms] = useState([]);
    useEffect(() => {
        loadFirms();
    }, [])
    const loadFirms = async () => {
        const result = await axios.get(url);
        setFirms(result.data)
        setFirms(result.data.sort((a, b) => b.companyList.length - a.companyList.length))
    }



    return (


        <div>
            <div className="accordion" id="accordionExample">

                {firms.map((value, index, array) => (
                    <div className="card">
                        <div className="card-header" id="headingOne">
                            <h2 className="mb-1">
                                <button className="btn btn-link btn-block text-left" type="button"
                                        data-toggle="collapse"
                                        data-target={`#collapseOne${index}`} aria-expanded="true" aria-controls="collapseOne"
                                >
                                    {value.auditingAccountingFirm}
                                </button>
                            </h2>
                        </div>

                        <div id={`collapseOne${index}`} className="collapse" aria-labelledby="headingOne"
                             data-parent="#accordionExample">
                            <div className="card-body">
                                {value.companyList.map((value) => (
                                    <div>
                                        {value.companyName}
                                    </div>
                                ))}
                            </div>
                        </div>
                    </div>
                ))}
            </div>
        </div>
    )
}

export default CompanyList