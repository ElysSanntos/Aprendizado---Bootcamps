package br.com.treinaweb.segundoexercicio;

import java.util.Date;

public class Computador {
	private String nome;
	private double preco;
	private Date dataFabricacao;
	
	public String getNome() {
		return nome;
	}
	
	public void setNome(String nome) {
		this.nome = nome;
	}

	public double getPreco() {
		return preco;
	}

	public void setPreco(double preco) {
		this.preco = preco;
	}

	public Date getDataFabricacao() {
		return dataFabricacao;
	}

	public void setDataFabricacao(Date dataFabricacao) {
		this.dataFabricacao = dataFabricacao;
	}
	
	public void ligar(){
		System.out.println("Computador ligado!");
	}
	
	public void desligar(){
		System.out.println("Computador desligado!");
	}
	
	public void acessarInternet(){
		System.out.println("Computador online!");
	}
}
