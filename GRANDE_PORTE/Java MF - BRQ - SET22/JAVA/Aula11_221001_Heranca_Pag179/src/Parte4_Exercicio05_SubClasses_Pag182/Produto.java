package Parte4_Exercicio05_SubClasses_Pag182;

public class Produto {
	
	
	protected String codigo;
	protected String descricao;
	protected double precoCompra;
	protected double precoVenda;
	
	public Produto() {}
	
	public Produto(String codigo, String descricao, double precoCompra, double precoVenda) {
		this.codigo = codigo;
		this.descricao = descricao;
		this.precoCompra = precoCompra;
		this.precoVenda = precoVenda;
	}

	public double calculaLucro() {
		double diferenca = precoVenda - precoCompra;
		return diferenca;
	}
	
	
}
