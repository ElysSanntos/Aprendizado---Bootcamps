#include <stdio.h>
#include <stdlib.h>

int main()
{
    char opcao;
printf("Usu�rio, voc� � maior de idade?");
scanf("%s", &opcao);
switch (opcao) {
    case �S�:
        printf("Usu�rio maior de idade");
        break;
    case �N�:
        printf("Usu�rio menor de idade");
        break;
    default:
        printf("Op��o inv�lida");
        break;
}
    return 0;
}
