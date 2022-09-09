#include <stdio.h>
#include <stdlib.h>

int main()
{
int qtdeParcelas = 0;
float  porcentagem, parcelaInicial,porcentagemDecrecimo;
float parcela = parcelaInicial;

printf("Digite o valor da parcela inicial: ");
scanf("%f", &parcelaInicial);

printf("Digite a porcentagem de decremento das parcelas: ");
scanf("%f", &porcentagemDecrecimo);
porcentagem = (100 - porcentagemDecrecimo) / 100;

printf("Digite a quantidade de parcelas: ");
scanf("%d", &qtdeParcelas);

for(int contador=1;contador<=qtdeParcelas;contador++)
{
    printf("%d - %4.2f\n", contador, parcela);
    parcela = (parcela * porcentagem);
}

    return 0;
}
