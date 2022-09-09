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

   // ESCREVER O QUE FOI DIGITADO, ANTES DA ORDENAÇÃO
   printf("Vetor antes da ordenação: \n");
   for(int i = 0; i<5; i++)
   {
       numero = vet[i];
       printf("%d\n", numero);
   }
   //IMPLEMENTAR O ALGORITMO


   alteracoes = 1; // NÃO PODE COMEÇAR EM ZERO, PORQUE ZERO NÃO SERÁ MAIOR QUE ZERO, E OBRIGAMOS A ENTRAR AO MENOS UMA VEZ
   int temporario = 0;
   while(alteracoes > 0)
   {
       // VAMOS VARRER O VETOR E COMPARAR AS POSIÇÕES
       alteracoes = 0; // vai guardar a posição de i ou de i+1--Preciso sempre zerar as alterações para não entrar em loop infinito
       for(int i = 0; i <4; i++)//Não pode ser igual a 5, pq chega um momento que faço a comparação de i+1
     {
           if(vet[i] > vet[i +1]) //Verificar se o numero que está na posição i
                                  //é maior do que o numero que está na posição i + 1(lembrando que o vetor inicia no zero), e a posição 5 não existe
        {

               temporario = vet[i];
               vet[i] = vet[i + 1];// fazendo a substituição do numero na posição do vetor
               vet[i + 1] = temporario; // pego o valor guardado no temporario e devolvo para a posição i+1
               alteracoes ++;//Então se foi realizada uma alteração, eu preciso incrementar a alteração, o que me leva ao while()
        }
       }
   }
   // RESULTADO DA ORDENAÇÃO

   printf("Resultado da ordenacao: \n\n");
   for(int i = 0; i<5; i++)
   {
       numero = vet[i];
       printf("%d\n", numero);
   }

    return 0;
}
