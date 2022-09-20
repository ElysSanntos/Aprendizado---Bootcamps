package Aula6_220919.MediaClasse;

import java.util.Scanner;

public class MediaClasse {

	public static void main(String[] args) {

		int qtdAluno = 0;
		double soma = 0.0;
		String acabou = "n";
		Scanner ze = new Scanner(System.in);
		
		while(acabou.equals("n")) {
			System.out.println("Entre N1...: ");
			double nota1 = Double.parseDouble(ze.nextLine());
			System.out.println("Entre N2...: ");
			double nota2 = Double.parseDouble(ze.nextLine());
			double media = (nota1 + nota2)/2.0;
			soma +=media;
			qtdAluno = qtdAluno+1;
			System.out.println("Alunos registrados: " + qtdAluno);
			
			System.out.print("Acabou (y / n)....: ");
			acabou = ze.nextLine();
		}
		double mediaClasse = soma/qtdAluno;
		System.out.println("media da classe = "+mediaClasse);
	}

}
