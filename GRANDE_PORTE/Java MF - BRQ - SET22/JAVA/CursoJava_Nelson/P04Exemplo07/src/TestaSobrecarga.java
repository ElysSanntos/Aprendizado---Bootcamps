// testa Sobrecarga de método 
public class TestaSobrecarga {
   public static void main (String [] args) {
        Funcionario F01 = new Funcionario(323,"Pedro da Costa",35.00);
        Estagiario  E01 = new Estagiario(548,"Miranda Lima",22.00);      
        System.out.println("Salario Funcionario = " +
                            F01.calculaSalario(160));
        System.out.println("Salario Estagiario  = " +
                            E01.calculaSalario(120));
        System.out.println("Bonificacao Funcionario = " + F01.bonificacao());
        System.out.println("Bonificacao Estagiario  = " + E01.bonificacao());
   }
}
