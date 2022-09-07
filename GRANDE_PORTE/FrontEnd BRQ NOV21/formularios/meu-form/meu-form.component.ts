import { Component, OnInit } from '@angular/core';
import {
  FormBuilder,
  FormControl,
  FormGroup,
  Validators,
} from '@angular/forms';

@Component({
  selector: 'app-meu-form',
  templateUrl: './meu-form.component.html',
  styleUrls: ['./meu-form.component.css'],
})
export class MeuFormComponent implements OnInit {
  meuForm: FormGroup = new FormGroup({
    email: new FormControl(),
    password: new FormControl(),
    checkme: new FormControl(),
  });

  constructor(private fb: FormBuilder) {}

  ngOnInit(): void {
    this.meuForm = this.fb.group({
      email: ['', [Validators.required, Validators.email]],
      password: [
        '',
        [
          Validators.required,
          Validators.minLength(8),
          Validators.pattern(
            '^(?=.*?[A-Z])(?=.*?[a-z])(?=.*?[0-9])(?=.*?[#?!@$ %^&*-]).{8,}$'
          ),
        ],
      ],
      checkme: ['', []],
    });
    console.log(this.meuForm);
  }

  getControl(control: string) {
    return this.meuForm.get(control);
  }

  isValid(control: string) {
    return (
      this.getControl(control)?.valid == false &&
      this.getControl(control)?.touched
    );
  }
}
