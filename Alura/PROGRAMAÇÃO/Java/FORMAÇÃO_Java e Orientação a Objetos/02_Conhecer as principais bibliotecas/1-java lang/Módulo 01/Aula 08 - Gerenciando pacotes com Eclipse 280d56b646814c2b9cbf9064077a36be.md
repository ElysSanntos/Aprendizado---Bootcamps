# Aula 08 - Gerenciando pacotes com Eclipse

Nesta altura do projeto já criamos nossos pacotes e uma hierarquia de pastas, também fizemos as declarações adequadas no `package` de cada classe. No caso das classes da pasta `teste`, tivemos de acionar a palavra-chave `import` para realizarmos as importações da pasta `modelo`.

Iremos nos voltar para o visualizador Package Explorer. Reparem que o Eclipse exibe o pacote `br.com.bytebank.banco.modelo`, sabemos que existem pastas únicas para `br`,`com` e assim sucessivamente, no entanto essas pastas são agrupadas para facilitar a visualização pelo usuário.

![https://s3.amazonaws.com/caelum-online-public/843-java-packages/01/1_4_8_pacotes+agrupados.png](https://s3.amazonaws.com/caelum-online-public/843-java-packages/01/1_4_8_pacotes+agrupados.png)

Acessaremos o arquivo `TesteContas` para explorarmos as facilidades disponibilizadas pelo Eclipse. Não há necessidade de criarmos nenhuma pasta manualmente, a própria ferramenta realiza essa ação.

Observem o código da classe:

```
package br.com.bytebank.banco.teste;

import br.com.bytebank.banco.modelo.*;

public class TesteContas {

    public static void main(String[] args) throws SaldoInsuficienteException{

        ContaCorrente cc = new ContaConrrente(111, 111);
        cc.deposita(100.0);

        ContaPoupanca cp = new ContaPoupanca(222, 222);
        cp.deposita(200.0);

        cc.transfere(10.0, cp);

        System.out.println("CC:" + cc.getSaldo());
        System.out.println("CP:" + cp.getSaldo());

    }
}
COPIAR CÓDIGO
```

Retiraremos as importações da classe `TesteContas` e veremos que um erro é apontado para a `SaldoInsuficienteException`, afinal, não estamos conseguindo identificar a procedência dessa classe se não há as devidas especificações.

```
package br.com.bytebank.banco.teste;

public class TesteContas {

    public static void main(String[] args) throws SaldoInsuficienteException{
//...COPIAR CÓDIGO
```

No entanto, ao selecionarmos com o mouse a classe `SaldoInsuficienteException` no código fonte de `TesteContas`, veremos que Eclipse sugere a importação.

![https://s3.amazonaws.com/caelum-online-public/843-java-packages/01/1_4_9_sugest%C3%A3o+de+importacao.png](https://s3.amazonaws.com/caelum-online-public/843-java-packages/01/1_4_9_sugest%C3%A3o+de+importacao.png)

Ao aceitarmos a importação sugerida pelo Eclipse, veremos que exitem algumas diferenças entre o modelo de importação que estávamos realizando, pois fazia uso do asterisco (`*`). O asterisco simboliza que todas as classes de `modelo` são importadas. Mas a importação sugerida pelo Eclipse é específica, e aponta somente para `SaldoInsuficienteException`.

```
package br.com.bytebank.banco.teste;

import br.com.bytebank.banco.modelo.SaldoInsuficienteException;

public class TesteContas {

    public static void main(String[] args) throws SaldoInsuficienteException{
COPIAR CÓDIGO
```

Normalmente as importações específicas são privilegiadas, pois elas garantem que não importemos nenhuma outra classe que não seja de nossa escolha. As importações não possuem nenhum impacto no desempenho do projeto. Neste caso, precisamos importar outras classes que não são mencionadas no código, como `ContaCorrente` e `ContaPoupanca`.

```
package br.com.bytebank.banco.teste;

import br.com.bytebank.banco.modelo.ContaCorrente;
import.com.bytebank.banco.modelo.ContaPoupanca;
import br.com.bytebank.banco.modelo.SaldoInsuficienteException;
COPIAR CÓDIGO
```

No entanto, não precisamos selecionar com o mouse as classes que precisam ser importadas, basta acionarmos com o atalho "Ctrl + Shift + O" e a ferramenta Eclipse irá realizar automaticamente as importações necessárias no código fonte.

Não existe a necessidade de digitar nenhum `import` no Eclipse, assim como não precisamos realizar manualmente a declaração do `package` ou criar pastas.

Retiraremos uma letra da declaração de `package` na classe `TesteTributaveis`, escrevendo `test` em vez de `teste` ao final da declaração, de forma que o Eclipse aponte um erro. Ao selecionarmos a declaração, veremos que a ferramenta nos aponta duas soluções: a renomeação ou a criação de um novo pacote.

![https://s3.amazonaws.com/caelum-online-public/843-java-packages/01/1_4_solu%C3%A7%C3%A3o+eclipse+declaracao+package.png](https://s3.amazonaws.com/caelum-online-public/843-java-packages/01/1_4_solu%C3%A7%C3%A3o+eclipse+declaracao+package.png)

Escolheremos a opção de criação de um novo pacote. Percebam que o Eclipse criou esse novo pacote

```
br.com.bytebank.banco.test
```

que contem a classe

```
br.com.bytebank.banco.test
```

.

![https://s3.amazonaws.com/caelum-online-public/843-java-packages/01/1_4_11_novo+pacote+test.png](https://s3.amazonaws.com/caelum-online-public/843-java-packages/01/1_4_11_novo+pacote+test.png)

Podemos mover outras classes para dentro do pacote que criamos, basta selecionar os arquivos e arrasta-los para o pacote fim. Selecionaremos `TesteContas` e `TesteSaca`, que antes estavam no pacote `br.com.bytebank.banco.teste`.

> Caso ocorra algum erro durante o processo de movimentar os arquivos para um novo pacote, entre no arquivo de origem, pressione com o botão direito na linha de declaração de package e escolha a opção "Move [classe] to [pacote]"
> 

O pacote `br.com.bytebank.banco.teste` ficou vazio, isso é simbolizado por um ícone branco ao lado do nome do pacote.

![https://s3.amazonaws.com/caelum-online-public/843-java-packages/01/1_4_12_pacote+vazio.png](https://s3.amazonaws.com/caelum-online-public/843-java-packages/01/1_4_12_pacote+vazio.png)

Ao observarmos o Navigator veremos que a pasta `teste` existe, mas não está mais armazenando nenhum arquivo, afinal todas as classes foram movidas para `test`.

![https://s3.amazonaws.com/caelum-online-public/843-java-packages/01/1_4_13_pasta+inutilizada+teste.png](https://s3.amazonaws.com/caelum-online-public/843-java-packages/01/1_4_13_pasta+inutilizada+teste.png)

Podemos excluir apenas a pasta `teste` sem que isso altere a ordem da hierarquia dos arquivos, e como ela está vazia, assim o faremos.

Temos toda essa estrutura de pastas dentro de `src` do Eclipse, onde se localiza nosso código fonte; mas temos, ainda, a pasta `bin` que armazena as classes compiladas. Reparem que em `bin` temos a mesma estrutura hierárquica de pastas, ou seja "bin > br > com > bytebank > banco > modelo > test".

Com isso, já sabemos como organizar nossas classes no mundo Java por meio dos pacotes, sempre seguindo a nomenclatura padrão.

Nos falta comentar sobre os modificadores de visibilidade, que podem ser dos tipos `public`, `protected` ou `private`, por exemplo. Trabalharemos nessa questão nas próximas aulas.