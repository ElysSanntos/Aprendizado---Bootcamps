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
		return precoVenda - precoCompra;
	}

	public String getCodigo() {
		return codigo;
	}

	public String getDescricao() {
		return descricao;
	}

	public double getPrecoCompra() {
		return precoCompra;
	}

	public double getPrecoVenda() {
		return precoVenda;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public void setPrecoCompra(double precoCompra) {
		this.precoCompra = precoCompra;
	}

	public void setPrecoVenda(double precoVenda) {
		this.precoVenda = precoVenda;
	}
}