import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';

import { ListComponent } from './views/list/list.component';
import { InformationComponent } from './views/information/information.component';
import { InformationGuard } from './guards/information.guard';

const routes: Routes = [
  {
    path: '',// o caminho esta vazio, pois já estamos no modulo
    component: ListComponent
  },
  {
    path: ':number', //variavel para pegar o numero da url
    component: InformationComponent,
    canActivate: [InformationGuard]
  }
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class PokedexRoutingModule { }
