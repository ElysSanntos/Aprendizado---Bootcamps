// Administrador eh um FuncionarioAutenticavel, e herda da class FuncionarioAutenticavel
public class Administrador extends Funcionario implements Autenticavel {


    private AutenticacaoUtil autenticador;

    public Administrador(){
        this.autenticador = new AutenticacaoUtil();
    }


    public double getBonificacao() {
        System.out.println("Chamando o método de bonificacao do GERENTE");
        return super.getSalario();
    }


    @Override
    public void setSenha(int senha) {

        this.autenticador.setSenha(senha);
    }

    @Override
    public boolean autentica(int senha) {
       return  this.autenticador.autentica(senha);
    }


}
