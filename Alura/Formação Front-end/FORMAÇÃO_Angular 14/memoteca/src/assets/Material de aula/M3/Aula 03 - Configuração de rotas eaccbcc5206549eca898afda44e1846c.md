# Aula 03 - Configuração de rotas

Você se lembra quando, no início do curso, nós utilizamos o comando `ng new` para criarmos nossa aplicação e o terminal retornou duas perguntinhas? A primeira delas perguntava se nós queríamos ***adicionar o arquivo de rotas*** na aplicação, e respondemos que sim. Chegou o momento de utilizá-lo.

Modificaremos esse arquivo para resolver o problema de rotas em nossa aplicação.

Fecharemos os dois arquivos que estão abertos no *VS Code* e acessaremos o arquivo `app-routing.module.ts`. Dentro deste arquivo vamos trabalhar com a constante que foi produzida por padrão quando criamos o arquivo de rotas.

```
const routes: Routes = [];COPIAR CÓDIGO
```

A constante `const` representa as rotas da aplicação. Ela possui o nome `routes` e o tipo `Routes` — este último sendo um objeto de configuração que define as rotas.

As rotas de nossa aplicação serão um *array* (arranjo, em português), pois são múltiplas. Portanto, para cada rota, informaremos um objeto diferente.

**Você se lembra do rádio?** Da mesma forma que precisamos inserir a frequência para ouvir rádio, para o funcionamento correto das rotas do *Angular* precisamos passar um caminho (`path`).

O `path` que estamos configurando possui uma *string* (cadeia de caracteres de texto) que alocará a rota que será acessada. Vamos inserir a rota `criarPensamento` para direcionar a página ao formulário. Abaixo do `path`, inserimos o componente `CriarPensamento` que representa o formulário.

```
const routes: Routes = [
    {
        path: 'criarPensamento',
        component: CriarPensamentoComponent
    }
];COPIAR CÓDIGO
```

Após digitar "Enter", a extensão *Auto Import* realizará a importação do componente automaticamente.

Pronto, já configuramos uma rota no *Angular*! Agora faremos o mesmo processo para a rota do mural.

```
const routes: Routes = [
    {
        path: 'criarPensamento',
        component: CriarPensamentoComponent
    },
    {
        path: 'listarPensamento',
        component: ListarPensamentoComponent
    }
];COPIAR CÓDIGO
```

Devemos criar também um `path` para a página inicial, com uma *string* vazia, que realizará um redirecionamento para o nosso mural de pensamentos.

```
const routes: Routes = [
    {
        path: '',
        redirectTo: 'listarPensamento'
    },
    {
        path: 'criarPensamento',
        component: CriarPensamentoComponent
    },
    {
        path: 'listarPensamento',
        component: ListarPensamentoComponent
    }
];COPIAR CÓDIGO
```

Sempre que criamos um `path` com o caminho vazio, devemos adicionar outra propriedade chamada `pathMatch`, que possui dois valores: `prefix` e `full`. Selecionaremos o `full`, pois queremos que ***toda a URL seja considerada***. Se o `prefix` for selecionado, somente o endereço da página inicial (antes da primeira barra) será considerado.

```
{
        path: '',
        redirectTo: 'listarPensamento'
        pathMatch: 'full'
    },COPIAR CÓDIGO
```

Quando acessamos o navegador e digitamos na barra de pesquisa a rota "[http://localhost:4200/criarPensamento"](http://localhost:4200/criarPensamento%22), é possível visualizar o conteúdo do formulário que havia sumido. Se a gente digitar "[http://localhost:4200/listarPensamento"](http://localhost:4200/listarPensamento%22), veremos nessa página o nosso mural de pensamento.

Ao acessarmos a página inicial digitando simplesmente "[http://localhost:4200"](http://localhost:4200"/), haverá um redirecionamento para a página do mural.

Pronto, conseguimos configurar as rotas perfeitamente. Entretanto, para acessar cada um dos componentes, nós temos que digitar cada endereço diretamente na barra do navegador. Esse processo não é nada agradável para a pessoa usuária e portanto não é o que queremos.

Em seguida, aprenderemos a realizar a navegação entre componentes de maneira mais eficiente, através dos próprios botões da página.