package Parte05_Classe_Polimorfismo_Dinamico_Exercicio02_Pag243;

/*O gerente deverá ter os atributos: setor, qtdAnalista e qtdProgramador, e o
 * método trabalhar() exibe a frase: “O gerente “ + nomefunc + “ gerencia o setor “ + setor
 * + “ com “ + qtdAnalistas + “ analistas e “ + qtdProgramadores + “ programadores”.
 * */

public class Gerente extends Funcionario {
	 
 private String setor;
 private int qtdAnalista;
 private int qtdProgramador;

	public Gerente() {}

	public Gerente(int idFunc, String nomeFunc,String setor, int qtdAnalista, int qtdProgramador) {
		super(idFunc, nomeFunc);
		this.setor = setor;
		this.qtdAnalista = qtdAnalista;
		this.qtdProgramador = qtdProgramador;
	}

	public String getSetor() {
		return setor;
	}

	public int getQtdAnalista() {
		return qtdAnalista;
	}

	public int getQtdProgramador() {
		return qtdProgramador;
	}

	public void setSetor(String setor) {
		this.setor = setor;
	}

	public void setQtdAnalista(int qtdAnalista) {
		this.qtdAnalista = qtdAnalista;
	}

	public void setQtdProgramador(int qtdProgramador) {
		this.qtdProgramador = qtdProgramador;
	}
	
	@Override
	public void trabalhar() {
		
		System.out.println("gerente:.... "+ nomeFunc + "\tGerencia o setor: " 
							+ setor + "\nQtde Analistas: " + qtdAnalista + 
							"\nQtde Programadores: " + qtdProgramador);
				
				
		
	}
}
