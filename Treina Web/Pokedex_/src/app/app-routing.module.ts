import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';

const routes: Routes = [
  {
    path: "pokedex",
    loadChildren: "./modules/pokedex/pokedex.module#PokedexModule",
    //#PokedexModule --> indica o nome do classe que está sendo exportada
  },
  {
    path: "**", // se for acessado um caminho qualquer(**) será direcionado para a home
    redirectTo: "pokedex",
    pathMatch: "full", //verifica o caminho completo, não bateu com nada redireciona para pokedex
  },
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
