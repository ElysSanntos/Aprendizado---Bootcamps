# Aula 06 - Posicionando com Flexbox

Você cria um projeto HTML com uma imagem e um parágrafo de texto, que estão dentro de uma `section`, como podemos observar no código a seguir:

```
<section>
    <img src="logo-alura.png" alt="Logo da Alura">
    <p>Estou aprendendo HTML e CSS na Alura!</p>
</section>COPIAR CÓDIGO
```

Logo, você cria um arquivo CSS para essa página, onde estiliza alguns detalhes de acordo com sua preferência e adiciona um `display: flex` para posicionar os elementos lado a lado, da seguinte forma:

```
section{
    border-style: solid;    /* Cria uma borda sólida */
    border-color:red;   /* Colore a borda com a cor vermelha */
    margin: 10%;    /* Adiciona uma margem ao redor da section */
    display: flex;  /* Adiciona o display flex */
}COPIAR CÓDIGO
```

Com o `display: flex`, os elementos que antes ficavam um embaixo do outro como nessa imagem:

![https://caelum-online-public.s3.amazonaws.com/2811-html-css-cabecalho-footer-variaveis-css/aula2-img2.png](https://caelum-online-public.s3.amazonaws.com/2811-html-css-cabecalho-footer-variaveis-css/aula2-img2.png)

Se posicionam lado a lado na tela, como está representado na imagem abaixo:

![https://caelum-online-public.s3.amazonaws.com/2811-html-css-cabecalho-footer-variaveis-css/aula2-img3.png](https://caelum-online-public.s3.amazonaws.com/2811-html-css-cabecalho-footer-variaveis-css/aula2-img3.png)

Observe que mesmo aplicando o `display: flex` em seu elemento pai (`section`), todos os elementos filhos (imagem e parágrafo) continuaram deslocados para o canto esquerdo da `section`.

O que podemos fazer para que a imagem e o parágrafo se desloquem para o centro dentro dessa `section` ?

*Selecione 3 alternativas*

Podemos adicionar a propriedade `justify-content: space-around` ao CSS da `section`.

A propriedade `justify-content` controla o posicionamento dos elementos filhos ao longo do eixo principal e também ajuda a distribuir o espaço livre entre eles. Com o valor `space-around`, os itens serão distribuídos cada um com um espaço ao seu redor.

- Podemos adicionar a propriedade `justify-content: center` ao CSS da `section`.
    
    A propriedade `justify-content` controla o posicionamento dos elementos filhos ao longo do eixo principal e também ajuda a distribuir o espaço livre entre eles. Com o valor `center`, os elementos serão centralizados em seu elemento pai, mas sem espaços entre si.
    
- Alternativa correta
    
    Podemos adicionar a propriedade `justify-content: space-evenly` ao CSS da `section`.
    
    A propriedade `justify-content` controla o posicionamento dos elementos filhos ao longo do eixo principal e também ajuda a distribuir o espaço livre entre eles. Com o valor `space-evenly`, os itens são distribuídos com espaços iguais entre si e até as bordas. Como temos apenas 2 elementos, eles ficarão centralizados.