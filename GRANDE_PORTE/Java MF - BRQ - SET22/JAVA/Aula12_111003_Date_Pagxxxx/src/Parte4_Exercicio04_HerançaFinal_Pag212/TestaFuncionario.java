package Parte4_Exercicio04_HerançaFinal_Pag212;

public class TestaFuncionario {
	public static void main(String[] args) {
		Funcionario f = new Funcionario("Geronimo Veiga",
 				                        "14.444.222-3",
 				                        8000.0);
		Chefe c = new Chefe("Helena de Troia", 
				            "12.111.655-6",
				            16000.0, 
				            2000.0,
				            3000.0,
				            5000.0);
		System.out.println("Funcionario: \t"+f.getNome()+"\t Pag_Total\tR$"+f.pagamento());
		System.out.println("Chefe: \t\t"+c.getNome()+"\t Pag_Total\tR$"+c.pagamento());
		System.out.println("Chefe_Extra:\t"+c.getNome()+"\t Pag_Total\tR$"+c.pagamentoExtra());
	}
}