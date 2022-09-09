#include <stdio.h>
#include <stdlib.h>

int main()
{
    int essenciais,prioridades,estiloDeVida = 0;
    printf("Digite o valor de gastos essenciais: \n");
    scanf("%d", &essenciais);
    printf("Digite o valor de gastos prioritários: \n");
    scanf("%d", &prioridades);
    printf("Digite o valor de gastos com Estilo de vida: \n");
    scanf("%d", &estiloDeVida);

    int mediaEssenciais = (essenciais*0,50)/100;
    int mediaPrioridades = (prioridades*0,15)/100;
    int mediaEstiloDeVida = (estiloDeVida*0,35)/100;


    if(mediaEssenciais <= 50)
    {
       printf("\nGastos essenciais: dentro da regra");
    }else
    {
         printf("\nGastos essenciais: acima da regra\n");
    }
    if(mediaPrioridades <= 15)
    {
        printf("\nPrioridades financeiras: dentro da regra");
    }else
    {
         printf("\nGastos financeiros: acima da regra\n");
    }
    if(mediaEstiloDeVida <= 35)
    {
        printf("\nEstilo de vida: acima da regra");
    }else
    {
         printf("\nGastos Estilo de vida: acima da regra\n");
    }
    return 0;
}
