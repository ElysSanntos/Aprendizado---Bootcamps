package Parte05_Polimorfismo_Dinamico_Pag246;

//Classe polimorfismo din�mico (Sobreposi��o)
//Classe ExibidorDeArea

public class ExibidorDeArea {
	public void exibeArea(PoligonoRegular p) {
		System.out.println("*-----------------*");
		System.out.println("�rea = " + p.area());
		System.out.println("*-----------------*");
	}
}