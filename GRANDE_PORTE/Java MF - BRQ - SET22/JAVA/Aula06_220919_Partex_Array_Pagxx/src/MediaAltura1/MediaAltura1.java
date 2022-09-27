package MediaAltura1;

import java.util.Scanner;



public class MediaAltura1 {

	public static void main(String[] args) {
		System.out.println("Media das Alturas");
		System.out.println("Media = " + viaDigitacao(10));
	}
	
	public static double viaDigitacao(int qtd) {
		Scanner ze = new Scanner(System.in);
		int qtdePessoas;
		double somaAltura = 0.0;
		
		for(qtdePessoas = 0;qtdePessoas<qtd;qtdePessoas++) {
			System.out.print("Entre altura...: ");
			double altura = Double.parseDouble(ze.nextLine());
			somaAltura += altura;
		}
		
		ze.close();
		return somaAltura / qtdePessoas;
	}

}