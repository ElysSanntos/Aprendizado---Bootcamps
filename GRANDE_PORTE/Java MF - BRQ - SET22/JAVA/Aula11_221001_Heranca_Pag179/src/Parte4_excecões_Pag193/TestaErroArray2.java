package Parte4_excecões_Pag193;

public class TestaErroArray2 {

	public static void main(String[] args) {

		int[] num = { 0, 1, 2, 3, 4 };

		try {
			// for iterando até exceder os limites do array
			for (int i = 0; i < num.length; i++) {
				System.out.println(num[i]);
			}
			int x = 10/0;
			int y = 10/10;
		} catch (ArithmeticException e) {
			System.out.println("Contate o Sinomar....");
			System.out.println(e);
		}
		
		
	}
	

}
