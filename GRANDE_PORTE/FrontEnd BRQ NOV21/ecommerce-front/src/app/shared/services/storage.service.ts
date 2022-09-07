import { Injectable } from '@angular/core';
import { ItemVendaModel } from '../models/item-venda.model';
import { ProdutoModel } from '../models/produto.model';

@Injectable({
  providedIn: 'root'
})
export class StorageService {

  /**
   * Responsável por gerenciar o carrinho na aplicação
   * do ecommerce
   */
  constructor() { 

  }

  getCarrinho() : ItemVendaModel[]{
    let carrinho = localStorage.getItem('carrinho');

    if (carrinho != null){
      return JSON.parse(carrinho);
    }
    else {
      return [];
    }
  }

  setCarrinho(carrinho : ItemVendaModel[]){
    if (carrinho != null ){
      localStorage.setItem('carrinho', JSON.stringify(carrinho) )
    }
    else{
      localStorage.removeItem('carrinho');
    }
  }

  addItemCarrinho(produto : ProdutoModel, quantidade : number){
    let item = new ItemVendaModel();

    item.produto = produto;
    item.quantidade = quantidade;

    // pegar item do localStorage
    let carrinho = this.getCarrinho();

    // colocar novo item no final do Array
    carrinho.push(item);

    this.setCarrinho(carrinho);
  }
}
