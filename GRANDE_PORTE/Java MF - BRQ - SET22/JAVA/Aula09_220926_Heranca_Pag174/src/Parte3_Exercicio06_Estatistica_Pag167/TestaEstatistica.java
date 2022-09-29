package Parte3_Exercicio06_Estatistica_Pag167;

public class TestaEstatistica {

	public static void main(String[] args) {


		double []dados = {5.0,7.0,3.0,8.0,3.0,10.0,3.0,1.0,2.0,4.0,6.5};
		Estatistica e = new Estatistica(dados);
		
		System.out.print("Valores desordenados: ");
		
		
		for(double balde1: dados) {System.out.print(balde1);}
			System.out.println("\n");
			
		
		e.ordena();// a partir daqui, todos os dados ficam ordenados, e não é possivel realizar a impressaão original
		System.out.println("Média........: "+e.media());
		System.out.println("Moda.........: "+e.moda());
		System.out.println("Mediana......: "+e.mediana());
		System.out.println("Variancia....: "+e.variancia());
		System.out.println("Desvio Padrão: "+e.desviopadrao());
		
		System.out.println("\n==========Valores desordenados=======\n");
		System.out.println("Endereço memoria: "+ dados);
		System.out.println();
		System.out.println("\n");

		System.out.println("Tentando pegar os dados originais: "+ dados);
		System.out.println();
		
		
		System.out.println("\n==========Valores ordenados=======\n");
		e.imprimeValores();
		
		

	}

}
