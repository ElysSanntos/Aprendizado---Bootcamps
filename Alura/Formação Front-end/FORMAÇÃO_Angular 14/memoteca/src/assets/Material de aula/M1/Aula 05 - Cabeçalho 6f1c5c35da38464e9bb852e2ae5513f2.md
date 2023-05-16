# Aula 05 - Cabeçalho

No prompt de comando, dentro do projeto, digitaremos o comando `code` +"espaço" + `.`, pois estamos utilizando o editor de texto *Visual Studio Code*.

```
code .
```

Na seção **[Para saber mais**,](https://cursos.alura.com.br/course/angular-explorando-framework/task/110853) que já estudamos, são explicadas as funcionalidades de todos os arquivos na lista à esquerda do *Visual Studio Code*. Lá também temos a explicação de como funciona a inicialização de uma aplicação em *Angular*. A partir de agora, vamos aos próximos passos.

Primeiro, vamos inserir alguns estilos no nosso projeto. Nesta parte, copiaremos e colaremos os códigos disponíveis na descrição deste vídeo dentro de alguns arquivos que estão na lista à esquerda do *Visual Studio Code*.

A primeira alteração será a modificação do estilo global no arquivo `styles.css`.

Você consegue [acessar o conteúdo do `styles.css` neste link](https://github.com/alura-cursos/2438-angular-memoteca/blob/aula-1/src/styles.css), e pode copiá-lo e colá-lo em sua própria versão.

> Estamos disponibilizando os códigos HTML e CSS já preparados pois este não é o foco do curso. A ideia é focarmos 100% nos conteúdos de Angular. Caso tenha dúvidas ou curiosidades, pode buscar em nossa plataforma outros cursos sobre HTML, CSS e responsividade.
> 

Outra modificação será feita colando o código abaixo no arquivo `app.component.css`, acessado também pelo explorador à esquerda:

```
main {
  background: url(/assets/imagens/background-completo.png);
  background-size: cover;
  min-height: 60vh;
}
```

O próximo passo é colocar [a pasta com todas as imagens da aplicação](https://caelum-online-public.s3.amazonaws.com/2438-angular-comecando-framework/01/imagens-angular.zip) dentro da pasta "assets" do *Visual Studio Code*.

> Atenção: é importante que os nomes das imagens não sejam modificados, pois a estilização foi criada com base nessa nomenclatura.
> 

Agora, vamos criar o primeiro componente do projeto, que será o cabeçalho. Dentro dele temos, à esquerda, uma imagem com o logotipo da "Memoteca", logo abaixo da imagem um parágrafo de texto, e à direita a imagem de um computador.

Em primeiro lugar, voltaremos ao *Visual Studio Code* e criaremos, dentro do diretório "app" à esquerda, uma nova pasta chamada "componentes". Em seguida, acessaremos o terminal pelo próprio *VS Code*. À direita encontraremos um "+" ("new terminal"), seguido de uma seta que nos permite abrir outras opções. Dentre elas, selecionaremos a opção "Git Bash".

Após essa alteração no terminal, digitaremos o comando `ng generate` e o caminho `componentes` juntamente com o nome do componente, que será "cabecalho":

```
ng generate component componentes/cabecalho
```

Após darmos "Enter", o *Angular* criará dentro da pasta "componentes" uma nova pasta com o componente "cabecalho", e dentro dela estarão quatro arquivos: CSS, HTML, Typescript e o arquivo de testes.

Clicaremos no arquivo CSS recém-criado e colaremos mais um [trecho de código do arquivo `cabecalho.component.css`](https://github.com/alura-cursos/2438-angular-memoteca/blob/aula-1/src/app/componentes/cabecalho/cabecalho.component.css).

Em seguida, criaremos o HTML do cabeçalho. Para isso, clicaremos no arquivo HTML recém-criado, apagaremos o parágrafo gerado automaticamente pelo *Angular CLI* e criaremos a *tag* `header`, com a classe `cabecalho` e o atributo `ff-inter`, onde `ff` se refere a *"font family"*.

```
<header class="cabecalho ff-inter">
</ header>
```

Dentro do `header`, criaremos uma `div` com a classe `logo`, e dentro dela colocaremos a imagem do logotipo, digitando o caminho em que ela se encontra dentro do atributo `src`. Depois, incluiremos a descrição da imagem no atributo `alt`.

```
<div class="logo">
    <img src="../../../assets/imagens/logo-memoteca.png" alt="Logo da aplicação Memoteca">
</div>
```

Em seguida, ainda dentro da `div`, abaixo da imagem, colocaremos a *tag* `<p>` e incluiremos nela o parágrafo de texto que temos no cabeçalho.

```
<p>Guarde trechos de músicas, citações de livros, pensamentos e suas melhores ideias</p>
COPIAR CÓDIGO
```

Agora vamos inserir a outra imagem. Abaixo da nossa `div`, digitaremos o mesmo comando de inserção de imagens, só que desta vez vamos colocar o caminho da nova imagem no atributo `src` e outra descrição no atributo `alt`. Além disso, vamos atribuir uma classe para esta imagem.

```
<img class="imagem" src="../../../assets/imagens/computador-cabecalho.png" alt="Imagem de um computador">COPIAR CÓDIGO
```

O código completo da nossa `header` ficará assim:

```
<header class="cabecalho ff-inter">
  <div class="logo">
    <img src="../../../assets/imagens/logo-memoteca.png" alt="Logo da aplicação Memoteca">
    <p>Guarde trechos de músicas, citações de livros, pensamentos e suas melhores ideias.</p>
  </div>
  <img class="imagem" src="../../../assets/imagens/computador-cabecalho.png" alt="Imagem de um computador">
</header>COPIAR CÓDIGO
```

Feito isso, vamos renderizar o nosso cabeçalho na tela.

> Uma dica: sempre que criamos um novo componente, devemos parar a aplicação no terminal com o atalho "Ctrl + C", criar o componente e logo em seguida inicializar novamente a aplicação com o comando ng serve. Esse procedimento evita futuros problemas.
> 

Abriremos o navegador na porta [http://localhost:4200](http://localhost:4200/) e veremos que nosso cabeçalho ainda não aparece.

Deixaremos o navegador aberto e voltaremos ao *Visual Studio Code*. Em seguidam, acessaremos o arquivo `app.component.html`, selecionaremos todo o seu conteúdo com o atalho "Ctrl + A" e apagaremos com "Delete". Depois, vamos clicar em `cabecalho.component.ts` e copiar o seletor do componente `app-cabecalho` que se encontra dentro do arquivo.

Depois disso, abriremos novamente o arquivo `app.component.html`, abriremos uma *tag* e colaremos o seletor desse do componente `app-cabecalho`.

```
<app-cabecalho></app-cabecalho>COPIAR CÓDIGO
```

Agora, voltaremos ao navegador e notaremos que já aparecem as duas imagens e o parágrafo de texto no cabeçalho da página.

Te espero a seguir onde codaremos juntos o rodapé!