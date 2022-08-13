import React, {useState} from "react";
import ObtemNotas from "./ObtemNotas";

export default function ExibeNotas(props){
    let situacao = ' - ';
    const[non, setNome] = useState('Sem valor definido');
    const[not, setNota] = useState('Sem valor definido');

    if(!isNaN(not)){
        situacao = not>=5 ? "Aprovada": "Reprovada";   
        
         console.log(situacao);
    }
    function Informacoes(nome, nota){
        console.log(nome,nota);
        setNome(nome);
        setNota(nota);

        return(

        <div style={{ backgroundColor: "#E0FFFF", padding: '5px'}}>
            <h2>Exibe notas (pai)   </h2>
            <ObtemNotas quandoClicar={Informacoes} />
            <p>Nome:{non} - {not}</p>
            <p>Situação: {situacao}</p>
           
        </div>
         );

       
       

    }


return(
        <div style={{backgroundColor: '#E0FFFF', padding: '5px'}}>
            <h2>Exibe notas (pai)</h2>
            <ObtemNotas quandoClicar={ Informacoes }/>
            <p>Situação: { situacao }</p>
        </div>
);
}