package Parte05_Revisao_FazendinhaFeliz_Interface_Pag316;

public class Galinha extends Animal  {
	public Galinha() {}
	public Galinha(String nome, int idade, double peso, String especie) {
		super(nome, idade, peso, especie);
	}

	@Override
	public void som() {
		System.out.println("Cocorico...");
	}
}