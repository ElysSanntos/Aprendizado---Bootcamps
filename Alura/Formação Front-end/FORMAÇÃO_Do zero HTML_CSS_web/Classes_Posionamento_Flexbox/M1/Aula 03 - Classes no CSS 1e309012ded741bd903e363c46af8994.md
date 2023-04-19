# Aula 03 - Classes no CSS

**Rafaella:** Estamos em uma situação na qual queremos determinar uma cor específica para tag `strong` sem que essa formatação passe para todos os elementos que a utilizam. E existe uma maneira para fazermos isso.

No arquivo `style.css`, estamos usando as tags `body` e `strong` como **seletores** do CSS, o que significa que conseguimos escrever o nome da tag, as chaves (`{}`) e o que queremos que altere nela dentro dessas chaves. No caso do `body`, é a cor do fundo e da letra.

Contudo, essa não é a única forma de seletor, e uma dela que é muito utilizada no dia a dia é o **seletor de classe** que consegue resolver justamente esse problema. Portanto, vamos aprender como utilizá-lo.

Para isso, acessaremos o Google.

**Guilherme:** Podemos escrever, por exemplo, "classes CSS W3C". Inclusive o correto é "W3S", mas o Google conseguiu achar para nós como "W3C". Podemos abrir o primeiro resultado, que é o [CSS .class Selector - W3Schools](https://www.w3schools.com/cssref/sel_class.php).

Nessa página ele tem um exemplo e uma definição, que está em inglês. Vamos alterar para o português, clicando na opção de tradução do google tradutor, que fica no canto direito da barra de endereço.

> Dica: Inclusive pode aparecer uma janela flutuante com a opção de tradução no lado inferior direito da barra de endereços. O idioma inglês estará selecionado e, ao lado dele, aparecerá a opção "português". Basta clicar nela.
> 

Então na seção "**Definição e Uso**" descobrimos que um seletor `.class` irá selecionar elementos com os atributos de uma classe específica. Essa explicação ficou um pouco confusa, mas o que ela quer dizer é que conseguimos selecionar partes para o CSS estilizar. Para selecionar cada elemento de uma classe específica, devemos escrever o ponto (referindo-se ao ponto final, ou seja, `.`).

Voltando para o nosso CSS, Rafa, repara que todas as nossas tags estão exatamente com o nome delas.

**Rafaella:** Exato!

**Guilherme:** O `body` e o `strong`, mas poderia ser também o `h1`, `h2`, `h3`, `h4` e assim por diante. Basta escrevermos na estrutura `nomeDaTag {}` e dentro das chaves escrevermos as configurações.

Quando trabalhamos com classes, é diferente. Para criarmos classes no CSS, primeiramente vamos ao HTML e especificamos que a tag possui uma classe específica.

**Rafaella:** Então, no Explorador, abriremos o arquivo `index.html` e na linha 13, onde temos a `<strong>` adicionaremos a propriedade `class` (classe). Essa propriedade fica realmente dentro da tag, como descobrimos com as imagens e com a âncora.

Portanto para definir uma classe para qualquer tag, basta escrever `class=""` e entre as aspas o nome da classe que queremos, tudo isso dentro da tag, no caso, `<strong class="">`.

```
//código suprimido
<strong class="">com um Front-end de qualidade!</strong></h1>
//código suprimidoCOPIAR CÓDIGO
```

Essa estrutura se aplica a **qualquer tag** para qual queiramos definir uma classe.

**Guilherme:** Boa, Rafa. Eu vou apenas fechar o Explorador para conseguirmos visualizar o código melhor.

E como funciona a **nomeação da classe**? Pode ser qualquer nome?

**Rafaella:** Existem diversos padrões que podemos seguir, mas nesse começo, recomendo sempre escrevermos algo que deixa bem óbvio do que se trata. Por exemplo, estamos no título da nossa página, e o `strong` é um **destaque** desse título, então seria bom nomearmos a classe como "titulo-destaque" ou "destaque-titulo".

**Guilherme:** Então sempre nomeamos de uma forma que faça sentido para aquele elemento.

**Rafaella:** Isso mesmo. Depois aprenderemos também um padrão que podemos seguir, por exemplo, estamos usando a classe "titulo-destaque", então para classe do título podemos escrever apenas "titulo". Então conseguimos encontrar padrões de nomes.

**Guilherme:** E aprenderemos isso com o passar do tempo.

**Rafaella:** Vamos então nomear como `class="titulo-destaque"`.

**Guilherme:** Descobrimos também que para selecionar esse `titulo-destaque` precisamos usar o ponto (`.`) . Portanto voltaremos para o arquivo `style.css` e, no lugar do `strong`, escreveremos `.titulo-destaque`.

```
body {
    background-color: #000000;
    color: #F6F6F6;
}

.titulo-destaque {
    color: #22D4FD;
}COPIAR CÓDIGO
```

Reparem que agora estamos em um momento diferente. Sempre que criamos uma classe CSS, selecionamos essa classe com o ponto final.

**Rafaella:** É a forma que informamos para o CSS que se trata de uma classe e não apenas de uma tag do HTML.

**Guilherme:** Temos outro desafio agora, Rafa. Pelo que fizemos, apenas o `titulo-destaque` estará na cor azul, enquanto o segundo `strong`, que está na linha 14 e que removeremos depois, porque foi apenas um exemplo, não estará com uma cor diferente.

**Rafaella:** Exato. É apenas para o `strong` do título estar azul.

**Guilherme:** Quando abrimos nosso projeto no navegador, observamos que funcionou. Conseguimos deixar a mesma tag, mas com uma classe específica, o que é bem comum, certo Rafa?

**Rafaella:** Isso! A classe é como um agrupamento de tipo. E podemos perceber que mesmo assim o trecho "**React, HTML e CSS**", na segunda linha, ficaram em destaque, mas apenas em negrito.

Isso ocorre porque o `strong` faz essa alteração quando é inserido em uma tag `<p>`. Portanto não se assustem, não é nenhuma configuração fora do normal ou alteração do CSS que fizemos, é porque utilizamos o `<strong>` que, por padrão, deixa o trecho em negrito dentro do parágrafo.

Porém podemos remover essa tag da linha 14, porque esse destaque não existe no modelo do [nosso Figma](https://www.figma.com/file/EjGLdArvshxGrwP9YDTZzT/Forma%C3%A7%C3%A3o-HTML-e-CSS?node-id=378%3A863&t=AnPDzv24lI2M8UXg-1). Ao retornarmos à página, observamos que o destaque sumiu no parágrafo, mas se manteve no título.

Agora aprendemos a utilizar classes no CSS e já podemos criá-las e utilizá-las em outras partes do projeto.