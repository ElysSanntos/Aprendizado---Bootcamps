package Parte05_FazendinhaFeliz_PolimorfismoDinamico_Pag248;

public class Cachorro extends Animal {

	public Cachorro() {}

	public Cachorro(String nomeAnimal, int idade, String especie, double peso) {
		super(nomeAnimal, idade, especie, peso);
	}

	@Override
	public void som() {
		
		System.out.println("O Cachorro emite o som:\t Au Au...");

	}

}
