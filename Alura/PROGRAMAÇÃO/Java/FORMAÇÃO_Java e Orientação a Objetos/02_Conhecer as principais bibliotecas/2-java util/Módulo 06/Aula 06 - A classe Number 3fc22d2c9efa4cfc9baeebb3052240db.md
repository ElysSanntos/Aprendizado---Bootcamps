# Aula 06 - A classe Number

Nesta aula, dando continuidade às anteriores, veremos mais alguns exemplos de classes *wrappers*.

Na tabela abaixo, temos alguns tipos primitivos e as classes às quais estão associados:

| Tamanho | Tipo primitivo | Wrappers |
| --- | --- | --- |
| 8 bytes | double | java.lang.Double |
| 4 bytes | float | java.lang.Float |
| 8 bytes | long | java.lang.Long |
| 4 bytes | int | java.lang.Integer |
| 2 bytes | short | java.lang.Short |
| 1 bytes | byte | java.lang.Byte |
| 2 bytes | char | java.lang.Character |
|  | boolean | java.lang.Boolean |

Sendo que, `double` e `float` são flutuantes, `long`, `int`, `short` e `byte` são inteiros, `char` representa um caractere, e por fim, temos um booleano.

Temos a informação do tamanho do tipo primitivo. Mas, o tamanho do objeto nos é desconhecido, ele será criado pela máquina virtual na memória posteriormente, e não fica a cargo do desenvolvedor Java.

Renomearemos a classe `Teste` do pacote `br.com.bytebank.banco.test.util`, ela passará a se chamar `TesteWrapperInteger`. No mesmo pacote, criaremos uma nova classe, chamada `TesteOutrosWrappers`, que também terá o *autoboxing* e o *unboxing*:

```
package br.com.bytebank.banco.test.util;

public class TesteOutrosWrappers {

        public static void main(String[] args) {

                Integer idadeRef = Integer.valueOf(29); //autoboxing
                System.out.println(idadeRef.intValue()); //unboxing

        }
}COPIAR CÓDIGO
```

Teremos um `double`, que chamaremos de `dRef`, e cujo valor será `3.2`, basta escrevermos o valor que o Java entenderá como um `double`, e fará o *autoboxing*:

```
package br.com.bytebank.banco.test.util;

public class TesteOutrosWrappers {

        public static void main(String[] args) {

                Integer idadeRef = Integer.valueOf(29); //autoboxing
                System.out.println(idadeRef.intValue()); //unboxing

                Double dRef = 3.2;
        }
}COPIAR CÓDIGO
```

Internamente, o Java utiliza a classe *wrapper* `Double`, e o método `valueOf()`:

```
package br.com.bytebank.banco.test.util;

public class TesteOutrosWrappers {

        public static void main(String[] args) {

                Integer idadeRef = Integer.valueOf(29); //autoboxing
                System.out.println(idadeRef.intValue()); //unboxing

                Double dRef = Double.valueOf(3.2);
        }
}COPIAR CÓDIGO
```

Em seguida, utilizando `System.out.println()`, faremos o *unboxing*:

```
package br.com.bytebank.banco.test.util;

public class TesteOutrosWrappers {

        public static void main(String[] args) {

                Integer idadeRef = Integer.valueOf(29); //autoboxing
                System.out.println(idadeRef.intValue()); //unboxing

                Double dRef = Double.valueOf(3.2);//autoboxing
                System.out.println(dRef.doubleValue());//unboxing
        }
}COPIAR CÓDIGO
```

No primeiro caso, utilizamos um `intValue()`, enquanto que no segundo, um `doubleValue()`. Executaremos a classe e temos o seguinte resultado no console:

```
29
3.2COPIAR CÓDIGO
```

Tudo está funcionando corretamente.

Em seguida, faremos mais um teste, desta vez com o tipo `boolean`. Este possui uma particularidade, já que deve possuir dois valores, um para representar o verdadeiro, `true`, e outro que representa o falso, `false`. Eles já existem, como constantes, `TRUE` e `FALSE`.

> Importante notar que, no Java, as constantes são sempre escritas em letras maiúsculas.
> 

Assim como anteriormente, faremos o *unboxing* utilizando o `booleanValue()`:

```
package br.com.bytebank.banco.test.util;

public class TesteOutrosWrappers {

        public static void main(String[] args) {

                Integer idadeRef = Integer.valueOf(29); //autoboxing
                System.out.println(idadeRef.intValue()); //unboxing

                Double dRef = Double.valueOf(3.2);//autoboxing
                System.out.println(dRef.doubleValue());//unboxing

                Boolean bRef = Boolean.FALSE;
                System.out.println(bRef.booleanValue());
        }
}COPIAR CÓDIGO
```

Poderíamos, também, ter utilizado o valor primitivo `false` e contar com o Java para que ele criasse o tipo automaticamente. Executaremos a classe:

```
29
3.2
falseCOPIAR CÓDIGO
```

E o resultado no console nos indica que tudo está funcionando corretamente.

Como havíamos mencionado, temos tipos flutuantes e inteiros, e o que eles têm em comum é que ambos são numéricos. Assim, há uma classe mãe que os conecta, a `java.lang.Number`. Seguinte este conceito, as seguintes classes a estendem: `Double`, `Float`, ambas flutuantes, `Long`, `Integer`, `Short` e `Byte`, representando os inteiros.

Em nosso código, isso significa que podemos utilizar a classe `Number` para criar uma referência:

```
package br.com.bytebank.banco.test.util;

public class TesteOutrosWrappers {

        public static void main(String[] args) {

                Integer idadeRef = Integer.valueOf(29); //autoboxing
                System.out.println(idadeRef.intValue()); //unboxing

                Double dRef = Double.valueOf(3.2);//autoboxing
                System.out.println(dRef.doubleValue());//unboxing

                Boolean bRef = Boolean.FALSE;
                System.out.println(bRef.booleanValue());

                Number refNumero = Integer.valueOf(29);
        }
}COPIAR CÓDIGO
```

No caso criamos um `int`, mas também poderíamos ter utilizado qualquer outro tipo, como `double`, por exemplo. O que temos neste caso é uma referência genérica, capaz de referenciar tipos mais específicos.

Pensando em herança, e no polimorfismo, quais seriam então os métodos definidos pela classe `Number`? Há diversos, dentre eles, podemos citar `byteValue()`, `doubleValue()` e `floatValue()`, todos métodos que já estudamos quando abordamos a classe `Integer`.

Esta classe pode ser útil, por exemplo, se quisermos criar uma lista que aceite qualquer tipo de valor numérico, para isso, poderíamos fazer o seguinte:

```
package br.com.bytebank.banco.test.util;

public class TesteOutrosWrappers {

        public static void main(String[] args) {

                Integer idadeRef = Integer.valueOf(29); //autoboxing
                System.out.println(idadeRef.intValue()); //unboxing

                Double dRef = Double.valueOf(3.2);//autoboxing
                System.out.println(dRef.doubleValue());//unboxing

                Boolean bRef = Boolean.FALSE;
                System.out.println(bRef.booleanValue());

                Number refNumero = Integer.valueOf(29);

                List<Number> lista = new ArrayList<>();
        }
}COPIAR CÓDIGO
```

Sendo que não há necessidade de repetirmos a palavra `Number` no lado direito do construtor.

Com isso, temos uma lista em que podemos guardar tanto um `int`, quanto um `double`, ou ainda um `float`:

```
package br.com.bytebank.banco.test.util;

public class TesteOutrosWrappers {

        public static void main(String[] args) {

                Integer idadeRef = Integer.valueOf(29); //autoboxing
                System.out.println(idadeRef.intValue()); //unboxing

                Double dRef = Double.valueOf(3.2);//autoboxing
                System.out.println(dRef.doubleValue());//unboxing

                Boolean bRef = Boolean.FALSE;
                System.out.println(bRef.booleanValue());

                Number refNumero = Integer.valueOf(29);

                List<Number> lista = new ArrayList<>();
                lista.add(10);
                lista.add(32.6);
                lista.add(25.6f);
        }
}COPIAR CÓDIGO
```

Isso funciona graças ao uso da classe `Number`, de cunho genérico.

A existência de primitivos e *wrappers* é explicada pelo momento da criação do Java, à época, a capacidade de processamento das máquinas era limitado, e a memória era custosa, portanto, pensando em questões de desempenho, e memória, importante a existência dos primitivos. Eles são mais rápidos, e ocupam menos espaço.

Hoje, isso não é mais um problema, sua existência se justifica apenas historicamente, como um legado.

Até a próxima!