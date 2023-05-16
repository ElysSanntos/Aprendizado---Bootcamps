# Aula 02 - Criando o formulário

Até agora a nossa aplicação tem um cabeçalho, um rodapé e uma imagem de fundo. O desafio para esse vídeo é criar um formulário para registrar o conteúdo e a autoria dos pensamentos, selecionar os modelos, mostrar a prévia e também os botões "Salvar" e "Cancelar".

Primeiro, no *Visual Studio Code* vamos parar a aplicação com "Ctrl + C" no terminal, e criar uma nova pasta para colocar todos os componentes relacionados aos pensamentos.

Dentro de `componentes` clicaremos com o botão direito, selecionaremos "*new folder*" (nova pasta) e daremos a ela o nome de "pensamentos",

Agora criaremos dentro de `pensamentos` um componente para o formulário chamado "criar-pensamento". No terminal, digitaremos o comando abaixo e apertaremos "Enter".

```
ng g c componentes/pensamentos/criar-pensamento
```

Ao conferir a pasta `pensamentos`, vemos que o componente `criar-pensamento` foi criado. Dentro dele, vamos abrir o arquivo `criar-pensamento.component.css` e colar o código disponível [neste link](https://github.com/alura-cursos/2438-angular-memoteca/blob/aula-2/src/app/componentes/pensamentos/criar-pensamento/criar-pensamento.component.css). Depois disso, fecharemos este arquivo.

Em seguida, abriremos `criar-pensamento.component.html`, apagaremos o parágrafo criado automaticamente e começaremos a codar.

Primeiro, criaremos o título. Abriremos uma `section` com a classes "container", "criar-pensamentos" e "ff-inter". Dentro da `section`, criaremos uma *tag* `header` com a classe "*header*". E dentro dela, vamos adicionar uma *tag* `h2` e inserir o título do formulário com uma quebra de linha (`br`) no meio.

```
<section class="container criar-pensamentos ff-inter">
    <header class="header">
        <h2>Adicione um <br> pensamento novo:</h2>
    </header>
</section>
```

**Vamos conferir como está ficando?** Para que o formulário apareça, precisamos iniciar a aplicação com o comando `ng serve`. Depois, copiaremos o seletor de `criar-pensamento.component.ts` e colaremos dentro do `main` do arquivo `app.component.html`.

```
<app-cabecalho></app-cabecalho>
<main>
  <app-criar-pensamento></app-criar-pensamento>
</main>
<app-rodape></app-rodape>
```

Agora, abriremos a aplicação novamente pelo navegador e daremos "F5" para atualizar. O nosso título já estará aparecendo.

Voltando ao *Visual Studio Code*, abaixo do `header`, criaremos uma *tag* `form` e dentro dela vamos colocar os *inputs* (inserção de dados). Primeiro, criaremos uma `label` para `pensamento` e dentro dela vamos escrever "Pensamento".

```
<form>
    <label for="pensamento">Pensamento</label>
</form>
```

Abaixo dela, criaremos um `input` de nome "Pensamento" com os atributos abaixo:

- um tipo;
- uma classe;
- um `id`;
- um `name`;
- e um `placeholder`.

```
  <form>
    <label for="pensamento">Pensamento</label>
    <input
      type="textarea"
      class="input"
      id="pensamento"
      name="pensamento"
      placeholder="Digite o pensamento"
        >
    </form>
```

Agora, vamos copiar e colar nosso `label` abaixo do primeiro, selecionando todo o código dessa tag e digitando "Shift + Alt + seta para baixo". No `label` copiado você deve alterar os campos de "pensamento" para "autoria" conforme abaixo:

```
<form>
    //Trecho de código omitido
    <label for="autoria">Autoria ou fonte</label><input
      type="text"
      class="input"
      id="autoria"
      name="autoria"
      placeholder="Digite a autoria ou fonte"
        >
</form>
```

> Dica: Para selecionar e editar todos os campos "pensamento" ao mesmo tempo, selecione o primeiro campo e depois digite "Ctrl + D" até o cursor selecionar todos os campos.
> 

Voltaremos para o navegador, atualizaremos a página e assim poderemos visualizar os campos "Pensamento" e "Autoria ou fonte" prontos para serem preenchidos pela pessoa usuária.

A próxima parte são os modelos do cartão. Abaixo do `label` de autoria, criaremos uma nova `label` para "modelo" e logo abaixo uma `div` grande que conterá três `div`s dentro (cada uma das três representa um modelo a ser selecionado com sua respectiva prévia).

```
<label for="modelo">Selecione o modelo do card:</label>
<div class="container-radio">
    <div class="radio-modelo">
        <label for="modelo1">
            <input
                type="radio"
                id="modelo1"
                value="modelo1"
                name="modelo-card"
            >
            <div class="custom-radio">
                <span></span>
            </div>
            <span>Modelo 1</span>
        </label>
    </div>
</div>
```

Agora, criaremos uma `div` para a imagem de prévia do cartão abaixo de cada um dos três `label`s de modelo. Faremos o modelo 1 primeiro.

Vamos inserir três classes, `modelo`, `modelo1` e `ff-roboto-mono`:

```
<label for="modelo">Selecione o modelo do card:</label>
<div class="container-radio">
    <div class="radio-modelo">
        //Conteúdo do "modelo1"
        Prévia:
        <div class="modelo modelo1 ff-roboto-mono">
        </div>
    </div>
</div>
```

Dentro desta `div` colocaremos as imagens das aspas coloridas e dois parágrafos — um para o conteúdo e outro para a autoria, sendo este último em negrito.

```
<label for="modelo">Selecione o modelo do card:</label>
<div class="container-radio">
    <div class="radio-modelo">
        //Conteúdo anterior
        Prévia:
        <div class="modelo modelo1 ff-roboto-mono">
            <img src="../../../../assets/imagens/modelo1.png" alt="Aspas azuis">
            <p class="conteudo">Aqui vai o conteúdo</p>
            <p class="autoria"><b>Aqui vai a autoria</b></p>
        </div>
    </div>
</div>
```

Voltando ao navegador e atualizando a página, podemos agora visualizar o campo "Modelo 1" a ser selecionado e também o quadro azul com a sua prévia. Precisamos de mais duas `div`s com estes atributos para criarmos os outros dois modelos.

Para agilizarmos o processo, vamos copiar a primeira `div` e colar abaixo duas vezes, modificando somente onde está escrito "modelo1" para "modelo2" e depois "modelo3". Em seguida, modificaremos o `alt` das imagens conforme abaixo:

**Modelo 2:**

```
<img src="../../../../assets/imagens/modelo2.png" alt="Aspas azul claro">
```

**Modelo 3:**

```
<img src="../../../../assets/imagens/modelo3.png" alt="Aspas verdes">
```

> Dica: Podemos utilizar o atalho "Ctrl + D" que aprendemos anteriormente para editar todos os campos de uma vez.
> 

Agora, faltam apenas os botões. Abaixo das três `div`s de modelos, criaremos mais uma `div` com a classe `acoes`, e dentro dela duas *tags* `button` com a classe `botao`, uma para "Salvar" e outra para "Cancelar" o nosso pensamento.

```
<div class="acoes">
    <button class="botao">Salvar</button>
    <button class="botao">Cancelar</button>
</div>
```

Se olharmos o navegador, agora já é possível visualizar o formulário completo, com dois campos, três modelos e três prévias, uma de cada cor. Em seguida, você vai entender como ocorre o fluxo de dados entre os arquivos em um componente.