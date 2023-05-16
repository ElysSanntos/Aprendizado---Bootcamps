# Aula 05 - Event Binding

Já associamos o objeto `pensamento` ao *template*, agora vamos adicionar uma lógica para configurar a ação que deve ocorrer quando a pessoa usuária clicar em "Salvar" — este botão deverá salvar as informações escolhidas.

Vamos voltar ao desfile. Uma pessoa que vai desfilar pela primeira vez te pede que sinalize o momento em que ela deve voltar para os bastidores. Você está segurando a máquina fotográfica, então decide usar o "clique" da máquina como sinal. A pessoa ouve o som e volta para os bastidores.

É esse "clique" que vamos configurar agora. No *VS Code*, acessaremos `criar-pensamento.component.ts` e criaremos o método `criarPensamento`.

```
//trecho de código omitido
    criarPensamento() {
    }COPIAR CÓDIGO
```

Agora, acessaremos o arquivo `criar-pensamento.component.html`. No final do aquivo, encontraremos a `div` com os botões e dentro dela criaremos o "*Event Binding*", a associação de eventos do *Angular*.

Ao abrir parênteses `()` ao lado de `button`, será exibida uma lista de comandos que o *Angular* pode "ouvir" e aplicar na página.

Nós aplicaremos o comando `(click)` e depois acrescentaremos o método `"criarPensamento"`. Dessa forma, o método será ativado com o "clique" do botão.

```
            <div class="acoes">
                <button (click)="criarPensamento()" class="botao">Salvar</button>
                <button (click)="cancelar()" class="botao">Cancelar</button>
            </div>COPIAR CÓDIGO
```

Voltando ao arquivo `criar-pensamento.component.ts` testaremos se o comando funciona através da inserção de um `alert` em `criarPensamento`.

```
    criarPensamento() {
        alert("Novo pensamento criado!")
    }COPIAR CÓDIGO
```

**Vamos testar?** No navegador, quando clicamos em "Salvar", deverá ser exibida uma caixa de texto com a mensagem "Novo pensamento criado!". Este é o nosso `alert`.

Assim como o "clique" da máquina avisou a pessoa para voltar para o bastidores, o `click` do `button` disparou uma ação para ser executada no *component*, neste caso a ação `alert`.

Assim como o "*Property Binding*", o "*Event Binding*" é um tipo unidirecional de "*Data Binding*" (ou associação de dados). Mas enquanto o "*Property Binding*" envia dados do *component* para o *template*, o "*Event Binding*" faz o contrário, envia dados do *template* para o *component*.

O "*Property Binding*" usa colchetes `[]` enquanto o "*Event Binding*" usa parênteses `()`.

**Como vamos lembrar de inserir os parênteses?**

Voltando ao desfile: quanto uma pessoa não escuta muito bem, ela coloca as mãos ao redor das orelhas em formato de concha, para ouvir melhor. Este formato lembra muito os parênteses.

Assim lembraremos que o "*Event Binding*" usa parênteses para se associar ao método de uma classe e para "ouvir" um evento que ocorre no *template*.

Como desafio, você deve criar o "*Event Binding*" para associar o "clique" do botão "Cancelar" a um método de cancelamento que você criará na classe *TypeScript*. Você pode seguir uma lógica similar à do botão "Salvar".

Em seguida vamos ver como ficou o seu botão e o meu também. Tenho certeza que você concluirá o desafio sem dificuldade!