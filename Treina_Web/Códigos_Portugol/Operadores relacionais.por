programa
{
	
	funcao inicio()
	{
		inteiro n1
		inteiro n2
		
		escreva("Digite o primeiro número: ")
		leia(n1)

		escreva("Digite o segundo número: ")
		leia(n2)

		//Operadores relacionais SEMPRE  retornanam uma expressão booleana

		logico  maior = n1 > n2
		logico menor = n1< n2
		logico igual = n1==n2
		logico menorIgual = n1<= n2
		logico maiorIgual = n1>= n2
		logico diferente = n1!=n2


		escreva(n1, " > " ,n2, " = ", maior,"\n")
		escreva(n1, " < " ,n2, " = ", menor,"\n")
		escreva(n1, " = " ,n2, " = ", igual,"\n")
		escreva(n1, " <= " ,n2, " = ", menorIgual,"\n")
		escreva(n1, " >= " ,n2, " = ", maiorIgual,"\n")
		escreva(n1, " != " ,n2, " = ", diferente, "\n")

	}
}
/* $$$ Portugol Studio $$$ 
 * 
 * Esta seção do arquivo guarda informações do Portugol Studio.
 * Você pode apagá-la se estiver utilizando outro editor.
 * 
 * @POSICAO-CURSOR = 685; 
 * @PONTOS-DE-PARADA = ;
 * @SIMBOLOS-INSPECIONADOS = ;
 * @FILTRO-ARVORE-TIPOS-DE-DADO = inteiro, real, logico, cadeia, caracter, vazio;
 * @FILTRO-ARVORE-TIPOS-DE-SIMBOLO = variavel, vetor, matriz, funcao;
 */