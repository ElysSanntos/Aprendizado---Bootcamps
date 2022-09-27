public class MinhaEscola {

	public static void main(String[] args) {
		TrataNotas maria = new TrataNotas();
		
		double [] notasAluno = new double[4];
		double [][] notasClasse = new double [30][4];
		double [][][] notasEscola = new double [10][30][4];
		
		maria.preencheNotas(notasAluno);
		maria.preencheNotas(notasClasse);
		maria.preencheNotas(notasEscola);
		
		System.out.println("Media Aluno...: " + maria.mediaNotas(notasAluno));
		System.out.println("Media Classe..: " + maria.mediaNotas(notasClasse));
		System.out.println("Media Escola..: " + maria.mediaNotas(notasEscola));
	}
}