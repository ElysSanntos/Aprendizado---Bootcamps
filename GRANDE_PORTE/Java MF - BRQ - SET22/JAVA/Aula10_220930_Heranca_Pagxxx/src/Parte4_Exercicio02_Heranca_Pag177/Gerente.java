package Parte4_Exercicio02_Heranca_Pag177;

public class Gerente extends Funcionario{
	
	private String departamento;
	public Gerente() {}

	public Gerente(int id, 
			       String nome, 
			       int funcional, 
			       String cargo, 
			       String departamento) {
		super(id, nome, funcional, cargo);
		this.departamento = departamento;
	}

	public String getDepartamento() {
		return departamento;
	}

	public void setDepartamento(String departamento) {
		this.departamento = departamento;
	}
	
	@Override
	public void imprimeDados() {
		super.imprimeDados();
		System.out.println("departamento.: "+departamento);
	}	

}
