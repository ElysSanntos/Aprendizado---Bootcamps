import { Component, OnInit, Output,EventEmitter } from '@angular/core';



@Component({
  selector: 'app-nova-transferencia',
  templateUrl: './nova-transferencia.component.html',
  styleUrls: ['./nova-transferencia.component.scss'],
})
export class NovaTransferenciaComponent implements OnInit {

  @Output() aoTransferir = new EventEmitter<any>();

  valor: number = 0;
  destino: number = 0;

  constructor() {}

  ngOnInit(): void {}

  transferir() {
    console.log('Solicitada nova transferência');
    // console.log("Valor: ", this.valor);
    // console.log("Destino: ", this.destino);
    const valorEmitir = { valor: this.valor, destino: this.destino };
    this.aoTransferir.emit(valorEmitir);

    this.limparCampos();

  }
  limparCampos(){
    this.valor = 0;
    this.destino = 0;
  }

}
