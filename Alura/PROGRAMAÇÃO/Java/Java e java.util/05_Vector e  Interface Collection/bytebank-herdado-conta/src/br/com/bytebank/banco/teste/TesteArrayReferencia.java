package br.com.bytebank.banco.teste;

import br.com.bytebank.banco.modelo.ContaCorrente;

public class TesteArrayReferencia {

	public static void main(String[] args) {
		ContaCorrente [] contas = new ContaCorrente [5]; //Criei um array
		
		ContaCorrente cc = new ContaCorrente(111,222); //Criei um objeto
		
		contas[0] = cc; //aponta para o objeto ContaCorrent
		
		
		ContaCorrente cc1 = new ContaCorrente(2222,3333);
		contas[1] = cc1;
		
		
		//System.out.println(cc1.getNumero());
		
		System.out.println(contas[1].getNumero());
		
		ContaCorrente referencia =  contas[1];
		System.out.println(referencia.getNumero());

	}

}
