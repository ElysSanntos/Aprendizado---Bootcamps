package br.com.bytebank.banco.teste;

public class TesteArray2 {

	public static void main(String[] args) {


		int [] idades = new int [5]; //inicializa o array com 0(zero)
		
		
		for (int iterator = 0; iterator< idades.length; iterator ++) {
			idades[iterator] = iterator * iterator;
			
		}
		
		for (int iterator = 0; iterator< idades.length; iterator ++) {
			System.out.println(idades[iterator]);
			
		}
		


	}

}
