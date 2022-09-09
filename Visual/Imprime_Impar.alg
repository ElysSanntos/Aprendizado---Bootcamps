algoritmo "Escre_Impar"
// Função :Solicita dois valores inteiros e escreva em tela os números impares entre eles.
// Autor :   Elys_Sanntos
// Data : 01/03/2020

var
valor1,valor2: inteiro

inicio

Escreval("Digite o primeiro numero: ")
Leia(valor1)
Escreval("Digite o segundo numero: ")
Leia(valor2)

se(valor1 mod 2 = 1) ENTAO
   Escreval( "O primeiro numero digitado:",valor1," é um numero Impar.")
fimse
   se(valor1 = 0) entao
      escreval("O primeiro numero digitado foi Zero, insira um valor válido!")
   fimse
   
      se(valor2 mod 2 = 1) ENTAO
         Escreval(" O segundo numero digitado:",valor2," é um numero Impar.")
      senao
         se(valor2 = 0) entao
            escreval(" O segundo numero digitado foi Zero, insira um valor válido!")



      fimse


   fimse

fimalgoritmo
