import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { AlunosRoutingModule } from './alunos-routing.module';
import { SharedModule } from '../shared/shared.module';
import { ListarAlunosComponent } from './listar-alunos/listar-alunos.component';
import { AlunosFormComponent } from './alunos-form/alunos-form.component';


@NgModule({
  declarations: [
    ListarAlunosComponent,
    AlunosFormComponent
  ],
  imports: [
    CommonModule,
    AlunosRoutingModule,
    SharedModule
  ]
})
export class AlunosModule { }
