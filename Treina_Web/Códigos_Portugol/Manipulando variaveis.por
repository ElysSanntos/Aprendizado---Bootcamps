programa
{
	
	funcao inicio()
	{
		real distanciaTotal
		real distanciaPercorrida
		real velocidade 
		escreva("Digite distancia total para chegar ao seu destino: ")
		leia(distanciaTotal)
		escreva("Digite distancia já percorrida:  ")
		leia(distanciaPercorrida)
		escreva("Digite a sua velocidade (km/h):  ")
		leia(velocidade)

		//Qual a distancia falta a ser percorrida - para depois descobrir o tempo que ainda resta
		real distanciaaSerPercorrida = (distanciaTotal - distanciaPercorrida)

		//Vamos calcular o tempo - relação entre o tempo e a distancia
		real horasRestantes = (distanciaaSerPercorrida / velocidade)

		escreva("Faltam ",horasRestantes, " horas para que termine o percurso")
		
	}
}
/* $$$ Portugol Studio $$$ 
 * 
 * Esta seção do arquivo guarda informações do Portugol Studio.
 * Você pode apagá-la se estiver utilizando outro editor.
 * 
 * @POSICAO-CURSOR = 334; 
 * @PONTOS-DE-PARADA = ;
 * @SIMBOLOS-INSPECIONADOS = ;
 * @FILTRO-ARVORE-TIPOS-DE-DADO = inteiro, real, logico, cadeia, caracter, vazio;
 * @FILTRO-ARVORE-TIPOS-DE-SIMBOLO = variavel, vetor, matriz, funcao;
 */