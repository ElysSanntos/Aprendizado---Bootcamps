//Gerente eh um Funcionario, Gerenre herda da classe Funcionario
public class EditorVideo extends Funcionario {

    public double getBonificacao() {
        System.out.println("Chamando o método de bonificacao do Editor de Video");
        return super.getBonificacao() + 100;

    }

}