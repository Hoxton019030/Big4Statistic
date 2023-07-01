function Footer() {
    return (
        <div className="d-flex flex-column min-vh-100">
            <footer className="page-footer font-small blue pt-4 mt-auto">

                <div className="container-fluid text-center text-md-left ">

                    <div className="row">

                        <div className="col-md-6 mt-md-0 mt-3">


                        </div>


                        <div className="col-md-3 mb-md-0 mb-3">


                            <h5 className="text-uppercase">參考之API列表</h5>


                            <ul className="list-unstyled">
                                <li>
                                    <a href="https://openapi.twse.com.tw/v1/opendata/opendata/t187ap23_L">上市公司違反資訊申報、重大訊息及說明記者會規定專區</a>
                                </li>
                                <li>
                                    <a href="https://openapi.twse.com.tw/v1/opendata/opendata/t187ap22_L">上市公司金管會證券期貨局裁罰案件專區</a>
                                </li>
                                <li>
                                    <a href="https://openapi.twse.com.tw/v1/opendata/t187ap03_L">上市公司基本資料</a>
                                </li>
                                <li>
                                    <a href="https://openapi.twse.com.tw/v1/opendata/t187ap03_P">公開發行公司基本資料</a>
                                </li>
                            </ul>

                        </div>
                        <div className="col-md-3 mb-md-0 mb-3">

                            <h5 className="text-uppercase">Github</h5>

                            <ul className="list-unstyled">
                                <li>
                                    <a href="https://github.com/Hoxton019030/Big4Statistic">Github原始碼網址</a>
                                </li>
                            </ul>

                        </div>

                    </div>

                </div>

                <div className="footer-copyright text-center py-3">© 2020 Copyright:
                </div>

            </footer>
        </div>
    )
}

export default Footer