public class Funcionario extends Pessoa {
	protected double salario;

	public Funcionario(String nome,double salario) {
		super(nome);
		this.salario = salario;
	}
	public double getSalario() {
		return salario;
	}
}