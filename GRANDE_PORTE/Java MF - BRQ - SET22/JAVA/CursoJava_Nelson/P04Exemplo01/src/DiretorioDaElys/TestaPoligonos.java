package DiretorioDaElys;
public class TestaPoligonos {
	public static void main(String[] args) {
		CPoligono  p = new CPoligono();
		CRetangulo r = new CRetangulo();
		CTriangulo t = new CTriangulo();
		
		p.setValores(3, 4);
		r.setValores(3, 4);
		t.setValores(3, 4);
		
		System.out.println("Area Retangulo = " + r.area());
		System.out.println("Area Triangulo = " + t.area());
		
		GuerraDoParaguai riachuelo = new GuerraDoParaguai();
		riachuelo.id = 1;
		riachuelo.nome = "batalha do Riachuelo";
		riachuelo.ano = 1865;
		
	}
}