package Exercicio02;

import java.util.ArrayList;

public class Pesquisa {
	//ATRIBUTO DA CLASSE ---> STATIC
	private static int sequencia;
	
	//ATRIBUTOS DA INSTANCIA
	private int numPesquisa;
	private char sexo;
	private char resposta;
	
	//CONSTRUTORES
	public Pesquisa() {
		sequencia++;
		numPesquisa = sequencia;
		
	}
	public Pesquisa(char sexo, char resposta) {
		sequencia++;
		this.numPesquisa = sequencia;
		this.sexo = sexo;
		this.resposta = resposta;
	}
	
	//Getters e Setters
	public static int getSequencia() {
		return sequencia;
	}
	public static void setSequencia(int sequencia) {
		Pesquisa.sequencia = sequencia;
	}
	public int getNumPesquisa() {
		return numPesquisa;
	}
//	public void setNumPesquisa(int numPesquisa) {
//		this.numPesquisa = numPesquisa;
//	}
	public char getSexo() {
		return sexo;
	}
	public void setSexo(char sexo) {
		this.sexo = sexo;
	}
	public char getResposta() {
		return resposta;
	}
	public void setResposta(char resposta) {
		this.resposta = resposta;
	}
	// quantidade de homens que responderam sim
	
	public static int QHRS(ArrayList<?> a) {
		int qtde = 0;
		
		for (int i = 0; i < a.size(); i++) {
			Pesquisa criatura = (Pesquisa)a.get(i);
			if(criatura.getSexo()=='M' && criatura.getResposta()=='S') {
				qtde++;
			
	}
		}
		return qtde;
	}
	// quantidade de homens que responderam Não
	
	public static int QHRN(ArrayList<?> a) {
		int qtde = 0;
		
		for (int i = 0; i < a.size(); i++) {
			Pesquisa criatura = (Pesquisa)a.get(i);
			if(criatura.getSexo()=='M' && criatura.getResposta()=='N') {
				qtde++;
			
	}
		}
		return qtde;
	}
	
	//Percentual de homens que responderam SIM 
	
	public static double PHRS(ArrayList<?> a) {
		double qtdeH = 0;
		double qtdeS = 0;
		for(int i = 0; i<a.size(); i++) {
			Pesquisa p = (Pesquisa) a.get(i);
			if(p.getSexo() == 'M') {
				qtdeH++;
				if(p.getResposta() == 'S') {
					qtdeS++;					
				} 
			}
		}
		return qtdeS/qtdeH*100.0;
	}
	
	//Percentual de homens que responderam NÂO 
	
		public static double PHRN(ArrayList<?> a) {
			double qtdeH = 0;
			double qtdeS = 0;
			for(int i = 0; i<a.size(); i++) {
				Pesquisa p = (Pesquisa) a.get(i);
				if(p.getSexo() == 'M') {
					qtdeH++;
					if(p.getResposta() == 'N') {
						qtdeS++;					
					} 
				}
			}
			return qtdeS/qtdeH*100.0;
		}
		
	// quantidade de mulheres que responderam sim
	
	public static int QMRS(ArrayList<?> a) {
		int qtde = 0;
		
		for (int i = 0; i < a.size(); i++) {
			Pesquisa criatura = (Pesquisa)a.get(i);
			if(criatura.getSexo()=='F' && criatura.getResposta()=='S') {
				qtde++;
			
	}
		}
		return qtde;
	}
	// quantidade de mulheres que responderam não
	
	public static int QMRN(ArrayList<?> a) {
		int qtde = 0;
		
		for (int i = 0; i < a.size(); i++) {
			Pesquisa criatura = (Pesquisa)a.get(i);
			if(criatura.getSexo()=='F' && criatura.getResposta()=='N') {
				qtde++;
			
	}
		}
		return qtde;
	}
	
	// percentual de mulheres que responderam sim
	public static double PMRS(ArrayList<?> a) {
		double qtdeH = 0;
		double qtdeS = 0;
		for(int i = 0; i<a.size(); i++) {
			Pesquisa p = (Pesquisa) a.get(i);
			if(p.getSexo() == 'F') {
				qtdeH++;
				if(p.getResposta() == 'S') {
					qtdeS++;					
				} 
			}
		}
		return qtdeS/qtdeH*100.0;
	}
	
	// percentual de mulheres que responderam não
	
	public static double PMRN(ArrayList<?> a) {
		double qtdeH = 0;
		double qtdeS = 0;
		for(int i = 0; i<a.size(); i++) {
			Pesquisa p = (Pesquisa) a.get(i);
			if(p.getSexo() == 'F') {
				qtdeH++;
				if(p.getResposta() == 'N') {
					qtdeS++;					
				} 
			}
		}
		return qtdeS/qtdeH*100.0;
	}
		
	}
	
	
	
	
	
	
	
	
	

