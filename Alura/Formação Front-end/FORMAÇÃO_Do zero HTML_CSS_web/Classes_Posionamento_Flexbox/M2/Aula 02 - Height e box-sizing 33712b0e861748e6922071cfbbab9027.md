# Aula 02 - Height e box-sizing

**Guilherme:** No nosso código CSS, aplicamos o `margin: 0` e o `padding: 0`. Existem outros padrões para adicionarmos e desenvolvermos nosso projeto de uma forma legal, Rafa?

É bom sabermos esses padrões desde o começo. Por exemplo, existe alguma forma de garantirmos que nossa página ocupará 100% do tamanho da tela? Porque isso é bem importante.

Vamos voltar ao [Figma do projeto](https://cursos.alura.com.br/course/html-css-classes-posicionamento-flexbox/task/118640) para eu mostrar uma coisa para você. Nesse Figma, toda nossa aplicação fica em uma tela. Não temos scroll, está tudo em uma tela só.

![https://cdn1.gnarususercontent.com.br/1/935581/49e15161-1a46-4440-9cb5-6a66625f046d.png](https://cdn1.gnarususercontent.com.br/1/935581/49e15161-1a46-4440-9cb5-6a66625f046d.png)

Tem alguma propriedade do CSS que nos permite informar que ocupamos todo tamanho dessa tela e como vermos que não está ocupando?

**Rafaella:** Tem sim, vamos descobrir como. Abrindo o "Inspecionar" do nosso projeto de portfólio, e aqui eu vou diminuir o zoom, porque está em 155%, ao passarmos o mouse sobre o código `body`, na coluna da direita.

Lembrando que o `body` contém todo nosso conteúdo e, ao observamos a seleção, notamos que ele não ocupa toda página. Na verdade ele termina praticamente na metade da página.

O que conseguimos fazer é usar um padrão inicial no qual sempre conseguimos usar 100% da altura da tela. Para isso, voltaremos ao arquivo `style.css` no VS Code e, dentro das chaves do `body`, adicionaremos o valor de `height` (**altura**).

> Lembrete: É comum confundir a posição do "T" em height, para isso, fica o lembrete que o T é no final.
> 

E definiremos uma altura para o nosso *body*

**Guilherme:** Lembrem que o "T" de ***height*** fica no final, pessoal, para não se confundirem!

**Rafaella:** E nós vamos definir uma altura para o nosso `body`, ou seja, todo corpo da página. E o valor que vamos atribuir é de `100vh`.

```
body {
    height: 100vh;
    background-color: #000000;
    color: #F6F6F6;
}COPIAR CÓDIGO
```

E o que é esse **vh**?

**Guilherme:** Nós demos um *spoiler* sobre isso quando fizemos o `index.html`, certo, Rafa?

**Rafaella:** Sim! Vou até voltar para o arquivo do `index.html`, onde criamos uma `meta` informação na linha 6 chamada `viewport`. Essa é a tela onde estamos acessando nosso projeto.

Então no CSS nós definimos a altura dessa tela equivalente a **100% do *viewport***, ou seja, da tela do nosso projeto no navegador.

**Guilherme:** E isso já mudou no navegador?

**Rafaella:** Vamos ver. Vamos recarregar a tela do nosso projeto no navegador e com o Inspecionar ainda aberto, vamos passar o mouse sobre o código do elemento `body`. Feito isso, toda tela fica azul, que é a cor desse elemento, então estamos ocupando 100% da tela!

**Guilherme:** Bem legal!

**Rafaella:** E esse é um padrão que podemos utilizar sempre, no começo dos nossos códigos. Além disso, tem outro padrão interessante de adicionarmos.

**Guilherme:** Nós informamos que a altura máxima será equivalente a toda a tela do dispositivo, agora precisamos garantir que nada fique de fora dessa tela.

**Rafaella:** O que o Guilherme está tentando dizer é que às vezes temos uma imagem cuja margem à esquerda fica tão grande que ela sai do `body`. Então precisamos garantir que os elementos "filhos", que estão dentro das tags maiores, como a tag "pai" `<body>`, ou seja, uma tag que está abaixo de outra não saia da tela.

Para isso, temos uma propriedade, que veremos agora na documentação. Para acessar a documentação, vamos pesquisar pelo nome da propriedade, que é "***box sizing***". E para ela eu gosto muito de usar como referência o Mozilla, porque tem um exemplo mais visual.

Então acessaremos a página [box-sizing do Mozilla](https://developer.mozilla.org/en-US/docs/Web/CSS/box-sizing) e traduziremos o texto para o Português. No começo da página já encontramos **três exemplos** de *box sizing* no centro esquerdo da página, e o efeito deles no conteúdo do lado direito.

Inicialmente temos o valor do `content-box`, e ele declara o `width` (largura) de 100%. No segundo exemplo também tem um `content-box` ao qual é adicionado uma borda e um *padding*, que já aprendemos o que são. Por fim, tem um `box-sizing` com o valor `border-box`.

```
box-sizing: content-box;
width: 100%;

box-sizing: content-box;
width: 100%;
border: solid #5B6DCD 10px;
padding: 5px;

box-sizing: border-box;
width: 100%;
border: solid #5B6DCD 10px;
padding: 5px;COPIAR CÓDIGO
```

A cada exemplo que clicamos, observamos como o conteúdo vai se alterando no lado direito. Então com o primeiro momento o elemento "filho" tem 100% da largura, então ele fica completamente dentro do elemento "pai". Pensando no nosso projeto, se deixássemos a imagem com `width: 100%`, ela ocuparia toda a largura do `body`.

No segundo exemplo temos uma borda e um padding. Se quiséssemos aplicar isso à imagem do nosso projeto, ou seja, adicionar uma borda colorida e deixar um espaçamento entre essa borda e o conteúdo, a imagem iria sair do nosso `body`, como aconteceu conteúdo do exemplo.

Com o valor `content-box` no `box-sizing` pode acontecer isso, e não é o que queremos. O que queremos é o valor `border-box`, porque com ele conseguimos criar, por exemplo, uma borda e um padding, ou o que quisermos, e o conteúdo será encolhido para sempre ser mantido dentro do elemento "pai".

Pode não parecer legal encolher esse conteúdo, mas é isso que faz com que tenhamos controle de como todos os elementos estão funcionando, já que é muito frustrante estar fazendo uma alteração no elemento "filho" e ele sair do "pai. Outro exemplo no nosso projeto: temos como "filho" o destaque do título, imagina se ele sai do elemento "pai".

Então precisamos desse controle do "filho" dentro do "pai", e para isso conseguimos usar como padrão o `box-sizing: border-box`. Sendo assim, vamos copiar esse código e adicioná-lo ao `body` do CSS.

```
body {
    height: 100vh;
    box-sizing: border-box;
    background-color: #000000;
    color: #F6F6F6;
}COPIAR CÓDIGO
```

Vamos salvar e atualizar a página do projeto no navegador.

**Guilherme:** Visualmente não notamos nenhuma diferença, mas agora nada vai sair da nossa página.

**Rafaella:** E essa é uma ótima prática para vocês aplicarem em todos os projetos que criarem, caso a intenção seja evitar que a imagem saia do body, ou seja, evitar que o elemento "filho" saia do elemento "pai".