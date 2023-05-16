# Aula 05 - Módulo de rotas

No projeto construímos as rotas para os componentes de formulário e lista de pensamento, estas rotas quando solicitadas devem ser renderizadas no corpo da diretiva `<router-outlet>`.

Agariberto está construindo a aplicação conosco, mas ao finalizar a construção do botão e testá-lo percebeu que a página inteira está sendo recarregada, aspecto que devemos evitar em uma Single Page Application. Veja as configurações de roteamento de Agariberto.

```
const routes: Routes = [
  { path: "", redirectTo: "listarPensamento", pathMatch: "full" },
  { path: "criarPensamento", component: CriarPensamentoComponent },
  { path: "listarPensamento", component: ListarPensamentoComponent },
];COPIAR CÓDIGO
```

E o botão que criou:

```
<button class="botao" href="/criarPensamento">
        Adicionar pensamento
</button>
```

O que fazer para que carregue apenas o componente quando clicar no botão?

*Selecione uma alternativa*

O atributo `href` deve ser trocado pelo `routerLink` tendo como valor o nome do componente igual ao declarado no objeto de rota.

O `routerLink` inicia a navegação do componente, que será renderizado na diretiva `<router-outlet>`.