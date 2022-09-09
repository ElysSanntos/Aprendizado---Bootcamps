package br.com.treinaweb.terceiroexercicio;

public class Paciente {
	private int codigo;
	private String nome;
	private String sobrenome;
	private int idade;
	private String sexo;
	private String telefone;
	private String endere�o;
	
	public Paciente(int codigo, String nome, String sobrenome, int idade, String sexo, String telefone, String endere�o) {
		this.codigo = codigo;
		this.nome = nome;
		this.sobrenome = sobrenome;
		this.idade = idade;
		this.sexo = sexo;
		this.telefone = telefone;
		this.endere�o = endere�o;
	}

	public int getCodigo() {
		return codigo;
	}
	
	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getSobrenome() {
		return sobrenome;
	}

	public void setSobrenome(String sobrenome) {
		this.sobrenome = sobrenome;
	}

	public int getIdade() {
		return idade;
	}

	public void setIdade(int idade) {
		this.idade = idade;
	}

	public String getSexo() {
		return sexo;
	}

	public void setSexo(String sexo) {
		this.sexo = sexo;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public String getEndere�o() {
		return endere�o;
	}

	public void setEndere�o(String endere�o) {
		this.endere�o = endere�o;
	}
	
	public void marcarConsulta(){
		System.out.println("Marcando uma consulta com o dentista!");
	}
	
	public void remarcarConsulta(){
		System.out.println("Remarcando uma consulta com o dentista!");
	}
	
	public void cancelarConsulta(){
		System.out.println("Cancelando uma consulta com o dentista!");
	}
	
	public void consultadoConsulta(){
		System.out.println("Consultado uma consulta com o dentista!");
	}
}
