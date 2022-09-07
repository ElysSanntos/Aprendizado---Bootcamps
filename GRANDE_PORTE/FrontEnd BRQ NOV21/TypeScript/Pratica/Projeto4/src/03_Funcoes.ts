function somar(x: number, y:number):number{
    return x+y;
}

let myAdd = function(x:number,y:number): void{
    console.log('A soma VOID  é:' + x + y);
    console.log(`A soma ANY é : ${x+y}`);
}
let myAny = function (x: number, y: number): any {
  console.log("A soma ANY MyAdd é: " + x + y);
  
}
function imprimirNomeCompleto(nome: string, meio: string, sobrenome?: string):string{
    let nomeCompleto: string;
    if(sobrenome){
        nomeCompleto = nome + ' ' + meio +' '+ sobrenome;
    }else{
        nomeCompleto = nome +' '+ meio;
    }
    console.log(nomeCompleto);
    return nomeCompleto;
}
imprimirNomeCompleto('Elys','Sanntos')

somar(10,20);
myAdd(1,2);