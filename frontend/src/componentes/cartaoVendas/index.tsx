import axios from "axios";
import { useEffect, useState } from "react";
import DatePicker from "react-datepicker";
import "react-datepicker/dist/react-datepicker.css";
import { Vendas } from "../../models/vendas";
import { BASE_URL } from "../../utils/request";
import BotaoNotificacao from '../botaoNotificacao';
import './styles.css';

function CartaoVendas() {
  const min=new Date(new Date().setDate(new Date().getDate() - 365));
  const max=new Date();
  const [minData,setMinData] =useState(min);
  const [maxData,setMaxData] =useState(max);
  const [vendas,setVendas]=useState<Vendas[]>([]);
  useEffect(()=>{
    const dMin=minData.toISOString().slice(0,10);
    const dMax=maxData.toISOString().slice(0,10);
    axios.get(`${BASE_URL}/vendas?minDate=${dMin}&maxDate=${dMax}`)
    .then(response=>{
      setVendas(response.data.content);
    });
  },[minData,maxData]);
  return (
    <div className="dsmeta-card">
      <h2 className="dsmeta-sales-title">Vendas</h2>
      <div>
        <div className="dsmeta-form-control-container">
          <DatePicker
            selected={minData}
            onChange={(date: Date) => setMinData(date)}
            className="dsmeta-form-control"
            dateFormat="dd/MM/yyyy"
          />
        </div>
        <div className="dsmeta-form-control-container">
          <DatePicker
            selected={maxData}
            onChange={(date: Date) => setMaxData(date)}
            className="dsmeta-form-control"
            dateFormat="dd/MM/yyyy"
          />
        </div>
      </div>
      <div>
        <table className="dsmeta-sales-table">
          <thead>
            <tr>
              <th className="show992">ID</th>
              <th className="show576">Data</th>
              <th>Vendedor</th>
              <th className="show992">Visitas</th>
              <th className="show992">Vendas</th>
              <th>Total</th>
              <th>Notificar</th>
            </tr>
          </thead>
          <tbody>
            {
              vendas.map(venda=>{
                return (
                  <tr key={venda.id}>
                    <td className="show992">{venda.id}</td>
                    <td className="show576">{new Date(venda.date).toLocaleDateString()}</td>
                    <td>{venda.sellerName}</td>
                    <td className="show992">{venda.visited}</td>
                    <td className="show992">{venda.deals}</td>
                    <td>R$ {venda.amount.toFixed(2)}</td>
                    <td>
                      <div className="dsmeta-red-btn-container">
                        <BotaoNotificacao />
                      </div>
                    </td>
                </tr>
                )
              })
            }
          </tbody>
        </table>
      </div>
    </div>
  )
}

export default CartaoVendas;