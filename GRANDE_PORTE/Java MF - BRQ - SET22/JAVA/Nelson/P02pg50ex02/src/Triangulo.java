public class Triangulo {
	// atributos
	private double base;
	private double altura;
	
	// construtores
	public Triangulo () {}
	public Triangulo(double base, double altura) {
		this.base = base;
		this.altura = altura; 
	}
	
	// getters
	public double getBase() {
		return base;
	}
	public double getAltura() {
		return altura;
	}
	
	// setters
	public void setBase(double base) {
		this.base = base;
	}
	public void setAltura(double altura) {
		this.altura = altura;
	}
	
	// métodos próprios da classe
	public double getArea() {
		return (base * altura)/2.0;
	}
	public double getPerimetro() {
		return base + altura + 
			   Math.sqrt(base*base+altura*altura);
	}
}