#include <stdio.h>
#include <stdlib.h>

int main()
{
    float total= 0;
    int codigos[3] = {3,1,2};
    int quantidades[3] = {1,4,1};
    int qtdLinhas= 0;
    int produtos[3] = {1,2,3};


for(int i = 0; i < qtdLinhas; i++)
{
    printf("Digite o código do produto: \n");
    int produtos = 0;
    scanf("%d", &produtos);

    switch (produtos[i])
    {
       case 1:
         total = total + (quantidades[i] * 3.80);
         printf("Leite Integral x %d - %2.2f\n", quantidades[i], quantidades[i] * 3.80);
       break;

       case 2:
         total = total + (quantidades[i] * 5.98);
         printf("Manteiga x %d - %2.2f\n", quantidades[i], quantidades[i] * 5.98);
       break;

       case 3:
         total = total + (quantidades[i] * 8.25);
         printf("Café 500g x %d - %2.2f\n", quantidades[i], quantidades[i] * 8.25);
       break;

       default:
        printf("Produto nao cadastrado");
        break;
    }
}

printf("Total - %4.2f", total);
    return 0;
}
