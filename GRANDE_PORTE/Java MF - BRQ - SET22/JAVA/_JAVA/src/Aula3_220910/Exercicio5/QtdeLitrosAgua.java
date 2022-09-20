package Aula3_220910.Exercicio5;

public class QtdeLitrosAgua {

	public static void main(String[] args) {
		
		/*Legenda
		 * DP Diâmetro Pequeno
		   DG Diâmetro Grande
           PP Profundidade Pequena
	       PM Profundidade Média
	       PG Profundidade Grande*/
		
		double PP = 2;
		double PG = 4;
		double DG = 8;
		double DP = 4;
		
		double PM = (PP + PG) / 2;
		double QTDLITROS = DG * DP * PM * 785;
		
		System.out.println("A Qtde de litros necessarios para preencher a piscina Oval: " + QTDLITROS);
	}

}
