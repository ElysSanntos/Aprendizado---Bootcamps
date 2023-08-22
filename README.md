<section class="container">
    <span class="title__page">Regras de Parametrização</span>

    <!-- segment-control 1 -->
    <dss-segment-control class="segment-control">
        <dss-segment-control-item class="segment-control__item__active">
            <dss-segment-control-item-header
                >Regras ativas</dss-segment-control-item-header
            >

            <dss-segment-control-item-content>
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
                                            (click)="edit(element)"
                                        >
                                            <span
                                                dssIcon
                                                name="subscription"
                                            ></span>
                                        </button>
                                    </div>
                                    <span *ngSwitchCase="'object'">{{
                                        element[col.key][col.keyObject]
                                    }}</span>
                                    <span *ngSwitchDefault>{{
                                        element[col.key]
                                    }}</span>
                                </div>
                            </td>
                        </ng-container>
                    </table>

                    <!-- Mensagens de erro -->
                    <div *ngIf="msgErro" class="error-message">
                        Ocorreu um erro: {{ msgErro }}
                    </div>

                    <!-- Paginação -->

                    <dss-pagination optionDefault="10"></dss-pagination>
                </dss-data-table>
            </dss-segment-control-item-content>
        </dss-segment-control-item>

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
                            <td class="center-td" *dssCell="let element">
                                <!-- Linhas padrões -->
                                <div
                                    [ngSwitch]="col.type"
                                    *ngIf="!element.isEdit"
                                >
                                    <!-- Botões -->
                                    <div *ngSwitchCase="'isEdit'">
                                        <!-- Botão editar -->
                                        <button dssIconButton disabled>
                                            <span
                                                dssIcon
                                                name="subscription"
                                            ></span>
                                        </button>
                                    </div>

                                    <span *ngSwitchCase="'object'">{{
                                        element[col.key][col.keyObject]
                                    }}</span>
                                    <span *ngSwitchDefault>{{
                                        element[col.key]
                                    }}</span>
                                </div>
                            </td>
                        </ng-container>
                    </table>
                    <div *ngIf="msgErro" class="error-message">
                        Ocorreu um erro: {{ msgErro }}
                    </div>

                    <dss-pagination optionDefault="5"></dss-pagination>
                </dss-data-table>
            </dss-segment-control-item-content>
        </dss-segment-control-item>
    </dss-segment-control>

    <spaui-preloader id="preLoader"></spaui-preloader>

    <div class="buttons-group-rules">
        <button dssOutlineButton class="buttons-group__download">
            Baixar regras
        </button>
        <button
            dssFilledButton
            class="buttons-group__newRule"
            dssButton
            (click)="open = true"
        >
            Nova regra
        </button>
    </div>
</section>

<!-- Modal para Create e Edit -->

<dss-dialog [open]="open">
    <dss-dialog-header>
        <div class="title__dialog">Nova Regra</div>
        <span class="text__dialog"
            >Preencha todos os campos para adição de nova regra</span
        >
    </dss-dialog-header>

    <dss-dialog-body>
        <app-formulario
            [formParameterRules]="formParameterRules"
        ></app-formulario>
    </dss-dialog-body>

    <dss-dialog-footer>
        <hr dssDivider />

        <button dssOutlineButton (click)="open = false" buttons-group__download>
            Cancelar
        </button>
        <button
            type="submit"
            [disabled]="!formParameterRules.valid"
            dssFilledButton
            buttons-group__newRule
        >
            Adicionar regra
        </button>

        <!-- <button [routerLink]="['/web']" dssFilledButton [disabled]="formParameterRules.invalid" >Adicionar regra</button> -->
    </dss-dialog-footer>
</dss-dialog>
-----------------------
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

  getActiveRules(): Observable<IDataSource[]> {
    return this.http.get<IDataSource[]>(urlConfig.getActiveRulesOrchestrator).pipe(
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
-----------------------------
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
-----------------------------------
import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup } from '@angular/forms';
import { Router } from '@angular/router';
import { RuleCommunicationService } from 'src/app/service/orquestrador-motores/rule-communication.service';

import { OrquestradorMotoresService } from '../../../service/orquestrador-motores/orquestrador-motores.service';
import { IDataSource } from './iDataSource';

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
    public activeDataSource: IDataSource[];
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

    ngOnInit(): void {
        this.getActiveRules();
        console.log("Chamando o metodo regras inativas getInactiveRules()");
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

    public getActiveRules() {
        this.orquestradorMotoresService.getActiveRules().subscribe(
            (res) => {
                this.activeDataSource = res;
                console.log("getActiveRules", this.activeDataSource);
            },
            (err) => {
                this.msgErro = err.message;
            }
        );
    }

    public getInactiveRules() {
        this.orquestradorMotoresService
            .getInactiveRules()
            .subscribe(
                (res) => {
                    this.inactiveDataSource = res._content;
                    console.log(
                        "getInactiveRules",
                        this.inactiveDataSource
                    );
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
-----------------------
import { Component, OnInit } from "@angular/core";
import { DssSortChangeInterface } from "@dss/components/data-table";
import { OrquestradorMotoresService } from "../../service/orquestrador-motores/orquestrador-motores.service";

export interface DataSourceInterface {
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

@Component({
    selector: "app-orquestrador-motores",
    templateUrl: "./orquestrador-motores.component.html",
    styleUrls: ["./orquestrador-motores.component.scss"],
})
export class OrquestradorMotoresComponent implements OnInit {
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
        private orquestradorMotoresService: OrquestradorMotoresService
    ) {}

    ngOnInit(): void {
        this.getActiveRules();
        this.getInactiveRules();
    }

    public getActiveRules() {

        this.orquestradorMotoresService.getActiveRules()
         .subscribe((res) =>{
             console.log("Regras Ativas", res)
             this.dataSource = res;
             console.log("REgras Ativas: ", this.dataSource)
         },
         (err) =>{
             this.msgErro = err.message;
         })
     }
    public getInactiveRules() {

        this.orquestradorMotoresService.getInactiveRules()
         .subscribe((res) =>{
             console.log("Regras Inativas", res)
             this.dataSource = res._content;
         },
         (err) =>{
             this.msgErro = err.message;
         })
     }

    public columnsSchema: Array<any> = [
        {
            key: "ruleId",
            type: "string",
            label: "ID",
        },
        {
            key: "channelName",
            type: "string",
            label: "Canal Vendas",
        },
        {
            key: "modalityCode",
            type: "string",
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

    public removeRow(ruleId) {
        this.dataSource = this.dataSource.filter((u: { ruleId: string; }) => u.ruleId !== ruleId);
    }

    public addRow() {
        const newRow =
        {
            ruleId: "string",
            channelName: "string",
            primarySegmentCode: "string",
            secondarySegmentCode: "string",
            riskGroup: "string",
            fopa: "string",
            clusterRisk: "string",
            modalityCode: "string",
            effectiveDate: "date",
            endDateValidity: "date",
            isEdit: true,
        };
        this.dataSource = [...this.dataSource, newRow];
    }
}
