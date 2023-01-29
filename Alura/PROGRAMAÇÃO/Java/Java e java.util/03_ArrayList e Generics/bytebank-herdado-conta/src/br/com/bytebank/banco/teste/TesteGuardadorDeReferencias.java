package br.com.bytebank.banco.teste;

import br.com.bytebank.banco.modelo.Conta;
import br.com.bytebank.banco.modelo.ContaCorrente;
import br.com.bytebank.banco.modelo.GuardadorDeContas;

public class TesteGuardadorDeReferencias {

	public static void main(String[] args) {

		GuardadorDeContas guardador = new GuardadorDeContas();

		Conta cc = new ContaCorrente(123, 321);
		guardador.adiciona(cc);

		Conta cc1 = new ContaCorrente(1233, 3211);
		guardador.adiciona(cc1);

		int tamanho = guardador.getQtdeElementos();

		System.out.println("Qtde de contas Criadas: " +tamanho);

		//Recuperar  a conta criada
			Conta ref = guardador.getReferencia(0);
			System.out.println("Nº da Conta criada na posição 0: " +ref.getNumero());
	}



}
