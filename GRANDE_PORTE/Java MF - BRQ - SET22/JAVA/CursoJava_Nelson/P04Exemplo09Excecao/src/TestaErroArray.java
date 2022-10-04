public class TestaErroArray {
	public static void main(String[] args) {
		int [] num = {0,1,2,3,4};
		try {
			for(int i=0;i<num.length;i++) {
				System.out.println(num[i]);
			}
			int x = 10 / 10;
			vaiEstourar(30);
			double [][][][][] s = new double[365][24][60][60][1000];
		}
		catch(ArrayIndexOutOfBoundsException e) {
			System.out.println("Contate a Elys...");
			System.out.println(e);
		}
		catch(ArithmeticException e) {
			System.out.println("Contate o Sinomar...");
			System.out.println(e);
		}
		catch(StackOverflowError e) {
			System.out.println("Contate o Tiberio...");
			System.out.println(e);
		}
		catch(OutOfMemoryError e) {
			System.out.println("Contate o Ivo...");
			System.out.println(e);
		}
	}
	
	public static void vaiEstourar(int a) {
		if (a<0) return;
		vaiEstourar(--a);
	}
}