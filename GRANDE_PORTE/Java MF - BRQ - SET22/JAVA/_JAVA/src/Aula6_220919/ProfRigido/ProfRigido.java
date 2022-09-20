package Aula6_220919.ProfRigido;

import java.util.Scanner;

public class ProfRigido {

	public static void main(String[] args) {
		Scanner lerTeclado = new Scanner(System.in);
		
		System.out.print("Entre n1....: ");
		double n1 = Double.parseDouble(lerTeclado.nextLine());
		System.out.print("Entre n2....: ");
		double n2 = Double.parseDouble(lerTeclado.nextLine());
		
		double m = ( n1 + n2 ) / 2.0;
		String situ;
		
		if(m < 5) {
			situ = "Reprovado";
		} 
		else {
			situ = "Aprovado";
		}
		
		System.out.println(situ + " com media " + m);
		lerTeclado.close();
	}

}