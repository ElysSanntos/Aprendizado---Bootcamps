#include <stdio.h>
#include <stdlib.h>

int main()
{
    float p1, p2, p3, tf;
    printf("Digite a Nota da P1: \n");
    scanf("%f", &p1);
    printf("Digite a Nota da P2: \n");
    scanf("%f", &p2);
    printf("Digite a Nota da P3: \n");
    scanf("%f", &p3);
    printf("Digite a Nota do TF: \n");
    scanf("%f", &tf);

    float media =  (p1+(p2*3)+(p3*3)+tf)/7;



    if(media < 6)
    {
        printf("\nMedia D \n");
    }
    if(media >= 6 && media < 7.5)
    {
        printf("\nMedia C \n");
    }
    if(media >=7.5 && media < 9)
    {
        printf("\nMedia B \n");
    }
    if (media >=9)
    {
        printf("\nMedia A \n");
    }
    return 0;
}
