package Parte05_Exemplo_Interface01;

public class MaquinaDeLavarRoupas implements InterfaceBotoes {
	
	private String modeloMarca;

	public MaquinaDeLavarRoupas() {}

	public MaquinaDeLavarRoupas(String modeloMarca) {
		this.modeloMarca = modeloMarca;
	}
	

	public String getModeloMarca() {
		return modeloMarca;
	}

	public void setModeloMarca(String modeloMarca) {
		this.modeloMarca = modeloMarca;
	}

	@Override
	public void play() {
		System.out.println("Botão PLAY pressionado");
		
	}

	@Override
	public void pause() {
		System.out.println("Botão PAUSE pressionado");
		
	}

	@Override
	public void stop() {
		System.out.println("Botão STOP pressionado");
		
	}

	@Override
	public void FF() {
		System.out.println("Botão FF pressionado");
		
	}

	@Override
	public void FR() {
		System.out.println("Botão FR pressionado");
		
	}

	
	

}
