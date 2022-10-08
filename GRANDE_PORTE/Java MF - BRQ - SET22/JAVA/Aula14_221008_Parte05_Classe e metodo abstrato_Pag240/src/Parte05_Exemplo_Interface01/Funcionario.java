package Parte05_Exemplo_Interface01;

public class Funcionario extends Pessoa 
						 implements MetodosComuns{
	
	private String cargo;

	public Funcionario() {
	}

	public Funcionario(int idPessoa, String nomePessoa, String cargo) {
		super(idPessoa, nomePessoa);
		this.cargo = cargo;
	}

	public String getCargo() {
		return cargo;
	}

	public void setCargo(String cargo) {
		this.cargo = cargo;
	}

	@Override
	public double calcula(double horasTrabalhadas, double salarioHora) {
		return horasTrabalhadas * salarioHora * 0.85;
	}

	@Override
	public void imprimeLinha(int tamanho) {
		for (int i = 0; i < tamanho; i++) {
			System.out.println(" = ");
			
		}
		System.out.println();
		
	}

	

	
}
