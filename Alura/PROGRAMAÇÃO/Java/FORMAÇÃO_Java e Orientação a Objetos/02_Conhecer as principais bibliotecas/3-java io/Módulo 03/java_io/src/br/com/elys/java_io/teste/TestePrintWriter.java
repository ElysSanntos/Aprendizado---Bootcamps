package br.com.elys.java_io.teste;

import java.io.IOException;
import java.io.PrintWriter;

public class TestePrintWriter {

	public static void main(String[] args)throws IOException {

		//Fluxo de Entrada com Arquivo

//		OutputStream fos = new FileOutputStream("lorem2.txt");
//
//		Writer osw = new OutputStreamWriter(fos);
//
//		BufferedWriter bw = new BufferedWriter(osw);
		
		PrintWriter ps = new PrintWriter("printWriter.txt");
		
		ps.println("Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod");
		ps.println();
		ps.println("teste teste teste teste teste teste");

		ps.close();

	}

}
