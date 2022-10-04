package Parte4_Exercicio03_ValorXerox_Pag211;

import java.text.SimpleDateFormat;

public class TestaCopias {

	public static void main(String[] args) {
		
		SimpleDateFormat ft = new SimpleDateFormat("dd/MM/yyyy");
		
		try {
			// Pessoa
			Pessoa pes01 = new Pessoa("Jose da Silva", 
					                  "111.111.111-11", 
					                  ft.parse("10/05/1998"));
			System.out.println("Nome: "+pes01.getNome()+ "\t\t"+" Tipo: Pessoa\t"+"Qtde 100 .........\tR$"+
					           pes01.tirarCopias(100));
			// Aluno
			Aluno alu01 = new Aluno("Maria Costa e Silva",
									"222.222.222-22",
									ft.parse("05/06/2000"),
									"232213-8");
			System.out.println("Nome: "+alu01.getNome() + "\t"+" Tipo: Aluno\t"+"Qtde 100 ..........\tR$"+
			           alu01.tirarCopias(100));
			// Professor
			Professor prof01 = new Professor("Marcos Pontes",
											"333.333.333-33",
											ft.parse("20/09/1990"),
											5000.0,
											"Estrutura de Dados");
			System.out.println("Nome: "+prof01.getNome()+"\t\t"+" Tipo: Profess\t"+"Qtde 100 ..........\tR$"+
			           prof01.tirarCopias(100));
			
			// Funcionário
			Funcionario func01 = new Funcionario("Josilaine Figueras Liz",
												"444.444.444-44",
												ft.parse("02/02/1992"),
												8000.0,
												ft.parse("05/10/1999"),
												"Inspetor de Aluno");
			System.out.println("Nome: "+func01.getNome()+"\t"+" Tipo: Funciona\t"+"Qtde 100 ..........\tR$"+
			           func01.tirarCopias(100));
			
		} catch (Exception e) {
			System.out.println(e);
		}
	}

	}


