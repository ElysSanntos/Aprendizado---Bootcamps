#include <stdio.h>
#include <stdlib.h>

int main()
{
   int vet[5];
   int numero, alteracoes = 0;

   //LER O VETOR
   for(int i = 0; i <5; i++)
   {
       printf("Digite um numero para entrar no vetor: ");
       scanf("%d", &numero); //Guarda o numero lido
       vet[i] = numero;
   }

   // ESCREVER O QUE FOI DIGITADO, ANTES DA ORDENA��O
   printf("Vetor antes da ordena��o: \n");
   for(int i = 0; i<5; i++)
   {
       numero = vet[i];
       printf("%d\n", numero);
   }
   //IMPLEMENTAR O ALGORITMO


   alteracoes = 1; // N�O PODE COME�AR EM ZERO, PORQUE ZERO N�O SER� MAIOR QUE ZERO, E OBRIGAMOS A ENTRAR AO MENOS UMA VEZ
   int temporario = 0;
   while(alteracoes > 0)
   {
       // VAMOS VARRER O VETOR E COMPARAR AS POSI��ES
       alteracoes = 0; // vai guardar a posi��o de i ou de i+1--Preciso sempre zerar as altera��es para n�o entrar em loop infinito
       for(int i = 0; i <4; i++)//N�o pode ser igual a 5, pq chega um momento que fa�o a compara��o de i+1
     {
           if(vet[i] > vet[i +1]) //Verificar se o numero que est� na posi��o i
                                  //� maior do que o numero que est� na posi��o i + 1(lembrando que o vetor inicia no zero), e a posi��o 5 n�o existe
        {

               temporario = vet[i];
               vet[i] = vet[i + 1];// fazendo a substitui��o do numero na posi��o do vetor
               vet[i + 1] = temporario; // pego o valor guardado no temporario e devolvo para a posi��o i+1
               alteracoes ++;//Ent�o se foi realizada uma altera��o, eu preciso incrementar a altera��o, o que me leva ao while()
        }
       }
   }
   // RESULTADO DA ORDENA��O

   printf("Resultado da ordenacao: \n\n");
   for(int i = 0; i<5; i++)
   {
       numero = vet[i];
       printf("%d\n", numero);
   }

    return 0;
}
