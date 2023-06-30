import axios from "axios"
import {useEffect, useState} from "react";
import "../node_modules/bootstrap/dist/css/bootstrap.css"
import Navbar from "./Navbar";
import {Route, Routes} from "react-router-dom";
import CompanyVisa from "./page/CompanyVisa";
import CompanyAverageProfit from "./page/CompanyAverageProfit";

function App() {
    return (
        <div className="App">
            <Navbar></Navbar>
            <Routes>
                <Route path="/" element={<CompanyVisa/>} />
                <Route path="/profit" element={<CompanyAverageProfit/>} />
            </Routes>
        </div>
    );
}

export default App;
