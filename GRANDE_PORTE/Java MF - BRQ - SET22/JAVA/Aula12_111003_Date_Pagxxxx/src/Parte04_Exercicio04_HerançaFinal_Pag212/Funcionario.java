package Parte04_Exercicio04_Heran�aFinal_Pag212;

/*Crie as classes Funcion�rio e Chefe, de acordo com o diagrama de classe. 
 *Fa�a construtores, getters e setters. O m�todo aumento acrescenta um valor
 *ao sal�rio. O m�todo pagamento (que n�o pode ser sobrecarregado � usar final) retorna 85% do
 *salario mensal (ent�o est� sendo descontado 15%). O m�todo pagamentoExtra retorna o valor do pagamento
 *mais contas, gastosExtras e adicionalChefia. Escreva um programa para testar 
 *esta classe.*/

public class Funcionario {
	
	//ATRIBUTOS
	protected String nome;
	protected String rg;
	protected double salarioMensal;
	
	
	//CONSTRUTORES
	public Funcionario() {}
	
	public Funcionario(String nome, String rg, double salarioMensal) {
		
		this.nome = nome;
		this.rg = rg;
		this.salarioMensal = salarioMensal;
	}

	//GETTERS E SETTERS
	public String getNome() {
		return nome;
	}

	public String getRg() {
		return rg;
	}

	public double getSalarioMensal() {
		return salarioMensal;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public void setRg(String rg) {
		this.rg = rg;
	}

	public void setSalarioMensal(double salarioMensal) {
		this.salarioMensal = salarioMensal;
	}
	
	//M�TODOS PR�PRIOS

	public void aumento(double valor) {
		
		salarioMensal +=valor;
		
	}
	public final double pagamento() {
		
		return salarioMensal * 0.85;
	}

}
