public class Calculadora {
	// atributos
	private double memoria = 0;
	
	// construtores
	public Calculadora() {}
	public Calculadora(double memoria) {
		this.memoria = memoria;
	}
	
	// getters e setters
	public void setMemoria(double memoria) {
		this.memoria = memoria;
	}
	public double getMemoria() {
		return memoria;
	}
	
	// métodos próprios
	public double somar      (double valor) {return memoria += valor;}
	public double subtrair   (double valor) {return memoria -= valor;}
	public double multiplicar(double valor) {return memoria *= valor;}
	public double dividir    (double valor) {return memoria /= valor;}
	
	public void exibeMemoria() {
		System.out.println("Memoria = " + memoria);
	}
}