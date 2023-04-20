# Aula 02 - Media Queries

**Guilherme:** Um ponto muito interessante agora, Rafa, é tentarmos identificar em que momento nossa aplicação começa a ter o comportamento que não estamos esperando, com elementos muito próximos uns dos outros.

**Rafaela:** Vou clicar com botão direito na nossa página do portifólio, abrir a aba do "Inspecionar" e clicar no nosso atalho para ajuste de tela.

> Lembrete: Também é possível usar o atalho "Ctrl + Shift + M"
> 

Agora vamos diminuir a tela aos poucos e observar o que acontece. O que você percebeu?

**Guilherme:** Eu senti que a imagem está colada ao texto, isso te incomodou?

**Rafaela:** Bastante, porque dá a sensação de que a tela vai diminuindo e vai meio que amassando todo o conteúdo. O que podemos fazer é adicionar um *gap* entre os elementos da `section` e a imagem.

**Guilherme:** Vamos voltar no nosso código HTML, Rafa, porque acho interessante mostrarmos isso.

A partir da linha 17 do arquivo `index.html`, temos o `main`, que é a classe `apresentacao`, com o conteúdo. Dentro dessa classe temos a `apresentacao__conteudo`, que tem todo o texto, e a `apresentacao__imagem`.

O que faremos é que, por mais que esteja diminuindo, sempre iremos garantir um espaço entre os dois.

**Rafaela:** E esse espaço será o ***gap***, que já conhecemos no *flex box*. Precisamos adicioná-lo à classe `apresentacao` para gerarmos esse espaço entre os filhos.

Então vamos no arquivo `style.css` e na linha 46, dentro da `.apresentacao{}`, vamos codar o `gap`. E o valor está no [projeto web do nosso Figma](https://www.figma.com/file/NrzJacC887svMVfF9oC2jM/Portfolio-Projeto-2?node-id=0%3A1), que tem a indicação do espaço que fica bom. No caso, o valor de 82px;

```
.apresentacao {
    padding: 5% 15%;
    display: flex;
    align-items: center;
    justify-content: space-between;
    gap: 82px;COPIAR CÓDIGO
```

Agora quando voltamos para nossa página e mudamos o tamanho da tela, reparamos que o espaço entre o texto e a imagem se mantém.

**Guilherme:** Diminui mais, Rafa. Vamos reparar em que momento nos sentimos incomodados. Quando chega por volta de 1300px de largura da tela, começa a ficar estranho.

A parte do texto na coluna está legal, mas a imagem fica isolada sozinha no lado direito. O que podemos fazer é falar que quando a largura da tela for menor que, vou propor um valor, 1023px ou algo assim, vamos deixar a imagem na mesma coluna.

**Rafaela:** Vamos! Porque assim já fica pronto conforme o [design mobile do Figma](https://www.figma.com/file/NrzJacC887svMVfF9oC2jM/Portfolio-Projeto-2?node-id=8%3A2), que leva a imagem para cima. E para isso podemos utilizar o ***media*** no CSS, então vamos abrir a documentação para descobrir como ele funciona.

**Guilherme:** Então de alguma forma existe uma propriedade do CSS, que são as ***Media Queries*** que garante que se a tela tiver um tamanho máximo ou mínimo terá a aplicação do estilo que determinarmos. É isso que faremos.

**Rafaela:** Portanto vamos abrir a [documentação do Developer Mozila](https://developer.mozilla.org/pt-BR/docs/Web/CSS/Media_Queries/Using_media_queries), que é o segundo link que aparece quando pesquisamos "css @media". Nela já temos a sintaxe de como usamos o *media queries*.

**Guilherme:** E é isso que queremos. Na documentação temos um exemplo de `max-width`, ou seja, o tamanho máximo:

```
<!-- CSS media query dentro de um stylesheet -->
@media (max-width: 600px)
{
  .facet_sidebar
   {
    display: none;
   }
}
COPIAR CÓDIGO
```

Se o tamanho máximo for 600px, que deve ter feito sentido para esse projeto, ele abriu chaves (`{`) e começou a adicionou a classe.

**Rafaela:** Exatamente, o `.facet_sidebar` seria como o nosso `.apresentacao`.

**Guilherme:** Depois ele começou a manipular elementos como sempre fazemos, e é isso que queremos. Por exemplo, informamos que se for até determinado valor, aplicaremos um tipo diferente de estilos, com a apresentação, tamanho da fonte e padding diferentes.

**Rafaela:** Podemos mudar até a cor, então podemos informar que se for para Mobile queremos outra cor de fundo.

**Guilherme:** Sim, nós somos livres! No caso, não queremos mudar a cor para mobile.

**Rafaela:** Não, ainda não!

**Guilherme:** Então vamos adicionar essa propriedade ao nosso código.

**Rafaela:** Certo, vou abrir o `styles.css` e codar na última linha, que é a 118, e declarar qual será nossa condição, ou seja, a largura máxima de tela para começarmos a utilizar os estilos que iremos definir:

```
@media (max-width: )COPIAR CÓDIGO
```

**Guilherme:** Só um detalhe, Rafa. Nós escrevemos como `@media` porque o CSS já tem isso naturalmente, e abrimos e fechamos parênteses (`()`), diferente de antes, que usávamos chaves.

**Rafaela:** É porque esses parênteses representam uma condição, nós verificamos se o que tem dentro deles é verdadeiro. Então se escrevermos um `max-width: 1000px`, se a tela tiver uma largura menor que isso, será aplicado o que está dentro das chaves.

Então os parênteses indicam que se tiver essa condição, aplica-se o que determinamos, senão, se a largura for maior, aplica-se os outros estilos que declaramos anteriormente.

**Guilherme:** Legal, e quanto colocamos?

**Rafaela:** Vamos descobrir diminuindo o tamanho da tela no navegador.

**Guilherme:** Por volta do 1020px começa a quebrar, certo?

**Rafaela:** Acho que antes, podemos deixar em 1200px, o que acha?

**Guilherme:** Pode ser.

**Rafaela:** Então se for até o tamanho de 1200px usaremos os estilos que definiremos entre chaves.

**Guilherme:** Vamos abrir e fechar chaves (`{}`) e tudo que colocarmos dentro delas, sejam as classe ou o `h1` só vai mudar quando essa função for verdadeira.

Portanto, Rafa, pensando no nosso Figma, conseguimos deixar a imagem em cima e depois alinhar os demais elementos?

**Rafaela:** Sim! Vamos conferir nossa classe `.apresentacao` no arquivo do CSS, onde estamos aplicando o flex box e estamos deixando os elementos alinhados. Temos o `display: flex` com o `flex-direction` automaticamente configurado para *row* (linha).

Então quando voltamos na página do nosso projeto do navegador os elementos estão dispostos em linha, mas queremos transformar em coluna, portanto no `@media` vamos configurar o `flex-direction: column;`.

```
@media (max-width: 1200ox) {
    .apresentacao {
        flex-direction: column;
    }
}COPIAR CÓDIGO
```

**Guilherme:** Ao fazemos isso e voltarmos para página, reparamos que já mudou, mas a imagem ficou embaixo, enquanto no Figma a imagem está em cima.

**Rafaela:** Precisamos lembrar que nosso código HTML tem a imagem depois do texto. Temos a `section` com o título, o parágrafo e os links e após eles que vem a imagem.

**Guilherme:** Nós precisaríamos inverter, Rafa?

**Rafaela:** Isso, e o flex box tem esse valor. Ele tem o `flex-direction` como *row* (linha) e *column* (coluna), mas também o *row-reverse* (linha reversa) e *column-reverse* (coluna reversa), trocando a ordem dos elementos.

```
@media (max-width: 1200ox) {
    .apresentacao {
        flex-direction: column-reverse;
    }
}COPIAR CÓDIGO
```

Quando salvarmos esse código e voltamos para página do navegador, reparamos que a ordem da imagem foi invertida e agora ela está em cima.

**Guilherme:** Não está exatamente igual ao Figma, precisamos manipular outros elementos, mas já ficou com uma aparência melhor.