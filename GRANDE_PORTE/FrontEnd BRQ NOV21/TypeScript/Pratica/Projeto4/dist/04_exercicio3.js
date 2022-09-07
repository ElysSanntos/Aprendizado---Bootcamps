"use strict";
/*Criei uma função para calcular o desconto que um cliente terá.​
O primeiro parâmetro é o valor da compra. O segundo parametro será o valor  do desconto.​
Se o valor a pagar com desconto for entre 90 reais e 100 reais, o cliente terá  mais um desconto de 5%.​
Se o valor a pagar com desconto for maior que 100 reais, o cliente terá mais  um desconto de 10%.​
Apresente o valor que o cliente irá pagar*/
function blackFraudi(valorCompra, valorDescontoInicial) {
    var valorTotal = valorCompra - valorDescontoInicial;
    var valorDescontoInicial = 0;
    var valorAdicional = 0;
    if (valorTotal > 90 && valorTotal <= 100) {
        valorAdicional = 0.05 * valorTotal;
    }
    else if (valorTotal > 100) {
        valorAdicional = 0.1 * valorTotal;
        console.log(`O valor final da compra é: ${valorTotal}`);
    }
    return valorAdicional;
}
blackFraudi(460, 100);
