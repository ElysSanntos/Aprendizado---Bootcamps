# Aula 03 - Caixa flexível_cabeçalho

Neste início de curso, precisamos que você preste bastante atenção a esse desenho:

![https://cdn1.gnarususercontent.com.br/1/141059/9ca63f7f-4a7b-4a05-9f09-2e09d41ec3c7.png](https://cdn1.gnarususercontent.com.br/1/141059/9ca63f7f-4a7b-4a05-9f09-2e09d41ec3c7.png)

Nele, temos uma estante com diversas prateleiras, onde estão dispostos livros na mesma distância um do outro. Agora vamos supor que compramos uma estante maior, com mais espaço para reorganizar esses livros.

![https://cdn1.gnarususercontent.com.br/1/141059/1f0e0906-4abb-454e-a2f2-0b63b42982db.png](https://cdn1.gnarususercontent.com.br/1/141059/1f0e0906-4abb-454e-a2f2-0b63b42982db.png)

Com o Flexbox, podemos organizar tais livros de diversas maneiras. Por exemplo, aplicando uma distância igual entre eles, de modo a aproveitar todo o espaço disponível.

![https://cdn1.gnarususercontent.com.br/1/141059/de2e814d-4d54-48c4-b6fd-d5bd8c166157.png](https://cdn1.gnarususercontent.com.br/1/141059/de2e814d-4d54-48c4-b6fd-d5bd8c166157.png)

Também poderíamos organizá-los de maneira diferente em cada uma das prateleiras, colocar a estante na horizontal e deixar os livros flutuando, ou mesmo inverter a forma em que estão distribuídos.

São essas possibilidades do Flexbox que aprenderemos na prática, organizando os elementos do [projeto AluraPlay, que está disponível para download na atividade **"Preparando o ambiente"**](https://cursos.alura.com.br/course/css-flexbox-layouts-responsivos/task/112613).

Vamos abrir o editor de código VSCode e clicar em "File > Open folder", acessando o diretório onde baixamos o projeto.

Após abrirmos, começaremos a analisar o primeiro problema que nos ajudará a aprender o Flexbox na prática.

![https://cdn1.gnarususercontent.com.br/1/141059/5793453f-d5ac-4d97-86b6-65932832cd38.png](https://cdn1.gnarususercontent.com.br/1/141059/5793453f-d5ac-4d97-86b6-65932832cd38.png)

De início, podemos organizar os elementos do cabeçalho do projeto. Por exemplo, temos a logo da AluraPlay, que aparentemente está do lado esquerdo, mas na verdade ocupa de um lado a outro de seu contêiner.

Logo abaixo temos um campo de pesquisa, seguido por quatro ícones que quase não são visíveis, já que estão cobertos pelas opções do menu.

A ideia é aplicarmos o Flexbox a esses elementos de modo a organizá-los. Para isso, vamos localizá-los em nosso código HTML.

No arquivo `index.html`, dentro da tag `<header>`, encontraremos uma tag `<nav >` contendo os itens que citamos anteriormente.

```
<body>

    <!-- Cabecalho -->
    <header>

        <nav class="cabecalho__container">

            <h1 class="logo__item" href="#"></h1>

            <div class="cabecalho__pesquisar__item">
                <form action="">
                    <input type="search" placeholder="Pesquisar" id="pesquisar" class="pesquisar__input">
                    <label for="pesquisar" class="pesquisar__label"></label>
                </form>
                <a href="#" class="cabecalho__audio"></a>
            </div>

            <div class="cabecalho__icones__item">
                <a href="#" class="cabecalho__videos"></a>
                <a href="#" class="cabecalho__apps"></a>
                <a href="#" class="cabecalho__notificacoes"></a>
                <a href="#" class="cabecalho__avatar"></a>
            </div>

        </nav>

    </header>
//código omitido...COPIAR CÓDIGO
```

Temos uma tag `<h1>` contendo a logo como background (esta localizada na pasta "estilos-css"). Além dela, temos uma `<div>` para o campo de pesquisa, contendo o `<input>` e a `<label>`. Por fim, temos outra `<div>`, esta contendo os quatro ícones que desejamos organizar.

Mas como aplicar o Flexbox a esses elementos? Primeiramente, é necessário localizar o "pai direto" desses três grupos de itens, que é a tag `<nav>`.

No arquivo `flexbox.css`, chamaremos a classe dessa tag - `cabecalho__container`:

```
.cabecalho__container {

}COPIAR CÓDIGO
```

Nela, adicionaremos a propriedade `display: flex`.

```
.cabecalho__container {
    display: flex;
}COPIAR CÓDIGO
```

Ao atualizar a página, todos os elementos ficarão lado a lado, o que é o comportamento padrão do Flexbox quando aplicado a um container. Mesmo que existissem um milhão de elementos, todos eles seguiriam esse padrão, mesmo que o layout fosse quebrado.

![https://cdn1.gnarususercontent.com.br/1/141059/585c3ee9-e8bc-467c-8604-7ff6e2c67eb9.png](https://cdn1.gnarususercontent.com.br/1/141059/585c3ee9-e8bc-467c-8604-7ff6e2c67eb9.png)

Os elementos já estão na ordem correta (na horizontal), mas não estão espaçados da maneira que desejamos. Aprenderemos a ajustar isso no próximo vídeo.