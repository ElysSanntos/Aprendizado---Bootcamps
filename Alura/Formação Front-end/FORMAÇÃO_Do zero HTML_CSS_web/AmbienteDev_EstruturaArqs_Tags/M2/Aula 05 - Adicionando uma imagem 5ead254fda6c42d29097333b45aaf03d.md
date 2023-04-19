# Aula 05 - Adicionando uma imagem

Nessa aula, aprendemos que para inserir uma imagem em sua página é necessário utilizar a tag `<img>`. Pensando nisso, considere o código a seguir:

```
<!DOCTYPE html>
<html>
    <head>
        <title>Portfólio</title>
    </head>
    <body>
        <h1>Isso é um título</h1>
        <p>Isso é um parágrafo</p>
        <img scr="html.png" alt="Logo do HTML 5">
    </body>
</html>COPIAR CÓDIGO
```

Assinale as alternativas corretas a respeito do código acima:

*Selecione 2 alternativas*

A imagem só será exibida caso exista um arquivo de imagem chamado “html.png” salvo dentro da pasta do projeto.

É comum principalmente no início, errarmos o caminho da imagem e não conseguirmos visualiza-las. Por isso, é essencial que o caminho dentro do atributo `src` corresponda ao nome do arquivo de imagem.

Apenas o texto alternativo será exibido e a imagem estará indisponível, porque o atributo `src` da tag `<img>` foi escrito incorretamente.

A imagem não será localizada e não conseguiremos visualizá-la na página, pois escrevemos `scr` ao invés de `src` no atributo da tag . O atributo `src` vem do termo em inglês “source”, que significa fonte, pois indica o caminho onde a imagem está localizada.

- A `<img>`  é uma das tags que não precisa de fechamento, portanto o `</img>`  não deve ser adicionado.
- Como houve um problema na exibição da imagem, o `alt`  foi o único recurso na página para descrever a imagem que não apareceu, por isso é sempre importante usar o atributo `alt`  mesmo não sendo obrigatório, por ser uma boa prática para a acessibilidade e manutenção da página.