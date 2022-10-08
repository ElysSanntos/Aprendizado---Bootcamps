package Parte04_Exercicio08_Pag217;

public class PortaAvioes extends NavioDeGuerra {

	protected int numAvioes;
	
	
	
public PortaAvioes() {}


public PortaAvioes(int numTripulantes,String nome, 
			       double blindagem, 
			       double ataque,int numAvioes) {
	super(numTripulantes, nome, blindagem, ataque);
	this.numAvioes = numAvioes;
}




public void poderDeFogo() {
	System.out.println("Ataque.........: " + 
            (ataque * Math.pow(numAvioes,2)));
		
	}
}
