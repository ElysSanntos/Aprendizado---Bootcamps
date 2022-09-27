package Parte4_Heranca_Poligono;


//teste da herança
public class TestaPoligonos {

	public static void main(String[] args) {
		CRetangulo rect = new CRetangulo();
		CTriangulo trgl = new CTriangulo();
		CPoligono  plgn = new CPoligono();
		
		 rect.setValores (4,5);
		 trgl.setValores (4,5);
		 plgn.setValores(4, 5);
		 
		 System.out.println("Área do retangulo: " + rect.area());
		 System.out.println("Área do triangulo: " +trgl.area());
		 //System.out.println("Área do Poligono: "  +plgn.area());

	}

}
