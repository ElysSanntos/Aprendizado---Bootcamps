package Relogio;

public class Relogio {
	//ATRIBUTOS
	
	private int segundo;
	private int minuto;
	private int hora;
	public String marca;
	
	 

	 
	//CONSTRUTOR
		public Relogio() {};
				
		public Relogio(int hora, int minuto, int segundo) {
			this.hora = hora;
			this.minuto = minuto;
			this.segundo = segundo;
			//this.marca = marca;
		}

	 
	//GETTERS E SETTERS
	public int getHora() {
		return hora;
	}

	public void setHora(int hora) {
		this.hora = hora;
	}

	public int getMinuto() {
		return minuto;
	}

	public void setMinuto(int minuto) {
		this.minuto = minuto;
	}

	public int getSegundo() {
		return segundo;
	}

	public void setSegundo(int segundo) {
		this.segundo = segundo;
	}

	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}
	
	
	//METODOS PROPRIOS DA CLASSE
	
	/**
	 * Adianta o horário em segundos
	 * qtdSegundos == Segundos para adiantar
	 */
	
	/*1 dia tem 24 horas
	 *1 dia tem 1440 minuots
	 *1 dia tem 86400 segundos
	 *1 hora tem 60 minutos
	 *1 hora tem 3600 segundos*/
		 
	public void adiantar(int qtdSegundo) {
		
		int segundosAgora = (this.hora * 3600)
				+ (this.minuto * 60) + this.segundo + qtdSegundo;
		segundosAgora %= 86400;//Desprezo os segundos excedentes do calculo
		this.hora = segundosAgora / 3600;//pego os segundos informados e divido pelos segundos de 1 hora, que vira minutos
		this.minuto = (segundosAgora / 60) % 60; // desprezo os minutos que passarem de 60
		this.segundo = segundosAgora % 60; // desprezo os segundos que passarem de 60
		
	}
	/**
	 * Atrasa o horário em segundos
	 * qtdSegundos Segundos para atrasar
	 */
	public void atrasar(int qtdSegundos) {
		
		int segundosAgora = ((this.hora * 3600) + (this.minuto * 60) 
				+ this.segundo) - qtdSegundos;
		segundosAgora %= 86400;
		this.hora = segundosAgora / 3600;
		this.minuto = (segundosAgora / 60) % 60;
		this.segundo = segundosAgora % 60;
	}
	public void exibeHorario() {
		System.out.println(marca +"\t"+ hora + ":" + minuto + ":" + segundo);
	}

}
