public class testaEstatistica {
	public static void main(String[] args) {
		double dados[] = {5.0,7.0,9.0,8.0,9.0,9.0,9.0,1.0,2.0,4.0};
		Estatistica e = new Estatistica(dados);
		e.ordena();
		System.out.println("media..........: " + e.media());
		System.out.println("moda...........: " + e.moda());
		System.out.println("mediana........: " + e.mediana());
		System.out.println("variancia......: " + e.variancia());
		System.out.println("desvio padrao..: " + e.desviopadrao());
		e.imprimeValores();
	}
}