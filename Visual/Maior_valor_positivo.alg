

algoritmo "Maior Valor Positivo"
var
   num, maior: inteiro
inicio
      maior <- -1
      leia(num)
      enquanto (num>=0) faca
         se (num>maior) entao
            maior<-num
         fimse
         leia(num)
      fimenquanto
      se (maior<0) entao
         escreval("Não foi digitado um valor maior que zero.")
      senao
         escreval("O maior valor digitado é ", maior)
      fimse
fimalgoritmo

