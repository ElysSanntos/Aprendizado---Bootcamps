#include <stdio.h>
#include <stdlib.h>

int main()
{
    float acumulado, juros;
    int qtdAportes = 0; // definir a quantidade meses que deve calcular
    float valorAporte[0]; // serão investidos a cada mês
    float porcentagemJuros = 0.5;

    printf("Qual o valor do investimento: ");
    scanf("%f", &valorAporte);


juros = porcentagemJuros / 100;
acumulado = 0;

for(int i = 0; i < qtdAportes; i++)
{
    acumulado = acumulado + (juros * acumulado);

    acumulado = acumulado + valorAporte[i];
}

printf("valor acumulado = %4.2f", acumulado);
    return 0;
}
