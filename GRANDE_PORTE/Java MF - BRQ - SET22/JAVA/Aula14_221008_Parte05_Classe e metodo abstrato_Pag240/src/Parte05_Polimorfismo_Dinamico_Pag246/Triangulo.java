package Parte05_Polimorfismo_Dinamico_Pag246;

//Classe Tri�ngulo

public class Triangulo extends PoligonoRegular {
	Triangulo(double medidaLado) {
		this.medidaLado=  medidaLado;
	}

	@Override
	public double area() {
		return medidaLado * medidaLado * 0.433;
	}
}