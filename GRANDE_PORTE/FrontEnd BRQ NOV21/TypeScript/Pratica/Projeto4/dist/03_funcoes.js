"use strict";
function somar(x, y) {
    return x + y;
}
let myAdd = function (x, y) {
    console.log('A soma VOID  é:' + x + y);
    console.log(`A soma ANY é : ${x + y}`);
};
let myAny = function (x, y) {
    console.log("A soma ANY MyAdd é: " + x + y);
};
function imprimirNomeCompleto(nome, meio, sobrenome) {
    let nomeCompleto;
    if (sobrenome) {
        nomeCompleto = nome + ' ' + meio + ' ' + sobrenome;
    }
    else {
        nomeCompleto = nome + ' ' + meio;
    }
    console.log(nomeCompleto);
    return nomeCompleto;
}
imprimirNomeCompleto('Elys', 'Sanntos');
somar(10, 20);
myAdd(1, 2);
