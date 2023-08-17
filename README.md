<section class="container">

    <span class="title__page">Regras Idade por Modalidade</span>

    <dss-segment-control class="segment-control">
        <dss-segment-control-item class="segment-control__item__active">

            <dss-segment-control-item-content >
                <dss-data-table [dataSource]="ageDataSource">
                    <table>
                        <ng-container *ngFor="let col of columnsSchema">
                            <th class="center-th" *dssHeaderCell>
                                {{ col.label }}
                            </th>
                            <td class="center-td" *dssCell="let element">
                                <div [ngSwitch]="col.key" *ngIf="!element.isEdit">
                                    <div *ngSwitchCase="'isEdit'">
                                        <button
                                            dssIconButton
                                            (click)="edit(element)"
                                        >
                                            <span dssIcon name="subscription"></span>
                                        </button>
                                    </div>
                                    <ng-container *ngSwitchDefault>
                                        {{ element[col.key] }}
                                    </ng-container>
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
        <button dssOutlineButton class="buttons-group__download">Baixar regras</button>
        <button dssFilledButton class="buttons-group__newRule" dssButton (click)="open = true">Nova regra</button>
    </div>

</section>

<dss-dialog [open]="open">
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
    </dss-dialog-footer>
</dss-dialog>
