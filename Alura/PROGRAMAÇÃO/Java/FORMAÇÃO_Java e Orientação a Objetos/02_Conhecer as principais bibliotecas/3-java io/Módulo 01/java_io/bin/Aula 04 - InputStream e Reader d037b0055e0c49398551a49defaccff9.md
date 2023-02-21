# Aula 04 - InputStream e Reader

Anteriormente, conseguimos estabelecer uma entrada e escrevemos código capaz de ler a primeira linha de nosso arquivo `lorem.txt`.

Nas seguintes linhas de código:

```
public class TesteLeitura {

//Código omitido

//Fluxo de Entrada com Arquivo
FileInputStream fis = new FileImputStream("lorem.txt");
InputStreamReader isr = new InputStreamReader(fis);
BufferedReader br = new BufferedReader(isr);

}COPIAR CÓDIGO
```

Foi estabelecida a entrada com o arquivo e, além disso, melhoramos a leitura, já que nosso objetivo era traduzir a linha inteira. Para isso, foi necessário utilizarmos as classes `InputStreamReader` e `BufferedReader`. A primeira transforma bytes em caracteres, enquanto a segunda é responsável por unir os caracteres em uma linha e interpretá-los, linha a linha.

Temos a referência `fis`, que aponta para o objeto `FileInputStream("lorem.txt")`, e foi inserida como parâmetro no construtor `InputStreamReader(fis)`.

O mesmo foi feito com a referência `isr`, que aponta para o objeto `InputStreamReader(fis)`, e foi inserida como parâmetro no construtor `BufferedReader(isr)`.

Na prática, isso significa que o `FileInputStream` é administrado por meio do `InputStreamReader`, este por sua vez, é administrado pelo `BufferedReader`, pois é passado no construtor.

Ao utilizarmos o método `br.readLine()`, pedimos primeiro ao `BufferedLine`, ele por sua vez faz o pedido ao `InputStreamReader` que, seguindo a ordem, pede ao `FileStreamReader` que faça a leitura dos dados do arquivo, que no caso é `lorem.txt`. Visualmente, temos algo como o desenho a seguir:

> BufferedReader> InputStreamReader > FileInputStream > lorem.txt
> 

Isso que fizemos é um padrão de projeto chamado *decorator*, ou seja, um objeto está **decorando** a funcionalidade de outro, sucessivamente. Em geral, o `java.io` é repleto de padrões de projeto.

Nosso objetivo seguinte será ler linha a linha do arquivo, até sua totalidade.

O método `readLine()` nos dá um retorno `null` quando não há mais nenhum conteúdo, portanto, criaremos um `while`, indicando que, enquanto a linha não for nula (`null`), teremos a impressão desta e leremos a próxima:

```
//Código omitido

public class TesteLeitura {

        public static void main(String[] args) throws IOException {

                //Fluxo de Entrada com Arquivo
                FileInputStream fis = new FileInputStream("lorem.txt");
                InputStreamReader isr = new InputStreamReader(fis);
                BufferedReader br = BufferedReader(isr);

                String linha = br.readLine();

                while(linha != null) {
                        System.out.println(linha);
                        linha = br.readLine();
                }

                System.out.println(linha);

                br.close();
        }
}COPIAR CÓDIGO
```

Salvaremos e executaremos o código. Temos o seguinte resultado no console:

```
Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod
tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam,
quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo
consequat. Duis aute irure dolor in reprehenderit in voluptate velit
esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat
cupidatat non proident, sunt in culpa qui officia deserunt mollit anim
id est laborum.COPIAR CÓDIGO
```

Temos o texto impresso integralmente, indicando que o código funcionou!

Concluímos nosso primeiro objetivo, que era estabelecer uma entrada a partir de um arquivo, o **fluxo de entrada**, e uma saída para o console, representando o **fluxo de saída**.

Em seguida, trabalharemos dois conceitos que vemos muito presentes em nosso código, os termos `Stream` e `Reader`. Eles existem tanto para entrada quanto saída, mas por enquanto focaremos somente na entrada.

Primeiro, temos um a`Stream`, capaz de ler bits e bytes, um "*input stream of bytes*". Em contrapartida, há o `Reader`, que também faz uma leitura, só que esta é focada nos caracteres, "*reading character streams*".

Se precisamos ler uma imagem ou um PDF, por exemplo, utilizamos sempre o `Stream`, já se trabalhamos com um arquivo de texto, devemos utilizar o `Reader`.

Ademais, há algo ainda mais geral que o `FileInputStream`, um conceito que representa o fluxo de dados binários, que é a classe (abstrata) `InputStream`.

No mundo `Reader`, vimos duas classes, a `InputStreamReader` e `BufferedReader`. O que ambas têm em comum é que são `Readers`, ou seja, compete à elas a leitura de caracteres. Assim, o `Reader` também é um conceito, uma classe abstrata, que tem estas duas classes como filhos concretos.

É fundamental compreendermos a existência destes dois mundos, dos `Streams` e `Readers`, focados na leitura dos dados.

No Eclipse, podemos visualizar a classe `FileInputStream`:

```
//Código omitido

public class FileInputStream extends InputStream {

//Código omitidoCOPIAR CÓDIGO
```

Vemos que ela estende `InputStream`. Ou seja, lembrando do conceito de polimorfismo, podemos utilizar este tipo mais genérico em nosso código, sem esquecer de importar esta classe:

```
//Código omitido

public class TesteLeitura {

        public static void main(String[] args) throws IOException {

                //Fluxo de Entrada com Arquivo
                InputStream fis = new FileInputStream("lorem.txt");
                InputStreamReader isr = new InputStreamReader(fis);
                BufferedReader br = BufferedReader(isr);

                String linha = br.readLine();

                while(linha != null) {
                        System.out.println(linha);
                        linha = br.readLine();
                }

                System.out.println(linha);

                br.close();
        }
}COPIAR CÓDIGO
```

O código continua funcionando. O próprio construtor do `InputStreamReader` funciona com um `InputStream`, não há necessidade de utilizarmos o tipo mais específico. Inclusive, ele é um `Reader`, e pode também ser representado pela classe mais genérica:

```
//Código omitido

public class TesteLeitura {

        public static void main(String[] args) throws IOException {

                //Fluxo de Entrada com Arquivo
                InputStream fis = new FileInputStream("lorem.txt");
                Reader isr = new InputStreamReader(fis);
                BufferedReader br = BufferedReader(isr);

                String linha = br.readLine();

                while(linha != null) {
                        System.out.println(linha);
                        linha = br.readLine();
                }

                System.out.println(linha);

                br.close();
        }
}COPIAR CÓDIGO
```

Na classe, vemos que ela estende a classe `Reader`:

```
//Código omitido

public class InputStreamReader extends Reader {

//Código omitidoCOPIAR CÓDIGO
```

Que por sua vez, é uma classe abstrata:

```
//Código omitido

public abstract class Reader implements Readable, Closeable {

//Código omitidoCOPIAR CÓDIGO
```

O mesmo é válido para a classe `InputStream`:

```
//Código omitido

public abstract class InputStream implements Closeable {

//Código omitidoCOPIAR CÓDIGO
```

Retornando à classe `TesteLeitura`, vemos que o `BufferedReader` é capaz de receber um `Reader`, ou seja, não há necessidade de ser um tipo específico.

As classes `InputStream` e `Reader` são chamadas ***templates***, que são aquelas que pré-definem determinado conteúdo para as filhas.

Salvaremos e executaremos, o resultado no console permanece inalterado, indicando que nosso código continua funcionando.

Se observarmos a classe `BufferedReader` em detalhe:

```
//Código omitido

public class BufferedReader extends Reader {

//Código omitidoCOPIAR CÓDIGO
```

Veremos que ela também é um `Reader`, assim, poderíamos pensar que assim como fizemos anteriormente, também será possível a substituição pelo tipo menos específico. Entretanto, a classe `Reader` não possui o método `readLine()`, necessário para a leitura do nosso arquivo, sendo assim, precisamos manter o `BufferedReader` neste casso.