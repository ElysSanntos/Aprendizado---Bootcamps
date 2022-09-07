import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';


@Injectable({
  providedIn: 'root',
})
export class ProfessoresService {
  urlApi = `urlApi`;

  constructor(private http: HttpClient) {}

  getAll() {
    return this.http.get('urlApi');
  }

  deletar(id: number) {
    
    return this.http.delete(`urlApi/${id}`);
  }

  salvar(body: any) {
    return this.http.post(this.urlApi, body);
  }

  getOne(id: number) {
    return this.http.get(`urlApi${id}`);
  }

  update(id: number, body: any) {
    return this.http.patch(`urlApi${id}`, body);
  }
}
