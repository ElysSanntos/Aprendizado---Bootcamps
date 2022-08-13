import React from "react";

export default function NumeroAleatorio(props){
// O componente vai receber dois números (máximo e mínimo) referentes a um intervalo e
// deverá retornar um número aleatório entre esses dois números.
    const {max, min} = props;
        let num = Math.floor(Math.random() * (max,min)) + min;
        console.log("num= "+ num);
    return(
        
        <div>
            <h1>Numero aleatório: {num} </h1>
        </div>
    );
}