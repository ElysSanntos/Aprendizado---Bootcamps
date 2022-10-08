package Parte05_Classe_Metodo_Absrato_Pag241;

/*É possível tirar grande vantagem do uso de classes abstratas tanto com 
 * herança quanto com polimorfismo. Herdando uma classe abstrata se garante uma
 * maior integridade para o sistema, pois é uma forma de proibir que uma classe
 * incompleta seja instanciada*/

public abstract class Eletrodomestico {
	protected boolean ligado;
	protected int voltagem;

	// métodos abstratos - não possuem corpo
	public abstract void ligar();

	public abstract void desligar();

	// método construtor – não pode ser usado para instanciar objetos
	public Eletrodomestico() {}
	public Eletrodomestico(boolean ligado, int voltagem) {
		this.ligado = ligado;
		this.voltagem = voltagem;
	}

	// Uma classe abstrata pode possuir métodos concretos
	public void setVoltagem(int voltagem) {
		this.voltagem = voltagem;
	}

	public int getVoltagem() {
		return this.voltagem;
	}

	public void setLigado(boolean ligado) {
		this.ligado = ligado;
	}

	//Métodos próprios
	public boolean isLigado() {
		return this.ligado;
	}
}
