# Aula 02 - Desenvolvendo o footer

**Guilherme:** Nosso próximo desafio sera o menu de "Home" e "Sobre mim", ou o *footer*. O que você sugere, Rafa?

**Rafaella:** Como ainda não criamos a outra página, poderemos finalizar o rodapé da página inicial para depois trabalharmos no menu.

**Guilherme:** Vamos copiar o texto de "Desenvolvido por Alura" na base da tela do Figma, porque é o único conteúdo que possui.

**Rafaella:** Sim, depois abriremos o arquivo `index.html` no VSCode e iremos até o `<footer>` que tínhamos definido no momento em que separamos a página em `<header>`, `<main>` e a *tag* do rodapé.

Dentro dela, abriremos uma nova linha e adicionaremos um parágrafo com `<p>` que receberá o texto copiado do Figma.

**Guilherme:** Lembrando que "Desenvolvido por Alura" pode ser substituído por qualquer outro escrito que quisermos.

**Rafaella:** No `<footer>`, adicionaremos uma classe chamada `"rodape"` para podermos estilizar o rodapé.

```
<!DOCTYPE html>
<html lang="pt-br">

//código omitido

<body>

//código omitido

    <footer class="rodape">
        <p>Desenvolvido por Alura.</p>
    </footer>
</body>
</html>COPIAR CÓDIGO
```

**Rafaella:** Em seguida, acessaremos o arquivo `style.css` e, na última linha, criaremos o seletor `.rodape` e abriremos chaves.

**Guilherme:** Salvando e voltando ao navegador, notaremos o texto "Desenvolvido por Alura" escrito bem pequeno na parte esquerda da base da tela.

Mesmo que não tenhamos colocado uma propriedade `color:` diretamente em `.rodape`, os caracteres aparecem na cor branca porque definimos como `#F6F6F6` em `body`.

**Rafaella:** Esse texto "herda" dos elementos-pais que estão acima, e por isso fica em branco mesmo automaticamente.

**Guilherme:** Então vamos alterar a cor do texto do `.rodape` colocando `color:` com o valor `#000000` para ficar na cor preta.

Já a propriedade da cor de fundo `background-color` terá o valor hexadecimal `#22D4FD` para ficar com a cor azul claro.

Conforme utilizamos a mesma paleta com os mesmos valores nas propriedades, o VSCode memoriza automaticamente o que escrevemos.

```
//código omitido

.rodape {
    color: #000000;
    background-color: #22D4FD;
}COPIAR CÓDIGO
```

**Guilherme:** Vamos observar o resultado no navegador.

**Rafaella:** Já está aparecendo com a cor de texto e de fundo que definimos, mas a faixa ainda está muito estreita porque tem a altura do conteúdo, então não há uma margem e uma borda com `padding:` no rodapé.

**Guilherme:** Vamos relembrar o que é essa propriedade?

**Rafaella:** Abrindo a janela lateral de "Inspecionar" em nossa página no navegador, teremos uma parte inferior com a aba "Estilos" contendo a representação dos elementos da tela.

![https://cdn1.gnarususercontent.com.br/1/308174/0e24ae50-2bfe-457f-b5cc-f31cfaa37b4d.png](https://cdn1.gnarususercontent.com.br/1/308174/0e24ae50-2bfe-457f-b5cc-f31cfaa37b4d.png)

**Guilherme:** Temos a margem ou "*margin*" que é onde o conteúdo está, dentro dela temos a borda ou "*border*" onde inserimos o `border-radius`, e dentro dele há o "*padding*" que representa a distância do conteúdo para a borda de sua área.

**Rafaella:** Neste caso do rodapé, só teremos o conteúdo textual mesmo.

Não colocaremos uma margem para aumentarmos a altura da faixa azul porque significaria da borda dela para os demais elementos externos. No arquivo `style.css`, criaremos uma propriedade `margin:` de `28px` apenas para entendermos como funciona.

```
//código omitido

.rodape {
    margin: 28px;
    color: #000000;
    background-color: #22D4FD;
}COPIAR CÓDIGO
```

**Rafaella:** Quando fazemos isso, salvamos e voltamos ao navegador, notaremos que há um espaçamento entre a borda da tela inteira e o início da faixa azul do rodapé, criando pequenos espaços em preto nas laterais dela.

Como queremos trabalhar na distância entre o conteúdo e a borda dessa própria faixa, substituiremos o `margin:` por `padding:`.

De volta ao Figma, apertaremos a tecla "Alt" e passaremos o cursor sobre o rodapé para obtermos o valor dessa propriedade.

Depois adicionaremos `24px` à propriedade do `.rodape`.

```
//código omitido

.rodape {
    padding: 24px;
    color: #000000;
    background-color: #22D4FD;
}COPIAR CÓDIGO
```

**Rafaella:** Salvando e analisando o resultado no navegador, notaremos uma distância maior entre os limites da faixa azul do rodapé e o conteúdo textual interno.

**Guilherme:** O texto ainda está alinhado à esquerda, e iremos centralizá-lo de acordo com o projeto do Figma usando a propriedade `text-align:`.

**Rafaella:** Exatamente. A colocaremos com o valor `center` e salvaremos o arquivo.

```
//código omitido

.rodape {
    padding: 24px;
    color: #000000;
    background-color: #22D4FD;
    text-align: center;
}COPIAR CÓDIGO
```

**Rafaella:** No navegador, já teremos o escrito centralizado.

**Guilherme:** Ainda precisamos definir a fonte correta e o tamanho do texto.

**Rafaella:** A família da fonte `'Montserrat'` será definida na propriedade `font-family:` que já conhecemos, que também é sem serifa ou `sans-serif`.

Em seguida, o tamanho de `font-size:` será de `24px`. Vamos salvar e analisar a página no navegador.

```
//código omitido

.rodape {
    padding: 24px;
    color: #000000;
    background-color: #22D4FD;
    text-align: center;
    font-family: 'Montserrat', sans-serif;
    font-size: 24px;
}COPIAR CÓDIGO
```

**Rafaella:** Agora já estará bem parecido com o projeto no Figma.

**Guilherme:** Ainda falta vermos se o peso da fonte está certo também.

**Rafaella:** Vamos abrir o Figma e acessar a aba "Inspect" da janela lateral direita de propriedades, onde descobriremos que é `400`.

De volta ao código, adicionaremos `font-weight:` com este valor, salvaremos e observaremos o resultado no navegador.

```
//código omitido

.rodape {
    padding: 24px;
    color: #000000;
    background-color: #22D4FD;
    text-align: center;
    font-family: 'Montserrat', sans-serif;
    font-size: 24px;
    font-weight: 400;
}COPIAR CÓDIGO
```

**Rafaella:** Agora já está certo.

**Guilherme:** Como comentamos no início do nosso curso, queremos que todo o conteúdo em `body` esteja visível no tamanho da página usando a propriedade `height: 100vh` que determina a altura.

**Rafaella:** Ou seja, este valor é de 100% do *viewport height* ou da "altura da tela".

**Guilherme:** Agora não há mais necessidade de termos isso.

**Rafaella:** Sim, afinal já temos um rodapé e mais elementos na página, e antes os elementos não alcançavam a base da tela, justificando o uso de toda altura disponível que não é mais necessário.

Inclusive, abrindo o Inspecionador de Elementos e selecionando a área do `body`, veremos que a seleção não atinge a base onde está o rodapé.

Portanto é interessante retiramos a `height: 100vh` para ajustarmos um novo valor e o *footer* ficar dentro do `body`.

No `style.css`, comentaremos a linha desta propriedade da altura usando o atalho "Ctrl + K + C" e salvaremos.

```
//código omitido

body {
    /* height: 100vh; */
    box-sizing: border-box;
    background-color: #000000;
    color: #F6F6F6;
}

//código omitidoCOPIAR CÓDIGO
```

Com a aba de Inspecionar Elementos aberta no navegador, notaremos que a seleção do `body` estará englobando toda a página, inclusive os novos elementos adicionados que estavam maiores do que a área visível da tela.

**Guilherme:** Outro problema que temos agora é que os espaçamentos entre todos os elementos estão maiores do que deveriam. Quando navegamos e *scrollamos*, notaremos um espaço desnecessariamente grande no topo.

**Rafaella:** Já tínhamos definido essas margens como `10%` e `15%`, então poderemos usar um `padding:` ao invés de `margin:`, o qual definirá a distância da borda da tela até o conteúdo interno.

Em `.apresentacao` no `style.css`, substituiremos a propriedade de margem pelo `padding:`.

**Guilherme:** Vamos testar um valor de porcentagem como de `5%`, por exemplo.

```
//código omitido

.apresentacao {
    padding: 5% 15%;
    display: flex;
    align-items: center;
    justify-content: space-between;
}

//código omitidoCOPIAR CÓDIGO
```

**Rafaella:** Salvando e observando a página no navegador, notaremos que os elementos até cabem na tela, mas o ideal é mantermos um espaço para inserirmos o cabeçalho. Então vamos testar o valor de `8%`.

**Guilherme:** E já ficou bem melhor.

A seguir, nosso próximo passo será trabalharmos com o `header`.