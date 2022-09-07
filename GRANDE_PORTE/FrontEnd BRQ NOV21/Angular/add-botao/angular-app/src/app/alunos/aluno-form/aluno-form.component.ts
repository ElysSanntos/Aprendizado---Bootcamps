import { CepService } from './../../shared/services/cep.service';
import { AlunosService } from './../alunos.service';
import { Component, OnInit } from '@angular/core';
import {
  FormBuilder,
  FormControl,
  FormGroup,
  Validators,
} from '@angular/forms';

import { ActivatedRoute, Router } from '@angular/router';
@Component({
  selector: 'app-aluno-form',
  templateUrl: './aluno-form.component.html',
  styleUrls: ['./aluno-form.component.css'],
})
export class AlunoFormComponent implements OnInit {
  id: number = 0;
  //alunoForm: FormGroup;

  constructor(
    private activatedRoute: ActivatedRoute,
    private fb: FormBuilder,
    private alunoService: AlunosService,
    private router: Router,
    private cepService: CepService
  ) {}

  ngOnInit(): void {
    this.alunoForm = this.fb.group({
      id: ['', [Validators.required]],
      nomeAluno: ['', [Validators.required]],
      emailAluno: [
        '',
        [Validators.required, Validators.minLength(5), Validators.email],
      ],

      senhaAluno: ['', [Validators.required]],
      cepAluno: ['', [Validators.required]],
      logradouroAluno: ['', [Validators.required]],
      nroAluno: ['', [Validators.required]],
      complementoAluno: ['', [Validators.required]],
      cidadeAluno: ['', [Validators.required]],
      bairroAluno: ['', [Validators.required]],
      estadoAluno: ['', [Validators.required]],
    });
    console.log(this.alunoForm);

    this.activatedRoute.params.subscribe((parametros: any) => {
      console.log(parametros);

      // Edição
      if (parametros.id) {
        //atualizar o id a ser editado
        this.id = parametros.id;

        this.alunoService.getOne(parametros.id).subscribe((resposta: any) => {
          console.log(resposta);
          this.alunoForm.patchValue(resposta);
        });
      }
      // Criação
      else {
      }
    });
  }

  alunoForm: FormGroup = new FormGroup({
    id: new FormControl(),
    emailAluno: new FormControl(),
    nomeAluno: new FormControl(),
    senhaAluno: new FormControl(),
    cepAluno: new FormControl(),
    logradouroAluno: new FormControl(),
    nroAluno: new FormControl(),
    complementoAluno: new FormControl(),
    cidadeAluno: new FormControl(),
    bairroAluno: new FormControl(),
    estadoAluno: new FormControl(),
  });

  getControl(control: string) {
    return this.alunoForm.get(control);
  }

  isValid(control: string) {
    return (
      this.getControl(control)?.valid == false &&
      this.getControl(control)?.touched
    );
  }
  buscarCEP() {
  
    this.cepService.consultar(this.alunoForm.value.cep).subscribe({
      next: (result: any) => {
        this.alunoForm.patchValue({
          logradouro: result.logradouro,
          cidade: result.localidade,
          bairro: result.bairro,
          estado: result.estado,
        });
      },
      error: (erro: any) => {
        alert('CEP inválido');
        //this.alunoForm.controls['logradouro'].reset();
        this.alunoForm.patchValue({
          logradouro: null,
          cidade: null,
          bairro: null,
          estado: null,
        });
      },
    });
  }

  onSubmit() {
    // quando é edição
    if (this.id > 0) {
      this.alunoService
        .update(this.id, this.alunoForm.value)
        .subscribe((dados: any) => {
          console.log(dados);
          this.router.navigate(['/alunos']);
        });
    }
    // quando é criação
    else {
      this.alunoService.salvar(this.alunoForm.value).subscribe({
        next: (respota: any) => {
          this.router.navigate(['/alunos']);
        },
        error: (e: any) => {
          alert('Erro ao Salvar');
        },
        complete: () => {
          console.log('acabou');
        },
      });
    }
  }
}
