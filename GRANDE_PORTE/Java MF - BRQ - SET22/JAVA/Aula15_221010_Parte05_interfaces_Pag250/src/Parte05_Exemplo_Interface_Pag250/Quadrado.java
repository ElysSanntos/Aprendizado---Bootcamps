package Parte05_Exemplo_Interface_Pag250;

//Classe Quadrado implementando a interface
public class Quadrado implements FiguraGeometrica {
	private double lado;

	public Quadrado(double lado) {
		this.lado = lado;
	}

// métodos da interface sobrecarregados na classe
	public String getNomeFigura() {
		return "quadrado";
	}

	public double getLado() {
		return lado;
	}

	public double getPerimetro() {
		return lado * 4.0;
	}

	public double getArea() {
		return lado * lado;
	}
}
