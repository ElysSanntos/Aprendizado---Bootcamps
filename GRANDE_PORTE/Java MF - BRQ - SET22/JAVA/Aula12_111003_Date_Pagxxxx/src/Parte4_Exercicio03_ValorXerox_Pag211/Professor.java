package Parte4_Exercicio03_ValorXerox_Pag211;

import java.util.Date;

public class Professor extends Pessoa {
	
	private double salario;
	private String disciplina;
	
	public Professor() {}

	public Professor(String nome, String cpf, Date dataNascimento,double salario, String disciplina) {
		super(nome,cpf,dataNascimento);
		this.salario = salario;
		this.disciplina = disciplina;
	}
	
	/*public Professor(String nome, 
			         String cpf, 
    		         Date datanascimento,
    		         double salario, 
    		         String disciplina) {
		super(nome, cpf, datanascimento);
		this.salario = salario;
		this.disciplina = disciplina;
	}*/

	public double getSalario() {
		return salario;
	}

	public String getDisciplina() {
		return disciplina;
	}

	public void setSalario(double salario) {
		this.salario = salario;
	}

	public void setDisciplina(String disciplina) {
		this.disciplina = disciplina;
	}
	
	
	
	
	

}
