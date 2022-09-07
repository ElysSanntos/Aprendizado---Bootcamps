import { AuthModel } from './../models/auth.models';
import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root',
})
export class AuthService {
  urlApi = 'http://cursos.grandeporte.com.br:8080/usuarios/auth';

  constructor(private http: HttpClient) {}

  autenticar(email: string, senha: string) {
    let authModel: AuthModel = {
      email: email,
      senha: senha,
    };
    return this.http.post(this.urlApi, authModel);
  }
  isAutenticado(): boolean {
    let isAutenticado = localStorage.getItem('autenticado');

    return isAutenticado === 'true' ? true : false;
  }
}


