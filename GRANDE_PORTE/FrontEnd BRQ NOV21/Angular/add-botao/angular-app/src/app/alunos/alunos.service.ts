import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';


@Injectable({
  providedIn: 'root',
})
export class AlunosService {
  
  constructor(private http: HttpClient) {}
  getAll() {
    // observa o endereço/api
    return this.http.get('http://cursos.grandeporte.com.br:8080/usuarios');
  }

  getOne(id: number) {
    return this.http.get(
      'http://cursos.grandeporte.com.br:8080/usuarios/${id}'
    );
  }
  salvar(body: any) {
    return this.http.get(
      'http://cursos.grandeporte.com.br:8080/usuarios',
      body
    );
  }
  update(id: number, body: any) {
    return this.http.patch(
      `http://cursos.grandeporte.com.br:8080/usuarios/${id}`,
      body
    );
  }
  deletar(id: number) {
    
    return this.http.delete(
      `http://cursos.grandeporte.com.br:8080/usuarios/${id}`
    );
  }
}
