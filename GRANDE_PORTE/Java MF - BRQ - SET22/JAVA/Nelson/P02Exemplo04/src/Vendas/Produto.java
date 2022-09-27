package Vendas;

public class Produto {
	public static int num=0;
	
	public int idProduto;
	public String descProduto;
	
	public Produto() {
		num++;
		this.idProduto = num;
	}
	public Produto(String descProduto) {
		num++;
		this.idProduto = num;
		this.descProduto = descProduto;
	}
	
	public void imprime() {
		System.out.println("num         = "+num);
		System.out.println("idProduto   = "+idProduto);
		System.out.println("descProduto = "+descProduto);
		System.out.println("-----------------------");
	}
}
