#include <stdio.h>
#include <stdlib.h>

int main()
{
    float areaConstruida, areaTotal = 0;

    printf("Qual a area Total do terreno? ");
    scanf("%f",&areaTotal);

    printf("Qual a area construida? ");
    scanf("%f",&areaConstruida);

    float areaNaoConstruida = areaTotal - areaConstruida;
    float impostoAreaConstruida = 5 * areaConstruida;
    float impareaNaoConstruida = 3.80 * areaNaoConstruida;
    float impostoTotal = impostoAreaConstruida + impareaNaoConstruida;
    printf("\nO imposto total a ser pago eh R$%2.2f\n\n",impostoTotal);

    return 0;
}
