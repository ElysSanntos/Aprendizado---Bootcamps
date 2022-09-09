algoritmo "Positivo_Exibe_Todos_Primos"
// Função :solicite um número inteiro POSITIVO e escreva em tela todos os números PRIMOS entre 1 e o número digitado.
// Autor :  Elys_Sanntos
// Data : 01/03/2020

var
num,cont,j,i:inteiro
inicio
Escreva("Digite um numero POSITIVO: ")
leia(num)
//testar quantos divisores o num tem
         //Cont quantas  divisoes exatas 0 numero é dividido por outro

         cont:= 0
         i:=  2
         j:= 1
         
                enquanto
                   i<=num faca
                   enquanto j<=i faça
                            se(i mod = 0)entao
                            cont:= cont + 1
                            fimse
                                 j:= j+ 1
                   fimenquanto
                   se(cont = 2)entao
                   escreval(i)
                   fimse
                        i:=i+1
                        j:= 1
                        cont:= 0
                   fimenquanto
fimalgoritmo
