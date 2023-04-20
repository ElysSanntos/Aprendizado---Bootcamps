# Aula 04 - Posicionando os links

**Guilherme:** Já conhecemos o projeto novo. Por onde devemos começar: cabeçalho, rodapé, botões?

**Rafaella:** Isso é uma escolha de cada pessoa desenvolvedora. No nosso caso podemos começar pelos botões, pois existe uma diferença bem clara entre a etapa anterior e a atual.

**Guilherme:** A primeira mudança que podemos ver é a presença de um novo subtítulo antes dos links, escrito "Acesse minhas redes:". Vamos adicioná-lo.

**Rafaella:** Voltando ao VS Code, acessaremos o arquivo `index.html`. Em seu interior encontraremos a `<div>` que agrega os dois botões que criamos: "Instagram" e "Github". Criamos ela para utilizar o Flexbox e realizar o posicionamento dos dois.

```
//código omitido

    <main class="apresentacao">
        <section class="apresentacao__conteudo">

//código omitido

            <div class="apresentacao__links">
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

Adicionaremos o novo subtítulo dentro dessa `<div>`, pois ela fará parte da divisão. Acima da linha com o botão do Instagram, adicionaremos um `<h2>`. Por que usamos o `<h2>` e não o `<h1>`?

**Guilherme:** Porque o `<h1>` é o título principal da página.

**Rafaella:** Isso mesmo. O correto é ***utilizar somente um `<h1>` por página***, para não atrapalharmos a pesquisa dela no Google. Assim, a página será retornada na pesquisa exibindo somente um título.

Entre as *tags* de fechamento e abertura do `<h2>` adicionaremos o texto "Acesse minhas redes:".

```
//código omitido

    <main class="apresentacao">
        <section class="apresentacao__conteudo">

//código omitido

            <div class="apresentacao__links">
                <h2>Acesse minhas redes:</h2>
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

**Guilherme:** Acessaremos a nossa página por meio do navegador e veremos que o texto aparece em uma disposição totalmente errada: à esquerda dos botões, e não acima.

Precisamos alterar a forma como dispomos esses elementos.

**Rafaella:** Exatamente. Eles estão na horizontal porque criamos, dentro de `style.css`, um `.apresentacao__links{}` cujo interior possui um `justify-content: space-between`. Sabemos que quando se cria um `display: flex`, automaticamente a direção dele será de *Row* (ou linha). Precisamos alterar a sua direção para *Column* (ou coluna).

Para isso, acessaremos novamente o arquivo `style.css`. No interior das chaves de `.apresentacao__links{}`, abaixo de `display: flex` adicionaremos um `flex-direction: column`.

```
.apresentacao__links{
    display: flex;
    flex-direction: column;
    justify-content: space-between;
}COPIAR CÓDIGO
```

**Guilherme:** Isso mesmo. Queremos que eles fiquem dispostos em coluna, ou seja, na vertical.

**Rafaella:** Se retornarmos à nossa página aberta no navegador já veremos a alteração. Agora o texto "Acesse minhas redes:" aparece acima dos botões.

**Guilherme:** Os três elementos (texto e botões) estão grudados. A impressão é de que, além de estarem muito próximos um do outro, estão encostados na borda esquerda do espaço dedicado a eles.

**Rafaella:** Exatamente. Para centralizar nossos elementos no eixo vertical, podemos utilizar uma outra propriedade do Flexbox, a qual já utilizamos anteriormente: o `align-itens`.

> Importante: Anteriormente havíamos utilizado o align-items para centralizar os elementos na vertical, pois o flex-direction estava em Row. Agora que alteramos a direção do Flexbox para Column, os elementos serão alinhados na vertical. Sempre que realizarmos uma alteração no flex-direction, ela se aplicará a todas as propriedades relacionadas.
> 

Por este motivo, utilizaremos a mesma propriedade, mas obteremos um resultado diferente do anterior. Acessaremos novamente o interior das chaves de `.apresentacao__links{}`, e abaixo de `justify-content` adicionaremos um `align-items: center`.

```
.apresentacao__links{
    display: flex;
    flex-direction: column;
    justify-content: space-between;
    align-items: center;
}COPIAR CÓDIGO
```

**Guilherme:** Se abrirmos o Figma, temos um espaço entre cada elemento. Podemos adicioná-lo com o `gap`.

**Rafaella:** Se clicarmos no subtítulo e arrastarmos o mouse para o primeiro botão, o Figma nos mostrará a distância exata entre cada elemento: 32px.

**Guilherme:** Podemos dizer que queremos um espaço de 32px entre cada uma das redes.

**Rafaella:** Exato. Já havíamos conhecido a propriedade `gap`, a qual deve ser inserida em nossa *tag* contêiner. Para configurar esse espaçamento vamos adicionar um `gap: 32px` abaixo de `align-items: center`.

```
.apresentacao__links{
    display: flex;
    flex-direction: column;
    justify-content: space-between;
    align-items: center;
    gap: 32px;
}COPIAR CÓDIGO
```

Salvaremos nosso código e retornaremos à página aberta no navegador. Nela, tanto o texto "Acesse minhas redes:" quanto os botões aparecem centralizados verticalmente, com um espaçamento entre cada um deles.

**Guilherme:** Nossa página está cada vez mais parecida com o projeto principal. Se abrirmos o Figma, veremos que os botões possuem a mesma cor do fundo da página, possuem uma imagem ao lado do texto e parece que o tamanho do botão também é diferente.

**Rafaella:** Exatamente.

**Guilherme:** A seguir, vamos implementar essas mudanças.