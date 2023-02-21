# Aula 01 - Autoboxing e Unboxing

> Você pode fazer o DOWNLOAD do projeto da aula anterior.
> 

Anteriormente, falamos um pouco sobre o mundo das coleções. Neste, daremos continuidade à exploração do pacote `java.util` com foco nas listas.

No pacote `br.com.bytebank.banco.test.util` criaremos uma nova classe, chamada `Teste`:

```
package br.com.bytebank.banco.test.util;

public class Teste {

        public static void main(String[] args) {

        }
}COPIAR CÓDIGO
```

No início do curso, quando começamos a falar sobre estrutura de dados, aprendemos sobre os arrays. O primeiro que criamos foi do tipo `int`, primitivo, onde utilizamos os colchetes (`[]`), da seguinte forma:

```
package br.com.bytebank.banco.test.util;

public class Teste {

        public static void main(String[] args) {

                int[] idades = new int[5];

        }
}COPIAR CÓDIGO
```

Trata-se da sintaxe padrão do array, onde temos um tamanho fixo. Com base nisso, falamos sobre uma série de pontos positivos e negativos deste tipo de lista, entre os negativos estão o tamanho fixo, sintaxe complicada e dificuldade em saber o número de referências efetivamente inseridas - ao passo que descobrir o seu tamanho é relativamente fácil.

Aprendemos sobre as listas, e utilizamos a interface `List`, sempre lembrando de importar o `java.util`. Com isso, criaremos um novo `ArrayList`, `numeros`:

```
package br.com.bytebank.banco.test.util;

public class Teste {

        public static void main(String[] args) {

                int[] idades = new int[5];

                List numeros = new ArrayList();

        }
}COPIAR CÓDIGO
```

Vimos que existem arrays de primitivos, e de referências. Na forma primitiva, eles são declarados na modalidade apresentada acima, enquanto que, em referência, utilizamos a classe como tipo para defini-lo, por exemplo:

```
package br.com.bytebank.banco.test.util;

public class Teste {

        public static void main(String[] args) {

                int[] idades = new int[5];

                String[] nomes = new String[5];

                List numeros = new ArrayList();

        }
}COPIAR CÓDIGO
```

Nos arrays primitivos, cada casa guarda o valor primitivo, enquanto que no array de referência, cada uma armazena a referência que é utilizada para encontrá-lo. Contudo, no mundo das listas, elas só podem ser de referências. Só existem coleções de referências.

Contudo, um problema surgirá disso. Criaremos uma variável que guardará um valor primitivo:

```
package br.com.bytebank.banco.test.util;

public class Teste {

        public static void main(String[] args) {

                int[] idades = new int[5];

                String[] nomes = new String[5];

                int idade = 29;
                List numeros = new ArrayList();

        }
}COPIAR CÓDIGO
```

Dentro dela, temos o valor `29`, que é um primitivo. Queremos armazená-lo em uma lista, e daí surge o problema, a lista só é capaz de guardar referências.

Ao chamarmos o método `add()`, veremos que o Eclipse mostra que ele já espera receber uma referência do tipo `Object`, ou seja, se tentarmos adicionar o primitivo idade:

```
package br.com.bytebank.banco.test.util;

public class Teste {

        public static void main(String[] args) {

                int[] idades = new int[5];

                String[] nomes = new String[5];

                int idade = 29;
                List numeros = new ArrayList();
                numeros.add(idade);

        }
}COPIAR CÓDIGO
```

Não deveria funcionar, porque `idade` não é uma referência, logo, não é compatível com o tipo `Object`.

Inicialmente, isto realmente não funcionava, contudo, atualmente o Java cria uma solução sem que seja necessária nenhuma ação por parte do programador.

Para cada primitivo no mundo Java, existe algo que o representa no mundo orientado a objetos. Isso significa que, para cada tipo primitivo, há uma classe que o representa.

Por exemplo, para representar o `int` primitivo, existe a classe `Integer`:

```
package br.com.bytebank.banco.test.util;

public class Teste {

        public static void main(String[] args) {

                int[] idades = new int[5];

                String[] nomes = new String[5];

                int idade = 29;//Integer
                List numeros = new ArrayList();
                numeros.add(idade);

        }
}COPIAR CÓDIGO
```

Internamente, o Java transforma o primitivo em um objeto, e armazena a referência no array.

```
package br.com.bytebank.banco.test.util;

public class Teste {

        public static void main(String[] args) {

                int[] idades = new int[5];

                String[] nomes = new String[5];

                int idade = 29;//Integer
                Integer idadeRef = new Integer(29);
                List numeros = new ArrayList();
                numeros.add(idade);

        }
}COPIAR CÓDIGO
```

Como havíamos falado, parametrizar o `ArrayList` é uma boa prática para nossas coleções, e para isso utilizamos os *generics*, representados pelos símbolos de menor e maior (`<>`). Desta forma garantimos maior segurança, já que afastamos problemas de cast. Se tentarmos inserir um *generics* de `int`, não funcionará:

```
package br.com.bytebank.banco.test.util;

public class Teste {

        public static void main(String[] args) {

                int[] idades = new int[5];

                String[] nomes = new String[5];

                int idade = 29;//Integer
                Integer idadeRef = new Integer(29);
                List<int> numeros = new ArrayList<int>();
                numeros.add(idade);

        }
}COPIAR CÓDIGO
```

Simplesmente porque `int` é um primitivo, não uma referência. Assim, o certo é utilizarmos o `Integer`:

```
package br.com.bytebank.banco.test.util;

public class Teste {

        public static void main(String[] args) {

                int[] idades = new int[5];

                String[] nomes = new String[5];

                int idade = 29;//Integer
                Integer idadeRef = new Integer(29);
                List<Integer> numeros = new ArrayList<Integer>();
                numeros.add(idade);

        }
}COPIAR CÓDIGO
```

Assim, estamos utilizando a classe que representa este número primitivo no mundo orientado a objetos.

Se trocarmos `idade` por `29`, no método `add()`:

```
package br.com.bytebank.banco.test.util;

public class Teste {

        public static void main(String[] args) {

                int[] idades = new int[5];

                String[] nomes = new String[5];

                int idade = 29;//Integer
                Integer idadeRef = new Integer(29);
                List<Integer> numeros = new ArrayList<Integer>();
                numeros.add(29);

        }
}COPIAR CÓDIGO
```

Ainda assim o código continuará funcionando, pois o Java cria um objeto para o `29`, automaticamente, e armazena sua referência no array. A ideia é auxiliar a transformar um primitivo em objeto, e vice versa. Esta transformação, que ocorre sempre automaticamente, é chamada de ***Autoboxing***.

Adiante, nos aprofundaremos no funcionamento da classe `Integer`. Até a próxima!