package br.com.elys.bytebank.banco.teste;

import br.com.elys.bytebank.banco.modelo.CalculadorDeImposto;
import br.com.elys.bytebank.banco.modelo.ContaCorrente;
import br.com.elys.bytebank.banco.modelo.SeguroDeVida;

public class TesteTributaveis {

    public static void main(String[] args) {
        ContaCorrente cc = new ContaCorrente(222,333);
        cc.deposita(100.0);

        SeguroDeVida seguroDeVida = new SeguroDeVida();

        CalculadorDeImposto calc = new CalculadorDeImposto();

        calc.registra(cc);
        calc.registra(seguroDeVida);

        System.out.println("Total de impostos: " + calc.getTotalImposto());
    }
}
