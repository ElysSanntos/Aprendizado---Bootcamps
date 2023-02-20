//Designer eh um Funcionario, Designer herda da classe Funcionario
public class Designer extends Funcionario {

    public double getBonificacao() {
        System.out.println("Chamando o método de bonificacao do Designer");
        return 200.0;

    }

}