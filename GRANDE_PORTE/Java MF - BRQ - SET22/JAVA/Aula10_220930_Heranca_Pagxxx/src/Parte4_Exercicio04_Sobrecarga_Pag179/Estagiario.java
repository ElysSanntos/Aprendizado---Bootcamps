package Parte4_Exercicio04_Sobrecarga_Pag179;

public class Estagiario  extends Funcionario{
	
	// construtor evocando super
	 public Estagiario(int idFunc,
	 String nomeFunc,
	double salarioHora){
	 super(idFunc,nomeFunc,salarioHora);
	 }
	 // c�lculo do sal�rio l�quido para estagi�rios
	 @Override
	 public double calculaSalario(double horasTrabalhadas){
	 double salBruto = salarioHora * horasTrabalhadas;
	 double salLiquido;
	 if (salBruto <= 1000.00)
	 salLiquido = 1000.00;
	 else
	 salLiquido = salBruto;
	 return salLiquido;

}
	// c�lculo da bonifica��o para os estagi�rios
	 @Override
	 public double bonificacao(){
	 return super.bonificacao() + 200.0;}
}
