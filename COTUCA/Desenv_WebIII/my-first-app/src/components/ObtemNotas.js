import React from "react";

export default function ObtemNotas(props){
  // props.quandoClicar vai informar alguma coisa para o componente pai

  return(
    <div style={{backgroundColor: '#FAF0E6', padding:'5px'}}>
        <h2>ObtemNotas (filho) </h2>
        <button onClick ={
            e =>{
                props.quandoClicar('Maria',5);
            }
        }>
Obter Nota
        </button>

    </div>
  );
}