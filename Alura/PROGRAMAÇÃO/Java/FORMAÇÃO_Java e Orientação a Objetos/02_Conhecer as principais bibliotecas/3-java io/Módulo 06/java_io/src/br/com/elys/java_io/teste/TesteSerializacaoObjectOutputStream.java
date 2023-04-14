package br.com.elys.java_io.teste;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

public class TesteSerializacaoObjectOutputStream {

	public static void main(String[] args) throws FileNotFoundException, IOException {
		
		
		//Transformar o objeto em um fluxo de bits e bytes
		
		String nome = "Elys Sanntos";
		
		ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream("objeto.bin"));
		objectOutputStream.writeObject(nome);
		objectOutputStream.close();
		

	}

}
