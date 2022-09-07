import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class ProdutoService {

  urlApi : string = `https://api.fabrizioborelli.com.br/ecommerce`

  constructor(private http:HttpClient) { }

  save(body:any){
    return this.http.post(`${this.urlApi}/produtos`, body );
  }

  getAll(){
    return this.http.get(`${this.urlApi}/produtos` );
  }
}
