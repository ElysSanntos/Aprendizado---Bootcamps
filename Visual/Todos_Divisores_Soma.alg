algoritmo "Todos_Divisores_Soma"
// Função :Solicita um número inteiro POSITIVO e escreva em tela a SOMA dos divisores dele.
// Autor :  Elys_Sanntos
// Data : 01/03/2020

var
num,contador,resto,soma: inteiro

inicio
contador <- 1
resto <- 0
soma:= soma+resto

      Escreva("Digite um numero: ")
      Leia(num)


repita
escreva(contador)
se(num mod contador = 0) entao
resto := resto + 1
fimse
     contador <- contador + 1
     ate (contador > num)
     escreva(" Número: " ,resto)
     escreva(" A soma dos divisores de: ",num," é: ",soma)

fimalgoritmo
