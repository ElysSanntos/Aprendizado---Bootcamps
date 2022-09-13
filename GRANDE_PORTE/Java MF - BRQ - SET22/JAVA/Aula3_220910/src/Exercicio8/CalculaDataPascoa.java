package Exercicio8;

/*O Dia da Páscoa, por definição, é o primeiro Domingo após a lua cheia que ocorre após o equinócio 
 * vernal, e pode cair entre 22 de Março e 25 de Abril. A seqüência dos dias de Páscoa se repete em 
 * ciclos de aproximadamente 5.700.000 anos. As fórmulas existentes calculam o que se convencionou 
 * chamar de "Cálculo Eclesiástico", quando em 325 o Concílio de Nicea assim definiu.
 O Carnaval acontece 47 dias antes da Páscoa. Logo o Carnaval pode acontecer de 4 de fevereiro a 9 de 
 março.
 Corpus Christi acontece 60 dias depois da Páscoa. Logo Corpus Christi pode acontecer de 21 de maio até
  24 de junho.
 Existem diversas fórmulas para a determinação do Domingo de Páscoa, entretanto uma das mais simples é a 
 fórmula de Gauss, descrita a seguir:
 Para calcular o dia da Páscoa (Domingo), usa-se a fórmula abaixo (Fórmula de Gauss em 1750), onde o 
 ANO deve ser introduzido com 4 dígitos. O Operador MOD é o resto da divisão. A fórmula vale para anos 
 entre 1901 e 2099. A fórmula pode ser estendida para outros anos, alterando X e Y conforme a tabela a 
 seguir (criada por Gauss até 1999 e estendida pelo autor até 2299):*/

public class CalculaDataPascoa {

	public static void main(String[] args) {

				int ANO = 2022;
				int permanecer    = ANO % 19;
				int primeiroDigito   = ANO / 100;
				int c   = ANO % 100;
				int d   = primeiroDigito / 4;
				int e   = primeiroDigito % 4;
				int f   = (primeiroDigito + 8) / 25;
				int g   = (primeiroDigito - f + 1) / 3;
				int h   = (19 * permanecer  + primeiroDigito - d - g + 15) % 30;
				int i   = c / 4;
				int j   = c % 4;
				int k   = (32 + 2 * e + 2 * i - h - j) % 7;
				int L   = (permanecer  + 11 * h + 22 * k) / 451;
				int MES = (h + k - 7 * L + 114) / 31;
				int DIA = ((h + k - 7 * L + 114) % 31) + 1;
				
				System.out.println("Em "+ ANO + " ,a Pácoa será no dia: " + DIA +"/" + MES);

	}
	


}
