import { HttpClient } from '@angular/common/http';
import { Component, Input, OnInit } from '@angular/core';
import { FormGroup, Validators, FormBuilder } from '@angular/forms';
import { Router } from '@angular/router';
import { DssOptionInterface } from '@dss/components';
import { urlConfig } from 'src/app/config/url.config';

import { IDataSource } from '../regras-parametrizacao/iDataSource';
import { IDataSourceAge } from '../regras-parametrizacao/IDataSourceAge';
import { MappingIds } from '../regras-parametrizacao/mapping-ids';
import { CustomValidators, segmentValidator } from '../validators/custom-validators';
import { isError } from 'util';

@Component({
    selector: "app-formulario",
    templateUrl: "./formulario.component.html",
    styleUrls: ["./formulario.component.scss"],
})

export class FormularioComponent implements OnInit {

    channels: MappingIds;
    modalities: MappingIds;

    private addRules = urlConfig.saveRulesOrchestrator;



    @Input() formParameterRules: FormGroup;
    @Input() editingRule: IDataSource | null;

    @Input() formParameterRulesAge: FormGroup;
    @Input() editingRuleAge: IDataSource | null;

    public input = "";

    public optionChannel: Array<DssOptionInterface> = [
        { value: "C2", viewValue: "C2" },
        { value: "C3", viewValue: "C3" },
        { value: "FVE", viewValue: "FVE" },
        { value: "IB", viewValue: "IB" },
        { value: "Mobile", viewValue: "Mobile" },
        { value: "PNG", viewValue: "PNG" },
        { value: "WPC", viewValue: "WPC" },
    ];
    public optionModality: Array<DssOptionInterface> = [
        { value: "AUTO", viewValue: "AUTO" },
        { value: "ELETRO", viewValue: "ELETRO" },
        { value: "IMÓVEL", viewValue: "IMÓVEL" },
        { value: "MOTO", viewValue: "MOTO" },
        { value: "PESADO", viewValue: "PESADO" },
        { value: "SERVIÇOS", viewValue: "SERVIÇOS" },
    ];
    public optionCluster: Array<DssOptionInterface> = [
        { value: "Alto", viewValue: "Alto" },
        { value: "Médio", viewValue: "Médio" },
        { value: "Baixo", viewValue: "Baixo" },
    ];

    public optionRisk: Array<DssOptionInterface> = [
        { value: "1", viewValue: "1" },
        { value: "2", viewValue: "2" },
        { value: "3", viewValue: "3" },
    ];

    public optionFOPA: Array<DssOptionInterface> = [
        { value: "T", viewValue: "T" },
        { value: "N", viewValue: "N" },
        { value: "S", viewValue: "S" },
    ];

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


    public ngOnInit(): void {
        if (this.editingRule) {

            //Obter IDs correspondentes ao nome
            const channelIdAsId = this.getChannelIdFromName(
                this.editingRule.channelName
            );
            const modalityAsId = this.getModalityIdFromCode(
                this.editingRule.modalityCode
            );

            //Preencher os campos do forms com os ids
            this.formParameterRules.patchValue({

                primarySegmentCode: this.editingRule.primarySegmentCode,
                fopa: this.editingRule.fopa,
                clusterRisk: this.editingRule.clusterRisk,
                riskGroup: this.editingRule.riskGroup,
                effectiveDate: this.editingRule.effectiveDate,
                endDateValidity: this.editingRule.endDateValidity,
                // Preencher os campos com IDs obtidos
                channelName: channelIdAsId,
                modalityCode: modalityAsId,

            });
        }
    }
    getChannelIdFromName(channelName: string) {
        throw new Error('Method not implemented.');
    }
    getModalityIdFromCode(modalityCode: string) {
        throw new Error('Method not implemented.');
    }

    public onSubmit(): void {
        console.log("onSubmit(), called");

        const formData: IDataSource = this.formParameterRules.value;
        const formDataAge: IDataSourceAge = this.formParameterRulesAge.value;

        console.log("onSubmit(), called");

        console.log(this.formParameterRules.value);


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
    }

    isError(controlName: string): boolean {
        const input = this.formParameterRules.get(controlName);
        return input !== null && input.invalid && input.dirty && input.touched;
      }

      isSuccess(controlName: string): boolean {
        const input = this.formParameterRules.get(controlName);
        return input !== null && input.valid && input.dirty && input.touched;
      }
    public getChannelIdFromName(channelName: string): string {
        return this.channels[channelName] || "";
    }
    public getModalityIdFromCode(modalityId: string): string {
        return this.channels[modalityId] || "";
    }
    get editingTitle(): string {
        return this.editingTitle ? "Editar Regra" : "Nova Regra";
    }
    get editingSubtitle(): string {
        return this.editingSubtitle
            ? "Edite os campos abaixo para atualizar a regra existente."
            : "Preencha os campos  abaixo para criar uma nova regra.";
    }
}

function isSuccess(controlName: any, string: any) {
    throw new Error('Function not implemented.');
}

function getChannelIdFromName(channelName: any, string: any) {
    throw new Error('Function not implemented.');
}

function getModalityIdFromCode(modalityId: any, string: any) {
    throw new Error('Function not implemented.');
}

function editingTitle() {
    throw new Error('Function not implemented.');
}

function editingSubtitle() {
    throw new Error('Function not implemented.');
}

