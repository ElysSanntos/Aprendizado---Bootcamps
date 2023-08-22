 return  activeRules$.pipe(
            mergeMap(this.activeRules =>{
                return inactiveRules$.pipe(
                    map(this.inactiveRules =>({ this.activeRules, this.inactiveRules}))
                );
            })
        );

        Nenhuma sobrecarga corresponde a esta chamada.
  A sobrecarga 1 de 3, '(project: (value: string, index: number) => ObservableInput<any>, concurrent?: number): OperatorFunction<string, any>', gerou o seguinte erro.
    O argumento do tipo 'string' não é atribuível ao parâmetro do tipo '(value: string, index: number) => ObservableInput<any>'.
  A sobrecarga 2 de 3, '(project: (value: string, index: number) => ObservableInput<any>, resultSelector: undefined, concurrent?: number): OperatorFunction<string, any>', gerou o seguinte erro.
    O argumento do tipo 'string' não é atribuível ao parâmetro do tipo '(value: string, index: number) => ObservableInput<any>'.
  A sobrecarga 3 de 3, '(project: (value: string, index: number) => ObservableInput<any>, resultSelector: (outerValue: string, innerValue: any, outerIndex: number, innerIndex: number) => any, concurrent?: number): OperatorFunction<...>', gerou o seguinte erro.
    O argumento do tipo 'string' não é atribuível ao parâmetro do tipo '(value: string, index: number) => ObservableInput<any>'.ts(2769)




--------------------
O argumento do tipo 'string[]' não é atribuível ao parâmetro do tipo '(value: [string, string], index: number) => { activeRules: string; inactiveRules: string; }'.ts(2345)
return forkJoin([activeRules$,inactiveRules$]).pipe(
            map(([this.activeRules,this.inactiveRules]) => ({
                this.activeRules, this.inactiveRules
            }))
        );

-------

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

    apiMessage: string = "";
    activeApiMessage: string = '';
    inactiveApiMessage: string = '';

    private readonly activeRules = 'urlConfig.getActiveRulesOrchestrator';
    private readonly inactiveRules = 'urlConfig.getInactiveRulesOrchestrator';
    dataSource: IDataSource[];

constructor(
    private http: HttpClient,
    private criptoService: CriptografiaService,

) { }

ngOnInit(): void {
   this.fetchApiMessages();

}

getApiMessage(): Observable<{ activeRules: string; inactiveRules: string}>{

    const activeRules$ = this.http.get<string>(activeApiURL).pipe(
        catchError(this.handleError));

    const inactiveRules$ = this.http.get<string>(inactiveApiURL).pipe(
        catchError(this.handleError));
    }



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

fetchApiMessages(): void{

    this.getApiMessage().subscribe(
        (response) =>{
            this.activeApiMessage = response.activeRules;
            this.inactiveApiMessage = response.inactiveRules;
        },
        (error) => {
            console.error('Erro na chamada à API: ', error);
            this.activeApiMessage = 'Erro ao obter mensagens para regras ativas.'
            this.inactiveApiMessage = 'Erro ao obter mensagens para regras inativas.'
        }
        );
    }


}

}
------------------------------
Erros:
declaração não utilizada:
 private readonly activeRules = 'urlConfig.getActiveRulesOrchestrator';
    private readonly inactiveRules = 'urlConfig.getInactiveRulesOrchestrator';


    A function whose declared type is neither 'undefined', 'void', nor 'any' must return a value.ts(2355)
    const activeRules$ = this.http.get<string>(activeApiURL).pipe(
        catchError(this.handleError));

    const inactiveRules$ = this.http.get<string>(inactiveApiURL).pipe(
        catchError(this.handleError));
    }



---------------html
 <td class="center-td" *dssCell="let element">
                                <div>
                                    <p>{{ apiMessage }}</p>
                                </div>
                                <!-- Linhas padrões -->
                                <div
                                    [ngSwitch]="col.type"
                                    *ngIf="!element.isEdit"
