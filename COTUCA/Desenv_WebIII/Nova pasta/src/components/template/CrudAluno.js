import React, { Component } from "react";
import "./CrudAluno.css";
import Main from "../template/Main";


const title = "Cadastro de Alunos";
const Alunos = [
  { id: 1, ra: 11111, nome: "André", codCurso: 19 },
  { id: 2, ra: 22222, nome: "Amanda", codCurso: 28 },
  { id: 3, ra: 33333, nome: "Pedro", codCurso: 39 },
  { id: 4, ra: 44444, nome: "Alice", codCurso: 59 },
]; 

export default class CrudAluno extends Component {
  renderTable() {
    return (
      <div className="listagem">
        <table className="listaAlunos" id="tblListaAlunos">
          {" "}
          <thead>
            <tr className="cabecTabela">
              {" "}
              <th className="tabTituloRa">Ra</th>{" "}
              <th className="tabTituloNome">Nome</th>{" "}
              <th className="tabTituloCurso">Curso</th>{" "}
            </tr>
          </thead>
          <tbody>
            <tr>
              <td>{Alunos[0].ra}</td>
              <td>{Alunos[0].nome}</td>
              <td>{Alunos[0].codCurso} </td>
            </tr>
          </tbody>
        </table>
      </div>
    );
  }
  render() {
    return <Main title={title}>{this.renderTable()}</Main>;
  }
}
