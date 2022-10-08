package Parte05_Classe_Polimorfismo_Dinamico_Exercicio02_Pag243;

/*O analista deverá ter o atributo: sistema, e o método trabalhar() exibe a frase:
 * “O analista “ + nomefunc + “ desenvolve software para o sistema “ + sistema.*/

public class Analista extends Funcionario {
	
	private String sistema;

	public Analista() {
		
	}

	public Analista(int idFunc, String nomeFunc, String sistema) {
		super(idFunc, nomeFunc);
		this.sistema = sistema;
	}

	public String getSistema() {
		return sistema;
	}

	public void setSistema(String sistema) {
		this.sistema = sistema;
	}
	
	@Override
	public void trabalhar() {
		System.out.println("Analista:... "+ nomeFunc + "\tSistema: " + sistema);
		
	}

}
