package Parte04_Exercicio07_Pag215;

import java.util.Scanner;

/*Escreva e teste um método robusto que imprime um string de prompt, lê 
 * interativamente um inteiro e o devolve. Use um tratador de exceção. O 
 * programa de teste deve reproduzir o seguinte comportamento frente a 
 * estes dados de entrada:
 * Digite um inteiro: sete
		Este não é um inteiro numérico
		Digite um inteiro: ok
		Este não é um inteiro numérico
		Digite um inteiro: 123.45
		Este não é um inteiro numérico
		Digite um inteiro: 123
		Você digitou 123.*/

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
				
				System.out.println("Este não é um inteiro numerico, tente novamente: ");
				
			}
		}
				
		ze.close();
		return n;
	}
}
