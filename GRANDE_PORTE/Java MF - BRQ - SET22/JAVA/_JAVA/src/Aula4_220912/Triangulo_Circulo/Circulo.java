package Aula4_220912.Triangulo_Circulo;

public class Circulo {
	//ATRIBUTOS
	private double raio;
	
	//CONSTRUTOR
	public Circulo() {}
	public Circulo(double raio) {
		this.raio = raio;
	}
	
	//GETTERS E SETTERS
	public double getRaio() {
		return raio;
	}
	public void setRaio(double raio) {
		this.raio = raio;
	}
	
	//METODOS PROPRIOS DA CLASSE
		public double getArea() {
			return Math.PI * raio * raio;
		}
		public double getPerimetro() {
			return 2.0 * Math.PI * raio;
		}
	

}
