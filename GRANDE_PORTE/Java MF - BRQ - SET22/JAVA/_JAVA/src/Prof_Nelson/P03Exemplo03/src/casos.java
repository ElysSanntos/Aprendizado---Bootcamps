public class casos {
	public static void main(String[] args) {
		int nivel=4;
		
		switch(nivel) {
		case  6: System.out.println("Auxilio Viagem"); 
		         System.out.println("Auxilio Hospedagem");
		case  5: System.out.println("Auxilio Moradia"); 
		case  4: System.out.println("Auxilio Combustivel"); 
		case  3: System.out.println("Seguro Saude"); 
		case  2: System.out.println("Seguro de Vida"); 
		case  1: System.out.println("vale Refeicao"); 
		         System.out.println("vale Refrigerante");
		case  0: System.out.println("vale transporte");
		default: System.out.println("agua");
		}
		
		int opcao=2;
		switch (opcao) {
		case  1: System.out.println("Abrir"   ); break;
		case  2: System.out.println("Ler"     ); break;
		case  3: System.out.println("Escrever"); break;
		case  4: System.out.println("Fechar"  ); break;
		default: System.out.println("Sair"    );
		}
		
		
		int qtde = 0;
		switch(qtde) {
		case 0:
		case 1:
		case 2: System.out.println("0 1 ou 2"); break;
		case 3:
		case 4: System.out.println("3 ou 4"); break;
		case 5: System.out.println("5");
		}
	}
}