package Exercicio03;

public class Turma {
	
	
	//ATRIBUTOS
	private int idTurma;
	private int qtdAlunos;
	private double notas[];
	
	
	
	//CONSTRUTORES
	public Turma() {}

	public Turma(int idTurma, int qtdAlunos, double[] notas) {
		this.idTurma = idTurma;
		this.qtdAlunos = qtdAlunos;
		this.notas = notas;
	}

	//GETTERS

	public int getIdTurma() {
		return idTurma;
	}

	public int getQtdAlunos() {
		return qtdAlunos;
	}

	public double[] getNotas() {
		return notas;
	}
	
	//SETTERS

	public void setIdTurma(int idTurma) {
		this.idTurma = idTurma;
	}

	public void setQtdAlunos(int qtdAlunos) {
		this.qtdAlunos = qtdAlunos;
	}

	public void setNotas(double[] notas) {
		this.notas = notas;
	}
	
	//MÉTODOS

	public double mediaTurma(double[] notas) {
		
		double soma = 0.0;
        for (double balde: notas){
            soma += balde;
        }
        return soma /notas.length;
		
		
	}

}
