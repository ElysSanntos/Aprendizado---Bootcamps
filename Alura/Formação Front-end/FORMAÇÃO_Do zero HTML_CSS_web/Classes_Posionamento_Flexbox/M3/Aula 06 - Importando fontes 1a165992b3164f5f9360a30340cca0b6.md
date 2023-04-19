# Aula 06 - Importando fontes

**Rafaella:** Já temos os tamanhos de fonte do nosso título e do parágrafo. Porém, existe uma grande diferença entre o Figma e a nossa página. Acessaremos o [Figma do projeto](https://www.figma.com/file/4EKKCbr5rS93RWP7kRjXIz/Portfolio---Curso-1?t=6dfeFknOinJA1UCL-0) e veremos que a fonte de ambos os textos é mais arredondada, é diferente.

Se clicarmos no elemento `h1` (o título) pelo Figma, veremos na coluna à direita, na seção "*Text*", o nome da fonte utilizada nesse trecho: *Krona One*. Clicaremos também no parágrafo e veremos na mesma coluna o nome da sua fonte: *Montserrat*. Como utilizaremos essas fontes diferentes do Figma em nosso projeto?

**Guilherme:** Precisaremos trazer para o projeto essas fontes de alguma forma. Importar.

**Rafaella:** Importar, exatamente.

**Guilherme:** Essas fontes já estão em um lugar: o ***Google Fonts***.

**Rafaella:** Exatamente! Acessaremos o site do Google e na barra de pesquisa digitaremos "google fonts". Clicaremos no primeiro link, o qual nos direcionará para o [página inicial do Google Fonts](https://fonts.google.com/). Essa página abrirá com diversas opções de fontes e línguas.

**Guilherme:** Se quisermos alterar a fonte do projeto, nós podemos.

**Rafaella:** Podemos. É possível personalizar da forma que quisermos!

Como vamos importar as fontes? Por meio do Figma, copiaremos o nome da fonte "Krona One" e colaremos no campo de pesquisa denominada "Search fonts", localizada no topo esquerdo da página do Google fonts. Após pressionarmos "Enter", a fonte que pesquisamos será exibida como resultado abaixo do campo de pesquisa. Clicaremos no resultado e seremos direcionados para a [página da fonte Krona One](https://fonts.google.com/specimen/Krona+One?query=krona+one). Vamos descê-la até a seção "Styles", onde veremos os estilos dessa fonte.

As fontes podem ter pesos diferentes: podem vir com **negrito**, com *itálico* ou com regular. No caso dessa fonte, temos apenas a opção "Regular 400". É justamente essa que estamos utilizando no Figma. Dentro da seção "Regular 400" temos um exemplo visual da fonte neste formato e neste peso. No canto direito deste exemplo, temos um botão intitulado "*Select Regular 400*" ("Selecione Regular 400"). Vamos clicar nele. Em seguida clicaremos no ícone denominado "*View selected families*" (ou "Ver famílias selecionadas"), localizado no canto superior esquerdo da página.

Neste momento uma nova coluna será aberta à direita da página, nos informando que temos a família de fontes *Krona One* selecionada. Em seu interior veremos a seção "*Use on the web*" ("use na web"). Nela veremos, lado a lado, dois botões de *radio* denominados `<link>` e `@import`, respectivamente. Eles nos permitem copiar a fonte para utilizarmos em nossas páginas web. A opção "" exibe uma *tag* HTML para ser inserida em um link. Já a opção "@import" nos permite inserir um `@import` no CSS. Vamos selecionar a segunda opção, pois é a que normalmente utilizamos.

Após essa seleção, copiaremos o trecho de código que colaremos no CSS, exibido abaixo dos botões radio:

```
<style>
@import url('https://fonts.googleapis.com/css2?family=Krona+One&display=swap');
</style>COPIAR CÓDIGO
```

Deste trecho, qual parte devemos copiar?

**Guilherme:** Este trecho possui um `<style>`, porém esse `<style>` já é o arquivo CSS em que estamos.

**Rafaella:** Exato. O `<style>` está em formato de *tag* HTML. No HTML é possível adicionarmos um trecho de CSS por meio dessa *tag*. Contudo, ***esta não é uma prática comum nos projetos***. Se o projeto crescer de tamanho, queremos ser capazes de implementar vários estilos e criar uma ou mais folhas de estilo. Além de editá-las, se necessário.

Portanto, vamos copiar somente o trecho de CSS, sem a *tag* `<style>`.

```
@import url('https://fonts.googleapis.com/css2?family=Krona+One&display=swap');COPIAR CÓDIGO
```

**Guilherme:** É só copiar e colar mesmo.

**Rafaella:** Exatamente. O código trará a URL dessa fonte acompanhada do peso selecionado. Basta copiar e colar.

**Guilherme:** Os arquivos dessa fonte estão em algum lugar. Estamos falando para o CSS buscar o local dessa fonte com o `@import` e trazer para o arquivo.

**Rafaella:** Retornando ao código, acessaremos o arquivo `style.css` e na linha 1 pressionaremos "Enter" duas vezes para descer o restante do código. Em seguida, colaremos o trecho copiado no topo do arquivo.

```
@import url('https://fonts.googleapis.com/css2?family=Krona+One&display=swap');

*{
    margin: 0;
    padding: 0;
}COPIAR CÓDIGO
```

Acabamos de importar nossa fonte.

**Guilherme:** Vamos ver o nosso código.

**Rafaella:** Acessaremos o navegador e veremos que não mudou nada. Por que isso ocorre, Gui?

**Guilherme:** Uma coisa é trazer a fonte para o projeto. Outra coisa é informar o local onde se deve aplicá-la.

**Rafaella:** Exatamente. Trouxemos a fonte, mas não estamos usando-a, de fato. Para utilizar uma fonte adicionaremos uma propriedade no elemento onde ela será aplicada. Nós a queremos no título da página, especificamente. Qual a classe desse título?

**Guilherme:** Vamos acessar o arquivo `index.html` para confirmar. Nele temos o `<h1>` cuja classe se chama `apresentacao__conteudo__titulo`.

**Rafaella:** Exato. Retornaremos ao arquivo CSS e buscaremos a seção `.apresentacao__conteudo__titulo{}`. Dentro de suas chaves, abaixo de `font-size`, adicionaremos a propriedade `font-family` para trazer a fonte trazida pelo *Google Fonts*.

```
.apresentacao__conteudo__titulo{
    font-size: 36px;
    font-family: ;
}COPIAR CÓDIGO
```

Adicionaremos qual valor dentro de `font-family`? Retornaremos ao navegador, na página da fonte que acabamos de importar. Na coluna de "Selected Family", abaixo da seção "*Use on the web*", encontraremos a seção "*CSS rules to specify families*" (ou "regras do CSS para especificar famílias") na qual veremos o código CSS para implementar a nossa fonte.

```
font-family: 'Krona One', sans-serif;COPIAR CÓDIGO
```

Copiaremos o trecho `'Krona One', sans-serif`, retornaremos ao arquivo CSS e o colaremos à direita do nosso `font-family`.

```
.apresentacao__conteudo__titulo{
    font-size: 36px;
    font-family: 'Krona One', sans-serif;
}COPIAR CÓDIGO
```

Salvaremos o código e retornaremos ao navegador, onde veremos a fonte *Krona One* aplicada ao título. Estamos bem mais próximos do que temos no Figma.

**Guilherme:** Vamos realizar o mesmo processo no parágrafo de forma bem rápida?

**Rafaella:** Vamos. No parágrafo aplicaremos a fonte *Montserrat*. Retornaremos à página inicial do *Google Fonts* no navegador e digitaremos "Montserrat" no campo de pesquisa. A página retornará diversas opções abaixo, dentre as quais selecionaremos aquela denominada simplesmente "Montserrat".

Desceremos a página até a seção "Styles" e veremos que esta fonte possui mais de um estilo. Vamos conferir o estilo desejado acessando o Figma, selecionando o texto a ser editado e acessando a coluna à direita. No topo dela, selecionaremos a aba "Inspect". Em seu interior acessaremos a seção "CSS", a qual possui as informações da nossa fonte.

Neste caso, não vale a pena copiar e colar o código CSS diretamente do Figma.

**Guilherme:** Vai dar errado.

**Rafaella:** No Figma podemos ver o peso da fonte no atributo `font-weight` dentro da aba "Inspect": 400. Retornando à página do *Google Fonts*, é interessante observar que temos muitas opções. Na seção "Styles" buscaremos ao lado direito dos exemplos visuais de fonte o botão "*Select Regular 400*" e clicaremos nele.

Acessaremos a coluna "*Selected families*", buscaremos e selecionaremos a opção "@import". Em seguida, copiaremos o trecho entre as *tags* de `<style>`.

```
<style>
@import url('https://fonts.googleapis.com/css2?family=Krona+One&family=Montserrat&display=swap');
</style>COPIAR CÓDIGO
```

**Guilherme:** Este link acoplou as duas fontes.

**Rafaella:** Exato. Voltando ao código, no arquivo CSS substituiremos o nosso `import` antigo pelo copiado. Agora estamos importando com o mesmo comando as duas fontes, *Krona One* e *Montserrat*.

```
@import url('https://fonts.googleapis.com/css2?family=Krona+One&family=Montserrat&display=swap');

*{
    margin: 0;
    padding: 0;
}COPIAR CÓDIGO
```

Retornaremos à coluna lateral do *Google Fonts* onde encontraremos o código das fontes *Krona One* e *Montserrat*, disponíveis na seção "*CSS Rules to specify families*".

```
font-family: 'Krona One', sans-serif;
font-family: 'Montserrat', sans-serif;COPIAR CÓDIGO
```

Copiaremos o trecho da fonte a ser importada: `'Montserrat', sans-serif`, e colaremos dentro das chaves de `.apresentacao__conteudo__texto{}`, abaixo de `font-size`.

```
.apresentacao__conteudo__texto{
    font-size: 24px;
    font-family: 'Montserrat', sans-serif;
}COPIAR CÓDIGO
```

Salvaremos nosso código e retornaremos à página da nossa aplicação no navegador, onde veremos as fontes aplicadas corretamente.

**Guilherme:** Já está muito legal.

**Rafaella:** Já.