#include <stdio.h>
#include <stdlib.h>

int main()
{
    printf("Digite o codigo de barras\n");
    int codigoBarras = 0;
    scanf("%d", &codigoBarras);

    switch(codigoBarras)
    {
    case 1:
        printf("Leite integral - 3,80");
        break;
    case 2:
        printf("Manteiga - 5,98");
        break;
    case 3:
        printf("Café 500g - 8,25");
        break;
    default:
        printf("Produto nao cadastrado\n");
        break;
    }
    return 0;
}
