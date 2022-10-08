package Parte05_Classe_Metodo_Absrato_Exercicio_Pag243;
/*Teremos a classe abstrata Funcionario, com atributos comuns a todos os 
 * funcion�rios (idFunc e nomeFunc) e o m�todo abstrato trabalhar() que deve ser
 * sobrescrito em todas as subclasses.
 * 
 * Teremos as seguintes subclasses de Funcion�rios: Gerente, Analista e Programador.
 */ 

public abstract class Funcionario {
	
	protected int idFunc;
	protected String nomeFunc;
	
	public Funcionario() {}

	public Funcionario(int idFunc, String nomeFunc) {
		this.idFunc = idFunc;
		this.nomeFunc = nomeFunc;
	}

	public int getIdFunc() {
		return idFunc;
	}

	public String getNomeFunc() {
		return nomeFunc;
	}

	public void setIdFunc(int idFunc) {
		this.idFunc = idFunc;
	}

	public void setNomeFunc(String nomeFunc) {
		this.nomeFunc = nomeFunc;
	}
	
	public void trabalhar() {}
	
	

}
