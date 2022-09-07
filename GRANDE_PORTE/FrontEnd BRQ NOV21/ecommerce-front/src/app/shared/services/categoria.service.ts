import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class CategoriaService {

  urlApi : string = `https://api.fabrizioborelli.com.br/ecommerce`

  constructor(private http:HttpClient) { }

  getAll(){
    return this.http.get(`${this.urlApi}/categorias`);
  }
}
