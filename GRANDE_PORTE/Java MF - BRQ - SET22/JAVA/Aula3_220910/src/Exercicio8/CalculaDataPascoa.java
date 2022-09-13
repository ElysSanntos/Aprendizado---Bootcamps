package Exercicio8;

/*O Dia da P�scoa, por defini��o, � o primeiro Domingo ap�s a lua cheia que ocorre ap�s o equin�cio 
 * vernal, e pode cair entre 22 de Mar�o e 25 de Abril. A seq��ncia dos dias de P�scoa se repete em 
 * ciclos de aproximadamente 5.700.000 anos. As f�rmulas existentes calculam o que se convencionou 
 * chamar de "C�lculo Eclesi�stico", quando em 325 o Conc�lio de Nicea assim definiu.
 O Carnaval acontece 47 dias antes da P�scoa. Logo o Carnaval pode acontecer de 4 de fevereiro a 9 de 
 mar�o.
 Corpus Christi acontece 60 dias depois da P�scoa. Logo Corpus Christi pode acontecer de 21 de maio at�
  24 de junho.
 Existem diversas f�rmulas para a determina��o do Domingo de P�scoa, entretanto uma das mais simples � a 
 f�rmula de Gauss, descrita a seguir:
 Para calcular o dia da P�scoa (Domingo), usa-se a f�rmula abaixo (F�rmula de Gauss em 1750), onde o 
 ANO deve ser introduzido com 4 d�gitos. O Operador MOD � o resto da divis�o. A f�rmula vale para anos 
 entre 1901 e 2099. A f�rmula pode ser estendida para outros anos, alterando X e Y conforme a tabela a 
 seguir (criada por Gauss at� 1999 e estendida pelo autor at� 2299):*/

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
				
				System.out.println("Em "+ ANO + " ,a P�coa ser� no dia: " + DIA +"/" + MES);

	}
	


}
