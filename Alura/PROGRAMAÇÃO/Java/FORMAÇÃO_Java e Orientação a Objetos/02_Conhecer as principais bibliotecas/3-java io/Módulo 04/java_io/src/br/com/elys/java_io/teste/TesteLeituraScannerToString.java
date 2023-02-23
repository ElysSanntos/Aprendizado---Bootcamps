package br.com.elys.java_io.teste;

import java.io.File;
import java.util.Arrays;
import java.util.Scanner;

public class TesteLeituraScannerToString {

	public static void main(String[] args) throws Exception {

		Scanner scanner = new Scanner(new File("contas.csv"));
		
		
		
	while (scanner.hasNextLine()) {
		
		
		String linha = scanner.nextLine();
		System.out.println(linha);
		
		/*Separando os valores que vem em cada linha
		 * Separando um String em pequenos pedaços, nesse caso, vamos separar por vírgula.*/
		
//		String[] valores = linha.split(",");
//		System.out.println(valores);
//		
//		//O resultado([Ljava.lang.String;@5dfcfece), não é legivel. 
		
			/*Então precisamos usar uma classe auxiliar que irá transformar o Array em String legivel
			 * Retorno: ([CC, 22, 33, Nico Steppat, 210.1]) */
			String[] valores = linha.split(",");
			System.out.println(Arrays.toString(valores));
	} 

		scanner.close();
	}

}
