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
                                <div>
                                    <p>{{ activeApiMessage }}</p>
                                </div>

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
                                <div>
                                    <p>{{ inactiveApiMessage }}</p>
                                </div>
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


![image](https://github.com/ElysSanntos/Aprendizado---Bootcamps/assets/62489007/fae64fe0-f3e4-4120-ba7c-dc94c1f5d1a2)
