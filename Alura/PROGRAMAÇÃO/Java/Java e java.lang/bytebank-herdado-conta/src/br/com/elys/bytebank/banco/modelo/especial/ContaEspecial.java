package br.com.elys.bytebank.banco.modelo.especial;

import br.com.elys.bytebank.banco.modelo.Conta;

public class ContaEspecial  extends Conta {

    public ContaEspecial(int agencia, int numero){
        super(8888,9999);

    }

    @Override
    public void deposita(double valor) {
        super.saldo+=valor;
    }
}
