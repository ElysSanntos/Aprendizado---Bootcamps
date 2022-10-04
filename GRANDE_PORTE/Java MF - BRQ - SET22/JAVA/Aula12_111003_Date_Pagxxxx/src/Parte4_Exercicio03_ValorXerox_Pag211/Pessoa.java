package Parte4_Exercicio03_ValorXerox_Pag211;

/*Crie as classes Pessoa, Aluno, Professor e Funcionário, de acordo com o diagrama de classe.
Faça construtores, getters e setters. O custo de tirar cópias é de R$ 0,10 por folha, 
mas alunos pagam apenas R$ 0,07 por folha. Escreva um programa para testar esta classe.*/

import java.util.Date;

public class Pessoa {
	
	protected String nome;
	protected String cpf ;
	protected Date dataNascimento;
	
		
	public Pessoa() {
	}
	
	
	public Pessoa(String nome, String cpf, Date dataNascimento) {
		this.nome = nome;
		this.cpf = cpf;
		this.dataNascimento = dataNascimento;
	}
	


	public String getNome() {
		return nome;
	}


	public String getCpf() {
		return cpf;
	}


	public Date getDataNascimento() {
		return dataNascimento;
	}


	public void setNome(String nome) {
		this.nome = nome;
	}


	public void setCpf(String cpf) {
		this.cpf = cpf;
	}


	public void setDataNascimento(Date dataNascimento) {
		this.dataNascimento = dataNascimento;
	}


	public double tirarCopias(int qtd) {
		
		//O custo de tirar cópias é de R$ 0,10 por folha
		
		return qtd * 0.1;
	}




	

}
