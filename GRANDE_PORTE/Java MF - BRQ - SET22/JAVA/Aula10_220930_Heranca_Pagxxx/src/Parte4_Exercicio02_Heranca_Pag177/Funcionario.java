package Parte4_Exercicio02_Heranca_Pag177;

public class Funcionario extends Pessoa {
	public int funcional;
	public String cargo;
	
	public Funcionario() {}
	public Funcionario(int id, String nome, int funcional, String cargo) {
		super(id, nome);
		this.funcional = funcional;
		this.cargo = cargo;
	}
	
	public int getFuncional() {
		return funcional;
	}
	public String getCargo() {
		return cargo;
	}
	public void setFuncional(int funcional) {
		this.funcional = funcional;
	}
	public void setCargo(String cargo) {
		this.cargo = cargo;
	}

	@Override
	public void imprimeDados() {
		super.imprimeDados();
		System.out.println("funcional....: "+funcional);
		System.out.println("cargo........: "+cargo);
	}

}
