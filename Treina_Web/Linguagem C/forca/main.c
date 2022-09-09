#include <stdio.h>
#include <string.h>

int main() {


    char palavrasecreta[20];

    sprintf(palavrasecreta, "MELANCIA");


    do {

        char chute;
        scanf("%c", &chute);
        int acertou = 0;
        int enforcou = 0;

        for(int i = 0; i < strlen(palavrasecreta); i++) {
            if(palavrasecreta[i] == chute) {
                printf("A posicao %d tem essa letra!\n", i);

            }

        }

        } while(!acertou && !enforcou);

}
