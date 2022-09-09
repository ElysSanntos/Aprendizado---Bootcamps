#include <stdio.h>
#include <stdlib.h>

int main()
{

    int idade;
    printf("Digite a sua idade: ");
    scanf("%d",&idade);//& cria um ponteiro para mesma posição de memoria da variavel idade
    printf("Você tem %d anos.",idade);
    return 0;
}
