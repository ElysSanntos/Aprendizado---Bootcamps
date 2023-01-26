# Aula 04 - Usando a classe Object

Nesta aula daremos continuidade aos nossos estudos em `java.lang`.

Estudamos juntos a classe `String`, fizemos uma revisão e análise da linha de código `System.out.println()`, e agora veremos uma classe fundamental.

No Eclipse, criaremos uma nova classe que chamaremos simplesmente de `Teste`. Nesta nova classe faremos o `System`.

```
package br.com.bytebank.banco.test;

public class Teste {

    public static void main(String[] args) {

        System.out.println();

    }

}
COPIAR CÓDIGO
```

Reparem que o código é compilado ainda que não tenhamos passado nenhum parâmetro para `println()`, mas podemos escrever uma `String`, inteiro ou um valor booleano.

```
package br.com.bytebank.banco.test;

public class Teste {

    public static void main(String[] args) {

        System.out.println("x");
        System.out.println(3);
        System.out.println(false);

    }

}
COPIAR CÓDIGO
```

Estamos nos deparando com várias versões do mesmo método. Para simular essa ideia, usaremos métodos `println()`. Na classe que implementou o `println()` existe um método com essa assinatura, mas veremos como se dá sua implementação.

```
package br.com.bytebank.banco.test;

public class Teste {

    public static void main(String[] args) {

        System.out.println("x");
        System.out.println(3);
        System.out.println(false);

        println();
    }

    static void println() {
    }

    static void println(int a) {
    }

    static void println(boolean valor) {
    }

}

COPIAR CÓDIGO
```

Dentro da classe que representa o `out`, existem no mínimo estas três versões do método `println()`, ou seja, são vários métodos com o mesmo nome e assinatura, apenas variando os parâmetros. Isso se chama **sobrecarga**, lembrem-se de não confundir com **sobrescrita**, que é relacionada à herança e sempre mantém os mesmos parâmetros.

Criaremos uma `ContaCorrente` e uma `ContaPoupanca` com os respectivos números de conta e agência.

```
package br.com.bytebank.banco.test;

public class Teste {

    public static void main(String[] args) {

        System.out.println("x");
        System.out.println(3);
        System.out.println(false);

        ContaCorrente cc = new ContaCorrente(22, 33);
        ContaPoupanca cp = new ContaPoupanca(33, 22);

        println();
    }

```

Queremos que o `System.out.println()` funcione com `cc` e `cp`. De forma mais clara, a ideia é:

```
System.out.println(cc);
System.out.println(cp);

```

Como podemos implementar isso? Teremos de adicionar mais uma versão do método: `println(ContaCorrente conta)`. Feito isso, acionamos o método `println()` passando para ele `cc`. Tudo deve funcionar perfeitamente, pois o método que recebe `ContaCorrente` foi implementado mais abaixo do código.

```
package br.com.bytebank.banco.test;

public class Teste {

  public static void main(String[] args) {

    System.out.println("x");
    System.out.println(3);
    System.out.println(false);

    ContaCorrente cc = new ContaCorrente(22, 33);
        ContaPoupanca cp = new ContaPoupanca(33, 22);

        System.out.println(cc);
        System.out.println(cp);

        println(cc);

    }

    static void println() {
    }

    static void println(int a) {
    }

    static void println(boolean valor) {
    }

    static void println(ContaCorrente conta) {
    }

}

```

A próxima questão é: dentro de `System.out`, ou seja, a classe que foi associada ao atributo `out`, existe o método `println()` que recebe `ContaCorrente`? Não há! Mas mesmo assim funciona, podemos passar para o `println()` qualquer tipo de referência. Como isso funciona?

Primeiramente, vamos remover o espaços do nosso código e estudar essa questão mais de perto.

```
        System.out.println(cc);
        System.out.println(cp);

        println(cc);

    }

    static void println() {}
    static void println(int a) {}
    static void println(boolean valor) {}

    static void println(ContaCorrente conta) {
    }

}

```

Caso alteremos `ConcaCorrente` para `ContaPoupanca` na última linha do código, não dará certo, pois o `println()` mais acima continua recebendo `cc` e não `cp`.

```
        System.out.println(cc);
        System.out.println(cp);

        println(cc);

    }

    static void println() {}
    static void println(int a) {}
    static void println(boolean valor) {}

    static void println(ContaPoupanca conta) {
    }

}

```

No entanto, reparem que `ConcaPoupanca` e `ContaCorrente` têm algo em comum: ambas são contas. Portanto podemos escrever o código adicionando simplesmente `Conta` e realizando sua importação.

```
import br.com.bytebank.banco.modelo.Conta;
import br.com.bytebank.banco.modelo.ContaCorrente;
import br.com.bytebank.banco.modelo.ContaPoupanca;

public class Teste {

  public static void main(String[] args) {

    System.out.println("x");
    System.out.println(3);
    System.out.println(false);

    ContaCorrente cc = new ContaCorrente(22, 33);
        ContaPoupanca cp = new ContaPoupanca(33, 22);

    System.out.println(cc);
    System.out.println(cp);

    println(cc);

  }
•
  static void println() {}
  static void println(int a) {}
  static void println(boolean valor) {}

  static void println(Conta conta) {
  }
•
}
•

```

Escrevendo o código desta maneira, o `println()` se torna mais genérico, aceitando tanto `cc` quanto `cp`. Caso queiramos um tipo mais genérico e uma referência qualquer, como isso seria feito?

```
//Código omitido

    println(cc);

  }
•
  static void println() {}
  static void println(int a) {}
  static void println(boolean valor) {}

  static void println(???? referencia) {
  }

}

```

Falamos bastante sobre herança em outro curso, e criamos a hierarquia com base em `Conta`, `Funcionario` e `Cliente`.

Queremos fazer uma classe mãe que é estendida por todas essas classes que estão no primeiro nível; lembre-se que em Java só podemos estender uma classe.

O nome da nossa classe mãe será `Object`, e ela estará no topo da hierarquia.

![https://s3.amazonaws.com/caelum-online-public/843-java-packages/05/5_2_33_heranca.png](https://s3.amazonaws.com/caelum-online-public/843-java-packages/05/5_2_33_heranca.png)

Porém, ao abrirmos a casse `Conta` ou `Cliente`, veremos que não existe `extends Object`, mas se você realiza essa extensão, o computador automaticamente preenche o código.

```
public class Cliente extends Object {

    private String nome;
    private String cpf;
    private Sstring profissao;

    public String getNome() {
        return nome;
    }
Temos a classe `Object` no topo da hierarquia, isso significa que também são herdados métodos dessa classe, ou seja, reutilização. Lembrem-se que herança possui duas características: reutilização de código e polimorfismo.
```

Na classe `Teste` estávamos justamente analisando o polimorfismo. Qual o tipo de referência genérica que podemos incluir em nosso código?

```
//Código omitido

    println(cc);

  }
•
  static void println() {}
  static void println(int a) {}
  static void println(boolean valor) {}

  static void println(???? referencia) {
  }

}

```

Adicionaremos, justamente, `Object`, que funcionará com `ContaCorrente` e `ContaPoupanca`. Adicionaremos,`Cliente`, realizando sua devida importação, dessa forma, `prinln()` funcionará inclusive com esta classe.

```
//Código omitido

    ContaCorrente cc = new ContaCorrente(22, 33);
    ContaPoupanca cp = new ContaPoupanca(33, 22);
    Cliente cliente = new Cliente();

    println(cliente);

  }
•
  static void println() {}
  static void println(int a) {}
  static void println(boolean valor) {}

  static void println(Object referencia) {
  }

}

```

Com "Ctrl" pressionado, passaremos o cursor do mouse sobre o método `println()` para acessá-lo. Dentro do método encontraremos alguns elementos que não são familiares, mas se atentem para o tipo de referência que o método recebe: `Object`, por isso ele funciona com qualquer referência, afinal, tudo é um objeto.

```
//Código omitido

public void println(Object x) {
    String s = String.valueOff(x);
    synchronized (this) {
        print(s);
        newLine();
    }
}
COPIAR CÓDIGO
```

Para ilustrarmos melhor essa ideia, podemos expressar nosso código de `Teste` da seguinte maneira: substituindo `ContaCorrente`, `ContaPoupanca` e `Cliente` por `Object`.

```
//Código omitido

public static void main(String[] args} {

    System.out.println("x");
    System.out.println(3);
    System.out.println(false);

    Object cc = new ContaCorrente(22, 33);
    Object cp =new ContaPoupanca(33, 22);
    Object = new Cliente();

    System.out.println(cc);
    System.out.println();

    println(cliente);

}
```

Esse é um bom exemplo de polimorfismo, temos uma referência genérica que se liga a um objeto mais específico. Podemos utilizar tanto a referência mais específica quanto a mais genérica para designar `ContaCorrete`, `ContaPoupanca` e `Cliente`.

Comentaremos a linha de código referente ao `println(cliente)` e executaremos o código.

```
//Código omitido

public static void main(String[] args} {

    System.out.println("x");
    System.out.println(3);
    System.out.println(false);

    Object cc = new ContaCorrente(22, 33);
    Object cp = new ContaPoupanca(33, 22);
    Object = new Cliente();

    System.out.println(cc);
    System.out.println();

    //println(cliente);

}
```

Observem o que foi impresso:

```
x
3
br.com.bytebank.banco.modelo.ContaCorrente@3abfe836
br.com.bytebank.banco.modelo.ContaPoupanca@2ff5659e

```

O que nos interessa são as últimas duas linhas, que estão relacionadas aos dois `System.out.println()` encontrados em nosso código de `Testes`.

Observem que foi impresso o nome da classe em seu *full qualified name*, mais `@3abfe836`. De onde vem esse código e quem o implementou? A classe `Object`; essa classe possui alguma funcionalidade que resulta na produção dessa String.

Essa funcionalidade é um método, afinal, dentro da funcionalidade existe um método encapsulado. Esse método é chamado `toString()`, e ele foi herdado de `Object`.

Observem: Caso digitemos o ponto (`.`) em `System.out.println(cc)` serão sugeridos pelo Eclipse todos os métodos implementados na classe `Object`, afinal estamos trabalhando com essa referência genérica em nosso código.

```
//Código omitido

public static void main(String[] args} {

    System.out.println("x");
    System.out.println(3);
    System.out.println(false);

    Object cc = new ContaCorrente(22, 33);
    Object cp = new ContaPoupanca(33, 22);
    Object = new Cliente();

    System.out.println(cc.);
    System.out.println();

```

No entanto, se modificarmos o código trabalhando novamente com referências mais específicas, substituindo `Object` por `ContaCorrente`, veremos as sugestões de métodos que foram implementados na classe `ContaCorrente`, `Conta` e o método `ToString()` da classe `Object`, por isso conseguimos evoca-lo.

```
//Código omitido

public static void main(String[] args} {

    System.out.println("x");
    System.out.println(3);
    System.out.println(false);

    ContaCorrente cc = new ContaCorrente(22, 33);
    Object cp = new ContaPoupanca(33, 22);
    Object = new Cliente();

    System.out.println(cc.toString());
    System.out.println();

```

Ao executarmos nosso código, obteremos a mesmo saída, apenas a numeração se modifica, já que está relacionada ao endereço do objeto e não temos muito controle sobre isso.

```
br.com.bytebank.banco.modelo.ContaCorrente@3abfe836Caso observemos o método `toString()` utilizando o botão "Ctrl", veremos o seguinte código:
```

```
//Código omitido

public String toString() {
    return getClass().getName() + "@" + Integer.toHexString(hashCode());

}
//Código omitido
COPIAR CÓDIGO
```

Nesta aula, vimos exemplos de **polimorfismo** e **reutilização de código**.