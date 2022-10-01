package Parte4_excecões_Pag193;

public class SimpleDateFormat {

	public static void main(String[] args) {


		try {
			double milenium [][][][][] = new double[365][24][60][60][10000];
			
		} 
		// OutOfMemoryError
		catch(Error error)
		 {
			System.out.println("Contate o IVO....");
			System.out.println(error);
		}

	}

}
