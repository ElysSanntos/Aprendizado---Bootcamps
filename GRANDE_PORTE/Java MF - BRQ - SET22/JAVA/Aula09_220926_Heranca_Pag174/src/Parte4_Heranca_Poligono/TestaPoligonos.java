package Parte4_Heranca_Poligono;


//teste da heran�a
public class TestaPoligonos {

	public static void main(String[] args) {
		CRetangulo rect = new CRetangulo();
		CTriangulo trgl = new CTriangulo();
		CPoligono  plgn = new CPoligono();
		
		 rect.setValores (4,5);
		 trgl.setValores (4,5);
		 plgn.setValores(4, 5);
		 
		 System.out.println("�rea do retangulo: " + rect.area());
		 System.out.println("�rea do triangulo: " +trgl.area());
		 //System.out.println("�rea do Poligono: "  +plgn.area());

	}

}
