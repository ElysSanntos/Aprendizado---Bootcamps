package br.com.bytebank.banco.teste.util;

import java.util.ArrayList;

import br.com.bytebank.banco.modelo.Conta;
import br.com.bytebank.banco.modelo.ContaCorrente;

public class TesteArrayListEquals {

	public static void main(String[] args) {
		
		
		//TESTANDO O MÉTODO IGUALS
		
//		Conta cc1 = new ContaCorrente(22, 22);
//		Conta cc2 = new ContaCorrente(22, 22);
//		
//		boolean igual = cc1.ehIgual(cc2);
//		System.out.println(igual);
				
		
		

		//GENERICS

		ArrayList<Conta> lista = new ArrayList<Conta>(); //Internamente é o guardador de referencia

		Conta cc = new ContaCorrente(1233, 3213);
		lista.add(cc);

		Conta cc1 = new ContaCorrente(12333, 32113);
		lista.add(cc1);
		
		Conta cc3 = new ContaCorrente(1233, 3213);
		boolean existe = lista.contains(cc3);
		System.out.println();
		System.out.println("================================================================");

		System.out.println("Já existe? " + existe);
		
		/*
		 * for (Conta conta : lista) { if(conta.ehIgual(cc3)) {
		 * System.out.println("Já tenho essa conta"); }
		 * 
		 * }
		 */

		//Para cada elemento Object dessa lista
		for (Conta conta : lista) {

			System.out.println(conta);

	}
		
		
		System.out.println();
		System.out.println("================================================================");

	}

}
