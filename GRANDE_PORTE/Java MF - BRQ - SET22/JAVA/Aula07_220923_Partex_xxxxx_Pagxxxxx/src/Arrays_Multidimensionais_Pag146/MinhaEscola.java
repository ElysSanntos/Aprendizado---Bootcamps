package Arrays_Multidimensionais_Pag146;

import java.util.*;

public class MinhaEscola {
	
	public static void main(String[] args) {
		
		TrataNotas maria = new TrataNotas();
		
		double [] notasAluno = new double [4];
		double [][] notasClasse = new double [30][4];
		double [][][] notasEscola = new double [10][30][4];
		
		maria.preencheNotas(notasAluno);
		
		System.out.println("Média Aluno....: "+ maria.mediaNotas(notasAluno));
		System.out.println("Média Classe...: "+ maria.mediaNotas(notasClasse));
		System.out.println("Média Escola...: "+ maria.mediaNotas(notasEscola));
	}
	
	
	
		
		
	}

