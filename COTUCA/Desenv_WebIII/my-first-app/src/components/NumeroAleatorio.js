import React from "react";

export default function NumeroAleatorio(props){

    const {max, min} = props;
        let num = Math.floor(Math.random() * (max,min)) + min;
        console.log("num= "+num);
    return(
        
        <div>
            <h1>Numero aleatório: {num} </h1>
        </div>
    );
}