package br.com.treinaweb.primeiroexercicio;

public class ContaCorrenteGold extends ContaCorrente {

	public ContaCorrenteGold(double saldo) {
		super(saldo);
	}

	@Override
	public void deposito(double valor) {
		this.saldo = saldo + (3 * valor);
	}
}
