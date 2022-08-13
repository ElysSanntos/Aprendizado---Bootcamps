import React from "react";
import VerificaIdade from "./VerificaIdade";


export default function Exemplo01(props){

  let idadeIdeal = props.idade > 18 ? props.idade: 18;

    return (
      <div>
        <h1>Primeiro componente</h1>
        <p>Exemplo com component React</p>
        <p>Seja bem vinda {props.nome}</p>
        <p>Sua média final é <strong>{props.media}</strong></p>
        <p>Situação: <b>{props.situacao}</b></p>
        <VerificaIdade nome={props.nome}  idade={props.idade} />
      </div>
    );
}