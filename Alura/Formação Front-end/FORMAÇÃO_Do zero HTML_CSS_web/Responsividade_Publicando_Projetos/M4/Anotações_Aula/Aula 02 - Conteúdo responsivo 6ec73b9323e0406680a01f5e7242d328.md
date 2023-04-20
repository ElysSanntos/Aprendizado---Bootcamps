# Aula 02 - Conteúdo responsivo

**Rafaella:** Estamos melhorando o *design* para telas menores cada vez mais, porém ainda há bastante trabalho pela frente.

**Guilherme:** Na tela do navegador, vai parecer que todo o nosso texto foi "espremido" ao centro.

**Rafaella:** Exatamente, todo o texto está com muitas linhas para caber no meio entre os espaços que colocamos nas laterais da tela.

**Guilherme:** Este espaçamento é a largura do comprimento.

**Rafaella:** Sim, e definimos isso em nosso CSS para telas maiores, mas para as menores, ainda precisaremos fazer alterações.

No `style.css`, iremos ao `.apresentacao` que contém tanto a parte de imagem quanto de texto do`<main>` de classe `"apresentacao"` no arquivo `index.html`, em que adicionamos um `padding:` de `5%` e `15%`.

Lembrando que, sempre que tivermos dois valores nessa propriedade, o primeiro dirá respeito respectivamente ao espaço superior e inferior, enquanto o segundo definirá os espaços laterais.

Em nosso caso, o valor de `15%` é muito grande, então diminuiremos para telas menores.

**Guilherme:** Colocaremos um `padding:` de `5%` abaixo do `flex-direction:` de `.apresentacao` dentro `@media` da largura máxima de `1200px`.

**Rafaella:** Fazendo isso, teremos o mesmo espaço para todos os lados. Vamos salvar e avaliar o resultado no navegador.

```
//código omitido

@media (max-width: 1200px) {
    .cabecalho {
        padding: 10%;
    }

    .cabecalho__menu {
        justify-content: center;
    }

    .apresentacao {
        flex-direction: column-reverse;
        padding: 5%;
    }
}COPIAR CÓDIGO
```

**Guilherme:** Melhorou, mas o espaçamento diminuiu pouco.

**Rafaella:** Para entendermos o que aconteceu, abriremos o Inspecionador de Elementos no navegador e clicaremos no primeiro ícone que aparece no topo desta aba.

Conseguiremos ver o `padding:` de `5%`, mas o conteúdo em si ainda está muito grande mesmo tendo apenas os textos dos parágrafos e os botões.

Adicionamos algo a mais, então abriremos o `style.css` e iremos para a `.apresentacao__conteudo` em que definimos a largura `width:` de `50%`.

Quando temos telas grandes, queremos que a largura ocupe bastante o espaço do elemento-pai, ou seja, metade dele com `50%`.

Porém, nos dispositivos menores, queremos que a largura acompanhe o `padding:` que definimos no `.apresentacao` acima, lembrando que a classe `"apresentacao__conteudo"` no `index.html` tem apenas o título, o parágrafo e os links.

Então precisaremos alterar a largura de `50%`. Portanto, ao final do arquivo `style.css`, adicionaremos `.apresentacao__conteudo` dentro do `@media` de `1200px`.

Dentro das chaves, colocaremos o `width:` com `0`.

**Guilherme:** Se estamos usando só a metade da tela e o espaçamento ainda não está bom, iremos "zerar" a largura.

**Rafaella:** Sim, e com isso não teremos uma largura fixa, mas vamos salvar e testar para termos certeza.

```
//código omitido

@media (max-width: 1200px) {

//código omitido

    .apresentacao {
        flex-direction: column-reverse;
        padding: 5%;
    }

    .apresentacao__conteudo {
        width: 0;
    }
}COPIAR CÓDIGO
```

**Rafaella:** A tela ficou pior do que estava antes e os textos ficaram mais apertados e com mais linhas ainda.

Isso aconteceu porque a propriedade `width:` precisa existir, e estamos apenas dizendo que nosso seletor `.apresentacao__conteudo` não terá largura nenhuma quando damos o valor `0`, mas possui um conteúdo e irão ultrapassar os limites.

Portanto, não poderemos simplesmente "zerar" deste jeito, então teremos que dar um valor que siga o comportamento do elemento-pai, como pegar todo o espaço disponível.

**Guilherme:** Existe uma maneira que delimita a área a ser ocupada e o `padding:`.

**Rafaella:** Sim, é o valor `auto` de "automático". Vamos aplicá-lo e salvar o código para avaliarmos o resultado.

```
//código omitido

@media (max-width: 1200px) {

//código omitido

    .apresentacao {
        flex-direction: column-reverse;
        padding: 5%;
    }

    .apresentacao__conteudo {
        width: auto;
    }
}COPIAR CÓDIGO
```

**Rafaella:** Quando fizermos isso, o conteúdo irá se adequar à área da tela conforme queríamos e o `padding:` de `5%` estará funcionando.