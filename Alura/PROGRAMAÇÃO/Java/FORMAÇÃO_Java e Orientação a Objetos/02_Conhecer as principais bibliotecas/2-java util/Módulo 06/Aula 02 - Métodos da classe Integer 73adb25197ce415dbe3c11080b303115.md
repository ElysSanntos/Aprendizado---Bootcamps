# Aula 02 - Métodos da classe Integer

Continuando o que havíamos falado anteriormente, no Java, há uma classe para cada tipo primitivo. Para o `int`, há uma classe `Integer`.

A transformação do tipo primitivo para o objeto referência acontece automaticamente, e é chamada de ***autoboxing***. O caminho inverso é chamado de ***unboxing***.

As classes que existem para cada tipo primitivo se chamam ***wrappers***. Isso porque elas "embrulham" o tipo primitivo do objeto, que internamente guarda o valor primitivo. Elas existem para que haja compatibilidade com as coleções, nos permitindo, por exemplo, guardar números dentro de uma lista.

Retornaremos à classe `Teste`, no pacote `br.com.bytebank.banco.test.util`.

```
//Código omitido

public class Teste {

        public static void main(String[] args) {

                int[] idades = new int[5];
                String[] nomes = new String[5];

                int idade = 29; //Integer
                Integer idadeRef = new Integer(29);
                List<Integer> numeros = new ArrayList<Integer>();
                numeros.add(29); //Autoboxing

        }

}COPIAR CÓDIGO
```

Tivemos a inicialização da variável, utilizando um primitivo:

```
//Código omitido

int idade = 29;

//Código omitidoCOPIAR CÓDIGO
```

E vimos também a inicialização com o uso de uma classe *wrapper*:

```
//Código omitido

Integer idadeRef = new ~Integer~(29);

//Código omitidoCOPIAR CÓDIGO
```

Percebemos que a classe `Integer` aparece riscada, o que indicada que este construtor não deveria mais estar sendo utilizado. Mas então, como construiremos o objeto? Neste caso, o construtor é descontinuado, surge a mensagem de que "*The constructor Int3eger(int) is deprecated*".

Neste caso, para criarmos um objeto, temos que utilizar a classe, com o método estático `valueOf()`, que receberá um primitivo `int`:

```
//Código omitido

public class Teste {

        public static void main(String[] args) {

                int[] idades = new int[5];
                String[] nomes = new String[5];

                int idade = 29;

                Integer idadeRef = Integer.valueOf(29);

                List<Integer> numeros = new ArrayList<Integer>();
                numeros.add(29); //Autoboxing

        }

}COPIAR CÓDIGO
```

Ao utilizarmos o `new` em um objeto, delegamos a criação para um método. Abriremos o método `valueOf()` para visualizarmos sua construção, lembrando que estamos considerando a versão Java 9:

```
//Código omitido
public static Integer valueOf(int i) {
        if(i >= IntegerCache.low && i <= IntegerCache.high)
            return IntegerCache.cache[i + (-IntegerCache.low)];
        return new ~Integer~(i);
}
//Código omitidoCOPIAR CÓDIGO
```

Vemos que, internamente, o método faz com que, caso o `IntegerCache` não funcione, exista um objeto como backup, ou seja, ele usa o construtor `new Integer()`. Podemos perceber que alguns métodos trabalham com ele.

Portanto, o jeito mais adequado de fazermos isso em nosso código é utilizando o método `valueOf()`, e termos como resultado uma referência. A partir desta referência `idadeRef`, podemos chamar métodos. Por exemplo, o `intValue()`.

Temos uma referência, que aponta para um objeto, e queremos obter desta classe *wrapper* - que embrulha o primitivo -, qual o valor que nela está contido. É para isso que o método `intValue()` é utilizado, ele nos devolve, justamente, o primitivo:

```
//Código omitido

public class Teste {

        public static void main(String[] args) {

                int[] idades = new int[5];
                String[] nomes = new String[5];

                int idade = 29;

                Integer idadeRef = Integer.valueOf(29);
                int valor = idadeRef.intValue();

                List<Integer> numeros = new ArrayList<Integer>();
                numeros.add(29); //Autoboxing

        }

}COPIAR CÓDIGO
```

Assim, estamos fazendo o *autoboxing*:

```
//Código omitido

                Integer idadeRef = Integer.valueOf(29);

//Código omitidoCOPIAR CÓDIGO
```

Para, em seguida, fazer o *unboxing*:

```
//Código omitido

int valor = idadeRef.intValue();

//Código omitidoCOPIAR CÓDIGO
```

A classe `Integer` possui uma série de métodos auxiliares. Ela faz parte do pacote `Java.lang` e por isso não foi necessária sua importação.

Lembrando do `String[] args`, imaginemos que estamos recebendo uma `String s`, que está na primeira posição dos `args`:

```
//Código omitido

public class Teste {

        public static void main(String[] args) {

                int[] idades = new int[5];
                String[] nomes = new String[5];

                int idade = 29;

                Integer idadeRef = Integer.valueOf(29);
                int valor = idadeRef.intValue();

                String s = args[0];

                List<Integer> numeros = new ArrayList<Integer>();
                numeros.add(29); //Autoboxing

        }

}COPIAR CÓDIGO
```

Ele recebe um valor numérico, entretanto, todos os valores armazenados em `args` são interpretados como `String`. Isso significa que, se passarmos por exemplo o número `10`, o Java interpretará como `"10"`, entre aspas, representando uma `String`.

Entretanto, queremos descobrir o valor inteiro. Assim, precisamos transformar esta `String` em um `int`, para isso, utilizamos a classe `Integer`, e o método `valueOf()`.

Contudo, ao digitarmos o nome deste método, percebemos que ele existe em três versões, escolheremos aquela que recebe um `String s`:

```
//Código omitido

public class Teste {

        public static void main(String[] args) {

                int[] idades = new int[5];
                String[] nomes = new String[5];

                int idade = 29;

                Integer idadeRef = Integer.valueOf(29);
                int valor = idadeRef.intValue();

                String s = args[0];//"10"

                Integer numero = Integer.valueOf(s);

                List<Integer> numeros = new ArrayList<Integer>();
                numeros.add(29); //Autoboxing

        }

}COPIAR CÓDIGO
```

Em seguida, imprimiremos o número:

```
//Código omitido

public class Teste {

        public static void main(String[] args) {

                int[] idades = new int[5];
                String[] nomes = new String[5];

                int idade = 29;

                Integer idadeRef = Integer.valueOf(29);
                int valor = idadeRef.intValue();

                String s = args[0];//"10"

                Integer numero = Integer.valueOf(s);
                System.out.println(numero);

                List<Integer> numeros = new ArrayList<Integer>();
                numeros.add(29); //Autoboxing

        }

}COPIAR CÓDIGO
```

O código está pronto para testarmos, mas antes, precisamos alterar as *run configurations*. Se não fizermos isso, teremos um erro, já que não passamos nenhum parâmetro para o array `args`, ou seja, ele ainda não tem nenhuma posição.

Ao lado do botão de execução, no menu superior, clicaremos na seta ao lado do botão com símbolo de play, na cor verde e branca, e selecionaremos no menu a opção "Run Configurations...":

![https://caelum-online-public.s3.amazonaws.com/850-java-util/08/-transcricao-compressed_06.02_001_imagem-demonstrativa-da.png](https://caelum-online-public.s3.amazonaws.com/850-java-util/08/-transcricao-compressed_06.02_001_imagem-demonstrativa-da.png)

Selecionaremos a classe `Teste`, com atenção para escolhermos a correta. Na barra de menu superior, selecionaremos a aba "Arguments", e preencheremos os argumentos com o valor `12`. Em seguida, clicaremos em "Apply" e executaremos a classe.

Temos o seguinte resultado no console:

```
12COPIAR CÓDIGO
```

Funcionou! O programa foi capaz de transformar o `String s` em um inteiro `int`. Esta transformação se chama ***parsing***.

Isto é muito comum em situações onde temos um formulário, em que são digitados determinados valores. Estes, normalmente, vêm como `String`s, e é uma tarefa comum do desenvolvedor transformá-los deste tipo para algum outro específico.

Além de termos um objeto e referência `Integer`, podemos também ter um método que cria o primitivo a partir da `String` diretamente, da seguinte forma:

```
//Código omitido

public class Teste {

        public static void main(String[] args) {

                int[] idades = new int[5];
                String[] nomes = new String[5];

                int idade = 29;

                Integer idadeRef = Integer.valueOf(29);
                int valor = idadeRef.intValue();

                String s = args[0];//"10"

                //Integer numero = Integer.valueOf(s);

                int numero = Integer.parseInt(s);

                System.out.println(numero);

                List<Integer> numeros = new ArrayList<Integer>();
                numeros.add(29); //Autoboxing

        }

}COPIAR CÓDIGO
```

Executaremos a classe novamente, e temos o mesmo resultado no console.

A classe `Integer` possui diversos métodos auxiliares, mas alguns que são essenciais são o `valueOf(int i)`, que corresponde ao *autoboxing*, `intValue()`, para o *unboxing*, `valueOf(String s)` e `parseInt()`.

Temos ainda um método que nos permite transformar um `Integer` para outros primitivos, por exemplo, em um `double`, neste caso, utilizamos o `doubleValue()`:

```
//Código omitido

public class Teste {

        public static void main(String[] args) {

                int[] idades = new int[5];
                String[] nomes = new String[5];

                int idade = 29;

                Integer idadeRef = Integer.valueOf(29); //autoboxing

                System.out.println(idadeRef.doubleValue());

                int valor = idadeRef.intValue(); //unboxing

                String s = args[0];//"10"

                //Integer numero = Integer.valueOf(s);

                int numero = Integer.parseInt(s);

                System.out.println(numero);

                List<Integer> numeros = new ArrayList<Integer>();
                numeros.add(29); //Autoboxing

        }

}COPIAR CÓDIGO
```

Ao executarmos a classe, temos o seguinte resultado no console:

```
29.0
12COPIAR CÓDIGO
```

Além disso, e removendo trechos de código que não são mais relevantes, veremos também algumas constantes. Em alguns casos, precisaremos estabelecer, por exemplo, valores mínimos e máximos para que sirvam de parâmetros em alguma regra de negócio específica'. Para sabermos, por exemplo, o valor máximo, podemos utilizar `MAX_VALUE`:

```
//Código omitido

public class Teste {

        public static void main(String[] args) {

                int idade = 29;
                Integer idadeRef = Integer.valueOf(29); //autoboxing
                System.out.println(idadeRef.doubleValue());

                System.out.println(Integer.MAX_VALUE);

                int valor = idadeRef.intValue(); //unboxing
                String s = args[0];//"10"
                //Integer numero = Integer.valueOf(s);
                int numero = Integer.parseInt(s);
                System.out.println(numero);

                List<Integer> numeros = new ArrayList<Integer>();
                numeros.add(29); //Autoboxing

        }

}COPIAR CÓDIGO
```

Cada `Integer` é capaz de um certo limite de armazenamento, de 4 Bytes. Assim, executaremos a classe, e temos o seguinte resultado no console:

```
29.0
2147483647
12COPIAR CÓDIGO
```

Para descobrirmos o valor mínimo, utilizamos o `MIN_VALUE`:

```
//Código omitido

public class Teste {

        public static void main(String[] args) {

                int idade = 29;
                Integer idadeRef = Integer.valueOf(29); //autoboxing
                System.out.println(idadeRef.doubleValue());

                System.out.println(Integer.MIN_VALUE);

                int valor = idadeRef.intValue(); //unboxing
                String s = args[0];//"10"
                //Integer numero = Integer.valueOf(s);
                int numero = Integer.parseInt(s);
                System.out.println(numero);

                List<Integer> numeros = new ArrayList<Integer>();
                numeros.add(29); //Autoboxing

        }

}COPIAR CÓDIGO
```

Executando a classe, temos o seguinte resultado:

```
29.0
-2147483648
12COPIAR CÓDIGO
```

Podemos, ainda, descobrir o tamanho do `Integer`, utilizando o `SIZE`:

```
//Código omitido

public class Teste {

        public static void main(String[] args) {

                int idade = 29;
                Integer idadeRef = Integer.valueOf(29); //autoboxing
                System.out.println(idadeRef.doubleValue());

                System.out.println(Integer.MAX_VALUE);
                System.out.println(Integer.MIN_VALUE);

                System.out.println(Integer.SIZE);

                int valor = idadeRef.intValue(); //unboxing
                String s = args[0];//"10"
                //Integer numero = Integer.valueOf(s);
                int numero = Integer.parseInt(s);
                System.out.println(numero);

                List<Integer> numeros = new ArrayList<Integer>();
                numeros.add(29); //Autoboxing

        }

}COPIAR CÓDIGO
```

Executaremos a classe, e temos o seguinte resultado no console:

```
29.0
2147483648
-2147483648
32
12COPIAR CÓDIGO
```

Indicando um tamanho de 32 bits. Se quisermos saber a quantidade de bytes, utilizamos o `BYTES`:

```
//Código omitido

public class Teste {

        public static void main(String[] args) {

                int idade = 29;
                Integer idadeRef = Integer.valueOf(29); //autoboxing
                System.out.println(idadeRef.doubleValue());

                System.out.println(Integer.MAX_VALUE);
                System.out.println(Integer.MIN_VALUE);

                System.out.println(Integer.SIZE);
                System.out.println(Integer.BYTES);

                int valor = idadeRef.intValue(); //unboxing
                String s = args[0];//"10"
                //Integer numero = Integer.valueOf(s);
                int numero = Integer.parseInt(s);
                System.out.println(numero);

                List<Integer> numeros = new ArrayList<Integer>();
                numeros.add(29); //Autoboxing

        }

}COPIAR CÓDIGO
```

Executaremos a classe, e temos o seguinte resultado no console:

```
29.0
2147483648
-2147483648
32
4
12COPIAR CÓDIGO
```

Indicando um total de 4 Bytes, como havia sido mencionado anteriormente.

Por todos estes motivos, é válido estudar [documentação](https://docs.oracle.com/javase/7/docs/api/java/lang/Integer.html) Java referente a este ponto.

Adiante, veremos outros exemplos de *wrappers*. Até a próxima!