"use strict";
Object.defineProperty(exports, "__esModule", { value: true });
let vetorNumeros = [1, 2, 3];
let vetorStrings = [];
let outroVetor = [10, 20, 30, 10, 90, 0, 60, 77];
vetorNumeros.splice(2, 1, ...outroVetor);
console.log(vetorNumeros);
let Elys = {
    nome: "Elys",
    email: "elys@email.com.br",
    matricula: "RA: 123456",
    idade: 18
};
let vetorEstudantes = [];
vetorEstudantes.push(Elys);
vetorStrings.push("Otávio");
let vetorEstudantesEgressos = [];
function imprimirElementoVetor(vetor) {
    for (let i = 0; i < vetor.length; i++) {
        console.log(vetor[i]);
    }
}
function imprimirElementosVetorV2(vetor) {
    vetor.forEach(function (e) {
        console.log(e);
    });
}
imprimirElementoVetor(vetorNumeros);
imprimirElementosVetorV2(vetorEstudantes);
imprimirElementoVetor(vetorStrings);
