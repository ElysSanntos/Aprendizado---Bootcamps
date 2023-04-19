# Aula 05 - Flexbox

**Guilherme:** Rafa, por favor, eu preciso da sua ajuda, porque ele não está bonito! As cores estão legais e a imagem também, mas como mudamos o posicionamento desses elementos?

Não precisa ficar lindo, mas seria legal ter os textos de um lado e a imagem do outro.

**Rafaella:** Existem várias formas de posicionarmos esses elementos na página. Podemos usar posições fixas e definir quanto pixels queremos de margem, por exemplo, 300px na margem superior do título, empurrando todo conteúdo para baixo.

Entretanto definir um número fixo não é uma boa prática, porque podemos usar várias telas para abrir nosso projeto, e assim ele não ficará da mesma forma como imaginamos.

**Guilherme:** Vou até usar um exemplo. Você define uma margem de 300px e eu abro no celular, que não tem todo esse espaço, então vai ficar muito estranho. Ou então eu abro em um super monitor gamer de 34 polegadas e o espaço ficará minúsculo.

**Rafaella:** Vai ficar horroroso. Então podemos utilizar esse posicionamento específico em alguns pontos específicos. Porém quando temos dois elementos grandes para posicionar, como observamos no Figma do nosso projeto, e queremos posicionar em relação um ao outro, conseguimos usar tecnologias que já foram criadas para facilitar a resolver esse problema.

No caso, temos vários elementos para posicionar na nossa página, mas eu me referi a dois elementos porque temos uma seção principal, com o texto e os botões do lado esquerdo, e a imagem, do lado direito. Portanto são dois grandes elementos que queremos centralizar na página, mas deixá-los lado a lado.

![https://cdn1.gnarususercontent.com.br/1/935581/49e15161-1a46-4440-9cb5-6a66625f046d.png](https://cdn1.gnarususercontent.com.br/1/935581/49e15161-1a46-4440-9cb5-6a66625f046d.png)

Uma das tecnologias que usaremos agora no nosso projeto é o ***Flexbox***. E como tudo que já fizemos, buscaremos a documentação dele.

**Guilherme:** Podemos reparar que essa é uma prática constante. Sempre que vamos aprender algo novo, conferimos a documentação. Estamos tentando guiar vocês à uma documentação mais fácil e que tenha uma tradução em português.

Podemos até abrir a [documentação do Mozilla sobre *Flexbox*](https://developer.mozilla.org/pt-BR/docs/Learn/CSS/CSS_layout/Flexbox) e ao traduzir para o português somos informados que se trata de "uma nova tecnologia" e que a ideia deles é "centralizar blocos de conteúdo verticalmente dentro do seu pai". Inclusive já aprendemos que o "pai" seria o elemento que contém outros elementos dentro.

Eu recomendo que vocês leiam essa documentação com calma, mas ela é bastante técnica. Porém existe um "atalho" que vamos passa, certo, Rafa?

**Rafaella:** Exato, é um **guia do *Flexbox*** com imagens, sendo muito mais tranquilo de conhecerem: o chamado ***[A Complete Guide to Flexbox](https://css-tricks.com/snippets/css/a-guide-to-flexbox/)***. Também traduziremos essa página para o português e, ao rolar por essa página, nos deparamos com várias imagens.

Agora nós tentaremos entender como iniciar a utilização do Flexbox. O **primeiro ponto** é que existe uma propriedade que precisamos definir para o elemento "pai", e ela indica quando começaremos a usar o *flexbox* para posicionar nossos elementos. O nome dessa propriedade, como mostra o primeiro exemplo, é o **[display: flex](https://css-tricks.com/snippets/css/a-guide-to-flexbox/#aa-display)**.

```
.container {
  display: flex; /* or inline-flex */
}COPIAR CÓDIGO
```

Nesse caso, podemos chamar a tag "pai" de container, mas sempre precisamos adicionar essa propriedade. Então vou copiar e voltar para o nosso código `index.html` no VS Code.

Comparando o Figma com o `index.html`, conseguimos analisar que o elemento "pai" dos elementos que queremos posicionar, ou seja, o container que fica o envolve, é o `<main>`. Tudo está dentro do `<main>`, portanto é nele que vamos codar a propriedade que informa onde usaremos o Flexbox, como informou o *Complete Guide*.

E para conseguirmos estilizar nosso `main`, criaremos uma classe para ele. Como nomeamos essa classe?

**Guilherme:** Como estamos mostrando o texto e a imagem, pode ser "apresentação".

**Rafaella:** Então será `"apresentacao"`, por isso nossa linha 12 fica:

```
<main class="apresentacao">COPIAR CÓDIGO
```

**Guilherme:** Rafa, em nenhum momento das classes que estamos criando você escreve com acentuação. Nós não usamos acento, certo?

**Rafaella:** Não, porque é uma boa prática e é mais fácil de não ter erros. Como comentamos, existe a questão de a máquina interpretar o acento como uma série de códigos, o que não é legal. Por isso escrevemos sem acento.

E agora, no `style.css`, após o fechamento de chaves do `.titulo-destaque {}` e pressionamos "Enter" duas vezes e codamos, a partir da linha 17:

```
.apresentacao {
    display: flex;
}COPIAR CÓDIGO
```

Colamos dentro dessa classe a propriedade que vimos na documentação. Agora, voltando para o navegador, observamos que nosso conteúdo de texto está à esquerda enquanto a imagem está à direita da página.

**Guilherme:** Ele mudou! Diz se eu entendi, Rafa. Ele está dizendo que o `main`, que é o "pai" será `display: flex`, então ele coloca todos os elementos do `main` na mesma linha.

**Rafaella:** Na verdade, o Flexbox faz isso por padrão, ou seja, deixa os elementos no sentido de linha, que em inglês é ***Row***, mas isso **é configurável**. Não necessariamente queremos que nossos elementos fiquem em uma linha, e eles podem ficar na posição de coluna; Essa é outra propriedade que podemos inserir no código: a **`flex-direction`**, como mostra o *Complete Guide*.

```
.container {
  flex-direction: row | row-reverse | column | column-reverse;
}COPIAR CÓDIGO
```

Contudo, o padrão do nosso projeto é horizontal, ou seja, do lado esquerdo fica o texto e do direito a imagem. Então não precisamos alterar esse padrão, ou seja, não precisamos alterar a propriedade ***[flex-direction](https://css-tricks.com/snippets/css/a-guide-to-flexbox/#aa-flex-direction)*** e determinar se será coluna ou linha. Inclusive podemos escrever como `flex-direction: row`, mas ele já está fazemos o que gostaríamos.

**Guilherme:** Então por *default* (padrão) ele já tem algumas configurações.

**Rafaella:** Sim, por isso já ficou automaticamente em forma de linha.

**Guilherme:** Vamos voltar no nosso projeto no navegador, Rafa, porque tem algo que achei interessante. Tiramos a margem e, quando deixamos no `display: flex` ele deixou na mesma linha.

Conseguimos centralizar esse conteúdo? Porque é um segundo passo grande vencido.

**Rafaella:** Descendo na documentação do *Complete Guide*, encontramos a propriedade **[Itens de alinhamento](https://css-tricks.com/snippets/css/a-guide-to-flexbox/#aa-align-content)**. Nela temos 5 imagens que representam a disposição dos itens na página.

![https://css-tricks.com/wp-content/uploads/2018/10/align-items.svg](https://css-tricks.com/wp-content/uploads/2018/10/align-items.svg)

```
.container {
  align-items: stretch | flex-start | flex-end | center | baseline | first baseline | last baseline | start | end | self-start | self-end + ... safe | unsafe;
}COPIAR CÓDIGO
```

Temos os itens na forma de `flex-start`, que é o valor da propriedade inicial, como está a página do nosso projeto. Além disso, podemos deixar todos os conteúdos no final da página, com `flex-end`, mas o que você falou para fazermos é deixá-lo no centro, então no valor da propriedade vamos codar `align-items: center`, como a documentação está informando para nós.

```
.apresentação {
    display: flex;
    align-items: center;
}COPIAR CÓDIGO
```

Quando salvamos e voltamos para observar nossa página no navegador, vemos que os conteúdos de texto estão centralizados, mas nossos elementos não estão no centro da página.

**Guilherme:** Parece que está no centro da imagem.

**Rafaella:** É justamente isso. Na verdade o `align-items` alinha os itens de acordo com o próprio alinhamento deles. Então temos a imagem, que é o elemento de maior altura, e ela que define qual será o ponto central do alinhamento. Então todos os alinhamentos estão alinhados conforme a imagem.