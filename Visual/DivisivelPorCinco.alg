algoritmo "DivisivelPorCinco"
// Função :solicite um número inteiro POSITIVO e verifique se esse número é divisível por 5.
// Autor :  Elys_Sanntos
// Data : 01/03/2020

var

   NumPos, resto: inteiro

inicio
   Escreva("Digite um número Positivo: ")
   Leia(NumPos)
   
   resto:= NumPos mod 5
               Se(resto = 0)  Entao
               Escreva(NumPos," é divisivel por 5;")
               senao
               escreva(NumPos," não é divisivel por 5;")
               fimse
   


fimalgoritmo
