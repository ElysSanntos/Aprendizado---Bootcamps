import { Component, Input, OnInit, Output, EventEmitter, OnChanges } from '@angular/core';

@Component({
  selector: 'app-detalhes-pokemons',
  templateUrl: './detalhes-pokemons.component.html',
  styleUrls: ['./detalhes-pokemons.component.css']
})
export class DetalhesPokemonsComponent implements OnInit, OnChanges {

  @Input()
  pokemonSelecionadoDetalhe : any = null;

  @Output()
  emitirIdPokemon = new EventEmitter();

  constructor() { }

  ngOnChanges(): void {
    console.log(this.pokemonSelecionadoDetalhe);

    let id = this.extrairIdUrl(this.pokemonSelecionadoDetalhe.url);
    this.emitirIdPokemon.emit(id);
  }


  ngOnInit(): void {
    //console.log(this.pokemonSelecionadoDetalhe)
  }

  /**
   * 
   * @param url https://pokeapi.co/api/v2/pokemon/300/
   * https:
   * '',
   * pokeapi.co
   * 
   */
  extrairIdUrl(url : any){
    let fields = url.split('/');
    console.log(fields)

    let id = fields[ fields.length - 2 ];
    console.log("ID : " + id)
    return id;
  }

}
