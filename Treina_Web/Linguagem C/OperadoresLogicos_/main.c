#include <stdio.h>
#include <stdlib.h>

int main()
{

    int a,b;
    printf("Digite o valor para a variavel a: \n");
    scanf("%d",a);
    printf("Digite o valor para a variavel b: \n");
    scanf("%d",b);


    printf("%d > 10  E  %d >20? %d\n",a,b,a > 10 && b > 20);
    printf("%d > 10  OU %d >20? %d\n",a,b,a > 10 || b > 20);
    printf("NAO%d > 10  E  %d >20?%d\n",a,b,!(a > 10 && b > 20));
    printf("NAO%d > 10  OU %d >20? %d\n",a,b,!(a > 10 || b > 20));

    return 0;
}
