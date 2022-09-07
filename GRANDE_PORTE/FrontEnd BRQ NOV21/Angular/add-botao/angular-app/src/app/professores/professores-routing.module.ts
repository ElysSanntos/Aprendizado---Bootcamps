import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { ListarProfessoresComponent } from './listar-professores/listar-professores.component';
import { ProfessorFormComponent } from './professor-form/professor-form.component';

const routes: Routes = [
    { path : 'professores' , component: ListarProfessoresComponent},
    { path: 'professores/new' ,component: ProfessorFormComponent  },
    { path: 'professores/:id' ,component: ProfessorFormComponent  }
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class ProfessoresRoutingModule { }