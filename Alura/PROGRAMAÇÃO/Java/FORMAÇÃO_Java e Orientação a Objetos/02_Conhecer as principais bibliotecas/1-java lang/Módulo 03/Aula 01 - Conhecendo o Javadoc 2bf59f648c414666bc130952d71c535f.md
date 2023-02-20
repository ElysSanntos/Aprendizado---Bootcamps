# Aula 01 - Conhecendo o Javadoc

A partir deste ponto o curso se tornará mais simples, pois a base da linguagem e seus conceitos nós já aprendemos; falamos sobre orientação básica, polimorfismo, exceções e pacotes. O que veremos será mais específico, como funcionalidades de algumas classes, ou seja, quais classes e pacotes o Java irá nos oferecer.

Para entendermos melhor como instrumentalizar algumas classes, começaremos a analisar a documentação Java. Digamos que seja necessário passar nosso projeto atual para outra equipe, para que essa transferência de projeto se dê da melhor forma precisamos nos preocupar com a documentação do código, o mínimo para ajudar os outros desenvolvedores. Precisamos, ainda, pensar em um modo de repassar todas as classes do projeto para a outra equipe da maneira mais simples o possível.

No caso da documentação, o Java oferece um recurso específico. Reparem na classe `SaldoInsuficienteException`:

```
package br.com.bytebank.banco.modelo;

public class SaldoInsuficienteException extends Exception{

    public SaldoInsuficienteException(String msg) {
        super(msg);
    }
}COPIAR CÓDIGO
```

A exceção que criamos estende uma classe do mundo Java, a `Exception`. Ao selecionarmos essa classe veremos uma série de comentários especiais:

```
/**
*The class {@code Exception} and its subclasses are a
*form of {@code Throwable} that indicates contidions that a reasonable
*application might want to catch.
*
*
*<p>The class {@code Exception} and any subclasses that are not also
*subclasses of {@link RuntimeException} are <em>checked
*exceptions</em>. Checked exceptions need to be declared in a
*method or constructor's {@conde throws} clause if they can be thrown
*by the execution of the method or cosntructor and propagate outside
*the method or constructor boundary.

*@author Frank Yellin
*@see java.lang.Error
*@jls 11.2 Compile-Time Cheking of Exceptions
*@since 1.0
*/
public class Exception extends Throwable `{
    static final lang serialVersionUID = -3387516993124229948LCOPIAR CÓDIGO
```

Estes comentários exibidos pelo Eclipse são textos da documentação oficial Java. Reparem que esses comentários são azuis, quando realizamos nossos comentários no código utilizando as barras (`//`), o texto surge em cor verde, o que significa que ele não faz parte da documentação oficial.

Para escrevermos um comentário em azul utilizamos uma `/**` e fechamos com `*/`. Nesse espaço existe uma sintaxe específica, como `@author`, que indica quem escreveu o comentário. Existem ainda outros, como `@version` que indicam a versão.

```
/**
*
*@author Nico Steppat
*@version 0.1
*/COPIAR CÓDIGO
```

Normalmente os comentários especiais possuem algum valor importante dentro do código. Por exemplo, especificar a função de alguma classe ou fornecer informações de valor acerca de algum elemento, como faz a classe `Exception`.

```
/**
* Classe que representa um cliente no Bytebank.
*
*@author Nico Steppat
*@version 0.1
*/COPIAR CÓDIGO
```

Faremos um comentário especial em nossa classe `Conta`.

```
package br.com.bytebank.banco.modelo;

/**
* Classe representa a moldura de uma conta
*
*@author Nico Steppat
*
*/
public abstract class Conta {

<....!....>COPIAR CÓDIGO
```

Os comentários podem ser escritos logo acima da classe referida, mas podem estar presentes em qualquer outro membro público. Lembrando: queremos passar as classes para um outro desenvolvedor e ele só enxergará nessa classe os membros públicos. Podemos deixar comentários que se referem a atributos privados, mas isso não terá nenhum significado para o desenvolvedor, já que ele não verá esse atributo.

Seguiremos fazendo comentários em nosso código para facilitar o trabalho dos outros desenvolvedores. Deixaremos um comentário no construtor da classe `Conta`.

```
/**
* Construtor para inicializar o objeto a partir da agencia e numero.
*
*@param agencia
*@param numero
*/
public Conta(int agencia, int numero){
    Conta.total++;

<....!....>COPIAR CÓDIGO
```

Faremos mais um comentário para apontarmos a exceção que o método joga.

```
/**
*
*
*@param valor
*@throws SaldoInsuficienteException
*/
public void saca(double valor) throws SaldoInsuficienteException{

<....!....>COPIAR CÓDIGO
```

Veremos a seguir como gerar a documentação, o chamado **Javadoc**. Há um botão disponível na área de console.

![https://s3.amazonaws.com/caelum-online-public/843-java-packages/03/3_1_15_javadoc.png](https://s3.amazonaws.com/caelum-online-public/843-java-packages/03/3_1_15_javadoc.png)

Caso essa opção não esteja disponível na área de console, basta selecionar o buscador na parte superior direta da tela do Eclipse e procurar por "Javadoc". Depois de acionarmos o Javadoc, ao clicarmos na classe os comentários são exibidos no console de forma mais organizada.

![https://s3.amazonaws.com/caelum-online-public/843-java-packages/03/3_1_16_view+javadoc.png](https://s3.amazonaws.com/caelum-online-public/843-java-packages/03/3_1_16_view+javadoc.png)

Essa seria um *preview* da documentação oficial do Java. A ideia é que a partir dos comentários elaborados, possamos criar um documento separado. Para isso, no cabeçalho do Eclipse, clicaremos em "Project -> Generate Javadoc".

Na caixa de diálogo, selecionaremos o projeto desejado, neste caso, `bytebank-herdado-conta`. É importante dizer que esta ferramenta de Javadoc vem junto com o JDK, portanto é crucial te-lo instalado. Salvaremos o projeto na pasta padrão.

![https://s3.amazonaws.com/caelum-online-public/843-java-packages/03/3_1_17_caixa+de+di%C3%A1lgo+javadoc.png](https://s3.amazonaws.com/caelum-online-public/843-java-packages/03/3_1_17_caixa+de+di%C3%A1lgo+javadoc.png)

Ao darmos o "Ok", serão percorridas todas as classes e será criada uma página HTML que contém todas as informações do projeto. Foi criada uma pasta `doc`, e vários arquivos a partir dessa varredura de classes, mas o que nos interessa neste momento é o `index`

![https://s3.amazonaws.com/caelum-online-public/843-java-packages/03/3_1_18_pasta+index.png](https://s3.amazonaws.com/caelum-online-public/843-java-packages/03/3_1_18_pasta+index.png)

Veremos, justamente, o índice da documentação com todos os pacotes, são eles `br.com.bybank.banco.especial`, `br.com.bybank.banco.modelo` e `br.com.bybank.banco.test`.

![https://s3.amazonaws.com/caelum-online-public/843-java-packages/03/3_1_19_indice+da+documentacao.png](https://s3.amazonaws.com/caelum-online-public/843-java-packages/03/3_1_19_indice+da+documentacao.png)

Ao selecionarmos um deles, no caso `br.com.bybank.banco.modelo`, teremos acesso ao sumário do pacote com todas as interfaces, classes e exceções e os comentários realizados.

![https://s3.amazonaws.com/caelum-online-public/843-java-packages/03/3_1_20_sumario.png](https://s3.amazonaws.com/caelum-online-public/843-java-packages/03/3_1_20_sumario.png)

No sumário de classes, podemos selecionar alguma classe específica para obtermos mais informações. Selecionaremos a classe `Cliente`.

Veremos o comentário que elaboramos (`Classe que representa um cliente no Bytebank`), a versão e o autor. Também veremos seus construtores, e seus métodos públicos.

![https://s3.amazonaws.com/caelum-online-public/843-java-packages/03/3_1_21_classe+cliente.png](https://s3.amazonaws.com/caelum-online-public/843-java-packages/03/3_1_21_classe+cliente.png)

Voltaremos nossa atenção para a classe `Conta`.

Percebam que são exibidas diversas informações, inclusive suas classes filhas, que são `ContaCorrente`, `ContaEspecial` e `ContaPoupanca`.

![https://s3.amazonaws.com/caelum-online-public/843-java-packages/03/3_1_22_classe+conta.png](https://s3.amazonaws.com/caelum-online-public/843-java-packages/03/3_1_22_classe+conta.png)

São exibidas ainda as mesmas informações que vimos na classe `Cliente`, como construtores e métodos.

Notem que estamos lidando com uma documentação bem profissional, de **desenvolvedor para desenvolvedor**, e não para um usuário final que está fazendo uso da aplicação.

O primeiro passo para repassar um projeto é justamente gerar essa documentação. O Java iniciou a proposta de incluir a documentação dentro do código, como vimos nos comentários especiais. Se você realiza alguma modificação, as atualizações na documentação podem ser realizadas facilmente.

Nos falta pensar em como podemos passar todas as classes para a outra equipe de desenvolvedores de forma inteligente.