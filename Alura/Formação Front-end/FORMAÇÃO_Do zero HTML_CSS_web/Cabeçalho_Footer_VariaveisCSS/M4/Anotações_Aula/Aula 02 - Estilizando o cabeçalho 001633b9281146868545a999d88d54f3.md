# Aula 02 - Estilizando o cabeçalho

**Rafaella:** Já criamos nosso cabeçalho com HTML, mas ainda precisamos estilizá-lo.

Abrindo o arquivo `style.css` no VSCode, inseriremos as classes que já criamos no `index.html`, mas sempre deveremos colocar no momento em que as *tags* vão aparecendo.

Vamos deslocar o `.titulo-destaque` para depois de `.apresentacao__conteudo__titulo` porque possui a *tag* `<strong>` que é utilizada logo depois do `<h1>`.

Começaremos a estilização do escrito para depois posicionarmos os elementos, então a classe `"cabecalho__menu__link"` na âncora `<a>` de `index.html` será copiada e colada após o `body` em `style.css`.

Abriremos as chaves de `.cabecalho__menu__link` e dentro colocaremos as propriedades de cor, fonte e tamanho obtidas do projeto do Figma.

**Guilherme:** Primeiro, a `font-family:` é `'Montserrat', sans-serif`, depois o `font-size:` terá o valor de `24px` e, por fim, seu peso `font-weight:` será de `600`.

**Rafaella:** Também precisaremos trocar a cor do texto de cabeçalho para azul claro, e já temos este valor também. Então `color:` será `#22D4FD`. Salvaremos e analisaremos o resultado no navegador.

```
//código omitido

body {
    /*height: 100vh */
    box-sizing: border-box;
    background-color: #000000;
    color: #F6F6F6;
}

.cabecalho__menu__link {
    font-family: 'Montserrat', sans-serif;
    font-size: 24px;
    font-weight: 600;
    color: #22D4FD;
}

//código omitidoCOPIAR CÓDIGO
```

**Rafaella:** Com isso, teremos nossos elementos estilizados.

**Guilherme:** Agora precisaremos trabalhar no posicionamento deles.

**Rafaella:** Exatamente, e poderemos usar o cabeçalho para estabelecer a posição de cima para baixo com espaçamento lateral usando `padding:`.

Pegaremos a classe `"cabecalho"` do `<header>` em `index.html` que agrupará toda a barra de navegação que contém as duas *tags* âncoras para podermos estilizá-las.

Copiaremos o nome dessa `class` e a adicionaremos acima de `.cabecalho__menu__link`, pois aparece antes.

Dentro das chaves, colocaremos o `padding:` para espaçarmos as duas âncoras, e queremos apenas na parte superior e de um lado só. Já aprendemos uma forma de escrevermos dois valores para trabalharmos no sentido vertical e horizontal.

Porém, agora precisaremos espaçar apenas dois lados, e não no sentido vertical e horizontal, e para isso poderemos inserir quatro valores para o `padding:`, o qual possui uma ordem específica.

Analisando a [documentação do `padding:` aqui](https://www.w3schools.com/cssref/pr_padding.php), encontraremos a parte "Se a propriedade *padding* tiver quatro valores:", que é justamente o que queremos.

O primeiro diz respeito à parte superior do conteúdo.

**Guilherme:** Então, no `padding:` de `.cabecalho`, colocaremos o valor `2%` em porcentagem que é melhor, pois se fixarmos em pixels, pode ser que sofra distorções na tela dependendo do dispositivo que acessará a aplicação.

```
//código omitido

body {
    /*height: 100vh */
    box-sizing: border-box;
    background-color: #000000;
    color: #F6F6F6;
}

.cabecalho {
    padding: 2%;
}

//código omitidoCOPIAR CÓDIGO
```

**Rafaella:** Feito isso, notaremos que a porcentagem foi aplicada a todos os quatro lados do conteúdo, pois só colocamos um valor apenas.

De volta à documentação, o espaçamento do lado direito será o segundo valor, que neste caso será `0%`. Já o terceiro valor diz respeito ao espaçamento inferior que também será `0%`. Por fim, o quarto valor do preenchimento do lado esquerdo terá `10%`.

Salvaremos e veremos o resultado no navegador.

```
//código omitido

.cabecalho {
    padding: 2% 0% 0% 10%;
}

//código omitidoCOPIAR CÓDIGO
```

**Rafaella:** Com isso, repararemos que o espaçamento já está bem diferente de antes.

**Guilherme:** Mas ainda não está na mesma linha.

**Rafaella:** Isso aconteceu porque colocamos um `padding:` horizontal de `15%` como segundo valor no `main` de `.apresentacao` do `style.css`.

Então, para ficar mais parecido com o Figma, colocaremos o valor de `15%` ao invés de `10%` no `padding:` do `.cabecalho`.

```
//código omitido

.cabecalho {
    padding: 2% 0% 0% 15%;
}

//código omitidoCOPIAR CÓDIGO
```

**Rafaella:** Feito isso, o texto já ficará alinhado. Agora, precisaremos afastar um pouco os conteúdos das duas *tags* âncoras.

No arquivo `index.html`, iremos para a `<nav>` e usaremos o FlexBox, lembrando que sempre jogaremos o `display: flex` no elemento *container*, no elemento-pai.

Copiaremos a classe `"cabecalho__menu"` e colaremos após o `.cabecalho` em `style.css`. Dentro, criaremos a propriedade `display: flex` para inicializarmos o FlexBox.

**Guilherme:** Vamos ver qual é essa distância de `gap:` no Figma.

**Rafaella:** Descobriremos que é de `80px`.

```
//código omitido

.cabecalho {
    padding: 2% 0% 0% 15%;
}

.cabecalho__menu {
    display: flex;
    gap: 80px;
}

//código omitidoCOPIAR CÓDIGO
```

**Rafaella:** Feito isso, teremos o espaçamento entre os textos "Home" e "Sobre mim" que queríamos.

Então terminamos nosso cabeçalho, porém ainda não está funcional, ou seja, quando clicamos em algum dos dois links, não nos direcionamos para as respectivas páginas.

**Guilherme:** Ainda tem um detalhe, pois seria interessante subir o bloco de texto que inicia com "Eleve seu negócio digital...".

**Rafaella:** Podemos subir para que fique mais próximo do cabeçalho.

De volta ao `padding:` de `.apresentacao` em `style.css`, substituiremos o valor `8%` por `5%`.

```
//código omitido

.cabecalho__menu__link {
    font-family: 'Montserrat', sans-serif;
    font-size: 24px;
    font-weight: 600;
    color: #22D4FD;
}

.apresentacao {
    padding: 5% 15%;
    display: flex;
    align-items: center;
    justify-content: space-between;
}

//código omitidoCOPIAR CÓDIGO
```

**Rafaella:** Assim ficou bem melhor e mais parecido com o projeto final no Figma.

**Guilherme:** Então já temos a página inteira feita.

**Rafaella:** Exato, mas ainda não está funcional, porque ao clicarmos ainda não vamos para outra página.

**Guilherme:** O desafio será tornar esse menu funcional para nos direcionarmos à página de "Sobre mim" para depois a desenvolvermos.