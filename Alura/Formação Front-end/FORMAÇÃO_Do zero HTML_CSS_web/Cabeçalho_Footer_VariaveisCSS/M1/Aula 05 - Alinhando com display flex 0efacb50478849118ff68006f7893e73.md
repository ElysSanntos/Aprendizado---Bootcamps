# Aula 05 - Alinhando com display flex

Aprendemos que podemos utilizar o `display: flex` para posicionar elementos na tela, observando seu comportamento padrão. Dito isso, observe o código HTML a seguir, no qual o elemento pai `container` contém quatro divs e cada uma será um quadrado na tela:

```
    <body>
        <div class="container">
            <div class="quadrado"></div>
            <div class="quadrado"></div>
            <div class="quadrado"></div>
            <div class="quadrado"></div>
        </div>
    </body>
```

Já no CSS, o elemento pai foi estilizado da seguinte maneira:

```
.container {
margin: 20%;    /* adiciona uma margem para centralizar os quadrados na tela*/
display: flex;    /* coloca os quadrados lado a lado */
gap: 10px;    /* adiciona espaços iguais entre cada quadrado */
}
```

Esses códigos exibem o seguinte resultado na tela:

![https://caelum-online-public.s3.amazonaws.com/2811-html-css-cabecalho-footer-variaveis-css/aula1-img1.png](https://caelum-online-public.s3.amazonaws.com/2811-html-css-cabecalho-footer-variaveis-css/aula1-img1.png)

Imagine que você deseja alinhar esses quadrados verticalmente, um embaixo do outro, porém mesmo adicionando o `display: flex` ainda não obteve esse resultado.

Qual das alternativas a seguir representa a solução para que consiga organizar esses elementos como deseja?

*Selecione uma alternativa*

Podemos adicionar a propriedade `flex-direction: column` ao CSS da classe `.container`.

Ao adicionarmos a propriedade `flex-direction: column` os quadrados irão se posicionar verticalmente, já que define que a direção do `display: flex` deve ser em “coluna”.

- A propriedade `flex-direction` define a direção em que os itens do `display: flex` devem ser dispostos
- A propriedade `align-items` se refere ao posicionamento dos quadrados em relação ao `.container`
- a propriedade `align-items: flex-start` iria posicionar os quadrados no início do elemento pai, na sua parte de cima, já que por padrão atua verticalmente, mas os quadrados ainda estariam na horizontal, lado a lado.
- A propriedade `justify-content` está relacionada a como o espaço será distribuído entre cada quadrado dentro do `.container` e não à direção do alinhamento deles.