package br.com.elys.java_io.teste;

import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintStream;
import java.io.Writer;

public class TestePrintScreamPrintWriter {

	public static void main(String[] args)throws IOException {

		//Fluxo de Entrada com Arquivo

//		OutputStream fos = new FileOutputStream("lorem2.txt");
//
//		Writer osw = new OutputStreamWriter(fos);
//
//		BufferedWriter bw = new BufferedWriter(osw);
		
		PrintStream ps = new PrintStream("printStream.txt");
		
		ps.println("Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod");
		ps.println();
		ps.println("teste teste teste teste teste teste");

		ps.close();

	}

}
