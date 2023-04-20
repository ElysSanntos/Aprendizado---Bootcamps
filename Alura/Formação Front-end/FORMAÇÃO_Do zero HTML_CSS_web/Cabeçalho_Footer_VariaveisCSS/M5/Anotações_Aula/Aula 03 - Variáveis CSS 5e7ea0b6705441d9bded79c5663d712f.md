# Aula 03 - Variáveis CSS

**Rafaella:** O nosso projeto está sensacional! Conseguimos:

- navegar entre as páginas;
- acessar o "Sobre mim";
- visualizar o rodapé, o cabeçalho e todos os conteúdos da tela;
- voltar para o "Home" e
- visualizar o efeito *Hover* quando passamos o mouse pelos botões.

O projeto está visualmente incrível, contudo existem alguns detalhes que podemos alterar em relação ao nosso ***código***.

**Guilherme:** Vamos analizar ***as cores*** do nosso projeto. Temos três cores principais:

- a cor preta de fundo `000000`, que é a cor principal;
- o branco `F6F6F6`, utilizado em vários elementos e
- o azul ciano `22D4FD`, uma cor terciária que utilizamos para dar destaque.

Utilizamos essas cores diversas vezes no nosso CSS. Vamos abrir o arquivo `style.css` por meio do VS Code. Pressionaremos "Ctrl + F" e pesquisaremos a cor terciária, digitando "22D4FD" no campo de pesquisa. Constataremos que essa cor foi utilizada ***quatro vezes*** ao longo do projeto. Pesquisaremos em seguida a cor do fundo, digitando "000000" no campo de pesquisa. Perceberemos que ela foi utilizada ***duas vezes***.

Ou seja, somando somente as duas cores, repetimos o nosso código ***seis vezes***. Na prática, repetimos uma ***propriedade sensível*** oito vezes. Isso significa que, caso precisarmos alterar alguma das três cores principais do nosso projeto, teríamos que alterá-la em oito partes diferentes.

**Rafaella:** Esse processo de mudança de cor é muito comum. Muitas empresas decidem alterar as suas identidades visuais em algum ponto de sua trajetória.

**Guilherme:** Como poderemos reutilizar um único código de cor em partes diferentes da nossa aplicação?

**Rafaella:** Utilizaremos ***variáveis no CSS***. Se você conhece alguma outra linguagem de programação, deve saber que elas são muito utilizadas. As variáveis são ***endereços na nossa memória*** reservados para armazenar um valor. Elas precisam ser nomeadas.

É possível criar, por exemplo, uma variável chamada `azul-claro` e armazenar nela a nossa cor, informando o valor hexadecimal `#22D4FD`. Com isso, podemos utilizar somente a variável ao invés de declarar o valor da cor diretamente em todas as partes do código. Além disso, poderemos alterar este valor sempre que precisarmos.

**Guilherme:** Com esse processo, podemos realizar alterações na cor do nosso projeto recorrendo a um único local, o qual enviará a alteração para todos os outros locais em que for inserido. Vamos entender as variáveis acessando a documentação.

**Rafaella:** Buscaremos no Google "variables css" (ou "variáveis no css"). No resultado da pesquisa, selecionaremos o link que nos guiará para a [página do Developer Mozilla sobre variáveis do CSS, em português](https://developer.mozilla.org/pt-BR/docs/Web/CSS/Using_CSS_custom_properties).

**Guilherme:** Selecionamos o Developer Mozilla pois nele temos um exemplo prático. Na seção "Uso básico", somos informados da possibilidade de ***criar variáveis para um escopo global ou para um escopo local***. Voltaremos ao VS Code para demonstrar os dois processos.

Começaremos entendendo a variável de ***escopo local***. Ela consiste em uma variável que poderá ser utilizada diversas vezes, mas que funcionará apenas em um bloco de código definido — como por exemplo, o `body {}` do nosso arquivo `style.css`.

**Rafaella:** Não temos nenhum caso desse em nosso código.

**Guilherme:** Não temos esse caso nem no código nem no nosso projeto. Portanto, faz mais sentido criarmos para o ***escopo global***. Essa técnica consiste em definir as nossas variáveis dentro de um local por meio do qual possamos utilizá-las em vários blocos diferentes, seja o `body`, o `header`, ou outro qualquer.

**Rafaella:** Podemos encontrar esta técnica no segundo exemplo que nos é dado no site Developer Mozilla. A técnica consiste em utilizar a pseudoclasse `root` para que a variável possa ser aplicada globalmente no documento HTML. Podemos consultar o exemplo mencionado abaixo:

```
:root {
    --main-bg-color: brown;
}COPIAR CÓDIGO
```

Neste exemplo declaramos uma variável dentro das chaves do `root`, utilizando a sintaxe `--nome: valor`. O `brown` ilustra um procedimento que já realizamos anteriormente. No lugar do nome da cor, adicionaremos o seu valor hexadecimal.

Retornando ao VS Code, ainda no interior do arquivo `style.css`, adicionaremos na linha 3, acima de todos os blocos de código, a pseudoclasse `:root {}` como se ela fosse um seletor.

**Guilherme:** Um seletor para utilizarmos ao longo de todo o nosso documento, ou seja, de forma global.

```
@import url('https://fonts.googleapis.com/css2?family=Krona+One&family=Montserrat&display=swap');

:root {

}

* {
        margin: 0;
        padding: 0;
}COPIAR CÓDIGO
```

No interior de suas chaves, criaremos nomes para as três variáveis de cor:

- a cor principal se chamará `-cor-primaria`;
- a cor secundária se chamará `-cor-secundaria` e
- a cor terciária ou de destaque, chamaremos de `-cor-terciaria`.

Para definir a `--cor-primaria`, utilizaremos `: #000000`, seguido de ponto e vírgula. Faremos o mesmo para as outras cores, alterando o valor hexadecimal da `--cor-secundaria` para `#F6F6F6`, enquanto o valor da `--cor-terciaria` será `#22D4FD`.

```
:root {
    --cor-primaria: #000000;
    --cor-secundaria: #F6F6F6;
    --cor-terciaria: #22D4FD;
}COPIAR CÓDIGO
```

**Rafaella:** Por enquanto, nada mudou no projeto, pois ***apenas declaramos essas variáveis.***

**Guilherme:** Exatamente. Nós criamos um local onde definimos que temos três cores, e atribuímos um valor para cada uma delas. Nosso próximo desafio será ***utilizar esses elementos*** no nosso projeto.