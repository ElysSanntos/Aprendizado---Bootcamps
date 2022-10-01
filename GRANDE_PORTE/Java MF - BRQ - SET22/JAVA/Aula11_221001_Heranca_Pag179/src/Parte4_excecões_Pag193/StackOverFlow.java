package Parte4_excecões_Pag193;

public class StackOverFlow {

	public static void main(String[] args) {


		try {
			double milenium [][][][][] = new double[365][24][60][60][1000];
			
		} catch (OutOfMemoryError error) {
			System.out.println("Contate o IVO....");
			System.out.println(error);
		}

	}

}
