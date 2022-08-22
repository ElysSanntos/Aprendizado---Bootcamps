package listasLigadas;

public class TestaListaLigada {

	public static void main(String[] args) {
		
		ListaLigada lista = new ListaLigada();
		
		System.out.println(lista);
		lista.adicionaNoComeco("Mauricio");
		System.out.println(lista);
		lista.adicionaNoComeco("Paulo");
		System.out.println(lista);
		lista.adicionaNoComeco("Guilherme");
		System.out.println(lista);

		lista.adicionaNoFim("Marcelo");
		System.out.println(lista);
		
		lista.adicionaNoMeio(2,"Gabriel");
		System.out.println(lista);
		
		Object x = lista.pega(2);
		System.out.println("Recupera elemento na posição 2: "+ x);
		
		System.out.println("Tamanho atual da lista: "+ lista.tamanho()+ " posições");
		
		lista.removeDoComeco();
		System.out.println("Removendo o primeiro elemento da lista: " +lista);
		System.out.println("Tamanho atual da lista: "+ lista.tamanho()+ " posições");
	}
}
