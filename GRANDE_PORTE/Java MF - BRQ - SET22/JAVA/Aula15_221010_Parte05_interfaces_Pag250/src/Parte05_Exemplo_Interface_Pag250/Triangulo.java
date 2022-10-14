package Parte05_Exemplo_Interface_Pag250;

//Classe tri�ngulo implementando a interface
public class Triangulo implements FiguraGeometrica {
// tri�ngulo equil�tero
	private double lado;

	public Triangulo(double lado) {
		this.lado = lado;
	}

// m�todos da interface sobrecarregados na classe
	public String getNomeFigura() {
		return "tri�ngulo";
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