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
		System.out.println("Bot�o PLAY pressionado");
		
	}

	@Override
	public void pause() {
		System.out.println("Bot�o PAUSE pressionado");
		
	}

	@Override
	public void stop() {
		System.out.println("Bot�o STOP pressionado");
		
	}

	@Override
	public void FF() {
		System.out.println("Bot�o FF pressionado");
		
	}

	@Override
	public void FR() {
		System.out.println("Bot�o FR pressionado");
		
	}

	
	

}
