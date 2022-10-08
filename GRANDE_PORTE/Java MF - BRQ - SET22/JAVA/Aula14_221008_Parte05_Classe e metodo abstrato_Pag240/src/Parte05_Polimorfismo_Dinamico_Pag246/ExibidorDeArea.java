package Parte05_Polimorfismo_Dinamico_Pag246;

//Classe polimorfismo dinâmico (Sobreposição)
//Classe ExibidorDeArea

public class ExibidorDeArea {
	public void exibeArea(PoligonoRegular p) {
		System.out.println("*-----------------*");
		System.out.println("Área = " + p.area());
		System.out.println("*-----------------*");
	}
}