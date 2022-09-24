package Aula7_220923_Arrays_Pag141;

import java.util.Date;
import java.util.Random;
import java.util.Scanner;

public class UsoDoArray {

	public static void main(String[] args) {

		// Declaração e instanciação do array
		int billy[] = new int[5];
		int maria[] = { 23, 34, 98, 77 };

		billy[0] = 0;
		billy[1] = 1;
		billy[2] = 2;
		billy[3] = 3;
		billy[4] = 4;

		System.out.println("    ========= Array Billy ==========\n");
		System.out.println("Endereço na memoria: " + billy);
		System.out.println("Quem está no endereço 2:  " + billy[2]);
		System.out.println("Comprimento do Array:  " + billy.length);
		System.out.println("\n   ========= Array Maria ==========\n");
		System.out.println("Endereço na memoria: " + maria);
		System.out.println("Quem está no endereço 2:  " + maria[2]);
		System.out.println("Comprimento do Array:  " + maria.length);

		System.out.println("\n========== Array Billy no laço for(;;) tradicional ==========\n");

		for(int i=0;i<billy.length;i++) {
			System.out.print("Posição: " + billy[i]+" \t ");
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

		System.out.println("\n========== Array Billy no laço for(:) aprimorado(enhaced for) ==========\n");

		for (int balde : a) {
			System.out.println(balde + "\t");

		}
		
		System.out.println("\n========== Array Billy no laço for(;;) tradicional * 2 ==========\n");
		for(int i=0;i<a.length;i++) {
			a[i] = a[i]*2;
			System.out.print(a[i] + "\t");
		}
	}

}
}
