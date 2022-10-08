package Parte04_Exercicio08_Pag217;

public class NavioMercante extends Navio {
	
	protected double capacidadeDeCarga;
	protected double carga;
	
		
	public NavioMercante() {}
	
	public NavioMercante(int numTripulantes, String nome, double capacidadeDeCarga, double carga) {
		super(numTripulantes,nome);
		this.capacidadeDeCarga = capacidadeDeCarga;
		this.carga = carga;
	}
	
	public double getCapacidadeDeCarga() {
		return capacidadeDeCarga;
	}

	public double getCarga() {
		return carga;
	}

	public void setCapacidadeDeCarga(double capacidadeDeCarga) {
		this.capacidadeDeCarga = capacidadeDeCarga;
	}

	public void setCarga(double carga) {
		this.carga = carga;
	}

	public void carregamento(int p1) {
		carga += p1;
		
		super.exibirInfoGeral();
		System.out.println("Volume ocupado: " +(carga/capacidadeDeCarga) );
		
	}
	

}
