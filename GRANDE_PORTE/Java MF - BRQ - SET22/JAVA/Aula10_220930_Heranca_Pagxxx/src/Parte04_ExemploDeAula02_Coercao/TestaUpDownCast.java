package Parte04_ExemploDeAula02_Coercao;

//Upcasting e Downcasting de objetos
public class TestaUpDownCast {

	public static void main(String[] args) {

		Pessoa[] minhaLista = new Pessoa[3];
		// Pessoa para Pessoa � n�o precisa de cast
		minhaLista[0] = new Pessoa("Ana");
		
		// Funcionario para Pessoa � cast implicito
		// pois um funcionario � uma pessoa
		minhaLista[1] = new Funcionario("Pedro", 6500.0);
		
		// Gerente para Pessoa � cast implicito
		// pois um gerente � um funcionario que � uma pessoa
		minhaLista[2] = new Gerente("Maria", 8500.0, 12);

		for (Pessoa balde: minhaLista) {
			// instanceof retorna true se a refer�ncia a esquerda �
			// da classe a direita e, false caso contr�rio
			if (balde instanceof Gerente) {
				Gerente g = (Gerente) balde;
				System.out.println("\nGerente");
				System.out.println("Nome: " + g.getNome());
				System.out.println("Sal�rio: " + g.getSalario());
				System.out.println("Qtf. Func: " + g.getQtdFunc());
			} else if (balde instanceof Funcionario) {
				Funcionario f = (Funcionario) balde;
				System.out.println("\nFuncionario");
				System.out.println("Nome: " + f.getNome());
				System.out.println("Sal�rio: " + f.getSalario());
			} else {
				System.out.println("\nPessoa");
				System.out.println("Nome: " + balde.getNome());
			}
		}
	}
}
