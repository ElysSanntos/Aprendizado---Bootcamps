package Parte04_Exercicio06_Pag214;
/*Escreva um programa no qual main() chama metodoA(), que
 * 								     chama metodoB(), que 
 * 									 chama metodoC(), que 
 * 									 chama metodoD(). 
 * Inclua código em metodoD() que dispara uma exceção, que é capturada
por metodoA() após metodoC() e metodoB() propagarem-na. Para cada método, 
inclua comandos de saída que indiquem quando o método inicia e quando ele retorna*/

public class TestaExcecao {
	public static void main(String[] args) {
		System.out.println("Antes do metodoA()");
		metodoA();
		System.out.println("Depois do metodoA()");
	}

	public static void metodoA() {
		try {
		System.out.println("Antes do metodoB()");
		metodoB();
		System.out.println("Depois do metodoB()");
		}catch(Exception e) {
			System.out.println("Pegamos o erro no metodoA(), agora estamos bem, não se preocupe!");
		}
	}
	
	public static void metodoB() {
		System.out.println("Antes do metodoC()");
		metodoC();
		System.out.println("Depois do metodoC()");
	}
	
	public static void metodoC() {
		System.out.println("Antes do metodoD()");
		metodoD();
		System.out.println("Depois do metodoD()");
	}
	
	public static void metodoD() {
		System.out.println("Antes do erro em D");
		//int a = 10 / 2; // Sem erro
		int a = 10 / 0;//Com exceção: java.lang.ArithmeticException: / by zero
		System.out.println("Depois do erro em D");
	}
}