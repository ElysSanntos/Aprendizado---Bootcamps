# Aula 05 - Array de referências

Nesta aula, daremos continuidade à construção do array que inicializamos na aula anterior.

Como arrays são objetos, para criarmos um novo, utilizamos a palavra `new`:

```
public class Teste {

        public static void main(String[] args) {
            int[] idades = new int[5];

        }
}COPIAR CÓDIGO
```

Precisamos definir qual tipo de dados são armazenados, no caso, utilizamos o `int`. Indicamos que se tratam de arrays por meio do uso de colchetes (`[]`), os utilizamos tanto ao declarar o tipo, quanto ao definir o tamanho do array. Todo array deve ter um tamanho fixo, pré-definido.

No nosso caso, definimos o tamanho como `5`, isso significa que, na memória onde os objetos são armazenados é criado um espaço suficiente para que sejam guardados cinco números inteiros.

Automaticamente, o array é inicializado com o valor padrão do tipo definido, como aqui utilizamos o `int`, o valor padrão inicial é `0`.

Em seguida, vimos como podemos acessar um array. No caso, fizemos um laço e criamos um mecanismo que nos permite acessar cada posição:

```
public class Teste {

        public static void main(String[] args) {
            int[] idades = new int[5];

        for(int i = 0; i < idades.length; i++) {
            idades[i] = i * i;
        }
    }
}COPIAR CÓDIGO
```

Utilizamos a referência `idades`, e os colchetes (`[]`), para indicarmos qual posição pretendemos acessar. Importante lembrar que para os arrays, as posições iniciam em `0`, ou seja, a primeira posição é representada pelo número `0`.

Mas não esclarecemos anteriormente, o real significado de `String[]` na assinatura do método `main`.

Temos que ter em mente que `String` é um tipo, uma classe, não um primitivo. Ou seja, o que fazemos ao declarar:

```
//Código omitido

public static void main(String[] args) {

//Código omitidoCOPIAR CÓDIGO
```

É declarar um array de referência.

Renomearemos a classe `Teste`, para `TesteArrayDePrimitivos`, e em seguida criaremos uma nova classe, um novo teste, chamado `TestArrayReferencias`, com um método `main`:

```
package br.com.bytebank.banco.test;

public class TestArrayReferencias {

        public static void main(String[] args) {

        }

}COPIAR CÓDIGO
```

Por que um array de referências? para estarmos preparados caso surja a necessidade de armazenamos diversas contas. E se tivermos 10 contas? onde guardaríamos as 10 referências? Uma possibilidade seria guardá-las dentro de um array.

Primeiro, vamos trabalhar com a classe `ContaCorrente`, onde iremos armazenar 10 contas correntes, declararemos então o tipo:

```
package br.com.bytebank.banco.test;

public class TestArrayReferencias {

        public static void main(String[] args) {

                ContaCorrente

        }

}COPIAR CÓDIGO
```

Utilizaremos a mesma sintaxe do exemplo anterior, por isso, podemos desde já trazê-la e mantê-la em comentários sobre o tipo `ContaCorrente`:

```
package br.com.bytebank.banco.test;

public class TestArrayReferencias {

        public static void main(String[] args) {

                //int[] idades = new int[5];
                ContaCorrente

        }

}COPIAR CÓDIGO
```

Para indicarmos que se trata de um array, incluiremos os colchetes (`[]`), após `ContaCorrente`:

```
package br.com.bytebank.banco.test;

public class TestArrayReferencias {

        public static void main(String[] args) {

                //int[] idades = new int[5];
                ContaCorrente[]

        }

}COPIAR CÓDIGO
```

Chamaremos a variável de `contas`. Utilizaremos o `new` para indicar que estamos criando um novo objeto, repetindo o tipo, e os colchetes (`[]`), além do número total de contas que pretendemos armazenar, no caso, `5`:

```
package br.com.bytebank.banco.test;

public class TestArrayReferencias {

        public static void main(String[] args) {

                //int[] idades = new int[5];
                ContaCorrente[] contas = new ContaCorrente[5];

        }

}COPIAR CÓDIGO
```

Criamos um objeto que pode guardar cinco referências de contas correntes. Quantas contas foram de fato criadas? nenhuma. Temos por enquanto somente o compartimento capaz de armazená-las.

Dentro deste array não há primitivos, mas podem viver referências, estas por sua vez, serão inicializadas com os valores padrões.

Como criamos uma `ContaCorrente`, qual é o seu valor padrão? No caso, é `null`. Por isso, não podemos dizer que foi criada alguma conta, pois o array não aponta para nenhum objeto.

Em seguida, criaremos uma `ContaCorrente cc1`, com seus respectivos dados de agência e número:

```
package br.com.bytebank.banco.test;

public class TestArrayReferencias {

        public static void main(String[] args) {

                //int[] idades = new int[5];
                ContaCorrente[] contas = new ContaCorrente[5];

                ContaCorrente cc1 = new ContaCorrente(22, 11);

        }

}COPIAR CÓDIGO
```

A ideia é que, agora, criamos o nosso primeiro objeto. Temos uma referência `cc1` que aponta para ele. Em seguida, nosso objetivo será armazená-lo na primeira posição em nosso array.

Como acessamos a primeira posição do array? primeiro, utilizamos o nome, em seguida fazemos a referência à posição entre colchetes (`[]`), para então atribuirmos o valor, `cc1`:

```
package br.com.bytebank.banco.test;

public class TestArrayReferencias {

        public static void main(String[] args) {

                //int[] idades = new int[5];
                ContaCorrente[] contas = new ContaCorrente[5];

                ContaCorrente cc1 = new ContaCorrente(22, 11);

                contas[0] = cc1;

        }

}COPIAR CÓDIGO
```

Internamente, é criada uma cópia do valor `cc1`, que é armazenada na primeira posição e aponta para o objeto.

Criaremos em seguida mais um objeto, `cc2`:

```
package br.com.bytebank.banco.test;

public class TestArrayReferencias {

        public static void main(String[] args) {

                //int[] idades = new int[5];
                ContaCorrente[] contas = new ContaCorrente[5];
                ContaCorrente cc1 = new ContaCorrente(22, 11);
                contas[0] = cc1;

                ContaCorrente cc2 = new ContaCorrente(22, 22);

        }

}COPIAR CÓDIGO
```

Temos mais uma referência em nosso código, apontando para este novo objeto. O próximo passo é armazenamos uma cópia desta cópia dentro do nosso array.

Para acessarmos a segunda posição, utilizamos o número `1`, e atribuímos o valor `cc2`:

```
package br.com.bytebank.banco.test;

public class TestArrayReferencias {

        public static void main(String[] args) {

                //int[] idades = new int[5];
                ContaCorrente[] contas = new ContaCorrente[5];
                ContaCorrente cc1 = new ContaCorrente(22, 11);
                contas[0] = cc1;

                ContaCorrente cc2 = new ContaCorrente(22, 22);
                contas[1] = cc2;

        }

}COPIAR CÓDIGO
```

Testaremos nosso código, tentaremos acessar o número da segunda conta a partir do nosso array. Criaremos um `System.out.println()`, com o método `getNumero()`:

```
package br.com.bytebank.banco.test;

public class TestArrayReferencias {

        public static void main(String[] args) {

                //int[] idades = new int[5];
                ContaCorrente[] contas = new ContaCorrente[5];
                ContaCorrente cc1 = new ContaCorrente(22, 11);
                contas[0] = cc1;

                ContaCorrente cc2 = new ContaCorrente(22, 22);
                contas[1] = cc2;

                System.out.println(cc2.getNumero());

        }

}COPIAR CÓDIGO
```

Mas não queremos acessar o objeto diretamente, queremos acessar a cópia que armazenamos. Como podemos fazer isso? Temos de fazer a referência ao array, utilizando a palavra `contas`, e incluir a posição que desejamos acessar, no caso a segunda posição, representada pelo número `1`:

```
package br.com.bytebank.banco.test;

public class TestArrayReferencias {

        public static void main(String[] args) {

                //int[] idades = new int[5];
                ContaCorrente[] contas = new ContaCorrente[5];
                ContaCorrente cc1 = new ContaCorrente(22, 11);
                contas[0] = cc1;

                ContaCorrente cc2 = new ContaCorrente(22, 22);
                contas[1] = cc2;

                //System.out.println(cc2.getNumero());

                System.out.println(contas[1].getNumero());
        }

}COPIAR CÓDIGO
```

Executaremos e temos o seguinte resultado no console:

```
22COPIAR CÓDIGO
```

Se tentarmos acessar a posição `0`:

```
package br.com.bytebank.banco.test;

public class TestArrayReferencias {

        public static void main(String[] args) {

                //int[] idades = new int[5];
                ContaCorrente[] contas = new ContaCorrente[5];
                ContaCorrente cc1 = new ContaCorrente(22, 11);
                contas[0] = cc1;

                ContaCorrente cc2 = new ContaCorrente(22, 22);
                contas[1] = cc2;

                //System.out.println(cc2.getNumero());

                System.out.println(contas[0].getNumero());
        }

}COPIAR CÓDIGO
```

Temos o seguinte resultado:

```
11COPIAR CÓDIGO
```

Se tentarmos acessar a terceira posição:

```
package br.com.bytebank.banco.test;

public class TestArrayReferencias {

        public static void main(String[] args) {

                //int[] idades = new int[5];
                ContaCorrente[] contas = new ContaCorrente[5];
                ContaCorrente cc1 = new ContaCorrente(22, 11);
                contas[0] = cc1;

                ContaCorrente cc2 = new ContaCorrente(22, 22);
                contas[1] = cc2;

                //System.out.println(cc2.getNumero());

                System.out.println(contas[2].getNumero());
        }

}COPIAR CÓDIGO
```

Temos o seguinte resultado:

```
Exception in thread "main" java.long.NullPointerException
        at br.com.bytebank.banco.test.TestArrayReferencias.main(TestArrayReferencias.java:20)COPIAR CÓDIGO
```

Pois ela ainda não foi inicializada e, por padrão, tem o valor `null`.

Retornaremos para a impressão da segunda posição:

```
package br.com.bytebank.banco.test;

public class TestArrayReferencias {

        public static void main(String[] args) {

                //int[] idades = new int[5];
                ContaCorrente[] contas = new ContaCorrente[5];
                ContaCorrente cc1 = new ContaCorrente(22, 11);
                contas[0] = cc1;

                ContaCorrente cc2 = new ContaCorrente(22, 22);
                contas[1] = cc2;

                //System.out.println(cc2.getNumero());

                System.out.println(contas[1].getNumero());
        }

}COPIAR CÓDIGO
```

Estamos acessando o `contas[1]` e, em contrapartida, nos será devolvido um valor, que é uma referência. Mas onde ela é armazenada? em uma variável, que por sua vez, tem que ter um tipo.

No nosso caso, o tipo da variável é `ContaCorrente`. Assim, nosso retorno é uma referência do tipo `ContaCorrente`:

```
package br.com.bytebank.banco.test;

public class TestArrayReferencias {

        public static void main(String[] args) {

                //int[] idades = new int[5];
                ContaCorrente[] contas = new ContaCorrente[5];
                ContaCorrente cc1 = new ContaCorrente(22, 11);
                contas[0] = cc1;

                ContaCorrente cc2 = new ContaCorrente(22, 22);
                contas[1] = cc2;

                //System.out.println(cc2.getNumero());

                System.out.println(contas[1].getNumero());

                ContaCorrente ref = contas[1];
        }

}COPIAR CÓDIGO
```

Aqui, chamamos nossa referência de `ref`, ela tem o mesmo valor de `cc2`, ou seja, aponta para o objeto `ContaCorrente`.

Assim, podemos utilizar o `ref.getNumero()` para imprimirmos o número da conta. Executaremos:

```
package br.com.bytebank.banco.test;

public class TestArrayReferencias {

        public static void main(String[] args) {

                //int[] idades = new int[5];
                ContaCorrente[] contas = new ContaCorrente[5];
                ContaCorrente cc1 = new ContaCorrente(22, 11);
                contas[0] = cc1;

                ContaCorrente cc2 = new ContaCorrente(22, 22);
                contas[1] = cc2;

                //System.out.println(cc2.getNumero());

                System.out.println(contas[1].getNumero());

                ContaCorrente ref = contas[1];

                System.out.println(ref.getNumero());
        }

}COPIAR CÓDIGO
```

E obtivemos o seguinte resultado:

```
22
22COPIAR CÓDIGO
```

Indicando que nosso código funcionou.

Este último `System.out.println()` equivale a `System.out.println(cc2.getNumero())`:

```
package br.com.bytebank.banco.test;

public class TestArrayReferencias {

        public static void main(String[] args) {

                //int[] idades = new int[5];
                ContaCorrente[] contas = new ContaCorrente[5];
                ContaCorrente cc1 = new ContaCorrente(22, 11);
                contas[0] = cc1;

                ContaCorrente cc2 = new ContaCorrente(22, 22);
                contas[1] = cc2;

                //System.out.println(cc2.getNumero());

                System.out.println(contas[1].getNumero());

                ContaCorrente ref = contas[1];
                System.out.println(cc2.getNumero());
                System.out.println(ref.getNumero());
        }

}COPIAR CÓDIGO
```

Se executarmos, temos o seguinte resultado:

```
22
22
22COPIAR CÓDIGO
```

Portanto, quantas contas criamos afinal? Duas. Quantos objetos criamos? Três. Já referências, temos 9, destas, apenas 6 foram inicializadas.

Temos assim um array de referências.

Adiante, falaremos sobre array de referências polimórfico. Até lá!