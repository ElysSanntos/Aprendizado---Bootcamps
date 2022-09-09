#include <stdio.h>
#include <stdlib.h>

int main()
{
    //DECLARAÇÃO DO VETOR
    int numerosDigitados[10];

    //PREENCHENDO O VETOR
    for(int i = 0; i<=9; i++)
    {
       printf("Digitar um numero: ");
       scanf("%d", &numerosDigitados[i]);
    }
    // LER OS VALORES DO VETOR

    printf("Os numeros digitados foram: \n");
    for(int i = 0; i<=9; i++)
    {
        printf("%d\n", numerosDigitados[i]);
    }
    return 0;
}
