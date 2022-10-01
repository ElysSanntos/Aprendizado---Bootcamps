package Parte4_Exercicio05_SubClasses_Pag182;

import java.util.Date;

public class TestaProduto {

	public static void main(String[] args) {

	
			Alimenticio a = new Alimenticio(
					"15481-9",
					"Arroz Tio Joao 5kg",
					8.0,
					15.0,
					new Date(),
					new Date(),
					0.1
					);
			
			Livro b = new Livro(
					"54845-8",
					"Use a Cabeca - Java",
					20.0,
					160.0,
					"978-8576081739"
					);

			System.out.println("Lucro Alimenticio R$ "+a.calculaLucro());
			System.out.println("Lucro Livro       R$ "+b.calculaLucro());
		}
	}


