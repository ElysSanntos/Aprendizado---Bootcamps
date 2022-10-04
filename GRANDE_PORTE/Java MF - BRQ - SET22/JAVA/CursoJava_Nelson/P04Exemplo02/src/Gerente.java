
public class Gerente extends Funcionario{
	private String departamento;
	public Gerente() {}
               //  (3,"Marcelo",432,"Gerente","Marketing")
	public Gerente(int id, 
			       String nome, 
			       int funcional, 
			       String cargo, 
			       String departamento) {
	     //  (3,"Marcelo",432,"Gerente"
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
		System.out.println("departamento.:"+departamento);
	}	
	
}
