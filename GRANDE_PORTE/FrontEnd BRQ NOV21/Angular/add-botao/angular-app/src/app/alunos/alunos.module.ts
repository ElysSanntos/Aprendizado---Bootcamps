import { AlunoFormComponent } from './aluno-form/aluno-form.component';
import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { ListarAlunosComponent } from './listar-alunos/listar-alunos.component';
import { SharedModule } from '../shared/shared.module';
import { AlunosRoutingModule } from './alunos-routing.module';

@NgModule({
  declarations: [ListarAlunosComponent,AlunoFormComponent],
  imports: [CommonModule, AlunosRoutingModule, SharedModule],
  
})
export class AlunoModule {}
