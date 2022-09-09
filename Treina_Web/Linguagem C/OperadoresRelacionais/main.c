#include <stdio.h>
#include <stdlib.h>

int main()
{
    int numero = 0;
    printf("Digite um numero: ");
    scanf("%d",&numero);

    printf("%d e >  que 10? %d\n",numero,numero >  10);
    printf("%d e >= que 10? %d\n",numero,numero >= 10);
    printf("%d e <  que 10? %d\n",numero,numero <  10);
    printf("%d e <= que 10? %d\n",numero,numero <= 10);
    printf("%d e == que 10? %d\n",numero,numero == 10);
    printf("%d e != que 10? %d\n",numero,numero != 10);


    return 0;
}
