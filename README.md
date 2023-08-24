.dss-segment-control__bar {
    background-color: #c00;
    bottom: 0;
    height: 2px;
    left: 0;
    position: absolute;
    transition-duration: .2s;
    transition-property: left,width;
    transition-timing-function: cubic-bezier(.6,0,.2,1);
}
----------------------------------------------------
.dss-segment-control__item {
  appearance: none;
  background-color: var(--token-segment-control-background-color-default);
  border-radius: var(--token-segment-control-border-radius);
  border-width: 0;
  color: var(--token-segment-control-color-default);
  cursor: pointer;
  font-family: var(--token-segment-control-font-family);
  font-size: var(--token-segment-control-font-size);
  font-weight: var(--token-segment-control-font-weight);
  line-height: var(--token-segment-control-line-height);
  margin: var(--token-segment-control-margin);
  outline: 0;
  padding: var(--token-segment-control-padding-vertical) var(--token-segment-control-padding-horizontal);
  position: relative;
  text-align: var(--token-segment-control-text-align);
  transition-duration: var(--token-segment-control-motion-duration);
  transition-property: background-color, color;
  transition-timing-function: var(--token-segment-control-motion-timing-function);
  white-space: nowrap;

  &::after {
    background-color: var(--token-segment-control-background-color-activated);
    content: '';
    height: 1px;
    left: -4px;
    position: absolute;
    top: calc(100% + var(--token-segment-control-margin));
    width: calc(100% + (var(--token-segment-control-margin) * 2));
  }

  &.dss-segment-control__item--active:not(.dss-segment-control__item--disabled) {
    color: var(--token-segment-control-color-selected);
  }

  &.dss-segment-control__item--disabled {
    color: var(--token-segment-control-color-disabled);
    cursor: var(--cursor-disabled);

    &::after {
      background-color: var(--token-segment-control-background-color-disabled);
    }
  }
}



-----------------------------------------
:host {
    margin-left: 7%;
    margin-top: 16px;
    width: 1106px;
    height: 809px;
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
    margin-top: 20px; /* Ajuste para estilos encapsulados */
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




------------------------------------------


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
-------------------------
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
                <dss-data-table [dataSource]="activeDataSource">
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
               <dss-data-table [dataSource]="inactiveDataSource">
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
      <button [routerLink]="['saveRulesOrchestrator']" dssFilledButton buttons-group__newRule>Adicionar regra</button>
      <!-- <button [routerLink]="['/web']" dssFilledButton [disabled]="formParameterRules.invalid" >Adicionar regra</button> -->
    </dss-dialog-footer>

  </dss-dialog>
----------------------------
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
-----------------------------------------------

import { ComponentFixture, TestBed } from '@angular/core/testing';

import { RegrasParametrizacaoComponent } from './regras-parametrizacao.component';

describe('RegrasParametrizacaoComponent', () => {
  let component: RegrasParametrizacaoComponent;
  let fixture: ComponentFixture<RegrasParametrizacaoComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ RegrasParametrizacaoComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(RegrasParametrizacaoComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
-----------------------------------------------
import { Component, OnInit } from "@angular/core";
import { FormBuilder, FormGroup } from "@angular/forms";
import { Router } from "@angular/router";
import { RuleCommunicationService } from "src/app/service/orquestrador-motores/rule-communication.service";

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
    public msgErro: string = "";

    public open = false;
    public input = "";
    public column = "ruleId";
    public order = "desc";
    public sortBy = "";
    public orderBy = "";
    public activeDataSource: any;
    public inactiveDataSource: any;
    files: any;

    formParameterRules: FormGroup;
    static primarySecondaryCodeValidators: any;

    constructor(
        private orquestradorMotoresService: OrquestradorMotoresService,
        private formBuilder: FormBuilder,
        private router: Router,
        private ruleCommunicationService: RuleCommunicationService
    ) {}

    // Inicialização do component

    ngOnInit(): void {
        this.getActiveRules();
        console.log(" getInactiveRules(ngOnInit)");
        this.getInactiveRules();

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

        // Assinar evento de criação da regra
        this.ruleCommunicationService.ruleCreated$.subscribe(() => {
            // Atualizar a lista de regras após criar a regra
            this.getActiveRules();
            this.getInactiveRules();
        });
    }
    // Função para criar o formulario
    createForm(parameterRules: IDataSource) {
        this.formParameterRules = this.formBuilder.group({
            channelName: [parameterRules.channelName],
            primarySegmentCode: [parameterRules.primarySegmentCode],
            secondarySegmentCode: [parameterRules.secondarySegmentCode],
            fopa: [parameterRules.fopa],
            clusterRisk: [parameterRules.clusterRisk],
            riskGroup: [parameterRules.riskGroup],
            modalityCode: [parameterRules.modalityCode],
            effectiveDate: [parameterRules.effectiveDate],
            endDateValidity: [parameterRules.endDateValidity],
        });
    }
    // Função para manipular o envio do formulario
    onSubmit() {
        if (this.formParameterRules.valid) {
            const formData = this.formParameterRules.value;
            this.orquestradorMotoresService.saveNewRule(formData).subscribe(
                (res) => {
                    console.log("Regra adicionada com sucesso: ", res);
                    this.formParameterRules.reset();
                    this.router.navigate(["../"]);
                    // Atualizar a lista de regras após criar a nova regra
                    this.getActiveRules();
                    // Fechar o modal
                    this.open = false;
                },
                (err) => {
                    this.msgErro = err.message;
                }
            );
        }
    }
    // função para obter regras ativas
    public getActiveRules() {
        this.orquestradorMotoresService.getActiveRules().subscribe(
            (data) => {
                this.activeDataSource = data._content;
                console.log("getActiveRules():regras", this.activeDataSource);
            },
            (err) => {
                this.msgErro = err.message;
            }
        );
    }
    // função para obter regras inativas
    public getInactiveRules() {
        this.orquestradorMotoresService.getInactiveRules().subscribe(
            (res) => {
                this.inactiveDataSource = res._content;
                console.log("getInactiveRules", this.inactiveDataSource);
            },
            (err) => {
                this.msgErro = err.message;
            }
        );
    }
    // função para edição de regras
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
}
-------------------------------------------------------------------
import { AbstractControl, ValidationErrors, ValidatorFn } from "@angular/forms";


export class CustomValidators {
    pattern: RegExp = /^[A-Z]{3}[0-9]{3}$/;
    static letters: RegExp = /^[A-Z]+$/;
    static numbers: RegExp = /^\d+$/;


    static SecondaryCodeValidators(
        control: AbstractControl
    ): ValidationErrors | null {
        const value: string = control.value;

        //verifica se o valor possui exatamente 6 caracteres
        if (value && value.length === 6) {
            //Verifica os 3 primeiros maiusculos
            const firstThreeChars = value.substring(0, 3);



            if (!this.letters.test(firstThreeChars)) {
                return { invalidFormat: true };
            }

            //Verifica 3 ultimos são numeros
            const lastThreeChars = value.substring(3);
            if (!this.numbers.test(lastThreeChars)) {
                return { invalidFormat: true };
            }

            //valor valido
            return null;
        }
        //Caso não tenha 6 caracteres
        return { invalidFormat: true };
    }
    // static snPatterns(control: AbstractControl): ValidationErrors | null {
    //     const snPattern: RegExp = /^[SN]$/;
    //     const value: string = control.value;

    //     if (!snPattern.test(value.charAt(0))) {
    //         return { snCode: true };
    //     }
    //     return null;
    // }



}
export function segmentValidator(): ValidatorFn {
    return(control: AbstractControl):{ [key: string]: any } | null =>{
        console.log("validação customizada............")
        const segmentValue = control.value;
        console.log("valor do segmento: ", segmentValue)
        if( segmentValue && segmentValue.length === 6){
            const primarySegment = segmentValue.substring(0,3);
            const numericPart = segmentValue.substring(3);

            console.log( "Primary Segment: ", primarySegment )
            console.log( "Numeric Part: ", numericPart )

            if( primarySegment === "PRI" && /\d{3}$/.test(numericPart)){
                return null; //validação bem sucedida
            }
        }
        return {invalidSegment: true}; //validação falhou
    };

}
---------------------------------------------------------------
import { TestBed } from '@angular/core/testing';

import { ApiService } from './api.service';

describe('ApiService', () => {
  let service: ApiService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(ApiService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
-------------------------------------------------------------
import { Injectable } from '@angular/core';
import { HttpClient, HttpErrorResponse } from '@angular/common/http';
import { Observable, throwError } from 'rxjs';
import { catchError } from 'rxjs/operators';

@Injectable({
  providedIn: 'root'
})
export class ApiService {

  constructor(
    private http: HttpClient,
  ) { }

  get(endpoint: string, data: any): Observable<any>{
    return this.http.post(endpoint, data).pipe(
        catchError(this.handleError)
    );
  }


//   Adicionar outros métodos CRUD aqui

private handleError(error: HttpErrorResponse){

    let errorMessage = "Ocorreu um erro";
    if(error.error instanceof ErrorEvent){

        errorMessage = `Error Code: ${error.status}\nMessage: ${error.message}`;

    }
    console.error(errorMessage);
    return throwError(errorMessage);

}
}
---------------------------------------------------------
import { HttpClient, HttpErrorResponse } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable, of, throwError } from 'rxjs';
import { catchError, debounceTime, map, mergeMap, retry, switchMap } from 'rxjs/operators';
import { IDataSource } from 'src/app/componentes/orquestrador-motores/regras-parametrizacao/iDataSource';
import { urlConfig } from 'src/app/config/url.config';
import { CriptografiaService } from 'src/app/service/criptografia/criptografia.service';

import { ApiService } from './api.service';

@Injectable({
  providedIn: 'root'
})
export class OrquestradorMotoresService {

  apiMessage: string = "";
  activeApiMessage: string = '';
  inactiveApiMessage: string = '';

  private readonly activeRules = urlConfig.getActiveRulesOrchestrator;
  private readonly inactiveRules = urlConfig.getInactiveRulesOrchestrator;

  dataSource: IDataSource[];

  constructor(
    private http: HttpClient,
    private apiService: ApiService,
    private criptoService: CriptografiaService,
  ) { }

  ngOnInit(): void {
    this.fetchApiMessages();
  }

  getApiMessage(): Observable<{ activeRules: string; inactiveRules: string }> {
    const activeRules$ = this.http.get<string>(this.activeRules).pipe(catchError(this.handleError));
    const inactiveRules$ = this.http.get<string>(this.inactiveRules).pipe(catchError(this.handleError));

    return activeRules$.pipe(
      switchMap(activeRules => {
        return inactiveRules$.pipe(map(inactiveRules => ({ activeRules, inactiveRules })));
      })
    );
  }

  getActiveRules(): Observable<any> {
    return this.http.get<any>(urlConfig.getActiveRulesOrchestrator).pipe(
      debounceTime(2000),
      switchMap((response) => {
        console.log('listagem das regras ativas - Metodo getActiveRules() ');
        return of(response);
      }),
      retry(2),
      catchError((err) => {
        const errorMessage = 'Ocorreu um erro ao buscar as regras ativas getActiveRules()';
        return throwError(errorMessage);
      })
    );
  }

  getInactiveRules(): Observable<any> {
    console.log('Chamando o metodo regras inativas do metodo getInactiveRules');
    return this.http.get<any[]>(urlConfig.getInactiveRulesOrchestrator).pipe(
      debounceTime(2000),
      switchMap((response) => {
        console.log('listagem das regras inativas');
        return of(response);
      }),
      retry(2),
      catchError((err) => {
        console.log('listagem de Erros regras inativas');
        const errorMessage = 'Ocorreu um erro ao buscar as regras inativas';
        return throwError(errorMessage);
      })
    );
  }

  saveNewRule(ruleData: any): Observable<any> {
    const apiURL = urlConfig.saveRulesOrchestrator;
    return this.http.post(apiURL, ruleData).pipe(
      retry(2),
      catchError((err) => {
        throw new Error(err);
      })
    );
  }

  private handleError(error: HttpErrorResponse) {
    let errorMessage = "Ocorreu um erro";
    if (error.error instanceof ErrorEvent) {
      errorMessage = `Error: ${error.error.message}`;
    } else {
      errorMessage = `Error Code: ${error.status}\nMessage: ${error.message}`;
    }
    console.error(errorMessage);
    return throwError(errorMessage);
  }

  fetchApiMessages(): void {
    this.getApiMessage().subscribe(
      (response) => {
        this.activeApiMessage = response.activeRules;
        this.inactiveApiMessage = response.inactiveRules;
      },
      (error) => {
        console.error('Erro na chamada à API: ', error);
        this.activeApiMessage = 'Erro ao obter mensagens para regras ativas.';
        this.inactiveApiMessage = 'Erro ao obter mensagens para regras inativas.';
      }
    );
  }
}
------------------------------------------------------------------------
/* tslint:disable:no-unused-variable */

import { TestBed, inject } from '@angular/core/testing';
import { OrquestradorMotoresService } from './orquestrador-motores.service';

describe('Service: OrquestradorMotores', () => {
  beforeEach(() => {
    TestBed.configureTestingModule({
      providers: [OrquestradorMotoresService]
    });
  });

  it('should ...', inject([OrquestradorMotoresService], (service: OrquestradorMotoresService) => {
    expect(service).toBeTruthy();
  }));
});
--------------------------------------------------------------------------
import { Injectable } from '@angular/core';
import { Subject } from 'rxjs/internal/Subject';

@Injectable({
  providedIn: 'root'
})
export class RuleCommunicationService {

    private ruleCreatedSource = new Subject<void>();
    ruleCreated$ = this.ruleCreatedSource.asObservable();

    notifyRuleCreated(){
        this.ruleCreatedSource.next();
    }

  constructor() { }
}
-----------------------------------------------------------------------
{
  "name": "yzModuloGestor",
  "version": "3.3.12",
  "scripts": {
    "ng": "afe",
    "start": "afe serve --port 4200",
    "build": "afe build --base-href /parametrizador/ --deploy-url /parametrizador/",
    "postbuild": "ncp conf.d dist/conf.d && ncp nginx.conf dist/nginx.conf",
    "test": "afe test --code-coverage --browsers=ChromeHeadlessNoSandbox --watch=false",
    "lint": "ng lint",
    "e2e": "ng e2e",
    "version": "ng version",
    "postinstall": "ngcc"
  },
  "private": true,
  "dependencies": {
    "@afe/authentication": "1.0.4",
    "@afe/authorization-manager": "4.0.0",
    "@afe/dlb-sdk": "2.0.0",
    "@afe/encryption": "2.6.1",
    "@afe/http-interceptors": "2.3.3",
    "@angular/animations": "12.2.17",
    "@angular/cdk": "12.2.13",
    "@angular/common": "12.2.17",
    "@angular/compiler": "12.2.17",
    "@angular/core": "12.2.17",
    "@angular/forms": "12.2.17",
    "@angular/platform-browser": "12.2.17",
    "@angular/platform-browser-dynamic": "12.2.17",
    "@angular/router": "12.2.17",
    "@dss/components": "^1.41.2",
    "@ngx-translate/core": "11.0.1",
    "angl-archtslint": "1.2.4",
    "angular-tslint-rules": "1.12.1",
    "ngx-bootstrap": "5.3.2",
    "ngx-toastr": "12.0.1",
    "rxjs": "6.6.7",
    "tslint-microsoft-contrib": "6.0.0",
    "zone.js": "~0.11.4"
  },
  "devDependencies": {
    "@afe/cli": "3.9.1",
    "@afe/compiler-factory": "2.0.0",
    "@afe/context-handler": "3.1.0",
    "@afe/workspace-manager": "2.1.5",
    "@angular-devkit/build-angular": "~12.2.18",
    "@angular-devkit/core": "12.2.18",
    "@angular-devkit/schematics": "12.2.18",
    "@angular/cli": "12.2.18",
    "@angular/compiler-cli": "12.2.17",
    "@angular/language-service": "12.2.17",
    "@schematics/angular": "12.2.18",
    "@types/jasmine": "~3.6.0",
    "@types/jasminewd2": "2.0.3",
    "@types/node": "^12.11.1",
    "browserslist": "4.8.2",
    "codelyzer": "^6.0.0",
    "core-js": "2.5.4",
    "jasmine-core": "~3.6.0",
    "jasmine-spec-reporter": "~5.0.0",
    "karma": "~6.4.1",
    "karma-chrome-launcher": "~3.1.0",
    "karma-coverage-istanbul-reporter": "~3.0.2",
    "karma-jasmine": "~4.0.0",
    "karma-jasmine-html-reporter": "^1.5.0",
    "ncp": "2.0.0",
    "ng-packagr": "^12.2.7",
    "protractor": "~7.0.0",
    "puppeteer": "1.2.0",
    "ts-node": "8.3.0",
    "tslib": "2.5.3",
    "tslint": "~6.1.0",
    "typescript": "4.3.5"
  }
}
------------------------------------------------------------------------------------------

{
  "compileOnSave": false,
  "compilerOptions": {
    "baseUrl": "./",
    "outDir": "./dist/out-tsc",
    "sourceMap": true,
    "declaration": false,
    "module": "es2020",
    "moduleResolution": "node",
    "experimentalDecorators": true,
    "importHelpers": true,
    "target": "es5",
    "typeRoots": [
      "node_modules/@types"
    ],
    "lib": [
      "es2018",
      "dom"
    ]
  }
}

