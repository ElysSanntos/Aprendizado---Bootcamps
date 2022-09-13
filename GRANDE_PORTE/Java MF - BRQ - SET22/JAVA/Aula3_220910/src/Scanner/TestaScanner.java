package Scanner;

import java.util.Scanner;

public class TestaScanner {

	public static void main(String[] args) {
		
		

		// criando um objeto Scanner e informando que
		// receberá dados via teclado (System.in)
		Scanner lerTeclado = new Scanner(System.in);

		// Pedindo um número inteiro para o usuário
		System.out.print("Informe um número : ");
		int num = lerTeclado.nextInt();
		System.out.print("Número = " + num);
	
		// criando uma String para ser lida com Scanner
		 String frase = "O peito do pé de pedro é preto";
		 
		 // receberá dados via frase, palavra por palavra
		 Scanner lerFrase = new Scanner(frase);

		 // Exibindo as palavras separadas por espaço
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
