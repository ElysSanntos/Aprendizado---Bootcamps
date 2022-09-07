import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { ListarPokemonsComponent } from './listar-pokemons/listar-pokemons.component';
import { DetalhesPokemonsComponent } from './detalhes-pokemons/detalhes-pokemons.component';
import { HttpClientModule } from '@angular/common/http';
import { SharedModule } from '../shared/shared.module';
import { PokemonsRoutingModule } from './pokemons-routing.module';



@NgModule({
  declarations: [
    ListarPokemonsComponent,
    DetalhesPokemonsComponent
  ],
  imports: [
    CommonModule,
    PokemonsRoutingModule,
    //HttpClientModule
    SharedModule
  ],
  exports:[
    ListarPokemonsComponent
  ]
})
export class PokemonsModule { }
