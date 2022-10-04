import java.util.Date;

public class Pessoa {
	// atributos
	protected String nome;
	protected String cpf;
	protected Date datanascimento;
	
	// construtores
	public Pessoa() {}
	public Pessoa(String nome, String cpf, Date datanascimento) {
		this.nome = nome;
		this.cpf = cpf;
		this.datanascimento = datanascimento;
	}
	// getters e setters
	public String getNome() {
		return nome;
	}
	public String getCpf() {
		return cpf;
	}
	public Date getDatanascimento() {
		return datanascimento;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	public void setDatanascimento(Date datanascimento) {
		this.datanascimento = datanascimento;
	}
	
	// métodos próprios
	public double tirarCopias(int qtd) {
		return qtd * 0.1;
	}
}
