package br.com.bytebank.banco.teste;

import br.com.bytebank.banco.modelo.Conta;
import br.com.bytebank.banco.modelo.ContaCorrente;
import br.com.bytebank.banco.modelo.ContaPoupanca;

public class TesteArrayReferencia2 {

	public static void main(String[] args) {
		Conta [] contaCC = new ContaCorrente [5]; //Criei um array
		Conta [] contaCP = new ContaPoupanca [5]; //Criei um array
		
		ContaCorrente cc = new ContaCorrente(111,222); //Criei um objeto
		ContaPoupanca cp = new ContaPoupanca(4444,5555); //Criei um objeto
		
		contaCC[0] = cc; //aponta para o objeto ContaCorrente
		contaCP[0] = cp; //aponta para o objeto ContaPoupanca
		
		
		ContaCorrente cc1 = new ContaCorrente(2222,3333);
		contaCC[1] = cc1;
		
		
		//System.out.println(cc1.getNumero());
		
		//System.out.println(contas[1].getNumero());
		
		ContaCorrente referencia =  (ContaCorrente) contaCC[1]; //Cast (type Cast) de referencia
		//Conta referencia =   contas[1];
		
		ContaPoupanca referencia2 =  (ContaPoupanca) contaCP[0];
		
		System.out.println("Conta Corrente de referencia:  " +referencia.getNumero());
		System.out.println("Conta Poupanca de referencia:  " +referencia2.getNumero());

	}

}
