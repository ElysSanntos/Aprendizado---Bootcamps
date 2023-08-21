import { HttpClient } from "@angular/common/http";
import { Component, Input, OnInit } from "@angular/core";
import { FormGroup } from "@angular/forms";
import { DssOptionInterface } from "@dss/components";
import { urlConfig } from "src/app/config/url.config";
import { IDataSource } from "../regras-parametrizacao/iDataSource";
import { MappingIds } from "../regras-parametrizacao/mapping-ids";
import { RegrasParametrizacaoComponent } from "../regras-parametrizacao/regras-parametrizacao.component";
import { IDataSourceAge } from "../regras-parametrizacao/IDataSourceAge";






@Component({
    selector: "app-formulario",
    templateUrl: "./formulario.component.html",
    styleUrls: ["./formulario.component.scss"],
})
export class FormularioComponent implements OnInit {



    channels: MappingIds;
    modalities: MappingIds;

    private addRules = urlConfig.saveRulesOrchestrator;

    private regras = RegrasParametrizacaoComponent;

    @Input() formParameterRules: FormGroup;
    @Input() editingRule: IDataSource | null;

    @Input() formParameterRulesAge: FormGroup;
    @Input() editingRuleAge: IDataSource | null;




    public input = '';


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

    ) {}

    public ngOnInit(): void {
        if(this.editingRule){
            const channelId = this.editingRule.channelName;
            const modalityId = this.editingRule.modalityCode;



            //Obter IDs correspondentes ao nome
            const channelIdAsId = this.getChannelIdFromName(channelId);
            const modalityAsId = this.getModalityIdFromCode(modalityId);

            //Preencher os campos do forms com os ids
            this.formParameterRules.patchValue({

                ruleId: this.editingRule.ruleId,
                channelId: this.editingRule.channelId,
                modalityId: this.editingRule.modalityId,
                primarySegmentCode: this.editingRule.primarySegmentCode,
                secondarySegmentCode: this.editingRule.secondarySegmentCode,
                fopa: this.editingRule.fopa,
                clusterRisk: this.editingRule.clusterRisk,
                riskGroup: this.editingRule.riskGroup,
                effectiveDate: this.editingRule.effectiveDate,
                endDateValidity: this.editingRule.endDateValidity,
                activeRule: this.editingRule.activeRule
            })

        }


    }


    public onSubmit(): void {

        console.log('onSubmit(), called');

        const formData: IDataSource = this.formParameterRules.value;
        const formDataAge: IDataSourceAge = this.formParameterRulesAge.value;

        console.log('onSubmit(), called');

        console.log(this.formParameterRules.value);
        if (this.formParameterRules.valid) {

            console.log('Form is valid')
            //Solicitação de Post para a API
            this.http.post<ResponseType>(this.addRules,formData).subscribe(
                (response) =>{
                    console.log('Regra adicionada com Sucesso: ', response);
                    this.formParameterRules.reset();
                },
                (err) =>{
                    console.log('Erro ao adicionar a regra',err);
                }
            )

        }else{
            console.log('Form is invalid')
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
    public getChannelIdFromName(channelName: string): string{
        return this.channels[channelName] || "";
    }
    public getModalityIdFromCode(modalityId: string): string{
        return this.channels[modalityId] || "";
    }
    get editingTitle(): string{
        return this.editingTitle ? "Editar Regra" : "Nova Regra";
    }
    get editingSubtitle(): string{
        return this.editingSubtitle ? "Edite os campos abaixo para atualizar a regra existente." : "Preencha os campos  abaixo para criar uma nova regra.";
    }

}


------------------------------

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
                        formControlName="riskGroup"
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

                <span
                    *ngIf="
                        formParameterRules.get('primarySegmentCode')?.errors
                            ?.required
                    "
                    dssError
                    >Campo obrigatório!</span
                >
                <span
                    *ngIf="
                        formParameterRules.get('primarySegmentCode')?.errors
                            ?.text
                    "
                    dssError
                    >Valor Inválido</span
                >
                <span
                    *ngIf="
                        formParameterRules.get('primarySegmentCode')?.errors
                            ?.minlength
                    "
                    dssError
                    >Mínimo de 6 caracteres!</span
                >
                <span
                    *ngIf="
                        formParameterRules.get('primarySegmentCode')?.errors
                            ?.maxlength
                    "
                    dssError
                    >Máximo de 6 caracteres!</span
                >
            </dss-form-field>

            <dss-form-field>
                <input type="text" formControlName="secondarySegmentCode" />
                <label dssLabel>Segmento Secundário</label>
            </dss-form-field>

            <!-- Datapicker -->

            <dss-datepicker  (datepickerChange)="input = $event">
                <label for="effectiveDate">Início Vigência</label>
            </dss-datepicker>
            
            <dss-datepicker (datepickerChange)="input = $event">
                <label for="endDateValidity">Fim Vigência</label>
            </dss-datepicker>

            {{ formParameterRules.value | json }}
        </div>
    </form>
</div>
