# Aula 02 - Documentação e estrutura básica do HTML

**Rafaella:** Criamos nosso primeiro arquivo HTML. Agora vamos aprender a escrever o texto em HTML.

**Guilherme:** Isso. O que geralmente acontece quando queremos aprender uma linguagem de programação ou uma tecnologia nova? Procuramos o ***manual***. No nosso caso, procuramos a ***documentação da linguagem***.

**Rafaella:** Exatamente. Temos manuais de diversas tecnologias. Se quisermos aprender Javascript, procuraremos a documentação. Isso é muito importante.

**Guilherme:** Vamos abrir a documentação. Recomendamos, inicialmente, a ***w3s html intro***. Vamos digitar esse nome na barra de pesquisa do Google.

Clicaremos no primeiro link retornado na pesquisa, o qual nos direcionará para a [página de introdução do HTML no site W3Schools](https://www.w3schools.com/html/html_intro.asp). Essa página nos mostra o conteúdo em inglês. Vamos colocá-la em português.

No topo da tela há uma barra de menus branca. Abaixo desta, há uma barra secundária de menus na cor preta, onde clicaremos no ícone de planeta denominado "Translate W3Schools", localizado à direita. Neste momento, à esquerda desse ícone, veremos um botão denominado "selecione o idioma", no qual clicaremos e selecionaremos a opção "Português". Após esse procedimento, a página será exibida em português.

# **Afinal, o que é HTML?**

**Rafaella:** Encontraremos a resposta na página que abrimos. Nela há a seção "O que é HTML?", onde encontramos o seguinte tópico:

- HTML significa *Hyper Text Markup Language* (ou "linguagem de marcação de hiper texto").

Ou seja, o HTML é uma ***linguagem de marcação***. Existe uma polêmica envolvendo o HTML e que alimenta dúvidas sobre o HTML ser uma linguagem de programação ou não. De fato, o HTML é uma linguagem de marcação, e por isso, não se trata de uma linguagem de programação. Utilizamos o HTML para designar as partes do texto.

Retornando ao nosso documento de texto, podemos ver que marcamos a frase "Isso é um título" como um título. No caso do Docs Google, não precisamos escrever *tags* ou códigos para marcação, pois o programa utilizado facilita esse processo. Já no HTML ***utilizaremos tags*** para marcar títulos, parágrafos e imagens.

**Guilherme:** Voltando à página do HTML, ainda na seção "O que é HTML?" encontramos os dois tópicos abaixo:

- HTML descreve a estrutura de uma página da Web.
- Os elementos HTML rotulam partes do conteúdo como "isto é um título", "isto é um parágrafo", "isto é um link", etc.

Isso significa que teremos um local onde rotularemos cada elemento da página: é como se indicássemos "isto será um título", "isto será uma imagem","estes serão dois parágrafos". O objetivo do HTML é ***marcar toda a página Web***.

É interessante notar que existe um código por trás das páginas com as quais interagimos indicando a função de cada elemento.

**Rafaella:** Abaixo da seção "O que é HTML?" temos a seção "Um Documento HTML Simples" no qual é possível ver um *spoiler* do que seriam as *tags*:

```
<!DOCTYPE html>
<html>
<head>
<title>Page Title</title>
</head>
<body>

<h1>My First Heading</h1>
<p>My first paragraph.</p>

</body>
</html>COPIAR CÓDIGO
```

**Guilherme:** Se olharmos este trecho não vamos entender muita coisa. A melhor forma para aprendermos uma técnica ou linguagem relacionada à tecnologia é ***praticando***. Não existe outro jeito.

**Rafaella:** Exatamente.

**Guilherme:** Nós criamos um arquivo simples no Docs Google, indicando um título, um parágrafo e uma imagem. Conforme praticamos o HTML, essa tarefa se tornará comum.

Conforme podemos ver no trecho de exemplo, toda propriedade do HTML começa com o sinal `<` e termina com o sinal `>`.

**Rafaella:** No interior destes sinais, temos o rótulo daquela porção da página Web.

**Rafaella:** Exatamente. Vamos criar esse código no VS Code. Criaremos uma *tag* por vez e entenderemos o que cada uma significa.

**Rafaella:** Perfeito.

A primeira se chama `<!DOCTYPE html>`. Conforme a própria página do HTML define, se trata de uma declaração que define o documento como um documento HTML5. Mesmo que criemos a extensão `.html`, é importante declarar esta *tag* pois ela define a versão. É possível copiá-la e colar no VS Code, mas vamos escrever do zero para que entendamos melhor.

Retornaremos ao VS Code, criaremos nossos sinais `<` e `>`. Entre eles escreveremos um `!DOCTYPE` em letras maiúsculas, daremos um espaço e escreveremos `html` em letras minúsculas.

```
<!DOCTYPE html>COPIAR CÓDIGO
```

**Guilherme:** O que a Rafa comentou é interessante. Essa *tag* serve para identificar que estamos trabalhando nesse arquivo HTML com a versão 5. Esta será a versão utilizada quando abrirmos este projeto no navegador. Se estamos falando da versão 5, significa que existiram versões diferentes? A resposta é ***sim***. Faremos um teste sobre isso depois.

**Rafaella:** Retornando à página do HTML, a próxima *tag* a ser copiada será a `<html>`. Esta *tag* indica que tudo o que existir dentro dela será o documento HTML.

**Guilherme:** A documentação nos informa que o `<html>` é o elemento raiz de uma página HTML, ou seja, este elemento será a base para tudo o que existir na página.

Vamos retornar ao VS Code e adicioná-la abaixo de `<!DOCTYPE html>`.

```
<!DOCTYPE html>
<html>COPIAR CÓDIGO
```

Neste momento, o Visual Studio Code completará automaticamente a *tag* que abrimos com a *tag* posterior, ou seja, de fechamento.

```
<!DOCTYPE html>
<html></html>COPIAR CÓDIGO
```

O que seria a *tag* posterior? Temos algumas *tags* que, para serem implementadas, precisam de uma abertura e de um fechamento.

Se voltarmos à página do HTML no navegador, veremos que existe a *tag* de fechamento `</html>` no final do trecho, precedida por vários outros elementos. Isso significa que todos os elementos entre `<html>` e `</html>` farão parte desta *tag*.

> Toda tag de fechamento possui uma barra (/) após o sinal <.
> 

Caso o VS Code não preencha a *tag* automaticamente, basta escrevê-la manualmente.

Posicionaremos o cursor no meio das *tags* `<html>` e `</html>` e pressionaremos "Enter" para abrir um espaço onde começaremos a escrever nosso documento.

```
<!DOCTYPE html>
<html>

</html>COPIAR CÓDIGO
```

**Guilherme:** Já temos a nossa *tag* HTML. No caso do `<!DOCTYPE html>` não existe uma *tag* de fechamento. Isso é um padrão. Não sabemos o motivo exato disso.

**Rafaella:** Exato. Existem *tags* com fechamento e outras sem. Neste curso veremos todos os tipos de *tags*.

Antes de continuar, salvaremos o código com o atalho "Ctrl + S".

**Guilherme:** O HTML indica que a nossa página abriu. Voltaremos ao navegador e veremos nossa próxima *tag*: `<head>`, a qual, segundo a documentação, contém meta informações sobre a página HTML.

**Rafaella:** O que seriam meta informações? São as informações sobre o próprio documento. São *metatags*. Vamos adicioná-las dentro do tal `<head>`.

Vamos retornar ao VS Code, e entre as *tags* de abertura e fechamento do `html` adicionaremos a `<head>`.

> Importante: Para indentarmos o código — ou seja, para mantê-lo organizado visualmente — devemos pressionar "Tab" a cada tag que abrirmos no interior de outra, criando dessa forma uma distância entre as tags e impedindo que todo o código fique "reto". Após a abertura e o fechamento da head pressionaremos "Enter". Dentro do espaço criado da <head> escreveremos as meta informações da nossa página.
> 

```
<!DOCTYPE html>
<html>
    <head></head>
</html>COPIAR CÓDIGO
```

**Guilherme:** Temos conteúdos na página que podemos visualizar e outros que não vemos diretamente.

**Rafaella:** Exato. Consultando a página do HTML, veremos que a primeira *tag* de metainformação é o `<title>`. No VS Code, vamos adicioná-la entre as *tags* do `<head>`, sem esquecer de pressionar "Tab" antes.

```
<!DOCTYPE html>
<html>
    <head>
        <title></title>
    </head>
</html>COPIAR CÓDIGO
```

**Guilherme:** Vamos dar um título para a página entre as *tags* do `title`?

**Rafaella:** Vamos. Pode ser "Portfolio"?

**Guilherme:** Pode.

```
<!DOCTYPE html>
<html>
    <head>
        <title>Portfolio</title>
    </head>
</html>COPIAR CÓDIGO
```

**Rafaella:** Salvaremos o arquivo e abriremos no navegador. Para abri-lo, acessaremos o explorador de arquivos do computador, acessaremos o local em que salvamos a pasta do projeto. Abriremos essa pasta e clicaremos duas vezes no arquivo que estamos escrevendo: o `index.html`. Podemos abri-lo com qualquer navegador disponível. Neste caso, abriremos no mesmo navegador que estamos usando.

**Guilherme:** Neste momento o navegador abrirá uma tela em branco. No corpo não tem nada, mas a metainformação que passamos no `<head>` deu um nome para a nossa aba: a aba se chama Portfolio. Ou seja, criamos um arquivo HTML e demos a ele um `title` denominado Portfolio.

A seguir, abordaremos de fato o ***conteúdo*** que queremos criar.