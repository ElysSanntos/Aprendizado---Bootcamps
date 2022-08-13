import React from "react";
import Exemplo01 from './components/Exemplo01';
import NumeroAleatorio from './components/NumeroAleatorio';
import Card from './components/Cards/Card';
import './App.css';

export default function App(props) {
 return (
   <div className="app">
     <h1>Exemplos com React*****</h1>

     <div className="cards">
       <Card titulo="Exemplo01">
         <Exemplo01 PrimeiroNome="Elys" SegundoNome="Santos" idade="45" nota="9,0" situacao="Aprovado"/>
       </Card>

       <Card titulo="NumeroAleatorio">
         <NumeroAleatorio min={20} max={40} />
       </Card>
     </div>
   </div>
 );
}


 