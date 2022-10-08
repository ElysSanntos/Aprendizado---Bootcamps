package Parte04_Exercicio05_TratamentoDeExcecoes_Pag213;

public class VelocidadeNegativa extends Exception {
	public VelocidadeNegativa(String msg) {
		super(msg);
	}
}