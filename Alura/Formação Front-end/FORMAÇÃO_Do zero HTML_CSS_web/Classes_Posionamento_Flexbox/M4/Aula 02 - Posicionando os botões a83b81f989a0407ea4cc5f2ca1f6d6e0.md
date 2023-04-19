# Aula 02 - Posicionando os botões

**Guilherme:** Rafa, com as fontes, o projeto está com outra cara. Porém, existe uma parte distante do resultado proposto no Figma.

**Rafaella:** Sim, os links do *Instagram* e do *Github*.

**Guilherme:** Não dá pra ver. Eu estou de óculos e não consigo enxergar.

Em nenhum momento estilizamos nossos botões. Vamos fazer isso?

**Rafaella:** Vamos. Podemos estilizá-los e depois posicioná-los.

Voltando no nosso [Figma do projeto](https://www.figma.com/file/4EKKCbr5rS93RWP7kRjXIz/Portfolio---Curso-1?t=6dfeFknOinJA1UCL-0), veremos que os botões possuem espaçamentos.

**Guilherme:** Existe um grupo que os une. Ele nos diz que existem dois botões na mesma linha.

**Rafaella:** Exatamente. Temos também um espaço entre eles. É isso que traremos para nosso código.

Já que os botões parecem estar unidos num grupo, podemos criar de fato um grupo entre eles. Acessaremos o arquivo `index.html` e veremos os botões localizados na *tag* âncora, ou `<a>`. Para agrupá-los, criaremos uma *tag* chamada `<div>` que significa "divisão". Ela envolverá os dois `<a>` dos botões.

```
    <main class="apresentacao">
        <section class="apresentacao__conteudo">
            <h1 class="apresentacao__conteudo__titulo">Eleve seu negócio digital a outro nível <strong class="titulo-destaque">com um Front-end de qualidade!</strong></h1>
            <p class="apresentacao__conteudo__texto">Olá! Sou Joana Santos, desenvolvedora Front-end com especialidade em React, HTML e CSS. Ajudo pequenos negócios e designers a colocarem em prática boas ideias. Vamos conversar?</p>
            <div>
                <a href="https://instagram.com/rafaballerini">Instagram</a>
                <a href="https://github.com/guilhermeonrails">Github</a>
            </div>
        </section><img src="imagem.png" alt="Foto da Joana Santos programando">COPIAR CÓDIGO
```

Utilizamos esta *tag* para agrupamentos bem específicos, como no caso dos nossos botões. Não utilizamos para esses fins as *tags* `<main>` ou `<section>`.

**Guilherme:** Não é uma divisão de estrutura. Ela só aponta um agrupamento entre os elementos. E não precisam ser necessariamente botões. Podemos agrupar elementos de texto, desde que não se enquadrem em um contexto maior.

**Rafaella:** Em um contexto semântico, né. Por exemplo: o conteúdo principal precisa de um nome: é o `<main>`. Se estamos trabalhando com um agrupamento de elementos que querem dizer uma coisa só, digitamos `<section>`. Já a `<div>` é puramente visual e serve apenas para juntar os dois botões em um lugar só, não possui valor semântico.

Vamos estilizar os botões. Posicionaremos um botão à esquerda e outro à direita, na horizontal. Para isso, criaremos uma `class` para essa `div`.

**Guilherme:** Podemos criar uma `class` para qualquer elemento, né.

**Rafaella:** Qualquer elemento ou *tag*. Qual nome você quer dar a ela, Gui?

**Guilherme:** Já que estamos dentro da seção de `apresentacao`, vamos nomeá-la de `apresentacao__links`.

```
    <main class="apresentacao">
        <section class="apresentacao__conteudo">
            <h1 class="apresentacao__conteudo__titulo">Eleve seu negócio digital a outro nível <strong class="titulo-destaque">com um Front-end de qualidade!</strong></h1>
            <p class="apresentacao__conteudo__texto">Olá! Sou Joana Santos, desenvolvedora Front-end com especialidade em React, HTML e CSS. Ajudo pequenos negócios e designers a colocarem em prática boas ideias. Vamos conversar?</p>
            <div class="apresentacao__links">
                <a href="https://instagram.com/rafaballerini">Instagram</a>
                <a href="https://github.com/guilhermeonrails">Github</a>
            </div>
        </section><img src="imagem.png" alt="Foto da Joana Santos programando">COPIAR CÓDIGO
```

**Rafaella:** Salvaremos esse código e acessaremos o arquivo `style.css`. Abaixo de `.apresentacao__conteudo__texto{}` criaremos um `.apresentacao__links{}`.

```
.apresentacao__conteudo__texto{
    font-size: 24px;
    font-family: 'Montserrat', sans-serif;
}

.apresentacao__links{

}COPIAR CÓDIGO
```

Dentro de suas chaves criaremos um Flexbox. Já fizemos algo parecido quando selecionamos o elemento pai e utilizamos o `space-between`. Sempre que utilizamos o Flexbox, precisamos fazer um procedimento no elemento pai. Lembrando que se trata do pai pois incluímos os dois botões em seu interior como elementos filhos, e são estes que posicionaremos.

O que devemos adicionar como propriedade no elemento pai?

**Guilherme:** Um `display: flex`.

**Rafaella:** Exatamente. Adicionaremos um `display: flex` dentro das chaves de `.apresentacao__links{}`. Abaixo desse comando acrescentaremos a propriedade `justify-content: space-between`.

```
.apresentacao__links{
    display: flex;
    justify-content: space-between;
}COPIAR CÓDIGO
```

Salvaremos esse código e retornaremos à nossa aplicação exibida no navegador. Nela veremos que os botões estão separados, um de cada lado.

**Guilherme:** Deu certo, os botões estão separados. O nosso próximo desafio é deixá-los bonitos.