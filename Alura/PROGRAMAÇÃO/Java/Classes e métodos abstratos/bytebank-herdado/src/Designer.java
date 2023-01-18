//Gerente eh um Funcionario, Gerenre herda da classe Funcionario
public class Designer extends Funcionario {

    public double getBonificacao() {
        System.out.println("Chamando o método de bonificacao do Designer");
        return super.getBonificacao() + 50;

    }

}