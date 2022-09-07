import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class UsuarioService {

  urlApi : string = `https://api.fabrizioborelli.com.br/ecommerce`

  constructor(private http:HttpClient) { 

  }

  novoUsuario(body:any){
    return this.http.post(`${this.urlApi}/usuarios`, body);
  }
}
