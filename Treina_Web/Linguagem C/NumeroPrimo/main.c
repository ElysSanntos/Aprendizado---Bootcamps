#include <stdio.h>
#include <stdlib.h>
#include <locale.h>

int main()
{
setlocale(LC_ALL, "");
int num,  resultado = 0;

 printf("Digite um n�mero: ");
 scanf("%d", &num);

 for (int i = 2; i <= num / 2; i++) {
    if (num % i == 0) {
       resultado++;
       break;
    }
 }

 if (resultado == 0)
    printf("\n%d � um n�mero primo\n", num);
 else
    printf("\n%d n�o eh um n�mero primo\n", num);
    return 0;
}
