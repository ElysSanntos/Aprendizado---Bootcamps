programa
{
	
	funcao inicio()
	{
		inteiro numero
		escreva("Digite um numero, para sabermos se ele é primo: ")
		leia(numero)
		inteiro qtdDivisores = 0
		para(inteiro i = 1; i<=numero; i++){
			se(numero % i == 0){
				qtdDivisores++
			}
		}
		se(qtdDivisores == 2){
			escreva("Numero, ",numero," é primo!")
		}
		senao{
			escreva("Numero, ",numero," NÃO é primo!")
		}
	}
}
/* $$$ Portugol Studio $$$ 
 * 
 * Esta seção do arquivo guarda informações do Portugol Studio.
 * Você pode apagá-la se estiver utilizando outro editor.
 * 
 * @POSICAO-CURSOR = 114; 
 * @PONTOS-DE-PARADA = ;
 * @SIMBOLOS-INSPECIONADOS = ;
 * @FILTRO-ARVORE-TIPOS-DE-DADO = inteiro, real, logico, cadeia, caracter, vazio;
 * @FILTRO-ARVORE-TIPOS-DE-SIMBOLO = variavel, vetor, matriz, funcao;
 */