package Parte05_Collections_Pag258;

public class TestaPalindromo {

	public static void main(String[] args) {
		
		String a = "anotaramadatadamaratona";
		String b = "osso";
		String c = "socorrammesubinoonibusemmarrocos";
		
		Palindromo ze = new Palindromo("a");
		
		
		
		if(ze.ehPalindromo()) {
			
			System.out.println(ze.getFraseOriginal() + " eh Palindromo");
			
		}else				
		System.out.println(ze.getFraseOriginal() + " NÃO eh Palindromo");

	}
}
