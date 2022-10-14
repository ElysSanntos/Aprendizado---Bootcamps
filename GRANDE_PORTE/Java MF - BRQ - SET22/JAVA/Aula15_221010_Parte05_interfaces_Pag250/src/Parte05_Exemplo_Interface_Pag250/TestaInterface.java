package Parte05_Exemplo_Interface_Pag250;

public class TestaInterface {
	public static void main(String[] args) {
		// usando a interface como tipo de referência aos objetos
		FiguraGeometrica Q = new Quadrado(10.0);
		FiguraGeometrica T = new Triangulo(10.0);
		// criando um Mostrador
		Mostrador jose = new Mostrador();
		System.out.println("*-----------------*");
		jose.mostraNomeFigura(Q);
		jose.mostraLado(Q);
		jose.mostraPerimetro(Q);
		jose.mostraArea(Q);
		System.out.println("*-----------------*");
		jose.mostraNomeFigura(T);
		jose.mostraLado(T);
		jose.mostraPerimetro(T);
		jose.mostraArea(T);
		System.out.println("*-----------------*");
	}
}