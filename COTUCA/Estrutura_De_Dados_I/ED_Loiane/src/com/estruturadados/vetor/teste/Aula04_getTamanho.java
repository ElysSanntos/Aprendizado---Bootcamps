package com.estruturadados.vetor.teste;

import com.estruturadados.vetor.Vetor_A4_getTamanho;

public class Aula04_getTamanho {

	public static void main(String[] args) {

		Vetor_A4_getTamanho vetor4 = new Vetor_A4_getTamanho(10);
		{
			vetor4.adicionaTamanho("Posição ocupada [0]");
			vetor4.adicionaTamanho("Posição ocupada [1]");
			vetor4.adicionaTamanho("Posição ocupada [2]");
			
			System.out.println("Quantidade de elementos no vetor: "+vetor4.getTamanho());
			System.out.println(vetor4.toString());
		}
	}
}
