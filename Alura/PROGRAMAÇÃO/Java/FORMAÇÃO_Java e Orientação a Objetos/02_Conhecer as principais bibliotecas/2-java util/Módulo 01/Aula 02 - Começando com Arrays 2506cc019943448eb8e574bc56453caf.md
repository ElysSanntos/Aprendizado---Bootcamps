# Aula 02 - Começando com Arrays

> Você pode fazer o [DOWNLOAD](https://caelum-online-public.s3.amazonaws.com/850-java-util/01/java6-projetos-iniciais.zip) dos projetos usados no curso anterior.
> 

Olá!

Neste curso, nosso objetivo é entendermos os pacotes `java.util` e `java.io`, e continuaremos a utilizar o `java.lang`.

Com relação ao `java.lang`, entenderemos melhor a nossa classe `Object`, pois temos os métodos `hashCode()` e `equals()`, isso será esclarecido ao falarmos sobre `java.util`.

Antes de entrarmos no `java.util` em si, retornaremos ao código que escrevemos para aprendermos um novo conceito.

Temos o projeto `bytebank-herdado-conta`, que finalizamos anteriormente, e conseguimos entendê-lo completamente, com uma exceção, vamos observar o código:

```
package br.com.bytebank.banco.test;

import br.com.bytebank.banco.modelo.Cliente;

public class Teste {

        public static void main(String[] args) {

//Código omitidoCOPIAR CÓDIGO
```

Na declaração do método `main`, não sabemos exatamente qual é a função dos colchetes `[]`. Antes de começarmos com o `java.util`, primeiro desvendaremos este mistério.

Renomearemos a classe `Teste`, clicando com o botão direto do mouse sobre ela, e selecionando "Refactor > Rename", a chamaremos de `TesteObject`. Em seguida, criaremos uma nova classe de teste, chamada `Teste`, com o seguinte conteúdo:

```
package br.com.bytebank.banco.test;

public class Teste {

        public static void main(String[] args) {

        }
}COPIAR CÓDIGO
```

Por que existem os colchetes `[]`?

Imaginemos que queremos armazenar um conjunto de dados, por exemplo, as idades de cinco pessoas, para isso, utilizamos as variáveis:

```
package br.com.bytebank.banco.test;

public class Teste {

        public static void main(String[] args) {

            int idade1 = 29;
            int idade2 = 39;
            int idade3 = 19;
            int idade4 = 69;
            int idade5 = 59;

        }
}COPIAR CÓDIGO
```

Para cinco idades, isto pode até funcionar, mas quando trabalhamos com um grande número de dados, por exemplo, cem idades, já se torna inviável. Precisamos de formas mais enxutas de armazenamento de dados, e para isso existem as **estruturas de dados**.

Conheceremos agora nossa primeira estrutura de dados, que se chama ***array***:

```
package br.com.bytebank.banco.test;

public class Teste {

        //Array []
        public static void main(String[] args) {

            int idade1 = 29;
            int idade2 = 39;
            int idade3 = 19;
            int idade4 = 69;
            int idade5 = 59;

        }
}COPIAR CÓDIGO
```

Raramente os arrays serão utilizados da forma como faremos agora, ou seja, manualmente.

Arrays são colchetes (`[]`) associados a algum tipo de dados, no caso, queremos apresentar idade que, como vimos, são do tipo `int`. Assim, o array será do tipo `int`. Em seguida, precisaremos de um nome para a variável, que será `idades`:

```
package br.com.bytebank.banco.test;

public class Teste {

        //Array []
        public static void main(String[] args) {

            int[]idades;

            int idade1 = 29;
            int idade2 = 39;
            int idade3 = 19;
            int idade4 = 69;
            int idade5 = 59;

        }
}COPIAR CÓDIGO
```

Os colchetes (`[]`) também poderiam estar posicionados após o nome da variável, da seguinte forma `int idades[]`, apesar de ser mais comum sua utilização da forma como colocamos no código acima.

Um array também é um objeto, assim sendo, precisamos criá-lo, pois temos uma referência que ainda não foi inicializada:

```
package br.com.bytebank.banco.test;

public class Teste {

        //Array []
        public static void main(String[] args) {

            int[]idades = new int[];

            int idade1 = 29;
            int idade2 = 39;
            int idade3 = 19;
            int idade4 = 69;
            int idade5 = 59;

        }
}COPIAR CÓDIGO
```

O compilador aponta um erro de compilação. Isso porque, ao criar o array, precisamos informar o seu tamanho. Quantas idades queremos guardar? 5, portando, o tamanho do nosso array é `5`:

```
package br.com.bytebank.banco.test;

public class Teste {

        //Array []
        public static void main(String[] args) {

            int[]idades = new int[5];

            int idade1 = 29;
            int idade2 = 39;
            int idade3 = 19;
            int idade4 = 69;
            int idade5 = 59;

        }
}COPIAR CÓDIGO
```

Assim que inserimos o tamanho do array o código volta a compilar.

Internamente, temos um processo que começa com uma pilha de execução, representada pelo método `main`. Nesta pilha, ou seja, no método, foi criada uma variável `idades`.

Esta variável é um array, que como vimos, é um objeto. Os objetos ficam armazenados na memória HEAP. Assim, `idades` é uma referência que aponta para um objeto na memória, capaz de guardar cinco idades.

Como podemos acessar uma das posições? Utilizamos a variável como referência e precisamos informar a posição que queremos acessar dentro de colchetes (`[]`). Por exemplo, se quisermos acessar a primeira posição, ela é representada pelo número `0`:

```
package br.com.bytebank.banco.test;

public class Teste {

        //Array []
        public static void main(String[] args) {

            int[]idades = new int[5];

            idades[0]

            int idade1 = 29;
            int idade2 = 39;
            int idade3 = 19;
            int idade4 = 69;
            int idade5 = 59;

        }
}COPIAR CÓDIGO
```

Nos será devolvido o valor que estiver armazenado na referida posição. Por enquanto, este valor é `0` já que, por padrão, ao criarmos um array ele é inicializado com `0` em todas as posições:

```
package br.com.bytebank.banco.test;

public class Teste {

        //Array []
        public static void main(String[] args) {

            int[]idades = new int[5]; //inicializa o array com os valores padroes

            idades[0]

            int idade1 = 29;
            int idade2 = 39;
            int idade3 = 19;
            int idade4 = 69;
            int idade5 = 59;

        }
}COPIAR CÓDIGO
```

O primeiro valor padrão do tipo `int` disponível é `0`.

Acessando o array na posição 0, ele nos retorna o valor desta posição, que no nosso caso é a `idade1`. Podemos apagar os dados que havíamos preenchido anteriormente:

```
package br.com.bytebank.banco.test;

public class Teste {

        //Array []
        public static void main(String[] args) {

            int[]idades = new int[5]; //inicializa o array com os valores padroes

            int idade1 = idades[0];

            System.out.println(idade1);

        }
}COPIAR CÓDIGO
```

Ao executarmos, temos o seguinte resultado no console:

```
0COPIAR CÓDIGO
```

Ele nos imprimiu o valor presente na posição 0, que por coincidência, também é `0`. Mas não queremos que seja `0`, de acordo com nossos dados, ele deve ser `29`. Para isso, inicializaremos o nosso array.

Utilizamos primeiro a referência do array, `idades`, seguida pelos colchetes (`[]`), que devem ser preenchidos com a posição que desejamos utilizar, no caso `0`, e ao fim, informamos o valor que desejamos armazenar, no caso, `29`:

```
package br.com.bytebank.banco.test;

public class Teste {

        //Array []
        public static void main(String[] args) {

            int[]idades = new int[5]; //inicializa o array com os valores padroes

            idades[0] = 29;

            int idade1 = idades[0];

            System.out.println(idade1);

        }
}COPIAR CÓDIGO
```

Isso significa que estamos armazenando no primeiro espaço de memória que criamos, como falamos acima. O `29` está no índice zero, ou seja, na primeira posição.1

Agora, ao executarmos, temos o seguinte resultado no console:

```
29COPIAR CÓDIGO
```

Com isso, podemos inicializar as demais posições do array:

```
package br.com.bytebank.banco.test;

public class Teste {

        //Array []
        public static void main(String[] args) {

            int[]idades = new int[5]; //inicializa o array com os valores padroes

            idades[0] = 29;
            idades[1] = 39;
            idades[2] = 49;
            idades[3] = 59;
            idades[4] = 69;

            int idade1 = idades[0];

            System.out.println(idade1);

        }
}COPIAR CÓDIGO
```

Tentaremos acessar, por exemplo, a posição 4:

```
package br.com.bytebank.banco.test;

public class Teste {

        //Array []
        public static void main(String[] args) {

            int[]idades = new int[5]; //inicializa o array com os valores padroes

            idades[0] = 29;
            idades[1] = 39;
            idades[2] = 49;
            idades[3] = 59;
            idades[4] = 69;

            int idade1 = idades[4];

            System.out.println(idade1);

        }
}COPIAR CÓDIGO
```

Executaremos o programa, e temos o seguinte resultado no console:

```
69COPIAR CÓDIGO
```

Se o array tivesse, por exemplo, 50 posições, seria possível acessarmos a de número 49:

```
package br.com.bytebank.banco.test;

public class Teste {

        //Array []
        public static void main(String[] args) {

            int[]idades = new int[50]; //inicializa o array com os valores padroes

            idades[0] = 29;
            idades[1] = 39;
            idades[2] = 49;
            idades[3] = 59;
            idades[4] = 69;

            int idade1 = idades[49];

            System.out.println(idade1);

        }
}COPIAR CÓDIGO
```

Ao executarmos o programa, temos o seguinte resultado no console:

```
0COPIAR CÓDIGO
```

Isso porque não inicializamos essa posição, logo, nos é fornecido o valor padrão.

E o que acontece se tentarmos acessar uma posição que não existe? voltaremos a definir o array com 5 posições, e tentaremos novamente acessar a de número 49:

```
package br.com.bytebank.banco.test;

public class Teste {

        //Array []
        public static void main(String[] args) {

            int[]idades = new int[5]; //inicializa o array com os valores padroes

            idades[0] = 29;
            idades[1] = 39;
            idades[2] = 49;
            idades[3] = 59;
            idades[4] = 69;

            int idade1 = idades[49];

            System.out.println(idade1);

        }
}COPIAR CÓDIGO
```

Executaremos o programa, e temos o seguinte resultado no console:

```
Exception in thread "main" java.long.ArrayIndexOutOfBoundsException: 49
        at br.com.bytebank.banco.test.Teste.main(Teste.java:16)COPIAR CÓDIGO
```

Um erro ocorre. Este tipo de erro, inclusive, é bastante comum. É uma exceção *unchecked*, não somos obrigados a fazer nenhum tratamento.

Os arrays nos permitem ainda que perguntemos o seu tamanho. Criaremos um `System.out.println()`, utilizando a referência `idades`, e chamando o atributo `length` - notamos que não é um método pois não é acompanhado de parênteses:

```
package br.com.bytebank.banco.test;

public class Teste {

        //Array []
        public static void main(String[] args) {

            int[]idades = new int[5]; //inicializa o array com os valores padroes

            idades[0] = 29;
            idades[1] = 39;
            idades[2] = 49;
            idades[3] = 59;
            idades[4] = 69;

            int idade1 = idades[4];

            System.out.println(idade1);

            System.out.println(idades.length);

        }
}COPIAR CÓDIGO
```

Com a posição de volta para `4`, na impressão, executaremos o programa e temos o seguinte resultado no console:

```
69
5COPIAR CÓDIGO
```

Ou seja, temos em primeiro lugar o valor armazenado na quarta posição, `69`, e, em seguida, o tamanho do nosso array, que possui um total de 5 posições.

Veremos agora como podemos inicializar um array dentro de um laço. Primeiro, apagaremos todo o código referente a inicialização que acabamos de criar.

Definiremos a primeira posição como `0`, portanto, `i = 0`. O limite do laço será o número de posições, assim, utilizaremos o atributo que acabamos de aprender `idades.length`. Por fim, incrementaremos com o `i++`:

```
package br.com.bytebank.banco.test;

public class Teste {

        //Array []
        public static void main(String[] args) {

            int[]idades = new int[5]; //inicializa o array com os valores padroes

            for(int i = 0; i < idades.length; i++) {

            }

        }
}COPIAR CÓDIGO
```

O próximo passo é a inicialização do array, dentro do laço.

Como `i` representa as posições, é esta variável que utilizaremos na inicialização, e que receberá `i * i`:

```
package br.com.bytebank.banco.test;

public class Teste {

        //Array []
        public static void main(String[] args) {

            int[]idades = new int[5]; //inicializa o array com os valores padroes

            for(int i = 0; i < idades.length; i++) {
                idades[i] = i * i;

            }

        }
}COPIAR CÓDIGO
```

Em seguida, teremos o mesmo laço, mas dentro desta segunda representação faremos a impressão dos valores:

```
package br.com.bytebank.banco.test;

public class Teste {

        //Array []
        public static void main(String[] args) {

            int[]idades = new int[5]; //inicializa o array com os valores padroes

            for(int i = 0; i < idades.length; i++) {
                idades[i] = i * i;
            }

            for(int i = 0; i < idades.length; i++) {
                System.out.println(idades[i]);
            }

        }
}COPIAR CÓDIGO
```

Executaremos, e temos o seguinte resultado no console:

```
0
1
4
9
16COPIAR CÓDIGO
```

Funcionou! Assim, conseguimos utilizar o array, também, com um laço.

Ainda não vimos o porquê da existência do `String[]` na assinatura do método `main`, mas chegaremos lá. Primeiro, precisamos entender o que são arrays de referências.