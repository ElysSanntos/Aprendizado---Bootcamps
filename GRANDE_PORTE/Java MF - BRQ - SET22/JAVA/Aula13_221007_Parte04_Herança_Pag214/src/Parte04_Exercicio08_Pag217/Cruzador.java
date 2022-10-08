package Parte04_Exercicio08_Pag217;

public class Cruzador extends NavioDeGuerra {
	
	protected int numCanhoes;
	
		
	public Cruzador() {}
	
/*Temos que pegar todos os atributos das super classes navio e navio de guerra*/
	public Cruzador(int numTripulantes, 
			        String nome, 
			        double blindagem, 
			        double ataque,
			        int numCanhoes) {
	super(numTripulantes, nome, blindagem, ataque);
	this.numCanhoes = numCanhoes;
}
	

	public int getNumCanhoes() {
		return numCanhoes;
	}


	public void setNumCanhoes(int numCanhoes) {
		this.numCanhoes = numCanhoes;
	}


	@Override
	public void poderDeFogo() {
		System.out.println("Ataque.........: " + 
	                       (ataque * Math.sqrt(numCanhoes)));
	}

}
