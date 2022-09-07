import estudante from './02_estudante';

let vetorNumeros:Array<number> = [1,2,3];
let vetorStrings: Array<string> = [];
let outroVetor: Array<number> = [10,20,30,10,90,0,60,77];

vetorNumeros.splice(2,1, ...outroVetor);
console.log(vetorNumeros);

let Elys: estudante = {
    nome:"Elys",
    email: "elys@email.com.br",
    matricula: "RA: 123456",
    idade: 18
}
let vetorEstudantes: Array<estudante> = [];
vetorEstudantes.push(Elys);
vetorStrings.push("Otávio");

let vetorEstudantesEgressos: estudante[] = [];

function imprimirElementoVetor(vetor: any): void{
    for(let i = 0;i<vetor.length;i++){
        console.log(vetor[i]);
    }
}
function imprimirElementosVetorV2(vetor:estudante[]):void {
    vetor.forEach(function(e){
        console.log(e);
    })

}


imprimirElementoVetor(vetorNumeros)
imprimirElementosVetorV2(vetorEstudantes)
imprimirElementoVetor(vetorStrings);

