import { Component, Input, OnInit } from '@angular/core';
import { FormGroup, FormBuilder, Validators } from '@angular/forms';
import { HttpClient } from '@angular/common/http';
import { Router } from '@angular/router';
import { DssOptionInterface } from '@dss/components';
import { urlConfig } from 'src/app/config/url.config';
import { CustomValidators, segmentValidator } from '../validators/custom-validators';

@Component({
  selector: 'app-formulario',
  templateUrl: './formulario.component.html',
  styleUrls: ['./formulario.component.scss'],
})
export class FormularioComponent implements OnInit {
  // ... (existing code)

  constructor(
    private http: HttpClient,
    private router: Router,
    private formBuilder: FormBuilder
  ) {
    this.formParameterRules = this.formBuilder.group({
      channelName: [null, Validators.required],
      modalityCode: [null, Validators.required],
      primarySegmentCode: [
        null,
        [
          Validators.required,
          Validators.maxLength(6),
          Validators.minLength(6),
          segmentValidator(),
        ],
      ],
      secondarySegmentCode: [
        null,
        [
          Validators.required,
          Validators.maxLength(6),
          Validators.minLength(6),
          CustomValidators.SecondaryCodeValidators,
        ],
      ],
      fopa: [null, Validators.required],
      clusterRisk: [null, Validators.required],
      riskGroup: [null, Validators.required],
      effectiveDate: [null, Validators.required],
      endDateValidity: [null, Validators.required],
    });
  }

  ngOnInit(): void {
    // ... (existing code)
  }

  onSubmit(): void {
    console.log('onSubmit(), called');

    const formData: IDataSource = this.formParameterRules.value;
    // ... (existing code)

    if (this.formParameterRules.valid) {
      console.log('Form is valid');
      this.http.post<ResponseType>(this.addRules, formData).subscribe(
        (response) => {
          console.log('Regra adicionada com Sucesso: ', response);
          this.formParameterRules.reset();
          this.router.navigate(['/yzju-regras-parametrizacao']);
        },
        (err) => {
          console.log('Erro ao adicionar a regra', err);
        }
      );
    } else {
      console.log('Form is invalid');
    }
  }

  isError(controlName: string): boolean {
    const input = this.formParameterRules.get(controlName);
    return input !== null && input.invalid && input.dirty && input.touched;
  }

  isSuccess(controlName: string): boolean {
    const input = this.formParameterRules.get(controlName);
    return input !== null && input.valid && input.dirty && input.touched;
  }

  // ... (existing code)
}
