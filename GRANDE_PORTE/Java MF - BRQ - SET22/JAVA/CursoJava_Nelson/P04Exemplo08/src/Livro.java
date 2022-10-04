
public class Livro extends Produto{
	private String ISBN;

	public Livro() {}

	public Livro(String codigo, 
			     String descricao, 
			     double precoCompra, 
			     double precoVenda,
			     String ISBN) {
		super(codigo, descricao, precoCompra, precoVenda);
		this.ISBN = ISBN;
	}
	
	@Override
	public double calculaLucro() {
		return  super.calculaLucro();
	}

	public String getISBN() {
		return ISBN;
	}

	public void setISBN(String iSBN) {
		ISBN = iSBN;
	}	
}
