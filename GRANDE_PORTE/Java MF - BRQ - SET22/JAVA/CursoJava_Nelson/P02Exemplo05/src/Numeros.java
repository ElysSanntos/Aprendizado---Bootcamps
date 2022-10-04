import java.util.Scanner;

public class Numeros {
	public static void main(String[] args) {
		Integer a = 10;
		System.out.println(a);
		
		Double pi = 3.14159;
		int num = pi.intValue();
		byte x = pi.byteValue();
		
		String nota = "8.25";
		double n = Double.parseDouble(nota);
		
		Scanner ze = new Scanner(System.in);
		int num1 = Integer.parseInt(ze.nextLine());
		double num2 = Double.parseDouble(ze.nextLine());
	}
}