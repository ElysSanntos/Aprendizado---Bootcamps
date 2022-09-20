package Aula4_220912.AlunoDisciplina;

public class AlunoDisciplina {
	//ATRIBUTOS
	private int idAluno;
	private int idDisciplina;
	private double notaB1;
	private double notaB2;
	
	//CONSTRUTOR
	public AlunoDisciplina() {
	}
		
	
	public AlunoDisciplina(int idAluno, int idDisciplina, double notaB1, double notaB2) {
		this.idAluno = idAluno;
		this.idDisciplina = idDisciplina;
		this.notaB1 = notaB1;
		this.notaB2 = notaB2;
	}




	//GETTERS E SETTERS
	

	
	public int getIdAluno() {
		return idAluno;
	}


	public int getIdDisciplina() {
		return idDisciplina;
	}


	public double getNotaB1() {
		return notaB1;
	}


	public double getNotaB2() {
		return notaB2;
	}


	public void setIdAluno(int idAluno) {
		this.idAluno = idAluno;
	}


	public void setIdDisciplina(int idDisciplina) {
		this.idDisciplina = idDisciplina;
	}


	public void setNotaB1(double notaB1) {
		this.notaB1 = notaB1;
	}


	public void setNotaB2(double notaB2) {
		this.notaB2 = notaB2;
	}

	
	
	//METODOS PROPRIOS DA CLASSE
	public double mediaAritmetica() {
		return  notaB1 + notaB2 / 2;
	}
	private double mediaPonderada() {
		 double media;
		 return  media = ((notaB1*4.0) +(notaB2*6.0)) /10.0;
		
	}
	
	public void imprime() {
		System.out.println("Aluno: " + getIdAluno() + "\t Disciplina: " + getIdDisciplina() + 
				"\t Nota1: "+ getNotaB1() + "\t Nota2: " + getNotaB2() + "\t Média A: " 
				+ mediaAritmetica() + "\t Média P: " + mediaPonderada() );
	}

}
