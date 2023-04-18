# Aula 04 - Criando o corpo da página

**Rafaella:** Temos o início da nossa página Web. Já adicionamos a metainformação `title` a qual aparece na aba da nossa página. Ainda não escrevemos nada da estrutura, do corpo da página. Faremos isso agora.

**Guilherme:** Vamos retornar à documentação do HTML para ver o próximo passo.

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

**Rafaella:** Já escrevemos tudo até a *tag* de fechamento `</head>`.

**Guilherme:** Entraremos na *tag* `<body>`. A documentação nos informa que ele define o corpo do documento e é um recipiente para todos os conteúdos visíveis, como cabeçalhos, parágrafos, imagens, hiperlinks, tabelas e listas. Vamos criar nossa *tag* retornando ao VS Code.

**Rafaella:** A *tag* `<body>` não ficará dentro do `<head>`. A palavra "head" significa cabeça, e "body" significa corpo. Se pensarmos bem, o corpo fica abaixo da cabeça.

Vamos criar o `<body>` abaixo do `<head>`, mas ainda dentro da *tag* `<html>`. Já que ambas estarão no mesmo nível em relação ao `html`, não pressionaremos "Tab".

Entre as *tags* de abertura e fechamento do `body`, pressionaremos "Enter" para abrir um espaço onde iremos escrever.

```
<!DOCTYPE html>
<html>
    <head>
        <title>Portfolio</title>
    </head>
    <body>

    </body>
</html>COPIAR CÓDIGO
```

O que adicionaremos neste espaço?

**Guilherme:** Vamos voltar para o nosso documento do Google Docs para ver o que escrevemos. Lá encontraremos, em primeiro lugar, o nosso título. Precisamos escrever "Isso é um título" lá no HTML.

Voltaremos ao VS Code e escreveremos dentro do `<body>` a frase "Isso é um título".

```
<!DOCTYPE html>
<html>
    <head>
        <title>Portfolio</title>
    </head>
    <body>
        Isso é um título
    </body>
</html>COPIAR CÓDIGO
```

Salvaremos o código e voltaremos à nossa página por meio do navegador, onde veremos o resultado. No canto superior esquerdo vemos a frase "Isso é um título" bem pequena. Ela não se parece com um título.

**Rafaella:** Não é só porque escrevemos "título" que o HTML entenderá que queremos um título. Ele não entende português. Nós, pessoas programadoras, precisamos rotular esse texto como um título de fato. Fazemos isso com o uso de *tags*.

Já vimos que o `<title>` se trata de uma meta informação do nome da página, que é inserida na aba. Existe uma outra *tag* denominada `heading`, a qual declaramos somente com `<h>`, o qual é acompanhado de um número que designa o peso daquele título. Podemos utilizá-la tanto para títulos quanto para subtítulos. Vamos envolver o nosso título com a `heading` no tamanho 1 — digitaremos portanto o comando `<h1>` à esquerda, e fecharemos com `</h1>` no final do texto.

```
<!DOCTYPE html>
<html>
    <head>
        <title>Portfolio</title>
    </head>
    <body>
        <h1>Isso é um título</h1>
    </body>
</html>COPIAR CÓDIGO
```

**Guilherme:** Temos o `<html>` aberto, todo o seu conteúdo e em seguida o seu fechamento. Abrimos e fechamos a *tag* `<h1>`, e tudo que escrevemos no espaço entre essas *tags* será o `heading 1`.

**Rafaella:** Exato.

**Guilherme:** Alguma coisa mudou no código?

**Rafaella:** Vamos ver. Salvaremos o código, retornaremos ao navegador e atualizaremos a página. Ainda vemos a frase "Isso é um título", mas agora ela possui um tamanho maior, mais compatível com um título.

**Guilherme:** Visualmente já está diferente.

**Rafaella:** Seria interessante entendermos como seriam os `heading`s de tamanho 2, para o subtítulo, e de tamanho 3. O `h2` é maior do que o parágrafo padrão, mas é menor do que nosso `h1`. As `heading`s diminuem de tamanho conforme aumentamos o número.

**Guilherme:** Muito bom. Nossos títulos geralmente possuem uma única *tag* de `heading`. E devemos manter essa ordem, de cima para baixo: `h1`, depois `h2`, e assim por diante.

**Rafaella:** Exato.

**Guilherme:** As `heading`s vão até qual número?

**Rafaella:** Até `h6`.

**Guilherme:** Vamos tomar cuidado com isso.

E para o nosso parágrafo, Rafa?

**Rafaella:** Se escrevermos o parágrafo sem uma *tag*, o conteúdo será exibido. Contudo, o ideal é sempre adicioná-las, pois a página, por vezes, pode interpretar aquele texto de uma forma errada.

> Acessibilidade: O uso das tags é essencial para pessoas que utilizam leitores de tela. Sem esse mecanismo, a navegação se torna muito difícil para esse público.
> 

Abaixo do `<h1>` vamos adicionar a *tag* `<p>`, de parágrafo, com abertura e fechamento. Entre elas adicionaremos o texto "Isso é um parágrafo".

```
<!DOCTYPE html>
<html>
    <head>
        <title>Portfolio</title>
    </head>
    <body>
        <h1>Isso é um título</h1>
        <p>Isso é um parágrafo</p>
    </body>
</html>COPIAR CÓDIGO
```

Salvaremos o código e retornaremos ao navegador. Atualizaremos a página e veremos o texto "Isso é um título". e logo abaixo dele vemos o texto "Isso é um parágrafo", em fonte menor. Agora temos nosso parágrafo.

**Guilherme:** Mesmo que não tenhamos alterado o tamanho do texto, o navegador agora sabe que se trata de um parágrafo. Se não escrevêssemos nada, não seria uma boa prática, por conta da acessibilidade. Precisamos entender desde o começo que as *tags* auxiliam o navegador a entender nossa página.

**Rafaella:** Exatamente.

**Guilherme:** Temos um desafio final: precisamos inserir a imagem. Se retornarmos ao nosso documento no Docs Google, veremos a imagem escolhida — o ícone do HTML5. Vamos adicioná-la ao nosso código.

**Rafaella:** Nós já havíamos salvado essa imagem em nosso computador, portanto vamos buscá-la através do explorador. Em seguida, vamos simplesmente arrastá-la para o explorador do VS Code.

> Dica: É possível também inserir a imagem no projeto através da barra de menus do VS Code, através do caminho "File > Open File" e em seguida arrastá-la da tela para o explorador.
> 

**Guilherme:** Você não precisa utilizar essa mesma imagem no seu projeto, pode escolher uma que você quiser! Mesmo assim, disponibilizaremos esta imagem nas atividades do curso.

**Rafaella:** Pode ser um gatinho, uma calopsita, qualquer coisa.

Neste momento, uma aba da imagem estará aberta na tela principal do VS Code. Vamos fechá-la clicando no X localizado nessa aba. Para trazer essa imagem para nosso HTML utilizaremos a *tag* `<img>`, que vem da palavra "*image*" (ou "imagem"). Vamos adicioná-la abaixo do parágrafo e dentro do `<body>`, pois este é o local onde adicionaremos tudo o que é visível.

```
<!DOCTYPE html>
<html>
    <head>
        <title>Portfolio</title>
    </head>
    <body>
        <h1>Isso é um título</h1>
        <p>Isso é um parágrafo</p>
        <img >
    </body>
</html>COPIAR CÓDIGO
```

A `<img>` é uma *tag* que não possui fechamento. Para adicionar a imagem nesta *tag* não vamos arrastá-la, copiá-la ou colá-la, mas sim escrever o seu endereço. Com este endereço, a *tag* buscará a imagem e a exibirá em nossa tela.

**Guilherme:** Por enquanto, a aplicação não sabe que imagem é. Precisamos informar a ela.

**Rafaella:** Isso mesmo. Informaremos onde está a imagem através da ***propriedade `src`***. As propriedades ficam dentro dos sinais de maior e menor da nossa *tag*. Quando digitarmos "src" e pressionarmos "Enter", o próprio VS Code deverá completar o comando adicionando o sinal de igual `=` e duas aspas duplas `""`. Caso não tenha ocorrido o autopreenchimento, podemos digitar manualmente.

```
<!DOCTYPE html>
<html>
    <head>
        <title>Portfolio</title>
    </head>
    <body>
        <h1>Isso é um título</h1>
        <p>Isso é um parágrafo</p>
        <img src="">
    </body>
</html>COPIAR CÓDIGO
```

Inserimos o `src` que vem de "*source*" ("fonte", em português), adicionamos o sinal de igual e abrimos aspas para escrever entre elas onde está o endereço da imagem. Neste caso, nossa imagem possui o nome que demos anteriormente: `html.png`, e se encontra na mesma pasta do nosso arquivo `index.html`: a pasta "Portfolio". Já que ambos estão na mesma pasta, basta adicionarmos `html.png` entre as aspas de nosso `src`.

```
<!DOCTYPE html>
<html>
    <head>
        <title>Portfolio</title>
    </head>
    <body>
        <h1>Isso é um título</h1>
        <p>Isso é um parágrafo</p>
        <img src="html.png">
    </body>
</html>COPIAR CÓDIGO
```

Salvaremos o código e retornaremos ao navegador. Atualizaremos a página e veremos o Título, o parágrafo, e logo abaixo deste último veremos a nossa imagem.

**Guilherme:** Nosso projeto está bem mais próximo da expectativa!

Agora vamos abordar um aspecto muito importante da nossa página: não é só o `<head>` que carrega as meta informações relevantes para a nossa página. No `<body>` também temos informações muito relevantes para a página e que não são visíveis. Essas informações são utilizadas por pessoas que utilizam leitores de tela.

**Rafaella:** Exato. O navegador quando utiliza leitores de tela sabe identificar o que são títulos, subtítulos, e consegue lê-los na ordem correta.

**Como o navegador lê uma imagem e a exibe para as pessoas que utilizam leitores de tela?** Nós precisamos ***descrever*** essa imagem, e para isso utilizamos dentro de `<img>` a propriedade `alt`. Após digitá-la, daremos "Enter" e o sistema completará a estrutura com o sinal de igual e as aspas duplas.

```
<!DOCTYPE html>
<html>
    <head>
        <title>Portfolio</title>
    </head>
    <body>
        <h1>Isso é um título</h1>
        <p>Isso é um parágrafo</p>
        <img src="html.png" alt="">
    </body>
</html>COPIAR CÓDIGO
```

O `alt` permite que adicionemos um texto alternativo para nossa imagem. Qual texto digitaremos para a imagem do HTML5?

**Guilherme:** Podemos descrevê-la como "Logo do HTML 5".

```
<!DOCTYPE html>
<html>
    <head>
        <title>Portfolio</title>
    </head>
    <body>
        <h1>Isso é um título</h1>
        <p>Isso é um parágrafo</p>
        <img src="html.png" alt="Logo do HTML 5">
    </body>
</html>COPIAR CÓDIGO
```

Isso muda algo na nossa página?

**Rafaella:** Na página não há nenhuma mudança. O texto alternativo será lido somente por leitores de tela que passarem por essa imagem. Entretanto, em casos de quebra de imagem, o texto alternativo será exibido no lugar dela.

Para aumentar a acessibilidade e para nos prepararmos melhor em casos de erro na aplicação, é muito importante adicionar um bom texto alternativo em todas as nossas imagens.