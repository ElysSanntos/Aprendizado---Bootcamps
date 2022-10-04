package Parte4_excecões_Pag193;

public class OutOfMemoryError {

	public static void main(String[] args) {

		int[] num = { 0, 1, 2, 3, 4 };

		try {
			// for iterando até exceder os limites do array
			for (int i = 0; i < num.length; i++) {
				System.out.println(num[i]);
			}
			int x = 10/10;
			vaiEstourar(30);
		} catch (ArithmeticException e) {
			System.out.println("Contate o Sinomar....");
			System.out.println(e);
		}
		
		
	}

	
	public static void vaiEstourar(int a ) {
		if(a<0) return;
		vaiEstourar(900000000);
	}
}
