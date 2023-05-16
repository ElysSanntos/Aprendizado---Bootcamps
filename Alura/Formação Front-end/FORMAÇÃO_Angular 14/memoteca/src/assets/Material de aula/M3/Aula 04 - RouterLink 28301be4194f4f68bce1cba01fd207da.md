# Aula 04 - RouterLink

Está com curiosidade para saber como fazemos o redirecionamento de página através dos botões? É super simples!

Queremos que o `button` de "Adicionar pensamento" carregue o formulário, portanto vamos acessar o arquivo `app-routing.module.ts` e copiar o `path` do formulário.

```
        path: 'criarPensamento',
```

Em `listar-pensamento.component.html`, acessaremos o local no qual o botão "Adicionar pensamento" está localizado, e adicionaremos uma diretiva chamada `routerLink`. Essa diretiva é capaz de transformar um elemento em um link que possibilita a navegação para uma rota especificada.

```
<section class="container">
  <header class="header d-flex">
    <h2 class="ff-inter">Meu Mural</h2>
    <button routerLink="" class="botao">Adicionar pensamento</button>
  </header>
</section>COPIAR CÓDIGO
```

Agora colaremos o `path` do formulário no `routerLink` que criamos, e adicionaremos uma barra `/` à esquerda.

```
    <button routerLink="/criarPensamento" class="botao">Adicionar pensamento</button>COPIAR CÓDIGO
```

Prontinho! Voltando ao navegador, se a gente clicar no botão "Adicionar pensamento", seremos redirecionados à página do formulário de inclusão de pensamentos.

Mas, como faremos para voltar a página? Por enquanto só dá para voltar digitando o endereço manualmente.

Nós temos que configurar também o botão "Cancelar" para nos enviar de volta à página do mural. Esta tarefa será o seu desafio!

Você deve acessar o arquivo `criar-pensamento.component.html` e inserir no `button` "Cancelar" um `routerLink`, informando a rota para o componente `listarPensamento`.

As diretivas facilitam muito a nossa vida! Se prepare, pois veremos muitas outras diretivas maravilhosas do *Angular*!