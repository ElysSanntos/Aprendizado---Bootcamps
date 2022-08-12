import React from "react";
import './Card/card.css';
export default function Card(props){
     const estilo = {
       backgroundColor: "#5F9EA0",
       borderColor: "#5F9EA0",
     };

    return(

        <div className="Card">
            <div className="card" style={estilo}></div>
            <div className="titulo"> {props.titulo}</div>
            <div className="conteudo">{props.children}</div>
        </div>
    );
}