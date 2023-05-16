# Aula 09 - Desafio: criando um novo componente

## **Agora é com você!**

O Angular CLI facilita muito a vida das pessoas desenvolvedoras na construção de uma aplicação e para aprofundar os conhecimentos adquiridos nesta aula, que tal montar um novo projeto para testar os comandos do Angular CLI?

Seu desafio será criar um novo componente contendo um título e um parágrafo, tornar esse componente visível e executar essa aplicação no navegador.

## **Gabarito do Desafio**

Para resolver o desafio, use o comando para criar um projeto simplificado. No exemplo abaixo foi criado sem um arquivo de rotas e com o estilo css, mas se quiser basta responder y ou selecionar outra folha de estilo:

![https://caelum-online-public.s3.amazonaws.com/2438-angular-comecando-framework/01/aula1-imagem1.png](https://caelum-online-public.s3.amazonaws.com/2438-angular-comecando-framework/01/aula1-imagem1.png)

Após a instalação, entre no diretório do projeto e crie o componente com o CLI:

![https://caelum-online-public.s3.amazonaws.com/2438-angular-comecando-framework/01/aula1-imagem2.png](https://caelum-online-public.s3.amazonaws.com/2438-angular-comecando-framework/01/aula1-imagem2.png)

Note que foi feito um UPDATE no arquivo app.module.ts, ou seja, a declaração do novo componente desafio.

Abra o projeto no VSCode e vá até o app.component.ts e limpe tudo que tiver no metadado template desse componente e crie um h1.

**app.component.ts**

```
import { Component } from '@angular/core';

@Component({
  selector: 'app-root',
  template: `
      <h1>
        Desafio Aula 1
      </h1>
  `,
  styles: []
})
export class AppComponent {
  title = 'projeto-test';
}
COPIAR CÓDIGO
```

Agora vá até /desafio e abra o desafio.component.ts, crie um h2 para o título e um p para parágrafo e insira os textos. Para diferenciar no app.component.ts coloquei os textos desse componente na cor azul.

**desafio.component.ts**

```
import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-desafio',
  template: `
    <h2>Componente do desafio</h2>
    <p>Lorem ipsum dolor sit amet, consectetur adipisicing elit. Commodi recusandae, est ipsam odit porro tenetur doloribus corrupti quia ipsum, nulla enim amet. Impedit ratione eos error inventore expedita blanditiis cumque.</p>
  `,
  styles: ['h2, p{color: blue}']
})
export class DesafioComponent implements OnInit {
  constructor() { }
  ngOnInit(): void {
  }
}
COPIAR CÓDIGO
```

Volte até o app.component.ts e declare o selector do componente desafio.

**app.component.ts**

```
@Component({
  selector: 'app-root',
  template: `
      <h1>
        Desafio Aula 1
      </h1>
      <app-desafio></app-desafio>
  `,
  styles: []
})
COPIAR CÓDIGO
```

Agora basta salvar tudo e rodar o projeto com o comando `ng serve` e ver o resultado.

![https://caelum-online-public.s3.amazonaws.com/2438-angular-comecando-framework/01/aula1-imagem3.png](https://caelum-online-public.s3.amazonaws.com/2438-angular-comecando-framework/01/aula1-imagem3.png)

Não tem dúvidas? Que tal ajudar alguém no fórum? :)