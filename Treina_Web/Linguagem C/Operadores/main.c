#include <stdio.h>
#include <stdlib.h>

int main()
{
    int a,b;
    printf("Digite o valor do primeiro numero: ");
    scanf("%d", &a);
    printf("Digite o valor do segundo numero: ");
    scanf("%d", &b);


    printf("A Soma de:  %d + %d = %d ",a,b,a+b);
    printf("\nA Subtra��o de %d - %d = %d ",a,b,a-b);
    printf("\nA Multiplica��o de %d * %d = %d ",a,b,a*b);
    printf("\nA Divis�o de %d / %d = %d ",a,b,a/b);
    printf("\nA O resto de %d mod %d = %d ",a,b,a%b);

    return 0;
}
