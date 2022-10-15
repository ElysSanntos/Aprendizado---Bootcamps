package Parte05_ClasseGenerica_Pag257;

public class Caixa<T> {

	private T dado;

	public Caixa() {}

	public Caixa(T dado) {
		this.dado = dado;
	}

	
	public T getDado() {
		return dado;
	}

	public void setDado(T dado) {
		this.dado = dado;
	}

}
