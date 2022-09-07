import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { ActivatedRoute, Router } from '@angular/router';
import { CepService } from 'src/app/shared/services/cep.service';
import { AlunosService } from '../alunos.service';

@Component({
  selector: 'app-alunos-form',
  templateUrl: './alunos-form.component.html',
  styleUrls: ['./alunos-form.component.css']
})
export class AlunosFormComponent implements OnInit {

  id : number = 0;
  meuForm : FormGroup;

  constructor(
    private router : Router, 
    private activatedRoute : ActivatedRoute,
    private alunoService: AlunosService,
    private fb: FormBuilder,
    private cepService: CepService
    ) { }

  ngOnInit(): void {
    this.activatedRoute.params
      .subscribe({
        next : (params) => {
          this.edicaoOrCriacao(params);
        }
      });

      this.createForm();
  }

  public onSubmit(){
    //criação, pois o id é zero
    if (this.id == 0){
      this.alunoService.save(this.meuForm.value)
        .subscribe(
          {
            next : (dados) => {
              alert ("dados salvos com sucesso");
              this.router.navigate(['/alunos'])
            }
          }
        );
    }
    //caso contrário é alteração
    else {
      this.alunoService.update(this.id, this.meuForm.value)
        .subscribe(
          {
            next : (dados) => {
              alert ("dados alterados com sucesso");
              this.router.navigate(['/alunos'])
            }
          }
        );
    }
  }
  getControl(control : string){
    return this.meuForm.get(control);
  }

  isValid(control :string){
    return (this.getControl(control)?.valid == false && this.getControl(control)?.touched)
  }

  buscarCEP(){
    console.log(this.meuForm.value.cep)
    this.cepService.consultar(this.meuForm.value.cep)
      .subscribe(
        {
          next : (result : any) => {
            //this.meuForm.controls['logradouro'].setValue(result.logradouro);
            this.meuForm.patchValue({
              logradouro : result.logradouro,
              cidade : result.localidade,
              bairro : result.bairro,
              estado : result.uf
            });
          },
          error: (erro) => {
            alert("CEP Inválido");
            //this.meuForm.controls['logradouro'].reset();
            this.meuForm.patchValue({
              logradouro : null,
              cidade : null,
              bairro : null,
              estado : null
            });
          }
        }
         
        
      );
  }

  private edicaoOrCriacao(params : any){
    //sabemos que é edição
    if (params.id){
      this.id = params.id;

      // busco na API pelo ID e trago dos dados do Aluno
      this.alunoService.getOne(this.id)
        .subscribe({
          next : (dados) => { 
            // atualizo o formulário (patch value)
            this.meuForm.patchValue(dados)
          }
        });

    }
  }

  // criar os controles do formulário
  private createForm(){
    this.meuForm = this.fb.group({
      nome : [ null, [ Validators.required] ],
      email : [ null, [ Validators.required, Validators.email] ],
      senha: [ null, [ Validators.required] ],
      tipo_usuario: [ null, [ Validators.required] ],
      cep: [ null, [ Validators.required] ],
      logradouro: [ null, [ Validators.required] ],
      numero: [ null, [ Validators.required] ],
      complemento : [ null, [ ] ],
      cidade: [ null, [ Validators.required] ],
      bairro: [ null, [ Validators.required] ],
      estado: [ null, [ Validators.required] ],
    });
  }



}
