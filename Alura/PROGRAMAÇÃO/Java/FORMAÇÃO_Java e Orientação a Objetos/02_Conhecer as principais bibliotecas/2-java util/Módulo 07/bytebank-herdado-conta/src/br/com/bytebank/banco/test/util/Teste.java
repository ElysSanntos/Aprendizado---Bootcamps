package br.com.bytebank.banco.test.util;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import br.com.bytebank.banco.modelo.Conta;
import br.com.bytebank.banco.modelo.ContaCorrente;
import br.com.bytebank.banco.modelo.ContaPoupanca;

public class Teste {

	public static void main(String[] args) {

		 Conta cc1 = new ContaCorrente(22, 33);
         cc1.deposita(333.0);


         Conta cc2 = new ContaPoupanca(22, 44);
         cc2.deposita(444.0);

         Conta cc3 = new ContaCorrente(22, 11);
         cc3.deposita(111.0);

         Conta cc4 = new ContaPoupanca(22, 22);
         cc4.deposita(222.0);

         List<Conta> lista = new ArrayList<>();
         lista.add(cc1);
         lista.add(cc2);
         lista.add(cc3);
         lista.add(cc4);

         System.out.println("----------------------Pré Ordenação-------------------------------------");
         System.out.println();
         for ( Conta conta : lista) {

        	 System.out.println(conta);
		}



         NumeroDaContaComparator comparator = new  NumeroDaContaComparator();
         lista.sort(comparator);

//        TitularDaContaComparator titularComparator = new TitularDaContaComparator();
//         lista.sort(titularComparator);

         /*Simplificação*/

         lista.sort(null);

         /*Simplificação baseada na ordem natural definida na classe Conta*/

//         lista.sort(new TitularDaContaComparator());


         /*Forma legada para fazer ordenação*/

         Collections.sort(lista, new  NumeroDaContaComparator());
         Collections.sort(lista);

         /*Métodos auxiliares da classe Collections*/

         Collections.reverse(lista); //inverte a ordenação das contas da maior para a menor


         System.out.println();
         System.out.println("----------------------Pós Ordenação-------------------------------------");
         System.out.println();
         for ( Conta conta : lista) {

        	 System.out.println(conta);
		}
	}

}

class NumeroDaContaComparator implements Comparator<Conta>{

//	@Override
//	public int compare(Conta c1, Conta c2) {
//
//		if(c1.getNumero() < c2.getNumero()) {
//			return -1; // valor negativo para conta menor
//		}
//
//     if(c1.getNumero() > c2.getNumero()) {
//			return 1; // valor positivo para conta maior
//		}
//
//		return 0; // valor zero para contas iguais
//	}

	/*SIMPLIFICAÇÃO 1
	 * Sempre que houver critérios numéricos podemos utilizar dessa forma:*/

//	@Override
//	public int compare(Conta c1, Conta c2) {
//
//		return c1.getNumero() - c2.getNumero();
//	}

	/*SIMPLIFICAÇÃO 2 - Forma mais elegante:*/

	@Override
	public int compare(Conta c1, Conta c2) {

		return Integer.compare(c1.getNumero(),c2.getNumero());
	}


	class TitularDaContaComparator implements Comparator<Conta> {

        @Override
        public int compare(Conta c1, Conta c2) {

                String nomeC1 = c1.getTitular().getNome();
                String nomeC2 = c2.getTitular().getNome();
                return nomeC1.compareTo(nomeC2);
        }}

}
