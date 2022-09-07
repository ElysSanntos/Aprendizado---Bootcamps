package com.estruturadados.vetor;

import java.util.Arrays;

public class Vetor_A7_adicionaQquerPosicao {
	
	
		private String[] elementos;
		
		//Atributo para controlar o tamanho real do vetor
		private int tamanho;
		
		public Vetor_A7_adicionaQquerPosicao(int capacidade) {
			
			this.elementos = new String[capacidade];
			//Inicializar o tamanho
			this.tamanho = 0;
		}
		
		public boolean adicionaTamanho(String elemento){
			
			if(this.tamanho < this.elementos.length) {
				this.elementos[this.tamanho] = elemento;
				this.tamanho ++;
				return true;
			
			}
			return false;
				}
		
		public boolean adicionaQquerPosicao(int posicao, String elemento) {
			
			return false;
		}
		
		//Método que retorna o tamanho real do Array
		public int getTamanho() {
			
			return this.tamanho;
		}

		//Atalho==> Source>Generate toString
		@Override
		public String toString() {
			
			StringBuilder s = new StringBuilder();
			s.append("Elementos do vetor = [");
			
			for (int i=0; i<this.tamanho-1;i++) {
				s.append(this.elementos[i]);
				s.append(", ");
			}
			if(this.tamanho>0) {
				
				s.append(this.elementos[this.tamanho-1]);
				
			}
			s.append("]");
			return s.toString();
		}
		
		public String buscaPosicaoElemento(int posicao) {
			
			if(!(posicao >=0 && posicao < tamanho)) {
				
				throw new IllegalArgumentException("Posição solicitada é inválida!");
			}
			return this.elementos[posicao];
			
		}
		
		//Verifica se o elemento informado existe no vetor
		
		/*public boolean elementoExiste(String elemento) {
			
			//Algoritmo de busca sequencial - verifica elemento por elemento do array
			
		for(int i = 0; i<this.tamanho; i++) {
				
				if(this.elementos[i].equals(elemento)) {
					
					return true;
				}
			}
			return false;
			*/
			
			//Forma mais elegante
			
			public int elementoExiste(String elemento) {
				
				for (int i = 0; i<this.tamanho;i++) {
					if (this.elementos[i].equals(elemento)) {
						return i;
					}
				}
			return -1; //posição que não existe
		}
		
		
		}
	



