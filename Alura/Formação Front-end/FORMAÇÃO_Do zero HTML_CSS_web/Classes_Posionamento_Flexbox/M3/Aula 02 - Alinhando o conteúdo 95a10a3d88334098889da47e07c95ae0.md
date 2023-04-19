# Aula 02 - Alinhando o conteúdo

**Guilherme:** Entendemos a questão do posicionamento do `flex`. Porém, se abrirmos o [Figma do nosso projeto](https://www.figma.com/file/4EKKCbr5rS93RWP7kRjXIz/Portfolio---Curso-1?node-id=0%3A1) veremos que o título, o texto e os botões de Instagram e de Github parecem um só bloco, enquanto a imagem parece outro bloco acoplado.

![https://cdn1.gnarususercontent.com.br/1/1319057/88a0fe24-a012-4072-8f8a-19e930d1791e.png](https://cdn1.gnarususercontent.com.br/1/1319057/88a0fe24-a012-4072-8f8a-19e930d1791e.png)

**Rafaella:** Exato. E no nosso código...

**Guilherme:** É uma coisa só, tudo centralizado.

**Rafaella:** São várias coisas. Vimos que é possível agrupar elementos em um único elemento pai, um `container`. Faremos isso no nosso HTML. Podemos agrupar todos os elementos que você apontou, do título até os botões, e manter a imagem como um elemento de fora. Acessaremos o nosso código e adicionaremos a *tag* `<section>` para criar uma seção separada da imagem. Vamos abri-la acima do `h1` e fechá-la abaixo da última âncora do botão de Github.

Além disso, selecionaremos todos os elementos no interior da `<section>` e pressionaremos "Tab" para alinhá-los no código.

```
    <main class="apresentacao">
        <section>
            <h1>Eleve seu negócio digital a outro nível <strong class="titulo-destaque">com um Front-end de qualidade!</strong></h1>
            <p>Olá! Sou Joana Santos, desenvolvedora Front-end com especialidade em React, HTML e CSS. Ajudo pequenos negócios e designers a colocarem em prática boas ideias. Vamos conversar?
            </p>
            <a href="https://instagram.com/rafaballerini">Instagram</a>
            <a href="https://github.com/guilhermeonrails">Github</a>
        </section><img src="imagem.png" alt="Foto da Joana Santos programando">COPIAR CÓDIGO
```

Salvaremos esse código e **refletiremos sobre a seguinte questão:** estamos utilizando o Flexbox e, conforme visto anteriormente, o elemento pai informará que os elementos em seu interior devem ficar enfileirados — os quais havíamos configurado como Row. Contudo, agora temos somente dois elementos filhos. O que será que vai acontecer? Vamos acessar a aplicação por meio no navegador.

**Guilherme:** Agora temos uma mudança significativa.

**Rafaella:** Tínhamos antes cinco elementos por baixo da nossa *tag* pai, e portanto cinco elementos enfileirados no Flexbox. Agora temos apenas dois: um que possui vários elementos em seu interior e outro que possui apenas a imagem. Por isso em nossa aplicação conseguimos separar uma `section` e a imagem ao lado direito.

![https://cdn1.gnarususercontent.com.br/1/1319057/46560d74-b8f8-4b28-9f64-f40bf3cbf0d7.png](https://cdn1.gnarususercontent.com.br/1/1319057/46560d74-b8f8-4b28-9f64-f40bf3cbf0d7.png)

**Guilherme:** Legal. Contudo, mesmo separando as seções do texto e da imagem, ambos estão "grudados".

**Rafaella:** Sim. Enquanto no nosso Figma temos um espaço entre eles.

**Guilherme:** Isso.

**Rafaella:** Se acessarmos a [página com o guia do Flexbox](https://css-tricks.com/snippets/css/a-guide-to-flexbox/), veremos que ele possui formas padrão de posicionar os elementos filhos.

**Guilherme:** Opa, na página podemos ver um comando legal: o `space-between`.

**Rafaella:** Exatamente. Na página do Flexbox temos uma seção denominada "justificar-conteúdo" — que na verdade se trata da propriedade `justify-content`, em inglês. Dentro dela temos várias formas de posicionar elementos, e cada exemplo utiliza grupos de três — é importante lembrar que temos somente dois em nosso projeto.

Queremos criar um espaço entre esses dois elementos sem criar uma margem externa muito grande. Vamos apenas espaçar a seção da imagem, concorda?

**Guilherme:** Sim.

**Rafaella:** Para isso vamos utilizar o `space-between` localizado dentro da propriedade `justify-content`. Retornaremos ao nosso código e acessaremos o arquivo `style.css`, na qual buscaremos a seção `.apresentacao{}` a qual representa o nosso contêiner. Dentro de suas chaves , abaixo de `align-items` adicionaremos o `justify-content: space-between;`.

```
.apresentacao {
    display: flex;
    align-items: center;
    justify-content: space-between;
}COPIAR CÓDIGO
```

Salvaremos o código e retornaremos ao navegador. Nele veremos que cada elemento filho foi alinhado em um canto da tela e criou-se um espaço entre eles.

**Guilherme:** A nossa tela é 100%, ele está usando tudo.

**Rafaella:** Exato.

**Guilherme:** Os elementos estavam todos "grudados". Uma seção na outra.

**Rafaella:** Isso.

**Guilherme:** Enquanto houver espaço, o conteúdo será afastado. Se tivéssemos três elementos, o `space-between` dividiria esse espaço entre cada um deles.

**Rafaella:** Exatamente. Porém, os elementos estão colados nos cantos da tela: o texto à esquerda e a imagem à direita.

**Guilherme:** Não dá nem para ler direito.

**Rafaella:** Exato! A imagem também está colada ao topo da tela. Podemos criar uma margem para fora, aglomerando os conteúdos em direção ao centro.

**Guilherme:** Legal.

**Rafaella:** O que podemos fazer com isso, Gui?

**Guilherme:** Já conhecemos a propriedade `margin`. Se retornarmos ao nosso código, ainda no arquivo `style.css`, veremos uma seção na linha 1 que estabelece a margem 0 para todos os elementos.

```
*    {
        margin: 0;
        padding: 0;
}COPIAR CÓDIGO
```

Podemos informar que todos os elementos da propriedade `apresentacao` — ou seja, do `main` — possuirá a propriedade possuirá uma margem específica.

**Rafaella:** Exato. Adicionaremos uma margem para que nossos dois elementos sejam agrupados. Dentro das chaves da seção `.apresentação{}`, acima de `display`, adicionaremos o comando `margin:`. Qual valor de margem devemos colocar?

**Guilherme:** Após adicionarmos `:` o sistema abre uma lista com várias sugestões: `auto`, porcentagem, entre outras. Vamos testar a porcentagem: selecionaremos a opção `0%`, mudando o conteúdo para `10%`.

**Rafaella:** Vamos.

```
.apresentacao {
    margin:10%;
    display: flex;
    align-items: center;
    justify-content: space-between;
}COPIAR CÓDIGO
```

Em seguida salvaremos o código e retornaremos ao navegador. Ficou incrível com os 10 por cento!

![https://cdn1.gnarususercontent.com.br/1/1319057/d86dcf38-d32e-44cb-af4d-7ab2e4a4b57f.png](https://cdn1.gnarususercontent.com.br/1/1319057/d86dcf38-d32e-44cb-af4d-7ab2e4a4b57f.png)

**Guilherme:** Ficou interessante. Ele deu a margem para todo mundo.

Alinhando expectativa e realidade, a nossa aplicação está ficando mais próxima ao Figma.

**Rafaella:** Exatamente. Podemos brincar com esses valores, alterando para 8%, salvando e retornando ao navegador para ver o resultado. Neste exemplo, a margem entre os elementos diminuiu. Retornaremos o valor da margem para 10% pois ficou excelente, e vamos manter assim.