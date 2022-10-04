// public class Produto extends Object{

public class Produto {
	private int idProduto;
	private String descProduto;
	
	public Produto() {}
	public Produto(int idProduto, String descProduto) {
		this.idProduto = idProduto;
		this.descProduto = descProduto;
	}

	@Override
	public String toString() {
		return "<<Produto>> id: " + idProduto + " descricao: " + descProduto;
	}
}