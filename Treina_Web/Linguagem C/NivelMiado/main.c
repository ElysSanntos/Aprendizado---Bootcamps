#include <stdio.h>
#include <stdlib.h>

int main()
{
    int nivelMiado = 1;
    while(nivelMiado != 0)
    {
        printf("\n\nInforme o nivel do miado: ");
        scanf("%d", &nivelMiado);

        printf("M");
        for(int i = 0; i< nivelMiado;i++)
        {
            printf("i");
        }
        printf("AU");
    }
    return 0;
}
