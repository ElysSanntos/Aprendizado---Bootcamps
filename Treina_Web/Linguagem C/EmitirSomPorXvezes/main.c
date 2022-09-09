#include <stdio.h>
#include <stdlib.h>

int main()
{
    int x;
    printf("Escreva a quantidade de repeticoes: ");
    scanf("%d", &x);

    for(int i = 0; i< x; i++)
    {
        printf("\n         MIAU...\n ");
    }
    return 0;
}
