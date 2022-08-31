package com.estruturadados.vetor.teste;

import com.estruturadados.vetor.Vetor_A3_OP2;

public class Aula03_AddElementoNoFimDoVetor_OP2 {

	public static void main(String[] args) {

		Vetor_A3_OP2 vetor2 = new Vetor_A3_OP2(2);
		try {
			vetor2.adiciona2("Posição 0");
			vetor2.adiciona2("Posição 1");
			vetor2.adiciona2("Posição 2");
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		

	}

}
