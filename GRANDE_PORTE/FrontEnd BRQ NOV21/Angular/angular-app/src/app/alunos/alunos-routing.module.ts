import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { AlunosFormComponent } from './alunos-form/alunos-form.component';
import { ListarAlunosComponent } from './listar-alunos/listar-alunos.component';


const routes: Routes = [
  { path: '', component: ListarAlunosComponent },
  { path: 'new', component: AlunosFormComponent },
  { path: ':id', component: AlunosFormComponent },
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class AlunosRoutingModule { }
