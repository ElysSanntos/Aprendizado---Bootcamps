# Aula 04 - Finalmente Lambdas

Nesta aula, continuaremos a trabalhar com a classe `Teste`. Se preferir, pode fazer uma cópia e guardá-la como `TesteClasseAnonima`.

Nosso objetivo será transforma-la para o uso de **lambdas**.

Os métodos atuais, mesmo sendo mais compactos, possuem uma sintaxe difícil. Ao analisarmos, percebemos que os métodos possuem dois parâmetros, no segundo caso há uma implementação, e por fim, ambos nos retornam algum valor.

Para começar a melhorar nosso código, apagaremos, no método `sort()`, a partir do construtor `new`, até o nome do método `compare`:

```
//Código omitido

public class Teste {

//Código omitido

        lista.sort((Conta c1, Conta c2) {
                        return Integer.compare(c1.getNumero(), c2.getNumero());
                   }
                );

                Comparator<Conta> comp = new Comparator<Conta>() {

                        @Override
                        public int compare(Conta c1, Conta c2) {
                            String nomeC1 = c1.getTitular().getNome();
                            String nomeC2 = c2.getTitular().getNome();
                            return nomeC1.compareTo(nomeC2);
                        }
                };

        for (Conta conta : lista) {
                System.out.println(conta + ", " + conta.getTitular().getNome());
        }
}COPIAR CÓDIGO
```

Salvaremos, e notamos que a classe não compila. Precisamos declarar a existência das lambdas expressamente, isso é feito por meio do símbolo de seta (`->`), formado por uma hífen e um sinal de "maior que":

```
//Código omitido

public class Teste {

//Código omitido

        lista.sort((Conta c1, Conta c2) -> {
                        return Integer.compare(c1.getNumero(), c2.getNumero());
                   }
                );

                Comparator<Conta> comp = new Comparator<Conta>() {

                        @Override
                        public int compare(Conta c1, Conta c2) {
                            String nomeC1 = c1.getTitular().getNome();
                            String nomeC2 = c2.getTitular().getNome();
                            return nomeC1.compareTo(nomeC2);
                        }
                };

        for (Conta conta : lista) {
                System.out.println(conta + ", " + conta.getTitular().getNome());
        }
}COPIAR CÓDIGO
```

Internamente, o Java gera uma classe que implementa a interface `Comparator`, e que contém o método `compare()`. Faremos o mesmo abaixo, onde temos a variável `comp`.

Apagaremos todo o conteúdo, exceto pelos parâmetros:

```
//Código omitido

public class Teste {

//Código omitido

        lista.sort((Conta c1, Conta c2) -> {
                        return Integer.compare(c1.getNumero(), c2.getNumero());
                   }
                );

                Comparator<Conta> comp = (Conta c1, Conta c2) {
                            String nomeC1 = c1.getTitular().getNome();
                            String nomeC2 = c2.getTitular().getNome();
                            return nomeC1.compareTo(nomeC2);
                };

        for (Conta conta : lista) {
                System.out.println(conta + ", " + conta.getTitular().getNome());
        }
}COPIAR CÓDIGO
```

Temos que indicar o lambda (`->`), após os parâmetros:

```
//Código omitido

public class Teste {

//Código omitido

        lista.sort((Conta c1, Conta c2) -> {
                        return Integer.compare(c1.getNumero(), c2.getNumero());
                   }
                );

                Comparator<Conta> comp = (Conta c1, Conta c2) -> {
                            String nomeC1 = c1.getTitular().getNome();
                            String nomeC2 = c2.getTitular().getNome();
                            return nomeC1.compareTo(nomeC2);
                };

        for (Conta conta : lista) {
                System.out.println(conta + ", " + conta.getTitular().getNome());
        }
}COPIAR CÓDIGO
```

O código está compilando, e visualmente, é mais sucinto. O foco é nos trechos cuja escrita é necessária, sem necessidade de nomes de métodos e classes que estavam em excesso.

É possível abreviarmos o código ainda mais, não há necessidade do `return`, tampouco das chaves (`{}`), no método `sort()`, com isso, temos de lembrar de remover o ponto e vírgula que vem sempre ao final destas:

```
//Código omitido

public class Teste {

//Código omitido

        lista.sort(
                        (Conta c1, Conta c2) -> Integer.compare(c1.getNumero(), c2.getNumero())
        );

                Comparator<Conta> comp = (Conta c1, Conta c2) -> {
                            String nomeC1 = c1.getTitular().getNome();
                            String nomeC2 = c2.getTitular().getNome();
                            return nomeC1.compareTo(nomeC2);
                };

        for (Conta conta : lista) {
                System.out.println(conta + ", " + conta.getTitular().getNome());
        }
}COPIAR CÓDIGO
```

Resumimos este método em apenas uma linha.

Como o Java entende que estamos comparando duas contas, não há necessidade de indicarmos o tipo `Conta`, antes de `c1` e `c2`:

```
//Código omitido

public class Teste {

//Código omitido

        lista.sort( (c1, c2) -> Integer.compare(c1.getNumero(), c2.getNumero()) );

                Comparator<Conta> comp = (Conta c1, Conta c2) -> {
                            String nomeC1 = c1.getTitular().getNome();
                            String nomeC2 = c2.getTitular().getNome();
                            return nomeC1.compareTo(nomeC2);
                };

        for (Conta conta : lista) {
                System.out.println(conta + ", " + conta.getTitular().getNome());
        }
}COPIAR CÓDIGO
```

Esta sintaxe nos indica que, para as contas `c1` e `c2`, teremos em retorno a comparação na forma de um inteiro. Ela nos priva da burocracia de classes e escrita excessiva, mas demanda uma leitura mais cuidadosa do código.

Assim, temos duas variações de lambdas, primeiro no método `sort()`, em que ela é bastante mínima, com a menor quantidade possível de linhas de código, e em seguida, onde temos a variável `comp`, temos a definição do tipo `Conta`, e a utilização das chaves (`{}`), com o `return`definido. Ambas são válidas.

Assim como o `sort()`, é possível que a lista faça sua própria iteração, para isso, utilizamos o `lista.forEach(action)`:

```
//Código omitido

public class Teste {

//Código omitido

        lista.sort( (c1, c2) -> Integer.compare(c1.getNumero(), c2.getNumero()) );

        Comparator<Conta> comp = (Conta c1, Conta c2) -> {
                 String nomeC1 = c1.getTitular().getNome();
                 String nomeC2 = c2.getTitular().getNome();
                 return nomeC1.compareTo(nomeC2);
                };

                lista.forEach(action);

        for (Conta conta : lista) {
                System.out.println(conta + ", " + conta.getTitular().getNome());
        }
}COPIAR CÓDIGO
```

Este método sabe fazer seu próprio laço, ele sabe acessar cada elemento, uma vez que os administra. Entretanto, ele não é capaz de definir o que será inserido dentro do laço, ou seja, aquilo que desejamos fazer com cada elemento. Portanto, nossa função será fazer justamente isso.

Dentro dos parênteses do método `forEach`, utilizaremos o atalho "Ctrl + Espaço". Veremos que o ele não recebe um `Comparator`, e sim um `Consumer`. Assim, abriremos esta interface, e notaremos que ela possui um método `accept()`:

```
//Código omitido

public interface Consumer<T> {

//Código omitido

        void accept(T t);

//Restante do código omitidoCOPIAR CÓDIGO
```

Assim, definiremos uma classe anônima que implementa esta interface. Lembrando que ela também utiliza os *generics*:

```
//Código omitido

public class Teste {

//Código omitido

        lista.sort( (c1, c2) -> Integer.compare(c1.getNumero(), c2.getNumero()) );

        Comparator<Conta> comp = (Conta c1, Conta c2) -> {
                 String nomeC1 = c1.getTitular().getNome();
                 String nomeC2 = c2.getTitular().getNome();
                 return nomeC1.compareTo(nomeC2);
                };

                lista.forEach(new Consumer<Conta>() {
                });

        for (Conta conta : lista) {
                System.out.println(conta + ", " + conta.getTitular().getNome());
        }
}COPIAR CÓDIGO
```

Entretanto, o compilador sinaliza que ainda precisamos implementar o método. O Eclipse nos oferece a opção de adiciona-los, ao clicarmos no ícone de lâmpada, ao lado esquerdo da linha em que o erro é apontado, com isso, temos o seguinte código gerado automaticamente:

```
//Código omitido

public class Teste {

//Código omitido

        lista.sort( (c1, c2) -> Integer.compare(c1.getNumero(), c2.getNumero()) );

        Comparator<Conta> comp = (Conta c1, Conta c2) -> {
                 String nomeC1 = c1.getTitular().getNome();
                 String nomeC2 = c2.getTitular().getNome();
                 return nomeC1.compareTo(nomeC2);
                };

                lista.forEach(new Consumer<Conta>() {

                        @Override
                        public void accept(Conta c1) {
                            //TODO Auto-generated method stub
                        }
                });

        for (Conta conta : lista) {
                System.out.println(conta + ", " + conta.getTitular().getNome());
        }
}COPIAR CÓDIGO
```

Em seguida, substituiremos o código que foi gerado automaticamente, por aquele que havíamos inserido em nosso laço `for`:

```
//Código omitido

public class Teste {

//Código omitido

        lista.sort( (c1, c2) -> Integer.compare(c1.getNumero(), c2.getNumero()) );

        Comparator<Conta> comp = (Conta c1, Conta c2) -> {
                 String nomeC1 = c1.getTitular().getNome();
                 String nomeC2 = c2.getTitular().getNome();
                 return nomeC1.compareTo(nomeC2);
                };

                lista.forEach(new Consumer<Conta>() {

                        @Override
                        public void accept(Conta c1) {
                            System.out.println(conta + ", " + conta.getTitular().getNome());
                        }
                });

        for (Conta conta : lista) {
                System.out.println(conta + ", " + conta.getTitular().getNome());
        }
}COPIAR CÓDIGO
```

Ao fazer o laço, ele consumirá cada elemento, ou seja, cada `conta`, portanto `c1` dará lugar à `conta`:

```
//Código omitido

public class Teste {

//Código omitido

        lista.sort( (c1, c2) -> Integer.compare(c1.getNumero(), c2.getNumero()) );

        Comparator<Conta> comp = (Conta c1, Conta c2) -> {
                 String nomeC1 = c1.getTitular().getNome();
                 String nomeC2 = c2.getTitular().getNome();
                 return nomeC1.compareTo(nomeC2);
                };

                lista.forEach(new Consumer<Conta>() {

                        @Override
                        public void accept(Conta conta) {
                            System.out.println(conta + ", " + conta.getTitular().getNome());
                        }
                });

        for (Conta conta : lista) {
                System.out.println(conta + ", " + conta.getTitular().getNome());
        }
}COPIAR CÓDIGO
```

Como podemos notar, este novo código é maior que o anterior, por isso, simplificaremos sua escrita. O primeiro passo será apagar tudo que é inserido no parâmetro, até a entrada `(Conta conta)`:

```
//Código omitido

public class Teste {

//Código omitido

        lista.sort( (c1, c2) -> Integer.compare(c1.getNumero(), c2.getNumero()) );

        Comparator<Conta> comp = (Conta c1, Conta c2) -> {
                 String nomeC1 = c1.getTitular().getNome();
                 String nomeC2 = c2.getTitular().getNome();
                 return nomeC1.compareTo(nomeC2);
                };

                lista.forEach((Conta conta) {
                            System.out.println(conta + ", " + conta.getTitular().getNome());
                        }
                });

        for (Conta conta : lista) {
                System.out.println(conta + ", " + conta.getTitular().getNome());
        }
}COPIAR CÓDIGO
```

Precisamos indicar que se trata de uma lambda, fazemos isso utilizando o símbolo **`->`**:

```
//Código omitido

public class Teste {

//Código omitido

        lista.sort( (c1, c2) -> Integer.compare(c1.getNumero(), c2.getNumero()) );

        Comparator<Conta> comp = (Conta c1, Conta c2) -> {
                 String nomeC1 = c1.getTitular().getNome();
                 String nomeC2 = c2.getTitular().getNome();
                 return nomeC1.compareTo(nomeC2);
                };

                lista.forEach((Conta conta) -> {
                            System.out.println(conta + ", " + conta.getTitular().getNome());
                        }
                );

        for (Conta conta : lista) {
                System.out.println(conta + ", " + conta.getTitular().getNome());
        }
}COPIAR CÓDIGO
```

Assim como anteriormente, não há necessidade de fazermos referência ao tipo `Conta`. Tampouco há necessidade para as chaves (`{}`), já que estamos trabalhando com uma linha de código somente:

```
//Código omitido

public class Teste {

//Código omitido

        lista.sort( (c1, c2) -> Integer.compare(c1.getNumero(), c2.getNumero()) );

        Comparator<Conta> comp = (Conta c1, Conta c2) -> {
                 String nomeC1 = c1.getTitular().getNome();
                 String nomeC2 = c2.getTitular().getNome();
                 return nomeC1.compareTo(nomeC2);
                };

                lista.forEach( (conta) -> System.out.println(conta + ", " + conta.getTitular().getNome()));

        for (Conta conta : lista) {
                System.out.println(conta + ", " + conta.getTitular().getNome());
        }
}COPIAR CÓDIGO
```

Assim foi possível escrever tudo em uma só linha.

Quem faz o laço é a própria `lista`, para cada elemento que for uma `conta`, será aplicado o `System.out.println()` que definimos. Podemos apagar o laço `for` antigo:

```
//Código omitido

public class Teste {

//Código omitido

        lista.sort( (c1, c2) -> Integer.compare(c1.getNumero(), c2.getNumero()) );

        Comparator<Conta> comp = (Conta c1, Conta c2) -> {
                 String nomeC1 = c1.getTitular().getNome();
                 String nomeC2 = c2.getTitular().getNome();
                 return nomeC1.compareTo(nomeC2);
                };

                lista.forEach( (conta) -> System.out.println(conta + ", " + conta.getTitular().getNome()));
}COPIAR CÓDIGO
```

Testaremos o código, executando-o, e temos o seguinte resultado no console:

```
ContaPoupanca, Numero: 11, Agencia: 22, Saldo: 111.0, Paulo
ContaPoupanca, Numero: 22, Agencia: 22, Saldo: 222.0, Ana,
ContaCorrente, Numero: 33, Agencia: 22, Saldo: 333.0, Nico
ContaCorrente, Numero: 44, Agencia: 22, Saldo: 444.0, GuilhermeCOPIAR CÓDIGO
```

Nosso código está funcionando.

Para testarmos o `comp`, utilizaremos o método `sort()` tendo ele como parâmetro:

```
//Código omitido

public class Teste {

//Código omitido

        lista.sort( (c1, c2) -> Integer.compare(c1.getNumero(), c2.getNumero()) );

        Comparator<Conta> comp = (Conta c1, Conta c2) -> {
                 String nomeC1 = c1.getTitular().getNome();
                 String nomeC2 = c2.getTitular().getNome();
                 return nomeC1.compareTo(nomeC2);
                };

                lista.sort( comp );

                lista.forEach( (conta) -> System.out.println(conta + ", " + conta.getTitular().getNome()));
}COPIAR CÓDIGO
```

Executando, temos o seguinte resultado:

```
ContaPoupanca, Numero: 22, Agencia: 22, Saldo: 222.0, Ana
ContaCorrente, Numero: 44, Agencia: 22, Saldo: 444.0, Guilherme
ContaCorrente, Numero: 33, Agencia: 22, Saldo: 333.0, Nico
ContaPoupanca, Numero: 11, Agencia: 22, Saldo: 111.0, PauloCOPIAR CÓDIGO
```

Funciona também!

Há um universo dos lambdas, muito maior do que vimos aqui, com outros paradigmas de programação funcional, e que pode ser visto em outro curso. Nosso objetivo aqui foi explicar a necessidade deles, e o porquê de existirem.