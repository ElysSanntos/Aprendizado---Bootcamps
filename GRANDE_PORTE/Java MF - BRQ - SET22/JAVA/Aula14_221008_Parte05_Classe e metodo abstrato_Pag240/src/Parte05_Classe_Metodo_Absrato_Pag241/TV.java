package Parte05_Classe_Metodo_Absrato_Pag241;

public class TV extends Eletrodomestico {
	// Está como private, pois não temos a intenção de extender a classe.
	private int tamanho;
	private int canal;
	private int volume;

	//CONSTRUTORES
	public TV() {}
	
	public TV(int tamanho, int voltagem) {
		 super (false, voltagem); 
		 this.tamanho = tamanho;
		 this.canal = 0;
		 this.volume = 0;
		 }

	public TV(int tamanho, int voltagem, int canal, int voume) {
		super(false, voltagem); // construtor classe abstrata
		this.tamanho = tamanho;
		this.canal = 0;
		this.volume = 0;
	}

	public int getTamanho() {
		return tamanho;
	}

	public int getCanal() {
		return canal;
	}

	public int getVolume() {
		return volume;
	}

	public void setTamanho(int tamanho) {
		this.tamanho = tamanho;
	}

	public void setCanal(int canal) {
		this.canal = canal;
	}

	public void setVolume(int volume) {
		this.volume = volume;
	}
	// implementação dos métodos abstratos

	@Override
	public void desligar() {
		super.setLigado(false);
		setCanal(0);
		setVolume(0);
	}
	@Override
	public void ligar() {
		super.setLigado(true);
		setCanal(3);
		setVolume(25);
	}
	
}
