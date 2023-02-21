# Aula 03 - A ordem natural

Olá! Nesta aula, dando continuidade ao assunto de ordenação das listas, falaremos sobre a **ordem natural**.

Primeiro, melhoraremos alguns aspectos em nosso código. Primeiro, como podemos simplificar o método `compare()`, da `NumeroDaContaComparator`?

```
//Código omitido

public class Teste {

//Código omitido

        for (Conta conta : lista) {
                System.out.println(conta);
        }

        NumeroDaContaComparator comparator = new NumeroDaContaComparator();
        TitularDaContaComparator titularComparator = new TitularDaContaComparator();
        lista.sort(titularComparator);

        System.out.println("---------");

        for (Conta conta : lista) {
                System.out.println(conta + ", " + conta.getTitular().getNome());
        }

}

class TitularDaContaComparator implements Comparator<Conta> {

        @Override
        public int compare(Conta c1, Conta c2) {

                String nomeC1 = c1.getTitular().getNome();
                String nomeC2 = c2.getTitular().getNome();
                return nomeC1.compareTo(nomeC2);
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

Na regra, temos um retorno negativo caso o valor da conta `c1`seja inferior ao da `c2`, e positivo se `c1` for maior que `c2`. Caso sejam iguais, o retorno é `0`. Entretanto, se escrevermos da seguinte forma:

```
//Apenas para exemplificar, ainda não foi inserido no código

return c1.getNumero() - c2.getNumero();COPIAR CÓDIGO
```

Chegamos ao mesmo resultado. Assim, comentaremos a escrita atual, e a substituiremos por esta nova:

```
//Código omitido

public class Teste {

//Código omitido

        for (Conta conta : lista) {
                System.out.println(conta);
        }

        NumeroDaContaComparator comparator = new NumeroDaContaComparator();
        TitularDaContaComparator titularComparator = new TitularDaContaComparator();
        lista.sort(titularComparator);

        System.out.println("---------");

        for (Conta conta : lista) {
                System.out.println(conta + ", " + conta.getTitular().getNome());
        }

}

class TitularDaContaComparator implements Comparator<Conta> {

        @Override
        public int compare(Conta c1, Conta c2) {

                String nomeC1 = c1.getTitular().getNome();
                String nomeC2 = c2.getTitular().getNome();
                return nomeC1.compareTo(nomeC2);
        }
}

class NumeroDaContaComparator implements Comparator<Conta> {

        @Override
        public int compare(Conta c1, Conta c2) {

            return c1.getNumero() - c2.getNumero();

//                if(c1.getNumero() < c2.getNumero()) {
//                    return -1;
//                }
//
//                if(c1.getNumero() > c2.getNumero()) {
//                    return 1;
//                }
//
//            return 0;
        }
}COPIAR CÓDIGO
```

A regra permanece a mesma, apenas alteramos o modo de escrevê-la. Sempre que tivermos um critério baseado em dados numéricos, é possível simplifica-lo.

Há ainda outra forma de escrevermos esta mesma regra. Assim como a `String`, o `Integer` também tem implementado um método de comparação, assim, poderíamos escrever o seguinte - comentando também a última linha de código que inserimos:

```
//Código omitido

public class Teste {

//Código omitido

        for (Conta conta : lista) {
                System.out.println(conta);
        }

        NumeroDaContaComparator comparator = new NumeroDaContaComparator();
        TitularDaContaComparator titularComparator = new TitularDaContaComparator();
        lista.sort(titularComparator);

        System.out.println("---------");

        for (Conta conta : lista) {
                System.out.println(conta + ", " + conta.getTitular().getNome());
        }

}

class TitularDaContaComparator implements Comparator<Conta> {

        @Override
        public int compare(Conta c1, Conta c2) {

                String nomeC1 = c1.getTitular().getNome();
                String nomeC2 = c2.getTitular().getNome();
                return nomeC1.compareTo(nomeC2);
        }
}

class NumeroDaContaComparator implements Comparator<Conta> {

        @Override
        public int compare(Conta c1, Conta c2) {

                            return Integer.compare(c1.getNumero(), c2.getNumero());

//                        return c1.getNumero() - c2.getNumero();
//
//                if(c1.getNumero() < c2.getNumero()) {
//                    return -1;
//                }
//
//                if(c1.getNumero() > c2.getNumero()) {
//                    return 1;
//                }
//
//            return 0;
        }
}COPIAR CÓDIGO
```

Tudo continua funcionando normalmente, pois a regra não foi alterada.

Outro ponto que alteraremos é a implementação dos comparadores na classe `Conta`, geralmente, ela não é feita desta forma.

Percebemos que a referência de cada um dos comparadores é utilizada somente para o método `sort()`, sendo assim, é comum que o construtor `new` seja inserido diretamente como parâmetro deste método:

```
//Código omitido

public class Teste {

//Código omitido

        for (Conta conta : lista) {
                System.out.println(conta);
        }

        NumeroDaContaComparator comparator = new NumeroDaContaComparator();
        TitularDaContaComparator titularComparator = new TitularDaContaComparator();
        lista.sort(new TitularDaContaComparator());

        System.out.println("---------");

        for (Conta conta : lista) {
                System.out.println(conta + ", " + conta.getTitular().getNome());
        }

}

class TitularDaContaComparator implements Comparator<Conta> {

        @Override
        public int compare(Conta c1, Conta c2) {

                String nomeC1 = c1.getTitular().getNome();
                String nomeC2 = c2.getTitular().getNome();
                return nomeC1.compareTo(nomeC2);
        }
}

class NumeroDaContaComparator implements Comparator<Conta> {

        @Override
        public int compare(Conta c1, Conta c2) {

                            return Integer.compare(c1.getNumero(), c2.getNumero());

//                        return c1.getNumero() - c2.getNumero();
//
//                if(c1.getNumero() < c2.getNumero()) {
//                    return -1;
//                }
//
//                if(c1.getNumero() > c2.getNumero()) {
//                    return 1;
//                }
//
//            return 0;
        }
}COPIAR CÓDIGO
```

Isso acaba com a necessidade da criação da referência, e a linha pode ser apagada. Quanto à linha do primeiro `comparator`, a manteremos em comentários:

```
//Código omitido

public class Teste {

//Código omitido

        for (Conta conta : lista) {
                System.out.println(conta);
        }

//        NumeroDaContaComparator comparator = new NumeroDaContaComparator();
        lista.sort(new TitularDaContaComparator());

        System.out.println("---------");

        for (Conta conta : lista) {
                System.out.println(conta + ", " + conta.getTitular().getNome());
        }

}

class TitularDaContaComparator implements Comparator<Conta> {

        @Override
        public int compare(Conta c1, Conta c2) {

                String nomeC1 = c1.getTitular().getNome();
                String nomeC2 = c2.getTitular().getNome();
                return nomeC1.compareTo(nomeC2);
        }
}

class NumeroDaContaComparator implements Comparator<Conta> {

        @Override
        public int compare(Conta c1, Conta c2) {

                            return Integer.compare(c1.getNumero(), c2.getNumero());

//                        return c1.getNumero() - c2.getNumero();
//
//                if(c1.getNumero() < c2.getNumero()) {
//                    return -1;
//                }
//
//                if(c1.getNumero() > c2.getNumero()) {
//                    return 1;
//                }
//
//            return 0;
        }
}COPIAR CÓDIGO
```

Como havia mencionado, o método `sort()` foi incluído apenas no Java 8, ou seja, antes, a ordenação era possível graças à classe `Collections`. Ao digitarmos seu nome em nosso código - logo abaixo do método `sort()`, temos a opção de importá-la, é o que faremos.

Trata-se de uma classe "fachada", que possui uma série de métodos estáticos auxiliares, e que portanto não são orientados a objetos. Por exemplo, ela inclui o método `sort()`. Aqui, o utilizaremos na sua versão que exige como parâmetro um `list` e um `comparator`:

```
//Código omitido

public class Teste {

//Código omitido

        for (Conta conta : lista) {
                System.out.println(conta);
        }

//        NumeroDaContaComparator comparator = new NumeroDaContaComparator();
        lista.sort(new TitularDaContaComparator());

                Collections.sort(list, c);

        System.out.println("---------");

        for (Conta conta : lista) {
                System.out.println(conta + ", " + conta.getTitular().getNome());
        }

}

class TitularDaContaComparator implements Comparator<Conta> {

        @Override
        public int compare(Conta c1, Conta c2) {

                String nomeC1 = c1.getTitular().getNome();
                String nomeC2 = c2.getTitular().getNome();
                return nomeC1.compareTo(nomeC2);
        }
}

class NumeroDaContaComparator implements Comparator<Conta> {

        @Override
        public int compare(Conta c1, Conta c2) {

                            return Integer.compare(c1.getNumero(), c2.getNumero());

//                        return c1.getNumero() - c2.getNumero();
//
//                if(c1.getNumero() < c2.getNumero()) {
//                    return -1;
//                }
//
//                if(c1.getNumero() > c2.getNumero()) {
//                    return 1;
//                }
//
//            return 0;
        }
}COPIAR CÓDIGO
```

Em seguida, preencheremos os parâmetros de acordo com a nossa realidade, ou seja, passando a nossa `lista`, e o nosso `comparator`, que é o `new NumeroDaContaComparator()`:

```
//Código omitido

public class Teste {

//Código omitido

        for (Conta conta : lista) {
                System.out.println(conta);
        }

//        NumeroDaContaComparator comparator = new NumeroDaContaComparator();
        lista.sort(new TitularDaContaComparator());

                Collections.sort(lista, new NumeroDaContaComparator());

        System.out.println("---------");

        for (Conta conta : lista) {
                System.out.println(conta + ", " + conta.getTitular().getNome());
        }

}

class TitularDaContaComparator implements Comparator<Conta> {

        @Override
        public int compare(Conta c1, Conta c2) {

                String nomeC1 = c1.getTitular().getNome();
                String nomeC2 = c2.getTitular().getNome();
                return nomeC1.compareTo(nomeC2);
        }
}

class NumeroDaContaComparator implements Comparator<Conta> {

        @Override
        public int compare(Conta c1, Conta c2) {

                            return Integer.compare(c1.getNumero(), c2.getNumero());

//                        return c1.getNumero() - c2.getNumero();
//
//                if(c1.getNumero() < c2.getNumero()) {
//                    return -1;
//                }
//
//                if(c1.getNumero() > c2.getNumero()) {
//                    return 1;
//                }
//
//            return 0;
        }
}COPIAR CÓDIGO
```

Executaremos a classe, para testarmos se agora é possível visualizarmos a lista ordenada de acordo com a numeração das contas. Temos o seguinte resultado no console:

```
ContaCorrente, Numero: 33, Agencia: 22
ContaPoupanca, Numero: 44, Agencia: 22
ContaCorrente, Numero: 11, Agencia: 22
ContaPoupanca, Numero: 22, Agencia: 22
---------
ContaPoupanca, Numero: 11, Agencia: 22, Paulo
ContaPoupanca, Numero: 22, Agencia: 22, Ana
ContaCorrente, Numero: 33, Agencia: 22, Nico
ContaCorrente, Numero: 44, Agencia: 22, GuilhermeCOPIAR CÓDIGO
```

A classe `Collections` possui muitos métodos, vale a pena explora-los posteriormente. Por exemplo, temos um chamado `reverse()`, que inverte a ordem da lista:

```
//Código omitido

public class Teste {

//Código omitido

        for (Conta conta : lista) {
                System.out.println(conta);
        }

//        NumeroDaContaComparator comparator = new NumeroDaContaComparator();
        lista.sort(new TitularDaContaComparator());

                Collections.sort(lista, new NumeroDaContaComparator());
                Collections.reverse(lista);

        System.out.println("---------");

        for (Conta conta : lista) {
                System.out.println(conta + ", " + conta.getTitular().getNome());
        }

}

class TitularDaContaComparator implements Comparator<Conta> {

        @Override
        public int compare(Conta c1, Conta c2) {

                String nomeC1 = c1.getTitular().getNome();
                String nomeC2 = c2.getTitular().getNome();
                return nomeC1.compareTo(nomeC2);
        }
}

class NumeroDaContaComparator implements Comparator<Conta> {

        @Override
        public int compare(Conta c1, Conta c2) {

                            return Integer.compare(c1.getNumero(), c2.getNumero());

//                        return c1.getNumero() - c2.getNumero();
//
//                if(c1.getNumero() < c2.getNumero()) {
//                    return -1;
//                }
//
//                if(c1.getNumero() > c2.getNumero()) {
//                    return 1;
//                }
//
//            return 0;
        }
}COPIAR CÓDIGO
```

Executando a classe, temos o seguinte resultado:

```
ContaCorrente, Numero: 33, Agencia: 22
ContaPoupanca, Numero: 44, Agencia: 22
ContaCorrente, Numero: 11, Agencia: 22
ContaPoupanca, Numero: 22, Agencia: 22
---------
ContaCorrente, Numero: 44, Agencia: 22, Guilherme
ContaCorrente, Numero: 33, Agencia: 22, Nico
ContaPoupanca, Numero: 22, Agencia: 22, Ana
ContaPoupanca, Numero: 11, Agencia: 22, PauloCOPIAR CÓDIGO
```

Ou seja, temos a `lista`, em ordem de maior para menor número de conta.

Como havíamos notado, há dois tipos de métodos `sort()` em `Collections`. O que já vimos, e que recebe um `comparator`, e um segundo, que **não recebe** um:

```
//Código omitido

public class Teste {

//Código omitido

        for (Conta conta : lista) {
                System.out.println(conta);
        }

//        NumeroDaContaComparator comparator = new NumeroDaContaComparator();
        lista.sort(new TitularDaContaComparator());

//                Collections.sort(lista, new NumeroDaContaComparator());
                Collections.sort(list);
                Collections.reverse(lista);

        System.out.println("---------");

        for (Conta conta : lista) {
                System.out.println(conta + ", " + conta.getTitular().getNome());
        }

}

class TitularDaContaComparator implements Comparator<Conta> {

        @Override
        public int compare(Conta c1, Conta c2) {

                String nomeC1 = c1.getTitular().getNome();
                String nomeC2 = c2.getTitular().getNome();
                return nomeC1.compareTo(nomeC2);
        }
}

class NumeroDaContaComparator implements Comparator<Conta> {

        @Override
        public int compare(Conta c1, Conta c2) {

                            return Integer.compare(c1.getNumero(), c2.getNumero());

//                        return c1.getNumero() - c2.getNumero();
//
//                if(c1.getNumero() < c2.getNumero()) {
//                    return -1;
//                }
//
//                if(c1.getNumero() > c2.getNumero()) {
//                    return 1;
//                }
//
//            return 0;
        }
}COPIAR CÓDIGO
```

Entretanto, ao incluirmos este método em nosso código, vemos que ele não compila. Se ele não possui um comparador, como pode ordenar os elementos? Ao nos depararmos com situações deste tipo, estamos lidando com o conceito de **ordem natural**.

Qualquer objeto que adicionamos à lista pode ter uma ordem natural. Ela é o critério de comparação que prevalece na hipótese de não definirmos um `comparator`.

Por exemplo, em um time de futebol, a ordem natural poderia ser considerada como a numeração na camisa dos jogadores.

Em nosso caso, para as contas, se não for definido um critério, qual deve ser nossa ordem natural? Há diversas possibilidades, mas neste caso, utilizaremos o saldo.

Para que isto funcione, é necessário alterarmos a classe `Conta`, já que é ela quem deve definir este critério.

Na classe `Conta`, implementaremos a interface utilizada para determinar a ordem natural, que se chama `Comparable`, do pacote `java.lang`:

```
//Código omitido

public abstract class Conta extends Object implements Comparable<T> {

                protected double saldo;
                private int agencia;
                private int numero;
                private Cliente titular;
                private static int total = 0;

//Código omitido

}COPIAR CÓDIGO
```

Assim, nossa conta se torna **comparável**. Como vimos, há também a presença de *generics*, uma vez que queremos comparar uma `Conta` a outra `Conta`:

```
//Código omitido

public abstract class Conta extends Object implements Comparable<Conta> {

                protected double saldo;
                private int agencia;
                private int numero;
                private Cliente titular;
                private static int total = 0;

//Código omitido

}COPIAR CÓDIGO
```

Para definirmos a ordem natural, de fato, precisamos implementar o método `compareTo()`. Utilizando a implementação automática do Eclipse, temos o seguinte:

```
//Código omitido

public abstract class Conta extends Object implements Comparable<Conta> {

                protected double saldo;
                private int agencia;
                private int numero;
                private Cliente titular;
                private static int total = 0;

//Código omitido

                @Override
                public boolean equals(Object ref) {

                        Conta outra = (Conta) ref;

                        if(this.agencia != outra.agencia) {
                            return false;
                        }

                        if(this.numero != outra.numero) {
                            return false;
                        }

                        return true;
                }

                @Override
                public int compareTo(Conta arg0) {
                //TODO Auto-generated method stub
                return 0;
                }

                @Override
                public String toString() {
                        return "Numero: " + this.numero + ", Agencia: " + this.agencia;
                }

}COPIAR CÓDIGO
```

Ele é similar ao método `compare()`, já que seu retorno é um inteiro, e nos devolve `0`, caso as contas sejam iguais. Também terá um número positivo, se a primeira conta for maior, e negativo, se ela for menor que a segunda.

Em seguida, adaptaremos o método, para que realize a comparação com base no saldo. Utilizaremos a classe *wrapper* `Double`, e teremos como parâmetro os dois valores dos saldos, `this.saldo` e `outra.saldo`, representando o saldo **desta** conta, e da **outra** conta:

```
//Código omitido

public abstract class Conta extends Object implements Comparable<Conta> {

                protected double saldo;
                private int agencia;
                private int numero;
                private Cliente titular;
                private static int total = 0;

//Código omitido

                @Override
                public boolean equals(Object ref) {

                        Conta outra = (Conta) ref;

                        if(this.agencia != outra.agencia) {
                            return false;
                        }

                        if(this.numero != outra.numero) {
                            return false;
                        }

                        return true;
                }

                @Override
                public int compareTo(Conta outra) {
                    return Double.compare(this.saldo, outra.saldo);
                }

                @Override
                public String toString() {
                        return "Numero: " + this.numero + ", Agencia: " + this.agencia;
                }

}COPIAR CÓDIGO
```

Não há necessidade de utilizarmos o método `getSaldo()` pois estamos trabalhando dentro da própria classe, assim, podemos utilizar `saldo` diretamente.

Agora que definimos a ordem natural, ao retornarmos à classe `Teste`, notamos que ela voltou a compilar. Podemos chamar o método `sort()` sem que haja um `comparator` definido, pois ele chamará internamente o método presenta na classe `Conta`, que acabamos de criar.

Para testarmos, comentaremos o método `reverse()`:

```
//Código omitido

public class Teste {

//Código omitido

        for (Conta conta : lista) {
                System.out.println(conta);
        }

//        NumeroDaContaComparator comparator = new NumeroDaContaComparator();
        lista.sort(new TitularDaContaComparator());

//                Collections.sort(lista, new NumeroDaContaComparator());
                Collections.sort(list);
//                Collections.reverse(lista);

        System.out.println("---------");

        for (Conta conta : lista) {
                System.out.println(conta + ", " + conta.getTitular().getNome());
        }

}

class TitularDaContaComparator implements Comparator<Conta> {

        @Override
        public int compare(Conta c1, Conta c2) {

                String nomeC1 = c1.getTitular().getNome();
                String nomeC2 = c2.getTitular().getNome();
                return nomeC1.compareTo(nomeC2);
        }
}

class NumeroDaContaComparator implements Comparator<Conta> {

        @Override
        public int compare(Conta c1, Conta c2) {

                            return Integer.compare(c1.getNumero(), c2.getNumero());

//                        return c1.getNumero() - c2.getNumero();
//
//                if(c1.getNumero() < c2.getNumero()) {
//                    return -1;
//                }
//
//                if(c1.getNumero() > c2.getNumero()) {
//                    return 1;
//                }
//
//            return 0;
        }
}COPIAR CÓDIGO
```

Executando, temos o seguinte resultado:

```
ContaCorrente, Numero: 33, Agencia: 22
ContaPoupanca, Numero: 44, Agencia: 22
ContaCorrente, Numero: 11, Agencia: 22
ContaPoupanca, Numero: 22, Agencia: 22
---------
ContaPoupanca, Numero: 11, Agencia: 22, Paulo
ContaPoupanca, Numero: 22, Agencia: 22, Ana
ContaCorrente, Numero: 33, Agencia: 22, Nico
ContaCorrente, Numero: 44, Agencia: 22, GuilhermeCOPIAR CÓDIGO
```

As contas estão ordenadas, mas não conseguimos visualizar os valores dos saldos.

Para solucionarmos isso, retornaremos à classe `Conta`, onde incluiremos no método `toString()` a referência ao saldo:

```
//Código omitido

public abstract class Conta extends Object implements Comparable<Conta> {

                protected double saldo;
                private int agencia;
                private int numero;
                private Cliente titular;
                private static int total = 0;

//Código omitido

                @Override
                public boolean equals(Object ref) {

                        Conta outra = (Conta) ref;

                        if(this.agencia != outra.agencia) {
                            return false;
                        }

                        if(this.numero != outra.numero) {
                            return false;
                        }

                        return true;
                }

                @Override
                public int compareTo(Conta outra) {
                    return Double.compare(this.saldo, outra.saldo);
                }

                @Override
                public String toString() {
                        return "Numero: " + this.numero + ", Agencia: " + this.agencia + ", Saldo: this.saldo;
                }

}COPIAR CÓDIGO
```

Mais uma vez, executando a classe `Teste`, temos o seguinte resultado no console:

```
ContaCorrente, Numero: 33, Agencia: 22, Saldo: 333.0
ContaPoupanca, Numero: 44, Agencia: 22, Saldo: 444.0
ContaCorrente, Numero: 11, Agencia: 22, Saldo: 111.0
ContaPoupanca, Numero: 22, Agencia: 22, Saldo: 222.0
---------
ContaPoupanca, Numero: 11, Agencia: 22, Saldo: 111.0, Paulo
ContaPoupanca, Numero: 22, Agencia: 22, Saldo: 222.0, Ana,
ContaCorrente, Numero: 33, Agencia: 22, Saldo: 333.0, Nico
ContaCorrente, Numero: 44, Agencia: 22, Saldo: 444.0, GuilhermeCOPIAR CÓDIGO
```

Tudo certo!

Primeiro, temos a ordem de inserção, e em seguida, a ordem de saldo, do menor para o maior.

A seguir, como podemos utilizar a ordem natural, aplicando diretamente na `lista`? Se fizermos o seguinte:

```
//Código omitido

public class Teste {

//Código omitido

        for (Conta conta : lista) {
                System.out.println(conta);
        }

//        NumeroDaContaComparator comparator = new NumeroDaContaComparator();
        lista.sort();

//                Collections.sort(lista, new NumeroDaContaComparator());
//                Collections.sort(list);
//                Collections.reverse(lista);

        System.out.println("---------");

        for (Conta conta : lista) {
                System.out.println(conta + ", " + conta.getTitular().getNome());
        }

}

class TitularDaContaComparator implements Comparator<Conta> {

        @Override
        public int compare(Conta c1, Conta c2) {

                String nomeC1 = c1.getTitular().getNome();
                String nomeC2 = c2.getTitular().getNome();
                return nomeC1.compareTo(nomeC2);
        }
}

class NumeroDaContaComparator implements Comparator<Conta> {

        @Override
        public int compare(Conta c1, Conta c2) {

                            return Integer.compare(c1.getNumero(), c2.getNumero());

//                        return c1.getNumero() - c2.getNumero();
//
//                if(c1.getNumero() < c2.getNumero()) {
//                    return -1;
//                }
//
//                if(c1.getNumero() > c2.getNumero()) {
//                    return 1;
//                }
//
//            return 0;
        }
}COPIAR CÓDIGO
```

O código não compila. O método `sort()` da `lista`, da instância, não é sobrecarregado. Aqui, existe apenas um, que é aquele que exige um `comparator`. Para que funcione, temos que passar o parâmetro `null` - mas isso á uma má prática de programação:

```
//Código omitido

public class Teste {

//Código omitido

        for (Conta conta : lista) {
                System.out.println(conta);
        }

//        NumeroDaContaComparator comparator = new NumeroDaContaComparator();
        lista.sort(null);

//                Collections.sort(lista, new NumeroDaContaComparator());
//                Collections.sort(list);
//                Collections.reverse(lista);

        System.out.println("---------");

        for (Conta conta : lista) {
                System.out.println(conta + ", " + conta.getTitular().getNome());
        }

}

class TitularDaContaComparator implements Comparator<Conta> {

        @Override
        public int compare(Conta c1, Conta c2) {

                String nomeC1 = c1.getTitular().getNome();
                String nomeC2 = c2.getTitular().getNome();
                return nomeC1.compareTo(nomeC2);
        }
}

class NumeroDaContaComparator implements Comparator<Conta> {

        @Override
        public int compare(Conta c1, Conta c2) {

                            return Integer.compare(c1.getNumero(), c2.getNumero());

//                        return c1.getNumero() - c2.getNumero();
//
//                if(c1.getNumero() < c2.getNumero()) {
//                    return -1;
//                }
//
//                if(c1.getNumero() > c2.getNumero()) {
//                    return 1;
//                }
//
//            return 0;
        }
}COPIAR CÓDIGO
```

Ao fazermos isso, passamos um `comparator` nulo, o que obriga o Java a utilizar a ordem natural. Entretanto, repetindo, o parâmetro `null` não é uma boa prática de programação.

Ao executarmos, vemos que o resultado no console permanece o mesmo, continua funcionando perfeitamente.