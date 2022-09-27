package Estoque;

public class Produto {
	private int idProduto;
	private String descProduto;
	
	public Produto(int idProduto, String descProduto) {
		this.idProduto = idProduto;
		this.descProduto = descProduto;
	}
	
	public int getIdProduto() {
		return idProduto;
	}
	public String getDescProduto() {
		return descProduto;
	}
	public void setIdProduto(int idProduto) {
		this.idProduto = idProduto;
	}
	public void setDescProduto(String descProduto) {
		this.descProduto = descProduto;
	}

}
