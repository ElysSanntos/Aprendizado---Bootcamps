package Parte05_Exemplo_HashSet;

import java.util.*;

/*Em cada posição do ArrayList vamos ter uma quantidade de jogos(HashSet)
 * 
 * */

public class MegaSena {
	protected int qtdeApostas;
	private int qtdeJogos;

	LinkedList<TreeSet> jogos = new LinkedList<>();

	public MegaSena() {}

	public MegaSena(int qtdeApostas, int qtdeJogos) {
		this.qtdeApostas = qtdeApostas;
		this.qtdeJogos = qtdeJogos;

		geraJogos();
	}

	// Gerar os números de cada jogo
	private void geraJogos() {
		Random ml = new Random(new Date().getTime());

		for (int i = 0; i < qtdeJogos; i++) {
			TreeSet<Integer> h = new TreeSet<>();

			while (h.size() < qtdeApostas) {
				h.add(ml.nextInt(60) + 1);

			}
			jogos.add(h);

		}

	}

	public void imprimeJogos() {

		for (int j = 1; j <= qtdeApostas; j++) {
			System.out.print(j + "\t");
		}
		System.out.print("\n==========================================\n");

		for (int i = 0; i < jogos.size(); i++) {
			TreeSet jogo = jogos.get(i);

			Iterator<Integer> it = jogo.iterator();

			while (it.hasNext()) {

				System.out.print(it.next() + "\t");
			}
			System.out.println();

		}

	}

	public void confereResultado(int[] resultado) {

		TreeSet<Integer> r = new TreeSet<>();
		for (int balde : resultado) {

			r.add(balde);

		}

		int quadra = 0;
		int quina = 0;
		int sena = 0;

		for (int i = 0; i < jogos.size(); i++) {
			TreeSet<Integer> jogo = jogos.get(i);

			// Verificar se o que está no jogo bate com o que foi sorteado

		}
	}

}
