import { AuthService } from './../../../shared/services/auth.service';
import { Component, OnInit } from '@angular/core';
import {
  FormBuilder,
  FormControl,
  FormGroup,
  Validators,
} from '@angular/forms';

@Component({
  selector: 'app-auth-form',
  templateUrl: './auth-form.component.html',
  styleUrls: ['./auth-form.component.css'],
})
export class AuthFormComponent implements OnInit {
  meuForm: FormGroup = new FormGroup({
    email: new FormControl(),
    senha: new FormControl(),
  });

  constructor(private fb: FormBuilder,
              private authService: AuthService) {}

  ngOnInit(): void {
    this.createForm();
  }
    onSubmit(){
    this.authService.autenticar(this.meuForm.value.email, this.meuForm.value.senha)
      .subscribe({
        next: (response)=> {
          console.log(response)
          if(response ==true){
            localStorage.setItem('autenticado', 'true');
          }
        }
      })
  }


  private createForm() {
    this.meuForm = this.fb.group({
      email: [
        '',
        [Validators.required, Validators.minLength(5), Validators.email],
      ],
      senha: ['', [Validators.required]],
    });
  }
}
