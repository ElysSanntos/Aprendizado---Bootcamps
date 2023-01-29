package br.com.bytebank.banco.teste.util;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import br.com.bytebank.banco.modelo.Conta;
import br.com.bytebank.banco.modelo.ContaCorrente;

public class TesteLinkedList {

	public static void main(String[] args) {


		List<Conta> lista = new ArrayList<Conta>(); //Internamente é o guardador de referencia

		Conta cc = new ContaCorrente(1233, 3213);
		lista.add(cc);

		Conta cc1 = new ContaCorrente(12333, 32113);
		lista.add(cc1);

		//Quantas referencias foram guardadas até agora?

		System.out.println("Qtde de referencias armazenadas: " +lista.size());

		Object ref = lista.get(0);
		System.out.println("Nº Conta: "+ ((Conta) ref).getNumero());

		lista.remove(0);
		System.out.println("Qtde de referencias armazenadas, apos a remoção: " +lista.size());

		Conta cc2 = new ContaCorrente(21233, 23213);
		lista.add(cc2);

		Conta cc3 = new ContaCorrente(312333, 332113);
		lista.add(cc3);
		System.out.println("Qtde de referencias armazenadas, apos adições: " +lista.size());

		System.out.println("================================================================");

		//Iterar -- Acessar cada elemento dentro do laço

		for (int i = 0; i < lista.size(); i++) {

			Object oRef = lista.get(i);

			System.out.println(oRef);

		}
		System.out.println("================================================================");

		//Para cada elemento Object dessa lista
		for (Object oRef : lista) {

			System.out.println(oRef);

		}
		System.out.println("================================================================");

	}

}
