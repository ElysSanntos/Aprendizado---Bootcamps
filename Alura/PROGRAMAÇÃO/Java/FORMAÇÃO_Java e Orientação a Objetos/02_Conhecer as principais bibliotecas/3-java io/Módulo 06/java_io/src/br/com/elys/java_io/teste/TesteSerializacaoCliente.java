package br.com.elys.java_io.teste;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;



public class TesteSerializacaoCliente{

	public static void main(String[] args) throws IOException {


		//Transformar o objeto em um fluxo de bits e bytes

		Cliente cliente = new Cliente();
		cliente.setNome("Elisangela Santos");
		cliente.setProfissao("Dev");
		cliente.setCpf("1111222223333");

		ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream("Cliente.bin"));
		objectOutputStream.writeObject(cliente);
		objectOutputStream.close();


	}

}
