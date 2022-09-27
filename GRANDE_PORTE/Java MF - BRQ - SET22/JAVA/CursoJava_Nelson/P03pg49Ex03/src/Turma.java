public class Turma {
	// atributos
	private int    idTurma;
	private int    qtdAlunos;
	private double notas [];
	
	// construtores
	public Turma() {}
	public Turma(int idTurma,int qtdAlunos,double notas []) {
		this.idTurma = idTurma;
		this.qtdAlunos = qtdAlunos;
		this.notas = notas;
	}

	// getters
	public int getIdTurma() {
		return idTurma;
	}
	public int getQtdAlunos() {
		return qtdAlunos;
	}
	public double[] getNotas() {
		return notas;
	}
	
	// setters
	public void setIdTurma(int idTurma) {
		this.idTurma = idTurma;
	}
	public void setQtdAlunos(int qtdAlunos) {
		this.qtdAlunos = qtdAlunos;
	}
	public void setNotas(double[] notas) {
		this.notas = notas;
	}

	// métodos próprios
	public double mediaTurma() {
		double soma=0.0;
		for(double balde:notas) {
			soma+=balde;
		}
		return soma/notas.length;
	}	
}