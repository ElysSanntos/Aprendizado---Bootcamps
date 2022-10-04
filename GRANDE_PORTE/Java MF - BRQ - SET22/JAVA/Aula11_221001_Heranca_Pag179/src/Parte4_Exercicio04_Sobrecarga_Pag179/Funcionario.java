package Parte4_Exercicio04_Sobrecarga_Pag179;

public class Funcionario {

	protected int idFunc;
	protected String nomeFunc;
	protected double salarioHora;

	// construtor
	public Funcionario(int idFunc, String nomeFunc, double salarioHora) {
		this.idFunc = idFunc;
		this.nomeFunc = nomeFunc;
		this.salarioHora = salarioHora;
	}

	// c�lculo do sal�rio l�quido para funcion�rios
	public double calculaSalario(double horasTrabalhadas) {
		double salBruto = salarioHora * horasTrabalhadas;
		double salLiquido;
		if (salBruto <= 1000.00)
			salLiquido = salBruto;
		else if (salBruto <= 2000.00)
			salLiquido = salBruto * 0.9;
		else
			salLiquido = salBruto * 0.85;
		return salLiquido;
	}

	// c�lculo da bonifica��o para os funcionarios
	public double bonificacao() {
		return salarioHora * 50;
	}

}
