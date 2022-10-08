package Parte05_Exemplo_Interface01;

public class Robo implements InterfaceBotoes, MetodosComuns {
	
	private String modelo;

	public Robo() {}
	

	public Robo(String modelo) {
		this.modelo = modelo;
	}

	

	public String getModelo() {
		return modelo;
	}


	public void setModelo(String modelo) {
		this.modelo = modelo;
	}


	@Override
	public double calcula(double distancia, double tempo) {
		double velocidade = distancia / tempo;
		return velocidade;
	}


	@Override
	public void imprimeLinha(int t) {
		for (int i = 0; i < t; i++) {
			System.out.println("*_______*");
			
		}
		
	}


	@Override
	public void play() {
		System.out.println("Bot�o Rob� PLAY pressionado");
		
	}

	@Override
	public void pause() {
		System.out.println("Bot�o Rob� PAUSE pressionado");
		
	}

	@Override
	public void stop() {
		System.out.println("Bot�o Rob� STOP pressionado");
		
	}

	@Override
	public void FF() {
		System.out.println("Bot�o Rob� FF pressionado");
		
	}

	@Override
	public void FR() {
		System.out.println("Bot�o Rob� FR pressionado");
		
	}


}
