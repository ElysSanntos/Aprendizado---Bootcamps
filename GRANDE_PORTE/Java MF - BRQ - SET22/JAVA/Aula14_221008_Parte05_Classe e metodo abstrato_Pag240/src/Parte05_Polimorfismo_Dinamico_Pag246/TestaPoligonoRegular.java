package Parte05_Polimorfismo_Dinamico_Pag246;

public class TestaPoligonoRegular {

	public static void main(String[] args) {
		// Classe TestaPoligonoRegular

		PoligonoRegular Q = new Quadrado(10.0);
		PoligonoRegular T = new Triangulo(10.0);
		//PoligonoRegular pr = PoligonoRegular(10.0);
		Triangulo t = new Triangulo(10.0);
		
		ExibidorDeArea arquimedes = new ExibidorDeArea();
		arquimedes.exibeArea(Q);
		arquimedes.exibeArea(T);
		arquimedes.exibeArea(t);

	}

}
