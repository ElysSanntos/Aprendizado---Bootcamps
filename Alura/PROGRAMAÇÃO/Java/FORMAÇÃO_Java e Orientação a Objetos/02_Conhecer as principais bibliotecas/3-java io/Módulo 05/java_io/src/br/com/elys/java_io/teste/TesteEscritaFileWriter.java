package br.com.elys.java_io.teste;

import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.Writer;

public class TesteEscritaFileWriter {

	public static void main(String[] args)throws IOException {

	
		//Fluxo de Entrada com Arquivo

//				OutputStream fos = new FileOutputStream("lorem2.txt");
//
//				Writer osw = new OutputStreamWriter(fos);
//
//				BufferedWriter bw = new BufferedWriter(osw);
		
		
		// Saída mais simples
		
//		FileWriter fw = new FileWriter("FileWrite.txt");//Classe que trabalha com arquivos já com caracteres
//		BufferedWriter bw = new BufferedWriter(fw); //Embrular o fw no bw
		
		
		// Enxugar o código
		
		BufferedWriter bw = new BufferedWriter(new FileWriter("FileWrite.txt"));
		
		bw.write("Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod");//Escrever uma linha
		bw.write(System.lineSeparator());//tem a mesma função da próxima linha -- mais elegante
		bw.write("\r\n"); //Caracteres especiais que indicam que é uma nova linha--Caracteres variam entre os sistemas operacionais
		bw.newLine(); // mais alto nível
		bw.write("Teste teste teste teste");

		bw.close();

	}

}
