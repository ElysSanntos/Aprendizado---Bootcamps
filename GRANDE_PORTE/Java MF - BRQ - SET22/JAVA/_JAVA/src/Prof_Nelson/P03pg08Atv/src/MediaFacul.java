import java.util.Scanner;

public class MediaFacul {

	public static void main(String[] args) {
		Scanner lerTeclado = new Scanner(System.in);
		
		System.out.print("Entre n1....: ");
		double n1 = Double.parseDouble(lerTeclado.nextLine());
		System.out.print("Entre n2....: ");
		double n2 = Double.parseDouble(lerTeclado.nextLine());

		double media = ( n1 + n2 ) / 2.0;
		String situacao;
		
		if(media < 4.0) {
			situacao = "Reprovado Direto";
		} 
		else {
			if(media >= 7.0) {
				situacao = "Aprovado Direto";
			} else {
				System.out.print("Entre Exame.: ");
				double notaExame = Double.parseDouble(lerTeclado.nextLine());
				media = (media + notaExame) / 2.0;
				if(media >= 5) {
					situacao = "Aprovado Exame";
				} else {
					situacao = "Reprovado Exame";
				}
			}
		}
		System.out.println(media + " - " + situacao);
		lerTeclado.close();
	}
}
