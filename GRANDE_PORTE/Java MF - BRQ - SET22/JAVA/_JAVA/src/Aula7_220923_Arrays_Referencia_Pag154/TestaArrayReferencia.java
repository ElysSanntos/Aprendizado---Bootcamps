package Aula7_220923_Arrays_Referencia_Pag154;

public class TestaArrayReferencia {

	public static void main(String[] args) {
		Aluno[] classe = new Aluno[4];
		 for (int i=0;i<classe.length;i++)
		 classe[i] = new Aluno();
		 double[] notas;

		 notas = new double [4];
		 notas[0]=3;notas[1]=8;notas[2]=8;notas[3]=6;
		 classe[0].setAluno(123, "Andrea",notas);

		 notas = new double [4];
		 notas[0]=7;notas[1]=3;notas[2]=5;notas[3]=8;
		 classe[1].setAluno(145, "Bruno",notas);

		 notas = new double [4];
		 notas[0]=6;notas[1]=8;notas[2]=4;notas[3]=9;
		 classe[2].setAluno(158, "Cecilia",notas);

		 notas = new double [4];
		 notas[0]=4;notas[1]=3;notas[2]=4;notas[3]=8;
		 classe[3].setAluno(169, "Daniel",notas);

		 for (int i=0;i<classe.length;i++){
		 System.out.println("------------------------------");
		 System.out.println("Matricula="+classe[i].matricula);
		 System.out.println("nome="+classe[i].nome);

		 for (int j=0;j<4;j++)
		 System.out.println("nota ["+j+"]="+classe[i].notas[j]);

		 System.out.println("Media="+classe[i].mediaAritmetica());
		 }

		 double soma = 0;
		 for (Aluno balde: classe){
		 soma += (balde.mediaAritmetica());
		 }
		 System.out.println("------------------------------");
		 System.out.println("Media Geral = "+soma/4);
		 System.out.println("------------------------------");
		 }
		}

