#include <stdio.h>
#include <stdlib.h>

int main()
{


    float rendaFamilias[0];
    float media,maior, menor, soma;
    soma = 0;
    maior = 0;
    menor = rendaFamilias[0];
    int qtdFamilias = 0;

    printf("Digite a soma de renda das familias: ");
    scanf("%f",soma);
    printf("Digite a quantidade de familias pesquisadas: ");
    scanf("%d",qtdFamilias);

    for(int i = 0; i < qtdFamilias; i++)
    {
        soma = soma + rendaFamilias[i];
        if(rendaFamilias[i] > maior)
        {
            maior = rendaFamilias[i];
        }
        if (rendaFamilias[i] < menor)
        {
            menor = rendaFamilias[i];
        }
    }
    media = soma / qtdFamilias;

    printf("Media - %4.2f\n", media);
    printf("Maior - %4.2f\n", maior);
    printf("Menor - %4.2f", menor);

    return 0;
}
