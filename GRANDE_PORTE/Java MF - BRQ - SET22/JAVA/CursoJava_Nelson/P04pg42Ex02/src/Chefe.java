public class Chefe extends Funcionario {
	// atributos
	protected double contas;
	protected double gastosExtras;
	protected double adicionalChefia;
	
	// construtores
	public Chefe() {}
	public Chefe(String nome, 
			     String rg, 
			     double salarioMensal,
			     double contas, 
			     double gastosExtras, 
			     double adicionalChefia) {
		super(nome, rg, salarioMensal);
		this.contas = contas;
		this.gastosExtras = gastosExtras;
		this.adicionalChefia = adicionalChefia;
	}
	
	// getters e setters
	public double getContas() {
		return contas;
	}
	public double getGastosExtras() {
		return gastosExtras;
	}
	public double getAdicionalChefia() {
		return adicionalChefia;
	}
	public void setContas(double contas) {
		this.contas = contas;
	}
	public void setGastosExtras(double gastosExtras) {
		this.gastosExtras = gastosExtras;
	}
	public void setAdicionalChefia(double adicionalChefia) {
		this.adicionalChefia = adicionalChefia;
	}
	// métodos próprios
	public double pagamentoExtra() {
		return pagamento()+contas+gastosExtras+adicionalChefia;
	}
}