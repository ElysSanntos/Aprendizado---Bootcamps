package Parte04_ExemploDeAula02_Coercao;

public class Coercao {
	public static void main(String[] args) {
		int idade = 10;
		long a = idade;
		float b = idade;
		double c = idade;
		System.out.println("Declarado como int " +idade);
		System.out.println("De double para long: " + idade);
		System.out.println("De double para float: " + idade);
		System.out.println("De double para double: " + idade);

System.out.println("================================================");
		
		//Casting
		double altura = 1.66;
		byte d = (byte)altura;
		short e = (short)altura;
		int f = (int)altura;
		long g = (long)altura;
		float h = (float) altura;
		
		
		System.out.println("Declarado como double " +altura);
		System.out.println("De double para byte: " + d);
		System.out.println("De double para short: " +e);
		System.out.println("De double para int: " +f);
		System.out.println("De double para long: " +g);
		System.out.println("De double para float: " +h);

		
	}

}
