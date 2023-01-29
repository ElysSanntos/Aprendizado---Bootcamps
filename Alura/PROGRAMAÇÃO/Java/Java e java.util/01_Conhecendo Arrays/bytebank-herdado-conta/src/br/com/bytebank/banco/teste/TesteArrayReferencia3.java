package br.com.bytebank.banco.teste;

import br.com.bytebank.banco.modelo.Cliente;
import br.com.bytebank.banco.modelo.Conta;
import br.com.bytebank.banco.modelo.ContaCorrente;
import br.com.bytebank.banco.modelo.ContaPoupanca;

public class TesteArrayReferencia3 {

	public static void main(String[] args) {
		Object [] referencias = new Object [5]; //Criei um array
		//Object [] contaCP = new Object [5]; //Criei um array
		
		ContaCorrente cc = new ContaCorrente(111,222); //Criei um objeto
		ContaCorrente cc1 = new ContaCorrente(2222,3333); // Criei um segundo objeto
		Cliente cliente = new Cliente();
		
		ContaPoupanca cp = new ContaPoupanca(4444,5555); //Criei um objeto
		ContaPoupanca cp1 = new ContaPoupanca(666,777); //Criei um segundo objeto de CP
		
		referencias[0] = cc; //aponta para o objeto ContaCorrente alocado na posição 0 do array
		referencias[1] = cc1;//aponta para o segundo objeto ContaCorrente, alocado na posição 1 do array
		
//		contaCP[0] = cp; //aponta para o objeto ContaPoupanca
//		contaCP[1] = cp; //aponta para o segundo objeto ContaPoupanca

		referencias[1] = cliente; // Criando referencia
		
		
		ContaCorrente referencia =  (ContaCorrente) referencias[1]; //Cast (type Cast) de referencia
	
//		Object referenciaGenerica = contaCC[1];
//		System.out.println(referenciaGenerica.getNumero());
		
		ContaPoupanca referencia2 =  (ContaPoupanca) referencias[0];
		
		System.out.println("Conta Corrente de referencia:  " +referencia.getNumero());
		
		
		System.out.println("Conta Poupanca de referencia:  " +referencia2.getNumero());

	}

}
