package Parte01_Exercicio06_Pag48;

public class QtdeMoedas {

	public static void main(String[] args) {

		int q1 = 1;
		int q2 = 2;
		int q3 = 3;
		int q4 = 4;
		int q5 = 5;
		int q6 = 6;
		double D = 5.15;
		
		double R = (q1 + 0.5* q2 + 0.25* q3 + 0.1* q4 + 0.05* q5 + 0.01*q6 )* D;
		
		System.out.println("No meu cofrinho tem R$ "+R);

	}

}
