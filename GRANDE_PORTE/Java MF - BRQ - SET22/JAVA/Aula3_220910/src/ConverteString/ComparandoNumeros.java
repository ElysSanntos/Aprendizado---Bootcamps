package ConverteString;

import java.util.Scanner;

public class ComparandoNumeros {

	public static void main(String[] args) {
		/*
		 * Integer num1 = new Integer(1); 
		 * Integer num2 = new Integer(2);
		 */
		 
		Integer num1 = 1;
		Integer num2 = 2;
		
		 if(num1.compareTo(num2) == -1)
		 System.out.println("num1 � maior que num2");
		 if(num1.compareTo(num2) == 0)
		 System.out.println("num1 � igual a num2");
		 if(num1.compareTo(num2) == 1)
		 System.out.println("num1 � menor que num2");
		 if(num1.equals(num2))
		 System.out.println("num1 � igual a num2");
		 Scanner lerTeclado = new Scanner(System.in);

		 System.out.print("Informe um n�mero : ");
		 String dado = lerTeclado.next();
		 int num3 = Integer.parseInt(dado);
		 System.out.print("num3 = " + num3);
	}

}
