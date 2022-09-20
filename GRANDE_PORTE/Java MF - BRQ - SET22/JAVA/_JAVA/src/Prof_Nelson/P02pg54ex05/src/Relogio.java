public class Relogio {
	// atributos
	private int hora;
	private int minuto;
	private int segundo;
	
	// construtor
	public Relogio() {}
	public Relogio(int hora, int minuto, int segundo) {
		this.hora = hora;
		this.minuto = minuto;
		this.segundo = segundo;
	}
	
	// getters e setters
	public int getHora() {
		return hora;
	}
	public int getMinuto() {
		return minuto;
	}
	public int getSegundo() {
		return segundo;
	}
	public void setHora(int hora) {
		this.hora = hora;
	}
	public void setMinuto(int minuto) {
		this.minuto = minuto;
	}
	public void setSegundo(int segundo) {
		this.segundo = segundo;
	}
	
	// métodos próprios
	public void adiantar(int seg) {
		int total = (hora * 3600 + minuto * 60 + segundo + seg)%86400;
		hora      = total / 3600;
		total     = total % 3600;
		minuto    = total / 60;
		total     = total % 60;
		segundo   = total;
	}
	
	public void atrasar(int seg) {
		int total = (hora * 3600 + minuto * 60 + segundo - (seg%86400) + 86400) % 86400;
		hora      = total / 3600;
		total     = total % 3600;
		minuto    = total / 60;
		total     = total % 60;
		segundo   = total;		
	}
	
	public void exibeHorario() {
		System.out.println(hora+":"+minuto+":"+segundo);
	}	
}