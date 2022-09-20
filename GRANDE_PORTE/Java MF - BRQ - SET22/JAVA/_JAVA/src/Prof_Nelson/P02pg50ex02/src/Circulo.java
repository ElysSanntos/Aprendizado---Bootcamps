public class Circulo {
	// atributos
	private double raio;
	
	// construtores
	public Circulo() {}
	public Circulo(double raio) {
		this.raio = raio;
	}
	// getters
	public double getRaio() {
		return raio; 
	}
	// setters
	public void setRaio(double raio) {
		this.raio = raio;
	}
	// métodos próprios
	public double getArea() {
		return Math.PI * raio * raio;
	}
	public double getPerimetro() {
		return 2.0 * Math.PI * raio;
	}
}