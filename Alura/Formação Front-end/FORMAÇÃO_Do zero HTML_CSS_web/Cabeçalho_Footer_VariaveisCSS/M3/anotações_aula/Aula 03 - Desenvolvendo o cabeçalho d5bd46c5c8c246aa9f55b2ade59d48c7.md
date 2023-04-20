# Aula 03 - Desenvolvendo o cabeçalho

**Guilherme:** Agora que terminamos nosso rodapé, nosso próximo desafio será o **cabeçalho**.

**Rafaella:** No Figma, temos dois links no topo da tela principal para "Home" e "Sobre mim".

Em nosso projeto no `index.html`, já temos a *tag* `<header>` preparada dentro de `<body>` para conseguirmos desenvolver o cabeçalho.

**Guilherme:** O `<header>` geralmente é composto por um **menu de navegação** na grande maioria das páginas *web*, contendo diversos links que nos direcionam para outras telas.

Para isso, também existe uma *tag* semântica.

**Rafaella:** Ela é chamada `<nav>` e receberá os links para navegarmos na página, que podem ser de um *blog* com uma hierarquia de links por assuntos, como uma opção "Programação" que envolveria "Front-end", seguido de "HTML" por exemplo. Essa forma também é uma navegação com a *tag* `<nav>`.

Nosso caso possui apenas dois: o da página inicial e "Sobre mim" com outras informações.

Dentro de `<nav>`, adicionaremos a *tag* âncora que já conhecemos, a qual receberá o texto `Home`. Já na segunda `<a>`, teremos `Sobre mim`.

Também criaremos as classes do cabeçalho para podermos estilizar. Então, ao lado de `<header` e antes de `>` na mesma linha, escreveremos `class` igual a `"cabecalho"`. Já em `<nav`, a classe será `"cabecalho__menu"`, e as duas *tags* `<a`, será `"cabecalho__menu__link"`.

**Guilherme:** Vamos salvar e ver o resultado no navegador.

```
<!DOCTYPE html>
<html lang="pt-br">

//código omitido

<body>
    <header class="cabecalho">
        <nav class="cabecalho__menu">
            <a class="cabecalho__menu__link">Home</a>
            <a class="cabecalho__menu__link">Sobre mim</a>
        </nav>
    </header>

//código omitido

</body>
</html>COPIAR CÓDIGO
```

**Rafaella:** Parece que não há nada.

**Guilherme:** Sim, mas na verdade está bem pequeno no canto superior, então precisaremos estilizar no arquivo `style.css` para ficar igual ao projeto no Figma.