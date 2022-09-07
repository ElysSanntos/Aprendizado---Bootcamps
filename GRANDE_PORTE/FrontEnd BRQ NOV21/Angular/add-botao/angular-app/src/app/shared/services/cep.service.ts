import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root',
})
export class CepService {
  [x: string]: any;

  constructor(private http: HttpClient) {
    //metodo que vai consultar o cep
  }
  consultar(cep: number) {
    return this.http.get(`https://viacep.com.br/ws/${cep}/json/`);
  }
}
