# Aula 02 - NgFor

Vamos ver como ficou o resultado do desafio do botão "Cancelar"?

No navegador, quando clicamos em "Cancelar", além do alert, agora somos redirecionados à página do mural de pensamentos.

No *VS Code*, acessamos o arquivo `criar-pensamento.component.html`,inserimos o `routerLink` e a rota para `listarPensamento`.

```
            <div class="acoes">
                <button (click)="criarPensamento()" class="botao">Salvar</button>
                <button (click)="cancelar()" routerLink="/listarPensamento" class="botao">Cancelar</button>
            </div>COPIAR CÓDIGO
```

Continuaremos a desenvolver a tela de listagem de pensamentos. Vamos [consultar o Figma do projeto novamente neste link](https://www.figma.com/file/YTSUBbe7Zgwx3L567TAzTc/Memoteca---Angular%3A-Come%C3%A7ando-com-o-Framework?node-id=148%3A26).

Nós temos o título e o botão com o comportamento configurado. Precisamos criar uma estrutura que comporte todos os cartões de pensamento salvos.

Se prestarmos atenção, os cartões são constituídos de uma imagem das aspas (com cores que variam de acordo com o modelo selecionado), o conteúdo, a autoria e dois ícones: um para editar e outro para excluir. O cartão segue o mesmo modelo em todos os pensamentos, portanto vamos transformá-lo em um componente e utilizá-lo dentro do componente de listagem.

Voltando ao terminal do *VS Code*, pararemos a aplicação com "Ctrl + C" e criaremos o componente `pensamento`.

```
ng g c componentes/pensamentos/pensamentoCOPIAR CÓDIGO
```

No explorador à esquerda, acessaremos o arquivo CSS deste componente e colaremos um código pronto. [Acesse o código de `pensamento.component.css` neste link](https://github.com/alura-cursos/2438-angular-memoteca/blob/aula-4/src/app/componentes/pensamentos/pensamento/pensamento.component.css), copie e cole na sua própria versão.

Depois, acessaremos o arquivo `pensamento.component.ts` e criaremos um atributo chamado `pensamento`, que será um objeto com um `conteudo` para teste.

```
    pensamento = {
        conteudo: 'I love Angular',
        autoria: 'Nay',
        modelo: 'modelo3'
    }COPIAR CÓDIGO
```

Em seguida codamos o HTML. No arquivo `pensamento.component.html` apagamos o parágrafo gerado automaticamente, criamos uma `div` com quatro classes: `pensamento`, `pensamento.modelo`, `ff-roboto-mono` e `pensamento-p`.

Vamos inserir o `pensamento.modelo` entre chaves duplas `{{}}` para acionar a interpolação que renderizará dentro do arquivo HTML o modelo que criamos no arquivo TS . Aqui será também renderizado o estilo que colamos no arquivo CSS, como por exemplo as bordas sombreadas.

```
<div class="pensamento {{ pensamento.modelo }} ff-roboto-mono pensamento-p">
</div>COPIAR CÓDIGO
```

Inserimos também imagens das aspas coloridas apontando o endereço junto com a interpolação, para renderizarmos o sombreamento e a cor das aspas em função do modelo escolhido.

```
<div class="pensamento {{ pensamento.modelo }} ff-roboto-mono pensamento-p">
    <img src="/assets/imagens/{{ pensamento.modelo }}.png" alt="Aspas coloridas">
</div>COPIAR CÓDIGO
```

Embaixo da imagem inserimos dois parágrafos com interpolações em `conteudo` e `autoria`. O parágrafo de autoria deverá aparecer em negrito, por isso incluiremos a *tag* `b`.

Em seguida, vamos inserir uma `div` para os botões de editar e de excluir. Os botões possuem uma classe de acordo com a sua função e uma imagem do seu respectivo ícone.

> Lembre-se das dicas para acelerar a escrita:
> 
> - para copiar um trecho de código, selecione-o e digite "Shift + Alt + seta para baixo".
> - para alterar a mesma palavra em vários trechos de código, selecione a primeira ocorrência com um clique duplo e digite "Ctrl + D" até selecionar todas. Em seguida faça a alteração.

```
//Trecho de cógido omitido
    <p class="conteudo">{{ pensamento.conteudo }}</p>
    <p class="autoria"><b>{{ pensamento.autoria }}</b></p>
    <div class="acoes">
        <button class="botao-editar">
            <img src="/assets/imagens/icone-editar.png" alt="Ícone de editar">
        </button>
        <button class="botao-excluir">
            <img src="/assets/imagens/icone-excluir.png" alt="Ícone de excluir">
        </button>
    </div>
//Trecho de código omitidoCOPIAR CÓDIGO
```

Acessaremos o arquivo `pensamento.component.ts` e copiaremos o `selector`.

```
    selector: 'app-pensamento',COPIAR CÓDIGO
```

Em seguida acessaremos o arquivo de listagem: `listar-pensamento.html`. Abaixo do `header`, criaremos uma `div` e dentro dela colaremos o seletor. A nova `div` possuirá a classe `"mural"`.

```
<div class="mural">
    <app-pensamento></app-pensamento>
</div>COPIAR CÓDIGO
```

Executaremos a aplicação no terminal com `ng serve` para ver o resultado. Ao atualizar o navegador com "F5" é possível visualizar o mural teste que salvamos anteriormente.

Contudo, nós não queremos mostrar somente um pensamento no mural, e sim a lista completa.

Quando queremos mostrar vários elementos com a mesma estrutura básica ou iterar uma lista, utilizamos uma estrutura de repetição que você já deve ter aprendido e que ensinamos nos [cursos de *Lógica de Programação* da *Alura*](https://www.alura.com.br/cursos-online-programacao/logica#como-comecar), o comando `for`.

No *Angular*, este *loop* (repetição, em português) é utilizado de um jeito um pouco diferente. Para renderizar uma lista de elementos, utilizamos a diretiva `ngFor`, que nada mais é do que um `for` específico do *Angular*. As letras "ng" vêm de "Angular".

Antes de utilizá-la, acessaremos o arquivo `listar-pensamento.component.ts`, dentro da seção `export` criaremos o atributo `listaPensamentos` e inicializá-lo com um arranjo vazio.

```
    listaPensamentos = [];COPIAR CÓDIGO
```

Acessaremos `listar-pensamento.html` e isolaremos o seletor `app-pensamento` em mais uma camada de `div` que vamos criar.

```
    <div class="mural">
        <div>
            <app-pensamento></app-pensamento>
        </div>
    </div>COPIAR CÓDIGO
```

Nesta nova `div` interna, utilizaremos o `ngFor`. Esta diretiva é do tipo estrutural, pois consegue modificar os elementos no HTML. A sua sintaxe é `*ngFor=""`.

Essa diretiva receberá a expressão `"let pensamento of listaPensamentos"`, onde `let` criará uma variável local e `listaPensamentos` o atributo que criamos na classe.

```
    <div class="mural">
        <div *ngFor="let pensamento of listaPensamentos">
            <app-pensamento></app-pensamento>
        </div>
    </div>COPIAR CÓDIGO
```

Neste código estamos informando que queremos iterar a lista de pensamentos, e que cada elemento da lista será um pensamento diferente.

Após rodar esse comando, voltamos ao navegador e percebemos que o nosso pensamento sumiu. A seguir, vamos entender o que aconteceu e como resolver.