package br.com.elys.java_io.teste;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;

public class TesteLeitura {

	public static void main(String[] args)throws IOException {
		
		//Fluxo de Entrada com Arquivo
		
		FileInputStream fis = new FileInputStream("lorem.txt"); // estabelecemos uma entrada de dados via arquivo.
		
//		fis.read();// O método read(), me devolve bytes, o que não é interessante para a leitura de um arquivo. 
//		Por essa razão, vamos fazer uso da Classe InputStreamReader
		
		InputStreamReader isr = new InputStreamReader(fis);
		
		BufferedReader br = new BufferedReader(isr);
		String linha = br.readLine();	
		
		while(linha !=null) {
			System.out.println(linha);
			linha = br.readLine();
			
		}

		
		br.close();

	}

}
