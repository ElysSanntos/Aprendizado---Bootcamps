package Exercicio9;

public class Funcionario {
	// atributos
	private int codFunc;
	private String nomeFunc;
	private double salarioMensal;
	
	// construtores
	public Funcionario() {}
	public Funcionario(int codFunc, 
			           String nomeFunc, 
			           double salarioMensal) {
		this.codFunc = codFunc;
		this.nomeFunc = nomeFunc;
		this.salarioMensal = salarioMensal;
	}
	
	// getters
	public int getCodFunc() {
		return codFunc;
	}
	public String getNomeFunc() {
		return nomeFunc;
	}
	public double getSalarioMensal() {
		return salarioMensal;
	}
	// setters
	public void setCodFunc(int codFunc) {
		this.codFunc = codFunc;
	}
	public void setNomeFunc(String nomeFunc) {
		this.nomeFunc = nomeFunc;
	}
	public void setSalarioMensal(double salarioMensal) {
		this.salarioMensal = salarioMensal;
	}
	
	// métodos próprios
	public double getSalarioAnual() {
		return salarioMensal * 12.0;
	}
	
	public void setAumento(double per) {
		salarioMensal = salarioMensal * (1.0+per/100.0);
	}
}