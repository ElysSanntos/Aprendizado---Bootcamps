import React from "react";
import Exemplo01 from './components/Exemplo01';
import NumeroAleatorio from './components/NumeroAleatorio';
import Card from './components/Cards/Card';
import './App.css';
import ExibeNotas from "./components/ExibeNotas";

export default function App(props) {
 return (
   <div className="app">
     <h1>Exemplos com React</h1>

     <div className="card">
       <Card titulo="Titulo: Exemplo 1">
         <Exemplo01 nome="ElysSanntos" idade="45" />
       </Card>
     </div>
     <div className="card">
       <Card titulo="Titulo: Numero Aleatorio">
         <NumeroAleatorio min={20} max={40} />
       </Card>
     </div>

     <div className ="card">
       <Card titulo ="Titulo: Comunicação Direta">
         <ExibeNotas />
       </Card>
     </div>
   </div>
 );
}


 