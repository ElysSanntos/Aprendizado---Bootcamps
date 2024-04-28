import { Component, OnInit } from '@angular/core';
import { Pensamento } from '../pensamento/pensamento';
import { PensamentoService } from '../pensamento.service';
import {  Router } from '@angular/router';

@Component({
  selector: 'app-criar-pensamento',
  templateUrl: './criar-pensamento.component.html',
  styleUrls: ['./criar-pensamento.component.scss']
})
export class CriarPensamentoComponent implements OnInit {
  pensamento: Pensamento = {

    conteudo: '',
    autoria: '',
    modelo: 'modelo1'
  }

  constructor(

    //Injetar o serviço no construtor para poder usar o metodo criar()
    private service: PensamentoService,
    //A injeção do Router, vai me permitir que ao clicar no botão salvar, o user seja direcionado(navegue) para a página informada
    private router: Router

    ) { }

  ngOnInit(): void {
  }

  criarPensamento() {
    this.service.criar(this.pensamento).subscribe(() => {
      this.router.navigate(['/listarPensamento'])
    })
  }

  cancelarPensamento() {
    this.router.navigate(['/listarPensamento'])
  }

}
