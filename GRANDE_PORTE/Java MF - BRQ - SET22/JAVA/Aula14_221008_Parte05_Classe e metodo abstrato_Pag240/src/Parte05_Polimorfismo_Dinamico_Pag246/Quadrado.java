package Parte05_Polimorfismo_Dinamico_Pag246;

//Classe Quadrado



public class Quadrado extends PoligonoRegular {
	Quadrado(double medidaLado) {
		this.medidaLado = medidaLado;
	}

	public double area() {
		return medidaLado * medidaLado;
	}
}