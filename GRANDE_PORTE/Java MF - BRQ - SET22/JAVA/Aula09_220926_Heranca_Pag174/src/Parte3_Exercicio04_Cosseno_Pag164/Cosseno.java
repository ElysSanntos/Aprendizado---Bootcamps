package Parte3_Exercicio04_Cosseno_Pag164;

public class Cosseno {
	
	//ATRIBUTOS
	private double x;
	private double [] parcelas = new double[10];
	private double cosseno;
	
	//CONSTRUTORES
	public Cosseno() {}


	public Cosseno(double x) {
		this.x = x;
		//Caso eu tenha o valor do angulo já posso chamar os metodos aqui
		somaParcelas();
		calculaParcelas();
		
	}

	//GETTERS E SETTERS
	public double getX() {
		return x;
	}


	public double[] getParcelas() {
		return parcelas;
	}


	public double getCosseno() {
		return cosseno;
	}


	public void setX(double x) {
		this.x = x;
	}


	public void calculaParcelas() {
		int potencia = 0;
		for (int i = 0; i < 10; i++) {
			parcelas[i] = Math.pow(x,potencia)/ fatorial(potencia);
			potencia =+2;
			
		}
	}
	private long fatorial(int numero) {
		if(numero<=1)return 1;
		return numero*fatorial(numero-1);
	}
	public void somaParcelas() {
		
		double soma = 0.0;
		for (double balde : parcelas) {
			soma += balde;
			
		}
		cosseno = soma;
	}
	
	
	
	
	
	

}
