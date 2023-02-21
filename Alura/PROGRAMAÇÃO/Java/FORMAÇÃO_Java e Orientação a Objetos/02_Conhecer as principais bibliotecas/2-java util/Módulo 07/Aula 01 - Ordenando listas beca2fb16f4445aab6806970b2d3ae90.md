# Aula 01 - Ordenando listas

> Você pode fazer o [DOWNLOAD](https://caelum-online-public.s3.amazonaws.com/850-java-util/07/java6-cap7.zip) do projeto da aula anterior.
> 

Dando continuidade à viagem pelo `java.util`, nesta aula, falaremos sobre os ***lambdas***.

No pacote `br.com.bytebank.banco.test.util`, criaremos uma nova classe, chamada `Teste`, com o seguinte código:

```
package br.com.bytebank.banco.test.util;

public class Teste {

        public static void main(String[] args) {

                Conta cc1 = new ContaCorrente(22, 33);
                cc1.deposita(333.0);

                Conta cc2 = new ContaPoupanca(22, 44);
                cc2.deposita(444.0);

                Conta cc3 = new ContaCorrente(22, 11);
                cc3.deposita(111.0);

                Conta cc4 = new ContaPoupanca(22, 22);
                cc4.deposita(222.0);

                List<Conta> lista = new ArrayList<>();
                lista.add(cc1);
                lista.add(cc2);
                lista.add(cc3);
                lista.add(cc4);

        }

}COPIAR CÓDIGO
```

Temos duas contas correntes, duas contas poupança, e um `ArrayList`, ao qual as estamos adicionando. O código ainda não está compilando pois ainda não fizemos os `import`s.

Podemos realizá-los automaticamente. Na barra de menu superior, na opção "Source", selecionaremos a opção "Organize Imports", podemos acessar esta opção também por meio do atalho "Shift + Command + O/Shift + Ctrl + O".

Surgirá uma caixa de diálogo, para selecionarmos a lista que desejamos utilizar, selecionaremos `java.util.List`. Temos o seguinte resultado:

```
package br.com.bytebank.banco.test.util;

import java.util.ArrayList;
import java.util.List;

import br.com.bytebank.banco.modelo.Conta;
import br.com.bytebank.banco.modelo.ContaCorrente;
import br.com.bytebank.banco.modelo.ContaPoupanca;

public class Teste {

        public static void main(String[] args) {

                Conta cc1 = new ContaCorrente(22, 33);
                cc1.deposita(333.0);

                Conta cc2 = new ContaPoupanca(22, 44);
                cc2.deposita(444.0);

                Conta cc3 = new ContaCorrente(22, 11);
                cc3.deposita(111.0);

                Conta cc4 = new ContaPoupanca(22, 22);
                cc4.deposita(222.0);

                List<Conta> lista = new ArrayList<>();
                lista.add(cc1);
                lista.add(cc2);
                lista.add(cc3);
                lista.add(cc4);

        }

}COPIAR CÓDIGO
```

Tudo está compilando.

Nosso objetivo agora será ordenar nossa lista. Temos diversas contas em nossa lista, e as ordenaremos de acordo com um determinado critério.

O algoritmo de ordenação do Java já está implementado, o desenvolvedor não precisa ter esta preocupação.

No nascimento do pacote `java.util` havia uma classe separada, destinada exclusivamente à função de ordenação. Entretanto, em versões mais recentes da linguagem, houve a implementação de um método específico, tendo em mente a orientação a objetos.

O método utilizado chama-se `sort()`, e exige um "*Comparator*", `c`. Ele representa o critério de ordenação, serve para comparar duas referências, por meio de um método presente na interface `Comparator`.

No mesmo arquivo `Teste.java`, criaremos uma nova classe, chamada`NaoSeiAinda`, que implementará a interface `Comparator`:

```
package br.com.bytebank.banco.test.util;

import java.util.ArrayList;
import java.util.List;

import br.com.bytebank.banco.modelo.Conta;
import br.com.bytebank.banco.modelo.ContaCorrente;
import br.com.bytebank.banco.modelo.ContaPoupanca;

public class Teste {

        public static void main(String[] args) {

                Conta cc1 = new ContaCorrente(22, 33);
                cc1.deposita(333.0);

                Conta cc2 = new ContaPoupanca(22, 44);
                cc2.deposita(444.0);

                Conta cc3 = new ContaCorrente(22, 11);
                cc3.deposita(111.0);

                Conta cc4 = new ContaPoupanca(22, 22);
                cc4.deposita(222.0);

                List<Conta> lista = new ArrayList<>();
                lista.add(cc1);
                lista.add(cc2);
                lista.add(cc3);
                lista.add(cc4);

        }

}

class NaoSeiAinda implements Comparator<>COPIAR CÓDIGO
```

Ela exige que seja definido seu tipo, no nosso caso, como queremos que ela compare contas, nosso tipo será `Conta`:

```
package br.com.bytebank.banco.test.util;

import java.util.ArrayList;
import java.util.List;

import br.com.bytebank.banco.modelo.Conta;
import br.com.bytebank.banco.modelo.ContaCorrente;
import br.com.bytebank.banco.modelo.ContaPoupanca;

public class Teste {

        public static void main(String[] args) {

                Conta cc1 = new ContaCorrente(22, 33);
                cc1.deposita(333.0);

                Conta cc2 = new ContaPoupanca(22, 44);
                cc2.deposita(444.0);

                Conta cc3 = new ContaCorrente(22, 11);
                cc3.deposita(111.0);

                Conta cc4 = new ContaPoupanca(22, 22);
                cc4.deposita(222.0);

                List<Conta> lista = new ArrayList<>();
                lista.add(cc1);
                lista.add(cc2);
                lista.add(cc3);
                lista.add(cc4);

        }

}

class NaoSeiAinda implements Comparator<Conta>COPIAR CÓDIGO
```

Precisamos importar a interface `Comparator`. Com o mouse sobre ela, o Eclipse mostrará algumas opções, dentre elas "Import `Comparator` (java.util)", clicaremos sobre ela, que é a primeira da lista. No começo do nosso código, onde estão listados todos os *imports*, já aparece este novo:

```
//Código omitido

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

//Código omitidoCOPIAR CÓDIGO
```

Contudo, a classe `NaoSeiAinda` não está compilando. Isso acontece porque ainda precisamos implementar o método `compare()`. Com a ajuda do Eclipse, clicaremos sobre o ícone de lâmpada, que aparece ao lado esquerdo da linha que não compila, e ela nos dará a opção "Add unimplemented methods". Temos assim a seguinte formulação automática, criada pelo Eclipse:

```
//Código omitido

public class Teste {

        public static void main(String[] args) {

        //Código omitido

        }

}

class NaoSeiAinda implements Comparator<Conta> {

        @Override
        public int compare(Conta arg0, Conta arg1) {
            // TODO Auto-generated method stub
            return 0;
        }
}COPIAR CÓDIGO
```

Como utilizamos o parâmetro `Conta` na interface `Comparator`, nosso método `compare()` trabalha com o mesmo, afinal, nosso objetivo é comparar duas contas.

Apenas para nossa didática, alteraremos o `arg0` e `arg1` para `c1` e `c2`.

O objetivo deste método é poder determinar quando que uma conta é maior, ou menor, do que outra - e qual o critério de avaliação. Quanto a este último, quem deve defini-lo somos nós, os desenvolvedores. Podemos, por exemplo, determinar que o saldo será o critério determinante, ou o titular, o número da agência, enfim, o que acharmos mais conveniente.

Definiremos o nosso critério de avaliação como o número das contas. Com isso, alteraremos o nome da classe para `NumeroDaContaComparator`:

```
//Código omitido

public class Teste {

        public static void main(String[] args) {

        //Código omitido

        }

}

class NumeroDaContaComparator implements Comparator<Conta> {

        @Override
        public int compare(Conta c1, Conta c2) {
            // TODO Auto-generated method stub
            return 0;
        }
}COPIAR CÓDIGO
```

O funcionamento do método `compare()` será similar ao do `equals()`. Teremos um retorno `0` somente se o número das contas forem idênticos, se o número da conta `c1` for inferior ao da `c2`, nosso retorno será um valor negativo, aleatório, pode ser por exemplo `-345`:

```
//Código omitido

public class Teste {

        public static void main(String[] args) {

        //Código omitido

        }

}

class NumeroDaContaComparator implements Comparator<Conta> {

        @Override
        public int compare(Conta c1, Conta c2) {

                if(c1.getNumero() < c2.getNumero()) {
                    return -345;
                }

            return 0;
        }
}COPIAR CÓDIGO
```

Evidentemente que, se `c1` é maior que `c2`, então devemos ter um resultado positivo. Assim, criaremos um segundo `if` que reflita esta regra:

```
//Código omitido

public class Teste {

        public static void main(String[] args) {

        //Código omitido

        }

}

class NumeroDaContaComparator implements Comparator<Conta> {

        @Override
        public int compare(Conta c1, Conta c2) {

                if(c1.getNumero() < c2.getNumero()) {
                    return -1;
                }

                if(c1.getNumero() > c2.getNumero()) {
                    return 1;
                }

            return 0;
        }
}COPIAR CÓDIGO
```

Apenas por motivos de organização, alteramos os valores dos retornos para `-1` e `1`, respectivamente. As regras do método `compare()` podem ser encontradas na documentação Java, mas podemos ver os detalhes pertinentes à ele, com o cursor posicionado sobre seu nome.

Com isso, finalizamos a construção de nossa classe. Notamos que encapsula a execução de um método somente, isso é pouco usual e causa estranheza - adiante falaremos mais sobre isto.

Nosso próximo passo será criar uma instância da classe `NumeroDaContaComparator`, para isso, criaremos um objeto desta classe:

```
//Código omitido

public class Teste {

        public static void main(String[] args) {

        //Código omitido

        List<Conta> lista = new ArrayList<>();
        lista.add(cc1);
        lista.add(cc2);
        lista.add(cc3);
        lista.add(cc4);

        NumeroDaContaComparator comparator = new NumeroDaContaComparator();

        lista.sort(c);

        }

}

class NumeroDaContaComparator implements Comparator<Conta> {

        @Override
        public int compare(Conta c1, Conta c2) {

                if(c1.getNumero() < c2.getNumero()) {
                    return -1;
                }

                if(c1.getNumero() > c2.getNumero()) {
                    return 1;
                }

            return 0;
        }
}COPIAR CÓDIGO
```

Lembrando que, se não definirmos nenhum construtor para a classe, é utilizado o construtor padrão. Uma vez instanciada, podemos inseri-la no método `sort()`:

```
//Código omitido

public class Teste {

        public static void main(String[] args) {

        //Código omitido

        List<Conta> lista = new ArrayList<>();
        lista.add(cc1);
        lista.add(cc2);
        lista.add(cc3);
        lista.add(cc4);

        NumeroDaContaComparator comparator = new NumeroDaContaComparator();

        lista.sort(comparator);

        }

}

class NumeroDaContaComparator implements Comparator<Conta> {

        @Override
        public int compare(Conta c1, Conta c2) {

                if(c1.getNumero() < c2.getNumero()) {
                    return -1;
                }

                if(c1.getNumero() > c2.getNumero()) {
                    return 1;
                }

            return 0;
        }
}COPIAR CÓDIGO
```

O código agora compila, e com isso, estamos ordenando nossa lista, com base em nosso critério - que é a numeração das contas.

Em seguida, testaremos nosso código. Para isso, criaremos dois laços, um antes e outro depois da comparação. Ao digitarmos `foreach` e utilizarmos o atalho "Ctrl + Espaço", o Eclipse gera o código automaticamente:

```
//Código omitido

public class Teste {

        public static void main(String[] args) {

        //Código omitido

        List<Conta> lista = new ArrayList<>();
        lista.add(cc1);
        lista.add(cc2);
        lista.add(cc3);
        lista.add(cc4);

        foreach (Conta conta : lista) {

        }

        NumeroDaContaComparator comparator = new NumeroDaContaComparator();

        lista.sort(comparator);

        }

}

class NumeroDaContaComparator implements Comparator<Conta> {

        @Override
        public int compare(Conta c1, Conta c2) {

                if(c1.getNumero() < c2.getNumero()) {
                    return -1;
                }

                if(c1.getNumero() > c2.getNumero()) {
                    return 1;
                }

            return 0;
        }
}COPIAR CÓDIGO
```

Faremos com que, a cada iteração, seja impressa a `conta`:

```
//Código omitido

public class Teste {

        public static void main(String[] args) {

        //Código omitido

        List<Conta> lista = new ArrayList<>();
        lista.add(cc1);
        lista.add(cc2);
        lista.add(cc3);
        lista.add(cc4);

        foreach (Conta conta : lista) {
            System.out.println(conta);
        }

        NumeroDaContaComparator comparator = new NumeroDaContaComparator();

        lista.sort(comparator);

        }

}

class NumeroDaContaComparator implements Comparator<Conta> {

        @Override
        public int compare(Conta c1, Conta c2) {

                if(c1.getNumero() < c2.getNumero()) {
                    return -1;
                }

                if(c1.getNumero() > c2.getNumero()) {
                    return 1;
                }

            return 0;
        }
}COPIAR CÓDIGO
```

A seguir, faremos um segundo laço, após a comparação:

```
//Código omitido

public class Teste {

        public static void main(String[] args) {

        //Código omitido

        List<Conta> lista = new ArrayList<>();
        lista.add(cc1);
        lista.add(cc2);
        lista.add(cc3);
        lista.add(cc4);

        foreach (Conta conta : lista) {
            System.out.println(conta);
        }

        NumeroDaContaComparator comparator = new NumeroDaContaComparator();

        System.out.println("---------");

        lista.sort(comparator);

        for (Conta conta : lista) {
            System.out.println(conta);
        }

    }

}

class NumeroDaContaComparator implements Comparator<Conta> {

        @Override
        public int compare(Conta c1, Conta c2) {

                if(c1.getNumero() < c2.getNumero()) {
                    return -1;
                }

                if(c1.getNumero() > c2.getNumero()) {
                    return 1;
                }

            return 0;
        }
}COPIAR CÓDIGO
```

Com isso temos, em ordem, a criação das contas, a criação da lista e o comparador. Estamos prontos para testar nossa classe. Executaremos e temos o seguinte resultado no console:

```
ContaCorrente, Numero: 33, Agencia: 22
ContaPoupanca, Numero: 44, Agencia: 22
ContaCorrente, Numero: 11, Agencia: 22
ContaPoupanca, Numero: 22, Agencia: 22
---------
ContaCorrente, Numero: 11, Agencia: 22
ContaPoupanca, Numero: 22, Agencia: 22
ContaCorrente, Numero: 33, Agencia: 22
ContaPoupanca, Numero: 44, Agencia: 22COPIAR CÓDIGO
```

Temos assim os dois resultados apresentados corretamente, primeiro antes da comparação e, em seguida, após a comparação. Como podemos ver, na segunda lista, as contas estão ordenadas de menor para o maior número de conta.

Assim como definimos o critério de numeração, outras classes poderiam ser criadas, com outros critérios de ordenação. Adiante, veremos como ordenar pelo titular, e como as coisas funcionavam antes da existência do método `sort()`, que surgiu na versão Java 8. Até a próxima!

**[DISCUTIR NO FORUM](https://cursos.alura.com.br/forum/curso-java-util-lambdas/exercicio-ordenando-listas/37830/novo)[PRÓ](https://cursos.alura.com.br/course/java-util-lambdas/task/37830/next)**