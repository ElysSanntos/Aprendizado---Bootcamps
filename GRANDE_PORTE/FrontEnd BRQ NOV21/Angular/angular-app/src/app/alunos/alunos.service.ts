import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class AlunosService {

  apiUrl = "http://cursos.grandeporte.com.br:8080/usuarios";

  constructor(private http: HttpClient) { }

  getAll(){
    return this.http.get(this.apiUrl)
  }

  getOne(id : number){
    return this.http.get(`${this.apiUrl}/${id}`)
  }

  save(body : any){
    return this.http.post(this.apiUrl ,body)
  }

  update(id : number, body : any){
    return this.http.patch(`${this.apiUrl}/${id}`,body)
  }

  delete(id : number){
    return this.http.delete(`${this.apiUrl}/${id}`)
  }
}
