package Parte05_Exemplo_Interface_Pag250;

//Classe Mostrador
public class Mostrador {
	public void mostraNomeFigura(FiguraGeometrica f) {
		System.out.println("figura = " + f.getNomeFigura());
	}

	public void mostraLado(FiguraGeometrica f) {
		System.out.println("lado = " + f.getLado());
	}

	public void mostraPerimetro(FiguraGeometrica f) {
		System.out.println("perímetro = " + f.getPerimetro());
	}

	public void mostraArea(FiguraGeometrica f) {
		System.out.println("área = " + f.getArea());
	}
}