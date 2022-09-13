package Exercicio1;


public class QtdeCavalos {

	public static void main(String[] args) {

		double cavalos;
		double m = 1000.0;
		double h = 100.0;
		double t = 10.0;
		
		cavalos = m*h/t/745.6999;
		
		System.out.println("Precisarei de: " + cavalos +" cavalos  para levantar o peso de " +m
											 + " kilos"+ " a uma altura de: "+ h 
											 + " metros, e farei isso em "+ t + " horas.");
		
		
	}

}
