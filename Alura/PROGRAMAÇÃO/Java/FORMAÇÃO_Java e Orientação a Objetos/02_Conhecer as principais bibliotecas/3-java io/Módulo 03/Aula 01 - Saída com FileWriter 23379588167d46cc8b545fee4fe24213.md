# Aula 01 - Saída com FileWriter

> Caso queira, você pode fazer o [download](https://s3.amazonaws.com/caelum-online-public/857-java-io/03/java7-aula3.zip) do projeto completo feito até a aula anterior.
> 

Anteriormente, havíamos criado a classe `TesteEscrita`, onde estabelecemos uma entrada de texto, análoga à leitura de código.

Nosso objetivo nesta aula será estabelecer uma saída, só que de forma mais simples.

Criaremos uma cópia da classe `TesteEscrita`, que chamaremos de `TesteEscrita2`.

Trabalharemos com uma classe que é capaz de trabalhar diretamente com um arquivo que já contém caracteres, em vez de os escrevermos diretamente no código. Esta classe se chama `FileWriter`.

Comentaremos o fluxo de entrada de arquivo que havíamos criado, e importaremos esta nova classe:

```
//Código omitido

public class TesteEscrita2 {

        public static void main(String[] args) throws IOException {

        //Fluxo de Entrada com Arquivo
        //OutputStream fos = new FileOutputStream("lorem2.txt");
        //Writer osw = new OutputStreamWriter(fos);
        //BufferedWriter bw = new BufferedWriter(osw);

        FileWriter

        br.write("Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod");
        br.newLine();
        br.newLine();
        br.write("asfasdfsafdas dfs sdf asf assdß");

        bw.close();

        }
}COPIAR CÓDIGO
```

Chamaremos este `FileWriter` de `fw`, e utilizaremos um construtor que recebe uma `String` referente ao nome do arquivo com o qual desejamos trabalhar, no caso `lorem2.txt`:

```
//Código omitido

public class TesteEscrita2 {

        public static void main(String[] args) throws IOException {

        //Fluxo de Entrada com Arquivo
        //OutputStream fos = new FileOutputStream("lorem2.txt");
        //Writer osw = new OutputStreamWriter(fos);
        //Buff3eredWriter bw = new BufferedWriter(osw);

        FileWriter fw = new FileWriter("lorem2.txt");

        br.write("Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod");
        br.newLine();
        br.newLine();
        br.write("asfasdfsafdas dfs sdf asf assdß");

        bw.close();

        }
}COPIAR CÓDIGO
```

Estabelecemos assim uma saída com um arquivo.

A classe `FileWriter` possui um método que nos permite escrever uma `String`, ou seja, escrever uma linha. Testaremos com a primeira linha do nosso arquivo de texto, como havíamos feito anteriormente. Continuaremos utilizando o `fw` nos demais métodos:

```
//Código omitido

public class TesteEscrita2 {

        public static void main(String[] args) throws IOException {

        //Fluxo de Entrada com Arquivo
        //OutputStream fos = new FileOutputStream("lorem2.txt");
        //Writer osw = new OutputStreamWriter(fos);
        //Buff3eredWriter bw = new BufferedWriter(osw);

        FileWriter fw = new FileWriter("lorem2.txt");
        fw.write("Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod");
        fw.newLine();
        fw.write("asfasdfsafdas dfs sdf asf assdß");

        fw.close();

        }
}COPIAR CÓDIGO
```

Entretanto, percebemos que não existe o método `newLine()` na classe `FileWriter`. Para criarmos esta linha em branco, escreveremos um novo `String`, e indicaremos dentro dele que se trata de uma nova linha. Para isso, utilizamos certos caracteres especiais, como é o caso da barra invertida (`\`), seguida da letra "n", portanto **`\n`**:

```
//Código omitido

public class TesteEscrita2 {

        public static void main(String[] args) throws IOException {

        //Fluxo de Entrada com Arquivo
        //OutputStream fos = new FileOutputStream("lorem2.txt");
        //Writer osw = new OutputStreamWriter(fos);
        //Buff3eredWriter bw = new BufferedWriter(osw);

        FileWriter fw = new FileWriter("lorem2.txt");
        fw.write("Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod");
        fw.write("\n");
        fw.write("asfasdfsafdas dfs sdf asf assdß");

        fw.close();

        }
}COPIAR CÓDIGO
```

Isto pode variar entre sistemas operacionais, para os sistemas Linus e MacOSx basta fazermos como está escrito acima, contudo, para o Windows OS, devemos escrever **`\r\n`**, indicando o retorno de uma nova linha. Inseriremos duas linhas:

```
//Código omitido

public class TesteEscrita2 {

        public static void main(String[] args) throws IOException {

        //Fluxo de Entrada com Arquivo
        //OutputStream fos = new FileOutputStream("lorem2.txt");
        //Writer osw = new OutputStreamWriter(fos);
        //Buff3eredWriter bw = new BufferedWriter(osw);

        FileWriter fw = new FileWriter("lorem2.txt");
        fw.write("Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod");
        fw.write("\r\n");
        fw.write("\r\n");
        fw.write("asfasdfsafdas dfs sdf asf assdß");

        fw.close();

        }
}COPIAR CÓDIGO
```

Ao abrirmos o arquivo, o editor de texto saberá interpretar estes caracteres especiais.

Salvaremos e executaremos, temos o segundo resultado, no arquivo `lorem2.txt`:

```
Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod

asfasdfsafdas dfs sdf asf assdßCOPIAR CÓDIGO
```

Funcionou.

Contudo, utilizar estes caracteres especiais para criar estas linhas em branco não é uma solução elegante, principalmente considerando estas disparidades entre sistemas operacionais. Para deixarmos nosso código mais robusto, podemos contar com um método do Java que nos devolve estes caracteres com base no sistema operacional que estamos utilizando.

Começamos chamando-o com a palavra `System`, e em seguida selecionaremos o método `lineSeparator()`:

```
//Código omitido

public class TesteEscrita2 {

        public static void main(String[] args) throws IOException {

        //Fluxo de Entrada com Arquivo
        //OutputStream fos = new FileOutputStream("lorem2.txt");
        //Writer osw = new OutputStreamWriter(fos);
        //Buff3eredWriter bw = new BufferedWriter(osw);

        FileWriter fw = new FileWriter("lorem2.txt");
        fw.write("Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod");
        fw.write(System.lineSeparator());
        fw.write(System.lineSeparator());
        fw.write("asfasdfsafdas dfs sdf asf assdß");

        fw.close();

        }
}COPIAR CÓDIGO
```

Do ponto de vista semântico, isto facilita a compreensão do código, já que explicita nossa intenção de criar uma separação em linha. Executaremos novamente o programa e veremos que tudo continuará funcionando.

Por mais que o `FileWriter` atenda às nossas necessidades, ainda assim, é recomendável continuarmos utilizando o `BufferedWriter` e apenas passarmos o `fw` no seu construtor:

```
//Código omitido

public class TesteEscrita2 {

        public static void main(String[] args) throws IOException {

        //Fluxo de Entrada com Arquivo
        //OutputStream fos = new FileOutputStream("lorem2.txt");
        //Writer osw = new OutputStreamWriter(fos);
        //Buff3eredWriter bw = new BufferedWriter(osw);

        FileWriter fw = new FileWriter("lorem2.txt");
        BufferedWriter bw = new BufferedWriter(fw);
        fw.write("Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod");
        fw.write(System.lineSeparator());
        fw.write(System.lineSeparator());
        fw.write(System.lineSeparator());
        fw.write("asfasdfsafdas dfs sdf asf assdß");

        fw.close();

        }
}COPIAR CÓDIGO
```

Assim, criamos a saída, e estamos a "embrulhado", em um `BufferedWriter`. Portanto, utilizamos o `bw`, trabalhando sempre com este fluxo. Para nos organizarmos, manteremos duas linhas entre os textos e, como voltamos a utilizar o `bw`, podemos fazer uso do método `newLine()`:

```
//Código omitido

public class TesteEscrita2 {

        public static void main(String[] args) throws IOException {

        //Fluxo de Entrada com Arquivo
        //OutputStream fos = new FileOutputStream("lorem2.txt");
        //Writer osw = new OutputStreamWriter(fos);
        //Buff3eredWriter bw = new BufferedWriter(osw);

        FileWriter fw = new FileWriter("lorem2.txt");
        BufferedWriter bw = new BufferedWriter(fw);
        bw.write("Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod");
        bw.newLine();
        bw.newLine();
        bw.write("asfasdfsafdas dfs sdf asf assdß");

        bw.close();

        }
}COPIAR CÓDIGO
```

Para simplificarmos o código, podemos mover a criação do `FileWriter` diretamente para o `BufferedWriter`:

```
//Código omitido

public class TesteEscrita2 {

        public static void main(String[] args) throws IOException {

        //Fluxo de Entrada com Arquivo
        //OutputStream fos = new FileOutputStream("lorem2.txt");
        //Writer osw = new OutputStreamWriter(fos);
        //Buff3eredWriter bw = new BufferedWriter(osw);

        BufferedWriter bw = new BufferedWriter(FileWriter fw = new FileWriter("lorem2.txt"));
        bw.write("Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod");
        bw.newLine();
        bw.newLine();
        bw.write("asfasdfsafdas dfs sdf asf assdß");

        bw.close();

        }
}
```