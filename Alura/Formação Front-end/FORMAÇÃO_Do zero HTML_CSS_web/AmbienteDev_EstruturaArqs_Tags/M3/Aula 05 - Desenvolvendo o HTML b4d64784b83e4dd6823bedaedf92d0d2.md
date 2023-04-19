# Aula 05 - Desenvolvendo o HTML

**Rafaella:** Vamos **começar a *codar*** dentro do nosso **`<main>`**.

O primeiro passo é **entender** o que precisamos fazer em nossa página *web* e **planejar** o que iremos estruturar.

**Guilherme:** Observando a tela inicial do projeto no Figma, notaremos dois blocos de texto um em cima do outro, dois botões lado a lado logo abaixo de "Instagram" e "GitHub", e uma imagem à direita desses elementos.

**Rafaella:** Uma boa sugestão é começar a trabalhar com os elementos **da esquerda para direita, de cima para baixo**. Então começaremos pelo título, depois pelo parágrafo, seguido pelos botões, e por fim colocaremos a foto.

Vamos fazer isso no nosso arquivo `index.html` no VSCode.

Abriremos uma nova linha dentro da *tag* `<main>` e começaremos com o título usando **`<h1>`**, em que "h" remete a "*heading*".

Voltaremos ao Figma e clicaremos várias vezes sobre o texto para o selecionarmos inteiro, para depois copiarmos o escrito com "Ctrl + C" e colarmos dentro de `<h1>` com "Ctrl + V".

```
<!DOCTYPE html>
<html lang="pt-br">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Portfolio</title>
</head>
<body>
    <header></header>
    <main>
        <h1>Eleve seu negócio digital a outro nível com um Front-end de qualidade!</h1>
    </main>
    <footer></footer>
</body>
</html>COPIAR CÓDIGO
```

**Rafaella:** Outro detalhe importante é que, ainda na parte do título, o trecho "com um Front-end de qualidade!" possui uma cor diferente que o destaca do começo do texto.

Para fazer essa diferenciação, existe uma *tag* semântica em nosso próprio HTML que indica ao navegador que deve destacar essa parte.

**Guilherme:** É para deixarmos este trecho mais em forte evidência mesmo.

**Rafaella:** Para isso, antes desta parte de destaque, aplicaremos a **`<strong>`**, que é justamente a palavra em inglês para "forte", e a fecharemos antes do fechamento da `<h1>`, pois a *tag* está dentro dela.

```
<!DOCTYPE html>
<html lang="pt-br">

//código omitido

<body>
    <header></header>
    <main>
        <h1>Eleve seu negócio digital a outro nível<strong>com um Front-end de qualidade!</strong></h1>
    </main>
    <footer></footer>
</body>
</html>COPIAR CÓDIGO
```

**Rafaella:** Salvaremos esse código e veremos o resultado no navegador.

![https://cdn1.gnarususercontent.com.br/1/308174/6d8ed07a-d723-43f9-b29f-87cf4ee1ad02.png](https://cdn1.gnarususercontent.com.br/1/308174/6d8ed07a-d723-43f9-b29f-87cf4ee1ad02.png)

**Guilherme:**

Visualmente, não há diferença entre os trechos, mas o navegador já sabe que a parte importante deve ser destacada.

**Rafaella:** Trabalharemos com essas questões visuais quando entrarmos na parte de **estilização**.

Em seguida, observando o Figma, teremos o nosso parágrafo que também copiaremos e, logo abaixo da `</h1>` no `index.html`, adicionaremos a *tag* **`<p>`** de "parágrafo" que já conhecemos para então colarmos o texto dentro dela.

```
<!DOCTYPE html>
<html lang="pt-br">

//código omitido

<body>
    <header></header>
    <main>
        <h1>Eleve seu negócio digital a outro nível<strong>com um Front-end de qualidade!</strong></h1>
        <p>Olá! Sou Joana Santos, desenvolvedora Front-end com especialidade em React, HTML e CSS. Ajudo pequenos negócios e designers a colocarem em prática boas ideias. Vamos conversar?</p>
    </main>
    <footer></footer>
</body>
</html>COPIAR CÓDIGO
```

**Guilherme:** Lembrando que o escrito pode mudar, afinal nem todo mundo se chama "Joana Santos". Vamos salvar e ver o resultado.

![https://cdn1.gnarususercontent.com.br/1/308174/cb1b3050-9bb6-4022-8e4e-bb72274cc682.png](https://cdn1.gnarususercontent.com.br/1/308174/cb1b3050-9bb6-4022-8e4e-bb72274cc682.png)

**Rafaella:** Com isso, já teremos as duas partes de texto em nossa página, e agora vamos colocar os dois botões. Mas o que são de fato?

**Guilherme:** Excelente pergunta; quando clicamos em "Instagram" ou "GitHub", o esperado é que nos redirecionem para outro lugar. Mas esta questão de **redirecionamento** para outra página geralmente **não é o comportamento de um botão**.

Existe uma *tag* do HTML chamada `<Botao>` que é usada quando estamos trabalhando com formulário, por exemplo. Semanticamente, neste nosso caso, usaremos a *tag* âncora **`<a>`**.

**Rafaella:** Certo, então a adicionaremos após `</p>` e sabemos que ela abre e fecha também. Mas o que colocamos como conteúdo?

**Guilherme:** Colocaremos o *link*. Se voltarmos ao código, o que escrevermos dentro dela como um texto é o que será exibido na tela, ou seja, `Instagram`. Inseriremos outra *tag* `<a>` abaixo e adicionaremos `Github` para salvarmos e vermos o resultado.'

```
<!DOCTYPE html>
<html lang="pt-br">

//código omitido

<body>
    <header></header>
    <main>
        <h1>Eleve seu negócio digital a outro nível<strong>com um Front-end de qualidade!</strong></h1>
        <p>Olá! Sou Joana Santos, desenvolvedora Front-end com especialidade em React, HTML e CSS. Ajudo pequenos negócios e designers a colocarem em prática boas ideias. Vamos conversar?</p>
        <a>Instagram</a>
        <a>Github</a>
    </main>
    <footer></footer>
</body>
</html>COPIAR CÓDIGO
```

**Guilherme:** Na página no navegador, notaremos que aparece o texto "Instagram Github".

**Rafaella:** Mas não está clicável, e parece apenas um outro parágrafo.

**Guilherme:** Está exatamente igual, e não é esse comportamento que esperamos, pois queremos poder clicar e nos redirecionar para o Instagram ou o Github.

Poderemos colocar o Instagram da Rafaella para exemplificar.

**Rafaella:** A *tag* âncora é bastante semelhante à propriedade que estávamos colocando de imagem com **`src`**, que vem de *source* ou "fonte", e que ser para buscar o caminho para encontrá-la.

Em `<a>`, vamos usar um *hiperlink* que nos permite clicar e ir para outra pagina. Escrevendo **`href`** entre `a` e `>` na abertura da primeira *tag*, e já exibiremos uma caixa com uma descrição.

Depois do sinal de igual `=`, escreveremos a URL de destino entre aspas para onde vamos nos redirecionar. Neste exemplo, será `"https://instagram.com/rafaballerini"`, depois salvaremos e veremos o que vai acontecer.

```
<!DOCTYPE html>
<html lang="pt-br">

//código omitido

<body>
    <header></header>
    <main>

//código omitido

        <a href="https://instagram.com/rafaballerini">Instagram</a>
        <a>Github</a>
    </main>
    <footer></footer>
</body>
</html>COPIAR CÓDIGO
```

![https://cdn1.gnarususercontent.com.br/1/308174/55987566-934a-435a-9ecf-d0ddc02ce6ed.png](https://cdn1.gnarususercontent.com.br/1/308174/55987566-934a-435a-9ecf-d0ddc02ce6ed.png)

**Guilherme:** Já mudou e visualmente está diferente.

**Rafaella:** Já se tornou um elemento clicável com o destaque sublinhado em azul, e quando clicamos, nos redirecionaremos para a página do Instagram que colocamos em `href`.

**Guilherme:** No botão de "Github", pode colocar o meu mesmo como exemplo para vermos.

**Rafaella:** Teremos o mesmo formato usando `href` igual a `"https://github.com/guilhermeonrails"`. Vamos salvar e ver o resultado no navegador.

```
<!DOCTYPE html>
<html lang="pt-br">

//código omitido

<body>
    <header></header>
    <main>

//código omitido

        <a href="https://instagram.com/rafaballerini">Instagram</a>
        <a href="https://github.com/guilhermeonrails">Github</a>
    </main>
    <footer></footer>
</body>
</html>COPIAR CÓDIGO
```

**Rafaella:** Quando clicarmos em "Github" também já clicável e sublinhado em azul, iremos para a página do GitHub do Guilherme.

**Guilherme:** Revisando o que fizemos, construímos tudo isso dentro do `<main>` até agora.

Na *tag* `<strong>`, pegamos o texto em destaque no Figma, mas visualmente não há diferença no navegador. Mesmo não tendo alterado nada, já indicou que é algo a ser destacado.

Também criamos o parágrafo com `<p>`, além dos dois *links* que redirecionam para o Instagram e GitHub, que não são literalmente dois botões.

Deixaremos essas duas âncoras `<a>` para outros sites com aparência de botão apenas, como está na tela no Figma.

**Rafaella:** Exatamente. Nosso último passo é inserir a fotografia da direita, e conseguimos fazer seu *download* direto do Figma, afinal não a encontraremos no Google.

Mas poderemos usar qualquer outra imagem que tivermos salvas no computador.

Para pegarmos direto do Figma, clicaremos sobre o elemento que queremos baixar e, na aba lateral direita chamada "Design", teremos a opção de "Export" onde clicaremos no botão de "Export Imagem" para fazermos o *download*.

Abriremos a pasta em que o arquivo foi salvo e poderemos renomear se quisermos, como apenas "imagem" mesmo para padronizarmos.

Clicando e arrastando a imagem para dentro do VSCode, criaremos o arquivo `imagem.png` na lista lateral esquerda chamada "Explorer", da mesma forma que fizemos com o HTML 5.

Para a adicionarmos no código, inseriremos a *tag* **`<img>`** que já conhecemos e sabemos que é única, então não precisamos abrir e fechar.

A propriedade usada para encontrar a imagem é a **`src`** que será igual a `"imagem.png"` entre aspas, pois já está na mesma pasta do projeto, bastando só escrever o nome do arquivo.

Além disso, usaremos outra importante propriedade chamada **`alt`** que diz respeito ao texto alternativo que descreve a imagem, como `"Foto da Joana Santos programando"` por exemplo.

Vamos Salvar e ver o resultado no navegador.

```
<!DOCTYPE html>
<html lang="pt-br">

//código omitido

<body>
    <header></header>
    <main>

//código omitido

        <a href="https://instagram.com/rafaballerini">Instagram</a>
        <a href="https://github.com/guilhermeonrails">Github</a>
        <img src="imagem.png" alt="Foto da Joana Santos programando">
    </main>
    <footer></footer>
</body>
</html>COPIAR CÓDIGO
```

![https://cdn1.gnarususercontent.com.br/1/308174/3727c664-fc1e-4c63-b16f-876661f8727e.png](https://cdn1.gnarususercontent.com.br/1/308174/3727c664-fc1e-4c63-b16f-876661f8727e.png)

**Rafaella:** Ainda não está como o projeto do Figma porque ainda temos muito o que estilizar, e é o que faremos a seguir.