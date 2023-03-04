package br.com.elys.java_io.teste;

import java.io.File;
import java.util.Arrays;
import java.util.Scanner;

public class TesteLeituraScannerDelimiter{

	public static void main(String[] args) throws Exception {

		Scanner scanner = new Scanner(new File("contas.csv"));
				
		while (scanner.hasNextLine()) {
			String linha = scanner.nextLine();
			System.out.println(linha);
			
			/*Analisar cada linha separadamente, é preciso criar uma nova instância do Scanner e 
			 * receber como parametro uma linha(source)*/
			
			Scanner linhaScanner = new Scanner(linha);
			
			/*Agora precisamos que o Scanner capture cada dado separando/delimitado por vírgula o devolva*/
			
			linhaScanner.useDelimiter(",");
			
			/*Acessando o Scanner através de métodos de mais alto nível*/
			
			String valor1 = linhaScanner.next();
			String valor2 = linhaScanner.next();
			String valor3 = linhaScanner.next();
			String valor4 = linhaScanner.next();
			String valor5 = linhaScanner.next();
			
			
			System.out.println(valor1 +valor2 +valor3 +valor4 +valor5);
			
			linhaScanner.close();			
		} 

		scanner.close();
	}

}
