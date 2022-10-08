package Parte04_Exercicio07_Pag215;

import java.util.Scanner;

/*Escreva e teste um m�todo robusto que imprime um string de prompt, l� 
 * interativamente um inteiro e o devolve. Use um tratador de exce��o. O 
 * programa de teste deve reproduzir o seguinte comportamento frente a 
 * estes dados de entrada:
 * Digite um inteiro: sete
		Este n�o � um inteiro num�rico
		Digite um inteiro: ok
		Este n�o � um inteiro num�rico
		Digite um inteiro: 123.45
		Este n�o � um inteiro num�rico
		Digite um inteiro: 123
		Voc� digitou 123.*/

public class Robusto {
	
	public static void main(String[] args) {
		int n = pegaInteiro();
		System.out.println("Voce digitou " + n + ".");
	}
	
	public static int pegaInteiro() {
		Scanner ze = new Scanner(System.in);
		int n = 0;
		boolean deuErro = true;
		
		while(deuErro) {
			System.out.print("Digite um inteiro: ");
			try {
				
				n = Integer.parseInt(ze.nextLine());
				deuErro = false;
				
			}catch(Exception e){
				
				System.out.println("Este n�o � um inteiro numerico, tente novamente: ");
				
			}
		}
				
		ze.close();
		return n;
	}
}
