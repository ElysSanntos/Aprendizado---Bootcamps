package br.com.bytebank.banco.teste;

public class TesteString {

	public static void main(String[] args) {
		
		String vazio = " ";
		String vazio2 = "";
		String vazio3 = "     Alura    ";
		String outroVazio1 = vazio3.trim();
		String outroVazio = vazio.trim();
		
		
		
		
		
		String nome = "Alura"; //object literal
		
		//String outro = new String ("Alura");
		
		char c = 'A';
		char d = 'a';
		
		String outra = nome.replace('A', 'a');
		String outra2 = nome.replace(c, d);
		String rs = nome.replace("Al", "aL");
		String lower = nome.toLowerCase();

		String upper = nome.toUpperCase();
		char chart = nome.charAt(2);
		
		int posicao = nome.indexOf("ur");
		String substring = nome.substring(1);
		
		
		for(int i = 0; i< nome.length();i++) {
			System.out.println("Impressao de cada Caracter: " +nome.charAt(i));
			
		}
		System.out.println();
		
		System.out.println("Nome iniciado na variavel: "+nome);
		System.out.println("Replace: "+outra);
		System.out.println("Replace com variavel: "+outra2);
		System.out.println("Replace Sequence: "+ rs);
		System.out.println("Upper Case: "+upper);
		System.out.println("Lower Case: "+lower);
		System.out.println("CharAt, que caracter existe na posição 2: "+chart);
		System.out.println("Onde começa a substring `ur`: "+posicao);
		System.out.println("Substring iniciada na posição 1: "+substring);
		System.out.println("Tamanho da String : "+nome.length());
		System.out.println("String vazia com espaço " + vazio.isEmpty());
		System.out.println("String vazia sem espaço " + vazio2.isEmpty());
		System.out.println("String vazia com trim() " + outroVazio.isEmpty());
		System.out.println("Imprimindo String Antes trim(): " +vazio3);
		System.out.println("Imprimindo String Depois trim(): " +outroVazio1);
		System.out.println("String vazio contem 'Alu': "+vazio.contains("Alu"));
		System.out.println("String vazio3 contem 'Alu': "+vazio3.contains("Alu"));
	}

}
