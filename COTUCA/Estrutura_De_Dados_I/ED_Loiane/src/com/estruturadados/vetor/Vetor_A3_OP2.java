package com.estruturadados.vetor;

public class Vetor_A3_OP2 {
	
	
		private String[] elementos;
		
		//Atributo para controlar o tamanho real do vetor
		private int tamanho;
		
		public Vetor_A3_OP2(int capacidade) {
			
			this.elementos = new String[capacidade];
			//Inicializar o tamanho
			this.tamanho = 0;
		}
		
		public void adiciona2(String elemento) throws Exception {
			
			if(this.tamanho < this.elementos.length) {
				
				this.elementos[this.tamanho]= elemento;
				this.tamanho++;
			
			}else {
				throw new Exception("Vetor cheio");
			}
				}
		}
	



