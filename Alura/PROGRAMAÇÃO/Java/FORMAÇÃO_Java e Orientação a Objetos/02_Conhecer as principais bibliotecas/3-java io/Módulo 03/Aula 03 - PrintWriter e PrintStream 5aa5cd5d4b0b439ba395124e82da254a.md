# Aula 03 - PrintWriter e PrintStream

Anteriormente havíamos estabelecido uma nova entrada, usando diretamente um `Writer`. Contudo, é possível atingirmos este mesmo resultado com um código ainda mais simples.

De início, alteraremos o nome da nossa classe, para que evidencia o tipo de teste que estamos fazendo. Ela passará a se chamar `TesteEscritaFileWriter`:

```
//Código omitido

public class TesteEscritaFileWriter {

        //Restante do código omitidoCOPIAR CÓDIGO
```

Como a classe é pública, o compilador indica que há um erro, pois alteramos o nome da classe, e assim ele não corresponde mais ao nome do arquivo. Para resolver este problema, basta renomearmos o arquivo para que tenha o mesmo nome da classe.

Faremos uma cópia da classe `TesteEscritaFileWriter`, e daremos o nome de `TesteEscrita3`, e comentaremos a linha em que temos o `BufferedWriter`:

```java
//Código omitido

public class TesteEscrita3 {

        public static void main(String[] args) throws IOException {

        //Fluxo de Entrada com Arquivo
        //OutputStream fos = new FileOutputStream("lorem2.txt");
        //Writer osw = new OutputStreamWriter(fos);
        //Buff3eredWriter bw = new BufferedWriter(osw);

        //BufferedWriter bw = new BufferedWriter( new FileWriter("lorem2.txt"));

                bw.write("Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod");
        bw.newLine();
        bw.newLine();
        bw.write("asfasdfsafdas dfs sdf asf assdß");

        bw.close();

        }
}COPIAR CÓDIGO
```

Aqui, utilizaremos uma classe chamada `PrintStream`. Por meio dela é possível fazermos uma impressão para um fluxo binário.

> Não podemos esquecer de importar a classe PrintStream.
> 

Ela será representada pela variável `ps`, e terá um construtor que receberá uma `String` com o nome do arquivo:

```
//Código omitido

public class TesteEscrita3 {

        public static void main(String[] args) throws IOException {

        //Fluxo de Entrada com Arquivo
        //OutputStream fos = new FileOutputStream("lorem2.txt");
        //Writer osw = new OutputStreamWriter(fos);
        //Buff3eredWriter bw = new BufferedWriter(osw);

        //BufferedWriter bw = new BufferedWriter(new FileWriter("lorem2.txt"));

                PrintStream ps = new PrintStream("lorem2.txt");

                bw.write("Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod");
        bw.newLine();
        bw.newLine();
        bw.write("asfasdfsafdas dfs sdf asf assdß");

        bw.close();

        }
}COPIAR CÓDIGO
```

Abrindo a classe `PrintStream`, vemos que ela existe desde a versão 1.0 do Java, enquanto as `FileWriter` e `BufferedWriter` entraram somente na versão 1.1. Ou seja, aqueles que desejavam trabalhar com caracteres desde o Java 1.0 utilizavam, necessariamente, a classe `PrintStream`. A partir disso, foram criadas ferramentas mais especializadas.

Agora que temos o `ps`, podemos utiliza-lo para imprimir caracteres, e para isso há o método `println()`. Ele é sobrecarregado, ou seja, possui várias versões e, dentre elas, a que recebe uma `String`, e que utilizaremos para imprimir a primeira linha do nosso arquivo de texto:

```
//Código omitido

public class TesteEscrita3 {

        public static void main(String[] args) throws IOException {

        //Fluxo de Entrada com Arquivo
        //OutputStream fos = new FileOutputStream("lorem2.txt");
        //Writer osw = new OutputStreamWriter(fos);
        //Buff3eredWriter bw = new BufferedWriter(osw);

        //BufferedWriter bw = new BufferedWriter( new FileWriter("lorem2.txt"));

                PrintStream ps = new PrintStream("lorem2.txt");

                ps.println("Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod");

        bw.newLine();
        bw.newLine();
        bw.write("asfasdfsafdas dfs sdf asf assdß");

        bw.close();

        }
}COPIAR CÓDIGO
```

Para criarmos uma quebra de linha, podemos simplesmente imprimir uma nova, utilizando o `println()`, vazio:

```
//Código omitido

public class TesteEscrita3 {

        public static void main(String[] args) throws IOException {

        //Fluxo de Entrada com Arquivo
        //OutputStream fos = new FileOutputStream("lorem2.txt");
        //Writer osw = new OutputStreamWriter(fos);
        //Buff3eredWriter bw = new BufferedWriter(osw);

        //BufferedWriter bw = new BufferedWriter(new FileWriter("lorem2.txt"));

                PrintStream ps = new PrintStream("lorem2.txt");

                ps.println("Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod");
        ps.println();

        bw.newLine();
        bw.newLine();
        bw.write("asfasdfsafdas dfs sdf asf assdß");

        bw.close();

        }
}COPIAR CÓDIGO
```

Por fim, passaremos a segunda linha de texto que queremos imprimir, e fecharemos com a referência `ps`:

```
//Código omitido

public class TesteEscrita3 {

        public static void main(String[] args) throws IOException {

        //Fluxo de Entrada com Arquivo
        //OutputStream fos = new FileOutputStream("lorem2.txt");
        //Writer osw = new OutputStreamWriter(fos);
        //Buff3eredWriter bw = new BufferedWriter(osw);

        //BufferedWriter bw = new BufferedWriter(new FileWriter("lorem2.txt"));

                PrintStream ps = new PrintStream("lorem2.txt");

                ps.println("Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod");
        ps.println();
                ps.println("asfasdfsafdas dfs sdf asf assdß");

        ps.close();

        }
}COPIAR CÓDIGO
```

Salvaremos e executaremos a classe. Abrindo o arquivo `lorem2.txt` vemos que os textos foram impressos sem problemas, indicando que tudo funcionou corretamente.

O `PrintStream` é uma classe de mais alto nível, que aceita uma grande variedade de construtores, como é o caso do `new File()`.

Além disso, temos o `println()` que já inclui um pulo de linha sempre que o utilizamos. Já o conhecíamos do `System.out.println()`, onde `out` nada mais é que um `PrintStream`, só que este não está vinculado a um arquivo específico, e sim ao console. Por isso essa impressão é feita no console.

Temos outra classe, que funciona de forma análoga a essa, e se chama `PrintWriter`. Comentaremos o que havíamos feito, e criaremos um novo `ps`:

```
//Código omitido

public class TesteEscrita3 {

        public static void main(String[] args) throws IOException {

        //Fluxo de Entrada com Arquivo
        //OutputStream fos = new FileOutputStream("lorem2.txt");
        //Writer osw = new OutputStreamWriter(fos);
        //Buff3eredWriter bw = new BufferedWriter(osw);

        //BufferedWriter bw = new BufferedWriter( new FileWriter("lorem2.txt"));
                //PrintStream ps = new PrintStream(new File("lorem2.txt"));

                PrintWriter ps = new PrintWriter();

                ps.println("Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod");
        ps.println();
                ps.println("asfasdfsafdas dfs sdf asf assdß");

        ps.close();

        }
}COPIAR CÓDIGO
```

Ele receberá o nome do arquivo:

```
//Código omitido

public class TesteEscrita3 {

        public static void main(String[] args) throws IOException {

        //Fluxo de Entrada com Arquivo
        //OutputStream fos = new FileOutputStream("lorem2.txt");
        //Writer osw = new OutputStreamWriter(fos);
        //Buff3eredWriter bw = new BufferedWriter(osw);

        //BufferedWriter bw = new BufferedWriter(new FileWriter("lorem2.txt"));
                //PrintStream ps = new PrintStream(new File("lorem2.txt"));

                PrintWriter ps = new PrintWriter("lorem2.txt");

                ps.println("Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod");
        ps.println();
                ps.println("asfasdfsafdas dfs sdf asf assdß");

        ps.close();

        }
}COPIAR CÓDIGO
```

Salvaremos e executaremos, temos o mesmo resultado. Continua funcionando perfeitamente.

Como os `Writers` e `Readers` foram criados após o `Stream`, eles têm funções muito similares. Inicialmente existia somente o `PrintStream`, mas como depois surgiu o mundo de `Writers`, viu-se a necessidade de criar um `PrintWriter`, este que não precisa utilizar um `Stream` internamente.

Falamos aqui sobre a saída e, adiante, falaremos sobre a entrada. Até lá!