public class P02E01 {
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
	   System.out.println("Circulo 1 - raio = " + C1.getRaio()  +
	                                 " area = " + C1.getArea()  +
	                            " perimetro = " + C1.getPerimetro());
	   System.out.println("Circulo 2 - raio = " + C2.getRaio()  +
	                                 " area = " + C2.getArea()  +
	                            " perimetro = " + C2.getPerimetro());
	   System.out.println("Triangulo 1 - base = " + T1.getBase()    +
	                                 " altura = " + T1.getAltura()  +
	                                   " area = " + T1.getArea()    +
	                              " perimetro = " + T1.getPerimetro());

	   System.out.println("Triangulo 2 - base = " + T2.getBase()    +
	                                 " altura = " + T2.getAltura()  +
	                                   " area = " + T2.getArea()    +
	                              " perimetro = " + T2.getPerimetro());
   }
}