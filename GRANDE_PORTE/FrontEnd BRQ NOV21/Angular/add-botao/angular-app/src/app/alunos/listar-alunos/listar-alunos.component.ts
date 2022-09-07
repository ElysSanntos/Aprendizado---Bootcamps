import { AlunosService } from './../alunos.service';
import { Component, OnInit } from '@angular/core';


@Component({
  selector: 'app-listar-alunos',
  templateUrl: './listar-alunos.component.html',
  styleUrls: ['./listar-alunos.component.css'],
})
export class ListarAlunosComponent implements OnInit {

  alunos: any = [];

  constructor(private alunosService: AlunosService) {}

  ngOnInit(): void {
    this.retornarTodos();
  }

  onApagarClick(alunos: any) {
    console.log(alunos);

    this.alunosService.deletar(alunos.id).subscribe(() => {
    let index = this.alunos.findIndex((obj: any) => alunos.id == obj.id);
    this.alunos.splice(index, 1);
    alert(`Alunos ${alunos.id} deletado com sucesso`);
    });
  }

  retornarTodos() {
    this.alunosService.getAll().subscribe((dados: any) => {
      this.alunos = dados;
      console.log(dados);
    });
  }
}
