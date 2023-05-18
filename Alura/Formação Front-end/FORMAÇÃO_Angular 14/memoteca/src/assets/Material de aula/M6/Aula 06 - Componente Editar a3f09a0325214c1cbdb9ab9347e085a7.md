# Aula 06 - Componente Editar

Configuraremos a última etapa do nosso CRUD, a funcionalidade de "editar". Para isso, construiremos a mesma interface da página em que inserimos os pensamentos, porém a tela do "editar" deverá carregar e preencher os campos automaticamente com informações do pensamento selecionado para edição.

No terminal da aplicação, criaremos o componente `editar-pensamento` com o comando `ng g c` e apertaremos "Enter".

```
ng g c componentes/pensamentos/editar-pensamentoCOPIAR CÓDIGO
```

Após a criação, acessaremos o arquivo do serviço, `pensamento.service.ts`e criaremos o método `editar()` logo abaixo do `criar()`. Este método utilizará o comando `put`.

```
    editar(pensamento: Pensamento): Observable<Pensamento> {
        const url = `${this.API}/${pensamento.id}`
        return this.http.put<Pensamento>(url, pensamento )
    }
```

Acessaremos o arquivo CSS do componente de edição e copiaremos o [conteúdo que deve ser colado em `editar-pensamento.component.css, disponível neste link`](https://github.com/alura-cursos/2438-angular-memoteca/blob/aula-6/src/app/componentes/pensamentos/editar-pensamento/editar-pensamento.component.css).

A tela de edição é idêntica à tela de criar pensamentos. Portanto, acessaremos o arquivo HTML deste último e copiaremos todo o seu conteúdo. O [código completo de `criar-pensamento.component.html` pode ser acessado através deste link](https://github.com/alura-cursos/2438-angular-memoteca/blob/aula-6/src/app/componentes/pensamentos/criar-pensamento/criar-pensamento.component.html). Em seguida acessaremos`editar-pensamento.component.html`, apagaremos o parágrafo gerado automaticamente e colaremos o conteúdo copiado.

Dentro do arquivo HTML de `editar-pensamento`, alteraremos a classe da `section` de `criar-pensamentos` para `editar-pensamentos`.

```
<section class="container editar-pensamentos ff-inter">COPIAR CÓDIGO
```

Na `div` de *Event Bindings*, modificaremos o método `criarPensamento()` dentro do `button` de "Salvar" transformando-o em um novo método: `editarPensamento()`.

Neste momento, o HTML permanecerá apontando alguns erros de código. Corrigiremos estes erros acessando o arquivo TS.

No arquivo `editar-pensamento.component.ts`, acima do `constructor`, vamos declarar o atributo `pensamento` de tipo `Pensamento` e importaremos esta interface automaticamente através da caixa que será aberta próxima ao código. Abaixo está disponível o código de importação que deverá ser gerado no topo do arquivo pela aplicação :

```
import { Pensamento } from './../pensamento';
```

Adicionaremos neste atributo os valores `id`, `conteudo`, `autoria` e `modelo`. Eles serão declarados com valores vazios, pois suas propriedades serão preenchidas com informações de um cartão já existente que será alterado nesta tela.

```
    pensamento: Pensamento = {
        id: 0,
        conteudo: '',
        autoria: '',
        modelo: ''
    }
```

Injetaremos no `constructor` os serviços que iremos utilizar: `PensamentoService`, `Router` e `ActivatedRoute`. É possível notar que a estrutura construída é similar à do componente `excluir-pensamento`.

```
    constructor(
        private service: PensamentoService,
        private router: Router,
        private route: ActivatedRoute
  ) { }
```

A aplicação deverá importar automaticamente estes serviços enquanto estivermos digitando, ao clicarmos no nome de cada um deles. O código de importação abaixo deverá ser incluído pela aplicação no topo do arquivo.

```
import { Router, ActivatedRoute } from '@angular/router';
import { PensamentoService } from './../pensamento.service';
```

Criaremos dentro de `ngOnInit` uma constante que receberá informações do `id` do cartão. Em seguida configuraremos o consumo do serviço `buscarPorId` através de uma *arrow function* que receberá `pensamento` armazenando-a em seguida no `this.pensamento`.

```
    ngOnInit(): void {
        const id = this.route.snapshot.paramMap.get('id')
        this.service.buscarPorId(parseInt(id!)).subscribe((pensamento) => {
            this.pensamento = pensamento
    })
  }
```

Corrigiremos os erros do HTML relacionados aos métodos criando-os no arquivo TS. Abaixo da seção `ngOnInit`, configuraremos os métodos de "editar" e de "cancelar".

Incluiremos no método `editarPensamento()` o comando `service.editar`. Ele editará um `this.pensamento`. Incluiremos neste comando um `subscribe`. Adicionaremos também uma *arrow fuction* que possui o comando `router.navigate` acompanhado de uma rota, possibilitando desta forma o redirecionamento para o mural e a visualização do pensamento editado.

```
    editarPensamento() {
        this.service.editar(this.pensamento).subscribe(() => {
            this.router.navigate(['/listarPensamento'])
    })
}
```

Já o método `cancelar()` utilizará somente o comando `router.navigate` junto à rota de retorno ao mural.

```
    cancelar() {
        this.router.navigate(['/listarPensamento'])
    }
```

Acessaremos o arquivo `app-routing.module.ts` e dentro de `const routes` criaremos o `path` para o componente `editar-pensamento`.

```
    {
        path: 'pensamentos/editarPensamento/:id',
        component: EditarPensamentoComponent
    }
```

Importaremos automaticamente o `EditarPensamentoComponent` clicando no ícone de lâmpada à direita do código recém-criado e clicando em "*Add import from*". O comando de importação abaixo deverá ser gerado no topo do arquivo:

```
import { EditarPensamentoComponent } from './componentes/pensamentos/editar-pensamento/editar-pensamento.component';
```

Acessaremos o arquivo HTML do cartão: `pensamento.component.html`, encontraremos o botão de "editar" e nele incluiremos o `routerLink` acompanhado de uma interpolação para o `id` de `pensamento`.

```
        <button class="botao-editar">
            <img src="/assets/imagens/icone-editar.png" routerLink="/pensamentos/editarPensamento/{{pensamento.id}}" alt="Ícone de editar">
        </button>COPIAR CÓDIGO
```

Dentro do terminal, executaremos novamente a aplicação com o `ng serve`.

> Dica: No terminal secundário, confira se o back-end ainda está rodando.
> 

Retornando ao navegador, recarregaremos a página com a tecla "F5". Em seguida testaremos as funções recém-configuradas de "editar" e "cancelar" clicando no ícone de edição e alterando qualquer pensamento. Com esta etapa finalizada, todas as funcionalidades que implementamos até agora deverão funcionar perfeitamente.

Parabéns! Conseguimos finalizar o nosso primeiro CRUD em *Angular*!

**[DISCUTIR NO FORUM](https://cursos.alura.com.br/forum/curso-angular-explorando-framework/exercicio-componente-editar/110747/novo)**