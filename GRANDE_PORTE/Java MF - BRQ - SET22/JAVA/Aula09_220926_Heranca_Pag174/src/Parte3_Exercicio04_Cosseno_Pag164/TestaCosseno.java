package Parte3_Exercicio04_Cosseno_Pag164;

public class TestaCosseno {

	public static void main(String[] args) {

		Cosseno c = new Cosseno(1.0);
		Cosseno c2 = new Cosseno();
		c2.setX(2.0);
		c2.calculaParcelas();
		c2.somaParcelas();
		
				
		System.out.println("Cosseno nosso de 1.0: " + c.getCosseno());
		System.out.println("Cosseno Math  de 1.0: " + Math.cos(1.0));
		
		System.out.println("========================================");
		
		System.out.println("Cosseno nosso de 2.0 : " + c2.getCosseno());
		System.out.println("Cosseno Math  de 2.0: " + Math.cos(1.0));

	}

}
