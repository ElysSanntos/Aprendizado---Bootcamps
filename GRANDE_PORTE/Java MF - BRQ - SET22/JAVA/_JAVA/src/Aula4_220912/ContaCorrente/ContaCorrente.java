package Aula4_220912.ContaCorrente;

public class ContaCorrente {

	// ATRIBUTOS
	private int numCC;
	private double saldoCC = 0.0;

	// CONSTRUTOR
	public ContaCorrente() {
	}

	public ContaCorrente(int numCC, double saldoCC) {

		this.numCC = numCC;
		this.saldoCC = saldoCC;
	}

	// GETTERS E SETTERS

	public int getNumCC() {
		return numCC;
	}

	public void setNumCC(int numCC) {
		this.numCC = numCC;
	}

	public double getSaldoCC() {
		return saldoCC;
	}

	public void setSaldoCC(double saldoCC) {
		this.saldoCC = saldoCC;
	}

	// METODOS PROPRIOS DA CLASSE
	public void depositar(double valor) {
		 this.saldoCC += valor;

	}

	public void sacar(double valor) {
		this.saldoCC -= valor;
	}
	
	public void imprimeCC() {
		System.out.println("CC: " + getNumCC() + "\t Saldo: " + getSaldoCC());
	}
}
