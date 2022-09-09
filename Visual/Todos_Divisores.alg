algoritmo "Todos_Divisores_Soma"
// Função :Solicita um número inteiro POSITIVO e escreva em tela a SOMA dos divisores dele.
// Autor :  Elys_Sanntos
// Data : 01/03/2020

var
num,i,resto: inteiro

inicio
      Escreva("Digite um numero: ")
      Leia(num)
               para
               i<- ate num faca
               resto <- num mod i
               Se(resto=0)entao
               escreva(i," é o numero divisor",num)
               fimse
               fimpara

fimalgoritmo
