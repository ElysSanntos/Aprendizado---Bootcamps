# Aula 04 - Desenvolvendo a nova página

**Rafaella:** Criaremos uma nova página para deixarmos o menu do cabeçalho funcional, em que poderemos clicar para nos redirecionarmos para outras páginas.

**Guilherme:** Abriremos o VSCode e veremos que, na aba lateral esquerda de "Explorer", teremos a arquitetura das pastas do portfólio em que `"assets"` contém todas as imagens. Ainda teremos os dois arquivos: `index.html` e `styles.css`.

Como criaremos uma nova página, da forma como nosso código está organizado, pode ser que sua manutenção e edição fiquem mais complicadas conforme cresce o número de telas do projeto.

Clicando com o botão direito do mouse sobre a aba "Explorer", escolheremos "New Folder..." ou "Nova pasta..." e nomearemos como "styles" porque é o padrão.

Em seguida, deslocaremos o arquivo `styles.css` para dentro da nova pasta. A partir de agora, qualquer documento `.css` que criarmos deverá ficar nela.

Depois, abriremos a página no navegador e não teremos mais a estilização dos elementos que aplicamos.

Isso aconteceu porque alteramos o lugar do documento de estilos, fazendo com que o `index.html` não o encontrasse mais através do `href` igual a `"styles.css"`.

**Rafaella:** Então precisaremos alterar o endereço que estamos usando, e bastará substituirmos por `"./styles/styles.css"` para indicarmos o caminho de dentro da pasta `"styles"`.

Desta forma, a estilização voltará a ser aplicada na página no navegador.

**Guilherme:** Todos os arquivos relacionados aos estilos dos elementos serão criados na pasta `"styles"`, todas as imagens estarão em `"assets"` e todos os arquivos `.html` ficarão fora na raiz da aplicação.

Clicando com o botão direito na área da aba lateral de pastas, e escolheremos "New File..." ou "Novo Arquivo...".

Geralmente, a página de "Sobre mim" é nomeada como `about.html`, que é "sobre" em inglês.

Neste novo arquivo, usaremos o atalho "ponto de exclamação + Enter" para escrevermos a estrutura básica do HTML automaticamente, que é bastante comum, mas precisaremos alterar alguns detalhes.

**Rafaella:** Também apertaremos as teclas "Alt + Z" para quebrarmos a linha e conseguirmos exibir todo o texto sem cortes da tela.

**Guilherme:** Na segunda linha, mudaremos o idioma oficial de inglês para protuguês brasileiro substituindo lang igual a "en" por "pt-br", e o título da nossa aba será “Sobre mim” dentro da tag `<title>` do `<head>`. Também adicionaremos um `<h1>` dentro de `<body>` contendo o texto “Sobre mim”.

Por enquanto não trabalharemos muito nos elementos desta tela, pois queremos apenas conseguir clicar no link "Sobre mim" do cabeçalho da página principal e nos redirecionar para a nova que criamos.

```
<!DOCTYPE html>
<html lang="pt-br">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Sobre mim</title>
</head>
<body>
    <h1>Sobre mim</h1>
</body>
</html>COPIAR CÓDIGO
```

**Guilherme:** Feito isso, voltaremos ao `index.html` onde temos o menu de navegação, e precisaremos fazer com que nos redirecione através do link `"Sobre mim"`.

Sempre utilizamos o `href` para navegar até uma outra pasta, ou ainda, no caso de imagens, há o `src` que significa "source" ou "fonte" em português.

**Rafaella:** Para navegarmos até outra página com um link, também utilizaremos o `href`.

**Guilherme:** Outro ponto de atenção é que, onde temos a classe de `<a>`, escreveremos o `href` logo após seu nome e antes de fechar a navegação em `>`.

No caso do link `"Home"`, sempre iremos voltar para a página inicial quando clicarmos, que é o `"index.html"`.

**Rafaella:** não colocaremos o `./` antes do nome do arquivo porque já estamos na mesma pasta que ele.

**Guilherme:** Faremos a mesma coisa para a segunda tag âncora, em que `href` será igual a `"about.html"`. Salvaremos e voltaremos à página no navegador.

```
<!DOCTYPE html>
<html lang="pt-br">

//código omitido

<body>
    <header class="cabecalho">
        <nav class="cabecalho__menu">
            <a class="cabecalho__menu__link" href="index.html">Home</a>
            <a class="cabecalho__menu__link" href="about.html">Sobre mim</a>
        </nav>
    </header>

//código omitido

</body>
</html>COPIAR CÓDIGO
```

**Guilherme:** Repararemos que os dois links estão sublinhados depois que colocamos os dois `href`s.

**Rafaella:** Mas não queremos que fiquem sublinhados, então vamos retirar isso no arquivo de estilização.

**Guilherme:** Para isso, em `styles.css`, iremos ao seletor `.cabecalho__menu__link` e inseriremos a propriedade `text-decoration: none` ao final do bloco dentro das chaves.

```
//código omitido

.cabecalho__menu__link {
    font-family: 'Montserrat', sans-serif;
    font-size: 24px;
    font-weight: 600;
    color: #22D4FD;
    text-decoration: none;
}

//código omitidoCOPIAR CÓDIGO
```

**Rafaella:** Voltando à página no navegador, teremos retirado os sublinhados.

**Guilherme:** Se clicarmos em "Home", iremos apenas recarregar porque já estaremos na página principal, mas se clicarmos em "Sobre mim", iremos à nova tela que criamos.

**Rafaella:** Então já conseguimos navegar entre páginas. A seguir, iremos desenvolver o `about.html`.