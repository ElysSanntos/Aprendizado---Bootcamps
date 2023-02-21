package br.com.bytebank.banco.test.util;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import br.com.bytebank.banco.modelo.Conta;
import br.com.bytebank.banco.modelo.ContaCorrente;
import br.com.bytebank.banco.modelo.ContaPoupanca;



public class TesteClasseAnonima {

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

         lista.sort(new Comparator<Conta>() { //classe anonima

             @Override
             public int compare(Conta c1, Conta c2) {

                 return Integer.compare(c1.getNumero(), c2.getNumero());
                         }
                     }
                     );

                     Comparator<Conta> comp = new Comparator<Conta>() {

                             @Override
                             public int compare(Conta c1, Conta c2) {
                                 String nomeC1 = c1.getTitular().getNome();
                                 String nomeC2 = c2.getTitular().getNome();
                                 return nomeC1.compareTo(nomeC2);
                             }
                     };

             for (Conta conta : lista) {
                     System.out.println(conta + ", " + conta.getTitular().getNome());
             }
        }
	}

