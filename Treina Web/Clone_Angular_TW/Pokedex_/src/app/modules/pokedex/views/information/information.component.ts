import { Component, OnInit, OnDestroy } from '@angular/core';
import { ActivatedRoute } from '@angular/router';

import { takeWhile } from 'rxjs/operators';
import { PokeapiService } from '../../../../services/pokeapi.service';

@Component({
  selector: 'app-information',
  templateUrl: './information.component.html',
  styleUrls: ['./information.component.css']
})
export class InformationComponent implements OnInit, OnDestroy {
  isAlive = true;
  pokemonNumber: number;
  pokemon: any = {}; // armazena o pokemon selecionado

  constructor(
    private activatedRoute: ActivatedRoute, //Pega o numero do pokemon
    private pokeapi: PokeapiService
  ) { }

  ngOnInit() {
    this.activatedRoute.params
      .pipe(takeWhile(() => this.isAlive))
      .subscribe((params: any) => {
        this.pokemonNumber = parseInt(params['number'], 10);//Essa informação chega como string e precisamos de um number, o numero 10 significa que estamos utilizando a base 10
        this.getPokemon();
      })
  }

  ngOnDestroy() {
    this.isAlive = false;
  }


  getPokemon(){
    this.pokeapi.getPokemon(this.pokemonNumber)
      .pipe(takeWhile(() => this.isAlive))
      .subscribe(response => {
        this.pokemon = response;
      })
  }

}
