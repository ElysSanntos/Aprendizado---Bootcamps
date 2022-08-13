package estruturaDeDados;

public class Aluno {
	
	private String nome;
	
	public Aluno(String nome) {//Ctrl + 1
		this.nome = nome;
		
	}
	public String getNome() { //getN ==> Ctrl + space
		return nome;
	}
	
	@Override
	public boolean equals(Object obj) {
		Aluno outro = (Aluno)obj;
		return outro.getNome().equals(this.nome);
		
	}
	@Override
	public String toString() {
		
		return nome;
	}
	
	

}
