package Exercicio01;

public class Pessoa {
	
	
	//ATRIBUTOS
	private int idPessoa;
	private String nomePessoa;
	private double alturaPessoa;
	
	//CONSTRUTORES
	public Pessoa() {
		
	}
	public Pessoa(int idPessoa, String nomePessoa, double alturaPessoa) {
		
		this.idPessoa = idPessoa;
		this.nomePessoa = nomePessoa;
		this.alturaPessoa = alturaPessoa;
	}
	public int getIdPessoa() {
		return idPessoa;
	}
	public String getNomePessoa() {
		return nomePessoa;
	}
	public double getAlturaPessoa() {
		return alturaPessoa;
	}
	public void setIdPessoa(int idPessoa) {
		this.idPessoa = idPessoa;
	}
	public void setNomePessoa(String nomePessoa) {
		this.nomePessoa = nomePessoa;
	}
	public void setAlturaPessoa(double alturaPessoa) {
		this.alturaPessoa = alturaPessoa;
	}
	
	public  static double  mediaAltura(Pessoa []pessoa) {
		
		double soma = 0.0;

	for (Pessoa balde : pessoa) {
		
		soma=+ balde.getAlturaPessoa();
	}
		
		return soma / pessoa.length;
		
	}
	
	

}
