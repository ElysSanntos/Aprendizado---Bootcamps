# Aula 01 - OutputStream e Writer

Olá! Anteriormente, estabelecemos um fluxo de entrada concreto a partir de um arquivo. Nesta aula, nosso foco será o fluxo de saída.

Como estamos trabalhando com **saída**, em vez de utilizarmos o `InputStream`, faremos uso do `OutputStream`, e em vez do `Reader`, teremos o `Writer`. Apesar das diferentes nomenclaturas, os conceitos são os mesmos.

Assim, enquanto temos uma classe concreta `FileOutputStream`, temos acima dela a classe mãe, abstrata, `OutputStream`, que é análoga à `InputStream`. Ela é utilizada para manipular arquivos em formato PDF ou imagens, por exemplo.

Se quisermos ter uma entrada em texto, precisaremos das classes `OutputStreamWriter` e `BufferedWriter`, e são filhas da classe `Writer`.

No Eclipse, faremos uma cópia da classe `TesteLeitura`, que chamaremos de `TesteEscrita`. Com relação ao código da classe anterior, manteremos apenas o seguinte:

```
//Código omitido

public class TesteEscrita {

        public static void main(String[] args) throws IOException {

                //Fluxo de Entrada com Arquivo
                InputStream fis = new FileInputStream("lorem.txt");
                Reader isr = new InputStreamReader(fis);
                BufferedReader br = new BufferedReader(isr);

                br.close();

        }
}COPIAR CÓDIGO
```

Onde há a palavra "*Input*", trocaremos para "*Output*", ou seja, trocaremos a entrada pela saída, e da mesma forma, a leitura se tornará escrita, trocaremos "*Reader*" por "*Writer*", onde for cabível.

Alteraremos também os nomes das variáveis, para maior clareza. Para não sobrescrevermos o arquivo, criaremos um `lorem2.txt`:

```
//Código omitido

public class TesteEscrita {

        public static void main(String[] args) throws IOException {

                //Fluxo de Entrada com Arquivo
                OutputStream fos = new FileOutputStream("lorem2.txt");
                Writer osw = new OutputStreamWriter(fos);
                BufferedWriter bw = new BufferedWriter(osw);

                bw.close();

        }
}COPIAR CÓDIGO
```

Lembrando de importar as respectivas classes.

O próximo passo será escrevermos um conteúdo. Para isso, utilizamos o `BufferedWriter`, chamando pelo `bw`, o Eclipse nos apresenta uma série de métodos disponíveis, dentre eles temos o `write()`, que recebe uma `String`. É o que utilizaremos. Nele, escreveremos a mesma primeira linha do nosso arquivo `lorem.txt`.

Em seguida criaremos mais duas linhas em branco, e uma de texto:

```
//Código omitido

public class TesteEscrita {

        public static void main(String[] args) throws IOException {

                //Fluxo de Entrada com Arquivo
                OutputStream fos = new FileOutputStream("lorem2.txt");
                Writer osw = new OutputStreamWriter(fos);
                BufferedWriter bw = new BufferedWriter(osw);

                bw.write("Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod");
                bw.newLine();
                bw.newLine();
                bw.write("asfasdfsafdas dfs sdf asf assdß");

                bw.close();

        }
}COPIAR CÓDIGO
```

Podemos notar que aqui está presente o padrão de *decorator*, onde cada objeto decora a funcionalidade do anteriormente, da mesma forma como aconteceu no fluxo de entrada.

Salvaremos e executaremos, o resultado aparece como terminado mas nada é exibido no console. Isso acontece porque o Eclipse não percebeu que estamos trabalhando com um novo arquivo, para isso, teremos de atualizar. Clicaremos com o botão direito do mouse sobre a pasta `java-io` e selecionaremos a opção "Refresh".

No menu de arquivos, surgirá um novo, de nome `lorem2.txt`. Clicaremos nele e, ao abrirmos, veremos que ele contém o seguinte texto:

```
Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod

asfasdfsafdas dfs sdf asf assdßCOPIAR CÓDIGO
```

Indicando que nosso programa funcionou.

Adiante, uniremos os dois códigos, ou seja, leremos e escreveremos em uma mesma oportunidade. Nos vemos lá.