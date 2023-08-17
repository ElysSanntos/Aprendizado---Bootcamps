 ID 	 Modalidade 	 Idade máxima para validar o prazo 	 Idade + prazo restante (cota) 	  
col.key: id
161	col.key: modality
[object Object]	col.key: maxAge
col.key: maxAgeCote
col.key: isEdit

col.key: id
153	col.key: modality
[object Object]	col.key: maxAge
col.key: maxAgeCote
col.key: isEdit

col.key: id
148	col.key: modality
[object Object]	col.key: maxAge
col.key: maxAgeCote
col.key: isEdit

col.key: id
166	col.key: modality
[object Object]	col.key: maxAge
col.key: maxAgeCote
col.key: isEdit






=====import { HttpClient } from "@angular/common/http";
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


        this.createFormAge({
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
                console.log("Pegando dados da API", res);
                this.ageDataSource = res._content;
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
---------------------------
<section class="container">

    <span class="title__page">Regras Idade por Modalidade</span>

    <dss-segment-control class="segment-control">
        <dss-segment-control-item class="segment-control__item__active">


            <dss-segment-control-item-content >
                <!-- Tabelas -->
                <dss-data-table [dataSource]="ageDataSource._content">
                    <table>
                        <ng-container *ngFor="let col of columnsSchema">
                            <th class="center-th" *dssHeaderCell>
                                {{ col.label }}
                            </th>
                            <td class="center-td" *dssCell="let element">
                                ageDataSource: {{ageDataSource | json}}

                                col.key: {{col.key}}
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
                                    <span *ngSwitchCase = "'object'">{{element[col.key].modalityCode }}</span>
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


