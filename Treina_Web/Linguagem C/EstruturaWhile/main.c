#include <stdio.h>
#include <stdlib.h>
#include <string.h>

int main()
{
    char nome = "";

    while(strcmp(&nome,"PARAR") !=0 )
    {
        printf("Digite o nome: \n");
        scanf("%s", &nome);
        printf("\nOla, %s\n", &nome);
    }

    return 0;
}
