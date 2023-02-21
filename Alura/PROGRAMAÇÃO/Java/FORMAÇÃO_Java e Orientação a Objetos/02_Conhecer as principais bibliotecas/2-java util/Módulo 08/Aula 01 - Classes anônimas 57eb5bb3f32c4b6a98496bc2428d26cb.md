# Aula 01 - Classes anônimas

> Você pode fazer o [DOWNLOAD](https://caelum-online-public.s3.amazonaws.com/850-java-util/08/java6-cap8.zip) do projeto da aula anterior.
> 

Olá! Anteriormente, falamos sobre comparação e ordenação das coleções, definindo o `comparator` e a ordem natural.

Neste vídeo, continuaremos a falar sobre as classes de `comparators` que havíamos criado nas aulas anteriores, mas primeiro faremos alguns ajustes em nosso código.

Renomearemos a classe `Teste`, que passará a se chamar `TesteOrdenacao`. Criaremos uma cópia desta classe, à qual daremos o nome de `Teste`.

Ao abrirmos a nova classe `Teste`, percebemos que ela não compila. Isso acontece pois as classes `TitularDaContaComparator` e `NumeroDaContaComparator` já estão definidas na classe `TesteOrdenacao`, que já foi compilada pelo Eclipse. Para permitirmos a compilação, adicionaremos um `2` ao final do nome de cada uma destas classes.

Além disso, apagaremos o conteúdo que havíamos mantido em comentários, dentro da classe `NumeroDaContaComparator2`:

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

class TitularDaContaComparator2 implements Comparator<Conta> {

        @Override
        public int compare(Conta c1, Conta c2) {

                String nomeC1 = c1.getTitular().getNome();
                String nomeC2 = c2.getTitular().getNome();
                return nomeC1.compareTo(nomeC2);
        }
}

class NumeroDaContaComparator2 implements Comparator<Conta> {

        @Override
        public int compare(Conta c1, Conta c2) {

               return Integer.compare(c1.getNumero(), c2.getNumero());
            }
}COPIAR CÓDIGO
```

Apagaremos o primeiro laço, que havíamos criado antes da ordenação, e removeremos os comentários da linha onde foi criado o `comparator`, passando-o como parâmetro para o método `sort()`. Alteraremos o nome da classe, para corresponder ao novo `NumeroDaContaComparator2`.

Apagaremos os comentários relacionados às `Collections`, e a linha divisória que havíamos criado:

```
//Código omitido

public class Teste {

//Código omitido

        NumeroDaContaComparator2 comparator = new NumeroDaContaComparator2();
        lista.sort(comparator);

        for (Conta conta : lista) {
                System.out.println(conta + ", " + conta.getTitular().getNome());
        }

}

class TitularDaContaComparator2 implements Comparator<Conta> {

        @Override
        public int compare(Conta c1, Conta c2) {

                String nomeC1 = c1.getTitular().getNome();
                String nomeC2 = c2.getTitular().getNome();
                return nomeC1.compareTo(nomeC2);
        }
}

class NumeroDaContaComparator2 implements Comparator<Conta> {

        @Override
        public int compare(Conta c1, Conta c2) {

               return Integer.compare(c1.getNumero(), c2.getNumero());
            }
}COPIAR CÓDIGO
```

Por fim, alteraremos a ordem das classes, de modo que `NumeroDaContaComparator2` apareça antes de `TitularDaContaComparator2`:

```
//Código omitido

public class Teste {

//Código omitido

        NumeroDaContaComparator2 comparator = new NumeroDaContaComparator2();
        lista.sort(comparator);

        for (Conta conta : lista) {
                System.out.println(conta + ", " + conta.getTitular().getNome());
        }
}

class NumeroDaContaComparator2 implements Comparator<Conta> {

        @Override
        public int compare(Conta c1, Conta c2) {

               return Integer.compare(c1.getNumero(), c2.getNumero());
            }
}

class TitularDaContaComparator2 implements Comparator<Conta> {

        @Override
        public int compare(Conta c1, Conta c2) {

                String nomeC1 = c1.getTitular().getNome();
                String nomeC2 = c2.getTitular().getNome();
                return nomeC1.compareTo(nomeC2);
        }
}COPIAR CÓDIGO
```

O objetivo de uma classe é agrupar os elementos que devem permanecer juntos. São eles os estados, ou atributos, e funções, ou métodos. Entretanto, percebemos que nas duas últimas classes em nosso código não há nenhum atributo.

Ainda, como trabalhamos apenas com um método em cada classe, sequer utilizamos o `this`, o que indica um desinteresse no objeto. A criação da classe foi necessária pois é uma exigência do Java, mas não seria o meio mais indicado para encapsular um método.

Estes objetos, que são criados com o único objetivo de encapsular uma função, são chamados de **Function Objects**.

Em nenhum momento utilizamos a classe `NumeroDaContaComparator2` fora deste código, diferente da classe `Conta`, que utilizamos em diversos lugares.

Estas são motivações muito fracos para se ter uma classe. Por isso, existem atalhos que nos permitem simplificar nosso código.

O primeiro que veremos é a **classe anônima**, modalidade que é compatível até com versões do Java anteriores ao Java 8. Como já vimos, podemos inserir o construtor do objeto diretamente como um parâmetro no método `sort()`. Nossa ideia agora é eliminar a necessidade desta classe `NumeroDaContaComparator2` por completo.

Primeiro, inseriremos o construtor diretamente como um parâmetro:

```
//Código omitido

public class Teste {

//Código omitido

        lista.sort(new NumeroDaContaComparator2());

        for (Conta conta : lista) {
                System.out.println(conta + ", " + conta.getTitular().getNome());
        }
}

class NumeroDaContaComparator2 implements Comparator<Conta> {

        @Override
        public int compare(Conta c1, Conta c2) {

               return Integer.compare(c1.getNumero(), c2.getNumero());
            }
}

class TitularDaContaComparator2 implements Comparator<Conta> {

        @Override
        public int compare(Conta c1, Conta c2) {

                String nomeC1 = c1.getTitular().getNome();
                String nomeC2 = c2.getTitular().getNome();
                return nomeC1.compareTo(nomeC2);
        }
}COPIAR CÓDIGO
```

Copiaremos todo o conteúdo da classe `NumeroDaContaComparator2` a partir de `Comparator`, até o final, e colaremos após `new`, apagando `NumeroDaContaComparator2()` que havíamos inserido. O resultado é o seguinte:

```
//Código omitido

public class Teste {

//Código omitido

        lista.sort(new Comparator<Conta> {

        @Override
        public int compare(Conta c1, Conta c2) {

            return Integer.compare(c1.getNumero(), c2.getNumero());
                    }
                }
                );

        for (Conta conta : lista) {
                System.out.println(conta + ", " + conta.getTitular().getNome());
        }
}

class NumeroDaContaComparator2 implements Comparator<Conta> {

        @Override
        public int compare(Conta c1, Conta c2) {

               return Integer.compare(c1.getNumero(), c2.getNumero());
            }
}

class TitularDaContaComparator2 implements Comparator<Conta> {

        @Override
        public int compare(Conta c1, Conta c2) {

                String nomeC1 = c1.getTitular().getNome();
                String nomeC2 = c2.getTitular().getNome();
                return nomeC1.compareTo(nomeC2);
        }
}COPIAR CÓDIGO
```

O código ainda não compila, precisamos inserir os parênteses após os *generics* de `<Conta>`:

```
//Código omitido

public class Teste {

//Código omitido

        lista.sort(new Comparator<Conta>() {

        @Override
        public int compare(Conta c1, Conta c2) {

            return Integer.compare(c1.getNumero(), c2.getNumero());
                    }
                }
                );

        for (Conta conta : lista) {
                System.out.println(conta + ", " + conta.getTitular().getNome());
        }
}

class NumeroDaContaComparator2 implements Comparator<Conta> {

        @Override
        public int compare(Conta c1, Conta c2) {

               return Integer.compare(c1.getNumero(), c2.getNumero());
            }
}

class TitularDaContaComparator2 implements Comparator<Conta> {

        @Override
        public int compare(Conta c1, Conta c2) {

                String nomeC1 = c1.getTitular().getNome();
                String nomeC2 = c2.getTitular().getNome();
                return nomeC1.compareTo(nomeC2);
        }
}COPIAR CÓDIGO
```

Chamamos o construtor, sem argumentos, e inserimos toda a implementação diretamente. Estamos criando um objeto, que é compatível com o `NumeroDaContaComparator2`.

Internamente, o Java gera uma classe, que por sua vez implementa o método `compare()`.

Acessaremos o *Navigator*. Isso pode ser feito por meio do *Quick Access*, no canto superior direito da janela do Eclipse. Com ele aberto, abriremos a pasta "bytebank-herdado-conta > bin > br > com > bytebank > banco > test > util", que é justamente o nosso pacote.

Nela, há uma classe chamada `Teste`, e, logo abaixo, outra de nome `Teste$1`. Esta segunda classe foi gerada automaticamente, justamente por termos implementado o método da forma como fizemos acima, o que fizemos foi criar uma **classe anônima**. Ao implementarmos a interface `Comparator`, estamos criando a classe anônima.

Sendo assim, podemos apagar a classe que havíamos criado abaixo, já que ela não é mais necessária:

```
//Código omitido

public class Teste {

//Código omitido

        lista.sort(new Comparator<Conta>() {

        @Override
        public int compare(Conta c1, Conta c2) {

            return Integer.compare(c1.getNumero(), c2.getNumero());
                    }
                }
                );

        for (Conta conta : lista) {
                System.out.println(conta + ", " + conta.getTitular().getNome());
        }
}

class TitularDaContaComparator2 implements Comparator<Conta> {

        @Override
        public int compare(Conta c1, Conta c2) {

                String nomeC1 = c1.getTitular().getNome();
                String nomeC2 = c2.getTitular().getNome();
                return nomeC1.compareTo(nomeC2);
        }
}COPIAR CÓDIGO
```

Recapitulando, criamos uma classe compatível com a interface `Comparator`, pois a classe anônima a implementa. Em seguida, copiamos toda a definição da classe, a partir do nome da interface, e colamos diretamente no método, utilizando o construtor `new`. Para chamarmos o construtor da classe anônima, precisamos utilizar os parênteses (`()`), após os *generics*.

É o que faremos com a classe `TitularDaContaComparator2`:

```
//Código omitido

public class Teste {

//Código omitido

        lista.sort(new Comparator<Conta>() {

        @Override
        public int compare(Conta c1, Conta c2) {

            return Integer.compare(c1.getNumero(), c2.getNumero());
                    }
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
}

class TitularDaContaComparator2 implements Comparator<Conta> {

        @Override
        public int compare(Conta c1, Conta c2) {

                String nomeC1 = c1.getTitular().getNome();
                String nomeC2 = c2.getTitular().getNome();
                return nomeC1.compareTo(nomeC2);
        }
}COPIAR CÓDIGO
```

Fizemos o mesmo processo, mas neste segundo criamos uma variável `comp`, algo que não havíamos feito anteriormente. Com isso, podemos apagar a classe `TitularDaContaComparator2`:

```
//Código omitido

public class Teste {

//Código omitido

        lista.sort(new Comparator<Conta>() { //classe anonima

        @Override
        public int compare(Conta c1, Conta c2) {

            return Integer.compare(c1.getNumero(), c2.getNumero());
                    }
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

Assim, definimos duas classes anônimas. Ao abrirmos novamente o diretório, no *navigator*, como fizemos anteriormente, veremos que na pasta `util` temos duas classes novas, a `Teste$1` e `Teste$2`, correspondendo a cada uma das classes anônimas em nosso código, na ordem de sua criação.

Este tipo de classe nos exime da obrigação de criar classes isoladas, mas ao mesmo tempo gera maior dificuldade de leitura do nosso código. Neste ponto que entram os **lambdas**, eles servem para unir ainda mais o código.

Veremos mais sobre eles adiante, até a próxima!