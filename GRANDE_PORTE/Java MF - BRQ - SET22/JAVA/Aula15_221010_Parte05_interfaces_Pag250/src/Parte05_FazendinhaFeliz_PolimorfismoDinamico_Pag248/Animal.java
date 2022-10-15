package Parte05_FazendinhaFeliz_PolimorfismoDinamico_Pag248;

public abstract class Animal {
//ATRIBUTOS
	protected String nomeAnimal;
	protected int idade;
	protected double peso;
	protected String especie;
	

//CONSTRUTORES	
	public Animal() {
	}

	public Animal(String nomeAnimal, int idade, String especie, double peso) {
		this.nomeAnimal = nomeAnimal;
		this.idade = idade;
		this.especie = especie;
		this.peso = peso;
	}

//GETERRES E SETTERS
	public String getNomeAnimal() {
		return nomeAnimal;
	}

	public int getIdade() {
		return idade;
	}

	public String getEspecie() {
		return especie;
	}

	public double getPeso() {
		return peso;
	}

	public void setNomeAnimal(String nomeAnimal) {
		this.nomeAnimal = nomeAnimal;
	}

	public void setIdade(int idade) {
		this.idade = idade;
	}

	public void setEspecie(String especie) {
		this.especie = especie;
	}

	public void setPeso(double peso) {
		this.peso = peso;
	}

//METODOS PRÓPRIOS

	public abstract void som();

}
