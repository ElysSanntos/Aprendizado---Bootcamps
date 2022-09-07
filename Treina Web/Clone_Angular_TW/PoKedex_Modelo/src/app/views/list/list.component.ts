
import { Component, OnInit } from '@angular/core';
import { HttpClient } from '@angular/common/http'

import { PokeapiService } from './../../../../../Pokedex/src/app/services/pokeapi.service';
@Component({
  selector: "app-list",
  templateUrl: "./list.component.html",
  styleUrls: ["./list.component.less"],
})
export class ListComponent implements OnInit {
  //Armazenar o pkm passado pelo template via click
  selectedPkm = null;

  /*fazer um get de acordo com o valor passado no filtro
1 - pegar  o valor do input com o two-way data binding
2 - importar o ngModel no appModel(ou modulo do componente) */
  nameFilter = "";

  /*A pokemonList será transformada em um get que vai pegar a lista que está fixa no serviço, só que filtrada de acordo com o valor passado no Search*/

  get pokemonList() {
    return this.pokeapi.pokemonList.filter((pokemon) => {
      return (
        pokemon.name.toLowerCase().indexOf(this.nameFilter.toLowerCase()) !== -1
      );
    });
  }

  // //Lista fixa -- Migrada para pokeapi.service.ts -- assim temos a listagem disponivel para outros componentes.
  // pokemonList = [
  //   { name: "Bubalsaur", number: 1 },
  //   { name: "Charmander", number: 4 },
  //   { name: "Squirtle", number: 7 },
  //   { name: "Pikachu", number: 25 },
  // ];
  //Retorna a imagem do pkm
  get pkmSprite() {
    const number = ("000" + this.selectedPkm.number).slice(-3);
    return `//serebii.net/sunmoon/pokemon/${number}.png`;
  }
  constructor(private http: HttpClient, private pokeapi: PokeapiService) {}

  /* ngOnInit é executado sempre que um componente é iniciado */
  ngOnInit() {
    this.pokeapi.listAll();
  }

  //função para selecionar o pokemon clicado no template e exibir no body
  selectPokemon(pkm) {
    this.selectedPkm = pkm;
  }
}
