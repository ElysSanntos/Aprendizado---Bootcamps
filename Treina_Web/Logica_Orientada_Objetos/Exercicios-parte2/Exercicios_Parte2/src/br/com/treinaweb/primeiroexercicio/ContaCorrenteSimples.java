package br.com.treinaweb.primeiroexercicio;

public class ContaCorrenteSimples extends ContaCorrente {

	public ContaCorrenteSimples(double saldo) {
		super(saldo);
	}

	@Override
	public void deposito(double valor) {
		this.saldo = saldo + valor;
	}
}
