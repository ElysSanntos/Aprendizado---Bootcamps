# Aula 04 - Criando o CSS

**Rafaella:** Vamos criar o **arquivo CSS** e estilizar nossa página *web*. Para isso, clicaremos no primeiro ícone do lado direito do nome da pasta "PORTFOLIO" na aba lateral "Explorer".

Mas qual nome iremos dar?

**Guilherme:** Damos o nome de `index.html` para a página principal da aplicação, e para o **estilo principal**, geralmente nomeamos apenas como `style.css`, que é "estilos” em inglês.

Com isso, teremos nosso primeiro arquivo CSS.

Voltando ao Figma, notaremos que há vários detalhes como cores dos elementos e fundo, posicionamentos, tamanhos e outras características, então não conseguiremos fazer tudo de uma só vez.

Uma sugestão é começarmos pela cor de fundo e pela cor do texto.

**Rafaella:** É uma boa ideia, porque começamos de algo que engloba todos os elementos até irmos especificando cada um deles.

Conforme a documentação do CSS que vimos anteriormente, conseguimos definir qual a *tag* que queremos alterar. Neste caso, como estamos utilizando a página inteira, conseguiremos usar a `<body>`, que é justamente onde inicia o corpo da página logo abaixo das metainformações.

Na primeira linha em `style.css`, escreveremos `body` e abriremos as chaves `{}` em seguida.

**Guilherme:** Com a tecla "Enter", abriremos o bloco e todos os estilos que aplicaremos ficarão entre as chaves.

A ideia do código em "cascata" remete ao sentido de cima para baixo, e "desceremos" em cada elemento conforme avançamos.

Na aula anterior, comentamos que não aprenderemos todas as propriedades de uma só vez, então focaremos em algumas específicas.

**Rafaella:** Há uma que é relacionada a cor do plano fundo, chamada **`background-color:`**, que é este mesmo termo em inglês.

**Guilherme:** Quando estamos escrevendo `background`, o próprio editor de código exibe as opções possíveis em uma lista.

**Rafaella:** Conseguiremos autocompletar da mesma forma que fizemos no HTML, subindo e descendo com as setas do teclado para passar pelos sufixos disponíveis.

Em nosso caso, queremos o `background-color:`, então o selecionaremos e apertaremos a tecla "Tab" para autocompletar. Em seguida, o editor preencherá com a estrutura que usaremos para aplicarmos o valor da propriedade.

Como observamos no Figma, a cor do *background* é preta, então bastará escrevermos `black` e salvaremos o arquivo.

```
body {
    background-color: black;
}COPIAR CÓDIGO
```

**Rafaella:** No navegador, notaremos que o código não funcionou porque a cor de fundo continua branca como antes.

**Guilherme:** Isso se deu porque algo de errado aconteceu na **comunicação** entre o arquivo CSS e o HTML.

**Rafaella:** Exatamente, pois simplesmente não ligamos um ao outro, e precisaremos sempre *linkar* o CSS no HTML para que seja utilizado e os estilos sejam de fato aplicados.

Abrindo o `index.html`, iremos às metainformações do `<head>` e usaremos uma *tag* chamada **`<link>`**, a qual também possui algumas propriedades que serão inseridas dentro para indicarmos o arquivo CSS que iremos usar.

Primeiro, escreveremos a **`rel`** que irá indicar qual a relação do documento HTML com o outro que traremos, que no caso será **`"stylesheet"`** que significa "folha de estilo".

Em seguida, colocaremos onde este arquivo está usando `href` igual ao nosso próprio `"style.css"` entre aspas. Por fim, fecharemos a *tag* apenas com `>` e salvaremos o arquivo para vermos o resultado.

```
<!DOCTYPE html>
<html lang="pt-br">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Portfolio</title>
    <link rel="stylesheet" href="styles.css">
</head>

//código suprimidoCOPIAR CÓDIGO
```

**Rafaella:** No navegador, veremos a cor de fundo preta desta vez.

**Guilherme:** Sim, porém todo o texto sumiu porque é da mesma cor do *background*, mas é possível vê-lo quando o selecionamos com o cursor do mouse, então ainda está na página.

**Rafaella:** Vamos mudar apenas a cor do texto. Em nosso arquivo `style.css` no editor de código, usaremos a propriedade **`color:`**.

**Guilherme:** Então teremos o `background-color` que diz respeito à cor de fundo, e apenas `color:` que altera a cor do texto.

**Rafaella:** Vamos definir como branco usando o valor `white`, do mesmo jeito que aparece no projeto do Figma.

```
body {
    background-color: black;
    color: white;
}COPIAR CÓDIGO
```

**Rafaella:** Salvando e atualizando nossa página no navegador, conseguiremos exibir o texto em branco sobre um fundo preto, tornando a leitura possível.

![https://cdn1.gnarususercontent.com.br/1/308174/1fe44d7c-2493-4328-a480-29d7bd299675.png](https://cdn1.gnarususercontent.com.br/1/308174/1fe44d7c-2493-4328-a480-29d7bd299675.png)

**Guilherme:** Só os *links* que ainda aparecem em azul e sublinhados na base esquerda da imagem da programadora.

**Rafaella:** Mais adiante iremos estilizá-los especificamente, mas por enquanto já conseguimos aplicar alguns estilos.