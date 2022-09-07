import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { AlunosFormComponent } from './alunos-form/alunos-form.component';
import { ListarAlunosComponent } from './listar-alunos/listar-alunos.component';

const routes: Routes = [
  {path : 'alunos', component : ListarAlunosComponent},
  {path : 'alunos/new', component : AlunosFormComponent},
  {path : 'alunos/:id', component : AlunosFormComponent},
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class AlunosRoutingModule { }
