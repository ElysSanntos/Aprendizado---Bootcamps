package Aula3_220910.Exercicio4;

public class QtdeSegundos {
	
	public static void main(String[] args) {
		
		int hora = 3;
		int minuto = 32;
		int segundo = 54;
		
		/*f�rmula que calcula quanto tempo se passou at� o momento 
		 * (segundo + minuto*60 + hora * 3600).*/
		double passado = segundo + minuto*60 + hora*3600;
		
		/*quanto falta para acabar o dia, a f�rmula � subtrair 86400 
		* (quantidade de segundos que tem em um dia) com o tempo que j� passou*/
		double faltam = 86400 - passado;
		
		System.out.println("J� se passaram " + passado + " segundos desde o in�cio do dia");
        System.out.println("Faltam " + faltam + " segundos para terminar o dia");
		
		
	}
		
	}


