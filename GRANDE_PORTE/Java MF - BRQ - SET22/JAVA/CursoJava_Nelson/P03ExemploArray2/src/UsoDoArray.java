import java.util.Scanner;
import java.util.Random;
import java.util.Date;

public class UsoDoArray {

	public static void main(String[] args) {
		int[] billy = new int[5];
		int[] maria = { 23, 34, 98, 77 };

		billy[0] = 3;
		billy[1] = 100;
		billy[2] = billy[0] * 2;
		billy[billy[0]] = 9;

		System.out.println(billy[2]);
		System.out.println(maria[2]);
		System.out.println(billy.length);
		System.out.println(maria.length);

		for (int i = 0; i < billy.length; i++) {
			System.out.print(billy[i] + " - ");
		}
		
		Scanner ze = new Scanner(System.in);
		System.out.print("\nEntre o tamanho do array...: ");
		
		int tam = Integer.parseInt(ze.nextLine());
		int a[] = new int[tam];
		
		System.out.println(a.length);
		Random ml = new Random(new Date().getTime());

		for (int i = 0; i < a.length; i++) {
			a[i] = ml.nextInt(100);
		}
		// enhanced for
		for (int balde : a) {
			System.out.print(balde + " - ");
		}

		System.out.println("\n----------------");

		for (int i = 0; i < a.length; i++) {
			a[i] = a[i] * 2;
			System.out.print(a[i] + " - ");
		}
		
		ze.close();
	}
}