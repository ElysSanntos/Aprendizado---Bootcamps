package br.com.treinaweb.primeiroexercicio;

public abstract class ContaCorrente {
	private int agencia;
	private int nrConta;
	protected double saldo;
	
	public ContaCorrente(double saldo){
		this.saldo = saldo;
	}
	
	public int getAgencia() {
		return agencia;
	}
	
	public void setAgencia(int agencia) {
		this.agencia = agencia;
	}

	public int getNrConta() {
		return nrConta;
	}

	public void setNrConta(int nrConta) {
		this.nrConta = nrConta;
	}

	public double getSaldo() {
		return saldo;
	}

	protected void setSaldo(double saldo) {
		this.saldo = saldo;
	}
	
	public void saque(double valor){
		this.saldo = saldo - valor;
	}
	
	public abstract void deposito(double valor);
}
