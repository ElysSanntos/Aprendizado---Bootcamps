import { Component, OnInit } from '@angular/core';
import { FormControl, FormGroup } from '@angular/forms';
import { UsuarioService } from 'src/app/shared/services/usuario.service';

@Component({
  selector: 'app-novo-usuario',
  templateUrl: './novo-usuario.component.html',
  styleUrls: ['./novo-usuario.component.css']
})
export class NovoUsuarioComponent implements OnInit {

  meuFormuser: FormGroup = new FormGroup({
    nome: new FormControl(),
    email: new FormControl(),
    nascimento: new FormControl(),
    senha: new FormControl(),
    telefone:  new FormControl(),
    confirmarSenha : new FormControl(),
    celular:  new FormControl(),
    cpf:  new FormControl(),
    endereco : new FormGroup(
      {
        cep: new FormControl(),
        logradouro: new FormControl(),
        numero: new FormControl(),
        complemento: new FormControl(),
        cidade: new FormControl(),
        bairro: new FormControl(),
        estado: new FormControl()
      }
    ),

  });

  constructor(private usuarioService: UsuarioService) { }

  ngOnInit(): void {

    let contador = localStorage.getItem("contador");

    let jsonDoGuilherme = {
      nome: "Guilherme",
      sobrenome: "Pereira de Carvalho"
    }

    let jsonStr = JSON.stringify(jsonDoGuilherme);
    localStorage.setItem("json", jsonStr);

    let jsonValue = JSON.parse(jsonStr);
    console.log(jsonValue)
    
    if (contador == null){
      localStorage.setItem("contador", "1");
    }
    else{
      let tmp = parseInt(contador);
      tmp++;
      localStorage.setItem("contador", tmp.toString());

    }
  }

  onSubmit(){
    console.log(this.meuFormuser.value)

    this.usuarioService.novoUsuario(this.meuFormuser.value)
      .subscribe(
        {
          next: (dados) => {
            console.log(dados)
          }
        }
      );
  }

}
