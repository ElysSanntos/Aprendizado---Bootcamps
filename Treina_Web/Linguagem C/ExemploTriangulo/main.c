#include <stdio.h>
#include <stdlib.h>

int main()
{
    int a, b, c;
    printf("Informe o lado A: ");
    scanf("%d", &a);
    printf("Informe o lado B: ");
    scanf("%d", &b);
    printf("Informe o lado C: ");
    scanf("%d", &c);

    if((a == b )&& (b==c))
    {
        printf("\nO tringulo eh equilatero\n");
    }else if((a!=b)&&(b!=c)&&(a !=c))
    {
        printf("\nO tringulo eh escaleno\n");
    }else
    {
        printf("\nO triangulo eh Esoseles\n");
    }
    return 0;
}
