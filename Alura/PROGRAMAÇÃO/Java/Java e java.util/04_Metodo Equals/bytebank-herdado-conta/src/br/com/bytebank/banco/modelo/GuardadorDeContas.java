package br.com.bytebank.banco.modelo;

public class GuardadorDeContas {

	private Conta[] referencias;

	//Variavel auxiliar para se lembrar qual a ultima posição utilizada
	private int posicaoLivre;

	public GuardadorDeContas() {

		this.referencias = new Conta[10];
		this.posicaoLivre = 0; //Linha não necessaria, dado que um atributo é automaticamente inicializado ocm zero.
	}



	public void adiciona(Conta ref) {

		this.referencias[this.posicaoLivre] = ref;
		this.posicaoLivre ++;
	}



	public int getQtdeElementos() {


		return this.posicaoLivre;
	}



	public Conta getReferencia(int posicao) {

		return this.referencias[posicao];
	}



}
