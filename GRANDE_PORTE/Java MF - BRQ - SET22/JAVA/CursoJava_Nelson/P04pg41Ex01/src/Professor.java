import java.util.Date;

public class Professor extends Pessoa {
	// Atributos
	private double salario;
	private String disciplina;
	// construtores
	public Professor() {}
	public Professor(String nome, 
			         String cpf, 
    		         Date datanascimento,
    		         double salario, 
    		         String disciplina) {
		super(nome, cpf, datanascimento);
		this.salario = salario;
		this.disciplina = disciplina;
	}
	// getters e setters
	public double getSalario() {
		return salario;
	}
	public String getDisciplina() {
		return disciplina;
	}
	public void setSalario(double salario) {
		this.salario = salario;
	}
	public void setDisciplina(String disciplina) {
		this.disciplina = disciplina;
	}
}