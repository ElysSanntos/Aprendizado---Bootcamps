# Aula 03 - Navegando entre páginas

**Rafaella:** Nesta aula, iremos desenvolver a página "Sobre mim" que por enquanto só tem este texto no `<h1>` de `<body>` no `about.html`, que inclusive poderemos apagar pois não o utilizaremos mais.

Vamos lembrar da estrutura inicial mais semântica que sempre utilizamos no HTML.

**Guilherme:** Dentro de `<body>`, usaremos o `<header>`, seguido de `<main>` que é o conteúdo principal da página, e o `<footer>` depois.

Porém, se observarmos a tela de "Sobre mim" no Figma, notaremos que o cabeçalho e o rodapé são exatamente iguais aos da página inicial.

Então poderemos copiar este código de `index.html` com "Ctrl + C" e colar com "Ctrl + V" no `about.html`.

**Rafaella:** No documento da página inicial, usamos as classes `"cabecalho"` em `<header>` e `"cabecalho__menu"` em `<nav>`, e poderemos copiar este bloco para depois estilizarmos.

Dentro do `<body>` que acabamos de colocar em `about.html`, colaremos todo o bloco de `<header>` copiado do `index.html`.

Faremos a mesma coisa com o `<footer>` de classe `"rodape"` do `index.html`, colando-o em `about.html`.

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
    <main></main>
    <footer class="rodape">
        <p>Desenvolvido por Alura.</p>
    </footer>
</body>
</html>COPIAR CÓDIGO
```

**Rafaella:** Com isso, já teremos o `<header>` e o `<footer>` da página "Sobre mim" igual aos da página inicial.

Agora precisaremos completar o `<main>`.

**Guilherme:** Vamos salvar e abrir o navegador para analisarmos o resultado.

Por enquanto há apenas os textos do cabeçalho sublinhados em azul porque são clicáveis, e a frase "Desenvolvido por Alura." do rodapé logo abaixo, tudo no canto superior esquerdo do fundo em branco.

Se clicarmos em "Home", nos redirecionaremos para a página inicial porque os links já estão definidos em `<a>`.

**Rafaella:** Ainda não temos os estilos porque não importamos o CSS.

**Guilherme:** Deveremos criar um novo arquivo `style.css` para essa página nova, ou manteremos o que já temos?

**Rafaella:** conseguiremos trazer este documento de estilos para a "Sobre mim", pois estamos utilizando exatamente as mesmas classes da mesma forma.

Por exemplo, se estivéssemos com um menu de cores e formatos diferentes, teríamos que utilizar outras classes ou criar mais arquivos `.css`.

Existem diversas possibilidades quando estamos em ambiente de desenvolvimento e criamos vários documentos para cada página para nos organizarmos, principalmente em grandes projetos.

Porém, na prática, no momento de colocarmos o projeto no ar, o ideal para a performance da nossa página ser boa, é termos o menor número de arquivos `.css` possível.

Então conseguiremos reutilizar nosso arquivo `style.css` em nosso projeto porque é bastante simples, e de fato usamos a mesma estilização.

Portanto, importaremos este documento no código da nova página.

**Guilherme:** Uma dica importante é, se formos em `<title>` com `Sobre mim` no `about.html`, e abaixo escrevermos apenas “link: css” para apertarmos a tecla "Enter" depois, aparecerá a linha de código `<link>` completa.

```
<!DOCTYPE html>
<html lang="pt-br">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Sobre mim</title>
    <link rel="stylesheet" href="styles.css">
</head>

//código omitido

</html>COPIAR CÓDIGO
```

**Rafaella:** O problema é que temos `"style.css"` em `href`, mas havíamos criado uma pasta, então precisaremos corrigir para `"./styles/style.css"`.

Se salvarmos e voltarmos ao navegador, encontraremos os links do cabeçalho e o texto do rodapé já com os estilos corretos.

**Guilherme:** Aparecem ainda muito juntos.

**Rafaella:** É porque ainda não temos nada no `<main>` do `about.html`, e a seguir iremos desenvolver o corpo da página.