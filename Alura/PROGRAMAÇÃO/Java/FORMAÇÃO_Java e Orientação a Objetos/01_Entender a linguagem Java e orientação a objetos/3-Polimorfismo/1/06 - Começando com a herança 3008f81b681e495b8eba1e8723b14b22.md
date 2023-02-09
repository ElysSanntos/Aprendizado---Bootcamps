# 06 - Começando com a herança

Anteriormente, identificamos certos problemas em trabalhar com todas as funcionalidades em uma única classe. Nas próximas aulas, daremos início ao aprendizado com o conceito de herança.

Em nosso exemplo, temos diferentes tipos de funcionários, cada um com suas especificidades, ou seja, termos cada uma delas em um só lugar tornará nosso programa muito difícil de manter.

Nosso objetivo então será separar as classes. Teremos uma para `Funcionario` e outra para `Gerente`.

Primeiro apagaremos a classe `FuncionarioTeste`, que foi criada anteriormente apenas como um exemplo. Apagaremos também a classe `Teste`.

> Para deletar uma classe, basta selecioná-la e pressionar o botão "delete" e, em seguida, confirmar pressionando o botão "Ok".
> 

Nos restam portanto as classes `Funcionario` e `Teste`.

A partir da classe `Funcionario`, criaremos a classe `Gerente`. A selecionaremos e utilizaremos o atalho "Ctrl + C" e "Ctrl + V", para que seja criada uma cópia sua. À esta cópia, daremos o nome de `Gerente`.

Ela terá todos os atributos que o `Funcionario` possui, exceto pela `senha`, que será criada especificamente para ele. Além disso, agora a `Bonificacao` funcionará unicamente para o gerente. Por fim, se temos uma `senha`, teremos também um método que a `autentica`:

```
public class Gerente {

        private String nome;
        private String cpf;
        private double salario;
        private int senha;

        public boolean autentica(int senha) {
            if(this.senha == senha) {
                return true;
            } else {
                return false;
            }
        }

        public double getBonificacao() {
            return this.salario;
        }

//Código continua abaixo...COPIAR CÓDIGO
```

Assim, nosso código melhorou, mas ainda pode ficar menos verboso. Como podemos observar, diversos dos atributos foram repetidos em ambas as classes, bem como muitos dos *getters* e *setters*.

O ideal seria termos um mecanismo que nos permitisse indicar que o `Gerente` já possui estes elementos presentes em `Funcionario`. Ou seja, teríamos que indicar ao Java que o `Gerente` **herda tudo** de `Funcionario`.

Na sintaxe da linguagem, a herança é expressada pela palavra `extends`. Nossa classe `Gerente` ficaria então da seguinte forma:

```
public class Gerente extends Funcionario {

    private int senha;

    public boolean autentica(int senha) {
        if(this.senha == senha) {
            return true;
        } else {
            return false;
        }
    }

    public double getBonificacao() {
        return this.salario;
    }
}COPIAR CÓDIGO
```

Em comentários, podemos manter a ordem de hereditariedade, para referência:

```
//Gerente é um Funcionário, Gerente herda da classe Funcionário
public class Gerente extends Funcionario {

    private int senha;

    public boolean autentica(int senha) {
        if(this.senha == senha) {
            return true;
        } else {
            return false;
        }
    }

    public double getBonificacao() {
        return this.salario;
    }
}COPIAR CÓDIGO
```

Ou seja, `Gerente` tem, e sabe fazer, tudo que `Funcionario` tem, e faz.

Ainda assim, nosso método `getBonificacao()` apresenta um erro. Resolveremos isso, mas, por enquanto, vamos apenas deixá-lo em comentários:

```
//Gerente é um Funcionário, Gerente herda da classe Funcionário
public class Gerente extends Funcionario {

    private int senha;

    public boolean autentica(int senha) {
        if(this.senha == senha) {
            return true;
        } else {
            return false;
        }
    }

//    public double getBonificacao() {
//        return this.salario;
//    }
}COPIAR CÓDIGO
```

Salvaremos e testaremos essas modificações. Criaremos uma nova classe, chamada `TesteGerente`, e geraremos o método `main`:

```
public class TesteGerente {

    public static void main(String[] args) {

    }
}COPIAR CÓDIGO
```

E criaremos um gerente hipotético, utilizando o construtor padrão, que chamaremos de `g1`:

```
public class TesteGerente {

    public static void main(String[] args) {
        Gerente g1 = new Gerente();
    }
}COPIAR CÓDIGO
```

Como o `Gerente` é um `Funcionario`, podemos utilizar, de forma direta, o método `setNome` - que origina da classe `Funcionario`. O mesmo vale para o `nome` e `salario`:

```
public class TesteGerente {

    public static void main(String[] args) {
        Gerente g1 = new Gerente();
        g1.setNome("Marco");
        g1.setCpf("235568413");
        g1.setSalario(5000.0);
    }
}COPIAR CÓDIGO
```

Em seguida, utilizaremos o `System.out.println` para imprimirmos o nome, CPF e salário deste gerente:

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
    }
}COPIAR CÓDIGO
```

Apesar de estarmos utilizando estes métodos para um gerente, como podemos perceber, todos eles foram criados na classe `Funcionario`.

Salvaremos e testaremos esta classe. No console, foi impresso o seguinte:

```
Marco
235568413
5000.0COPIAR CÓDIGO
```

Nosso programa funcionou. Nesta ocasião, o gerente `g1` se comportou como um funcionário comum. Entretanto, ele também conta com um método `autentica`, particular, que não consta em `Funcionario`:

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

        boolean autenticou = g1.autentica(2222);

        System.out.println(autenticou);
    }
}COPIAR CÓDIGO
```

Este método foi criado na classe `Gerente` e existe somente nela.

Executaremos mais uma vez, para testarmos. Temos o seguinte resultado no console:

```
Marco
235568413
5000.0
falseCOPIAR CÓDIGO
```

Ele nos devolveu `false` porque a senha padrão do `Gerente` é `0`, já que não inicializamos este atributo com nenhum valor em particular.

> Como não informamos nenhum valor para senha, o Java automaticamente inicializou como 0.
> 

Para realizarmos mais um teste, criaremos um método `setSenha()` na classe `Gerente`:

```
//Gerente é um Funcionário, Gerente herda da classe Funcionário

public class Gerente extends Funcionario {

    private int senha;

    public void setSenha(int senha) {
        this.senha = senha;
    }

//Código continua abaixoCOPIAR CÓDIGO
```

Retornando à classe `TesteGerente`, chamaremos o método `setSenha()`:

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
}COPIAR CÓDIGO
```

Podemos observar, no próprio menu de sugestões do Eclipse que surge assim que começamos a digitar, que enquanto todos os outros originam de `Funcionario`, este método vem da classe `Gerente`.

Salvaremos e executaremos. No console, temos:

```
Marco
235568413
5000.0
trueCOPIAR CÓDIGO
```

Deu certo! Estamos utilizando herança com sucesso. Com o vocábulo `extends` é possível ter as características, atributos e métodos da classe `Funcionario`. Adiante, veremos como podemos resolver nosso problema com a `Bonificacao`.