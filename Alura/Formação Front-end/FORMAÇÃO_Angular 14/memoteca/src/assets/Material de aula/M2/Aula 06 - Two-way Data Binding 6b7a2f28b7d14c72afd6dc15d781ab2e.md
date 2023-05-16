# Aula 06 - Two-way Data Binding

Você conseguiu fazer o desafio do botão "Salvar"? Vamos ver como ficou o resultado?

No arquivo TypeScript, criamos o método `cancelar` e inserimos um `alert` com a mensagem "Ação cancelada!".

```
    cancelar() {
        alert("Ação cancelada!")COPIAR CÓDIGO
```

Já no arquivo HTML, criamos um `button` com o `click` adicionado, e em seguida associamos a esse botão o método `cancelar`.

```
             <button (click)="cancelar()" class="botao">Cancelar</button>COPIAR CÓDIGO
```

Agora quando clicamos em "Cancelar" na página, aparece uma aba com o `alert` "Ação cancelada!".

O nosso formulário está quase pronto, mas ainda temos um problema a resolver: se a gente digitar qualquer outro conteúdo nos campos "Pensamento" e "Autoria", a prévia não exibirá esse texto, e sim o texto que colocamos no código. Ou seja, o conteúdo da Prévia está fixo.

**Por que isso acontece?** Porque até agora estamos utilizando somente associações de dados unidirecionais.

**Como resolvemos isso?** Precisamos utilizar uma associação de dados bidirecional, que atualize o *template* e o `component` ao mesmo tempo.

Podemos associar o fluxo de dados do *Angular* a um tráfego de carros, onde o fluxo de dados unidirecional ("*one-way data binding*") representa uma via de mão única, enquanto o fluxo bidirecional ("*two-way data binding*") seria uma via de mão dupla.

A sintaxe do o fluxo de dados bidirecional é uma junção das duas que vimos antes: colchetes `[]` e parênteses `()`, formando assim a famosa "banana na caixa".

Para configurarmos o "*data binding*" bidirecional, utilizaremos uma ***diretiva*** no *input* de `pensamento` do arquivo HTML.

**O que são diretivas em *Angular*?** São classes que conseguem modificar elementos dentro da aplicação.

> Atenção: Antes de partirmos para a diretiva, verifique se você possui a extensão Auto Import para o VSCode. O link para download do Auto Import pode ser encontrado aqui.
> 

Vamos utilizar a diretiva de atributo `ngModel`, que faz parte do `FormsModule`. Para isso, acessaremos o arquivo `app.module.ts`. Na seção `imports`, digitaremos uma vírgula após o último item e importaremos o `FormsModule`. Após o comando, o *Auto Import* fará a importação automática.

```
    imports: [
        BrowserModule,
        AppRoutingModule,
        FormsModule
]
```

Depois,acessaremos o arquivo `criar-pensamento.component.html`. Nos *inputs* de `pensamento`, `autoria`, vamos substituir o atributo `[value]` pela diretiva `ngModel`, envolvendo-a em parênteses e colchetes por fora.

***Input* de Pensamento:**

```
            <input
                type="textarea"
                class="input"
                id="pensamento"
                name="pensamento"
                placeholder="Digite o pensamento"
                [(ngModel)]="pensamento.conteudo"
            >COPIAR CÓDIGO
```

***Input* de Autoria:**

```
            <input
                type="text"
                class="input"
                id="autoria"
                name="autoria"
                placeholder="Digite a autoria ou fonte"
                [(ngModel)]="pensamento.autoria"
            >COPIAR CÓDIGO
```

Acessaremos os três *inputs* dos modelos e também colaremos essa diretiva em cada um deles, abaixo do `name`.

***Input* dos modelos:**

```
            <input
            //Trecho de código omitido
                [(ngModel)]="pensamento.modelo"
            >COPIAR CÓDIGO
```

> A diretivangModel é muito utilizada em formulários justamente pela sua capacidade de realizar uma vinculação bidirecional.
> 

**Vamos testar?** Acessaremos `criar-pensamento.component.ts` e na seção `pensamento` vamos inserir um conteúdo no atributo `modelo`, que antes estava vazio.

```
    pensamento = {
        id: '1',
        conteudo: 'Aprendendo Angular',
        autoria: 'Dev',
        modelo: 'modelo1'
  }COPIAR CÓDIGO
```

A seguir, testaremos a página pelo navegador. Podemos ver que quando digitamos dentro dos campos, as três prévias atualizam e sincronizam o conteúdo.

Já que agora entendemos tudo sobre o fluxo de dados, em seguida entenderemos como navegar entre componentes utilizando rotas.