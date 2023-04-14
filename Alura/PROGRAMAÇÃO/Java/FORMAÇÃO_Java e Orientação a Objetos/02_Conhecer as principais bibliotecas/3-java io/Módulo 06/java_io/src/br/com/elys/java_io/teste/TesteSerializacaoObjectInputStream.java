package br.com.elys.java_io.teste;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;

public class TesteSerializacaoObjectInputStream {

	public static void main(String[] args) throws IOException, ClassNotFoundException {


		//Transformar bits e bytes  em um fluxo para criar um objeto

	
		ObjectInputStream inputStream = new ObjectInputStream(new FileInputStream("objeto.bin"));
		String nome = (String) inputStream.readObject();
		inputStream.close();
		
		System.out.println(nome);
		


	}

}
