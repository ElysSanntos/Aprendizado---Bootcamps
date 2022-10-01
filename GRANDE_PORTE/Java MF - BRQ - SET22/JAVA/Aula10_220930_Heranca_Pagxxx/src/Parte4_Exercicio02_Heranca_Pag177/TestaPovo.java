package Parte4_Exercicio02_Heranca_Pag177;

public class TestaPovo {

	public static void main(String[] args) {
 
			Pessoa p = new Pessoa(1,"Adilson");
			p.setTime("Palmeiras");
			System.out.println("========Classe RAIZ Pessoa========\n");
			p.imprimeDados();
			
			
			Funcionario f = new Funcionario(2, "Sinomar",212,"Analista");
			System.out.println("\n========Classe Funcionario que herda de Pessoa========\n");
			f.imprimeDados();
			
			Gerente g = new Gerente(3,"Marcelo",432,"Gerente", "Marketing");
			System.out.println("\n========Classe Gerente que herda de Funcionario========\n");
			g.imprimeDados();
	}

}
