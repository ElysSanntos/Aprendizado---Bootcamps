package br.com.treinaweb.primeiroexercicio;

public class Correntista {
	private String nome;
	private String sobrenome;
	private int idade;
	private int CPF;
	private ContaCorrente conta;
	
	public String getNome() {
		return nome;
	}
	
	public String getSobrenome() {
		return sobrenome;
	}

	public void setSobrenome(String sobrenome) {
		this.sobrenome = sobrenome;
	}

	public int getIdade() {
		return idade;
	}

	public void setIdade(int idade) {
		this.idade = idade;
	}

	public int getCPF() {
		return CPF;
	}

	public void setCPF(int cPF) {
		CPF = cPF;
	}

	public ContaCorrente getConta() {
		return conta;
	}

	public void setConta(ContaCorrente conta) {
		this.conta = conta;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public void saque(double valor){
		conta.saque(valor);
	}
	
	public void deposito(double valor){
		conta.deposito(valor);
	}
	
	public double saldo(){
		return conta.getSaldo();
	}
}
