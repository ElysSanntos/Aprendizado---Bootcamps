import { HttpClient, HttpErrorResponse } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable, forkJoin, of, throwError } from 'rxjs';
import { catchError, debounceTime, map, mergeMap, retry, switchMap } from 'rxjs/operators';
import { IDataSource } from 'src/app/componentes/orquestrador-motores/regras-parametrizacao/iDataSource';
import { urlConfig } from 'src/app/config/url.config';
import { CriptografiaService } from 'src/app/service/criptografia/criptografia.service';
import { Rule } from './rule';
import { ApiService } from './api.service';

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
    private apiService: ApiService,
    private criptoService: CriptografiaService,

) { }

ngOnInit(): void {
   this.fetchApiMessages();

}

getApiMessage(): Observable<{ activeRules: string; inactiveRules: string}>{

    const activeRules$ = this.http.get<string>(this.activeRules).pipe(
        catchError(this.handleError));

    const inactiveRules$ = this.http.get<string>(this.inactiveRules).pipe(
        catchError(this.handleError));

        return  activeRules$.pipe(
            mergeMap(activeRules =>{
                return inactiveRules$.pipe(
                    map(inactiveRules =>({ activeRules, inactiveRules}))
                );
            })
        );
    }



/*Lista regras ativas*/

getActiveRules(): Observable<Rule[]>{

    return this.http.get(urlConfig.getActiveRulesOrchestrator).pipe(

        debounceTime(2000),
        switchMap((response)=>{
            console.log('listagem das regras ativas');
            return of(response);

        }),
        retry(2),
        catchError((err) =>{
            const errorMessage = 'Ocorreu um erro ao buscar as regras ativas'
            return throwError(errorMessage);
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
            const errorMessage = 'Ocorreu um erro ao buscar as regras inativas'
            return throwError(errorMessage);
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


