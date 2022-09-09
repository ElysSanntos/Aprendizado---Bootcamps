#include <stdio.h>
#include <stdlib.h>

int main()
{
    float dolar = 0;
    float real = 3.85;

    printf("Qual o valor em U$ deseja converter para R$? ");
    scanf("%f", &dolar);

    real = real * dolar;

    printf("O valor convertido eh R$  %4.2f",real);

    return 0;
}
