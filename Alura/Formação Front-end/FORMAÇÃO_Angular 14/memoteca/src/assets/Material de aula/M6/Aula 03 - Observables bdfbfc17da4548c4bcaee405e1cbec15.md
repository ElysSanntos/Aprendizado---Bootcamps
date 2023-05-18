# Aula 03 - Observables

Imagine que uma pessoa conhecida queira trocar de celular e entra todos os dias no site para ver se o preço baixou. Você indica a ela que coloque o produto na lista de "Favoritos", pois assim ela receberá uma notificação quando o preço do celular cair.

Através deste exemplo entenderemos como funciona um `Observable`, ou observável, que neste caso é o site de compras. A pessoa conhecida, por sua vez, é a `Observer`, ou observadora, que está interessada em receber as notificações.

O `Observable` funciona de forma similar ao `promise` do *Javascript*, mas com a vantagem de possuir uma transferência de dados contínua. Ou seja, o `Observable` é capaz de emitir dados várias vezes durante a sua existência. Este comando faz parte da biblioteca RXJS, que é utilizada de forma camuflada pelo *Angular* e já vem instalada na aplicação.

Descobriremos o funcionamento do `Observable` para listar os pensamentos na tela do nosso mural. Primeiro, vamos acessar o arquivo `pensamento.service.ts` e inserir o `Observable` de `Pensamento` no método `listar()`.

```
    listar(): Observable<Pensamento[]> {
        // Trecho de código omitido
    }COPIAR CÓDIGO
```

Mantendo o cursor parado em cima de `Observable` aparecerá uma caixa acima do comando. Clicaremos em "Quick Fix... > Add import from "rxjs"". Desta maneira, importaremos este comando da biblioteca RXJS e o comando abaixo aparecerá automaticamente junto aos outros `import`s.

```
import { Observable } from 'rxjs';COPIAR CÓDIGO
```

Em seguida, acessaremos o arquivo `listar-pensamento.component.ts` e informaremos através do comando `subscribe` o nosso interesse nas informações da API que o serviço armazena. É como se estivéssemos acompanhando um canal no Youtube — se não realizarmos a inscrição no canal, não receberemos notificações de novos conteúdos lançados.

O método `subscribe` sinaliza ao `Observable` que é necessário emitir notificações sempre que houver um mudança. Dentro dele inserimos a lista que queremos receber da API.

```
    ngOnInit(): void {
        this.service.listar().subscribe((listaPensamentos))
    }COPIAR CÓDIGO
```

Em seguida vamos inserir a função do tipo *arrow function* para permitir que a lista do serviço receba a lista do `Observable`.

> Dica: A arrow function também é conhecida como "função de seta" por conta de sua sintaxe que lembra uma flecha: =>.
> 

```
    ngOnInit(): void {
        this.service.listar().subscribe((listaPensamentos) => {
            this.listapensamentos = listapensamentos
        });
    }COPIAR CÓDIGO
```

Voltaremos ao navegador e finalmente será possível visualizar a lista de pensamentos no mural. Finalizamos o método de listagem.

Acessaremos novamente o *VS Code* e configuraremos o cadastro. Dentro do arquivo `pensamento.service.ts`, abaixo do método de listagem, digitaremos o método `criar()` e dentro dele vamos inserir a variável `pensamento` do tipo `Pensamento`, que também retornará um `Observable` de `Pensamento`, mas dessa vez o retorno não será um arranjo.

```
    criar(pensamento: Pensamento): Observable<Pensamento> {
    }COPIAR CÓDIGO
```

Dentro de `criar()`, vamos inserir um `return` com o método `post`, a URL da API e também o pensamento que iremos cadastrar.

```
    criar(pensamento: Pensamento): Observable<Pensamento> {
        return this.http.post<Pensamento>(this.API, pensamento)
    }COPIAR CÓDIGO
```

Acessaremos o arquivo `criar-pensamento.component.ts` para consumir o serviço. Dentro do `constructor`, injetaremos o serviço `private service` do tipo `PensamentoService`, que será importado automaticamente no componente. Em seguida, iremos até o método `criarPensamento()`, apagaremos o `alert` que criamos anteriormente e em seu lugar adicionaremos o serviço.

```
    criarPensamento() {
        this.service.criar(this.pensamento).subscribe()
    }COPIAR CÓDIGO
```

Acessaremos a classe `pensamento` e apagaremos os conteúdos de `conteudo`, `autoria` e `modelo`, já que a partir de agora eles serão gerados pelo método `criar()`. Apagaremos também a variável `id` por completo, o que gerará um erro que vamos corrigir em outro arquivo.

```
    pensamento: Pensamento = {
        conteudo: '',
        autoria: '',
        modelo: ''
    }COPIAR CÓDIGO
```

Para corrigir o erro de `id`, acessaremos o arquivo da interface `pensamento.ts` e alteraremos a variável `id` inserindo um ponto de interrogação (`?`). Assim, o `id` se torna uma variável opcional.

```
export interface Pensamento {
    id?: number
    conteudo: string
    autoria: string
    modelo: string
}COPIAR CÓDIGO
```

**Vamos testar?** Acessaremos a página do navegador, clicaremos no botão "Adicionar pensamento" e cadastraremos um novo pensamento com o conteúdo, autoria e modelo abaixo, e depois clicaremos em salvar:

- **Conteúdo:** Pensamento de teste
- **Autoria ou fonte:** Dev Angular
- **Selecione o modelo do cartão:** Modelo 3

Vamos conferir se deu certo voltando ao *VS Code*. Através do explorador, abriremos o arquivo `db.json` dentro da pasta `backend`. Abaixo dos pensamentos que cadastramos anteriormente de forma manual, podemos ver o pensamento que inserimos pela página do navegador.

```
        {
            "conteudo": "Pensamento de teste",
            "autoria": "Dev Angular",
            "modelo": "modelo3",
            "id": 4
        }COPIAR CÓDIGO
```

Nós queremos que, ao salvar ou cancelar, haja um redirecionamento para a página do mural. Para isso, vamos utilizar uma funcionalidade de rotas chamada `router`. Dentro do `constructor` de `criar-pensamento.component.ts`, vamos inserir esse serviço.

```
    constructor(
        private service: PensamentoService,
        private router: Router
    ) { }COPIAR CÓDIGO
```

Dentro de `criarPensamento` vamos inserir uma *arrow function* (`=>`) que retorna o `router` com o método `navigate`. Este por sua vez receberá o caminho para onde queremos que a página seja redirecionada. Note que a rota fornecida estará dentro de um *Event Binding*.

```
    criarPensamento() {
        this.service.criar(this.pensamento).subscribe(() => {
            this.router.navigate(['/listarPensamento'])
        )}COPIAR CÓDIGO
```

Faremos o mesmo processo para o botão de cancelar. Primeiro, acessaremos o arquivo `criar-pensamento.component.html` e deletaremos o `routerLink` que configuramos anteriormente dentro do `button`, para centralizar os redirecionamentos no arquivo TS. Abaixo podemos ver como ficou o código após a retirada desse comando.

```
        <div class="acoes">
            //Trecho de código omitido
            <button (click)="cancelar()" class="botao">Cancelar</button>
        </div>COPIAR CÓDIGO
```

Voltando ao arquivo `criar-pensamento.component.ts`, vamos inserir a mesma função de `criarPensamento()` dentro de `cancelar()`

```
    cancelar() {
        this.router.navigate(['/listarPensamento'])
    }COPIAR CÓDIGO
```

Após esse procedimento, se criarmos um pensamento de teste e pressionarmos "Salvar" ou "Cancelar", ocorrerá o redirecionamento para a página do mural.

No próximo vídeo, configuraremos as outras funcionalidades do CRUD.