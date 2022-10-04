package Parte4_Exercicio05_SubClasses_Pag182;

import java.util.Date;

public class Alimenticio extends Produto{

	
	private Date dataFabricacao;
	private Date dataValidade;
	private double imposto;
	
	

	public double calculaLucro(){
		
	double diferenca = super.calculaLucro();
	double lucro = diferenca - (precoVenda * imposto);
	return lucro;

	}
	
	public Alimenticio() {}

	public Alimenticio(String codigo, 
			           String descricao, 
			           double precoCompra, 
			           double precoVenda,
			           Date dataFabricacao,
			           Date dataValidade,
			           double imposto
			) {
		super(codigo, descricao, precoCompra, precoVenda);
		this.dataFabricacao = dataFabricacao;
		this.dataValidade = dataValidade;
		this.imposto = imposto;
	}



	public Date getDataFabricacao() {
		return dataFabricacao;
	}


	public Date getDataValidade() {
		return dataValidade;
	}


	public void setDataFabricacao(Date dataFabricacao) {
		this.dataFabricacao = dataFabricacao;
	}


	public void setDataValidade(Date dataValidade) {
		this.dataValidade = dataValidade;
	}
	
	
}
