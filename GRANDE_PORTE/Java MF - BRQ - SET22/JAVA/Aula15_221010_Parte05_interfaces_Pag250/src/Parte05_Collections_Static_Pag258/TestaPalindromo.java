package Parte05_Collections_Static_Pag258;

public class TestaPalindromo {

	public static void main(String[] args) {

		String a = "anotaramadatadamaratona";
		String b = "osso";
		String c = "socorrammesubinoonibusemmarrocos";
		String d = "Elys";
		String e = "maddamimaddam";
		String f = "omo";
		String g = "abasedotetodesaba";
		

		imprime(a);
		imprime(b);
		imprime(c);
		imprime(d);
		imprime(e);
		imprime(f);
		imprime(g);
	}

	public static void imprime(String t) {
		if (Palindromo.ehPalindromo(t)) {

			System.out.println(t + " eh Palindromo");

		} else
			System.out.println(t + " NÃO eh Palindromo");

	}
}
