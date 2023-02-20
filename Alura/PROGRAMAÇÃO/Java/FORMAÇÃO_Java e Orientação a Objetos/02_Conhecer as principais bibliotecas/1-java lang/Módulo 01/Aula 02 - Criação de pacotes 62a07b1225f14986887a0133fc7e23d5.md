# Aula 02 - Criação de pacotes

Antes de trabalharmos no código propriamente, iremos preparar nosso ambiente.

Temos o Java instalado e na linha de comando escreveremos `version` e veremos que o Java executado está na versão `9.0.4`.

```
Last login: Thu Mar 8 13:50:45 on console
Aluras-iMac:~ alura$ java -version
java version "9.0.4"
Java(TM) SE Runtime Environment (build 9.0.4+11)
Java HotSpot(TM) 64-Bit Server VM (build 9.0.4+11, mixed mode)
Aluras-iMac:~ alura$COPIAR CÓDIGO
```

Da mesma forma, as outras ferramentas que estão juntas ao *development kit* também estão na versão `9.0.4`.

```
Last login: Thu Mar 8 13:50:45 on console
Aluras-iMac:~ alura$ java -version
java version "9.0.4"
Java(TM) SE Runtime Environment (build 9.0.4+11)
Java HotSpot(TM) 64-Bit Server VM (build 9.0.4+11, mixed mode)
Aluras-iMac:~ alura$ javac - version
javac 9.0.4
Alura-iMac: ~ alura$COPIAR CÓDIGO
```

A linha de comando está configurada, o Eclipse também está instalado e iremos inicializa-lo. Estamos utilizando a versão Oxygen, mas uma versão anterior poderia ser utilizada sem problemas. No caso do Java, para nosso projeto, bastaria a versão 1.7 ou 1.8.

No Package Explorer temos os projetos que foram desenvolvidos nas outras partes do curso. Você pode fazer [download dos arquivos do projeto.](https://s3.amazonaws.com/caelum-online-public/843-java-packages/java5-projetos-inicias.zip)

Estamos com o ambiente preparado e podemos iniciar.

Você já possui uma base sólida em Java, mas ainda existem alguns pontos que podemos conhecer melhor. Na área do Package Explorer, selecionaremos o projeto `bytebank-herdado-conta` e veremos que existem onze arquivos `.java` de código fonte.

![https://s3.amazonaws.com/caelum-online-public/843-java-packages/01/1_2_2_onze+c%C3%B3digos+fonte.png](https://s3.amazonaws.com/caelum-online-public/843-java-packages/01/1_2_2_onze+c%C3%B3digos+fonte.png)

Em um projeto real teríamos facilmente por volta de quinhentos arquivos, mas podemos chegar no ponto da discussão apenas com estes onze arquivos.

Queremos organizar melhor esses arquivos, e agrupa-los todos em uma única pasta não é uma boa solução. Em nosso exemplo, podemos identificar pelo menos dois tipos de classes: reparem que temos os testes (`TesteContas`, `TesteSaca` e `TesteTributaveis`) e todas as outras fazem parte do nosso domínio.

Iremos separar esses dois tipos de classes; faremos isso organizando as classes em diretórios específicos. Em um primeiro momento, esse procedimento será feito da forma mais custosa, para depois aprendermos a fazer uso de todas as facilidades disponibilizadas pelo Eclipse.

Estamos utilizando a visualização do Package Explorer, deixaremos de fazer isso neste momento.

Na parte superior esquerda, teremos um buscador e procuraremos por outra view conhecida por "Navigator". Selecionaremos a opção correspondente e ela se tornará visível ao lado esquerdo da tela.

![https://s3.amazonaws.com/caelum-online-public/843-java-packages/01/1_2_3_navigator.png](https://s3.amazonaws.com/caelum-online-public/843-java-packages/01/1_2_3_navigator.png)

O Navigator opera como um explorer do Windows, exibe as pastas do nosso interesse de forma mais completa. Já o Package Explorer oculta alguns conteúdos a fim de simplificar a visualização, focando nos itens mais importantes. Percebam que no Navigator a pasta `bin` é exibida, diferentemente do Package Explorer.

Nosso objetivo é separar nossas classes em diretórios diferentes, como já foi dito. Em `src`, clicaremos com o botão direito e selecionaremos a opção "New > Folder". O primeiro diretório se chamará `modelo`, e dentro dessa pasta colocaremos todos os arquivos que não são de teste, como `CalculadorDeImposto`, `Cliente`, `Conta` e assim por diante.

![https://s3.amazonaws.com/caelum-online-public/843-java-packages/01/1_2_4_nova+pasta+modelo.png](https://s3.amazonaws.com/caelum-online-public/843-java-packages/01/1_2_4_nova+pasta+modelo.png)

Criaremos uma segunda pasta que chamaremos de `teste`, em que, claramente, guardaremos os arquivos de teste. Com isso temos as duas classes divididas entre diretórios específicos, visualizados no Navigator.

![https://s3.amazonaws.com/caelum-online-public/843-java-packages/01/1_2_5_direitorios+modelo+e+teste.png](https://s3.amazonaws.com/caelum-online-public/843-java-packages/01/1_2_5_direitorios+modelo+e+teste.png)

Ao clicarmos no visualizador Package Explorer reparem que há ocorrência de erros que podem ser vistos através da mudança na visualização dos diretórios que criamos, há um pequeno alerta vermelho.

![https://s3.amazonaws.com/caelum-online-public/843-java-packages/01/1_2_6_erro+no+package+explorer.png](https://s3.amazonaws.com/caelum-online-public/843-java-packages/01/1_2_6_erro+no+package+explorer.png)

Pastas e diretórios possuem um nome especial dentro do mundo Java: são os **pacotes**, ou em inglês *packages*. Esses pacotes existem para organizarmos melhor o nosso código. No entanto, quando colocamos uma classe dentro de um pacote, essa ação precisa ser evidenciada no código fonte.

Vamos entender melhor como se dá esse processo.

Abriremos o arquivo `CalculadorDeImposto`, localizado no diretório `modelo`. Percebemos que o Eclipse já aponta erros de compilação quando abrimos esta classe, afinal, ela faz parte do pacote `modelo` e isso precisa ser definido no código fonte, e deve ser a primeira declaração do código.

Por isso, inseriremos a palavra chave `package` e inseriremos o nome da pasta, no caso, `modelo`.

```
package modelo;

public class CalculadorDeImposto {

    private double totalImposto;

    public void registra(Tributavel t) {
        double valor = t.getValorImposto();
        this.totalImposto += valor;
    }COPIAR CÓDIGO
```

Com essa declaração, o código já está sendo compilado normalmente. O nome da pasta que deve ser escrito após o uso da palavra chave `package` deve sempre partir do diretório `src`, o local em que está armazenado o código fonte e para onde o compilador do Eclipse olhará.

Esse mesmo processo deve ser feito para todos os arquivos, por isso copiaremos a declaração `package modelo` por meio do atalho "Ctrl + C" e colaremos em todos as classes. Para as classes na pasta `teste` a declaração será `package teste`. Esse é o jeito mais trabalhoso de executar essa ação, mas depois aprenderemos outra forma.

Os erros de declaração do pacote não existem mais, no entanto, são apresentadas outras falhas pelo Eclipse.

Separamos nossos arquivos e eles se encontram em pacotes separados. Observamos o código da classe `testeTributaveis`:

```
package teste;

public class TesteTributaveis {

    public static void main(String[] args) {
        ContaCorrente cc = new ContaCorrente(222, 333);
        cc.deposita(100.0);

        SeguroDeVida seguro = new SeguroDeVida();

        CalculadorDeImposto calc = new CalculadorDeImposto();
        calc.registra(cc);
        calc.registra(seguro);

        System.out.println(calc.getTotalImposto());
    }COPIAR CÓDIGO
```

A classe faz referência à `ContaCorrente`, e é justamente nesse ponto em que surgem problemas, pois essa classe está no diretório `modelo`, e não em `teste`. O *package* não é apenas um diretório simples, ele passa a fazer parte do nome da classe, portanto a classe `ContaCorrente` não possui mais essa nomeação, passa a ser `modelo.ContaCorrente`. Portanto, para que o código seja compilado, devemos atualizar os nomes simples das classes que se encontram no pacote `modelo` em todos os arquivos de `teste`.

```
package teste;

public class TesteTributaveis {

    public static void main(String[] args) {
        modelo.ContaCorrente cc = new modelo.ContaCorrente(222, 333);
        cc.deposita(100.0);

        modelo.SeguroDeVida seguro = new modelo.SeguroDeVida();

        modelo.CalculadorDeImposto calc = new modelo.CalculadorDeImposto();
        calc.registra(cc);
        calc.registra(seguro);

        System.out.println(calc.getTotalImposto());
    }COPIAR CÓDIGO
```

Esse nome completo da classe que contém o nome de seu diretório é conhecido como **Full Qualified Name** ou **FQN**.