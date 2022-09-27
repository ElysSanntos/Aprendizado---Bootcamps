package Parte3_Exercicio06_Estatistica_Pag167;

public class TestaEstatistica {

	public static void main(String[] args) {


		double dados[] = {5.0,7.0,3.0,8.0,3.0,10.0,3.0,1.0,2.0,4.0,6.5};
		Estatistica e = new Estatistica(dados);
		
		e.ordena();
		System.out.println("Média........: "+e.media());
		System.out.println("Moda.........: "+e.moda());
		System.out.println("Mediana......: "+e.mediana());
		System.out.println("Variancia....: "+e.variancia());
		System.out.println("Desvio Padrão: "+e.desviopadrao());
		
		System.out.println("\n==========Valores desordenados=======\n");
		System.out.println(e.getValores(dados));
		System.out.print(dados);
		e.valoresDesordenados(dados);
		
		System.out.println();
		
		System.out.println("\n==========Valores ordenados=======\n");
		e.imprimeValores();
		
		

	}

}
