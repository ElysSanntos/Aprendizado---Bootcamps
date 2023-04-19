# Aula 05 - Estilizando o texto

**Guilherme:** Se compararmos a expectativa com a realidade, veremos que o texto da nossa aplicação está posicionado. Entretanto, o tamanho desses elementos...

**Rafaella:** Dessa seção, né.

**Guilherme:** Isso! Dessa seção. A linguagem está ficando mais técnica.

**Rafaella:** Exato.

**Guilherme:** O tamanho da nossa seção de texto está diferente do Figma, onde ela possui um tamanho específico.

**Rafaella:** Exatamente. É possível definir um tamanho para que todos os elementos caibam dentro da seção. Para isso, utilizaremos uma propriedade dentro do arquivo CSS.

Precisamos de uma `class` para definir essa `section` localizada no `index.html`, assim como ocorre com a classe `main`. Portanto vamos adicioná-la entre os sinais de menor e maior da tag `<section>`. Qual será o nome dessa classe, Gui?

**Guilherme:** Estamos no elemento pai que é o `main`, cuja `class` é `apresentacao`. Embaixo criaremos uma nova seção, na qual colocaremos primeiro o nome do pai: `apresentacao`.

> Dica: Por padrão, para nomear elementos filhos, as pessoas utilizam o nome do elemento pai junto ao sinal __ e junto ao nome que será criado para o elemento filho.
> 

Já que se trata do conteúdo — ou seja, o `h1`, o texto e os links — vamos chamá-lo de `conteudo`, pode ser?

**Rafaella:** Vamos. Será `apresentacao__conteudo`.

```
    <main class="apresentacao">
    <section class="apresentacao__conteudo">
        <h1>Eleve seu negócio digital a outro nível <strong class="titulo-destaque">com um Front-end de qualidade!</strong></h1>
        <p>Olá! Sou Joana Santos, desenvolvedora Front-end com especialidade em React, HTML e CSS. Ajudo pequenos negócios e designers a colocarem em prática boas ideias. Vamos conversar?
        </p>
        <a href="https://instagram.com/rafaballerini">Instagram</a>
        <a href="https://github.com/guilhermeonrails">Github</a>
    </section><img src="imagem.png" alt="Foto da Joana Santos programando">COPIAR CÓDIGO
```

Acessaremos o nosso `style.css` e adicionaremos abaixo das chaves de `.apresentacao{}` uma nova seção chamada `.apresentacao__conteudo{}`.

```
.apresentacao {
    display: flex;
    align-items: center;
    justify-content: space-between;
}

.apresentacao__conteudo{

}COPIAR CÓDIGO
```

Definiremos uma largura para essa `section`. De onde retiraremos esse valor?

**Guilherme:** Não vamos tirar da nossa cabeça, e sim da cabeça de quem fez o Figma!

**Rafaella:** Exatamente.

**Guilherme:** Vamos acessar o [Figma do projeto](https://www.figma.com/file/4EKKCbr5rS93RWP7kRjXIz/Portfolio---Curso-1?node-id=0%3A1) para procurar o valor dessa largura.

**Rafaella:** A pessoa que fez o Figma inseriu e agrupou os elementos. Podemos clicar neles e ver as informações sobre cada seção de elementos no canto direito da tela. Nele buscaremos a aba "Design", onde veremos um valor `W`. O que seria esse valor?

**Guilherme:** É *width*, ou seja, a largura.

**Rafaella:** Exatamente, `W` é a largura e `H` é altura, ou *height*.

**Guilherme:** Uma dica que eu dou: o W é mais largo e lembra a largura, enquanto o H é mais alto e lembra a altura. Isso me ajuda.

**Rafaella:** Interessante. Gostei.

Vamos clicar no valor de `W` e copiá-lo — ele corresponde a `615`. Voltaremos ao nosso código e dentro das chaves de `.apresentacao__conteudo{}` vamos adicionar um `width:` e colar o valor copiado.

Este `615` corresponde a qual unidade?

**Guilherme:** Pixel.

**Rafaella:** Exatamente. Portanto adicionaremos `px` e salvaremos o código.

```
.apresentacao__conteudo{
    width: 615px;
}COPIAR CÓDIGO
```

Voltaremos ao navegador. O que aconteceu?

**Guilherme:** O bloco de texto não está mais tão comprido, existe um limite.

**Rafaella:** Exato. Quando o conteúdo chega no limite dessa `width` que configuramos, ele é quebrado para a linha de baixo.

**Guilherme:** Então eu sugiro um próximo passo, Rafa. Vamos aumentar o tamanho do nosso título? Se verificarmos o Figma, ele é grande.

**Rafaella:** Sim. O título é bem maior.

**Guilherme:** Podemos selecioná-lo isoladamente no Figma?

**Rafaella:** Podemos.

**Guilherme:** Este título tem um tamanho de 36 pixels. Podemos localizar esta informação na seção "Text" na coluna lateral direita do Figma. Vamos colocar esse tamanho no código.

Este conteúdo é novo, nós nunca havíamos alterado o tamanho de uma fonte.

**Rafaella:** Exato. Retornaremos ao nosso código e acessaremos o arquivo `index.html`. Em seu interior buscaremos a tag `<h1>` e entre os sinais de menor e maior adicionaremos uma `class`. Qual será o nome dessa classe?

**Guilherme:** Podemos chamá-la de `apresentacao__conteudo__titulo`.

**Rafaella:** Pode ser.

```
    <main class="apresentacao">
    <section class="apresentacao__conteudo">
        <h1 class="apresentacao__conteudo__titulo">Eleve seu negócio digital a outro nível <strong class="titulo-destaque">com um Front-end de qualidade!</strong></h1>
        <p>Olá! Sou Joana Santos, desenvolvedora Front-end com especialidade em React, HTML e CSS. Ajudo pequenos negócios e designers a colocarem em prática boas ideias. Vamos conversar?
        </p>
        <a href="https://instagram.com/rafaballerini">Instagram</a>
        <a href="https://github.com/guilhermeonrails">Github</a>
    </section><img src="imagem.png" alt="Foto da Joana Santos programando">COPIAR CÓDIGO
```

Salvaremos o código e abriremos o arquivo `style.css`para utilizar esse nome de classe.

**Guilherme:** Boa.

**Rafaella:** No arquivo CSS, abaixo das chaves de `.apresentacao__conteudo{}`, criaremos a `.apresentacao__conteudo__titulo{}`.

```
.apresentacao {
    display: flex;
    align-items: center;
    justify-content: space-between;
}

.apresentacao__conteudo{
    width: 615px;
}

.apresentacao__conteudo__titulo{

}COPIAR CÓDIGO
```

**Guilherme:** Como alteraremos o tamanho da fonte, Rafa?

**Rafaella:** Temos uma propriedade chamada `font-size`, onde `font` corresponde à fonte e `size` ao tamanho. Vamos adicioná-la dentro das chaves de `.apresentacao__conteudo__titulo{}`. em seguida adicionaremos o valor `36px` que coletamos do Figma.

```
.apresentacao__conteudo__titulo{
    font-size: 36px;
}COPIAR CÓDIGO
```

Salvaremos e retornaremos ao navegador para conferir a mudança no tamanho da fonte do título.

**Guilherme:** Está ficando bem legal.

**Rafaella:** Está. Vamos alterar também o conteúdo do subtítulo, ou seja, do parágrafo. Ele possui um tamanho específico que também podemos extrair do Figma: 24 pixels.

Retornaremos ao arquivo `index.html` e buscaremos a tag `<p>`. Entre os sinais de menor e maior dela criaremos uma `class`. Qual será o nome dela?

**Guilherme:** Pode ser `apresentacao__conteudo__texto`?

**Rafaella:** Pode ser.

```
    <main class="apresentacao">
    <section class="apresentacao__conteudo">
        <h1 class="apresentacao__conteudo__titulo">Eleve seu negócio digital a outro nível <strong class="titulo-destaque">com um Front-end de qualidade!</strong></h1>
        <p class="apresentacao__conteudo__texto">Olá! Sou Joana Santos, desenvolvedora Front-end com especialidade em React, HTML e CSS. Ajudo pequenos negócios e designers a colocarem em prática boas ideias. Vamos conversar?
        </p>
        <a href="https://instagram.com/rafaballerini">Instagram</a>
        <a href="https://github.com/guilhermeonrails">Github</a>
    </section><img src="imagem.png" alt="Foto da Joana Santos programando">COPIAR CÓDIGO
```

Salvaremos o código e acessaremos o arquivo `style .css`. Abaixo das chaves de `.apresentacao__conteudo__titulo{}` adicionaremos um `apresentacao__conteudo__texto{}`. Em seu interior adicionaremos um `font-size: 24px`.

```
.apresentacao {
    display: flex;
    align-items: center;
    justify-content: space-between;
}

.apresentacao__conteudo{
    width: 615px;
}

.apresentacao__conteudo__titulo{
    font-size: 36px;
}

.apresentacao__conteudo__texto{
    font-size: 24px;
}COPIAR CÓDIGO
```

Salvaremos esse código e voltaremos ao navegador, onde veremos os textos com os tamanhos certos.

**Guilherme:** Está ficando cada vez melhor.