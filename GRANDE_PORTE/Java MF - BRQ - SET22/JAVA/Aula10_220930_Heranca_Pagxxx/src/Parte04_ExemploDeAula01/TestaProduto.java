package Parte04_ExemploDeAula01;

public class TestaProduto {
	public static void main(String[] args) {
		Produto p1 = new Produto(1,"Livro");
		Produto p2 = new Produto(3,"Tablet");
		Produto p3 = p1;
		
		System.out.println(p1.equals(p2));
		System.out.println(p1.equals(p3));
		System.out.println(p1.getClass());
		System.out.println(p1.toString());
	}
}