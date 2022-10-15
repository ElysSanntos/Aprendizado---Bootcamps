package Parte05_FazendinhaFeliz_PolimorfismoDinamico_Pag248;

public class Galinha extends Animal {

	public Galinha() {
	}

	public Galinha(String nomeAnimal, int idade, String especie, double peso) {
		super(nomeAnimal, idade, especie, peso);
	}

	@Override
	public void som() {
		System.out.println("O Galinha emite o som:\t Cocoricó cocoricó ....");
	}

}
