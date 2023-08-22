import { HttpClient } from '@angular/common/http';
import { Component, Input, OnInit } from '@angular/core';
import { FormGroup, Validators, FormBuilder } from '@angular/forms';
import { Router } from '@angular/router';
import { DssOptionInterface } from '@dss/components';
import { urlConfig } from 'src/app/config/url.config';

import { IDataSource, IDataSourceAge } from '../regras-parametrizacao/iDataSource';
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

  public optionChannel: Array<DssOptionInterface> = [
    // ... (rest of your optionChannel values)
  ];

  public optionModality: Array<DssOptionInterface> = [
    // ... (rest of your optionModality values)
  ];

  public optionCluster: Array<DssOptionInterface> = [
    // ... (rest of your optionCluster values)
  ];

  public optionRisk: Array<DssOptionInterface> = [
    // ... (rest of your optionRisk values)
  ];

  public optionFOPA: Array<DssOptionInterface> = [
    // ... (rest of your optionFOPA values)
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

  ngOnInit(): void {
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

  onSubmit(): void {
    if (this.formParameterRules.valid) {
      this.http
        .post<ResponseType>(this.addRules, this.formParameterRules.value)
        .subscribe(
          (response) => {
            console.log("Regra adicionada com Sucesso: ", response);
            this.formParameterRules.reset();
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

  isError(controlName: string): boolean {
    const input = this.formParameterRules.get(controlName);
    return input !== null && input.invalid && input.dirty && input.touched;
  }

  isSuccess(controlName: string): boolean {
    const input = this.formParameterRules.get(controlName);
    return input !== null && input.valid && input.dirty && input.touched;
  }

  get editingTitle(): string {
    return this.editingRule ? "Editar Regra" : "Nova Regra";
  }

  get editingSubtitle(): string {
    return this.editingRule
      ? "Edite os campos abaixo para atualizar a regra existente."
      : "Preencha os campos abaixo para criar uma nova regra.";
  }

  getChannelIdFromName(channelName: string): string {
    return this.channels[channelName] || "";
  }

  getModalityIdFromCode(modalityId: string): string {
    return this.modalities[modalityId] || "";
  }
}

