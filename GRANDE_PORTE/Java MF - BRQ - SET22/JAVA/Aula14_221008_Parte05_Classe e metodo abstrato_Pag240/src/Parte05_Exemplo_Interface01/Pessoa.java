package Parte05_Exemplo_Interface01;

public abstract class Pessoa {

	protected int idPessoa;
	protected String nomePessoa;

	public Pessoa() {
	}

	public Pessoa(int idPessoa, String nomePessoa) {
		this.idPessoa = idPessoa;
		this.nomePessoa = nomePessoa;
	}

	public int getIdPessoa() {
		return idPessoa;
	}

	public String getNomePessoa() {
		return nomePessoa;
	}

	public void setIdPessoa(int idPessoa) {
		this.idPessoa = idPessoa;
	}

	public void setNomePessoa(String nomePessoa) {
		this.nomePessoa = nomePessoa;
	}

}
