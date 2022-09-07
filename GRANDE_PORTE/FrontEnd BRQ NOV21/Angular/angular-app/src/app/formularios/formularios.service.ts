import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { environment } from 'src/environments/environment';

@Injectable({
  providedIn: 'root',
})
export class FormulariosService {
  constructor(private http: HttpClient) {}

  salvar(body: any) {
    return this.http.post(`${environment.urlApiGp}/professores`, body);
  }
}
