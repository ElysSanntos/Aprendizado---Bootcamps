# Aula 02 - Navegação dinâmica

Agora que a primeira tela foi finalizada, daremos início à segunda tela da nossa aplicação que conterá um mural com todos os pensamentos salvos.

Haverá também um botão no topo para adicionar mais pensamentos. Ao clicarmos nesse botão, devemos ser redirecionados para o formulário de cadastro de pensamento.

Primeiro pararemos a aplicação no terminal do *VS Code* com "Ctrl + C" e criaremos um novo componente que representará a listagem de pensamentos:

```
ng g c componentes/pensamentos/listar-pensamentoCOPIAR CÓDIGO
```

Depois acessaremos o arquivo CSS recém-criado através do caminho "src > app > componentes > pensamentos > listar-pensamento > `listar-pensamento.css`" e colaremos um código pronto. Você deve [acessar o código do `listar-pensamento.css` neste link](https://github.com/alura-cursos/2438-angular-memoteca/blob/aula-3/src/app/componentes/pensamentos/listar-pensamento/listar-pensamento.component.css), copiá-lo e colá-lo em seu projeto.

Fecharemos o CSS e abriremos o arquivo `listar-pensamento.component.html`. Apagaremos o parágrafo gerado automaticamente e criaremos uma `section` com a classe `container`. Dentro de `container` criaremos um `header` com as classes `header` e `d-flex`, onde `d` de refere a "*directive*".

Em seguida, dentro do `header` criaremos um `h2` com a classe `ff-inter` e adicionaremos a ele o título "Meu Mural". Por fim, adicionaremos abaixo de `h2` um `button` com a classe `botao` e daremos a ele o título "Adicionar pensamento".

```
<section class="container">
    <header class="header d-flex">
        <h2 class="ff-inter">Meu Mural</h2>
        <button class="botao">Adicionar pensamento</button>
    </header>
</section>
```

Como já sabemos, para que este componente apareça na página, precisamos copiar o conteúdo do `selector` do arquivo TS e inseri-lo no arquivo `app.component.html`. Nesta etapa, o conteúdo do seletor é `app-listar-pensamento`.

```
<app-cabecalho></app-cabecalho>
<main>
    <app-criar-pensamento></app-criar-pensamento>
    <app-listar-pensamento></app-listar-pensamento>
</main>
<app-rodape></app-rodape>COPIAR CÓDIGO
```

Agora, reiniciaremos a aplicação no terminal com `ng serve`. Se rodarmos a página dessa maneira, o título "Meu Mural" e o botão "Adicionar pensamento" aparecerão na mesma página do formulário. Não é isso que queremos.

Para resolver esse problema, ***utilizaremos o sistema de rotas*** do *Angular*!

Imagine que as rotas do *Angular* são ondas de rádio. Se queremos ouvir uma estação de rádio específica, precisamos sintonizar na frequência dela. Ou seja, precisamos passar o caminho específico ao rádio para ter o acesso ao conteúdo daquela estação.

Primeiro acessaremos o arquivo `app.component.html` e apagaremos as *tags* dos seletores `app-criar-pensamento` e `app-listar-pensamento`, já que não queremos carregar os dois ao mesmo tempo.

No lugar dos seletores, inseriremos o elemento `router-outlet`, uma diretiva que atuará como um espaço reservado que será preenchido pelo próprio *Angular* dinamicamente.

Se a gente acessar o navegador neste momento, não aparecerá mais nenhum conteúdo na página. **Por quê?**

O motivo é simples: não configuramos ainda o arquivo de rotas da aplicação. É como se ligássemos o rádio e não sintonizássemos em nenhuma estação. Portanto, o aparelho não sabe que música deve tocar.

Com o `router-outlet`, informamos ao *Angular* que queremos que os componentes sejam carregados dinamicamente. Mas não informamos quais componentes ele deve carregar e em quais momentos eles devem ser carregados.

Em seguida, resolveremos essa questão.