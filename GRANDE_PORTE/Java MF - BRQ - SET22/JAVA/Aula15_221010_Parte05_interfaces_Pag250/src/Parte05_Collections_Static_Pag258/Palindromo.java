package Parte05_Collections_Static_Pag258;

import java.util.Stack;

public class Palindromo {

	
	
	public static boolean ehPalindromo(String frase) {
		
		// 1 - Declarar a pilha
		Stack<Character> s = new Stack<>();
		String r = "";
		
		// 2 - colocar os caracteres da string na pilha
		for (int i = 0; i < frase.length(); i++) {
			s.push(frase.charAt(i));
			
		}
		
		// 3 - tirar os caracteres da pilha
		
		while (!s.isEmpty()) {
			
			r += s.pop();
			
		}
		// 4 - comparar as duas strings
		
		return frase.equals(r);
		
		
	}
	
	

}
