# Aula 03 - Outras entradas e saídas

Olá! Nesta aula, veremos como podemos copiar o conteúdo de um arquivo de texto para outro.

Utilizaremos o `TesteLeitura` como base. Faremos uma cópia desta classe, e nomearemos como `TesteCopiarArquivo`. Assim, temos o seguinte conteúdo:

```
//Código omitido
public class TesteCopiarArquivo {

        public static void main(String[] args) throws IOException {

                //Fluxo de Entrada com Arquivo
                InputStream fis = new FileInputStream("lorem.txt");
                Reader isr = new InputStreamReader(fis);
                BufferedReader br = new BufferedReader(isr);

                String linha = br.readLine();

                while(linha != null) {
                    System.out.println(linha);
                    linha = br.readLine();
                }

                br.close();

        }
}COPIAR CÓDIGO
```

Nela, há uma entrada já estabelecida. Seguindo isso, estabeleceremos a escrita. Para isso, podemos copiar o código da classe `TesteEscrita`, e teremos o seguinte resultado:

```
//Código omitido
public class TesteCopiarArquivo {

        public static void main(String[] args) throws IOException {

                //Fluxo de Entrada com Arquivo
                InputStream fis = new FileInputStream("lorem.txt");
                Reader isr = new InputStreamReader(fis);
                BufferedReader br = new BufferedReader(isr);

                OutputStream fos = new FileOutputStream("lorem2.txt");
                Writer osw = new OutputStreamWriter(fos);
                BufferedWriter bw = new BufferedWriter(osw);

                String linha = br.readLine();

                while(linha != null) {
                    System.out.println(linha);
                    linha = br.readLine();
                }

                br.close()

        }
}COPIAR CÓDIGO
```

Copiaremos o conteúdo do arquivo `lorem.txt` para o `lorem2.txt`.

Para tanto, não queremos mostrar isso no console, ou seja, queremos escrever para o `BufferedWriter`. Assim, em vez de utilizarmos o método `System.out.println`, faremos uso do `br.write()`, passando como parâmetro nossa `String` `linha`:

```
//Código omitido
public class TesteCopiarArquivo {

        public static void main(String[] args) throws IOException {

                //Fluxo de Entrada com Arquivo
                InputStream fis = new FileInputStream("lorem.txt");
                Reader isr = new InputStreamReader(fis);
                BufferedReader br = new BufferedReader(isr);

                OutputStream fos = new FileOutputStream("lorem2.txt");
                Writer osw = new OutputStreamWriter(fos);
                BufferedWriter bw = new BufferedWriter(osw);

                String linha = br.readLine();

                while(linha != null) {
                    bw.write(linha);
                    linha = br.readLine();
                }

                br.close()

        }
}COPIAR CÓDIGO
```

Ao final, além de fecharmos o `BufferedReader` (`br.close()`), temos de fechar também o `BufferedWriter`:

```
//Código omitido
public class TesteCopiarArquivo {

        public static void main(String[] args) throws IOException {

                InputStream fis = new FileInputStream("lorem.txt");
                Reader isr = new InputStreamReader(fis);
                BufferedReader br = new BufferedReader(isr);

                OutputStream fos = new FileOutputStream("lorem2.txt");
                Writer osw = new OutputStreamWriter(fos);
                BufferedWriter bw = new BufferedWriter(osw);

                String linha = br.readLine();

                while(linha != null) {
                    bw.write(linha);
                    linha = br.readLine();
                }

                br.close();
                bw.close();

        }
}COPIAR CÓDIGO
```

Salvaremos e executaremos o código. Atualizaremos a pasta `java-io`, e abriremos o arquivo `lorem2.txt`. Foi feita uma cópia do conteúdo escrito do arquivo `lorem.txt`, mas não houve uma quebra de linha. Criaremos esta quebra, adicionando uma `newLine()` dentro do laço `while`:

```
//Código omitido
public class TesteCopiarArquivo {

        public static void main(String[] args) throws IOException {

                InputStream fis = new FileInputStream("lorem.txt");
                Reader isr = new InputStreamReader(fis);
                BufferedReader br = new BufferedReader(isr);

                OutputStream fos = new FileOutputStream("lorem2.txt");
                Writer osw = new OutputStreamWriter(fos);
                BufferedWriter bw = new BufferedWriter(osw);

                String linha = br.readLine();

                while(linha != null) {

                bw.write(linha);
                    bw.newLine();
                    linha = br.readLine();
                }

                br.close();
                bw.close();

        }
}COPIAR CÓDIGO
```

Executando mais uma vez, temos o seguinte resultado no console:

```
Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod
tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam,
quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo
consequat. Duis aute irure dolor in reprehenderit in voluptate velit
esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat
cupidatat non proident, sunt in culpa qui officia deserunt mollit anim
id est laborum.COPIAR CÓDIGO
```

Funcionou, temos uma cópia idêntica de `lorem.txt`.

As classes `InputStream` e `OutputStream` são bases do mundo `java.io`, há milhares de bibliotecas que as utilizam.

Recapitulando, nós partimos de um arquivo, estabelecendo um fluxo de entrada, e seguimos em direção a um novo arquivo, como fluxo de saída.

A entrada concreta pode acontecer de diversas formas, bem como a saída concreta, o importante é sabermos que a forma como elas ocorrem é menos importante que os fluxos de entrada e de saída.

Isto pode ser observado na classe `TesteCopiarArquivo`, onde utilizamos sempre o `InputStream` ou `OutputStream`, em tradução do inglês, "fluxo de entrada" e "fluxo de saída":

```
//Código omitido

InputStream fis = new FileInputStream("lorem.txt");
//Código omitido

OutputStream fos = new FileOutputStream("lorem2.txt");
//Código omitidoCOPIAR CÓDIGO
```

O tipo concreto de entrada pode variar, por exemplo, pode passar a ser o teclado. Para isso, utilizamos o `System.in`:

```
//Código omitido
public class TesteCopiarArquivo {

        public static void main(String[] args) throws IOException {

                InputStream fis = System.in;
                Reader isr = new InputStreamReader(fis);
                BufferedReader br = new BufferedReader(isr);

                OutputStream fos = new FileOutputStream("lorem2.txt");
                Writer osw = new OutputStreamWriter(fos);
                BufferedWriter bw = new BufferedWriter(osw);

                String linha = br.readLine();

                while(linha != null) {

                bw.write(linha);
                    bw.newLine();
                    linha = br.readLine();
                }

                br.close();
                bw.close();

        }
}COPIAR CÓDIGO
```

Executaremos. O console nunca encerra a execução, a JVM não para de rodar, isso acontece porque o programa está aguardando um input do usuário.

Assim, podemos digitar qualquer texto, e continuar digitando, de qualquer forma que o façamos, em momento algum a aplicação para de ser executada. Isso porque não há o gatilho para que ela pare, que é o momento em que a linha for `null`. Nós não somos capazes de simular manualmente a condição de saída do laço, `null`.

Ao abrirmos o arquivo `lorem2.txt`, vemos que o que escrevemos no console foi passado para o arquivo, mas não é garantido, já que estamos trabalhando com um `BufferedWriter`. Isso significa que ele guarda todos os caracteres e, em um momento posterior - ao fazer o `close()` -, escreve o que foi armazenado.

O programa está funcionando, mas precisamos fazer com que a execução pare sem a necessidade de o fazermos manualmente. Em nosso laço `while`, criaremos uma nova condição, além de ser diferente de `null`, ela não deve ser vazia. Para isso utilizamos a negativa do método `isEmpty()`:

```
//Código omitido
public class TesteCopiarArquivo {

        public static void main(String[] args) throws IOException {

                InputStream fis = System.in;
                Reader isr = new InputStreamReader(fis);
                BufferedReader br = new BufferedReader(isr);

                OutputStream fos = new FileOutputStream("lorem2.txt");
                Writer osw = new OutputStreamWriter(fos);
                BufferedWriter bw = new BufferedWriter(osw);

                String linha = br.readLine();

                while(linha != null && !linha.isEmpty()) {

                bw.write(linha);
                    bw.newLine();
                    linha = br.readLine();
                }

                br.close();
                bw.close();

        }
}COPIAR CÓDIGO
```

Desta forma, o laço só funcionará quando a linha não for nula ou não estiver vazia. Executaremos, no console escreveremos:

```
mais coisas
outras coisas
oi
sadfCOPIAR CÓDIGO
```

Pressionaremos a tecla "Enter", deixando uma linha em branco. Desta forma, a máquina virtual encerrou a execução. No arquivo `lorem2.txt` lemos:

```
mais coisas
outras coisas
oi
sadfCOPIAR CÓDIGO
```

Portanto, nosso programa funcionou.

Se retornarmos para o `FileInputStream("lorem.txt")` o programa funcionará normalmente, e fará uma cópia do arquivo para o `lorem2.txt`, como havíamos feito anteriormente. Manteremos esta opção em comentários, por enquanto trabalharemos com o `System.in`.

A seguir, testaremos uma variação da saída concreta, o console. Neste caso, utilizamos o `System.out`:

```
//Código omitido
public class TesteCopiarArquivo {

        public static void main(String[] args) throws IOException {

                InputStream fis = System.in; //new FileInputStream("lorem.txt");
                Reader isr = new InputStreamReader(fis);
                BufferedReader br = new BufferedReader(isr);

                OutputStream fos = System.out; //new FileOutputStream("lorem2.txt");
                Writer osw = new OutputStreamWriter(fos);
                BufferedWriter bw = new BufferedWriter(osw);

                String linha = br.readLine();

                while(linha != null && !linha.isEmpty()) {

                bw.write(linha);
                    bw.newLine();
                    linha = br.readLine();
                }

                br.close();
                bw.close();

        }
}COPIAR CÓDIGO
```

Executaremos o código. Primeiro, ele espera que haja uma entrada, digitaremos:

```
escrever algo
sfdasdfasdf
asdfasdfsaCOPIAR CÓDIGO
```

Pressionaremos a tecla "Enter", e internamente o `BufferedWriter` guarda esta informação, ao criarmos uma linha em branco, o programa imprime o que escrevemos e temos o seguinte resultado no console:

```
escrever algo
sfdasdfasdf
asdfasdfsa

escrever algo
sfdasdfasdf
asdfasdfsaCOPIAR CÓDIGO
```

Funcionou! Temos a entrada, e em seguida o resultado impresso no console, ou seja, a saída. Para que isso aconteça de forma imediata, sem a necessidade de uma linha em branco entre a entrada e a saída, utilizaremos o método `flush()`:

```
//Código omitido
public class TesteCopiarArquivo {

        public static void main(String[] args) throws IOException {

                InputStream fis = System.in; //new FileInputStream("lorem.txt");
                Reader isr = new InputStreamReader(fis);
                BufferedReader br = new BufferedReader(isr);

                OutputStream fos = System.out; //new FileOutputStream("lorem2.txt");
                Writer osw = new OutputStreamWriter(fos);
                BufferedWriter bw = new BufferedWriter(osw);

                String linha = br.readLine();

                while(linha != null && !linha.isEmpty()) {

                    bw.write(linha);
                    bw.newLine();
                    bw.flush();
                    linha = br.readLine();
                }

                br.close();
                bw.close();

        }
}COPIAR CÓDIGO
```

Portanto, realizaremos um novo teste. Escreveremos um texto e pressionaremos a tecla "Enter". Temos o seguinte resultado no console:

```
escreve algo
escreve algoCOPIAR CÓDIGO
```

Funcionou, temos a entrada e a impressão. O programa continua rodando, até fazermos com que pare, gerando uma linha em branco.

Temos um código cada vez mais genérico e flexível.

Se quisermos ler o arquivo `lorem.txt` e imprimi-lo em seguida, é possível fazermos isso, retornando o código da linha `InputStream` para o que havíamos mantido em comentários:

```
//Código omitido
public class TesteCopiarArquivo {

        public static void main(String[] args) throws IOException {

                InputStream fis = new FileInputStream("lorem.txt");
                Reader isr = new InputStreamReader(fis);
                BufferedReader br = new BufferedReader(isr);

                OutputStream fos = System.out; //new FileOutputStream("lorem2.txt");
                Writer osw = new OutputStreamWriter(fos);
                BufferedWriter bw = new BufferedWriter(osw);

                String linha = br.readLine();

                while(linha != null && !linha.isEmpty()) {

                    bw.write(linha);
                    bw.newLine();
                    bw.flush();
                    linha = br.readLine();
                }

                br.close();
                bw.close();

        }
}COPIAR CÓDIGO
```

Ao executarmos a classe, temos impresso no console todo o conteúdo do arquivo `lorem.txt`.

Se quisermos ler uma entrada do teclado, e imprimi-la no arquivo, basta mantermos o `System.in`, e retornarmos o `OutputStream` para o `FileOutputStream()`:

```
//Código omitido
public class TesteCopiarArquivo {

        public static void main(String[] args) throws IOException {

                InputStream fis = System.in; //new FileInputStream("lorem.txt");
                Reader isr = new InputStreamReader(fis);
                BufferedReader br = new BufferedReader(isr);

                OutputStream fos = new FileOutputStream("lorem2.txt");
                Writer osw = new OutputStreamWriter(fos);
                BufferedWriter bw = new BufferedWriter(osw);

                String linha = br.readLine();

                while(linha != null && !linha.isEmpty()) {

                    bw.write(linha);
                    bw.newLine();
                    bw.flush();
                    linha = br.readLine();
                }

                br.close();
                bw.close();

        }
}COPIAR CÓDIGO
```

Executaremos, e digitaremos o seguinte texto no console:

```
oi oi oi
oi oi
oiCOPIAR CÓDIGO
```

Encerraremos a execução e, abrindo o arquivo `lorem2.txt`, vemos impresso exatamente isso que acabamos de digitar.

Percebemos que, sem fazermos grandes alterações ao código, é possível alterarmos a forma de entrada ou saída concreta. Funciona inclusive para a rede, contudo, é algo que não conseguimos simular por enquanto.

A comunicação via rede se dá de forma análoga ao telefone, na parte em que ouvimos, seria localizado o `OutputStream`, enquanto que a extremidade por onde falamos pode ser considerada como a `InputStream`. O telefone, no caso do nosso código, se chama `Socket`.

Em Java, temos uma classe com esse nome e, para utilizá-la, precisamos instanciá-la:

```
//Código omitido
public class TesteCopiarArquivo {

        public static void main(String[] args) throws IOException {

                new Socket();

                InputStream fis = System.in; //new FileInputStream("lorem.txt");
                Reader isr = new InputStreamReader(fis);
                BufferedReader br = new BufferedReader(isr);

                OutputStream fos = new FileOutputStream("lorem2.txt");
                Writer osw = new OutputStreamWriter(fos);
                BufferedWriter bw = new BufferedWriter(osw);

                String linha = br.readLine();

                while(linha != null && !linha.isEmpty()) {

                    bw.write(linha);
                    bw.newLine();
                    bw.flush();
                    linha = br.readLine();
                }

                br.close();
                bw.close();

        }
}COPIAR CÓDIGO
```

Nosso `Socket` será representado pela variável `s`:

```
//Código omitido
public class TesteCopiarArquivo {

        public static void main(String[] args) throws IOException {

                Socket s = new Socket().getInputStream();

                InputStream fis = System.in; //new FileInputStream("lorem.txt");
                Reader isr = new InputStreamReader(fis);
                BufferedReader br = new BufferedReader(isr);

                OutputStream fos = new FileOutputStream("lorem2.txt");
                Writer osw = new OutputStreamWriter(fos);
                BufferedWriter bw = new BufferedWriter(osw);

                String linha = br.readLine();

                while(linha != null && !linha.isEmpty()) {

                    bw.write(linha);
                    bw.newLine();
                    bw.flush();
                    linha = br.readLine();
                }

                br.close();
                bw.close();

        }
}COPIAR CÓDIGO
```

Em seguida, precisamos criar uma conexão. Por meio do `Socket`, podemos utilizar um `get()` e obter o `InputStream`:

```
//Código omitido
public class TesteCopiarArquivo {

        public static void main(String[] args) throws IOException {

                Socket s = new Socket().getInputStream();

                InputStream fis = s.getInputStream(); //System.in; //new FileInputStream("lorem.txt");
                Reader isr = new InputStreamReader(fis);
                BufferedReader br = new BufferedReader(isr);

                OutputStream fos = new FileOutputStream("lorem2.txt");
                Writer osw = new OutputStreamWriter(fos);
                BufferedWriter bw = new BufferedWriter(osw);

                String linha = br.readLine();

                while(linha != null && !linha.isEmpty()) {

                    bw.write(linha);
                    bw.newLine();
                    bw.flush();
                    linha = br.readLine();
                }

                br.close();
                bw.close();

        }
}COPIAR CÓDIGO
```

Da mesma forma, podemos obter o `OutputStream`:

```
//Código omitido
public class TesteCopiarArquivo {

        public static void main(String[] args) throws IOException {

                Socket s = new Socket();

                InputStream fis = s.getInputStream(); //System.in; //new FileInputStream("lorem.txt");
                Reader isr = new InputStreamReader(fis);
                BufferedReader br = new BufferedReader(isr);

                OutputStream fos = s.getOutputStream(); //System.out; //new FileOutputStream("lorem2.txt");
                Writer osw = new OutputStreamWriter(fos);
                BufferedWriter bw = new BufferedWriter(osw);

                String linha = br.readLine();

                while(linha != null && !linha.isEmpty()) {

                    bw.write(linha);
                    bw.newLine();
                    bw.flush();
                    linha = br.readLine();
                }

                br.close();
                bw.close();

        }
}COPIAR CÓDIGO
```

Assim, temos três formas de entrada e saída concretas, a rede, console, e o arquivo.

Notamos que o programa é bastante flexível, com poucas alterações, alternamos entre estes tipos de entrada ou saída. Isto é importante, já que existem diversas bibliotecas que utilizam tanto o `InputStream` quanto o `OutputStream`.

No site da [Caelum](https://www.caelum.com.br/apostila-java-web/), encontramos a apostila Java para Desenvolvimento Web. Nela, um dos tópicos, que também é uma das ferramentas fundamentais para o desenvolvimento web, trata dos *servlets*.

***Servlet*** é um objeto Java que funciona como um mini servidor. Este, por sua vez, tem por função receber e devolver dados, ou seja, `java.io`.

Tomemos o seguinte código como exemplo:

```
public class OiMundo extends HttpServlet {

        protected void service (HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

                PrintWriter out = response.getWriter();

                //escreve o texto
                out.println("<html>");
                out.println("<body>");
                out.println("Primeira servlet");
                out.println("</body>");
                out.println("</html>");

        }
}COPIAR CÓDIGO
```

Queremos retornar, ou seja, responder, e fazemos isso por meio de um `Writer()`, como é o caso em `response.getWriter()`. Para isso, utilizamos uma classe chamada `PrintWriter`, que assim como as classes `OutputStreamWriter` e `BufferedWriter`, também estende `Writer`.

Por isso, entendemos que ela tem por finalidade escrever caracteres.

Aqui temos um exemplo de outra biblioteca, um outro contexto, no qual utilizamos o *input* e *output*.

Atualmente, o mundo web é dominado por este fluxo de informações. Tudo isso funciona graças ao `java.io`.