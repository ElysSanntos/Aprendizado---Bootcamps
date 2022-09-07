import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { MeuPrimeiroComponent } from './meu-primeiro/meu-primeiro.component';
//import { ListarPokemonsComponent } from './pokemons/listar-pokemons/listar-pokemons.component';
// import { ListarProfessoresComponent } from './professores/listar-professores/listar-professores.component';

const routes: Routes = [
  { path:'primeiro-componente', component: MeuPrimeiroComponent },
  //{ path : 'professores' , component: ListarProfessoresComponent},
//  { path: 'pokemons', component: ListarPokemonsComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
