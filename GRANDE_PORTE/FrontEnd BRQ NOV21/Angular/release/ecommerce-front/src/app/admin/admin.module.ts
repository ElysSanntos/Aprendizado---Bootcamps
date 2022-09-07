import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { AdminRoutingModule } from './admin-routing.module';
import { ProdutoFormComponent } from './produto-form/produto-form.component';
import { SharedModule } from '../shared/shared.module';


@NgModule({
  declarations: [
    ProdutoFormComponent
  ],
  imports: [
    CommonModule,
    AdminRoutingModule,
    SharedModule
  ]
})
export class AdminModule { }
