package armazenamentoSequencial_E_Vetores;

import java.util.Arrays;

public class Vetor {

	private Aluno[] alunos = new Aluno[100];
	private int totalDeAlunos = 0;

//Metodos dos comportamentos da lista

	public void adiciona(Aluno aluno) { // adiciona um aluno a lista

//	Comentar/Descomentar de uma linha Ctrl + /
//	Comentários de varias linhas Ctrl + Shift + /

		/*
		 * Essa lógica funciona, mas é onerosa pq tem que percorrer todo o array 
		 * for(int i = 0;i< alunos.length;i++) { 
		 * if(alunos[i] == null) { 
		 * alunos[i] = aluno;
		 * break; } 
		 * }
		 * 
		 */
		
		//Essa solução leva tempo constante
		this.alunos[totalDeAlunos]= aluno; //TotalDeAlunos aponta para um buraco no array
		totalDeAlunos++;
	}
	private boolean posicaoValida(int posicao) {
		return posicao>= 0 && posicao <= totalDeAlunos;
	}
	
	private void garanteEspaco() {
	    if(totalDeAlunos == alunos.length) {
	        Aluno[] novoArray = new Aluno[alunos.length*2];
	        for(int i = 0; i < alunos.length; i++) {
	            novoArray[i] = alunos[i];
	        }
	        this.alunos= novoArray;
	    }
	}
	public void adicionaQualquerLugar(int posicao, Aluno aluno) {
		if(!posicaoValida(posicao)) {
			throw new IllegalArgumentException("Posição inválida!");
		}
		//abrir o buraco na posição desejada - Começa o for pelo fim
		for(int i = totalDeAlunos;i >= posicao;i=-1) {//empurra todo mundo pra direita - abre um espaço
			alunos[i+1]=alunos[i];//pegando a posição a direita e levando para a esquerda
			alunos[posicao]=aluno;
			totalDeAlunos++;
		}
	}
	private boolean posicaoOcupada(int posicao) {
		return posicao>= 0 && posicao < totalDeAlunos;
	
}
	public Aluno pega(int posicao) {// pega o aluno que está em determinada posição
		if(!posicaoOcupada(posicao)){
			throw new IllegalArgumentException("Posição já ocupada");
		}
			return alunos[posicao];
		}
	

	public void remove(int posicao) {
		for(int i = posicao;i < this.totalDeAlunos; i++ ) {
			this.alunos[i] = this.alunos[i +1];
		}
		totalDeAlunos --;

	}

	public boolean contem(Aluno aluno) {// Avalia se o aluno está na lista
		
		for(int i =0;i<totalDeAlunos;i++) {
			if(aluno.equals(alunos[i])) {
				return true;
						
			}
		}
		
		return false;
	}

	public int tamanho() {// devolve a qtd de alunos na lista
		return totalDeAlunos;
	}

	@Override
	public String toString() {// pega todos os elementos do array e chama o toString deles
		return Arrays.toString(alunos);
	}
}
