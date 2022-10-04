import java.util.ArrayList;

public class Pesquisa {
	// atributos da classe
	private static int sequencia;
	
	// atributos da instância
	private int numPesquisa;
	private char sexo;
	private char resposta;
	
	// construtores
	public Pesquisa() {
		sequencia++;
		numPesquisa = sequencia;
	}
	public Pesquisa (char sexo, char resposta) {
		sequencia++;
		numPesquisa = sequencia;
		this.sexo = sexo;
		this.resposta = resposta;
	}
	
	// getters
	public int getNumPesquisa() {
		return numPesquisa;
	}
	public char getSexo() {
		return sexo;
	}
	public char getResposta() {
		return resposta;
	}

	// setters
	public void setSexo(char sexo) {
		this.sexo = sexo;
	}
	public void setResposta(char resposta) {
		this.resposta = resposta;
	}
	
	// Quantidade de Homens que responderam SIM
	public static int QHRS(ArrayList a) {
		int qtde = 0;
		for(int i = 0; i<a.size(); i++) {
			Pesquisa p = (Pesquisa) a.get(i);
			if(p.getSexo() == 'M' && p.getResposta() == 'S') {
				qtde++;
			}
		}
		return qtde;
	}
	// Quantidade de Mulheres que responderam NAO
	public static int QMRN(ArrayList a) {
		int qtde = 0;
		for(int i = 0; i<a.size(); i++) {
			Pesquisa p = (Pesquisa) a.get(i);
			if(p.getSexo() == 'F' && p.getResposta() == 'N') {
				qtde++;
			}
		}
		return qtde;
	}
	// Percentual de Homens que responderam SIM
	public static double PHRS(ArrayList a) {
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
	// Percentual de Mulheres que responderam NAO
	public static double PMRN(ArrayList a) {
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
