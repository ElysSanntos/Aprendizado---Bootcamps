package Parte4_Exercicio05_SubClasses_Pag182;

public class Livro {
	
	private String codigo;
	 private String descricao;
	 private String ISBN;
	 private double precoCompra;
	 private double precoVenda;

	 public double calculaLucro(){
	 double diferenca = precoVenda - precoCompra;
	 return diferenca;
	 }

}
