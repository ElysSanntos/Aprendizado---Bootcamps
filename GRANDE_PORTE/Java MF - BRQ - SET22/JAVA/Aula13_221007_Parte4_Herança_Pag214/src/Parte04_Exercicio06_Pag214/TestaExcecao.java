package Parte04_Exercicio06_Pag214;
/*Escreva um programa no qual main() chama metodoA(), que
 * 								     chama metodoB(), que 
 * 									 chama metodoC(), que 
 * 									 chama metodoD(). 
 * Inclua c�digo em metodoD() que dispara uma exce��o, que � capturada
por metodoA() ap�s metodoC() e metodoB() propagarem-na. Para cada m�todo, 
inclua comandos de sa�da que indiquem quando o m�todo inicia e quando ele retorna*/

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
			System.out.println("Pegamos o erro no metodoA(), agora estamos bem, n�o se preocupe!");
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
		int a = 10 / 0;//Com exce��o: java.lang.ArithmeticException: / by zero
		System.out.println("Depois do erro em D");
	}
}