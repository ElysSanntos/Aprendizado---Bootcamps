package Parte3_Exercicio05_Primos_Pag165;

public class ArrayPrimo {

	public static void main(String[] args) {
		
		boolean primo[] = new boolean[100];

		inicializa(primo);
		verificaPrimo(primo);
		imprimePrimo(primo);
		
		
		
	}
	//Inicializar o array com true
	public static void inicializa(boolean[] a) {
		
		
				for (int i = 0; i < a.length; i++) {
					a[i] = true;
				}
	}
	//Seta como false se a posição do array não for primo
	public static void verificaPrimo(boolean[] a) {
		for (int i = 0; i < a.length; i++) {
			if(!ehPrimo(i)) {
				a[i] = false;
			
		}
	}
	}
	
	private static boolean ehPrimo(int n) {
		if(n<2)return true;
		int divisor = 2;
		
		while(n%divisor !=0) divisor++;
			return  n==divisor;
			
		}
	
	private static void imprimePrimo(boolean []a) {
		for (int i = 0; i<a.length; i++) {
			if(a[i]) {
				System.out.println("Número primo: " +i);
			}
			
		}
	}
	}


