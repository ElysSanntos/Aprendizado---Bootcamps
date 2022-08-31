package com.estruturadados.vetor;

public class Vetor {
	
	private String[] elementos;
	
	public Vetor(int capacidade) {
		
		this.elementos = new String[capacidade];
	}
	
	public void adiciona(String elemento) {
		
		//iterar o vetor 
		for (int i = 0; i<this.elementos.length;i++) {
		
			//Verificar se existe uma posi��o nula, e ai podemos adicionar nosso elemento
			if(this.elementos[i] == null) {
				this.elementos[i] = elemento;
				//Parar o c�digo na primeiro posi��o que for nula
				break;
				
			}
			
			
		}
	}
}
