<div class="container">
    <form [formGroup]="formParameterRules" (ngSubmit)="onSubmit()">
        <div class="grid-container">
            <div dssContainer shadow="lg" class="grid-item item1">
                <dss-form-field>
                    <dss-dropdown
                        [options]="optionChannel"
                        formControlName="channelName"
                    >
                        <span *dssOption="let option">{{
                            option.viewValue
                        }}</span>
                    </dss-dropdown>
                    <label dssLabel>Canal</label>
                </dss-form-field>
            </div>

            <div dssContainer shadow="lg" class="grid-item item2">
                <dss-form-field>
                    <dss-dropdown
                        [options]="optionModality"
                        formControlName="modalityCode"
                    >
                        <span *dssOption="let option">{{
                            option.viewValue
                        }}</span>
                    </dss-dropdown>
                    <label dssLabel>Modalidade</label>
                </dss-form-field>
            </div>

            <div dssContainer shadow="lg" class="grid-item item3">
                <dss-form-field>
                    <dss-dropdown
                        [options]="optionCluster"
                        formControlName="clusterRisk"
                    >
                        <span *dssOption="let option">{{
                            option.viewValue
                        }}</span>
                    </dss-dropdown>
                    <label dssLabel>Cluster</label>
                </dss-form-field>
            </div>

            <div dssContainer shadow="lg" class="grid-item item4">
                <dss-form-field>
                    <dss-dropdown
                        [options]="optionRisk"
                        formControlName="riskGroup"
                        ><span *dssOption="let option">{{
                            option.viewValue
                        }}</span>
                    </dss-dropdown>
                    <label dssLabel>Risco do grupo</label>
                </dss-form-field>
            </div>
            <div dssContainer shadow="lg" class="grid-item item4">
                <dss-form-field>
                    <dss-dropdown
                        [options]="optionFOPA"
                        formControlName="fopa"
                        ><span *dssOption="let option">{{
                            option.viewValue
                        }}</span>
                    </dss-dropdown>
                    <label dssLabel>FOPA</label>
                </dss-form-field>
            </div>

            <dss-form-field
                class="segmentoPrimario"
                [isError]="isError('primarySegmentCode')"
                [isSuccess]="isSuccess('primarySegmentCode')"
            >
                <input type="text" formControlName="primarySegmentCode" />
                <label dssLabel>Segmento Primário</label>
                <div *ngIf="isError('primarySegmentCode')">
                    <div
                        *ngIf="formParameterRules.get('primarySegmentCode').hasError('required')"> Campo obrigatório!</div>
                    <div
                        *ngIf="formParameterRules.get('primarySegmentCode').hasError('invalidSegment')">Valor Inválido - EX PRI000</div>
                    <div
                        *ngIf="formParameterRules.get('primarySegmentCode').hasError('minLength')">Mínimo de 6 caracteres!</div>
                    <div
                        *ngIf="formParameterRules.get('primarySegmentCode').hasError('maxLength')">Máximo de 6 caracteres!</div>
                </div>
            </dss-form-field>

            <dss-form-field
                [isError]="isError('secondarySegmentCode')"
                [isSuccess]="isSuccess('secondarySegmentCode')"
            >
                <input type="text" formControlName="secondarySegmentCode" />
                <label dssLabel>Segmento Secundário</label>
                <div *ngIf="isError('secondarySegmentCode')">
                    <div
                        *ngIf="formParameterRules.get('secondarySegmentCode').hasError('required')"> Campo obrigatório!</div>
                    <div
                        *ngIf="formParameterRules.get('secondarySegmentCode').hasError('invalidSegment')">Valor Inválido - EX PRI000</div>
                    <div
                        *ngIf="formParameterRules.get('secondarySegmentCode').hasError('minLength')">Mínimo de 6 caracteres!</div>
                    <div
                        *ngIf="formParameterRules.get('secondarySegmentCode').hasError('maxLength')">Máximo de 6 caracteres!</div>
                </div>
            </dss-form-field>

            <!-- Datapicker -->

            <dss-datepicker  (datepickerChange)="formParameterRules.controls['effectiveDate'].setValue($event)">
                <label for="effectiveDate">Início Vigência</label>
            </dss-datepicker>

            <dss-datepicker (datepickerChange)="formParameterRules.controls['endDateValidity'].setValue($event)">
                <label for="endDateValidity">Fim Vigência</label>
            </dss-datepicker>


        </div>
    </form>
    {{ formParameterRules.value | json }}
</div>
-------------------
.container {
    display: grid;
    column-gap: 1rem;
    position: absolute;
    top: 140px;
    left: 40px;
    right: 40px;
    padding: 1rem;
}

.grid-container {
    display: grid;
    grid-template-columns: repeat(2, 1fr);
    gap: 20px 72px;
}
:host ::ng-deep{
    .dss-form-field__label{

    }
}
------------------
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
        private formBuilder: FormBuilder,
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
                    segmentValidator()
                ]
            ],
            secondarySegmentCode: [
                null,
                Validators.required,
                Validators.maxLength(6),
                Validators.minLength(6),
                CustomValidators.SecondaryCodeValidators,

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

    public onSubmit(): void {
        console.log("onSubmit(), called");

        const formData: IDataSource = this.formParameterRules.value;
        const formDataAge: IDataSourceAge = this.formParameterRulesAge.value;

        console.log("onSubmit(), called");

        console.log(this.formParameterRules.value);
        if (this.formParameterRules.valid) {
            console.log("Form is valid");
            //Solicitação de Post para a API
            this.http.post<ResponseType>(this.addRules, formData).subscribe(
                (response) => {
                    console.log("Regra adicionada com Sucesso: ", response);
                    this.formParameterRules.reset();

                    //Navegar para a pagina de lista regras
                    this.router.navigate(["/yzju-regras-parametrizacao"]);
                },
                (err) => {
                    console.log("Erro ao adicionar a regra", err);
                    
                }
            );
        } else {
            console.log("Form is invalid");
        }
    }

    public isError(channelName: string): boolean {
        const input = this.formParameterRules.get(channelName);
        return input !== null && input.invalid && input.dirty && input.touched;
    }

    public isSuccess(name: string): boolean {
        const input = this.formParameterRules.get(name);
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

----------------------
import { ComponentFixture, TestBed } from '@angular/core/testing';

import { RegrasIdadeModalidadeComponent } from './regras-idade-modalidade.component';

describe('RegrasIdadeModalidadeComponent', () => {
  let component: RegrasIdadeModalidadeComponent;
  let fixture: ComponentFixture<RegrasIdadeModalidadeComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ RegrasIdadeModalidadeComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(RegrasIdadeModalidadeComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
