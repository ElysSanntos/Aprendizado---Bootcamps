package br.com.elys.java_io.teste;

import java.io.File;
import java.util.Arrays;
import java.util.Locale;
import java.util.Scanner;

public class TesteLeituraScannerParsingLocale{

	public static void main(String[] args) throws Exception {

		Scanner scanner = new Scanner(new File("contas.csv"));
				
		while (scanner.hasNextLine()) {
			String linha = scanner.nextLine();
			System.out.println(linha);
			
			/*Analisar cada linha separadamente, é preciso criar uma nova instância do Scanner e 
			 * receber como parametro uma linha(source)*/
			
			Scanner linhaScanner = new Scanner(linha);
			
			/*Ao compilar, encontramos a execeção:
			 * Exception in thread "main" java.util.InputMismatchException
			 * Meu SO é Pt-BR e o parsing utilizado com (210.1)ponto,que é um padrão americano, 
			 * Para equacionar vamos utilizar o código local abaixo:*/
			
			linhaScanner.useLocale(Locale.US);
			
			/*Agora precisamos que o Scanner capture cada dado separando/delimitado por vírgula o devolva*/
			
			linhaScanner.useDelimiter(",");
			
			/*Acessando o Scanner através de métodos de mais alto nível*/
			
			String valor1 = linhaScanner.next();
			int valor2 = linhaScanner.nextInt();
			int valor3 = linhaScanner.nextInt();
			String valor4 = linhaScanner.next();
			double valor5 = linhaScanner.nextDouble();
			
			
			System.out.println(valor1 +valor2 +valor3 +valor4 +valor5);
			
			linhaScanner.close();			
		} 

		scanner.close();
	}

}
