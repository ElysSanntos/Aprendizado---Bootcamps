package br.com.elys.java_io.teste;

import java.io.File;
import java.util.Arrays;
import java.util.Locale;
import java.util.Scanner;

public class TesteLeituraScannerFormatação{

	public static void main(String[] args) throws Exception {

		Scanner scanner = new Scanner(new File("contas.csv"));
				
		while (scanner.hasNextLine()) {
			String linha = scanner.nextLine();
//			System.out.println(linha);
		
			Scanner linhaScanner = new Scanner(linha);
			
			linhaScanner.useLocale(Locale.US);
			
			linhaScanner.useDelimiter(",");
						
			String tipoConta = linhaScanner.next();
			int agencia = linhaScanner.nextInt();
			int conta = linhaScanner.nextInt();
			String titular = linhaScanner.next();
			double saldo = linhaScanner.nextDouble();
			
			/*DOCUMENTAÇÂO: https://docs.oracle.com/javase/tutorial/java/data/numberformat.html*/
			String valorFormatado = String.format(new Locale("pt","BR") ,
															 "%s - %04d - %08d - %20s: R$ %08.2f %n", 
															 tipoConta,agencia,conta,titular,saldo);
			System.out.format(valorFormatado);
			
			linhaScanner.close();			
		} 

		scanner.close();
	}

}
