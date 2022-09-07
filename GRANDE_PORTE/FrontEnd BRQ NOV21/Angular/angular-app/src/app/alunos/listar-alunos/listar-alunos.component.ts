import { Component, OnInit } from '@angular/core';
import { AlunosService } from '../alunos.service';

@Component({
  selector: 'app-listar-alunos',
  templateUrl: './listar-alunos.component.html',
  styleUrls: ['./listar-alunos.component.css']
})
export class ListarAlunosComponent implements OnInit {

  alunos : any = [];

  constructor(private alunoService: AlunosService) { }

  ngOnInit(): void {
    this.getAll();
  }

  private getAll(){
    this.alunoService.getAll()
      .subscribe(
        {
          next: (dados) => { this.alunos = dados; },
          error: (e) => { alert('Erro ao carregar dados da API') }
        }
      );
  }

  onApagarClick(aluno : any){
    this.alunoService.delete(aluno.id)
      .subscribe(
        {
          next: () => { 
            //achar índice para remover do vetor
            let index = this.alunos.findIndex( (x : any)  => x.id == aluno.id );
            this.alunos.splice(index,1);
          },
          error: (e) => { alert('Erro ao deletar dados da API') }
        }
      );
  }

}
