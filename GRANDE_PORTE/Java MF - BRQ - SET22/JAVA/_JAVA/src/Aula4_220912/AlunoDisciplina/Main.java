package Aula4_220912.AlunoDisciplina;

public class Main {

	public static void main(String[] args) {
		
		AlunoDisciplina aluno1 = new AlunoDisciplina();
		AlunoDisciplina aluno2 = new AlunoDisciplina(1,10,3.5,10.0);
		AlunoDisciplina aluno3 = new AlunoDisciplina(3,10,8.5,10.0);
		AlunoDisciplina aluno4 = new AlunoDisciplina();
		AlunoDisciplina aluno5 = new AlunoDisciplina();
		
		aluno1.setIdAluno(4);
		aluno1.setIdDisciplina(8);
		aluno1.setNotaB1(0);
		
		
		aluno1.imprime();
		aluno2.imprime();
		aluno3.imprime();
		aluno4.imprime();
		aluno5.imprime();
		
		

	}

}
