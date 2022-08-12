import React from "react";

export default function Exemplo01(props){

    return (
      <div>
        <h1>Primeiro componente</h1>
        <p>Exemplo com component React</p>
        <p>Seja bem vinda {props.nome}</p>
        <p>Sua média final é {props.media}</p>
        <p>
          Situação: {props.situacao}
        </p>
      </div>
    );
}