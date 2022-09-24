package Aula7_220923_Arrays_Pag141;

import java.util.Date;
import java.util.Random;
import java.util.Scanner;

public class UsoDoArray {

	public static void main(String[] args) {

		// Declara��o e instancia��o do array
		int billy[] = new int[5];
		int maria[] = { 23, 34, 98, 77 };

		billy[0] = 0;
		billy[1] = 1;
		billy[2] = 2;
		billy[3] = 3;
		billy[4] = 4;

		System.out.println("    ========= Array Billy ==========\n");
		System.out.println("Endere�o na memoria: " + billy);
		System.out.println("Quem est� no endere�o 2:  " + billy[2]);
		System.out.println("Comprimento do Array:  " + billy.length);
		System.out.println("\n   ========= Array Maria ==========\n");
		System.out.println("Endere�o na memoria: " + maria);
		System.out.println("Quem est� no endere�o 2:  " + maria[2]);
		System.out.println("Comprimento do Array:  " + maria.length);

		System.out.println("\n========== Array Billy no la�o for(;;) tradicional ==========\n");

		for(int i=0;i<billy.length;i++) {
			System.out.print("Posi��o: " + billy[i]+" \t ");
		}
		{
			Scanner ze = new Scanner(System.in);
			System.out.print("\nEntre o tamanho do array...: ");
			int tam = Integer.parseInt(ze.nextLine());
			int a [] = new int[tam];
			System.out.println(a.length);
			Random ml = new Random(new Date().getTime());
			for(int i=0; i<a.length;i++) {
				a[i] = ml.nextInt(100);
			}

		System.out.println("\n========== Array Billy no la�o for(:) aprimorado(enhaced for) ==========\n");

		for (int balde : a) {
			System.out.println(balde + "\t");

		}
		
		System.out.println("\n========== Array Billy no la�o for(;;) tradicional * 2 ==========\n");
		for(int i=0;i<a.length;i++) {
			a[i] = a[i]*2;
			System.out.print(a[i] + "\t");
		}
	}

}
}
