package br.com.bytebank.banco.test.util;

import java.util.ArrayList;
import java.util.List;

public class TesteWrapperInteger {
	public static void main(String[] args) {
		
		int idade = 29; //Integer
		
		
		
		//Integer idadeRef = new Integer(29);
		
		
		Integer idadeRef = Integer.valueOf(29);
		int valor = idadeRef.intValue();
		System.out.println("doubleValue: "+idadeRef.doubleValue());
		
		System.out.println("MAX_VALUE: "+Integer.MAX_VALUE);
		System.out.println("MIN_VALUE: "+Integer.MIN_VALUE);
		System.out.println("SIZE: "+Integer.SIZE + " bits");
		System.out.println("BYTES: "+Integer.BYTES + " bytes");
		
		
		
		String s = args[0];//"10"
		
		Integer numero = Integer.valueOf(s);
		System.out.println("valueOf: "+numero);
		
		int numero1 = Integer.parseInt(s);
		System.out.println("parseInt: "+numero1);
		
		List<Integer> numeros = new ArrayList<Integer>();
		numeros.add(idadeRef);
		numeros.add(29);//Autoboxing
		
	}
	

}
