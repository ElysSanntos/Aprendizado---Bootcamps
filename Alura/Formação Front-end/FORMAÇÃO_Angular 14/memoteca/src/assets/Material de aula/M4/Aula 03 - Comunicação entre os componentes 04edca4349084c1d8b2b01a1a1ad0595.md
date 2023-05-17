# Aula 03 - Comunicação entre os componentes

Neste momento, aprenderemos como ocorre a comunicação entre os componentes. Vamos verificar o motivo do pensamento ter sumido do mural, e como resolver.

No arquivo `listar-pensamento.html`, a comunicação entre componentes ocorre da seguinte maneira: o `listar-pensamento` atua como componente "pai" enquanto o `app-pensamento` seria um componente "filho".

Para passarmos as informações do componente "pai" `listar-pensamento` para o componente "filho" `pensamento`, acessaremos o arquivo `pensamento.component.ts` na seção `export` e vamos inserir o decorador `@Input()` ao lado de `pensamento`. Ao dar "Enter", será feita a importação automática deste arquivo.

```
    @Input() pensamento = {COPIAR CÓDIGO
```

Este comando informa para o componente "filho" que passará a receber informações do componente "pai".

Depois disso, acessaremos novamente o arquivo `listar-pensamento.component.html` e inseriremos um *Property Binding* (lembra dos colchetes?) para que a propriedade `pensamento` que está com `@Input` receba as informações da variável local `pensamento` que criamos dentro do `ngFor`.

```
    <div class="mural">
        <div *ngFor="let pensamento of listaPensamentos">
            <app-pensamento [pensamento]="pensamento"></app-pensamento>
        </div>
    </div>COPIAR CÓDIGO
```

Assim conseguimos realizar a comunicação entre os componentes "pai" e "filho".

A lista que configuramos receberá no futuro as informações do back-end, e a aplicação renderizará essa lista como um mural na forma dos cartões de pensamento. O componente `pensamento` é de um tipo apelidado de "*dumb component*", pois ele não pensa, somente recebe informações de fora. Por possuir esta característica ele também pode ser reutilizado.

Continuaremos as lições a seguir.