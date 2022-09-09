#include <stdio.h>
#include <stdlib.h>

int main()
{
    float comprimento, altura = 0.0;


    printf("Digite o comprimento do retangulo: ");
    scanf("%f", &comprimento);

    printf("Digite a altura do retangulo: ");
    scanf("%f", &altura);

    float area = comprimento * altura ;
    float perimetro = 2 * comprimento + 2 * altura;

    printf("\nA area do retangulo eh: %2.2f \nO perimetro do retangulo eh: %2.2f\n\n",area,perimetro);


    return 0;
}
