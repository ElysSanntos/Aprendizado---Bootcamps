import java.util.Scanner;

public class FolhaPagamento2 {

	public static void main(String[] args) {
		Scanner lerTeclado = new Scanner(System.in);
		
		System.out.print("Entre qtde. horas....: ");
		double qtdHoras = Double.parseDouble(lerTeclado.nextLine());
		System.out.print("Entre salario hora...: ");
		double salHora = Double.parseDouble(lerTeclado.nextLine());
		
		double salBruto = qtdHoras * salHora;
		
		if(salBruto < 500.0) {
			salBruto = salBruto + 200;
		}
		
		System.out.println("Salario Bruto = "+salBruto);
		lerTeclado.close();
	}

}
