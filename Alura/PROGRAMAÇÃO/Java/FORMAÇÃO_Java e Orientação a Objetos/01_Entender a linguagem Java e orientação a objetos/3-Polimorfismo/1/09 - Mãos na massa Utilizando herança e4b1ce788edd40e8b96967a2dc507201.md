# 09 - Mãos na massa: Utilizando herança

Chegou a hora de você executar o que foi visto na aula! Para isso, execute os passos listados abaixo.

---

1) No Eclipse, crie um projeto Java, chamado **bytebank-herdado**.

2) Dentro deste projeto, crie a classe **`Funcionario`** com os atributos privados **`nome`** e **`cpf`**, do tipo **String**, e **`salario`**, do tipo **double**.

3) Gere os *getters* e *setters* para todos os atributos da classe **`Funcionario`**.

4) O funcionário pode receber uma bonificação, de 10% do salário, então crie o método **`getBonificacao()`**, que faça esse cálculo:

```
public double getBonificacao() {
    return this.salario * 0.1;
}COPIAR CÓDIGO
```

5) Para testar a classe que você acabou de implementar, crie a classe **`TesteFuncionario`**, com o método **`main`**. Nela, instancie um **`Funcionario`**, dê um nome, CPF e salário a ele, e imprima-os:

```
public class TesteFuncionario {

    public static void main(String[] args) {

        Funcionario nico = new Funcionario();

        nico.setNome("Nico Steppat");
        nico.setCpf("223355646-9");
        nico.setSalario(2590.80);

        System.out.println(nico.getNome());
        System.out.println(nico.getBonificacao());

    }

}COPIAR CÓDIGO
```

6) Agora, crie a classe **`Gerente`**, que **é um funcionário**, logo faça com que essa classe herde tudo da classe **`Funcionario`**.

7) Além disso, um gerente tem uma senha, então crie esse atributo, inteiro e privado, juntamente com o seu *setter*, e um método para autenticar essa senha no sistema:

```
public boolean autentica(int senha) {
    if (this.senha == senha) {
        return true;
    } else {
        return false;
    }
}COPIAR CÓDIGO
```

8) Por fim, para testar a classe **`Gerente`**, crie a classe **`TesteGerente`**, com o método **`main`**. Nela, instancie um **`Gerente`**, dê um nome, CPF, salário e senha a ele, e imprima-os. Além disso, teste a autenticação da senha:

```
public class TesteGerente {

    public static void main(String[] args) {

        Gerente g1 = new Gerente();
        g1.setNome("Marco");
        g1.setCpf("235568413");
        g1.setSalario(5000.0);

        System.out.println(g1.getNome());
        System.out.println(g1.getCpf());
        System.out.println(g1.getSalario());

        g1.setSenha(2222);
        boolean autenticou = g1.autentica(2222);

        System.out.println(autenticou);

    }

}
```

A classe **`Funcionario`** ficará assim:

```
public class Funcionario {

    private String nome;
    private String cpf;
    private double salario;

    public double getBonificacao() {
        return this.salario * 0.1;
    }

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

}COPIAR CÓDIGO
```

E a classe **`Gerente`** ficará assim:

```
public class Gerente extends Funcionario {

    private int senha;

    public void setSenha(int senha) {
        this.senha = senha;
    }

    public boolean autentica(int senha) {
        if (this.senha == senha) {
            return true;
        } else {
            return false;
        }
    }

}COPIAR CÓDIGO
```

Continue com os seus estudos, e se houver dúvidas, não hesite em recorrer ao nosso fórum!