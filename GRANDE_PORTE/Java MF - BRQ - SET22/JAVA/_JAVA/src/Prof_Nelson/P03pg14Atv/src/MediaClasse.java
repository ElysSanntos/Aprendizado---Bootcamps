import java.util.Scanner;

public class MediaClasse {

	public static void main(String[] args) {
		int qtdAluno = 0;
		double soma = 0.0;
		String acabou = "nao";
		Scanner ze = new Scanner(System.in);
		
		while(acabou.equals("nao")) {
			System.out.print("Entre n1....: ");
			double nota1 = Double.parseDouble(ze.nextLine());
			System.out.print("Entre n2....: ");
			double nota2 = Double.parseDouble(ze.nextLine());
			double media = (nota1+nota2)/2.0;
			soma=soma+media;
			qtdAluno = qtdAluno+1; 
			System.out.print("Acabou (sim/nao)....: ");
			acabou = ze.nextLine();
		}
		double mediaClasse = soma/qtdAluno;
		System.out.println("media da classe = "+mediaClasse);
	}
}