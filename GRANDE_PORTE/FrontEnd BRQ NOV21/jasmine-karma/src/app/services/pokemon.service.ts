import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { PokemonPaginatorModel } from '../shared/models/pokemons/pokemon-paginator.model';

@Injectable({
  providedIn: 'root'
})
export class PokemonService {
  urlApi = `https://pokeapi.co/api/v2/pokemon`;

  constructor(private http: HttpClient) { 

  }

  getAll(){
    //return this.http.get<PokemonPaginatorModel>(this.urlApi);
    return this.http.get(this.urlApi);
  }
}
