package Parte04_Exercicio08_Pag217;

/*Uma classe Navio � empregada para descrever os diversos tipos de
 * navios, em particular ela serve de base para outras classes tal 
 * como descrito no diagrama de classes abaixo e a tabela ao lado 
 * resume a fun��o que cada um dos m�todos deve realizar. 
 * Crie um programa que simule uma batalha naval.*/

public class Navio {
	
	protected int numTripulantes;
	protected String nome;
	
	
	
	public Navio() {}
	
	public Navio(int numTripulantes, String nome) {
		this.numTripulantes = numTripulantes;
		this.nome = nome;
	}
	
	
	public int getNumTripulantes() {
		return numTripulantes;
	}

	public String getNome() {
		return nome;
	}

	public void setNumTripulantes(int numTripulantes) {
		this.numTripulantes = numTripulantes;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	
	public void exibirInfoGeral() {
		/*Exibe as informa��es dos atributos  numTripulantes e nome*/
		
		System.out.println("Tripula��o.: " + numTripulantes);
		System.out.println("Nome.......: " + nome);
		
		
	}

}
