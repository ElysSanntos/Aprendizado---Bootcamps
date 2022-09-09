programa
{
	
	funcao inicio()
	{
		//Permite a analise de duas ou mais expressoes que retornem um dado logico

		inteiro n1
		inteiro n2
		escreva("Entre com dois números e vamos avaliar se é maior que 10 \n")
		escreva("Digite o primeiro número: ")
		leia(n1)

		escreva("Digite o segundo número: ")
		leia(n2)

		logico E = n1 > 10 e n2 > 10
		logico OU = n1 > 10 ou n2 > 10
		escreva("Resultado E: ",n1, " e ", n2," são maiores que 10? : ",E,"\n")
		escreva("Resultado OU: ",n1, " ou ", n2," são maiores que 10? : ",OU,"\n")
	}
}
/* $$$ Portugol Studio $$$ 
 * 
 * Esta seção do arquivo guarda informações do Portugol Studio.
 * Você pode apagá-la se estiver utilizando outro editor.
 * 
 * @POSICAO-CURSOR = 526; 
 * @PONTOS-DE-PARADA = ;
 * @SIMBOLOS-INSPECIONADOS = ;
 * @FILTRO-ARVORE-TIPOS-DE-DADO = inteiro, real, logico, cadeia, caracter, vazio;
 * @FILTRO-ARVORE-TIPOS-DE-SIMBOLO = variavel, vetor, matriz, funcao;
 */