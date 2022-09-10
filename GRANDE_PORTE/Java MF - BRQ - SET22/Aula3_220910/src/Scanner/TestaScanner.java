package Scanner;

import java.util.Scanner;

public class TestaScanner {

	public static void main(String[] args) {
		
		

		// criando um objeto Scanner e informando que
		// receber� dados via teclado (System.in)
		Scanner lerTeclado = new Scanner(System.in);

		// Pedindo um n�mero inteiro para o usu�rio
		System.out.print("Informe um n�mero : ");
		int num = lerTeclado.nextInt();
		System.out.print("N�mero = " + num);
	
		// criando uma String para ser lida com Scanner
		 String frase = "O peito do p� de pedro � preto";
		 
		 // receber� dados via frase, palavra por palavra
		 Scanner lerFrase = new Scanner(frase);

		 // Exibindo as palavras separadas por espa�o
		 System.out.println(lerFrase.next());
		 System.out.println(lerFrase.next());
		 System.out.println(lerFrase.next());
	}
		 
		  private static void clearBuffer(Scanner scanner) {
		        if (scanner.hasNextLine()) {
		            scanner.nextLine();
		        }

	}

}
