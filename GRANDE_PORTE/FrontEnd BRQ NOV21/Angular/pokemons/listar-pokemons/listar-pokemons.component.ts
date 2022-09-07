import { Component, OnInit } from '@angular/core';
import { PokemonsService } from '../pokemons.service';
@Component({
  selector: 'app-listar-pokemons',
  templateUrl: './listar-pokemons.component.html',
  styleUrls: ['./listar-pokemons.component.css'],
})
export class ListarPokemonsComponent implements OnInit {
  pokemons: any = null;
  pokemonSelecionadoPai: any = null;
  page: number = 1;
  itemsPerPage: number = 10;

  diaDeHoje = new Date();

  onSelecionarClick(dados: any) {
    this.pokemonSelecionadoPai = dados;
  }
  receberIdFilho(variavel: any) {
    alert('O ID do Filho é ' + variavel);
  }

  itemsPerPageSelect(items: string) {
    const itemsNumber = Number(items);
    this.itemsPerPage = itemsNumber;
    this.onPageChange(1);
  }

  onPageChange(newPage: number) {
    this.page = newPage;
    let offset = newPage * this.itemsPerPage - this.itemsPerPage;
    this.fetch(offset);
  }

  fetch(offset: number) {
    this.pokemonService.getAll(offset, this.itemsPerPage).subscribe((dados) => {
      this.pokemons = dados;
    });
  }
  constructor(private pokemonService: PokemonsService) {}

  ngOnInit(): void {
    this.fetch(0);
  }
}
