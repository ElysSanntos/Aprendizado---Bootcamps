package br.com.bytebank.banco.modelo;

public class GuardadorDeReferencias {

	private Object[] referencias;

	//Variavel auxiliar para se lembrar qual a ultima posição utilizada
	private int posicaoLivre;

	public GuardadorDeReferencias() {

		this.referencias = new Object[10];
		this.posicaoLivre = 0; //Linha não necessaria, dado que um atributo é automaticamente inicializado ocm zero.
	}



	public void adiciona(Object ref) {

		this.referencias[this.posicaoLivre] = ref;
		this.posicaoLivre ++;
	}



	public int getQtdeElementos() {


		return this.posicaoLivre;
	}



	public Object getReferencia(int posicao) {

		return this.referencias[posicao];
	}



}
