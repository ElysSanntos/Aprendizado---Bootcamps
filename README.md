export interface IDataSource {


    ruleId: string;
    channelId: string;
    channelName: string;
    primarySegmentCode: string;
    secondarySegmentCode: string;
    fopa: string;
    clusterRisk: number; //risco do cliente
    riskGroup: string;
    modalityId: string;
    modalityCode: string;
    effectiveDate: string;
    endDateValidity: string;
    activeRule: boolean;
}


---------------------------------------------------------------------
<section class="container">

    <span class="title__page">Regras de Parametrização</span>

    <!-- segment-control 1 -->
    <dss-segment-control class="segment-control">
        <dss-segment-control-item class="segment-control__item__active">
            <dss-segment-control-item-header
                >Regras ativas</dss-segment-control-item-header
            >

            <dss-segment-control-item-content >
                <!-- Tabelas -->
                <dss-data-table [dataSource]="dataSource">
                    <table>
                        <ng-container *ngFor="let col of columnsSchema">
                            <th class="center-th" *dssHeaderCell>
                                {{ col.label }}
                            </th>
                            <td class="center-td" *dssCell="let element">
                                <!-- Linhas padrões -->
                                <div
                                    [ngSwitch]="col.type"
                                    *ngIf="!element.isEdit"
                                >
                                    <!-- Botões -->
                                    <div *ngSwitchCase="'isEdit'">
                                        <!-- Botão editar -->
                                        <button
                                            dssIconButton
                                            (click)=" edit(element) "
                                        >
                                            <span
                                                dssIcon
                                                name="subscription"
                                            ></span>
                                        </button>
                                    </div>
                                    <span *ngSwitchCase = "'object'">{{element[col.key][col.keyObject] }}</span>
                                    <span *ngSwitchDefault>{{ element[col.key] }}</span>


                                </div>
                            </td>
                        </ng-container>
                    </table>
                    <dss-pagination optionDefault="10"></dss-pagination>
                </dss-data-table>

            </dss-segment-control-item-content>
        </dss-segment-control-item >


        <!-- segment-control 2 -->
        <dss-segment-control-item class="segment-control__item__inactive">
            <dss-segment-control-item-header
                >Regras inativas</dss-segment-control-item-header
            >
            <dss-segment-control-item-content>
               <!-- Tabelas -->
               <dss-data-table [dataSource]="dataSource">
                <table>
                    <ng-container *ngFor="let col of columnsSchema">
                        <th class="center-th" *dssHeaderCell>
                            {{ col.label }}
                        </th>
                        <td class="center-td" *dssCell="let element" >
                            <!-- Linhas padrões -->
                            <div
                                [ngSwitch]="col.type"
                                *ngIf="!element.isEdit"
                            >
                                <!-- Botões -->
                                <div *ngSwitchCase="'isEdit'">
                                    <!-- Botão editar -->
                                    <button
                                        dssIconButton disabled

                                    >
                                        <span
                                            dssIcon
                                            name="subscription"
                                        ></span>
                                    </button>
                                </div>

                                <span *ngSwitchCase = "'object'">{{element[col.key][col.keyObject] }}</span>
                                <span *ngSwitchDefault>{{element[col.key] }}</span>

                            </div>
                        </td>
                    </ng-container>
                </table>
                    <dss-pagination optionDefault="5"></dss-pagination>
                </dss-data-table>
            </dss-segment-control-item-content>
        </dss-segment-control-item>
    </dss-segment-control>


    <spaui-preloader id="preLoader"></spaui-preloader>

    <div class="buttons-group-rules">
        <button dssOutlineButton class="buttons-group__download" > Baixar regras </button>
        <button dssFilledButton class="buttons-group__newRule " dssButton (click) = "open = true"> Nova regra </button>
    </div>

</section>

<!-- Modal para Create e Edit -->

  <dss-dialog [open]="open" >
    <dss-dialog-header>
      <div class="title__dialog">Nova Regra</div>
      <span class="text__dialog">Preencha todos os campos para adição de nova regra</span>
    </dss-dialog-header>

    <dss-dialog-body>
      <app-formulario [formParameterRules] = 'formParameterRules'></app-formulario>
    </dss-dialog-body>



    <dss-dialog-footer>
        <hr dssDivider />

      <button dssOutlineButton (click)="open = false" buttons-group__download>Cancelar</button>
      <button [routerLink]="['/API']" dssFilledButton buttons-group__newRule>Adicionar regra</button>
      <!-- <button [routerLink]="['/web']" dssFilledButton [disabled]="formParameterRules.invalid" >Adicionar regra</button> -->
    </dss-dialog-footer>

  </dss-dialog>
------------------------------------------------------------------
.container {
    margin-left: 7%;
    margin-top: 16px;
    width: 1106px;
    height: 809px;
}

:host ::ng-deep {
    .dss-dialog__content {
        min-width: 950px;
        height: 757px;
        margin: 0;
        padding: 40px;
    }
    .dss-dialog__footer {
        display: flex;
        justify-content: center;
        align-items: flex-end;
        margin-top: 423px;
        flex-wrap: wrap;
        align-content: flex-start;
        padding-bottom: 40px;
        padding-top: 81px;
    }
    .dss-button--secondary {
        margin-top: 40px;
        height: 48px;
        line-height: 30px;
        width: 148px;
        border-radius: 4px;
        border: 1px solid rgba(204, 0, 0, 1);
        opacity: 1;
        background-color: rgba(255, 255, 255, 1);
        border: 1px solid #cc0000;
        padding: 8px 16px;
        color: #cc0000;
        font-family: "SantanderText-Regular";
        font-size: 18px;
        font-weight: 400;
        font-style: normal;
        letter-spacing: 0px;
        text-align: center;
        line-height: 28px;
    }

    .dss-button--primary {
        margin-top: 40px;
        height: 48px;
        line-height: 30px;
        min-width: 148px;
        max-width: 250px ;
        border-radius: 4px;
        border: 1px solid #cc0000;
        background-color: #cc0000;
        padding: 8px 16px;
        margin-left: 25px;
        width: 133px;
        height: 48px;
        opacity: 1;
        color: white;
        font-family: "SantanderText-Regular";
        font-size: 17px;
        font-weight: 400;
        font-style: normal;
        letter-spacing: 0px;
        text-align: center;
        line-height: 28px;
    }
    .dss-segment-control__nav{
        border-bottom: 1px solid #ccc;
        display: flex;
        list-style: none;
        position: relative;
        width: 100%;
        flex-direction: row;
        flex-wrap: nowrap;
        align-content: center;
        justify-content: space-around;

    }
}

.title__page .title__dialog {
    display: flex;
    width: auto;
    margin-bottom: 50px;
    opacity: 1;
    color: rgba(34, 34, 34, 1);
    font-family: "SantanderHeadline-Regular";
    font-size: 32px;
    font-weight: 400;
    font-style: normal;
    letter-spacing: 0px;
    text-align: left;
    line-height: 48px;
}
.text__dialog {
    opacity: 1;
    color: rgba(34, 34, 34, 1);
    font-family: "SantanderText-Regular";
    font-size: 18px;
    font-weight: 400;
    font-style: normal;
    letter-spacing: 0px;
    text-align: left;
    line-height: 28px;
}
.segment-control {
    top: 262px;
    left: 211px;
    width: 100%;
    height: 38px;
    margin-top: 50px;
}
.segment-control__item__active {
    margin-right: 0px;
    width: 553px !important;
    white-space: break-spaces !important;
}
.center-th {
    white-space: break-spaces !important;
    padding: 8px 8px;
    text-align: center;
    color: rgba(68, 68, 68, 1);
    font-family: "SantanderMicroText-Bd";
    font-size: 14px;
    font-weight: bold;
    font-style: normal;
    letter-spacing: 0px;
    line-height: 22px;
    opacity: 1;
}
.center-th__ID {
    width: 20px;
    padding-right: 3px;
}
.center-td {
    padding: 6px 6px;
    text-align: center;
    opacity: 1;
    color: rgba(68, 68, 68, 1);
    font-family: "SantanderMicroText";
    font-size: 14px;
    font-weight: 400;
    font-style: normal;
    letter-spacing: 0px;
    line-height: 22px;
}

.flex-container {
    display: flex;
    justify-content: flex-start;
    align-content: center;
    flex-wrap: wrap;
    align-items: center;
}
.flex-item {
    display: flex;
    flex-wrap: nowrap;
    align-items: center;
    justify-content: space-between;
}
.buttons-group-rules {
    display: flex;
    justify-content: center;
    align-items: center;
    margin-top: 56px;
}
.buttons-group__download {
    border-radius: 4px;
    border: 1px solid rgba(204, 0, 0, 1);
    opacity: 1;
    background-color: rgba(255, 255, 255, 1);
    padding: 8px 16px;
    width: 133px;
    height: 48px;
    opacity: 1;
    color: rgba(204, 0, 0, 1);
    font-family: "SantanderText-Regular";
    font-size: 18px;
    font-weight: 400;
    font-style: normal;
    letter-spacing: 0px;
    text-align: center;
    line-height: 28px;
}
.buttons-group__newRule {
    border-radius: 4px;
    border: 1px solid rgba(204, 0, 0, 1);
    opacity: 1;
    background-color: rgba(204, 0, 0, 1);
    padding: 8px 16px;
    margin-left: 25px;
    width: 133px;
    height: 48px;
    opacity: 1;
    color: rgba(255, 255, 255, 1);
    font-family: "SantanderText-Regular";
    font-size: 18px;
    font-weight: 400;
    font-style: normal;
    letter-spacing: 0px;
    text-align: center;
    line-height: 28px;
}

------------------------------------
import { Component, OnInit } from "@angular/core";
import { FormBuilder, FormGroup, Validators } from "@angular/forms";
import { DssSortChangeInterface } from "@dss/components/data-table";
import { OrquestradorMotoresService } from "../../../service/orquestrador-motores/orquestrador-motores.service";
import { IDataSource } from "./iDataSource";

interface IcolumnsSchema {
    key: string;
    keyObject?: string;
    type: string;
    label: string;
}

@Component({
    selector: "app-regras-parametrizacao",
    templateUrl: "./regras-parametrizacao.component.html",
    styleUrls: ["./regras-parametrizacao.component.scss"],
})
export class RegrasParametrizacaoComponent implements OnInit {
    public open = false;

    public input = "";
    public column = "ruleId";
    public order = "desc";
    public sortBy = "";
    public orderBy = "";

    public dataSource: any;
    files: any;
    msgErro: any;

    public compareFimVigencia(a: Object, b: Object): number {
        const currentColumnValueA = a["endDateValidity"] || "";
        const currentColumnValueB = b["endDateValidity"] || "";

        return currentColumnValueA - currentColumnValueB;
    }

    public handleSortChange({ column, order }: DssSortChangeInterface): void {
        this.sortBy = column;
        this.orderBy = order;
    }

    constructor(
        private orquestradorMotoresService: OrquestradorMotoresService,
        private formBuilder: FormBuilder
    ) {}

    ngOnInit(): void {
        this.getAllRules();

        this.createForm({
            ruleId: "",
            channelId: "",
            channelName: "",
            primarySegmentCode: "",
            secondarySegmentCode: "",
            fopa: "",
            clusterRisk: 0,
            riskGroup: "",
            modalityId: "",
            modalityCode: "",
            effectiveDate: "",
            endDateValidity: "",
            activeRule: true,
        });
    }

    public getAllRules() {
        this.orquestradorMotoresService.getOrchestradorAllRules().subscribe(
            (res) => {
                
                this.dataSource = res._content;

                console.log("dataSource", this.dataSource);
            },
            (err) => {
                this.msgErro = err.message;
            }
        );
    }

    public edit(element) {
        console.log(element);
        this.createForm({
            ruleId: "",
            channelId: "",
            channelName: "",
            primarySegmentCode: "",
            secondarySegmentCode: "",
            fopa: "",
            clusterRisk: 0,
            riskGroup: "",
            modalityId: "",
            modalityCode: "",
            effectiveDate: "",
            endDateValidity: "",
            activeRule: false,
        });

        this.open = true;
    }

    public columnsSchema: Array<IcolumnsSchema> = [
        {
            key: "ruleId",
            type: "string",
            label: "ID",
        },
        {
            key: "channel",
            keyObject: "channelName",
            type: "object",
            label: "Canal Vendas",
        },
        {
            key: "modality",
            keyObject: "modalityCode",
            type: "object",
            label: "Modalidade",
        },
        {
            key: "clusterRisk",
            type: "string",
            label: "Cluster Risco Cliente",
        },
        {
            key: "primarySegmentCode",
            type: "string",
            label: "Segmento Primário",
        },
        {
            key: "secondarySegmentCode",
            type: "string",
            label: "Segmento Secundário",
        },
        {
            key: "riskGroup",
            type: "string",
            label: "Cluster Risco Grupo",
        },
        {
            key: "fopa",
            type: "string",
            label: "FOPA",
        },

        {
            key: "effectiveDate",
            type: "date",
            label: "Início Vigência",
        },
        {
            key: "endDateValidity",
            type: "date",
            label: "Fim da Vigência",
        },

        {
            key: "isEdit",
            type: "isEdit",
            label: "",
        },
    ];

    public displayedColumns: string[] = this.columnsSchema.map(
        (col) => col.key
    );

    formParameterRules: FormGroup;

    createForm(parameterRules: IDataSource) {
        this.formParameterRules = this.formBuilder.group({

            channelName: [parameterRules.channelName, [Validators.required]],
            primarySegmentCode: [parameterRules.primarySegmentCode,[Validators.required]],
            secondarySegmentCode: [parameterRules.secondarySegmentCode,[Validators.required, Validators.minLength(6),Validators.maxLength(6) ]],
            fopa: [parameterRules.fopa,[Validators.required, Validators.minLength(6),Validators.maxLength(6)]],
            clusterRisk: [parameterRules.clusterRisk, [Validators.required]],
            riskGroup: [parameterRules.riskGroup, [Validators.required]],
            modalityCode: [parameterRules.modalityCode, [Validators.required]],
            effectiveDate: [parameterRules.effectiveDate, [Validators.required]],
            endDateValidity: [parameterRules.endDateValidity, [Validators.required]],


        });
    }
}
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

            <dss-form-field>
                <input type="text" formControlName="fopa" />
                <label dssLabel>FOPA</label>

            </dss-form-field>
            <dss-form-field
                class="segmentoPrimario"
                class="grid-item item5"
                [isError]="isError('primarySegmentCode')"
                [isSuccess]="isSuccess('primarySegmentCode')"
            >
                <input type="text" formControlName="primarySegmentCode" />
                <label dssLabel>Segmento Primário</label>

                <span
                    *ngIf="formParameterRules.get('primarySegmentCode')?.errors?.required"
                    dssError
                    >Campo obrigatório!</span
                >
                <span
                    *ngIf="formParameterRules.get('primarySegmentCode')?.errors?.text"
                    dssError
                    >Valor Inválido</span
                >
                <span
                    *ngIf="formParameterRules.get('primarySegmentCode')?.errors?.minlength"
                    dssError
                    >Mínimo de 6 caracteres!</span
                >
                <span
                    *ngIf="formParameterRules.get('primarySegmentCode')?.errors?.maxlength"
                    dssError
                    >Máximo de 6 caracteres!</span
                >
            </dss-form-field>

            <dss-form-field
                class="segmentoSecundario"
                class="grid-item item6"
                [isError]="isError('secondarySegmentCode')"
                [isSuccess]="isSuccess('secondarySegmentCode')"
            >
                <input type="text" formControlName="secondarySegmentCode" />
                <label dssLabel>Segmento Secundário</label>

                <span
                    *ngIf="formParameterRules.get('secondarySegmentCode')?.errors?.required"
                    dssError
                    >Campo obrigatório!</span
                >
                <span
                    *ngIf="formParameterRules.get('secondarySegmentCode')?.errors?.text"
                    dssError
                    >Valor Inválido</span
                >
                <span
                    *ngIf="formParameterRules.get('secondarySegmentCode')?.errors?.minlength"
                    dssError
                    >Mínimo de 6 caracteres!</span
                >
                <span
                    *ngIf="formParameterRules.get('secondarySegmentCode')?.errors?.maxlength"
                    dssError
                    >Máximo de 6 caracteres!</span
                >
            </dss-form-field>

            <!-- Datapicker -->


            <dss-datepicker (datepickerChange)="input = $event">
                <label for="Início Vigência"></label>
            </dss-datepicker>
            <dss-datepicker (datepickerChange)="input = $event">
                <label for="Fim Vigência"></label>
            </dss-datepicker>

                <!-- {{formParameterRules.value | json}} -->


        </div>
    </form>


</div>

-------------
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
---------
import { Component, Input, OnInit } from "@angular/core";
import { FormBuilder, FormGroup, Validators } from "@angular/forms";
import { DssOptionInterface } from "@dss/components";
import { IDataSource } from "../regras-parametrizacao/iDataSource";




@Component({
    selector: "app-formulario",
    templateUrl: "./formulario.component.html",
    styleUrls: ["./formulario.component.scss"],
})
export class FormularioComponent implements OnInit {

    @Input() formParameterRules: FormGroup;
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

    constructor() {}

    public ngOnInit(): void {


    }


    public onSubmit(): void {

        console.log(this.formParameterRules.value);
        if (this.formParameterRules.valid) {
            this.formParameterRules.reset();
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


}
------------
import { DataSource } from '@angular/cdk/collections';
import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable, of } from 'rxjs';
import { catchError, retry, switchMap, tap, debounceTime } from 'rxjs/operators';
import { IDataSource } from 'src/app/componentes/orquestrador-motores/regras-parametrizacao/iDataSource';
import { urlConfig } from 'src/app/config/url.config';
import { CriptografiaService } from 'src/app/service/criptografia/criptografia.service';

@Injectable({
  providedIn: 'root'
})
export class OrquestradorMotoresService {

    private readonly API = 'urlConfig.getRulesOrchestrator';
    dataSource: IDataSource[];

constructor(
    private http: HttpClient,
    private criptoService: CriptografiaService
) { }

/*Lista todas as regras da API */

getOrchestradorAllRules(): Observable<any>{
    return this.http.get(urlConfig.getRulesOrchestrator).pipe(

        debounceTime(2000),
        switchMap((response)=>{
            return of(response);
        }),
        retry(2),
        catchError((err) =>{
            throw new Error(err);
        })
        
    )
}

}


-----------------------------------------------------
formulario.html

import { Component, Input, OnInit } from "@angular/core";
import { FormBuilder, FormGroup, Validators } from "@angular/forms";
import { DssOptionInterface } from "@dss/components";
import { IDataSource } from "../regras-parametrizacao/iDataSource";
import { HttpClient } from "@angular/common/http";
import { urlConfig } from "src/app/config/url.config";
import { RegrasParametrizacaoComponent } from "../regras-parametrizacao/regras-parametrizacao.component";
import { MappingIds } from "../regras-parametrizacao/mapping-ids";




@Component({
    selector: "app-formulario",
    templateUrl: "./formulario.component.html",
    styleUrls: ["./formulario.component.scss"],
})
export class FormularioComponent implements OnInit {
   


    channels: MappingIds;
    modalities: MappingIds;

    private apiAdd = urlConfig.addModalitiesChannelOrchestrator;
    private regras = RegrasParametrizacaoComponent;

    @Input() formParameterRules: FormGroup;
    @Input() editingRule: IDataSource | null;




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
        const formData: IDataSource = this.formParameterRules.value;

        console.log(this.formParameterRules.value);
        if (this.formParameterRules.valid) {
            //Solicitação de Post para a API
            this.http.post<ResponseType>(this.apiAdd,formData).subscribe(
                (response) =>{
                    console.log('Regra adicionada com Sucesso: ', response);
                    this.formParameterRules.reset();
                },
                (err) =>{
                    console.log('Erro ao adicionar a regra',err);
                }
            )

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


