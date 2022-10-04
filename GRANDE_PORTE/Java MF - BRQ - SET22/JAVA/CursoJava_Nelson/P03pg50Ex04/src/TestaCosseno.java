public class TestaCosseno {
	public static void main(String[] args) {
		Cosseno c1 = new Cosseno(1.0);
		Cosseno c2 = new Cosseno();
		c2.setX(2.0);
		c2.calculaParcelas();
		c2.somaParcelas();
		
		System.out.println("Cosseno nosso = " + c1.getCosseno());
		System.out.println("Cosseno Math  = " + Math.cos(1.0));
		
		System.out.println("Cosseno nosso = " + c2.getCosseno());
		System.out.println("Cosseno Math  = " + Math.cos(2.0));
	}
}