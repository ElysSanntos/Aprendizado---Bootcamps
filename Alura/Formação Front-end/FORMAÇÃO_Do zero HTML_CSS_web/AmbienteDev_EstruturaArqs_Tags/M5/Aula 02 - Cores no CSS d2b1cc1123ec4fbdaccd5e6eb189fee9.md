# Aula 02 - Cores no CSS

**Guilherme:** Já conseguimos alterar tanto a cor de fundo quanto a cor do texto, mas ainda há um detalhe importante.

No Figma, será que a cor branca que colocamos com `white` é realmente esta?

Abrindo o projeto no Figma e selecionando o bloco de texto, notaremos que há duas cores: um valor `22D4FD` para azul claro e `F6F6F6` para o branco, e não `white`.

Mas isso tem uma diferença, afinal não faz sentido dizermos no cotidiano que outros objetos de cor branca são da cor "F6F6F6", como uma camisa por exemplo, dizemos que é "branca". Mas para o computador, faz sentido.

**Rafaella:** Vamos usar esses valores obtidos do Figma em nossas propriedades no arquivo `style.css`. Copiaremos "F6F6F6" e colaremos no lugar de `white` em `color:` para salvarmos e vermos o resultado.

```
body {
    background-color: black;
    color: F6F6F6;
}COPIAR CÓDIGO
```

No navegador, notaremos que o texto está em preto, da mesma cor que o fundo, e não ficou visível.

**Guilherme:** Sabemos que o texto ainda está no corpo da página quando selecionamos com o cursor do mouse.

**Rafaella:** Está com a cor padrão que é preto igual ao fundo, do mesmo jeito que estava antes de aplicarmos estilos no CSS. Ou seja, apenas o que escrevemos de valor para a cor branca não está funcionando.

**Guilherme:** Não reconheceu porque temos que adicionar um sinal quando queremos representar cores de outra forma, que é a cerquilha ou *hashtag* `#` antes do valor da cor.

```
body {
    background-color: black;
    color: #F6F6F6;
}COPIAR CÓDIGO
```

**Rafaella:** Salvando e atualizando a página no navegador, conseguiremos deixar o texto em branco sobre o fundo preto.

**Guilherme:** Então teremos um problema, pois conseguimos representar cores no HTML e estilizando no CSS de maneiras diferentes.

Na barra de busca no navegador, pesquisaremos por "cores no CSS" e, logo no topo da lista de resultados do buscador, aparecerá a **Especificação CSS Level 1**.

| Especificação | Palavra-chave | valores hex RGB |
| --- | --- | --- |
|  | gray | #808080 |
| CSS Level 1 | white | #ffffff |
|  | marron | #800000 |
| red | #ff0000 |  |

Portanto, existem formas diferentes de gerar nossas cores.

Acessando a [documentação oficial do Mozilla neste link](https://developer.mozilla.org/pt-BR/docs/Web/CSS/color_value), encontraremos uma tabela mais completa de cores, nomes e códigos.

Repararemos que podemos usar **palavras-chave** para as cores como o `black` e `white` que fizemos antes. Mas também poderemos representá-las com **Notação Hexadecimal RGB** que sempre começam com a cerquilha `#` seguido de seis números ou letras.

**Rafaella:** O Hexadecimal usa números de zero até nove e da letra "A" até "F". Por exemplo, o preto que é a ausência de cor é "000000", e o branco que é a junção de todas as cores é "ffff".

Todas as outras cores estão neste intervalo e sua numeração representa a proporção de vermelho, verde e azul que possuem, ou seja, *red*, *green* e *blue* que compõe o padrão RGB.

**Guilherme:** Vamos fazer um teste então. Eu vou escolher a cor "purple" por palavra-chave.

**Rafaella:** E eu vou outra com valor "00ffff" pelo RGB.

**Guilherme:** De volta ao código `style.css`, vamos usar a cor `purple` em `background-color:` e `#00ffff` em `color:`

```
body {
    background-color: purple;
    color: #00ffff;
}COPIAR CÓDIGO
```

**Guilherme:** Vamos salvar e ver como ficaram essas cores aleatórias na página do navegador.

![https://cdn1.gnarususercontent.com.br/1/308174/3b763c63-ef52-4860-a0b3-1456cd1ad93a.png](https://cdn1.gnarususercontent.com.br/1/308174/3b763c63-ef52-4860-a0b3-1456cd1ad93a.png)

**Guilherme:** Não ficou tão ruim, mas a versão que a pessoa *designer* elaborou para nosso projeto é muito melhor. De volta ao nosso código no VSCode, voltaremos com as cores `black` e `#F6F6F6` do nosso projeto.

Isso acontece porque a junção das cores de **forma harmônica** é baseada em estudos, boas práticas e conceitos da área.

> Deixaremos um desafio para pesquisar e escolher as cores que poderiam ficar interessantes, e há várias ferramentas para isso.
> 

Pesquisando no navegador, digitaremos "roda de cores adobe" na barra de busca e clicaremos no [link do **Adobe Colors**](https://color.adobe.com/pt/create/color-wheel).

Esta Roda de Cores produz paletas com boa interação entre si que ajudam na escolha dos estilos, e há várias regras de harmonia de cores como "Análogo", "Monocromático", "Tríade", "Complementar"< entre outras. Vale a pena explorar, mas há outros também.

**Rafaella:** Continuando, poderemos deixar a cor `black` como padrão substituindo-a pelo Hexadecimal `#00000` em `background-color`.

```
body {
    background-color: #000000;
    color: #F6F6F6;
}COPIAR CÓDIGO
```

**Rafaella:** Salvaremos e rodaremos a aplicação sem problemas.