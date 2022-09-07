import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { AlunoFormComponent } from './aluno-form/aluno-form.component';
import { ListarAlunosComponent } from './listar-alunos/listar-alunos.component';


const routes: Routes = [
  { path: 'alunos', component: ListarAlunosComponent },
  { path: 'alunos/new', component: AlunoFormComponent },
  { path: 'alunos/:id', component: AlunoFormComponent },
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule],
})
export class AlunosRoutingModule {}
