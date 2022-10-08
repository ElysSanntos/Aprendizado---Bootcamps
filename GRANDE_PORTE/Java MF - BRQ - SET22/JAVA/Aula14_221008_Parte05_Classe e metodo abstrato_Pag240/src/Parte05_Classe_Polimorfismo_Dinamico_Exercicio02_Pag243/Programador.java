package Parte05_Classe_Polimorfismo_Dinamico_Exercicio02_Pag243;

/*O programador deverá ter os atributos: setor e linguagem, e o método
 * trabalhar() exibe a frase: “O programador “ + nomeFunc + “ trabalha no setor “ + setor
 * + “ desenvolvendo software na linguagem “ + linguagem. */

public class Programador extends Funcionario {

	private String setor;
	private String linguagem;

	public Programador() {}

	public Programador(int idFunc, String nomeFunc,String setor, String linguagem) {
		super(idFunc, nomeFunc);
		this.setor = setor;
		this.linguagem  = linguagem;

	}

	public String getSetor() {
		return setor;
	}

	public String getLinguagem() {
		return linguagem;
	}

	public void setSetor(String setor) {
		this.setor = setor;
	}

	public void setLinguagem(String linguagem) {
		this.linguagem = linguagem;
	}
	
	@Override
	public  void trabalhar() {
		System.out.println("Programador: " + nomeFunc + " \tSetor:.. " 
							+ setor+ "\tLinguagem: " + linguagem);
		
	}

}
