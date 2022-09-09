#include <stdio.h>
#include <stdlib.h>

int main()
{
   int numero = 0;
   printf("Digite o numero da tabuada: ");
   scanf("%d", &numero);
   int i = 9;
   for(i=0;i<=10;i++)
    {
       printf("\n%d X %d = %d", numero, i, numero *i );
   }
    return 0;
}
