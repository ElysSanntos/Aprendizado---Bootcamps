package Parte05_Revisao_FazendinhaFeliz_Pag248;

public class Galinha extends Animal {
	public Galinha() {}
	public Galinha(String nome, int idade, double peso, String especie) {
		super(nome, idade, peso, especie);
	}

	@Override
	public void som() {
		System.out.println("Cocorico...");
	}
}