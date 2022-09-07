import { Component } from '@angular/core';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  title = 'curso de angular';
  nome = 'Fabrizio';
  cor = 'vermelho';
  valorDigitado = '';
  cpfDigitado : string = '';
  msgCpf : string = '';

  public mask: any = {
    mask: '+{7} (000) 000-00-00',
    lazy: false
  };

  botaoClick() {
    alert('Uma mensagem');
    console.log(this.testaCPF('27999620098'))
    this.cor = (this.cor == 'azul' ? 'vermelho' : 'azul');
  }

  // inputKeyUp(input:any){

  //   //console.log(value)
  //   console.log(input.target.value);
  //   this.valorDigitado = input.target.value;
  //   //console.log(this.valorDigitado)
  // }

  getValor() {
    return 'BRQ';
  }

  onCpfBlur(){
    console.log(this.cpfDigitado, this.cpfDigitado == '')
    
    let cpfValido = this.testaCPF( this.cpfDigitado );

    if (cpfValido){
      this.msgCpf = 'CPF é Válido';
    }
    else {
      this.msgCpf = 'CPF não é válido';
    }
    



    // if (this.cpfDigitado == ''){
    //   this.msgCpf = ''
    // }

    //this.msgCpf = (cpfValido ? 'CPF é Válido': 'CPF não é válido');

  }

  testaCPF(strCPF: string) {
    var Soma;
    var Resto;
    Soma = 0;
    if (strCPF == "00000000000") return false;

    for (let i = 1; i <= 9; i++) Soma = Soma + parseInt(strCPF.substring(i - 1, i)) * (11 - i);
    Resto = (Soma * 10) % 11;

    if ((Resto == 10) || (Resto == 11)) Resto = 0;
    if (Resto != parseInt(strCPF.substring(9, 10))) return false;

    Soma = 0;
    for (let i = 1; i <= 10; i++) Soma = Soma + parseInt(strCPF.substring(i - 1, i)) * (12 - i);
    Resto = (Soma * 10) % 11;

    if ((Resto == 10) || (Resto == 11)) Resto = 0;
    if (Resto != parseInt(strCPF.substring(10, 11))) return false;
    return true;
  }
}
