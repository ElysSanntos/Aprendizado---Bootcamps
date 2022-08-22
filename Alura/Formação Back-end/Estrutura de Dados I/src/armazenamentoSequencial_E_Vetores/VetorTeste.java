package armazenamentoSequencial_E_Vetores;

public class VetorTeste {

	public static void main(String[] args) {
		// Testando o metodo adiciona()
		Aluno a1 = new Aluno("Jo�o");
		Aluno a2 = new Aluno("Jos�");
		Aluno a3 = new Aluno("Maria");
		
		Vetor lista = new Vetor();
		
		//Testando o tamanho da lista
		System.out.println("Qtde de alunos na lista: " + lista.tamanho());
		lista.adiciona(a1);
		System.out.println("Qtde de alunos na lista: " +lista.tamanho());
		lista.adiciona(a2);
		System.out.println("Qtde de alunos na lista: " +lista.tamanho());
		lista.adiciona(a3);
		System.out.println("Qtde de alunos na lista: " +lista.tamanho());
		
		System.out.println(lista);
		System.out.println("O aluno "+ a1 +", j� est� na lista? "+lista.contem(a1));
		
		Aluno a4 = new Aluno("Danilo");
		System.out.println("O aluno "+ a4 +", j� est� na lista? "+lista.contem(a4));
		
		//Testando o m�todo pega()
		
		Aluno x = lista.pega(1);
		System.out.println("O aluno que est� na posi��o 1: "+ x);
		
		//Adicionando aluno em qualquer lugar
		Aluno a5 = new Aluno("Elys");
		lista.adicionaQualquerLugar(1,a5);
		System.out.println("O aluno "+a5+" ,foi inserido na posi��o 1"+ lista);
		
		//Removendo aluno
		lista.remove(1);
		System.out.println(lista);
	}

}
