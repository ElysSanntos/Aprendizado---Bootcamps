package Parte04_Exercicio01_Aniversario_Pag207;

import java.util.Date;

public class Aniversarios {
	public static void main(String[] args) {
		try {
			System.out.println("Imprime a data e não o endereço da memória");
		// current date
		Date d1 = new Date();
		System.out.println("d1 " +d1);
		
		System.out.println("\ncom o metodo toString  ");
		System.out.println("d1 "+d1.toString());
		
		System.out.println("\n========================================================");
		System.out.println("Add 1s para executar a instrução");
		Thread.sleep(1000);
		System.out.println(d1);
		
		System.out.println("\n========================================================");
		
		System.out.println("d2 => 01/10/1967" );
		Date d2 = new Date(-71020800000L);
		System.out.println("d2  "+d2);
		
		System.out.println("\n========================================================");
		
		Date dd = new Date(1664885152);
		System.out.println("SECONDS SINCE JAN 01 1970. (UTC)" + dd);
		
		System.out.println("\n========================================================");
		//Precisa multiplicar por mil(acrescentar 3 numeros zeros) e colocar a letra L ao fim para não estourar
		Date elys = new Date(216227152000l);
		System.out.println("Desde o meu nascimento se passaram 216227152000l segundos " + elys);
		
		System.out.println("\n========================================================");
		
		// d3 = 28/06/2000
		Date d3 = new Date(962236800000L);
		System.out.println("d3  "+d3);
		
		System.out.println("d1.after(d2) eh "+ d1.after(d2));
		System.out.println("d1.before(d3) eh "+ d1.before(d3));
		
		//(Date) é um DownCast - O método clone, clona o objeto em outro endereço
		Date d4 = (Date) d3.clone();
		System.out.println("d3.equals(d4) eh "+ d3.equals(d4));
		System.out.println("d3 == d4 eh "+ (d3 == d4));
		
		/*Compara o valor da data do objeto Date que invocou o método com a especificada em data. 
		 * Retorna zero se forem iguais, 
		 * 			-1  se a data do objeto Date for anterior( O objeto atual é menor que o objeto da comparação) ou 
		 * 			+1 se for posterior( O objeto atual é maior que o objeto da comparação).*/
		System.out.println("d1.compareTo(d2) eh MAIOR "+ d1.compareTo(d2));
		System.out.println("d3.compareTo(d4) eh IGUAL "+ d3.compareTo(d4));
		System.out.println("d2.compareTo(d3) eh MENOR "+ d2.compareTo(d3));
		
		System.out.println("\n========================================================");
		/*Retorna a quantidade de milissegundos que se passaram desde 01/01/1970 0h 0min 0s*/
		System.out.println(d1.getTime());
		d4.setTime(2000000000000L);
		System.out.println("d4  "+d4);
		}
		catch(Exception e) {
			System.out.println(e);
		}
	}
}