# Aula 06 - Estilizando os links

**Rafaella:** Conseguimos posicionar nossos links corretamente. O subtítulo ainda possui fonte e tamanho errados, portanto vamos estilizá-lo.

**Guilherme:** Vamos.

**Rafaella:** Retornaremos ao VS Code e acessaremos o arquivo `index.html`, onde criaremos uma classe para o subtítulo. Acessaremos a *tag* de abertura do nosso `<h2>`, entre os sinais de menor e de maior, e adicionaremos uma `class=""`. Qual será o nome dessa classe?

**Guilherme:** Considerando o padrão seguido, pode ser `apresentacao__links__subtitulo`?

**Rafaella:** Pode ser. Adicionaremos este nome entre as aspas e salvaremos nosso código.

```
//código omitido

    <main class="apresentacao">
        <section class="apresentacao__conteudo">

//código omitido

            <div class="apresentacao__links">
                <h2 class="apresentacao__links__subtitulo">Acesse minhas redes:</h2>
                <a  class="apresentacao__links__link" href="https://instagram.com/rafaballerini">Instagram</a>
                <a class="apresentacao__links__link" href="https://github.com/guilhermeonrails">Github</a>
            </div>
        </section>
        <img src="imagem.png" alt="Foto da Joana Santos programando">
    </main>
    <footer></footer>
</body>
</html>COPIAR CÓDIGO
```

Copiaremos o nome da classe e acessaremos o arquivo `style.css`.

Devemos sempre escrever o CSS ***na ordem em que utilizamos as *tags* no HTML***. Portanto, adicionaremos a nova classe `.apresentacao__links__subtitulo{}` acima de `.apresentacao__links__link{}`.

```
.apresentacao__links__subtitulo{

}

.apresentacao__links__link{
    //código omitido
}COPIAR CÓDIGO
```

Iniciaremos a nossa estilização.

**Guilherme:** O primeiro detalhe a ser alterado será a ***fonte*** do subtítulo.

**Rafaella:** Se acessarmos o Figma e clicarmos neste elemento, descobriremos na aba "Design" o nome da fonte: ***Krona One***. Já utilizamos esta fonte anteriormente, portanto já temos a sua importação no projeto. Basta que a chamemos.

**Guilherme:** Para chamá-la, adicionaremos entre as chaves de `.apresentacao__links__subtitulo{}` um `font-family:'Krona One', 'sans-serif'`. Temos que modificar também o peso e o tamanho dessa fonte.

**Rafaella:** Exato. Se acessarmos o Figma e clicarmos no subtítulo, descobriremos na aba "Inspect" o `font-weight` (ou "peso da fonte"): ***400***. Na mesma aba veremos o *Size* (ou "tamanho") de ***24px***.

Voltaremos ao VS Code e traremos estas configurações adicionando abaixo de `font-family` um `font-weight: 400`. Abaixo de `font-weight`, por sua vez, adicionaremos um `font-size: 24px`.

```
.apresentacao__links__subtitulo{
    font-family:'Krona One', 'sans-serif';
    font-weight: 400;
    font-size: 24px;
}COPIAR CÓDIGO
```

**Guilherme:** O `sans-serif` é uma propriedade, portanto não precisamos adicioná-lo entre aspas simples. Vamos retirá-las.

```
.apresentacao__links__subtitulo{
    font-family:'Krona One', sans-serif;
    font-weight: 400;
    font-size: 24px;
}COPIAR CÓDIGO
```

**Rafaella:** Salvaremos o código e retornaremos à página aberta pelo navegador. Nela, temos o subtítulo com a fonte, tamanho e peso desejados. Em seguida, estilizaremos os botões em si, trocando o fundo ciano por bordas nessa cor.

Retornaremos ao arquivo `style.css` pelo VS Code e buscaremos a classe `.apresentacao__links__link{}`. Entre suas chaves, alteraremos os seguintes elementos:

- removeremos o fundo ciano, deletando o comando `background-color: #22D4FD`;
- mudaremos a cor dos textos, modificando o valor de `color` de `#000000` (preto) para `#F6F6F6` (branco);
- adicionaremos a borda `2px solid` (borda sólida com 2px de espessura), na cor `#22D4FD` (ciano);

Os valores de cor do texto e de borda encontraremos no Figma. Com a seleção ativa nestes elementos, veremos na aba "Inspect" os campos `color: #F6F6F6` e `border: 2px solid #22D4FD`, respectivamente. Basta copiar os valores destes campos.

> Dica: Se você gostou da configuração anterior, é possível comentar estes trechos de código em vez de excluí-los. Os trechos de código que comentamos não são lidos pelo sistema. No Visual Studio Code, o atalho para comentar uma linha de código é "Ctrl + K + C". Após ativá-lo, o VS Code adicionará os comando /* e */ no início e no final da linha, respectivamente.
> 
> 
> Vamos comentar um trecho do código como exemplo: `/* background-color: #22D4FD; */`.
> 

```
.apresentacao__links__link{
    /* background-color: #22D4FD; */
    border: 2px solid #22D4FD;
    width: 280px;
    text-align: center;
    border-radius: 16px;
    font-size: 24px;
    font-weight: 600;
    padding: 21.5px 0;
    text-decoration: none;
    color: #F6F6F6;
    font-family: 'Montserrat', sans-serif;
}COPIAR CÓDIGO
```

Salvaremos o código e retornaremos à página aberta pelo navegador. Nela, temos os dois botões na cor preta, com bordas ciano e seus respectivos textos na cor branca. Ficou do jeito que queríamos.

**Guilherme:** Vamos entender o código: na propriedade `border`, o primeiro valor informa a espessura da borda.

**Rafaella:** O segundo valor informa o tipo de tracejado. Neste caso é sólido. Se acessarmos a [página do W3Schools sobre bordas do CSS](https://www.w3schools.com/css/css_border.asp), veremos na seção "*CSS Border Style*" (ou "estilo de borda CSS") vários opções de estilização de borda disponíveis.

**Guilherme:** O próprio CSS possui configurações nativas. Existem muitas propriedades pré-definidas, e cabe a nós explorarmos e aprendermos sobre elas.

**Rafaella:** Imagine receber um Figma com bordas pontilhadas, por exemplo. Se não houvesse a propriedade `border`, seria muito difícil configurar algo assim.

Voltaremos ao VS Code para entender o último valor de `border`: a cor. Como vimos anteriormente, se trata de um valor hexadecimal que traz a cor escolhida.

Acessaremos o Figma e veremos que a largura do botão também mudou, está maior. Clicaremos neste elemento e buscaremos na aba `Inspect` o valor de sua `width`: ***378px***. Copiaremos este valor e voltaremos ao VS Code. Em `.apresentacao__links__link{}` substituiremos o valor da `width` de `280px` para `378px`.

A forma do botão também mudou. Antes, tínhamos cantos arredondados, e agora eles estão mais retos. Buscaremos e copiaremos no Figma o valor de `Radius` da borda: ***8px***. Ainda em `.apresentacao__links__link{}` substituiremos o valor da `border-radius` de `16px` para `8px`.

```
.apresentacao__links__link{
    /* background-color: #22D4FD; */
    border: 2px solid #22D4FD;
    width: 378px;
    text-align: center;
    border-radius: 8px;
    font-size: 24px;
    font-weight: 600;
    padding: 21.5px 0;
    text-decoration: none;
    color: #F6F6F6;
    font-family: 'Montserrat', sans-serif;
}COPIAR CÓDIGO
```

Salvaremos o código e veremos as alterações no navegador, onde temos os dois botões mais largos e com bordas menos redondas.

**Guilherme:** Os ícones dos botões estão fazendo falta. A seguir, vamos adicioná-los.