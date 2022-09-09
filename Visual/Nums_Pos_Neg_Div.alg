algoritmo "Nums_Pos_Neg_Div"
// Função :
// Autor :
// Data : 02/03/2020
// Seção de Declarações 
var

num, soma, divisor: inteiro


inicio



    escreva("Você verá a soma dos")
    escreva(" divisores de um número.")
//divisor  := 1

  Repita
    escreva("Digite um número positivo")
    leia(num);

    se(num <= 0) então
        escreva ("Número inválido.")
        escreva (" Digite um número positivo.")
  Até (num > 0)
fimrepita

  enquanto (divisor <= num) faça 
      início 
        se (divisor MOD num = 0) Entao
            início
              soma := soma + divisor
              divisor : = divisor + 1
            fim

        SENAO 
            divisor : = divisor + 1
      fim

    escreva("A soma dos divisores")
    escreva(" deste número é ")
    escreva(soma)

fimalgoritmo

fimalgoritmo
