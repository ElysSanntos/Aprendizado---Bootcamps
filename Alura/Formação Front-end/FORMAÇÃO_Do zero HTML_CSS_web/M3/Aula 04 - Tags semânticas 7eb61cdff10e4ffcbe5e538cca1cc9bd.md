# Aula 04 - Tags semânticas

**Rafaella:** Iremos iniciar nosso projeto e **transformar o design do Figma em código**.

**Guilherme:** Vamos abrir o arquivo `index.html` no VSCode. Sempre que criarmos uma página HTML, devemos escrever `<!DOCTYPE html>`, `<html>`, `<head>`, `<body>` e fechá-los?

**Rafaella:** Existem alguns atalhos que nos permitem iniciar um documento `.html` com essa estrutura básica.

Para entendermos, excluiremos todo o conteúdo do arquivo, salvaremos e notaremos que não há mais nada da página no navegador, lembrando que ainda estamos rodando o Live Server.

Em seguida, digitaremos apenas um ponto de exclamação `!` na primeira linha do documento e exibiremos uma janela de título "Emmet Abbreviation" contendo todo um código. Quando simplesmente apertarmos a tecla "Enter", toda a estrutura básica do HTML aparecerá.

```
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
</head>
<body>

</body>
</html>COPIAR CÓDIGO
```

Também perceberemos que há mais coisas do que antes, como as três informações `<meta>` e `lang="en"`. Entenderemos o que são essas novas *tags*.

**Guilherme:** Isso é tão comum que criaram este atalho para gerar o texto automaticamente.

Fazendo uma primeira leitura, ao posicionarmos o cursor sobre `lang="en"`, exibiremos uma caixa de diálogo com um texto explicando que este trecho define a língua oficial do elemento que estamos trabalhando, que neste caso está em inglês.

**Rafaella:** Utilizaremos em português e escreveremos o conteúdo usando os acentos específicos que não são usados com `"en"`, então substituiremos por `"pt-br"` para especificar que é do Brasil.

**Guilherme:** Na quarta linha, encontraremos a primeira tag `<meta>` seguido de `charset="UTF-8"`.

**Rafaella:** O **`UTF-8`** é a **codificação dos caracteres** mais usada no mundo, pois consegue trazer todos os acentos que comentamos, além de interpretar corretamente as outras línguas.

**Guilherme:** É **Unicode**, como se fosse um grande dicionário de caracteres que usaremos na aplicação.

**Rafaella:** Se não utilizarmos o `UTF-8`, pode ser que não consigamos exibir acentos como `~` ou circunflexo `^` corretamente em alguns navegadores.

**Guilherme:** Entendi! E na quinta linha com a segunda `<meta>` que tem `http-equiv="X-UA-Compatible"` e `content="IE=edge"`, é algo para o **Microsoft Edge**?

**Rafaella:** Exato, esta é uma configuração para sempre utilizarmos sua versão mais recente neste navegador especificamente.

Caso estejamos rodando o código no Edge, é importante que coloquemos esta informação `<meta>`, além de que a pessoa usuária final que vai usar nossa aplicação pode estar rodando nele também, principalmente se forem versões anteriores.

**Guilherme:** Já na sétima linha, temos o `<title>` que já conhecemos, contendo `Document`. Na sexta linha com o terceiro `<meta>` que tem `name="viewport"` e o `content` que inclusive fica com a parte final encoberta pelo limite da tela do VSCode.

Se apertarmos as teclas "Alt + Z" com o cursor sobre esta linha, iremos fazer com que este trecho passe para a linha seguinte e fique totalmente visível dentro do espaço de texto.

Aparentemente, o conteúdo de `content` parece dizer respeito à largura e ao tamanho da imagem.

**Rafaella:** Exato, o nome `"viewport"` é o próprio **dispositivo** que acessará nossa página, e obtém sua **largura** com `width=device-width` para depois gerar a **escala** da página com `initial-scale`, que sempre iniciará com `1.0` com base na tela, seja de celular, Ipad, computador, entre outras.

Com isso, não teremos o problema dos elementos ficarem posicionados de forma errada e nem da fonte ter um tamanho desproporcional.

**Guilherme:** Cientes disso, poderemos começar alterando o conteúdo do `<title>`.

**Rafaella:** Escreveremos `Portfolio` mesmo, que é o nosso projeto. Salvaremos e abriremos o navegador para exibirmos este nome na aba. Como é uma **metainformação**, não aparecerá no corpo da página. Agora começaremos a desenvolver todos os elementos dela.

**Guilherme:** Mas só iremos escrever HTML diretamente?

**Rafaella:** Talvez sim, e há pessoas que fazem isso apesar de **não** ser recomendado, pois sempre teremos que pensar e planejar o que iremos desenvolver em nossa página *web*.

Por exemplo, é interessante analisarmos o Figma e separar nossas tarefas em partes, como pelo cabeçalho da página no topo, ou o rodapé na base, e há também o conteúdo principal no centro da tela, como no nosso caso.

No HTML, utilizamos algumas *tags* de maneira **semântica** para separarmos de fato os elementos da página conforme as estruturas que temos. A que seguiremos será pelo cabeçalho, conteúdo principal e o rodapé.

**Guilherme:** Se acessarmos a própria plataforma da Alura, encontraremos esses elementos. Temos o *menu* onde fazemos o *login*, o conteúdo principal ao centro e o *footer* na base.

**Rafaella:** Às vezes precisaremos descer ou *scrollar* para o final da página, mas este é o básico.

**Guilherme:** Então vamos criar esta estrutura! Como cada um desses elementos são feitos por *tags* que possuem conteúdos internos, elas devem ser abertas com `<` e fechadas com `/>`.

**Rafaella:** Como são *tags* estruturais, sim.

Primeiramente, no topo da página, teremos o menu com **`<header>`** que significa "cabeçalho", que é **diferente** de `<head>`. A inseriremos dentro de `<body>`, abrindo e fechando na mesma linha.

Em seguida, teremos o conteúdo principal em **`<main>`** na linha seguinte, que é a própria tradução do inglês.

Dentro desta *tag*, iremos colocar o título, o parágrafo, os botões e a imagem.

Na linha seguinte, teremos o `<footer>` relativo a "rodapé", também abrindo e fechando.

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
    <main></main>
    <footer></footer>
</body>
</html>
```

**Guilherme:** Com isso, teremos a estrutura básica do HTML, e vamos começar com o `<main>`
.