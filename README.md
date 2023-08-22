import { Component, OnInit } from "@angular/core";
import { FormBuilder, FormGroup, Validators } from "@angular/forms";
import { DssSortChangeInterface } from "@dss/components/data-table";

import { OrquestradorMotoresService } from "../../../service/orquestrador-motores/orquestrador-motores.service";
import { IDataSource } from "./iDataSource";
import { Router } from "@angular/router";
import { RuleCommunicationService } from "src/app/service/orquestrador-motores/rule-communication.service";

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

        //Assinar evento de criação da regra
        this.ruleCommunicationService.ruleCreated$.subscribe(() => {
            //Atualizar a lista de regras após criar a regra
            this.getActiveRules();
            this.getInactiveRules();
        });
    }

    // Função para criar formulário

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

    // função para manipular o envio do formulário
    onSubmit() {
        if (this.formParameterRules.valid) {
            const formData = this.formParameterRules.value;

            this.orquestradorMotoresService.saveNewRule(formData).subscribe(
                (res) => {
                    // Atualizar a lista de regras após criar a nova regra
                    this.getActiveRules();

                    //fechar o modal
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
    // função para obter regras inativas
    public getInactiveRules() {
        this.orquestradorMotoresService
            .getOrchestradorInactiveRules()
            .subscribe(
                (res) => {
                    this.inactiveDataSource = res._content;

                    console.log(
                        "dataSource Regras Inativas",
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
