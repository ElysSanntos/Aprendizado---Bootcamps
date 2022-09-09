#include <stdio.h>
#include <stdlib.h>

int main()
{
    char opcao;
printf("Usuário, você é maior de idade?");
scanf("%s", &opcao);
switch (opcao) {
    case ‘S’:
        printf("Usuário maior de idade");
        break;
    case ‘N’:
        printf("Usuário menor de idade");
        break;
    default:
        printf("Opção inválida");
        break;
}
    return 0;
}
