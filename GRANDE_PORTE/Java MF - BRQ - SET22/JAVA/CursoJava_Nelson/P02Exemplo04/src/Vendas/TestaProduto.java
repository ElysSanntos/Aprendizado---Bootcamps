package Vendas;
public class TestaProduto {
	public static void main(String[] args) {
		final int valor = 20;
		
		Produto p1 = new Produto();
		Produto p2 = new Produto("Caneta");
		Produto p3 = new Produto("Livro");
		p1.imprime();
		p2.imprime();
		p3.imprime();
	}
}