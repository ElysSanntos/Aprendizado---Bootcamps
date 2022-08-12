import React from "react";
import Exemplo01 from './components/Exemplo01';
import NumeroAleatorio from './components/NumeroAleatorio';
import Card from './components/Cards/Card';
import './App.css';

export default function App() {
 return (
   <div>
     <Card titulo="Exemplo01">
       <Exemplo01 nome="Elys" idade="27" />
     </Card>

     <Card titulo="NumeroAleatorio">
       <NumeroAleatorio min={20} max={40} />
     </Card>
   </div>
 );
}


 