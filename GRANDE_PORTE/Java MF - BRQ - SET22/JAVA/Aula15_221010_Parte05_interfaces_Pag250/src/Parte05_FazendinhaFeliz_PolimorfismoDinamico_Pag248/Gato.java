package Parte05_FazendinhaFeliz_PolimorfismoDinamico_Pag248;

public class Gato extends Animal {

	public Gato() {
	}

	public Gato(String nomeAnimal, int idade, String especie, double peso) {
		super(nomeAnimal, idade, especie, peso);
	}

	@Override
	public void som() {
		System.out.println("O Gato emite o som:\t Miau Miau...");
	}

}
