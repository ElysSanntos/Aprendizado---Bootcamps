package Exercicio03;

import java.util.Scanner;

public class TestaTurma {

	public static void main(String[] args) {
		
		Turma turma = new Turma();
		

		// Ler a quantidade de alunos da turma
        Scanner aluno = new Scanner(System.in);
        System.out.print("\nDigite a quantidade de alunos: ");
        int qtdeAlunos = aluno.nextInt();
        
		// Ler a quantidade de notas para cada aluno
        Scanner notas = new Scanner(System.in);
        System.out.print("\nDigite quantas notas o aluno vai receber: ");
        int qtdeNotas = notas.nextInt();
        
        
        
        //System.out.printf("\nMédia das notas: %5.1f", mediaTurma());

	}

}
