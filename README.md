 <td class="center-td" *dssCell="let element">
                               DATASource: {{ageDataSource | json}}
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
