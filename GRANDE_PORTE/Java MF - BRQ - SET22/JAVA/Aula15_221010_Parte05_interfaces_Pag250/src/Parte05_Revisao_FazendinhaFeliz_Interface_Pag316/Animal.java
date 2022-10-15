package Parte05_Revisao_FazendinhaFeliz_Interface_Pag316;

public abstract class Animal implements InterfaceSons{
	// atributos
	protected String nome;
	protected int idade;
	protected double peso;
	protected String especie;
	
	// construtores
	public Animal() {}
	public Animal(String nome, int idade, double peso, String especie) {
		this.nome = nome;
		this.idade = idade;
		this.peso = peso;
		this.especie = especie;
	}
	
	// getters e setters
	public String getNome() {
		return nome;
	}
	public int getIdade() {
		return idade;
	}
	public double getPeso() {
		return peso;
	}
	public String getEspecie() {
		return especie;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public void setIdade(int idade) {
		this.idade = idade;
	}
	public void setPeso(double peso) {
		this.peso = peso;
	}
	public void setEspecie(String especie) {
		this.especie = especie;
	}
	
	
}
