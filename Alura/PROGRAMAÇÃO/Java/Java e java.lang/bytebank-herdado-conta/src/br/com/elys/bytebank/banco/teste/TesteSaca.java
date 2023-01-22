package br.com.elys.bytebank.banco.teste;

import br.com.elys.bytebank.banco.modelo.Conta;
import br.com.elys.bytebank.banco.modelo.ContaCorrente;
import br.com.elys.bytebank.banco.modelo.SaldoInsuficienteException;

public class TesteSaca {

    public static void main(String[] args) throws SaldoInsuficienteException {

        Conta cc = new ContaCorrente(123,321);
        cc.deposita(200.0);
        cc.saca(200.0);
        System.out.println("Saldo da CC após Saque: " + cc.getSaldo());

//        /*Gerando a exceção*/
//        cc.saca(210.0);
//        System.out.println("Saldo da CC após Saque: " + cc.getSaldo());

        /*Tratando a exceção*/

        try {
            cc.saca(210.0);
        }catch (Exception ex){
            System.out.println("Exceção tratada - Saldo da CC após Saque: " + cc.getSaldo());
        }
    }
}
