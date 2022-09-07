import { HttpClient} from '@angular/common/http';
import { Injectable } from '@angular/core';


/*Criar uma interface para tipar a resposta da requisição -- depois podemos usar o generics para tipar o objeto da requisição no metodo listAll()
Extrair o numero da Url - com a função getNumberFromUrl()
Ordenar os numeros da Url -- com a função sortPokemon() e filtrados <1000*/

interface PokeListResponse{
  //Vamos colocar os dados que foram impressos no console.log
  created: string,
  modified: string,
  name: string,
  pokemon: any[],
  resource_uri: string,
}

@Injectable({
  providedIn: 'root',
})
export class PokeapiService {
  /*
URL
1 - Fazer a injeção de dependencia do HttpClientModule
2 - Declarar o HttpClientModule no app-module (ou no modulo do seu componente)
*/
  private url = '//dev.treinaweb.com.br/pokeapi/';
  pokeList = [];
  pokemonList: any;

  constructor(private http: HttpClient) {}
  /*Fazer a requisição dos dados na API -- Deve ser chamado no ngOnInit do arquivo list component.ts
  ${this.url} = base da URL
  /pokedex/1 = end point do serviço
  .subscribe = acessa o resultado*/
  listAll() {
    this.http
      .get<PokeListResponse>(`${this.url}/pokedex/1`)
      .subscribe((response) => {
        response.pokemon.forEach((pokemon) => {
          pokemon.number = this.getNumberFromUrl(pokemon.resource_uri);
        })
        this.pokeList = this.sortPokemon(response.pokemon).filter(
          (pokemon: any) => pokemon.number < 1000
        );
      });
  }

  getNumberFromUrl(url: string) {
    return parseInt(url.replace(/.*\/(\d+)\/$/, '$1'));
  }

  sortPokemon(pokemonList: any){
    return pokemonList.sort((a: number, b: number) =>{
      return (a > b ? 1 : -1);
    })
  }

  // //Lista fixa
  // pokemonList = [
  //   { name: 'Bubalsaur', number: 1 },
  //   { name: 'Charmander', number: 4 },
  //   { name: 'Squirtle', number: 7 },
  //   { name: 'Pikachu', number: 25 },
  // ];
}
