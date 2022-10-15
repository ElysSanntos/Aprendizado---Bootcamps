package Parte05_ClasseGenerica_Pag257;

public class Tupperware extends Caixa {

	public Tupperware() {}

	public <T>Tupperware(T dado) {
		super(dado);
	}

}
