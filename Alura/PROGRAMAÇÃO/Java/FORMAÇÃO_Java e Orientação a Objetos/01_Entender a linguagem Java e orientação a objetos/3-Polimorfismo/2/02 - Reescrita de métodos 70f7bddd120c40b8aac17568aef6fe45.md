# 02 - Reescrita de métodos

Olá, tudo bem? A partir desta aula, passaremos a estudar alternativas para tratar do método `getBonificacao()`, que havíamos deixado em comentários anteriormente:

```
//Gerente é um Funcionario, Gerente herda da classe Funcionario

public class Gerente extends Funcionario {

        private int senha;

        public void setSenha(int senha) {
            this.senha = senha;
        }

        public boolean autentica(int senha) {
            if(this.senha == senha) {
                return true;
            } else {
                return false;
            }
        }

//        public double getBonificacao() {
//            return this.salario;
//        }
}COPIAR CÓDIGO
```

Removeremos os comentários, simplesmente removendo as barras.

> No Mac OS, o atalho para isso é "Command + 7".
> 

Assim que fizermos isso, podemos observar que o Eclipse nos informa que há um erro de compilação.

O objetivo de `getBonificacao()` era implementarmos, na classe `Funcionario`, um método que calculasse uma bonificação padrão para todos os funcionários, entretanto, vimos que isso não condiz com a realidade de negócio da empresa, uma vez que o gerente terá uma bonificação diferenciada dos demais funcionários da empresa.

Por isso, precisamos inserir esta funcionalidade específica na própria classe `Gerente`. Entretanto, isto não funciona - por que não?

Dentro do método, estamos tentando acessar o `salario`. Se olharmos a classe `Funcionario`:

```
public class Funcionario {

        private String nome;
        private String cpf;
        private double salario;

//Código omitido

}COPIAR CÓDIGO
```

Vemos que este atributo é `private`, ou seja, privado. Trata-se de um modificador de visibilidade, que permite que esta informação seja visível somente dentro **desta** classe. Acontece que, ao utilizar o método `getBonificacao()` na classe `Gerente` estamos querendo acessá-la externamente, por isso o Eclipse aponta um erro de compilação.

Uma solução seria alterar o modificador de visibilidade, de `private`, para `public`. Isso solucionaria o problema de compilação, mas essa seria uma boa prática de programação?

Como vimos, temos que buscar sempre **encapsular** os atributos, que são detalhes da programação que não devem ser visíveis, ou acessíveis diretamente fora de sua classe.

Isso nos permitiria, por exemplo, alterar o salário de um funcionário em outra classe completamente distinta - não é uma boa prática de programação permitirmos que isto aconteça.

Para solucionar nosso problema, veremos que há um outro modificador de visibilidade que está entre o `private` e o `public`, ou seja, ele nem é visível somente em determinada classe, e tampouco pode ser visualizado por todos. Este modificador se chama `protected`.

Desta forma, as informações ali contidas serão públicas apenas para si e para os filhos, as demais classes, não. Dessa forma, nosso código assumirá a seguinte sintaxe:

```
public class Funcionario {

        private String nome;
        private String cpf;
        protected double salario;

//Código omitido

}COPIAR CÓDIGO
```

Retornaremos à classe `TesteFuncionario` e veremos que, mesmo com esta alteração, o código ainda funciona. Isso acontece em razão de um outro problema, que está relacionado à forma como organizamos as classes dentro dos pacotes. Veremos mais sobre isto adiante.

Com a classe `TesteGerente`, testaremos se é possível utilizarmos o `getBonificacao()`:

```
public class TesteGerente {

        public static void main(String [] args) {
                Gerente g1 = new Gerente();
                g1.setNome("Marco");
                g1.setCpf("23556813");
                g1.setSalario(5000.0);

                System.out.println(g1.getNome());
                System.out.println(g1.getCpf());
                System.out.println(g1.getSalario());

                g1.setSenha(2222);
                boolean autenticou = g1.autentica(2222);

                System.out.println(autenticou);

                System.out.println(g1.getBonificacao());

        }

}COPIAR CÓDIGO
```

Executaremos. Temos o seguinte resultado no console:

```
Marco
235568413
5000.0
true
5000.0COPIAR CÓDIGO
```

Todos os dados foram impressos corretamente, inclusive a bonificação, que foi calculada com base na regra específica para o `Gerente`.

Testaremos também a classe `TesteFuncionario`:

```
public class TesteFuncionario {

        public static void main(String[] args) {

                Funcionario nico = new Funcionario();
                nico.setNome("Nico Steppat");
                nico.setCpf("223355646-9");
                nico.setSalario(2600.00);

                System.out.println(nico.getNome());
                System.out.println(nico.getBonificacao());

                //nico.salario = 300.0;

        }

}COPIAR CÓDIGO
```

Executaremos e, no console, temos o seguinte resultado:

```
Nico Steppat
260.0COPIAR CÓDIGO
```

Temos o nome, e a bonificação, impressos corretamente.

Ou seja, para `Funcionario` foi utilizado o método desta classe, enquanto que para a classe `Gerente`, foi usado o método específico contido nela.

Como vimos, temos um terceiro modificador de visibilidade, chamado `protected`, que está entre o `private` e o `public`, e significa que sua informação é compartilhada somente entre seus filhos, ou herdeiros. Ainda não foi possível visualizarmos isto de forma clara porque nossas classes ainda não estão bem subdivididas, por enquanto, elas estão armazenadas em um único pacote.

Quando fizermos a devida separação dos arquivos, veremos que a linha de código em `TesteFuncionario` que usa o atributo `salario` deixará de funcionar.

O `protected` foi feito para liberar o acesso ao atributo para os filhos, e deixar privado para todas as outras classes. Ou seja, quem não é um `Funcionario` não verá o `salario`.

Antes de partirmos para os exercícios, faremos mais uma melhoria em nosso código.

Retornaremos para a classe `Gerente`:

```
public class Gerente extends Funcionario {

        private int senha;

        public void setSenha(int senha) {
            this.senha = senha;
        }

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

Como programador, ao utilizarmos e vermos um `this.`, no caso, `this.salario`, no código, somos levados a olhar para os atributos, porque pensamos automaticamente que `salario` é um atributo desta classe.

O `this`, além de guardar a referência para mexermos nos atributos do objeto, para o desenvolvedor, significa que o atributo deve estar definido nesta classe. Entretanto, neste caso o salário não está definido na classe `Gerente`, e sim na classe mãe, ou super classe, `Funcionario`.

Para deixarmos isso explícito em nosso código, ou seja, que o `salario` vem da super classe, há uma outra palavra que podemos utilizar, que é `super`:

```
public class Gerente extends Funcionario {

        private int senha;

        public void setSenha(int senha) {
            this.senha = senha;
        }

        public boolean autentica(int senha) {
            if(this.senha == senha) {
                return true;
            } else {
                return false;
            }
        }

        public double getBonificacao() {
            return super.salario;
        }
}COPIAR CÓDIGO
```

Desta forma, o desenvolvedor sabe que precisará subir na hierarquia para encontrar este atributo, já que ele não está definido nesta classe. Se colocarmos `super` em algo definido na própria classe, o Eclipse apontará um erro de compilação, já que neste caso ele procurará na classe acima e não encontrará tal atributo.

Por fim, na classe `Funcionario`, temos nosso método `getBonificacao()` que é público, devolve um `double`, e não recebe parâmetros:

```
//Código omitido
public double getBonificacao() {
        return this.salario * 0.1;
}

//Código omitidoCOPIAR CÓDIGO
```

Isto é chamado de **assinatura do método**. Se olharmos para a classe `Gerente`, veremos que lá temos a mesma assinatura do método, o que chamamos de **reescrita**.

Temos o método definido na classe mãe, e redefinimos este método na classe filha, ou seja, fizemos a reescrita do método.

A característica da reescrita é utilizar a mesma assinatura do método, há algumas peculiaridades que podem variar mas, em geral, é este o conceito, ou seja, mesma visibilidade, mesmo retorno, mesmo nome e mesmos parâmetros.

Com isso, podemos partir para a prática e nos vemos nas próximas aulas!