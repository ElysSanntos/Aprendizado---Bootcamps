# Aula 02 - Conteúdo da página Sobre Mim

**Rafaella:** Já temos nosso cabeçalho e nosso rodapé. Falta adicionarmos o conteúdo principal da página "Sobre mim". Podemos ver no Figma quais elementos existem dentro do nosso `main`:

- o título "Sobre mim";
- abaixo dele, dois parágrafos;
- à direita destes, a mesma imagem que usamos na página inicial.

Retornaremos ao VS Code e acessaremos o arquivo `about.html` para inserir estes elementos. Buscaremos o nosso `<main>` vazio e nele criaremos uma `<section>` para armazenar todos os elementos da página. Abaixo da `<section>` adicionaremos uma `<img>`.

Lembrando que já realizamos esse procedimento no nosso índice. A `<section>` será o elemento visualizado à esquerda da página, enquanto a `<img>` ficará à direita.

```
// Código omitido

        </nav>
    </header>

    <main>
        <section>

        </section>
        <img>
    </main>

    <footer class="rodape">
        <p>Desenvolvido por Alura.</p>
    </footer>
</body>
</html>COPIAR CÓDIGO
```

O que temos dentro dessa `<section>`?

**Guilherme:** Temos o `<h1>` com o texto "Sobre mim", e dois `<p>`s.

> Dica: Para adicionarmos os dois parágrafos de uma vez, iremos até a linha vazia abaixo do <h1> e digitaremos o atalho p*2, seguido do "Enter".
> 

```
// Código omitido

        </nav>
    </header>

    <main>
        <section>
            <h1>Sobre mim</h1>
            <p></p>
            <p></p>
        </section>
        <img>
    </main>

    <footer class="rodape">
        <p>Desenvolvido por Alura.</p>
    </footer>
</body>
</html>COPIAR CÓDIGO
```

**Rafaella:** Voltaremos ao Figma, onde copiaremos o "Lorem ipsum" dos dois parágrafos, um por vez. Voltaremos ao nosso código e colaremos esses conteúdos no interior das suas respectivas *tags*.

```
// Código omitido

        </nav>
    </header>

    <main>
        <section>
            <h1>Sobre mim</h1>
            <p>At vero eos et accusamus et iusto odio dignissimos ducimus qui blanditiis praesentium voluptatum deleniti atque corrupti quos dolores et quas molestias excepturi sint occaecati cupiditate non provident, similique sunt in culpa qui officia deserunt mollitia animi, id est laborum et dolorum fuga.</p>
            <p>Et harum quidem rerum facilis est et expedita distinctio. Nam libero tempore, cum soluta nobis est eligendi optio cumque nihil impedit quo minus id quod maxime placeat facere possimus, omnis voluptas assumenda est, omnis dolor repellendus. Temporibus autem quibusdam et aut officiis debitis aut rerum necessitatibus saepe eveniet ut et voluptates repudiandae sint et molestiae non recusandae. Itaque earum rerum hic tenetur a sapiente delectus, ut aut reiciendis voluptatibus maiores alias consequatur aut perferendis doloribus asperiores ipsum delis forum birol parela maxime infena. Excepteur sint occaecat cupidatat non.</p>
        </section>
        <img>
    </main>

    <footer class="rodape">
        <p>Desenvolvido por Alura.</p>
    </footer>
</body>
</html>COPIAR CÓDIGO
```

**Guilherme:** Agora precisamos da imagem. Ela possui as mesmas propriedades da imagem anterior. Podemos copiar o conteúdo do `index.html` e colá-lo no `about.html`. O código a ser copiado está disponível abaixo.

```
<img src=".assets/imagem.png" alt="Foto da Joana Santos programando">COPIAR CÓDIGO
```

O resultado será este:

```
// Código omitido

        </nav>
    </header>

    <main>
        <section>
            <h1>Sobre mim</h1>
            <p>At vero eos et accusamus et iusto odio dignissimos ducimus qui blanditiis praesentium voluptatum deleniti atque corrupti quos dolores et quas molestias excepturi sint occaecati cupiditate non provident, similique sunt in culpa qui officia deserunt mollitia animi, id est laborum et dolorum fuga.</p>
            <p>Et harum quidem rerum facilis est et expedita distinctio. Nam libero tempore, cum soluta nobis est eligendi optio cumque nihil impedit quo minus id quod maxime placeat facere possimus, omnis voluptas assumenda est, omnis dolor repellendus. Temporibus autem quibusdam et aut officiis debitis aut rerum necessitatibus saepe eveniet ut et voluptates repudiandae sint et molestiae non recusandae. Itaque earum rerum hic tenetur a sapiente delectus, ut aut reiciendis voluptatibus maiores alias consequatur aut perferendis doloribus asperiores ipsum delis forum birol parela maxime infena. Excepteur sint occaecat cupidatat non.</p>
        </section>
        <img src=".assets/imagem.png" alt="Foto da Joana Santos programando">
    </main>

    <footer class="rodape">
        <p>Desenvolvido por Alura.</p>
    </footer>
</body>
</html>COPIAR CÓDIGO
```

**Rafaella:** Salvaremos o nosso código.

**Guilherme:** Vamos ver como ficou no navegador. Abaixo do cabeçalho, temos os três textos e a imagem no canto esquerdo da página, dispostos na vertical. No topo temos o título "Sobre mim". Abaixo dele temos o primeiro parágrafo, e logo abaixo deste temos o segundo parágrafo. Por fim, abaixo dos textos, temos a imagem.

**Rafaella:** Por que as nossas configurações de CSS não estão funcionando no `main`?

**Guilherme:** ***Porque não atribuímos classes a elas***. Vamos adicionar as seguintes classes:

- no `<main>`, a `class="apresentacao"`;
- na `<section>`, a `class="apresentacao__conteudo"`;
- no `<h1>`, a `class="apresentacao__conteudo__titulo"`;
- nos dois `<p>`s, a `class="apresentacao__conteudo__texto"`.

> Dica 1: Podemos copiar os nomes das classes diretamente do index.html. Esse procedimento é muito comum no início da criação de páginas Web.
> 

> Dica 2: Para adicionar a mesma classe em dois locais de uma vez — como no caso dos nossos dois parágrafos —, basta clicar no primeiro local, segurar o botão "Alt" e clicar nos próximos locais em que deseja escrever. Desta forma, todos os locais selecionados serão editados simultaneamente.
> 

```
// Código omitido

        </nav>
    </header>

    <main class="apresentacao">
        <section class="apresentacao__conteudo>
            <h1 class="apresentacao__conteudo__titulo">Sobre mim</h1>
            <p>At vero eos et accusamus et iusto odio dignissimos ducimus qui blanditiis praesentium voluptatum deleniti atque corrupti quos dolores et quas molestias excepturi sint occaecati cupiditate non provident, similique sunt in culpa qui officia deserunt mollitia animi, id est laborum et dolorum fuga.</p>
            <p>Et harum quidem rerum facilis est et expedita distinctio. Nam libero tempore, cum soluta nobis est eligendi optio cumque nihil impedit quo minus id quod maxime placeat facere possimus, omnis voluptas assumenda est, omnis dolor repellendus. Temporibus autem quibusdam et aut officiis debitis aut rerum necessitatibus saepe eveniet ut et voluptates repudiandae sint et molestiae non recusandae. Itaque earum rerum hic tenetur a sapiente delectus, ut aut reiciendis voluptatibus maiores alias consequatur aut perferendis doloribus asperiores ipsum delis forum birol parela maxime infena. Excepteur sint occaecat cupidatat non.</p>
        </section>
        <img src=".assets/imagem.png" alt="Foto da Joana Santos programando">
    </main>

    <footer class="rodape">
        <p>Desenvolvido por Alura.</p>
    </footer>
</body>
</html>COPIAR CÓDIGO
```

**Rafaella:** Salvaremos nosso código e veremos o resultado no navegador. Abaixo do cabeçalho, agora temos o conteúdo centralizado na tela e dividido em dois blocos: o da esquerda possui o título, seguido abaixo pelos textos, enquanto o bloco da direita possui somente a imagem.

![https://cdn1.gnarususercontent.com.br/1/1319057/627c3c38-c71b-45ba-9dce-5e8f395cc2be.png](https://cdn1.gnarususercontent.com.br/1/1319057/627c3c38-c71b-45ba-9dce-5e8f395cc2be.png)