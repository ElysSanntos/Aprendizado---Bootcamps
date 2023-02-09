# 02 - Revisão e a classe Funcionario

> Você pode fazer o DOWNLOAD do projeto criado no curso anterior.
> 

---

Bem-vindos ao curso de Java Parte 3! Nele, aprenderemos sobre herança e outros aspectos conceituais.

Antes de começarmos a programar, revisaremos o ambiente no qual estamos trabalhando.

Abriremos o **terminal**, no qual, digitando:

```
java -versionCOPIAR CÓDIGO
```

E pressionando "Enter", conseguimos ver a versão do Java que estamos utilizando. Neste caso, é o Java 9, ou como outros a chamam, 1.9. Não há problema em utilizar a versão 1.8 para os propósitos deste curso.

Além disso, utilizaremos o software **Eclipse**. Não há nenhuma especificidade de versão, isso fica a critério do aluno. Abriremos no `workspace` padrão, que é criado automaticamente pelo programa.

Se você já fez os cursos de Java partes 1 e 2, provavelmente criou outros projetos Java. Abriremos o último, de nome `bytebank-encapsulado`.

> Para acompanhar, é possível fazer o download do projeto do curso anterior.
> 

Nele, há a classe `Cliente`, e a classe `Conta`.

Nesta última, como podemos observar, temos os atributos:

```
public class Conta {

    private double saldo;
    private int agencia;
    private int numero;
    private Cliente titular;
    private static int total = 0;

    //código continua...
COPIAR CÓDIGO
```

São privados, ou seja, ninguém fora da classe pode acessá-los. Em seguida, temos o construtor para inicializar, ou seja, criar o objeto:

```
//parte de cima do código omitida

public Conta(int agencia, int numero) {
    Conta.total++;
    System.out.println("O total de contas é " + Conta.total);
    this.agencia = agencia;
    this.numero = numero;
    this.saldo = 100;
    System.out.println("Estou criando uma conta  " + this.numero);

}COPIAR CÓDIGO
```

Abaixo, temos todos os métodos, como `deposita`, `saca` e `transfere`, além dos *getters* e *setters*. Por fim, temos o método da classe, que nos retorna o total das contas, com um atributo estático privado, o nome da classe:

```
//parte de cima do código omitida

public static int getTotal(){
    return Conta.total;
}COPIAR CÓDIGO
```

Além disso, associamos duas classes, `Conta` e `Cliente`, fazendo o que chamamos de **composição**, aprendemos o relacionamento entre classes, o que inclui a **herança**.

Ainda, foram feitos diversos testes, criando contas e passando parâmetros, realizando depósitos e saques, utilizando o `conta.`, chamando o método para poder fazer algo com o objeto. Utilizando o `set` para estabelecer dados que não foram determinados pelo construtor, e imprimindo-os acessando as informações por meio de *getters*.

Ao final, foi inserido o acesso do método estático, com o nome da classe `Conta` com o `C` maiúsculo, não confundir com a referência `conta` em `c` minúsculo.

Nossa classe `TestaContas`, contém portanto o seguinte código:

```
public class TesteContas {

    public static void main(String[] args) {

        Conta conta = new Conta(1337, 23334);

        conta.deposita(200.0);

        System.out.println(conta.getSaldo());

        conta.setAgencia(570);

        System.out.println(conta.getAgencia());

        System.out.println("o total de contas é : " + Conta.getTotal());

    }
}COPIAR CÓDIGO
```

Tentaremos executar, e obtivemos o seguinte resultado:

```
O total de contas é 1
Estou criando uma conta 23334
300.0
570
o total de contas é : 1
```

Ou seja, os dados foram impressos no console sem nenhum problema.

Nesta primeira parte do curso, não continuaremos a utilizar a classe `Conta`, criaremos um novo projeto e novas classes.

Temos diversas maneiras de criar um novo projeto, aqui, utilizaremos o clique com o botão direito do mouse dentro da área "Package Explorer", e selecionaremos a opção "New > Java Project".

Daremos continuidade à ideia do Bytebank, portanto o nome do nosso novo projeto será `bytebank-herdado`. Concluiremos a criação do projeto.

Ao clicarmos com o botão direito do mouse sobre o nome do novo projeto, e selecionarmos a opção "Close Unrelated Projects", fará com que o Eclipse feche todos os outros projetos que não tenham relação com este. Surgirá um *pop up* perguntando se temos certeza disso, e basta confirmarmos.

Assim, ele fecha os demais projetos e garante que as classes serão criadas nos lugares corretos, e que serão executados os devidos testes.

Inicialmente, não trabalharemos com a `Conta`, criaremos uma nova classe, e nossa tarefa é representar um funcionário em nosso sistema. Portanto, ela se chamará `Funcionario`.

Clicaremos com o botão direito do mouse sobre a pasta `src` e selecionar "New > Class". Na janela de diálogo, preencheremos o nome, e finalizaremos o processo clicando em "Finish".

> Este não é o único método para criação de classes, o Eclipse permite diversos outros.
> 

Inicialmente, temos este código:

```
public class Funcionario {

}
```

Precisamos pensar em quais atributos o funcionário tem. No caso, teremos o nome, que será uma `String` privada. Além disso, ele terá um `cpf`, que também será uma `String`, e um `salario`, que será do tipo `double`:

```
public class Funcionario {

    private String nome;
    private String cpf;
    private double salario;
}
```

É melhor termos o menor número possível de atributos, contendo o mínimo necessário, assim evitamos de ter elementos que não serão utilizados.

Inicialmente, o Eclipse sinalizará que estes três atributos que criamos não estão sendo utilizados, isso porque ainda não criamos os métodos de `get`e `set`.

Como se tratam de métodos recorrentes, o Eclipse facilita sua criação. Podemos selecionar "Source > Generate Getters e Setters..." e surgirá uma janela na qual podemos selecionar para quais atributos desejamos gerar os *getters* e *setters*.

Automaticamente, o próprio programa detecta `cpf`, `nome` e `salario`. Selecionaremos a *check box* referente a cada um deles, com visibilidade pública, e concluiremos o processo clicando em "Ok".

Assim, temos o seguinte código:

```
public class Funcionario {

        private String nome;
        private String cpf;
        private double salario;

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

Agora nosso chefe informou que todo funcionário recebe uma bonificação padrão, e que seu valor corresponde a 10% do salário. Precisamos portanto criar o método `salario`, com visibilidade pública, portanto, utilizaremos o **modificador** `public`.

O método devolverá a bonificação, que será um `double`, e se chamará `getBonificacao`. Em seu corpo, inseriremos o `return`, que nos retornará o valor do salário, `this.salario`, multiplicado por `0.1`:

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

Como podemos observar, utilizamos um *getter* em `getBonificacao` mesmo não tendo criado o atributo `bonificacao`. Não há problema em fazer isso, ou seja, podemos criar nossos próprios *getters* ainda que não haja um atributo relacionado.

No caso, o valor será calculado, nos dando um resultado para a bonificação.

Salvaremos nosso arquivo, utilizando o atalho "CTRL + S". Criaremos um teste para verificarmos se funcionou.

Clicaremos com o botão direito do mouse sobre nosso pacote, e selecionaremos "New > Class". Daremos à classe o nome `TesteFuncionario` e, no próprio *wizard* de criação, podemos observar que há uma pergunta, logo abaixo da caixa de interfaces, que diz "*Which method stubs would you like to create?*", ou seja, ele já nos dá a opção de gerar um método `main`, é o que faremos, clicando na primeira caixa, que diz `public static void main(String[] args)`.

Para concluir, clicaremos em "Finish".

Assim já temos uma classe e um método:

```
public class TesteFuncionario {

    public static void main(String[] args) {

    }
}COPIAR CÓDIGO
```

Em seguida, inseriremos nosso primeiro funcionário. Primeiro, temos que definir a referência à classe `Funcionario`, ao qual daremos o nome de `nico`:

```
public class TesteFuncionario {

    public static void main(String[] args) {

        Funcionario nico =

    }
}COPIAR CÓDIGO
```

Isto receberá um `new`, para criar o objeto, chamando o construtor `Funcionario`:

```
public class TesteFuncionario {

    public static void main(String[] args) {

        Funcionario nico = new Funcionario();

    }
}COPIAR CÓDIGO
```

Retornando à classe `Funcionario`, vemos que não foi criado nenhum construtor, faremos isso agora:

```
public class Funcionario {

    private String nome;
    private String cpf;
    private double salario;

    public Funcionario() {

    }

// Código continua embaixo...
COPIAR CÓDIGO
```

Ele sempre recebe o nome da classe, entretanto, diferente do método, não retorna nada. Temos `public` seguido direto pelo nome da classe, sem nenhum tipo de retorno definido, como `double`, por exemplo.

Mesmo sem termos criado este construtor, nosso código estava funcionando. Isso porque, se nenhum construtor for criado, o compilador insere *automaticamente* o construtor padrão.

O construtor padrão é aquele que não recebe nenhum parâmetro.

Trabalharemos novamente com a classe `TesteFuncionario`. Daremos um nome para este funcionário, utilizando o `setNome`, bem como um CPF, por meio do `setCpf`', e ainda, um salário, com o `setSalario`:

```
public class TesteFuncionario {

    public static void main(String[] args) {

        Funcionario nico = new Funcionario();
        nico.setNome("Nico Steppat");
        nico.setCpf("223355646-9");
        nico.setSalario(2600.00);

    }
}COPIAR CÓDIGO
```

Com isso, podemos imprimir algumas informações, utilizando os *getters*. Testaremos com o nome a bonificação:

```
public class TesteFuncionario {

    public static void main(String[] args) {

        Funcionario nico = new Funcionario();
        nico.setNome("Nico Steppat");
        nico.setCpf("223355646-9");
        nico.setSalario(2600.00);

        System.out.println(nico.getNome());
        System.out.println(nico.getBonificacao());

    }
}COPIAR CÓDIGO
```

Salvaremos e executaremos. Clicamos com o botão direito do mouse sobre a tela, e selecionaremos "Run As > Java Application". No console, é impresso:

```
Nico Steppat
260.0COPIAR CÓDIGO
```

Funcionou.

Todos os conceitos vistos nesta aula foram para revisão, nas próximas aulas adentraremos no conceito de herança, e quais problemas ela é capaz de solucionar.