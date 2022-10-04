import java.util.Date;

public class Funcionario extends Pessoa {
	// atributos
	private double salario;
	private Date dataAdmissao;
	private String cargo;
	// construtores
	public Funcionario() {
	}
	public Funcionario(String nome, 
			           String cpf, 
			           Date datanascimento,
			           double salario, 
			           Date dataAdmissao, 
			           String cargo) {
		super(nome, cpf, datanascimento);
		this.salario = salario;
		this.dataAdmissao = dataAdmissao;
		this.cargo = cargo;
	}
	// getters e setters
	public double getSalario() {
		return salario;
	}
	public Date getDataAdmissao() {
		return dataAdmissao;
	}
	public String getCargo() {
		return cargo;
	}
	public void setSalario(double salario) {
		this.salario = salario;
	}
	public void setDataAdmissao(Date dataAdmissao) {
		this.dataAdmissao = dataAdmissao;
	}
	public void setCargo(String cargo) {
		this.cargo = cargo;
	}
}