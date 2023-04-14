package br.com.elys.java_io.teste;

import java.io.File;
import java.util.Arrays;
import java.util.Scanner;

public class TesteLeituraScannerSplit {

	public static void main(String[] args) throws Exception {

		Scanner scanner = new Scanner(new File("contas.csv"));
		
		
		
	while (scanner.hasNextLine()) {
		
		
		String linha = scanner.nextLine();
		System.out.println(linha);
		
		
			String[] valores = linha.split(",");
			/*Extrair as informações especificas*/
			System.out.println(valores[3]);
	} 

		scanner.close();
	}

}
