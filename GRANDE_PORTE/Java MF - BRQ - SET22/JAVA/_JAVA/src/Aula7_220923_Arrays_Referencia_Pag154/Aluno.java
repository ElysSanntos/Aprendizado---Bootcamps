package Aula7_220923_Arrays_Referencia_Pag154;

public class Aluno {
	
	 public int matricula;
	 public String nome;
	 public double [] notas;
	 public void setAluno(int matricula,
	 String nome,
	 
	 double[] notas){
	 this.matricula = matricula;
	 this.nome = nome;
	 this.notas = notas;
	 }

	 public double mediaAritmetica(){
	 return (notas[0]+notas[1]+notas[2]+notas[3])/4;
	 }

}
