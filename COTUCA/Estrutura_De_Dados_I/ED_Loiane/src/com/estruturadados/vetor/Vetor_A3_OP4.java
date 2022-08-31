package com.estruturadados.vetor;

public class Vetor_A3_OP4 {
	
	
		private String[] elementos;
		
		//Atributo para controlar o tamanho real do vetor
		private int tamanho;
		
		public Vetor_A3_OP4(int capacidade) {
			
			this.elementos = new String[capacidade];
			//Inicializar o tamanho
			this.tamanho = 0;
		}
		
		public boolean adiciona3(String elemento){
			
			if(this.tamanho < this.elementos.length) {
				this.elementos[this.tamanho] = elemento;
				this.tamanho ++;
				return true;
			
			}
			return false;
				}
		}
	



