import { HttpClient } from "@angular/common/http";
import { Component, OnInit } from "@angular/core";
import { FormBuilder, FormGroup, Validators } from "@angular/forms";
import { Router } from "@angular/router";
import { urlConfig } from "src/app/config/url.config";
import { CriptografiaService } from "src/app/service/criptografia/criptografia.service";
import { RuleCommunicationService } from "src/app/service/orquestrador-motores/rule-communication.service";
import { IDataSourceAge } from "./../regras-parametrizacao/IDataSourceAge";
import { DssSortChangeInterface } from "@dss/components/data-table";
import { OrquestradorMotoresService } from './../../../service/orquestrador-motores/orquestrador-motores.service';

export interface DataSourceInterface {
    id: any;
    modality: string;
    maxAge: string;
    maxAgeCote: string;
}

@Component({
    selector: "app-regras-idade-modalidade",
    templateUrl: "./regras-idade-modalidade.component.html",
    styleUrls: ["./regras-idade-modalidade.component.scss"],
})
export class RegrasIdadeModalidadeComponent implements OnInit {
    [x: string]: any;
    public open = false;

    public input = "";
    public column = "id";
    public order = "desc";
    public sortBy = "";
    public orderBy = "";

    public ageDataSource: any;
    files: any;
    msgErro: any;

    formParameterRulesAge: FormGroup;

    public handleSortChange({ column, order }: DssSortChangeInterface): void {
        this.sortBy = column;
        this.orderBy = order;
    }
    constructor(
        private http: HttpClient,
        private formBuilder: FormBuilder,
        private router: Router,
        private ruleCommunicationService: RuleCommunicationService,
        private orquestradorMotoresService: OrquestradorMotoresService,
        private criptografiaService: CriptografiaService
    ) {}



    // public removeRow(id) {
    //     this.ageDataSource = this.ageDataSource.filter((u) => u.id !== id);
    // }

    // public addRow() {
    //     const newRow = {
    //         id: "",
    //         modality: "",
    //         maxAge: "",
    //         maxAgeCote: "",
    //         isEdit: true,
    //     };
    //     this.ageDataSource = [...this.ageDataSource, newRow];
    // }

    ngOnInit(){
        console.log("Chamando metodo getRulesAges em onInit");
        this.getRulesAge();

        this.createFormAge()({
            id: "",
            modality: "",
            maxAge: "",
            maxAgeCote: "",
        });

        //Assinar evento de criação da regra
        this.ruleCommunicationService.ruleCreated$.subscribe(() => {
            //Atualizar a lista de regras após criar a regra
            this.getRulesAge();
        });
    }

    createFormAge(parameterRulesAge: IDataSourceAge) {
        this.formParameterRulesAge = this.formBuilder.group({
            id: [parameterRulesAge.id, [Validators.required]],
            modality: [parameterRulesAge.modality, [Validators.required]],
            maxAge: [parameterRulesAge.maxAge, [Validators.required]],
            maxAgeCote: [parameterRulesAge.maxAgeCote, [Validators.required]],
        });
    }

    onSubmit() {
        if (this.formParameterRulesAge.valid) {
          const formData = this.formParameterRulesAge.value;

          this.OrquestradorMotoresService.saveNewRule(formData).subscribe(
            (res) => {
              // Atualizar a lista de regras após criar a nova regra
              this.getActiveRules();
              this.router.navigate(['/lista-regras']); // Navegar para a página de listagem de regras
                //fechar o modal
                this.open=false;
            },
            (err) => {
              this.msgErro = err.message;
            }
          );
        }
      }

    public getRulesAge() {
        this.http.get(urlConfig.getActiveRulesAgeOrchestrator).subscribe(
            (res) => {
                console.log("Pegando dados da URL", res);
                this.ageDataSource = res;
            },
            (err) => {
                this.msgErro = err.message;
            }
        );
    }

    public columnsSchema: Array<any> = [
        {
            key: "id",
            type: "number",
            label: "ID",
        },
        {
            key: "modality",
            type: "text",
            label: "Modalidade",
        },
        {
            key: "maxAge",
            type: "text",
            label: "Idade máxima para validar o prazo",
        },
        {
            key: "maxAgeCote",
            type: "text",
            label: "Idade + prazo restante (cota)",
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

--------

<section class="container">

    <span class="title__page">Regras Idade por Modalidade</span>

    <dss-segment-control class="segment-control">
        <dss-segment-control-item class="segment-control__item__active">


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
      <!-- <app-formulario [formParameterRules] = 'formParameterRules'></app-formulario> -->
    </dss-dialog-body>



    <dss-dialog-footer>
        <hr dssDivider />

      <button dssOutlineButton (click)="open = false" buttons-group__download>Cancelar</button>
      <button [routerLink]="['saveRulesOrchestrator']" dssFilledButton buttons-group__newRule>Adicionar regra</button>
      <!-- <button [routerLink]="['/web']" dssFilledButton [disabled]="formParameterRules.invalid" >Adicionar regra</button> -->
    </dss-dialog-footer>

  </dss-dialog>





=============================================================================================
import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { DssSortChangeInterface } from '@dss/components/data-table';

import { OrquestradorMotoresService } from '../../../service/orquestrador-motores/orquestrador-motores.service';
import { IDataSource } from './iDataSource';
import { Router } from '@angular/router';
import { RuleCommunicationService } from 'src/app/service/orquestrador-motores/rule-communication.service';

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

    public activeDataSource: any;
    public inactiveDataSource: any;
    files: any;
    msgErro: any;

    formParameterRules: FormGroup;


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
        private formBuilder: FormBuilder,
        private router: Router,
        private ruleCommunicationService: RuleCommunicationService,
    ) {}

    ngOnInit(): void {
        this.getActiveRules();

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

        //Assinar evento de criação da regra
        this.ruleCommunicationService.ruleCreated$.subscribe(()=>{
            //Atualizar a lista de regras após criar a regra
            this.getActiveRules();
            this.getInactiveRules();
        });
    }

    createForm(parameterRules: IDataSource) {
        this.formParameterRules = this.formBuilder.group({

            channelName: [parameterRules.channelName, [Validators.required]],
            primarySegmentCode: [parameterRules.primarySegmentCode,[Validators.required]],
            secondarySegmentCode: [parameterRules.secondarySegmentCode,[Validators.required, Validators.minLength(6),Validators.maxLength(6) ]],
            fopa: [parameterRules.fopa,[Validators.required]],
            clusterRisk: [parameterRules.clusterRisk, [Validators.required]],
            riskGroup: [parameterRules.riskGroup, [Validators.required]],
            modalityCode: [parameterRules.modalityCode, [Validators.required]],
            effectiveDate: [parameterRules.effectiveDate, [Validators.required]],
            endDateValidity: [parameterRules.endDateValidity, [Validators.required]],


        });
    }

    onSubmit() {
        if (this.formParameterRules.valid) {
          const formData = this.formParameterRules.value;

          this.orquestradorMotoresService.saveNewRule(formData).subscribe(
            (res) => {
              // Atualizar a lista de regras após criar a nova regra
              this.getActiveRules();
              this.router.navigate(['/lista-regras']); // Navegar para a página de listagem de regras
                //fechar o modal
                this.open=false;
            },
            (err) => {
              this.msgErro = err.message;
            }
          );
        }
      }

    public getActiveRules() {
        this.orquestradorMotoresService.getOrchestradorActiveRules().subscribe(
            (res) => {

                this.activeDataSource = res._content;

                console.log("dataSource", this.activeDataSource);
            },
            (err) => {
                this.msgErro = err.message;
            }
        );
    }
    public getInactiveRules() {
        this.orquestradorMotoresService.getOrchestradorInactiveRules().subscribe(
            (res) => {

                this.inactiveDataSource = res._content;

                console.log("dataSource: Regras Inativas", this.inactiveDataSource);
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




}
--------------------------------------------
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

  ---------------------------------------------

  import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable, of } from 'rxjs';
import { catchError, debounceTime, retry, switchMap } from 'rxjs/operators';
import { IDataSource } from 'src/app/componentes/orquestrador-motores/regras-parametrizacao/iDataSource';
import { urlConfig } from 'src/app/config/url.config';
import { CriptografiaService } from 'src/app/service/criptografia/criptografia.service';

@Injectable({
  providedIn: 'root'
})
export class OrquestradorMotoresService {

    private readonly activeRules = 'urlConfig.getActiveRulesOrchestrator';
    private readonly inactiveRules = 'urlConfig.getInactiveRulesOrchestrator';
    dataSource: IDataSource[];

constructor(
    private http: HttpClient,
    private criptoService: CriptografiaService
) { }

/*Lista regras ativas*/

getOrchestradorActiveRules(): Observable<any>{
    return this.http.get(urlConfig.getActiveRulesOrchestrator).pipe(

        debounceTime(2000),
        switchMap((response)=>{
            return of(response);
        }),
        retry(2),
        catchError((err) =>{
            throw new Error(err);
        })

    );

}
/*Lista regras inativas*/

getOrchestradorInactiveRules(): Observable<any>{
    return this.http.get(urlConfig.getInactiveRulesOrchestrator).pipe(

        debounceTime(2000),
        switchMap((response)=>{
            return of(response);
        }),
        retry(2),
        catchError((err) =>{
            throw new Error(err);
        })

    );

}

saveNewRule(ruleData: any): Observable<any>{
    const apiURL = 'urlConfig.saveRulesOrchestrator';
    return this.http.post(apiURL,ruleData).pipe(
        retry(2),
        catchError((err)=>{
            throw new Error(err)
        })
    )

}

}

----------------------------------
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


