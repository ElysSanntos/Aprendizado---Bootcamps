package com.estruturadados.vetor;

import java.util.Arrays;

public class Vetor_A4_getTamanho {
	
	
		private String[] elementos;
		
		//Atributo para controlar o tamanho real do vetor
		private int tamanho;
		
		public Vetor_A4_getTamanho(int capacidade) {
			
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
		
		
		}
	



