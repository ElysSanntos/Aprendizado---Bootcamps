package Parte04_Exercicio04_HerançaFinal_Pag212;

public class Chefe extends Funcionario {
	// ATRIBUTOS
	protected double contas;
	protected double gastosExtras;
	protected double adicionalChefia;
	
	//CONSTRUTORES
	public Chefe() {}
	public Chefe(String nome, String rg, double salarioMensal, double contas, double gastosExtras,
			double adicionalChefia) {
		super(nome, rg, salarioMensal);
		this.contas = contas;
		this.gastosExtras = gastosExtras;
		this.adicionalChefia = adicionalChefia;
	}
	
	// GETTERS E SETTERS	
	public double getContas() {
		return contas;
	}
	public double getGastosExtras() {
		return gastosExtras;
	}
	public double getAdicionalChefia() {
		return adicionalChefia;
	}
	public void setContas(double contas) {
		this.contas = contas;
	}
	public void setGastosExtras(double gastosExtras) {
		this.gastosExtras = gastosExtras;
	}
	public void setDicionalChefia(double adicionalChefia) {
		this.adicionalChefia = adicionalChefia;
	}
	
	//MÉTODOS PROPRIOS DA CLASSE
	public double pagamentoExtra() {
		
		
		return pagamento()+ contas + gastosExtras + getAdicionalChefia();
	}

}
