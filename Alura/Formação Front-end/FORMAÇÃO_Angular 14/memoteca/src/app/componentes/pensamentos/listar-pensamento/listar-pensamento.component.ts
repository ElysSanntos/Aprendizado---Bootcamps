import { Component, OnInit } from '@angular/core';
import { Pensamento } from '../pensamento/pensamento';
import { PensamentoService } from '../pensamento.service';
import { Observable } from 'rxjs';

@Component({
  selector: 'app-listar-pensamento',
  templateUrl: './listar-pensamento.component.html',
  styleUrls: ['./listar-pensamento.component.scss']
})
export class ListarPensamentoComponent implements OnInit {

  listaPensamentos: Pensamento[] = [];

  //Para utilizar o service, fazemos o inject no construtor
  constructor(private service: PensamentoService) { }

  ngOnInit(): void {
    //Toda a lógica que desejo que seja carregada quando a aplicação for iniciada, será adicionada no método ngOnInit

    this.service.listar().subscribe((listaPensamentos) =>{
      this.listaPensamentos = listaPensamentos

    })

    }
  }


