package Aula6_220919.MenorAltura;

import java.util.Scanner;

public class MenorAltura {

	public static void main(String[] args) {
		
			double menorAltura = Double.POSITIVE_INFINITY;
			String menorNome = "";
			int contador = 0;
			Scanner ze = new Scanner(System.in);
			
			do {
				System.out.print("Entre nome.........: ");
				String nome = ze.nextLine();
				System.out.print("Entre altura.......: ");
				double altura = Double.parseDouble(ze.nextLine());
				
				if(altura < menorAltura) {
					menorAltura = altura;
					menorNome = nome;
				}
				
				contador = contador + 1;
			} while(contador < 3);
			
			System.out.println("A pessoa com menor altura é: ");
			System.out.println("Nome..........: " + menorNome);
			System.out.println("Altura..: " + menorAltura);
			
			ze.close();

	}

}
