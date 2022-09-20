public class AlunoDisciplina {
	// Atributos
	private int idAluno;
	private int idDisciplina;
	private double notaB1;
	private double notaB2;

	// construtores
	public AlunoDisciplina() {}

	public AlunoDisciplina(int idAluno, 
			               int idDisciplina) {
		this.idAluno = idAluno;
		this.idDisciplina = idDisciplina;
	}

	public AlunoDisciplina(int idAluno, 
			               int idDisciplina, 
			               double notaB1, 
			               double notaB2) {
		this.idAluno = idAluno;
		this.idDisciplina = idDisciplina;
		this.notaB1 = notaB1;
		this.notaB2 = notaB2;
	}

	// getters e setters
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

	// métodos próprios
	public double mediaAritmetica() {
		return (notaB1 + notaB2) / 2;
	}

	public double mediaPonderada() {
		return (notaB1 * 4.0 + notaB2 * 6.0) / 10.0;
	}
}