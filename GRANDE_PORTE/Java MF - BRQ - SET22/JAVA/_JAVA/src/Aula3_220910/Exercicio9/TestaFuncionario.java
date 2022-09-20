package Aula3_220910.Exercicio9;

public class TestaFuncionario {

	public static void main(String[] args) {
		// criando dois funcionários
		 Funcionario F01 = new Funcionario();
		 Funcionario F02 = new Funcionario(1105,"Jose Carlos Silva",6500.00);
		 
		 F01.setCodFunc(1200);
		 F01.setNomeFunc("Maria Antonia Guimarães");
		 F01.setSalarioMensal(8600.00);
		 
		 // exibindo seus atributos
		 System.out.println("Cod: " +F01.getCodFunc() + "\t\t"+"Nome: "+ F01.getNomeFunc() +
				 "\t\t"+"Sálario R$ "+F01.getSalarioMensal());
		 System.out.println("Cod: " +F02.getCodFunc() + "\t\t"+"Nome: "+ F02.getNomeFunc() +
				 "\t\t"+"        Sálario R$ "+F02.getSalarioMensal());
		 
		 // aumentando os salários em 15%
		 F01.setAumento(15.0);
		 F02.setAumento(15.0);
		 
		 // exibindo salario anual
		 System.out.println("Cod: " + F01.getCodFunc()+"\t\t"+"Sálario Anual R$ " + F01.getSalarioAnual());
		 System.out.println("Cod: " + F02.getCodFunc()+"\t\t"+"Sálario Anual R$ " + F02.getSalarioAnual());

	}

}
