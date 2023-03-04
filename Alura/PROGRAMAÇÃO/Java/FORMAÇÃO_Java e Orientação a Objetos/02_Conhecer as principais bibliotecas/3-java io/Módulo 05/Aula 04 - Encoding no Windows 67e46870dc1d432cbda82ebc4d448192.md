# Aula 04 - Encoding no Windows

Como havíamos falado anteriormente, veremos o funcionamento do Java em diferentes sistemas operacionais. Começaremos pelo Windows. Já temos todas as instalações necessárias e importamos o projeto com o qual trabalhávamos.

Na janela "Package Explorer", localizada na lateral esquerda da tela, clicaremos com o botão direito do mouse, e selecionaremos a opção "Import...> General > Existing Projects into Workspace".

Surgirá uma caixa de diálogo, com a opção "Select archive file", escolheremos o [arquivo](https://s3.amazonaws.com/caelum-online-public/857-java-io/05/java7-aula5.zip) `java7-aula5.zip`.

Pode ser que apareça uma exclamação vermelha no ícone do arquivo, isso acontece pois é comum haver diferenças entre as configurações de um computador para o outro.

Clicaremos com o botão direito do mouse sobre o nome do arquivo `java-io`, selecionaremos a opção "Buil Path > Configure Build Path...". Surgirá uma caixa de diálogo, onde temos uma aba chamada "Libraries" com uma pasta `Classpath`.

Clicaremos sobre a pasta e temos uma subpasta, com o nome `JRE System Library [Java SE 10.0.0] (unbound)`. Removeremos este último item, e adicionaremos a JRE instalada em nosso sistema.

Na lateral direita, selecionaremos a opção "Add Library", em seguida, "JRE System Library". Clicaremos em "Next", e selecionaremos "Workspace default JRE (jre-10.0.1)". Para concluir, clicaremos em "Finish" e "Apply".

Com isso, temos todos os arquivos com os quais estávamos trabalhando no outro computador.

Na pasta `br.com.alura.java.io.teste` criaremos uma nova classe, chamada `TesteUnicodeEEncoding`, com um método `main` já estabelecido. Nela teremos uma `String`, `s`, que receberá a letra `"C"`:

```
package br.com.alura.java.io.teste;

public class TesteUnicodeEEncoding {

        public static void main(String[] args) {

                String s = "C";

        }
}COPIAR CÓDIGO
```

Em seguida, faremos um `System.out.println()` para descobrirmos qual é o *codepoint*, que é o número associado na tabela de *unicodes*. Ao digitarmos, ele aparece como `codePointAt()` pois o `String` pode ser uma série de caracteres:

```
//Código omitido

public class TesteUnicodeEEncoding {

        public static void main(String[] args) {

                String s = "CCCC";

                System.out.println(s.codePointAt(arg0));

        }
}COPIAR CÓDIGO
```

Precisamos especificar a posição exata, que no caso será `0`. E manteremos o caractere `"C"`:

```
//Código omitido

public class TesteUnicodeEEncoding {

        public static void main(String[] args) {

                String s = "C";

                System.out.println(s.codePointAt(0));

        }
}COPIAR CÓDIGO
```

Executando o código, temos o seguinte resultado no console:

```
67COPIAR CÓDIGO
```

Correspondente ao número que vimos na tabela ASCII, e que também vale para a tabela *unicode*. A diferença é que o unicode é apenas o mapeamento do caractere, e não nos fornece a informação de como armazenar este, isso é o trabalho do *encoding*.

Sendo assim, temos que descobrir qual *encoding* é utilizado por padrão pelo Java. A primeira coisa que precisamos considerar é que isso varia de acordo com o sistema operacional, o Java se adapta de acordo com o SO.

Como estamos trabalhando com o Windows, para descobrirmos, utilizamos uma classe que representa o *encoding*, chamada de `Charset`, que em uma tradução simplificada pode ser compreendida como um conjunto de caracteres. Esta por sua vez contém uma série de métodos estáticos, dentre eles o `defaultCharset()`, que nos interessa, quando estamos falando em descobrir qual é o *encoding* padrão.

Nosso retorno será, também, um `Charset`:

```
//Código omitido

public class TesteUnicodeEEncoding {

        public static void main(String[] args) {

                String s = "C";
                System.out.println(s.codePointAt(0));

                Charset charset = Charset.defaultCharset();
        }
}COPIAR CÓDIGO
```

Por meio do `Charset`, podemos utilizar um novo método que imprima o seu nome, que é o `charset.displayName()`:

```
//Código omitido

public class TesteUnicodeEEncoding {

        public static void main(String[] args) {

                String s = "C";
                System.out.println(s.codePointAt(0));

                Charset charset = Charset.defaultCharset();
                System.out.println(charset.displayName());
        }
}COPIAR CÓDIGO
```

Executamos. No console, é exibido o seguinte:

```
67
windows-1252COPIAR CÓDIGO
```

Funcionou. Desta forma, descobrimos que o *encoding* utilizado é o `windows-1252`.

É importante termos esta informação pois, é este `charset` que define como traduzir o *codepoint* em uma sequência de bits e bytes.

A partir da `String s` é possível utilizarmos um `get` - padrão - para obtermos os bytes:

```
//Código omitido

public class TesteUnicodeEEncoding {

        public static void main(String[] args) {

                String s = "C";
                System.out.println(s.codePointAt(0));

                Charset charset = Charset.defaultCharset();
                System.out.println(charset.displayName());

                s.getBytes();
        }
}COPIAR CÓDIGO
```

Com o cursor sobre o método `get`, utilizaremos o atalho "Ctrl + 1" para criarmos uma variável local, da seguinte forma:

```
//Código omitido

public class TesteUnicodeEEncoding {

        public static void main(String[] args) {

                String s = "C";
                System.out.println(s.codePointAt(0));

                Charset charset = Charset.defaultCharset();
                System.out.println(charset.displayName());

                byte[] bytes = s.getBytes();
        }
}COPIAR CÓDIGO
```

Será utilizado o *encoding* padrão, que como vimos, é o `windows-1252`, para a criação dos bytes. Para verificarmos se tudo está funcionando, faremos a impressão do tamanho do array, utilizando o `bytes.length`, e concatenaremos com `charset` utilizado, no caso o `windows-1252`:

```
//Código omitido

public class TesteUnicodeEEncoding {

        public static void main(String[] args) {

                String s = "C";
                System.out.println(s.codePointAt(0));

                Charset charset = Charset.defaultCharset();
                System.out.println(charset.displayName());

                byte[] bytes = s.getBytes();
                System.out.println(bytes.length + ", windows-1252");
        }
}COPIAR CÓDIGO
```

Executando, temos o seguinte resultado no console:

```
67
windows-1252
1, windows-1252COPIAR CÓDIGO
```

Além disso, é possível também definirmos o `charset` que gostaríamos de utilizar, independentemente do padrão. Para isso, utilizamos o método `getBytes()` cujo parâmetro recebe uma `String` referente ao `charsetName`, ou seja, o nome do `charset` - definiremos como a `String` `windows-1252`.

Precisamos estabelecer o `throws` com a exceção `UnsupportedEncodingException` para nos assegurarmos de que o `charset` existe:

```
//Código omitido

public class TesteUnicodeEEncoding {

        public static void main(String[] args) throws UnsupportedEncodingException {

                String s = "C";
                System.out.println(s.codePointAt(0));

                Charset charset = Charset.defaultCharset();
                System.out.println(charset.displayName());

                byte[] bytes = s.getBytes("windows-1252");
                System.out.println(bytes.length + ", windows-1252");
        }
}COPIAR CÓDIGO
```

Testando novamente, temos o mesmo resultado no console:

```
67
windows-1252
1, windows-1252COPIAR CÓDIGO
```

Em seguida, utilizando o mesmo código como base, testaremos um novo `charset`, no caso, o `UTF-16`:

```
//Código omitido

public class TesteUnicodeEEncoding {

        public static void main(String[] args) throws UnsupportedEncodingException {

                String s = "C";
                System.out.println(s.codePointAt(0));

                Charset charset = Charset.defaultCharset();
                System.out.println(charset.displayName());

                byte[] bytes = s.getBytes("windows-1252");
                System.out.println(bytes.length + ", windows-1252");

                bytes = s.getBytes("UTF-16");
                System.out.println(bytes.length + ", UTF-16");
        }
}COPIAR CÓDIGO
```

Executaremos, e temos o seguinte resultado no console:

```
67
windows-1252
1, windows-1252
4, UTF-16COPIAR CÓDIGO
```

Podemos testar com o `UTF-8`, e veremos que o tamanho é de 1 byte. Manteremos em `UTF-16`.

Veremos uma nova forma de acessar um `Charset`. Isto pode ser feito por intermédio de uma classe chamada `StandardCharsets`, do pacote `java.nio.charset`, onde `nio` significa novo `io`, novas formas de input e output. Nesta classe há algumas constantes, utilizaremos a `US_ASCII`, e imprimiremos a mesma:

```
//Código omitido

public class TesteUnicodeEEncoding {

        public static void main(String[] args) throws UnsupportedEncodingException {

                String s = "C";
                System.out.println(s.codePointAt(0));

                Charset charset = Charset.defaultCharset();
                System.out.println(charset.displayName());

                byte[] bytes = s.getBytes("windows-1252");
                System.out.println(bytes.length + ", windows-1252");

                bytes = s.getBytes("UTF-16");
                System.out.println(bytes.length + ", UTF-16");

                bytes = s.getBytes(StandardCharsets.US_ASCII);
                System.out.println(bytes.length + ", US-ASCII");

        }
}COPIAR CÓDIGO
```

Executando, temos o seguinte resultado:

```
67
windows-1252
1, windows-1252
4, UTF-16
1, US-ASCIICOPIAR CÓDIGO
```

A seguir, veremos como transformar a representação binária em uma `String`, para uma destas `Charsets`. Para isso, utilizaremos o construtor da classe `String`.

Sendo assim, teremos `new String()`, e com o atalho "Ctrl + Barra de Espaço" nos será apresentada uma lista de diferentes tipos de parâmetros possíveis:

```
//Código omitido

public class TesteUnicodeEEncoding {

        public static void main(String[] args) throws UnsupportedEncodingException {

                String s = "C";
                System.out.println(s.codePointAt(0));

                Charset charset = Charset.defaultCharset();
                System.out.println(charset.displayName());

                byte[] bytes = s.getBytes("windows-1252");
                System.out.println(bytes.length + ", windows-1252");
                new String();

                bytes = s.getBytes("UTF-16");
                System.out.println(bytes.length + ", UTF-16");

                bytes = s.getBytes(StandardCharsets.US_ASCII);
                System.out.println(bytes.length + ", US-ASCII");

        }
}COPIAR CÓDIGO
```

Utilizaremos a que recebe bytes, e nos retorna uma nova `String`. Para visualiza-la, a imprimiremos:

```
//Código omitido

public class TesteUnicodeEEncoding {

        public static void main(String[] args) throws UnsupportedEncodingException {

                String s = "C";
                System.out.println(s.codePointAt(0));

                Charset charset = Charset.defaultCharset();
                System.out.println(charset.displayName());

                byte[] bytes = s.getBytes("windows-1252");
                System.out.println(bytes.length + ", windows-1252");
                String sNovo = new String(bytes);
                System.out.println(sNovo);

                bytes = s.getBytes("UTF-16");
                System.out.println(bytes.length + ", UTF-16");

                bytes = s.getBytes(StandardCharsets.US_ASCII);
                System.out.println(bytes.length + ", US-ASCII");

        }
}COPIAR CÓDIGO
```

Executaremos, e temos o seguinte resultado no console:

```
67
windows-1252
1, windows-1252
C
4, UTF-16
1, US-ASCIICOPIAR CÓDIGO
```

Vemos que a letra "C" foi imprimida, portanto, funcionou. Mas qual foi o `Charset` utilizado ao transformar para a classe `String`? Justamente o padrão, ou seja, `windows-1252`.

Contudo, assim como fizemos anteriormente, também é possível definir o `Charset` explicitamente. Para fazer isto, basta separarmos por vírgulas e colocarmos o nome do `Charset` entre aspas (`""`), da seguinte forma:

```
//Código omitido

public class TesteUnicodeEEncoding {

        public static void main(String[] args) throws UnsupportedEncodingException {

                String s = "C";
                System.out.println(s.codePointAt(0));

                Charset charset = Charset.defaultCharset();
                System.out.println(charset.displayName());

                byte[] bytes = s.getBytes("windows-1252");
                System.out.println(bytes.length + ", windows-1252");
                String sNovo = new String(bytes, "windows-1252");
                System.out.println(sNovo);

                bytes = s.getBytes("UTF-16");
                System.out.println(bytes.length + ", UTF-16");

                bytes = s.getBytes(StandardCharsets.US_ASCII);
                System.out.println(bytes.length + ", US-ASCII");

        }
}COPIAR CÓDIGO
```

Como já estávamos usando este `Charset`, o resultado no console será o mesmo. Faremos o mesmo processo com os demais `Charset`s:

```
//Código omitido

public class TesteUnicodeEEncoding {

        public static void main(String[] args) throws UnsupportedEncodingException {

                String s = "C";
                System.out.println(s.codePointAt(0));

                Charset charset = Charset.defaultCharset();
                System.out.println(charset.displayName());

                byte[] bytes = s.getBytes("windows-1252");
                System.out.println(bytes.length + ", windows-1252");
                String sNovo = new String(bytes, "windows-1252");
                System.out.println(sNovo);

                bytes = s.getBytes("UTF-16");
                System.out.println(bytes.length + ", UTF-16");
                sNovo = new String(bytes, "windows-1252");
                System.out.println(sNovo);

                bytes = s.getBytes(StandardCharsets.US_ASCII);
                System.out.println(bytes.length + ", US-ASCII");
                sNovo = new String(bytes, "windows-1252");
                System.out.println(sNovo);

        }
}COPIAR CÓDIGO
```

Desta forma estamos criando um problema, pois primeiro temos um `UTF-16`, ou `US_ASCII`, e abaixo estamos forçando o `windows-1252`. Testaremos imprimir desta forma, tirando a quebra de linha nestas duas ocasiões:

```
//Código omitido

public class TesteUnicodeEEncoding {

        public static void main(String[] args) throws UnsupportedEncodingException {

                String s = "C";
                System.out.println(s.codePointAt(0));

                Charset charset = Charset.defaultCharset();
                System.out.println(charset.displayName());

                byte[] bytes = s.getBytes("windows-1252");
                System.out.print(bytes.length + ", windows-1252, ");
                String sNovo = new String(bytes, "windows-1252");
                System.out.println(sNovo);

                bytes = s.getBytes("UTF-16");
                System.out.print(bytes.length + ", UTF-16, ");
                sNovo = new String(bytes, "windows-1252");
                System.out.println(sNovo);

                bytes = s.getBytes(StandardCharsets.US_ASCII);
                System.out.print(bytes.length + ", US-ASCII, ");
                sNovo = new String(bytes, "windows-1252");
                System.out.println(sNovo);
                .
        }
}COPIAR CÓDIGO
```

Executando, temos o seguinte resultado:

```
67
windows-1252
1, windows-1252, C
4, UTF-16,þÿ C
1, US-ASCII, CCOPIAR CÓDIGO
```

Notamos que o *codepoint* não muda, continua `67`. No primeiro exemplo, como não alteramos o `Charset`, temos o `windows-1252`, já no exemplo do `UTF-16` tivemos um problema, apareceram caracteres especiais `þÿ`. Isso aconteceu porque ele recebeu 4 bytes, mas o `windows-1252` tem apenas 1 byte. No `US_ASCII` não tivemos este problema, porque eles são iguais nos caracteres comuns do alfabeto.

Isso pode ser observado de forma prática facilmente. Trocaremo o"C" por "ç":

```
//Código omitido

public class TesteUnicodeEEncoding {

        public static void main(String[] args) throws UnsupportedEncodingException {

                String s = "ç";
                System.out.println(s.codePointAt(0));

                Charset charset = Charset.defaultCharset();
                System.out.println(charset.displayName());

                byte[] bytes = s.getBytes("windows-1252");
                System.out.print(bytes.length + ", windows-1252, ");
                String sNovo = new String(bytes, "windows-1252");
                System.out.println(sNovo);

                bytes = s.getBytes("UTF-16");
                System.out.print(bytes.length + ", UTF-16, ");
                sNovo = new String(bytes, "windows-1252");
                System.out.println(sNovo);

                bytes = s.getBytes(StandardCharsets.US_ASCII);
                System.out.print(bytes.length + ", US-ASCII, ");
                sNovo = new String(bytes, "windows-1252");
                System.out.println(sNovo);
                .
        }
}COPIAR CÓDIGO
```

Executando, temos o seguinte retorno:

```
231
windows-1252
1, windows-1252, ç
4, UTF-16,þÿ ç
1, US-ASCII, ?COPIAR CÓDIGO
```

Tivemos um problema de impressão com o `US_ASCII`, pois ele não define esse tipo de caractere.

Isto é um problema comum, o recebimento de informação em bits e bytes, que acreditamos estar codificado em algo, mas que na realidade não está.

Para que nosso código funcione, precisamos indicar o *encoding* correto, para cada um dos casos respectivamente:

```
//Código omitido

public class TesteUnicodeEEncoding {

        public static void main(String[] args) throws UnsupportedEncodingException {

                String s = "ç";
                System.out.println(s.codePointAt(0));

                Charset charset = Charset.defaultCharset();
                System.out.println(charset.displayName());

                byte[] bytes = s.getBytes("windows-1252");
                System.out.print(bytes.length + ", windows-1252, ");
                String sNovo = new String(bytes, "windows-1252");
                System.out.println(sNovo);

                bytes = s.getBytes("UTF-16");
                System.out.print(bytes.length + ", UTF-16, ");
                sNovo = new String(bytes, "UTF-16");
                System.out.println(sNovo);

                bytes = s.getBytes(StandardCharsets.US_ASCII);
                System.out.print(bytes.length + ", US-ASCII, ");
                sNovo = new String(bytes, "US-ASCII");
                System.out.println(sNovo);
                .
        }
}COPIAR CÓDIGO
```

Executaremos novamente e temos o seguinte resultado:

```
231
windows-1252
1, windows-1252, ç
4, UTF-16, ç
1, US-ASCII, ?COPIAR CÓDIGO
```

O `ASCII` continua apresentando erro, pois a `ç` não está presenta na tabela padrão.

Vimos o *codepoint*, e como ele é imutável, e vimos também os diferentes tipos de *encoding*. Adiante, veremos como aplicar este conhecimento na leitura e escrita de arquivos, o que acontece na prática no celular ou mesmo no navegador.