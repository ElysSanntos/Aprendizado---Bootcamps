package Parte05_Revisao_FazendinhaFeliz_Pag248;

public class Cachorro extends Animal {
	public Cachorro() {}
	public Cachorro(String nome, int idade, double peso, String especie) {
		super(nome, idade, peso, especie);
	}

	@Override
	public void som() {
		System.out.println("Au Au...");
	}
}