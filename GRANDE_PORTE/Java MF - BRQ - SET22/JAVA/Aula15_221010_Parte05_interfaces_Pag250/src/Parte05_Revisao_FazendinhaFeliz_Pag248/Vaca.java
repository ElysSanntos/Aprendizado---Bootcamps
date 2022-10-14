package Parte05_Revisao_FazendinhaFeliz_Pag248;

public class Vaca extends Animal {
	public Vaca() {}
	public Vaca(String nome, int idade, double peso, String especie) {
		super(nome, idade, peso, especie);
	}

	@Override
	public void som() {
		System.out.println("Muuu Muuu...");
	}
}