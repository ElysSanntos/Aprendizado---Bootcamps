import { HttpClient, HttpErrorResponse } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable, of, throwError } from 'rxjs';
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
            console.log('listagem das regras ativas');
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
    console.log('Chamando o metodo regras inativas do metodo getOrchestradorInactiveRules');
    return this.http.get(urlConfig.getInactiveRulesOrchestrator).pipe(


        debounceTime(2000),
        switchMap((response)=>{
            console.log('listagem das regras inativas');
            return of(response);

        }),
        retry(2),

        catchError((err) =>{
            console.log('listagem de Erros regras inativas');
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

private handleError(error: HttpErrorResponse){
    let errorMessage = "Ocorreu um erro";
    if (error.error instanceof ErrorEvent){
        errorMessage = 'Error: ${error.error.message}';
    }else{
        errorMessage = 'Error Code: ${error.status}\nMessage: ${error.message}';
    }
    console.error(errorMessage);
    return throwError(errorMessage);
}

}


---------------------------
{
    "traceId": null,
    "errors": [
        {
            "field": null,
            "message": null,
            "code": 404,
            "_code": 404,
            "_field": null,
            "_message": null
        }
    ],
    "timestamp": null,
    "message": "Não foi possível localizar as regras no banco de dados.",
    "errorCode": 404,
    "details": "HTTP operation failed invoking https://yz.paas.santanderbr.pre.corp/yz-consortium-orchestrator-group/api/v1/rules/find-all/N with statusCode: 404",
    "_errorCode": 404,
    "_message": "Não foi possível localizar as regras no banco de dados.",
    "_details": "HTTP operation failed invoking https://yz.paas.santanderbr.pre.corp/yz-consortium-orchestrator-group/api/v1/rules/find-all/N with statusCode: 404",
    "_timestamp": null,
    "_traceId": null,
    "_errors": [
        {
            "field": null,
            "message": null,
            "code": 404,
            "_code": 404,
            "_field": null,
            "_message": null
        }
    ]
}


---------------------------------------------------------
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
------------------------------------------
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

------------------------------------
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
    static primarySecondaryCodeValidators: any;


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
        console.log('Chamando o metodo regras inativas getInactiveRules()');
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

        //Assinar evento de criação da regra
        this.ruleCommunicationService.ruleCreated$.subscribe(()=>{
            //Atualizar a lista de regras após criar a regra
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

                console.log("dataSource Regras Ativas", this.activeDataSource);
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

                console.log("dataSource Regras Inativas", this.inactiveDataSource);
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
--------------------------------------------------
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
-----------------------------------------
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
      <button type="submit"[disabled]="!formParameterRules.valid" dssFilledButton buttons-group__newRule>Adicionar regra</button>


      <!-- <button [routerLink]="['/web']" dssFilledButton [disabled]="formParameterRules.invalid" >Adicionar regra</button> -->
    </dss-dialog-footer>


  </dss-dialog>
