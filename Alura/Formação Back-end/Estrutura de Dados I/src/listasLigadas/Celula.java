package listasLigadas;

public class Celula {
	
	private Object elemento;
	private Celula proximo;
	
	//Criar os construtures ==> Ctrl + 3 (abre o poupup) digita gcuf
	public Celula(Object elemento, Celula proximo) {
		super();
		this.elemento = elemento;
		this.proximo = proximo;
	}
	
	//Criar getters e setters ==> Ctrl + 3 (abre o poup up) digita ggas
	

	public Object getElemento() {
		return elemento;
	}

	public void setElemento(Object elemento) {
		this.elemento = elemento;
	}

	public Celula getProximo() {
		return proximo;
	}

	public void setProximo(Celula proximo) {
		this.proximo = proximo;
	}
	

	

}
