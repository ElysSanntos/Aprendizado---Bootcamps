package Parte05_Classe_Metodo_Absrato_Pag241;

public class Radio extends Eletrodomestico {
	public static final short AM = 1; //static pq vai ficar apenas nessa classe
	public static final short FM = 2;//Final é uma constante
	private int banda;
	private float sintonia;
	private int volume;
	
	
	//CONSTRUTORES
	public Radio() {}
	public Radio(int voltagem) {
		super(false, voltagem);
		 setBanda(Radio.FM);
		 setSintonia(0);
		 setVolume(0);
	}
	public Radio(boolean ligado,
				 int voltagem, 
				 int banda, 
				 float sintonia, 
				 int volume) {
		super(false, voltagem);
		setBanda(Radio.FM);
		setSintonia(0);
		setVolume(0);
	}
	
	public static short getAm() {
		return AM;
	}
	public static short getFm() {
		return FM;
	}
	public int getBanda() {
		return banda;
	}
	public float getSintonia() {
		return sintonia;
	}
	public int getVolume() {
		return volume;
	}
	public void setBanda(int banda) {
		this.banda = banda;
	}
	public void setSintonia(float sintonia) {
		this.sintonia = sintonia;
	}
	public void setVolume(int volume) {
		this.volume = volume;
	}
	

	// implementação dos métodos abstratos
	public void desligar() {
		super.setLigado(false);
		setSintonia(0);
		setVolume(0);
	}

	
	public void ligar() {
		super.setLigado(true);
		setSintonia(88.1f);
		setVolume(25);
	}
	
}