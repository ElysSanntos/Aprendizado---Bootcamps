# Aula 05 - Importando pacotes

Começamos anteriormente, a discutir a questão dos pacotes. Vimos como o Package Explorer atua na visualização simplificada dos arquivos, mas por hora continuaremos fazendo uso do Navigator que exibe mais conteúdos.

Criamos os pacotes `modelo` e `teste` para separarmos as classes. Observamos que essa informação de armazenamento deve constar no código fonte usando a palavra chave `package`, e que o nome da classe se modifica ao realizarmos a reorganização dos arquivos. Esse nome completo da classe é conhecido por *full qualified name*; internamente a máquina sempre utilizará esse nome completo para fazer a identificação das classes.

No entanto, podemos perceber que a nossa nomenclatura ainda é frágil, olhemos para a classe `CalculadorDeImposto`, por exemplo: o Java é uma linguagem muito popular no Brasil, imaginem quantas classes chamadas `CalculadorDeImposto` não existem no país? Além disso, o nome do pacote `modelo` também é muito comum, algumas pessoas utilizam o nome `dominio`.

Como esses nomes são bem comuns, é muito provável que já tenham os utilizado em outro projeto, isso é um problema no momento em que precisamos utilizar um código escrito por outra pessoa e a mesma nomenclatura foi utilizada em seu próprio projeto.

A ideia geral é: como podemos aproveitar classes com o mesmo nome em um outro projeto, sem precisar renomear nenhuma delas?

No sistema operacional, ao abrimos uma pasta, sabemos que dentro dela não podem ser criados dois arquivos com o mesmo nome, o mesmo vale para o mundo Java.

Em `src` criaremos uma pasta com o nome do projeto, ou seja, `banco`. Dentro dessa pasta colocaremos todas as classes de `modelo`; para isso, selecionamos `modelo` no visualizador Navigator e o arrastamos para dentro da pasta `banco`. Faremos o mesmo procedimento com `teste`.

![https://s3.amazonaws.com/caelum-online-public/843-java-packages/01/1_3_7_nova+pasta+banco.png](https://s3.amazonaws.com/caelum-online-public/843-java-packages/01/1_3_7_nova+pasta+banco.png)

Veremos que assim que fizemos essa modificação, os erros novamente surgem, afinal o pacote não é reconhecido apenas por `modelo`, pois incluímos esta pasta dentro de outra denominada `banco`. Precisaremos fazer a seguinte modificação para que os códigos compilem corretamente:

```
package banco.modelo;

public class CalculadorDeImposto {

    private double totalImposto;

    public void registra(Tributabel t) {
        double valor = t.getValorImposto();
        this.totalImposto += valor;
    }
COPIAR CÓDIGO
```

Estamos utilizando o nome do projeto na nomenclatura das classes `banco.modelo`, adotando o nome mais específico. No entanto, a comunidade Java ainda considera essa nomeação frágil, e conflitos ainda podem ocorrer no desenvolvimento de um projeto.

Iremos incluir outra pasta que terá o nome da empresa, que por sua vez guardará todas as pastas e classes específicas.

O nome da nossa pasta será `bytebank`, e ela conterá a pasta`banco`, que por sua vez contém `modelo` e `teste`. Mesmo assim, a comunidade Java não está satisfeita, a nomenclatura pode ainda gerar confusões já que podem existir duas ou mais empresas no mundo com o mesmo nome.

O que de fato identifica uma empresa de forma única no mundo inteiro? No caso da **Alura**, o que a identifica na web é seu endereço, ou seja **[www.alura.com.br](http://www.alura.com.br/)**. Só existe esse endereço para esta página.

Aproveitaremos a ideia dos endereços da internet nos pacotes Java. Criaremos um conjunto de pastas que recriam o endereço do portal, iniciando pelo país, ou seja, em `src` criaremos uma pasta denominada `br`; depois criaremos uma pasta `com` que representa o sub-domínio. Portanto, temos a seguinte organização de arquivos: "src > br > com > bytebank > banco > modelo,teste", essa é a sistematização do Java que encontraremos em nosso dia a dia.

Qual será o *full qualified name* da classe `CalculadorDeImposto` nesta altura do projeto?

Além da palavra chave `package` inseriremos no começo do código fonte `br.com.bytebank.banco.modelo`. E o nome da classe será `br.com.bytebank.banco.modelo.CalculadorDeImposto`.

```
package br.com.bytebank.banco.modelo;

public class CalculadorDeImposto {

    private double totalImposto;

    public void registra(Tributavel t) {
        double valor = t.getValorImposto();
        this.totalImposto += valor;
    }
//...COPIAR CÓDIGO
```

Esse tipo de estruturação pode parecer exagerada em um primeiro momento, mas essa prática se tornou muito útil durante o desenvolvimento de projetos. Não precisamos criar todas as pastas manualmente como fizemos até este ponto, a ferramenta Eclipse criará as pastas de forma automática e rápida.

Aprendemos que o nome completo da classe `CalculadorDeImposto` é `br.com.bytebank.banco.modelo.CalculadorDeImposto`. Veremos o nome da classe `TesteTributaveis`. Percebam que o Eclipse irá autocompletar a linha, porque já conhece a estrutura padrão.

Mas precisamos alterar as classes que estão sendo citadas ao longo do código, incluindo seus respectivos nomes completos para que o código seja compilado corretamente.

```
package br.com.bytebank.banco.teste.TesteTributaveis;

public class TesteTributaveis {

    public static void main(String[] args} {
        br.com.bytebank.banco.modelo.ContaCorrente cc = new br.com.bytebank.banco.modelo.ContaCorrente(222,333);

        br.com.bytebank.banco.modelo.SeguroDeVida seguro = new model.SeguroDeVida();

        br.com.bytebank.banco.modelo.CalculadorDeImposto calc = new br.com.bytebank.banco.modelo.CalculadorDeImposto();
COPIAR CÓDIGO
```

Além de ser um processo trabalhoso, esse tipo de ação dificulta a legibilidade do código. Não precisamos fazer deste modo, existe a opção de importarmos o pacote necessário e com isso podemos continuar utilizando o nome simples das classes.

As importações são expressas logo abaixo da palavra-chave `package`, sendo essa uma estrutura regular de organização do código. Acionaremos a palavra chave `import` e vamos declarar o que queremos importar.

```
package br.com.bytebank.banco.teste;

import br.com.bytebank.banco.modelo.*;
COPIAR CÓDIGO
```

Com isso, podemos manter nosso código mais limpo e otimizar as adaptações necessárias.

Como vocês puderam ver, há muitas adequações que devemos realizar em nosso código atualmente, precisamos realizar as importações necessárias e corrigir as classes que aparecem com nomes incorretos. Façam isso, observem o que precisa ser retificado e, apenas então, prosseguiremos nas próximas lições.