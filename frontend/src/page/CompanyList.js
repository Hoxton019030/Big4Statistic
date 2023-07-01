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
                            <h2 className="mb-0">
                                <button className="btn btn-link btn-block text-left" type="button"
                                        data-toggle="collapse"
                                        data-target="#collapseOne" aria-expanded="true" aria-controls="collapseOne">
                                    {value.auditingAccountingFirm}
                                </button>
                            </h2>
                        </div>

                        <div id="collapseOne" className="collapse show" aria-labelledby="headingOne"
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
                <div className="card">
                    <div className="card-header" id="headingTwo">
                        <h2 className="mb-0">
                            <button className="btn btn-link btn-block text-left collapsed" type="button"
                                    data-toggle="collapse" data-target="#collapseTwo" aria-expanded="false"
                                    aria-controls="collapseTwo">
                                Collapsible Group Item #2
                            </button>
                        </h2>
                    </div>
                    <div id="collapseTwo" className="collapse" aria-labelledby="headingTwo"
                         data-parent="#accordionExample">
                        <div className="card-body">
                            Some placeholder content for the second accordion panel. This panel is hidden by default.
                        </div>
                    </div>
                </div>
                <div className="card">
                    <div className="card-header" id="headingThree">
                        <h2 className="mb-0">
                            <button className="btn btn-link btn-block text-left collapsed" type="button"
                                    data-toggle="collapse" data-target="#collapseThree" aria-expanded="false"
                                    aria-controls="collapseThree">
                                Collapsible Group Item #3
                            </button>
                        </h2>
                    </div>
                    <div id="collapseThree" className="collapse" aria-labelledby="headingThree"
                         data-parent="#accordionExample">
                        <div className="card-body">
                            And lastly, the placeholder content for the third and final accordion panel. This panel is
                            hidden by default.
                        </div>
                    </div>
                </div>
            </div>
        </div>
    )
}

export default CompanyList