//Não pode instanciar dessa classe, pq é abstrata.

public abstract class  Funcionario {

    private String nome;
    private String cpf;
    private double salario;

    /*Recebemos então uma demanda do nosso chefe, informando que não deve existir uma
     regra padrão de bonificação para todos. O designer receberá R$200,00, o editor de
    vídeo recebe R$150,00, e o gerente recebe um salário simples. Não há mais uma regra padrão.
     */


    // metodo sem corpo, não há implementação --- Implementação fica em um dos filhos
    public abstract  double getBonificacao();


    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public double getSalario() {
        return salario;
    }

    public void setSalario(double salario) {
        this.salario = salario;
    }
}
