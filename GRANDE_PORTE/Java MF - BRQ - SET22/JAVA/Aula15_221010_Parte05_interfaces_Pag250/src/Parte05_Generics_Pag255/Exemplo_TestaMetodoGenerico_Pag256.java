package Parte05_Generics_Pag255;

import java.util.ArrayList;

public class Exemplo_TestaMetodoGenerico_Pag256 {

	// Testa M�todo Gen�rico

	// m�todo generic imprimeArray
	// static, pq � chamado pelo m�todo main
	// E[] ==> Vari�vel de tipo
	//<E> ==> operador de tipo gen�rico
	public static <E> void imprimeArray(E[] meuArray) {
		// exibe os elementos do array
		for (E elemento : meuArray) {
			System.out.print(elemento + " ");
		}
		System.out.println();
	}
	public static <T1, T2> void imprimeJunto(T1 a, T2 b) {
		System.out.println("Exibe os tipos passados para T1 e T2");
		System.out.println("T1 " + a.getClass());
		System.out.println("T2 " + b.getClass());
		System.out.print(a);
		System.out.print(b);
		System.out.println();
	}

	public static void main(String args[]) {
		// Cria arrays dos tipos Integer, Double e Character
		// N�o pode usar tipo primitivo como gen�rico somente wrappers
		Integer[] intArray = { 1, 2, 3, 4, 5 };
		Double[] doubleArray = { 1.1, 2.2, 3.3, 4.4 };
		Character[] charArray = { 'J', 'A', 'V', 'A', '!' };
		String[] stringArray = { "Ana", "Daniele", "V�nia", "Amanda"};

		System.out.println("o array integerArray cont�m:");
		// passando um array de Integer
		imprimeArray(intArray);
		
		System.out.println("o array doubleArray cont�m:");
		// passando um array de Double
		imprimeArray(doubleArray);
		
		System.out.println("o array characterArray cont�m:");
		// passando um array de Character
		imprimeArray(charArray);
		
		System.out.println("o array stringrArray cont�m:");
		// passando um array de String
		imprimeArray(stringArray);
		
		//Gen�rico em uma classe
		ArrayList <Integer> al = new ArrayList <Integer>();
		al.add(6);
		
		System.out.println("o ArrayList cont�m:");
		// passando um ArrayList 
		System.out.println(al);
		
		imprimeJunto(3.14159, " - banana");
		imprimeJunto( + 3, " - F");
		
		
		
		
		
	}
}
