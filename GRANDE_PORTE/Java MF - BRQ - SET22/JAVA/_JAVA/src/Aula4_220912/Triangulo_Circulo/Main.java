package Aula4_220912.Triangulo_Circulo;

public class Main {

	public static void main(String[] args) {
		
		// criando triângulos e círculos
		 Circulo C1 = new Circulo();
		 Circulo C2 = new Circulo(5.0);
		 Triangulo T1 = new Triangulo();
		 Triangulo T2 = new Triangulo(3.0,4.0);
		 C1.setRaio(8.0);
		 T1.setBase(4.0);
		 T1.setAltura(5.0);
		 
		 // exibindo seus atributos, área e perímetro
		 System.out.println("Circulo 1: \t raio = " + C1.getRaio() +
		 "\tarea = " + C1.getArea() +
		 "\tperimetro = " + C1.getPerimetro());
		 
		 System.out.println("Circulo 2: \t raio = " + C2.getRaio() +
		 "\tarea = " + C2.getArea() +
		 "\tperimetro = " + C2.getPerimetro());
		 
		 System.out.println("Triangulo 1: \t base = " + T1.getBase() +
		 "\taltura = " + T1.getAltura() +
		 "\tarea = " + T1.getArea(0, 0) +
		 "\tperimetro = " + T1.getPerimetro());
		 System.out.println("Triangulo 2: \t base = " + T2.getBase() +
		 "\taltura = " + T2.getAltura() +
		 "\tarea = " + T2.getArea(0, 0) +
		 "\tperimetro = " + T2.getPerimetro());
		 }

	}


