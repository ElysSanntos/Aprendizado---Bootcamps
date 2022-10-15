package Parte05_Exemplo_HashSet;

public class TestaMegaSena {

	public static void main(String[] args) {

		MegaSena ms = new MegaSena(6,5);
		ms.imprimeJogos();
		
		int[] resultadoSorteado = {2,23,44,45,47,38};
		
		ms.confereResultado(resultadoSorteado);
		
		System.out.println("FIM");
	}

}
