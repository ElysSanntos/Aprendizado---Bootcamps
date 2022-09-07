import { Component, OnInit } from '@angular/core';
import { CategoriaModel } from 'src/app/shared/models/categoria.model';
import { ItemVendaModel } from 'src/app/shared/models/item-venda.model';
import { ProdutoModel } from 'src/app/shared/models/produto.model';
import { CategoriaService } from 'src/app/shared/services/categoria.service';
import { ProdutoService } from 'src/app/shared/services/produto.service';
import { StorageService } from 'src/app/shared/services/storage.service';

@Component({
  selector: 'app-produtos',
  templateUrl: './produtos.component.html',
  styleUrls: ['./produtos.component.css']
})
export class ProdutosComponent implements OnInit {

  itemVenda : ItemVendaModel[] = [];
  produtos : ProdutoModel[];
  all_produtos : ProdutoModel[];
  categorias : CategoriaModel[] = [];
  categoriaSelected : number = -1;

  constructor(
    private produtoService : ProdutoService,
    private storageService: StorageService,
    private categoriaService : CategoriaService
    ) { }

  ngOnInit(): void {
    this.getAllProdutos();
    this.getAllCategorias();
  }

  onQuantidadeChange(produto : ProdutoModel , event: any){
    console.log(event.target.value)

    let ivm : ItemVendaModel = new ItemVendaModel();

    ivm.produto = produto;
    ivm.quantidade = event.target.value;

    let index = this.itemVenda
      .findIndex( 
        (x:ItemVendaModel) => x.produto.idProduto == produto.idProduto 
      );
      
    if (index >=0 ){
      this.itemVenda[index].quantidade = event.target.value;
    }
    else {
      this.itemVenda.push(ivm);
    }

    console.log(this.itemVenda);
  }

  finalizarCompra(){
    this.storageService.setCarrinho(this.itemVenda);
  }

  

  onCategoriaChange(){
    //console.log(this.categoriaSelected)
    this.produtos = this.all_produtos;
    if (this.categoriaSelected >= 0)
      this.produtos = this.produtos.filter( (x) => this.hasCategoria(x.categorias, this.categoriaSelected ) >= 0  );
  }

  private hasCategoria(categorias : CategoriaModel[], categoria_sel_id : number){
    let index = categorias.findIndex( (y) => y.idCategoria == categoria_sel_id );
    //console.log(index)
    return index;
  }

  private getAllProdutos(){
    this.produtoService.getAll()
      .subscribe(
        {
          next : (produtos : any) => {
            this.produtos = produtos;
            this.all_produtos = produtos;
          }
        }
      );
  }

  private getAllCategorias(){
    this.categoriaService.getAll()
      .subscribe(
        {
          next : (categorias : any) => {this.categorias = categorias;}
        }
      );
  }


}
