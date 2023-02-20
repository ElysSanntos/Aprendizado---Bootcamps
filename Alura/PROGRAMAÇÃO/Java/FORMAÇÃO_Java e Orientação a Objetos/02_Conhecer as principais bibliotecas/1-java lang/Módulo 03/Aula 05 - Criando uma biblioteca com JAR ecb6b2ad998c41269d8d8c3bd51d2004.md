# Aula 05 - Criando uma biblioteca com JAR

Seguindo de onde paramos anteriormente, nosso próximo objetivo é repassar todas as classes para uma nova equipe.

Em um primeiro momento nos parece que basta acionar o atalho "Ctrl + C" e "Ctrl + V" em todas as classes compiladas e trabalho concluído. No entanto, essa não é a forma mais inteligente de distribuir o meu código.

A ideia é que passemos para o desenvolvedor o código compilado dentro de um arquivo ".zip", e a documentação, afinal, ele não necessariamente precisa do código fonte, que é de nossa responsabilidade.

No entanto, o Java não chama esse tipo de arquivo de código compilado de ".zip", o tipo do arquivo na verdade é "JAR".

Poderíamos criar esse arquivo ".jar" manualmente, manipulando todo o conteúdo através do visualizador "Navigator". Porém, o Eclipse nos fornece facilidades para esse tipo de ação.

Na área "Package Explorer", selecionaremos nosso projeto `bytebank-herdado-conta`, clicaremos com o botão direito do mouse e selecionaremos a opção "Export".

Na caixa de diálogo que será aberta, veremos que há vários modos de exportar nosso projeto. Como queremos apenas o código compilado, selecionaremos a opção "JAR file" e em seguida "next" para avançarmos na exportação.

![https://s3.amazonaws.com/caelum-online-public/843-java-packages/03/3_2_23_exportando+projeto.png](https://s3.amazonaws.com/caelum-online-public/843-java-packages/03/3_2_23_exportando+projeto.png)

Na nova caixa de diálogo, selecionaremos as pastas que serão exportadas. Não exportaremos os arquivos internos do Eclipse (`.classpath` e `.project`), e sim, todo o conteúdo da pasta `src`. Lembrando que não estamos exportando o código fonte, apenas o **código compilado**, que o Eclipse denomina "class files". Exportaremos o código para o desktop com o nome de `bytebank-1.0.jar`.

![https://s3.amazonaws.com/caelum-online-public/843-java-packages/03/3_2_24_exportanto+codigo+compilado.png](https://s3.amazonaws.com/caelum-online-public/843-java-packages/03/3_2_24_exportanto+codigo+compilado.png)

Temos o arquivo JAR, que atua basicamente como um ".zip", mas em uma extensão diferente. Ao extrairmos os arquivos, veremos que todas as classes estarão presentes dentro da estrutura de pacotes.

Neste ponto do curso, já sabemos como exportar nosso projeto de forma inteligente e organizada. Como próximo passo, analisaremos o processo do ponto de vista da equipe que recebe o projeto.

No Eclipse, fecharemos todas classes que estão abertas através do atalho "Ctrl + Shift + W". Criaremos um novo projeto que chamaremos de `bytebank-biblioteca`. Para que não haja nenhuma confusão, fecharemos todos os outros projetos.

Clicaremos com o botão direito sobre `bytebank-biblioteca` e selecionaremos a opção "Close Unrelated Projects".

Normalmente, criamos uma pasta que armazenará todas as bibliotecas a serem utilizadas. Não existe um nome de pasta padrão, mas é muito comum utilizarmos o nome `libs`, que remete ao termo em inglês *library*. Nesta pasta arrastaremos nosso arquivo `bytebank-1.0.jar`.

O arquivo já faz parte do nosso projeto. O próximo passo é criar uma nova classe que chamaremos de `TesteBiblioteca`, que estará inserida em um novo pacote que nomearemos como `br.com.alura.bytebank`.

Observemos o código da nossa classe:

```
package br.com.alura.bytebank

public class TesteBiblioteca {

    public static void main(String[] args) {

    }

}COPIAR CÓDIGO
```

Queremos utilizar a classe `Conta`.

```
package br.com.alura.bytebank

public class TesteBiblioteca {

    public static void main(String[] args) {

        Conta c = new ContaCorrente(123, 321);

    }

}COPIAR CÓDIGO
```

Percebam que utilizamos os nomes simples das classes, o que gera erros na compilação do código. Precisamos utilizar o *full qualified name* neste caso, portanto, precisamos importar estas classes.

O Eclipse, nestes casos, sugere uma importação das classes. No entanto, essa opção não é mostrada, a sugestão é que se cria uma classe `Conta`, muito embora essa classe já exista dentro do arquivo `bytebank-1.0.jar`.

O que precisamos realizar é uma comunicação do Eclipse com os arquivos do projeto. Para isso existe uma configuração que ainda não realizamos, simplesmente copiamos o arquivo ".jar" para a ferramenta e isso não é o suficiente para que as classes se tornem visíveis e usuais.

Para realizarmos essa configuração, selecionamos o arquivo `bytebank-1.0.jar` na área do Package Explorer e pressionamos o botão direito do mouse, e selecionamos as opções "Build Path > Add to Build Path".

Assim feito, veremos que uma representação gráfica de jarra surge ao lado do nome do arquivo, apontado como `Referenced Libraries`, e dentro dele são exibidas todas os pacotes, que por sua vez, armazenam as classes.

![https://s3.amazonaws.com/caelum-online-public/843-java-packages/03/3_2_25_aqurivo+jar+no+projeto.png](https://s3.amazonaws.com/caelum-online-public/843-java-packages/03/3_2_25_aqurivo+jar+no+projeto.png)

Com isso, voltando ao código de `TesteBiblioteca` o Eclipse sugere a importação das classes `Conta` e `ContaCorrente`, afinal, elas estão acessíveis.

Faremos um pequeno teste para avaliar se o nosso código está de fato funcional, acionando o método `deposita()`.

```
package br.com.alura.bytebank

public class TesteBiblioteca {

    public static void main(String[] args) {

        Conta c = new ContaCorrente(123, 321);

        c.deposita(200.3);

        System.out.println(c.getSaldo());

    }

}COPIAR CÓDIGO
```

Tudo opera como o esperado.

Nesta aula aprendemos duas ações: primeiramente como criar a documentação dentro do código fonte e gerar os HTMLs organizados, depois, aprendemos como criar uma biblioteca que seja funcional para os desenvolvedores que recebem o projeto através de um arquivo ".jar".

O mundo Java possui uma série de ".jar"s, caso você queira criar um gráfico ou abrir uma conexão com um banco de dados, sempre haverá um ".jar" ou mais que auxiliarão em seu trabalho.