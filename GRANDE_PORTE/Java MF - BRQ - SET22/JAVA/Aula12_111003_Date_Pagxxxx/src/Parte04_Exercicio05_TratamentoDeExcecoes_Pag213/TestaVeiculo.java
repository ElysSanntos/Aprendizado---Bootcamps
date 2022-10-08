package Parte04_Exercicio05_TratamentoDeExcecoes_Pag213;

public class TestaVeiculo {
	public static void main(String[] args) {
		try {
			Veiculo fusca = new Veiculo();
			System.out.println("velocidade maxima " + fusca.getVelocidadeMax() + " km/h");
			System.out.println("velocidade atual    " + fusca.getVelocidade() + " km/h");
			fusca.acelera(50);
			System.out.println("velocidade atual   " + fusca.getVelocidade() + " km/h");
			fusca.desacelara(20);
			System.out.println("velocidade atual   " + fusca.getVelocidade() + " km/h");
		} catch (Exception e) {
			System.out.println(e);
		}

	}
}
