# Aula 04 - align-items_finalizando o cabeçalho

Nosso objetivo agora é deixar a logo do lado esquerdo, o campo de pesquisa no centro e os quatro ícones do lado direito.

![https://cdn1.gnarususercontent.com.br/1/141059/cfdc12d7-7416-440b-a4d1-74d1abf1465c.png](https://cdn1.gnarususercontent.com.br/1/141059/cfdc12d7-7416-440b-a4d1-74d1abf1465c.png)

Se não estivéssemos usando o Flexbox, poderíamos pegar a classe da nossa logo, `logo__item`, e aplicar um `margin-right` com, por exemplo, `200px`.

```
.logo__item {
    margin-right: 200px;
}COPIAR CÓDIGO
```

Dessa forma, nosso campo de pesquisa será movido para o centro.

![https://cdn1.gnarususercontent.com.br/1/141059/8770716c-136c-4f5f-8561-2423b5dc6517.png](https://cdn1.gnarususercontent.com.br/1/141059/8770716c-136c-4f5f-8561-2423b5dc6517.png)

Podemos, também, aplicar o `margin-right` à classe desse campo de pesquisa.

```
.cabecalho__pesquisar__item {
    margin-right: 200px;
}COPIAR CÓDIGO
```

Com isso, os ícones é que serão movidos para a direita, quebrando o layout.

![https://cdn1.gnarususercontent.com.br/1/141059/c778f701-9b02-439a-925c-56befaee8b17.png](https://cdn1.gnarususercontent.com.br/1/141059/c778f701-9b02-439a-925c-56befaee8b17.png)

Inclusive, se diminuirmos o valor da propriedade `margin-right`, o layout quebrará menos.

```
.cabecalho__pesquisar__item {
    margin-right: 150px;
}COPIAR CÓDIGO
```

Ou seja, essa não é uma prática responsiva, já que não estamos ajustando os elementos para diferentes tamanhos de tela.

Para que a logo fique sempre no canto esquerdo, o campo de pesquisa sempre no centro e os ícones sempre à direita, utilizaremos o Flexbox, que é a melhor solução para esse caso.

Removeremos os códigos anteriores de nosso arquivo `flexbox.css`, e adicionaremos à classe `cabecalho__container` a propriedade `justify-content` com o valor `space-between`.

```
.cabecalho__container {
    display: flex;
    justify-content: space-between;

}COPIAR CÓDIGO
```

Dessa forma, os elementos ficarão dispostos da maneira que desejamos, e passarão a ser responsivos, ajustando sua posição de acordo com o tamanho da tela.

![https://cdn1.gnarususercontent.com.br/1/141059/dad70648-d20e-4422-b4c9-b9e0ccbb28a1.png](https://cdn1.gnarususercontent.com.br/1/141059/dad70648-d20e-4422-b4c9-b9e0ccbb28a1.png)

Entretanto, eles ainda estão muito próximos do topo do layout. Já os ajustamos em relação à horizontal, e agora queremos fazer um ajuste vertical, centralizando-os no contêiner.

Faremos isso com a propriedade `align-items` recebendo o valor `center`.

```
.cabecalho__container {
    display: flex;
    justify-content: space-between;
    align-items: center;
}COPIAR CÓDIGO
```

Atualizando a página, veremos que estamos bem mais próximos do nosso objetivo.

![https://cdn1.gnarususercontent.com.br/1/141059/e5f81413-1783-4c47-b36c-d21d6f8aa459.png](https://cdn1.gnarususercontent.com.br/1/141059/e5f81413-1783-4c47-b36c-d21d6f8aa459.png)

Quando utilizamos a barra de rolagem, porém, o menu fica fixo na tela. Queremos replicar esse efeito no cabeçalho.

Para isso, usaremos a propriedade `position` com o valor `fixed`.

```
.cabecalho__container {
    display: flex;
    justify-content: space-between;
    align-items: center;
    position: fixed;
}COPIAR CÓDIGO
```

Já informamos que desejamos que o cabeçalho fique fixo, agora precisamos informar a coordenada onde ele será fixado, algo feito com a propriedade `top` e um valor de distância, nesse caso `0`.

```
.cabecalho__container {
    display: flex;
    justify-content: space-between;
    align-items: center;
    position: fixed;
    top: 0;
}COPIAR CÓDIGO
```

Assim, o cabeçalho se manterá fixo no topo.

![https://cdn1.gnarususercontent.com.br/1/141059/b67d0501-ceee-45ec-bffd-699856ea5659.png](https://cdn1.gnarususercontent.com.br/1/141059/b67d0501-ceee-45ec-bffd-699856ea5659.png)

Já aprendemos várias propriedades do Flexbox e do CSS, que trabalha em conjunto com ele. No próximo vídeo daremos continuidade aos nossos estudos.