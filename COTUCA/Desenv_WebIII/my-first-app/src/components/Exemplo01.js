import React from "react";
import VerificaIdade from "./VerificaIdade"; //Chamando o componente filho aqui 
                                            //no componente pai


export default function Exemplo01(props){

  let idadeIdeal = props.idade > 18 ? props.idade: 18;

    return (
      <div>
        <h1>Primeiro componente!</h1>
            <p>
              Nome: <strong> {props.nome}</strong>
            </p>
            <p> Idade: {idadeIdeal}</p>
           
        <VerificaIdade nome={props.nome} idade={props.idade} />
      </div>
    );
}