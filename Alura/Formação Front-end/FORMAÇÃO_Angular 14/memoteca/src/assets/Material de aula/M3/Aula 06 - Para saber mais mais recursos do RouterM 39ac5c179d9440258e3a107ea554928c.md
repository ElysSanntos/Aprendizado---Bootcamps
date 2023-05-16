# Aula 06 - Para saber mais: mais recursos do RouterModule

O RouterModule é um módulo do Angular que permite definir rotas na sua aplicação, diferentes estratégias de correspondência de caminho, fácil acesso aos parâmetros de rota e proteções de rota para proteger os componentes contra acesso não autorizado.

Na aula vimos a diretiva `<router-outlet>` que é responsável por renderizar a rota solicitada pelo usuário e por meio da propriedade routerLink podemos passar para um botão ou ancora o componente que será renderizado a partir dele.

No projeto da aula não teremos, mas imagine que você esteja construindo uma página que possui um menu com links que redireciona para alguns componentes desta página, como no exemplo:

![https://caelum-online-public.s3.amazonaws.com/2438-angular-comecando-framework/03/aula3-imagem1.png](https://caelum-online-public.s3.amazonaws.com/2438-angular-comecando-framework/03/aula3-imagem1.png)

Perceba que a página /home é apresentada, mas na barra de menu nada indica que está nessa página. Se você conhece um pouco de Javascript talvez pode ter pensado em um evento de click e adicionar uma classe, mas isso daria muito trabalho. O RouterModule possui a propriedade routerLinkActive que é necessário apenas passar a classe com o estilo que será aplicado no link.

**app.component.html**

```
<nav class="navbar container full-width d-flex">
    <ul class="d-flex  links">
        <li
            routerLink="/first"
            routerLinkActive="active"
            class="links-nav py-1"><a>First</a>
        </li>
        <li
            routerLink="/second"
            routerLinkActive="active"
            class="links-nav py-1"><a>Second</a>
        </li>
    </ul><img
        class="logo"
        routerLink="/home"
        routerLinkActive="active"
        src="./assets/LogoAlurabranco.png" alt="">
</nav><main class="container m-width py-3">
    <router-outlet></router-outlet>
</main>COPIAR CÓDIGO
```

**app.component.css**

```
.active{
    border-bottom: 5px solid white;
    color: white;
    transition: 300ms ease-in;
}
.logo.active {
    padding-bottom: 13px;
}
```