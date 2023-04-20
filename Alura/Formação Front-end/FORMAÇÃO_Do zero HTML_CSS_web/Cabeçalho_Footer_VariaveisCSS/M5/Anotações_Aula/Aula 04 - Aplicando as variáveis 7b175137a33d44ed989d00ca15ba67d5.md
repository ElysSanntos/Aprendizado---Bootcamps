# Aula 04 - Aplicando as variáveis

**Rafaella:** Declaramos todas as nossas variáveis. Precisamos utilizá-las nos trechos de código que fazem uso dessas cores. Para isso, voltaremos à nossa [documentação sobre variáveis do CSS no site Developer Mozilla](https://developer.mozilla.org/pt-BR/docs/Web/CSS/Using_CSS_custom_properties) para consultar a seção abaixo da declaração de variáveis, onde encontraremos as instruções para utilização delas.

Temos o `element {}`, que poderá ser o `body`, a *tag* `<h2>`, o `<p>`, entre outros. Dentro dele, adiciona-se a propriedade `background-color`, a qual receberá a variável declarada anteriormente (`--main-bg-color`) dentro da função `var()`.

```
element {
    background-color: var(--main-bg-color);
}COPIAR CÓDIGO
```

Faremos esse procedimento, voltando ao VS Code.

**Guilherme:** Nos atentaremos ao detalhe mais importante: sempre que reutilizarmos variáveis, adicionaremos a função `var()` e o nome da variável entre os parênteses.

**Rafaella:** No arquivo CSS faremos as alterações a seguir.

> Guilherme: Dica: No momento em que digitamos "var(" e pressionamos "Enter", o sistema abre uma lista com as variáveis disponíveis. Podemos selecionar cada uma por meio dessa lista.
> 

Dentro das chaves do `body {}`, deletaremos os códigos hexadecimais e adicionaremos as funções abaixo:

- na propriedade `background-color` adicionaremos a `var(--cor-primaria)`;
- na propriedade `color` adicionaremos a `var(--cor-secundaria)`.

Dentro das chaves das classes `.cabecalho__menu__link {}` e `.titulo-destaque {}`:

- na propriedade `color` removeremos os hexadecimais e adicionaremos a função `var(--cor-terciaria)`.

Dentro das chaves da classe `.apresentacao__links__link {}`, por sua vez, deletaremos os hexadecimais e adicionaremos as funções abaixo:

- na propriedade `border` adicionaremos a `var(--cor-terciaria)`;
- na propriedade `color` adicionaremos a `var(--cor-secundaria)`;

O resultado das alterações qeu fizemos pode ser consultado abaixo.

```
body {
    /* height: 100vh; */
    box-sizing: border-box;
    background-color: var(--cor-primaria);
    color: (--cor-secundaria);
}

// código omitido

.cabecalho__menu__link {
    font-family: 'Montserrat', sans-serif;
    font-size: 24px;
    font-weight: 600;
    color: var(--cor-terciaria);
}

// código omitido

.titulo-destaque {
    color: var(--cor-terciaria);
}

// código omitido

.apresentacao__links__link {
    /* background-color: #22D4FD; */
    display: flex;
    justify-content: center;
    gap: 16px;
    border: 2px solid var(--cor-terciaria);
    width: 378px;
    text-align: center;
    border-radius: 8px;
    font-size: 24px;
    font-weight: 600;
    padding: 21.5px 0;
    text-decoration: none;
    color: var(--cor-secundaria);
    font-family: 'Montserrat', sans-serif;
}COPIAR CÓDIGO
```

**Rafaella:** Quando chegamos na classe `.apresentacao__links__link:hover {}`, percebemos que não criamos uma variável para a cor do Hover. Vamos criá-la para que seja possível modificá-la em relação à cor de fundo, caso necessário. No interior das chaves de `:root {}`, abaixo das outras cores, adicionaremos a variável `--cor-hover`, a qual receberá a cor `#272727`.

```
:root {
    --cor-primaria: #000000;
    --cor-secundaria: #F6F6F6;
    --cor-terciaria: #22D4FD;
    --cor-hover: #272727;
}COPIAR CÓDIGO
```

Retornaremos à classe `.apresentacao__links__link:hover {}` e continuaremos as nossas modificações. Dentro de suas chaves, na propriedade `background-color`, deletaremos o hexadecimal e adicionaremos a função `var(--cor-hover)`.

Por fim, dentro das chaves da classe `.rodape {}`, deletaremos os códigos hexadecimais e adicionaremos as funções abaixo:

- na propriedade `color` adicionaremos a `var(--cor-primaria)` e
- na propriedade `background-color` adicionaremos a `var(--cor-terciaria)`;

O resultado das novas alterações pode ser consultado abaixo.

```
.apresentacao__links__link:hover {
    background-color: var(--cor-hover);
}

.rodape {
    padding: 24px;
    color: var(--cor-primaria);
    background-color: var(--cor-terciaria);
    text-align: center;
    font-family: 'Montserrat', sans-serif;
    font-size: 24px;
    font-weight: 400;
}COPIAR CÓDIGO
```

Além das variáveis de cor, vamos declarar as ***variáveis de fonte***, pois também se tratam de ***dados muito repetidos*** ao longo do nosso código.

Voltaremos ao interior das chaves do `:root {}` e abaixo das variáveis existentes, criaremos mais duas: `--fonte-primaria` e `--font-secundaria`. Vamos manter um espaço entre os dois tipos de variáveis com uma linha vazia.

Na primeira variável nova, adicionaremos o valor do título:`'Krona One', sans-serif`, enquanto que na segunda adicionaremos o valor dos parágrafos: `'Montserrat', sans-serif`.

```
:root {
    --cor-primaria: #000000;
    --cor-secundaria: #F6F6F6;
    --cor-terciaria: #22D4FD;
    --cor-hover: #272727;

    --fonte-primaria: 'Krona One', sans-serif;
    --font-secundaria: 'Montserrat', sans-serif;
}COPIAR CÓDIGO
```

Agora faremos a troca dos valores hexadecimais pelas novas variáveis, em todos os locais que utilizamos essas cores:

- na classe `.cabecalho__menu__link {}`, adicionaremos a `var(--font-secundaria)`;
- na classe `.apresentacao__conteudo__titulo {}`, adicionaremos a `var(--fonte-primaria)`;
- na classe `.apresentacao__conteudo__texto {}`, adicionaremos a `var(--font-secundaria)`;
- na classe `.apresentacao__links__subtitulo {}`, adicionaremos a `var(--fonte-primaria)`;
- na classe `.apresentacao__links__link {}`, adicionaremos a `var(--font-secundaria)` e por fim,
- na classe `.rodape {}`, adicionaremos a `var(--font-secundaria)`.

```
// código omitido

.cabecalho__menu__link {
    font-family: var(--font-secundaria);
    font-size: 24px;
    font-weight: 600;
    color: var(--cor-terciaria);
}

// código omitido

.apresentacao__conteudo__titulo {
    font-size: 36px;
    font-family: var(--fonte-primaria);
}

// código omitido

.apresentacao__conteudo__texto {
    font-size: 24px;
    font-family: var(--font-secundaria);
}

// código omitido

.apresentacao__links__subtitulo {
    font-family: var(--fonte-primaria);
    font-weight: 400;
    font-size: 24px;
}

.apresentacao__links__link {
    /* background-color: #22D4FD; */
    display: flex;
    justify-content: center;
    gap: 16px;
    border: 2px solid var(--cor-terciaria);
    width: 378px;
    text-align: center;
    border-radius: 8px;
    font-size: 24px;
    font-weight: 600;
    padding: 21.5px 0;
    text-decoration: none;
    color: var(--cor-secundaria);
    font-family: var(--font-secundaria)
}

// código omitido

.rodape {
    padding: 24px;
    color: var(--cor-primaria);
    background-color: var(--cor-terciaria);
    text-align: center;
    font-family: var(--font-secundaria);
    font-size: 24px;
    font-weight: 400;
}COPIAR CÓDIGO
```

**Guilherme:** Utilizamos essas fontes em vários lugares. Após essas alterações, se voltarmos ao projeto pelo navegador, não veremos nenhuma mudança visual. Contudo, faremos um teste que mostrará toda a diferença: mudaremos a paleta de cores do projeto.

**Rafaella:** Sim. Para isso, acessaremos a [página *Color Hunt*](https://colorhunt.co/), a qual disponibiliza uma seleção de paletas pré-definidas. Selecionaremos, no explorador à esquerda, a opção "Coffee", e nela encontraremos a [paleta nova do nosso projeto, disponível neste link](https://colorhunt.co/palette/2c36393f4e4fa27b5cdcd7c9).

A nova paleta possui as seguintes cores, organizadas do tom mais escuro para o mais claro: `#2C3639` (cinza escuro), `#3F4E4F` (cinza médio), `#A27B5C` (marrom) e `#DCD7C9` (branco creme). Clicaremos em cima de cada faixa de cor para copiar o seu valor hexadecimal automaticamente.

Retornando ao VS Code, trocaremos todas as cores da pseudoclasse `:root {}` conforme abaixo:

- a `-cor-primaria` receberá o valor do cinza escuro: `#2C3639`;
- a `-cor-secundaria` receberá o valor do branco creme: `#DCD7C9`;
- a `-cor-terciaria` receberá o valor do marrom: `#A27B5C` e
- a `-cor-hover` receberá o valor do cinza médio: `#3F4E4F`.

```
:root {
    --cor-primaria: #2C3639;
    --cor-secundaria: #DCD7C9;
    --cor-terciaria: #A27B5C;
    --cor-hover: #3F4E4F;

    --fonte-primaria: 'Krona One', sans-serif;
    --font-secundaria: 'Montserrat', sans-serif;
}COPIAR CÓDIGO
```

**Guilherme:** Não conseguimos nem imaginar como ficará o projeto com essas novas cores. Vamos checar!

![https://cdn1.gnarususercontent.com.br/1/1319057/043f250e-ca66-40e1-8c07-8c05945652ec.png](https://cdn1.gnarususercontent.com.br/1/1319057/043f250e-ca66-40e1-8c07-8c05945652ec.png)

Este foi o resultado. Mudamos somente quatro valores e com eles alteramos as cores do projeto inteiro. A página "Sobre mim" possui o mesmo padrão nas alterações.

Podemos mudar infinitamente e facilmente essas quatro variáveis! Você pode escolher qualquer paleta que quiser para aplicar nesse projeto.

**Rafaella:** É possível modificar cores, fontes e até mesmo criar novas variáveis, caso você julgue que outro valor esteja se repetindo muito dentro do código.

***Por que os ícones e os detalhes da imagem continuaram azul ciano?*** Porque são imagens prontas, baixadas diretamente do Figma. Caso você queira modificá-las, basta substituí-las por imagens de outra cor.

Finalizamos o teste, portanto retornaremos os valores de cor para o seu estado anterior.

```
:root {
    --cor-primaria: #000000;
    --cor-secundaria: #F6F6F6;
    --cor-terciaria: #22D4FD;
    --cor-hover: #272727;

    --fonte-primaria: 'Krona One', sans-serif;
    --font-secundaria: 'Montserrat', sans-serif;
}COPIAR CÓDIGO
```

Agora que finalizamos o projeto, é importante ***remover os comentários que havíamos feito***. Nós comentamos algumas propriedades que não queríamos mais utilizar, mas agora que finalizamos, vamos limpar nosso código removendo-os. A seguir temos a lista de comentários que serão removidos do arquivo `style.css`:

- dentro de `.apresentacao__links__link {}`, removeremos o `/* background-color: #22D4FD */` e
- dentro de `body {}`, removeremos o `/* height: 100vh */`.

Pronto. Temos o nosso projeto finalizado.