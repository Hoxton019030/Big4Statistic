import "../node_modules/bootstrap/dist/css/bootstrap.css"
import "../node_modules/bootstrap/dist/js/bootstrap.bundle.min.js"
import Navbar from "./Navbar";
import {Route, Routes} from "react-router-dom";
import CompanyVisa from "./page/CompanyVisa";
import CompanyAverageProfit from "./page/CompanyAverageProfit";
import CompanyList from "./page/CompanyList";

function App() {
    return (
        <div className="App">
            <Navbar></Navbar>
            <Routes>
                <Route path="/" element={<CompanyVisa/>} />
                <Route path="/profit" element={<CompanyAverageProfit/>} />
                <Route path="/company" element={<CompanyList/>} />
            </Routes>
        </div>
    );
}

export default App;
