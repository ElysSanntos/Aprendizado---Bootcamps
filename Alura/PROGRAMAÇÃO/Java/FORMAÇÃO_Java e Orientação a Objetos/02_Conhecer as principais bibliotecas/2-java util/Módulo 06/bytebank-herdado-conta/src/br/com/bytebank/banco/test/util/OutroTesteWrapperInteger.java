package br.com.bytebank.banco.test.util;

import java.util.ArrayList;
import java.util.List;

public class OutroTesteWrapperInteger {
	public static void main(String[] args) {
		
		
			
		Integer idadeRef = Integer.valueOf(29);//autoboxinf
	
		System.out.println("doubleValue: "+idadeRef.intValue());//unboxing
		
		
		Double dRef = Double.valueOf(3.2);////autoboxinf
		System.out.println("doubleValue: "+dRef.doubleValue());//unboxing
		
		Boolean bRef = Boolean.FALSE;
		System.out.println(bRef.booleanValue());
		
		Number refNum = Double.valueOf(30.1);
		Number refNumFloat = Float.valueOf(30.2f);
		
		List<Number> lista = new ArrayList<Number>();
		lista.add(32.6);
		lista.add(10);
		lista.add(25.6f);
		lista.add(dRef);
		lista.add(idadeRef);
		lista.add(8);
	
		
		System.out.println(lista);
	}
	

}
