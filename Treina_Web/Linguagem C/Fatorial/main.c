#include <stdio.h>
#include <stdlib.h>

int main()
{
int i, n = 0;
int fat = 1;
printf("Qual valor deseja fatorar? ");
scanf("%d",n);

i = n;
while(i >= 1)
{
    fat *= i;
    i--;
}
    printf("O fatorial de %d eh: %d", n, fat);
    return 0;
}
