# Aula 04 - String e a imutabilidade

O foco dessa aula será o pacote `java.lang`.

Começaremos com, talvez, a classe mais importante de todas: a `String`. Quanto mais conhecermos esta classe, mais fácil será o seu dia a dia enquanto desenvolvedor, pois trata-se de uma classe fundamental no desenvolvimento de projetos.

Criaremos uma classe para testarmos a `String`; o nome dessa classe será `TesteString`.

Nesta nova classe, criaremos uma `String` e definiremos seu nome como `Alura`

```
package br.com.bytebank.banco.test;

public class TesteString {

    public static void main(String[] args) {

        String nome = "Alura";
    }
}
COPIAR CÓDIGO
```

Até este ponto não há nada de novo; temos a classe `String` que pertence ao pacote `java.lang`, e `nome` é uma referência.

Ao observarmos a classe `TesteContas` veremos que `cc` é uma referência, `ContaCorrente` é uma classe que representa um tipo, e ao lado direito temos o objeto.

```
public static void main(String[] args) throws SaldoInsuficienteException{

    ContaCorrente cc = new ContaCorrente(111, 111);
    cc.deposita(100.0);
COPIAR CÓDIGO
```

Ou seja, em `TesteString` também estamos criando um objeto, `String`s também são objetos. No entanto, não é preciso utilizar o `new` para criar este objeto. Isso ocorre para facilitar a vida do desenvolvedor, não precisamos utilizar o `new` todas as vezes que formos trabalhar com Strings, mas nada impede que você o faça. Portanto, as duas formas são funcionais, embora o segundo caso seja considerado uma má prática. A partir da primeira forma a máquina virtual consegue executar algumas otimizações, o que é impossível no segundo caso.

```
String nome = "Alura";
String outro = new String("Alura");
COPIAR CÓDIGO
```

Chamamos essa sintaxe de **objeto literal**. Na sintaxe não há diferença entre inicializar um inteiro(`int`) e uma String. `nome` é uma referência, então nada nos impede de executar métodos em cima dela. Ao escrevermos no Eclipse `nome` veremos diversas sugestões de métodos, vale a pena estudar isso com calma, pois isso facilitará muito o seu dia a dia. A melhor forma de estudar é experimentando os métodos, testando e conversando com outras pessoas, mas claro, existe uma forma mais oficial e tradicional de se realizar este estudo.

Nas aulas anteriores criamos um `Javadoc` para nosso projeto, da mesma forma os desenvolvedores oficiais do Java fizeram uma documentação que nos auxiliará nos estudos.

Procuraremos a documentação oficial do Java 9, muito embora você possa utilizar a da versão 8 ou 7, já que a classe String se modificou muito pouco. Veremos que a estética da documentação é idêntica ao `Javadoc` gerado por nós. Estamos analisando especificamente a [documentação](https://docs.oracle.com/javase/9/docs/api/java/lang/String.html/) sobre a String.

![https://s3.amazonaws.com/caelum-online-public/843-java-packages/03/4_2_32_documetacao+oficial+java.png](https://s3.amazonaws.com/caelum-online-public/843-java-packages/03/4_2_32_documetacao+oficial+java.png)

Encontraremos muitas explicações a respeito da classe e uma detalhada lista sobre seus construtores e métodos, como por exemplo, o `replace()`, que faremos muito uso. Caso você tenha alguma dúvida acerca do funcionamento dos métodos, vale a pena consultar a documentação oficial Java.

Voltemos a classe `TesteString`.

Testaremos o recém citado `replace()`, existem duas versões para este método e veremos suas diferenças. A ideia é substituir `"A"` por `"a"`, ao final, faremos um `System.out` para imprimirmos `nome`.

```
package br.com.bytebank.banco.test;

public class TesteString {

    public static void main(String[] args) {

        String nome = "Alura";

        nome.replace("A", "a");

        System.out.println(nome);
    }
}
COPIAR CÓDIGO
```

Ao executarmos o código veremos que o `replace()` não foi bem sucedido, afinal o resultado impresso continua sendo `Alura`, com "A" maiúsculo. Faremos um outro teste lançando uso sobre o método `toLowerCase()`, que basicamente substitui todas as letras por minúsculas.

```
package br.com.bytebank.banco.test;

public class TesteString {

    public static void main(String[] args) {

        String nome = "Alura";

        nome.replace("A", "a");

        nome.toLowerCase();

        System.out.println(nome);
    }
}
COPIAR CÓDIGO
```

Mais uma vez o resultado impresso continua sendo `Alura`.

Conheceremos um conceito fundamental da `String`: uma vez que foi criada, ela não poderá ser modificada posteriormente. Chamamos o conceito de um objeto não poder ser alterado de **imutabilidade**. Caso você queira alterar algo em uma `String`, você terá de criar uma `String` que refletirá uma nova ação, ou seja, teremos dois objetos, como duas "Aluras", sendo uma com "A" e outra com "a".

Ao consultarmos a documentação oficial, veremos que o `replace()` retorna uma String.

```
public String replace(char oldChar, char newChar)
COPIAR CÓDIGO
```

Se quisermos imprimir `alura`, deveremos criar uma `String` que chamaremos de `outra`, e que apontará para o objeto de nosso interesse.

```
package br.com.bytebank.banco.test;

public class TesteString {

    public static void main(String[] args) {

        String nome = "Alura";

        String outra = nome.replace("A", "a");

        System.out.println(outra);
    }
}
COPIAR CÓDIGO
```

Com isso, temos o resultado impresso de `alura`.

Na verdade, temos duas `String` na memória, sendo uma `nome` que aponta para o objeto `Alura` e a `String` `outra` que aponta para um novo objeto, no caso, `alura`.

Todos os métodos funcionam nessa linha: devolvem uma nova `String`, respeitando o conceito de imutabilidade. Esse é um conceito importante e algumas classes do nosso projeto seguem essa ideia.

Nem todas classes são imutáveis, a nossa classe `Conta` não é imutável, afinal a ideia de uma conta é necessariamente dinâmica, o saldo de uma conta está sempre em movimento e transformação.