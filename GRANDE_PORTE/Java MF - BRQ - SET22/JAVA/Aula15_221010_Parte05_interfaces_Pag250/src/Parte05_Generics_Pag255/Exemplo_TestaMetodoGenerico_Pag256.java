package Parte05_Generics_Pag255;

import java.util.ArrayList;

public class Exemplo_TestaMetodoGenerico_Pag256 {

	// Testa Método Genérico

	// método generic imprimeArray
	// static, pq é chamado pelo método main
	// E[] ==> Variável de tipo
	//<E> ==> operador de tipo genérico
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
		// Não pode usar tipo primitivo como genérico somente wrappers
		Integer[] intArray = { 1, 2, 3, 4, 5 };
		Double[] doubleArray = { 1.1, 2.2, 3.3, 4.4 };
		Character[] charArray = { 'J', 'A', 'V', 'A', '!' };
		String[] stringArray = { "Ana", "Daniele", "Vânia", "Amanda"};

		System.out.println("o array integerArray contém:");
		// passando um array de Integer
		imprimeArray(intArray);
		
		System.out.println("o array doubleArray contém:");
		// passando um array de Double
		imprimeArray(doubleArray);
		
		System.out.println("o array characterArray contém:");
		// passando um array de Character
		imprimeArray(charArray);
		
		System.out.println("o array stringrArray contém:");
		// passando um array de String
		imprimeArray(stringArray);
		
		//Genérico em uma classe
		ArrayList <Integer> al = new ArrayList <Integer>();
		al.add(6);
		
		System.out.println("o ArrayList contém:");
		// passando um ArrayList 
		System.out.println(al);
		
		imprimeJunto(3.14159, " - banana");
		imprimeJunto( + 3, " - F");
		
		
		
		
		
	}
}
