package Parte05_Polimorfismo_Estatico_Ou_Sobrecarga_Pag245;

//Classe polimorfismo Estático (sobrecarga)

public class TestaCalculadorDeAreas {
	public static void main(String[] args) {
		CalculadorDeAreas Imotepe = new CalculadorDeAreas();
		int ladoInt = 20;
		double ladoDouble = 20.0;
		System.out.println(Imotepe.areaQuadrado(ladoInt));
		System.out.println(Imotepe.areaQuadrado(ladoDouble));
	}
}