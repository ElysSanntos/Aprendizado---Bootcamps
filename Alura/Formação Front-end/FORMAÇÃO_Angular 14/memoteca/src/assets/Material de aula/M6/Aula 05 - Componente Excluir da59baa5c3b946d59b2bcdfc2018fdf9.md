# Aula 05 - Componente Excluir

Agora que concluímos o cadastro e a listagem de pensamentos, continuaremos com as outras funcionalidades do "CRUD".

Ao clicar no ícone de lixeira que fica à direita do cartão, queremos que seja aberto um modal para que haja uma etapa de confirmação de exclusão. Se houver a confirmação, queremos que o pensamento seja deletado, e se cancelarmos a ação, nada deverá ocorrer.

Voltaremos ao *VS Code* e dentro do terminal, pararemos a aplicação com "Ctrl + C". Para fins de didática, criaremos um novo componente que será responsável pela exclusão dos pensamentos, assim manteremos cada função do CRUD separada em um componente diferente.

> Atenção: Cuidado ao selecionar o terminal. O back-end deve continuar em execução no terminal secundário, separado da aplicação.
> 

```
ng g c componentes/pensamentos/excluir-pensamentoCOPIAR CÓDIGO
```

Podemos conferir a criação do componente `excluir-pensamento` acessando pelo navegador o caminho que passamos no terminal.

Acessaremos o arquivo CSS deste componente e colaremos o [código de `excluir-pensamento.css` disponível no *GitHub* da *Alura*](https://github.com/alura-cursos/2438-angular-memoteca/blob/aula-6/src/app/componentes/pensamentos/excluir-pensamento/excluir-pensamento.component.css).

Acessaremos em seguida o arquivo `excluir-pensamento.component.html`, apagaremos o parágrafo gerado automaticamente e criaremos uma `section` com as classes `container`, `ff-inter` e `excluir-pensamentos`. Dentro da `section`, criaremos uma `div` com a classe `modal`, e dentro da `div` criaremos um parágrafo com a mensagem que confirmará a exclusão do pensamento.

```
<section class="container excluir-pensamentos ff-inter">
    <div class="modal">
        <p>O pensamento será deletado. <br/> Confirma a exclusão?</p>
    </div>
</section>
```

Dentro desta `div`, abaixo da mensagem de confirmação, criaremos uma `div` menor que conterá os botões de excluir pensamento e de cancelar a exclusão. Adicionaremos antecipadamente o método `excluirPensamento()` que será criado no `component`, o que causará um erro que será resolvido posteriormente. Criaremos em seguida uma `div` abaixo da `div` do modal, que conterá o comando `overlay` para escurecer levemente o fundo da tela atrás quando o modal abrir.

```
<section class="container excluir-pensamentos ff-inter">
    <div class="modal">
        <p>O pensamento será deletado. <br/> Confirma a exclusão?</p>
        <div class="acoes">
            <button class="botao botao-excluir" (click)="excluirPensamento()">Excluir</button>
            <button class="botao botao-cancelar" (click)="cancelar()">Cancelar</button>
        </div>
    </div>
    <div class="overlay"></div>
</section>
```

Acessaremos `pensamento.service.ts` e criaremos a função `excluir`, que precisará do endereço e do id do pensamento a ser excluído. Vamos inserir o `id` do pensamento e um `Observable` de `Pensamento`. Dentro da função, criaremos uma `const` (ou constante) com o nome `url`. Em seguida configuraremos o retorno através do método `delete` junto à URL. Este método fará a exclusão do pensamento.

```
    excluir(id: number): Observable<Pensamento> {
        const url = `${this.API}/${id}`
        return this.http.delete<Pensamento>(url)
    }
```

Abaixo de `excluir()`, criaremos outro método para buscar um pensamento pelo `id`. Vamos passar o parâmetro `id` que retornará um `observable` de `Pensamento`. Criaremos também uma `const` idêntica à do método `excluir`, porém utilizaremos o método `get` como retorno, pois queremos somente buscar um pensamento.

```
    buscarPorId(id: number): Observable<Pensamento> {
        const url = `${this.API}/${id}`
        return this.http.get<Pensamento>(url)
    }
```

Acessaremos o arquivo `excluir-pensamento.component.ts`, criaremos o parâmetro `pensamento` do tipo `Pensamento` e em seguida vamos inserir algumas variáveis vazias. Em seguida faremos o `import` da classe `Pensamento`.

> Atenção: É importante conferir periodicamente se não faltam importações no seu código. Muitas delas podem ser realizadas automaticamente, com o clique de um botão em cima do método ou classe a ser importada.
> 

```
    pensamento: Pensamento = {
        id: 0,
        conteudo: '',
        autoria: '',
        modelo: ''
    }
```

Dentro do `constructor` injetaremos os serviços que vamos utilizar: `PensamentoService`, `router`. Vamos inserir também o serviço `route` do tipo `ActivatedRoute`, que fornecerá informações sobre as rotas dos cartões de pensamento. Aliado a outros métodos como `snapshot` e `paramMap`, conseguiremos informações sobre os cartões em momentos específicos.

```
    constructor(
        private service: PensamentoService,
        private router: Router,
        private route: ActivatedRoute
    ) { }
```

Dentro do método `ngOnInit()` criaremos uma contante de nome `id` que receberá as propriedades `snapshot` — uma captura ou fotografia da rota no momento em que for acessada — e `paramMap`, que retorna um mapa com informações obrigatórias e opcionais do pensamento. Adicionaremos também o método `get('id')`.

```
    ngOnInit(): void {
        const id = this.route.snapshot.paramMap.get('id')
    }COPIAR CÓDIGO
```

A combinação de comandos acima será responsável por obter o `id` do pensamento para possibilitar a sua exclusão.

Abaixo da `const id`, adicionaremos o serviço `buscarPorId` que possuirá um `subscribe` para `pensamento` e receberá um `pensamento` dentro de `this.pensamento`. Utilizaremos a *arrow function* para construir a lógica.

```
    ngOnInit(): void {
        const id = this.route.snapshot.paramMap.get('id')
        this.service.buscarPorId(parseInt(id!)).subscribe((pensamento) => {
            this.pensamento = pensamento
        })
    }
```

Criaremos o método `excluirPensamento()` no `component`para resolver o erro que causamos dentro do arquivo HTML. Nele haverá o serviço `excluir` baseado do `id` do pensamento e um redirecionamento para o mural.

> Dica: acesse excluir-pensamento.component.html, copie o nome do método e cole no arquivo TS para evitar possíveis erros de digitação na hora de criá-lo.
> 

```
    excluirPensamento() {
        if(this.pensamento.id) {
            this.service.excluir(this.pensamento.id).subscribe(() => {
                this.router.navigate(['/listarPensamento'])
            })
        }
    }
```

Criaremos o método `cancelar()` abaixo do método de exclusão. Este método fará somente o redirecionamento para o mural de pensamentos.

```
cancelar() {
    this.router.navigate(['/listarPensamento'])
  }
```

Antes de testarmos o código, acessaremos o arquivo de rotas `app-routing.module.ts` e na constante `routes` criaremos a rota (`path`) do componente `excluirPensamento`. Faremos também a importação do componente clicando em "*Quick fix...* > *Add import from*".

```
const routes: Routes = [
    //Trecho de código omitido
    {
            path: 'pensamentos/excluirPensamento/:id',
            component: ExcluirPensamentoComponent
    }
    //Trecho de código omitido
];
```

Em seguida acessaremos o HTML do componente do cartão: `pensamento.component.html` para inserir o `routerLink` no botão de exclusão e uma interpolação (`{{}}`) para adquirir o `id`.

```
        <button class="botao-excluir" routerLink="/pensamentos/excluirPensamento/{{pensamento.id}}">
            <img src="/assets/imagens/icone-excluir.png" alt="Ícone de excluir">
        </button>
```

Voltaremos a executar a aplicação no terminal com o comando `ng serve`.

Após a execução, podemos acessar o navegador e testar os métodos implementados. Seremos capazes de utilizar o botão com o ícone de lixeira dentro do cartão, e ao clicarmos nele, um modal será aberto com a mensagem de confirmação e dois botões. O botão "Excluir" fará o pensamento selecionado sumir, já o botão "Cancelar" voltará ao mural.

No próximo vídeo, concluiremos o CRUD.