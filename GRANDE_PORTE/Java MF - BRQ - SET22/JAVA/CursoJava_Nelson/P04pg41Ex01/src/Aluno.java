import java.util.Date;

public class Aluno extends Pessoa {
	// Atributos
	private String matricula;
    // construtores
	public Aluno() {}
	public Aluno(String nome, 
			     String cpf, 
			     Date datanascimento,
			     String matricula) {
		super(nome, cpf, datanascimento);
		this.matricula = matricula;
	}
	// getters e setteres
	public String getMatricula() {
		return matricula;
	}
	public void setMatricula(String matricula) {
		this.matricula = matricula;
	}
	
	// métodos próprios
	@Override
	public double tirarCopias(int qtd) {
		return qtd * 0.07;
	}	
}