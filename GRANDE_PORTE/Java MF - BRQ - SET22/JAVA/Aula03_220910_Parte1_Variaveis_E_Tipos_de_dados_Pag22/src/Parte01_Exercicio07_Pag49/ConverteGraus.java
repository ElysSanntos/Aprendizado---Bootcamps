package Parte01_Exercicio07_Pag49;

public class ConverteGraus {

	public static void main(String[] args) {
		
				double C  = 1;
				double F = C * 1.8 + 32;
				double K = C + 273.15;
				double Ra = C * 1.8 + 32 + 459.67;
				double Re = C * 0.8;
				
				System.out.println("Temperatura em °C: " + C);
				System.out.println("Conversão para °F:  " + F + "°F");
				System.out.println("Conversão para °K:  " + K + "°K");
				System.out.println("Conversão para °Ra: " + Ra + "°Ra");
				System.out.println("Conversão para °Re: " + Re + "°Re");
	}

}
