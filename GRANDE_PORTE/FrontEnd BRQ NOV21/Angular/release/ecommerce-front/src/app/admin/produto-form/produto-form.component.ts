import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormControl, FormGroup } from '@angular/forms';
import { ActivatedRoute, Router } from '@angular/router';
import { timeout } from 'rxjs';
import { CategoriaService } from 'src/app/shared/services/categoria.service';
import { ProdutoService } from 'src/app/shared/services/produto.service';

@Component({
  selector: 'app-produto-form',
  templateUrl: './produto-form.component.html',
  styleUrls: ['./produto-form.component.css']
})
export class ProdutoFormComponent implements OnInit {

  categoriasSelect : any = [];

  meuForm : FormGroup = new FormGroup({
    nome : new FormControl(),
    preco : new FormControl(),
    descricao : new FormControl(),
    categorias : new FormControl(),
    imagens : new FormControl(),
  });

  constructor(
    private router : Router,
    private formBuilder : FormBuilder,
    private activatedRoute : ActivatedRoute,
    private categoriaService: CategoriaService,
    private produtoService : ProdutoService
  ) { }

  ngOnInit(): void {
    this.getAllCategorias();
    
    setTimeout(() => {
			this.meuForm.get('categorias')?.setValue(this.meuForm.get('categorias')?.value);
		}, 1000);
  }

  onSubmit(){
    //console.log(this.meuForm.value)
    //console.log(this.categoriasSelect)

    let index = this.categoriasSelect
      .findIndex( (x:any) => x.idCategoria == this.meuForm.value.categorias );
    
    //console.log(index)
    //console.log([ this.categoriasSelect[index] ])
    this.meuForm.value.categorias = [ this.categoriasSelect[index] ];
    this.meuForm.value.imagens = [];
    //console.log(this.meuForm.value)

    this.produtoService.save(this.meuForm.value)
      .subscribe(
        {
          next : (produto) => {
            console.log(produto)
          }
        }
      );
  }

  private getAllCategorias(){
    this.categoriaService.getAll()
      .subscribe(
        {
          next : (categorias) => {
            this.categoriasSelect = categorias;
          }
        }
      );
  }

}
