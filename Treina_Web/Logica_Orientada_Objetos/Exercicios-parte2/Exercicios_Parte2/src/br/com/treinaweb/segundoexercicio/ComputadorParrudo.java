package br.com.treinaweb.segundoexercicio;

public class ComputadorParrudo extends Computador {
	private String corGabinete;
	
	public String getCorGabinete() {
		return corGabinete;
	}

	public void setCorGabinete(String corGabinete) {
		this.corGabinete = corGabinete;
	}

	public void jogarCounterStrike(){
		System.out.println("Jogando Counter Strike!");
	}
}
