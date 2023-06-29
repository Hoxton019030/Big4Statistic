import axios from "axios"
import { useEffect, useState } from "react";
import "../node_modules/bootstrap/dist/css/bootstrap.css"

function App() {

  let url = "http://localhost:8080/company"

  const [firms, setFirms] = useState([]);
  useEffect(() => {
    loadUFirms();
  }, [])

  const loadUFirms = async () => {
    const result = await axios.get(url);
    console.log(result)
    setFirms(result.data)
  }



  return (

    <div className="App">
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
              <tr>
                <th scope="row" key={index}>{index + 1}</th>
                <td>{firm.firmName}</td>
                <td>{firm.count}</td>
              </tr>
            ))
          }
        </tbody>
      </table>
    </div>
  );
}

export default App;
