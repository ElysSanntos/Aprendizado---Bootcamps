package br.com.elys.java_io.teste;

import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.Writer;

public class TesteEscrita {

	public static void main(String[] args)throws IOException {

		//Fluxo de Entrada com Arquivo

		OutputStream fos = new FileOutputStream("lorem2.txt");

		Writer osw = new OutputStreamWriter(fos);

		BufferedWriter bw = new BufferedWriter(osw);
		
		bw.write("Estou escrendo no arquivo.");
		bw.newLine();
		bw.write("Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod");
		bw.newLine();
		bw.write("Teste teste teste teste");

		bw.close();

	}

}
