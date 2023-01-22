package br.com.elys.bytebank.banco.teste;

import br.com.elys.bytebank.banco.modelo.ContaCorrente;
import br.com.elys.bytebank.banco.modelo.ContaPoupanca;
import br.com.elys.bytebank.banco.modelo.SaldoInsuficienteException;
import br.com.elys.bytebank.banco.modelo.especial.ContaEspecial;

public class TesteContas {
    public static void main(String[] args) throws SaldoInsuficienteException {
        ContaCorrente contaCorrente = new ContaCorrente(111,111);
        contaCorrente.deposita(100.0);

        ContaPoupanca contaPoupanca = new ContaPoupanca(222,222);
        contaPoupanca.deposita(200.0);

        contaCorrente.transfere(10.0, contaPoupanca);

        ContaEspecial contaEspecial = new ContaEspecial(4444,5555);
        contaEspecial.deposita(800.0);


        System.out.println("Saldo CC: " + contaCorrente.getSaldo());
        System.out.println("Saldo CP: " + contaPoupanca.getSaldo());
        System.out.println("Saldo CE: " + contaEspecial.getSaldo());


    }
}
