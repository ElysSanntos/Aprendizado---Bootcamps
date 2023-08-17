<section class="container">

    <span class="title__page">Regras Idade por Modalidade</span>

    <dss-segment-control class="segment-control">
        <dss-segment-control-item class="segment-control__item__active">


            <dss-segment-control-item-content >
                <!-- Tabelas -->
                <<ng-container *ngIf = "ageDataSource">

                <dss-data-table [dataSource]="ageDataSource._content">
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
                                    <ng-container [ngSwitch]="col.key">

                                    <span *ngSwitchCase = " 'modality' ">{{ element[col.key]?.modalityCode }}</span>
                                    <span *ngSwitchCase = " 'maxAge' ">{{ element[col.key] }}</span>
                                    <span *ngSwitchCase = " 'maxAgeCote' ">{{element[col.key] }}</span>
                                    <span *ngSwitchDefault>{{ element[col.key] }}</span>
                                </ng-container>

                                </div>
                            </td>
                        </ng-container>
                    </table>
                    <dss-pagination optionDefault="10"></dss-pagination>
                    </dss-data-table>
                </ng-container>


            </dss-segment-control-item-content>
        </dss-segment-control-item >



    </dss-segment-control>

    <!-- {{ element[col.key]}} -->


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

![image](https://github.com/ElysSanntos/Aprendizado---Bootcamps/assets/62489007/5fdf0982-1a9d-4dd0-a5f2-f7309549e6eb)
