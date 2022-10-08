package Parte04_Exercicio08_Pag217;

public class NavioDeGuerra extends Navio{
	protected  double blindagem;
	protected  double ataque;
	
	
	public NavioDeGuerra() {}
	
	public NavioDeGuerra(int numTripulantes, String nome,double blindagem, double ataque) {
		super(numTripulantes,nome);
		this.blindagem = blindagem;
		this.ataque = ataque;
	}
	
	public double getBlindagem() {
		return blindagem;
	}

	public double getAtaque() {
		return ataque;
	}

	public void setBlindagem(double blindagem) {
		this.blindagem = blindagem;
	}

	public void setAtaque(double ataque) {
		this.ataque = ataque;
	}

	public void exibirArmas() {
		super.exibirInfoGeral();
		System.out.println("Blindagem : " +blindagem );
		poderDeFogo();
		
	}
	
	public void poderDeFogo() {
		//Mostra o valor no campo ataque
		
		System.out.println("Ataque: " +ataque );
			
		}
}
