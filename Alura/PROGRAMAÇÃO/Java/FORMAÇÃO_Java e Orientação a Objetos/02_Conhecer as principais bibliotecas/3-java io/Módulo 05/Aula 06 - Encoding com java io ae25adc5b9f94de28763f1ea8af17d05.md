# Aula 06 - Encoding com java.io

Já vimos como funciona o *encoding* no Java. Aprendemos que cada caractere dentro de uma `String` possui um *codepoint* associado, registrado na tabela *unicode*, e vimos também que há um `Charset` padrão, que é aplicado conforme o sistema operacional que está sendo utilizado. No Windows OS, por exemplo, este padrão é `windows-1252`.

O codepoint de um caractere nunca muda, é sempre o mesmo. O codepoint de `"ç"` é `231`, e sempre será.

Fizemos testes com os bytes, vimos qual a sua quantidade, e aprendemos a tranformá-los em `Strings`.

A seguir, trabalharemos com o foco nos arquivos. Abriremos o `contas.csv`, clicando com o botão direito do mouse, e selecionando a opção "Text Editor". Vemos o seguinte:

```
CC,22,33,Nico Steppat,210.1
CP,11,55,Luan Silva,1300.98
CC,22,44,SÃ©rgio  Lopes,350.40COPIAR CÓDIGO
```

Temos um problema de encoding, pois o nome "Sérgio" tem um acento agudo na letra "e". Isso acontece pois o encoding utilizado por padrão no Windows não tem o registro deste caractere `é`.

Clicaremos com o botão direito do mouse, sobre o nome do arquivo `contas.csv` e selecionaremos a opção "Properties". Podemos observar nas propriedades que foi aplicado o encoding `windows-1252`. Na própria caixa de diálogo é possível alterar isso, clicando na opção "Other", selecionaremos `UTF-8`, ao fazermos isso temos o seguinte resultado:

```
CC,22,33,Nico Steppat,210.1
CP,11,55,Luan Silva,1300.98
CC,22,44,Sérgio  Lopes,350.40COPIAR CÓDIGO
```

Problemas de encoding em decorrência do uso de um `Charset` errado não são incomuns. Estes problemas não são exclusivos do mundo Java.

Em seguida, abriremos a classe `TesteLeitura2`. Nela, temos um `Scanner()` que lê o arquivo `contas.csv`. Ao fazer isso, ele precisa determinar qual encoding será utilizado. Por padrão, é aplicado o do sistema operacional, que neste caso é o `windows-1252`. Já dentro do laço, temos um outro `Scanner`, que separa as informações contidas em cada uma das linhas:

```
//Código omitido

public class TesteLeitura2 {

    public static void main(String[] args) throws Exception {

        Scanner scanner = new Scanner(new File("contas.csv"));
        while(scanner.hasNextLine()) {
                String linha = scanner.nextLine();
                //System.out.println(linha);

                Scanner linhaScanner = new Scanner(linha);
                linhaScanner.useLocale(Locale.US);
                linhaScanner.useDelimiter(",");

                String tipoConta = linhaScanner.next();
                int agencia = linhaScanner.nextInt();
                int numero = linhaScanner.nextInt();
                String titular = linhaScanner.next();
                double saldo = linhaScanner.nextDouble();

                System.out.format(new Locale("pt","BR"), %s - %04d0%08d, %20s: %08.2f %n",
                        tipoConta, agencia, numero, titular, saldo );

                linhaScanner.close();

                //Código omitidoCOPIAR CÓDIGO
```

Aplicando o `Locale`, se necessário, para fazer o `parseInt()` dos dados.

Executaremos, e temos o seguinte resultado no console:

```
CC - 0022-00000033,      Nico Steppat: 00210,10
CP - 0011-00000055,        Luan Silva: 01300,98
CC - 0022-00000044,     SÃ©rgio Lopes: 00350,40COPIAR CÓDIGO
```

A execução funcionou, contudo, temos um problema no encoding, com o caractere especial `é`, no nome "Sérgio". Isso acontece porque o `contas.csv` é `UTF-8`, enquanto o Java utiliza por padrão, do Windows OS, o `windows-1252`. Sendo assim, precisamos especificar o `UTF-8` para o Java.

O responsável por ler o arquivo é o `Scanner`, então é nele que deve ser inserida esta especificação. Selecionaremos o construtor que recebe a `File source`, bem como o `charsetName` formato `String`. Podemos então escrever isso no código:

```
//Código omitido

public class TesteLeitura2 {

    public static void main(String[] args) throws Exception {

        Scanner scanner = new Scanner(new File("contas.csv"), "UTF-8");
        while(scanner.hasNextLine()) {
                String linha = scanner.nextLine();
                //System.out.println(linha);

                Scanner linhaScanner = new Scanner(linha);
                linhaScanner.useLocale(Locale.US);
                linhaScanner.useDelimiter(",");

                String tipoConta = linhaScanner.next();
                int agencia = linhaScanner.nextInt();
                int numero = linhaScanner.nextInt();
                String titular = linhaScanner.next();
                double saldo = linhaScanner.nextDouble();

                System.out.format(new Locale("pt","BR"), %s - %04d0%08d, %20s: %08.2f %n",
                        tipoConta, agencia, numero, titular, saldo );

                linhaScanner.close();

                //Código omitidoCOPIAR CÓDIGO
```

Executando novamente, temos o seguinte resultado:

```
CC - 0022-00000033,      Nico Steppat: 00210,10
CP - 0011-00000055,        Luan Silva: 01300,98
CC - 0022-00000044,      Sérgio Lopes: 00350,40COPIAR CÓDIGO
```

Temos o programa funcionando, com todos os nomes impressos corretamente.

Ao abrirmos um arquivo temos um fluxo de entrada de bits e bytes, que é transformado em um texto, neste momento é aplicado um `Charset`. Nos é dada a possibilidade de defini-lo, de modo a melhor servir ao nosso programa.

Veremos como isso pode funcionar com outra classe, no caso `TesteLeitura`

Testaremos isso em outra classe, desta vez, `TesteLeitura`. Trabalhávamos com o arquivo `lorem.txt`, onde não há nenhum caractere especial, ou seja, com acentuação, mas que de qualquer forma permite a definição do `Charset`.

A definição do `Charset` ocorre somente a partir do `InputStreamReader`, pois é ele quem transforma o fluxo de bytes em caracteres, utilizando justamente o `Charset`.

No construtor `InputStreamReader()` temos a possibilidade de passar tanto um `Charset`, quando um `charsetNamet` do tipo `String`. No caso, utilizaremos a segunda opção. Definiremos como `UTF-8`, já que é o padrão do arquivo:

> Caso o arquivo não esteja neste formato, é possível altera-lo, clicando com o botão direito do mouse sobre seu nome, e selecionando a opção "Properties". Em "Text file encoding", selecionaremos "Other > UTF-8".
> 

```
//Código omitido

public class TesteLeitura {

        public static void main(String[] args) throws IOException {

                //Fluxo de Entrada com Arquivo
                InputStream fis = new FileInputStream("lorem.txt");
                Reader isr = new InputStreamReader(fis, "UTF-8");
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

Executando, temos o texto completo do arquivo `lorem.txt` no console, indicando que tudo está funcionando corretamente.

Ainda que nesse caso estivéssemos trabalhando apenas com caracteres padrão, este exemplo serve para aprendemos que é possível impormos um `Charset` via o `InputStreamReader()`.

O mesmo vale para a escrita. Na classe `TesteEscritaPrintStreamWriter`, utilizaremos o construtor `PrintWriter()` para este fim, que recebe um `File` e um `Charset csn`. O `csn` neste caso significa o nome de qualquer `Charset` suportado pelo Java:

```
//Código omitido

public class TesteEscritaPrintStreamWriter {

        public static void main(String[] args) throws IOException {

        //Código omitido

        PrintWriter ps = new PrintWriter("lorem2.txt", "UTF-8");

        //Código omitido

        }
}COPIAR CÓDIGO
```

Executando, abriremos o arquivo `lorem2.txt` e veremos que o texto foi gravado, mas ainda com um caractere não reconhecido:

```
Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod

asfasdfsafdas dfs sdf asf assdfÃfÄ.COPIAR CÓDIGO
```

Isso acontece porque o Eclipse ainda acha que o padrão do arquivo é o `windows-1252`. Para solucionar, clicaremos sobre o nome do arquivo com o botão direito do mouse, e selecionaremos a opção "Properties", na seção "Text file encoding" definiremos "Other > UTF-8".

Continua errado. Acontece que o código fonte está errado, pois isso se aplica também à ele. Precisaremos repetir o processo indicado acima também ao código fonte.

Com todos estes ajustes feitos, testamos novamente, e o texto está correto tanto no código quanto no arquivo `lorem2.txt`.

Se, por exemplo, estivéssemos trabalhando em equipe, não haveria problema, desde que fosse definido um único encoding para o projeto.

Adiante, falaremos sobre serialização. Até lá!