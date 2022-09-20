package Aula4_220912.Triangulo_Circulo;

public class Triangulo {
	
	//ATRIBUTOS
	
	private double base;
	private double altura;
	
	
	//CONSTRUTOR
	public Triangulo () {}
	
	public Triangulo(double base, double altura) {
		
		this.base = base;
		this.altura = altura;
	}
	


	
	
	//GETTERS E SETTERS
	
	public double getBase() {
		return base;
	}


	public void setBase(double base) {
		this.base = base;
	}


	public double getAltura() {
		return altura;
	}


	public void setAltura(double altura) {
		this.altura = altura;
	}
	
	//METODOS PROPRIOS DA CLASSE
	
	public double getArea(double base, double altura) {
	 
		return (base * altura)/2.0;
	}
	
	public double getPerimetro() {
		return base + altura + 
				   Math.sqrt(base*base+altura*altura);
    }

}
