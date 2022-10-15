package Parte05_Collections_Pag258;

import java.util.Stack;

public class Palindromo {

	private String fraseOriginal;
	

	public Palindromo() {}
	public Palindromo(String frase) {
		this.fraseOriginal = frase;
	}
	
	public String getFraseOriginal() {
		return fraseOriginal;
	}
	public void getFraseOriginal(String fraseOriginal) {
		this.fraseOriginal = fraseOriginal;
	}

	
	
	public boolean ehPalindromo() {
		
		// 1 - Declarar a pilha
		Stack<Character> s = new Stack<>();
		String r = "";
		
		// 2 - colocar os caracteres da string na pilha
		for (int i = 0; i < fraseOriginal.length(); i++) {
			s.push(fraseOriginal.charAt(i));
			
		}
		
		// 3 - tirar os caracteres da pilha
		
		while (!s.isEmpty()) {
			
			r += s.pop();
			
		}
		// 4 - comparar as duas strings
		
		return fraseOriginal.equals(r);
		
		
	}
	
	

}
