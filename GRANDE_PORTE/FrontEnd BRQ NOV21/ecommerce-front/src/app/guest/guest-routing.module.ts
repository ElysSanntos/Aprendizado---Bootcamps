import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { NovoUsuarioComponent } from './novo-usuario/novo-usuario.component';
import { ProdutosComponent } from './produtos/produtos.component';

const routes: Routes = [
  {path: 'guest/novo-usuario', component: NovoUsuarioComponent},
  {path: 'guest/produtos', component: ProdutosComponent}
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class GuestRoutingModule { }
