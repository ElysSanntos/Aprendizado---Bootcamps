package Parte05_FazendinhaFeliz_PolimorfismoDinamico_Pag248;

public class Vaca extends Animal {

	public Vaca() {
	}

	public Vaca(String nomeAnimal, int idade, String especie, double peso) {
		super(nomeAnimal, idade, especie, peso);
	}

	@Override
	public void som() {
		System.out.println("O Vaca emite o som:\t Muuuu Muuuu.....");
	}

}
