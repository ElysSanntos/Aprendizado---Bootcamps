package Parte05_Exemplo_Interface_Pag250;

//Classe triângulo implementando a interface
public class Triangulo implements FiguraGeometrica {
// triângulo equilátero
	private double lado;

	public Triangulo(double lado) {
		this.lado = lado;
	}

// métodos da interface sobrecarregados na classe
	public String getNomeFigura() {
		return "triângulo";
	}

	public double getLado() {
		return lado;
	}

	public double getPerimetro() {
		return lado * 3;
	}

	public double getArea() {
		return lado * lado * 0.433;
	}
}