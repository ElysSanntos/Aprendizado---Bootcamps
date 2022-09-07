import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { FormulariosRoutingModule } from './formularios-routing.module';
import { MeuFormComponent } from './meu-form/meu-form.component';
import { SharedModule } from '../shared/shared.module';


@NgModule({
  declarations: [
    MeuFormComponent
  ],
  imports: [
    CommonModule,
    FormulariosRoutingModule,
    SharedModule
  ]
})
export class FormulariosModule { }
