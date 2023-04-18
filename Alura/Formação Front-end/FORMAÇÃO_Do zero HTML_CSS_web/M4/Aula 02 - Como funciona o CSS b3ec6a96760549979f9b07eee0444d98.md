# Aula 02 - Como funciona o CSS

**Guilherme:** Já criamos um HTML semântico, e escrevemos as estruturas e as marcações de todo o conteúdo que queremos realizar, mas não está visualmente bem finalizado.

**Rafaella:** Os elementos já estão estruturados, mas falta colocar as cores e formatos que fazem uma página web.

**Guilherme:** Isso faz muita diferença, pois há anos atrás, a parte visual não era tão desenvolvida como atualmente, tanto que há uma área profissional que se dedica somente a esta parte de criação.

O desafio desta aula é deixarmos a página mais bonita e parecida com o projeto no Figma, com as cores, tamanhos, formas e posicionamentos corretos.

**Rafaella:** Já compreendemos que o HTML é uma **linguagem de marcação** enquanto o CSS é uma **linguagem de estilização**, portanto **não** são linguagens de programação.

Vamos começar a estilizar nossa página.

**Guilherme:** Sempre quando formos aprender algo novo, é interessante consultarmos a **documentação**. Na barra de busca do navegador, digitaremos "CSS w3s" para acessarmos o [link sobre CSS no W3Schools](https://www.w3schools.com/css/) que aparece na lista de resultados.

Este tutorial é bem simples e possui vários exemplos. Há outras documentações, mas esta é bastante objetiva.

Clicando na opção "CSS Introduction" na lista lateral esquerda do site, abriremos o texto de introdução. Poderemos alterar para o português clicando no ícone de planeta ao lado da lupa na barra superior de opções da cor preta, para depois clicarmos em "Selecionar idioma" e escolhermos "português".

> O HTML é a sigla para "Hyper Text Markup Language" em inglês, ou "Linguagem de Marcação de HiperTexto".
> 

> O CSS é a sigla para "Cascading Style Sheet" ou "Folhas de Estilo em Cascatas" em português.
> 

**Guilherme:** O CSS descreve como esses elementos HTML devem ser exibidos na tela, mas não necessariamente é só a cor, mas também o posicionamento deles, tamanho, peso da fonte e diversos outros detalhes visuais importantes na construção final da página.

A introdução da documentação diz que o CSS "economiza" bastante trabalho, pois pode controlar o *layout* de várias páginas *web* de uma só vez.

Além disso, também são armazenados em arquivos **`.css`**, da mesma forma que o HTML é armazenado em arquivos **`.html`**.

Vamos ver uma [demonstração de seu uso neste link](https://www.w3schools.com/css/css_intro.asp).

**Rafaella:** Mais adiante na introdução, encontraremos a parte de "Demonstração CSS - Uma página HTML - Vários estilos!" com um mesmo arquivo `.html` relacionados com arquivos `.css` diferentes, ou seja, com estilizações diferentes aplicados a um mesmo HTML.

Quando clicamos na opção de "Folha de estilo 1" à esquerda e abaixo de "Bem-Vindo à minha página inicial", teremos uma composição de cores, posições, formas e tamanhos específica, e se clicarmos no "Folha de estilo 2" em seguida, teremos outra composição, e assim por diante.

Todas as alterações são estabelecidas nos arquivos `.css`, mesmo contendo o mesmo conteúdo textual. A última opção de "Sem estilo de folha" é a mais básica e bem parecida com a nossa página atual do projeto.

Portanto, já conseguimos entender como funciona na prática e como escrevemos em CSS.

**Guilherme:** Semelhante ao HTML, existem palavras que são específicas para realizar alguma ação.

Da mesma forma que comentamos que não é necessário aprendermos todas as *tags* em um primeiro curso de HTML, também não é possível aprender todas as **propriedades** de todas as estilizações que existem em CSS de uma só vez. Então focaremos nas **principais**.

Na parte de "Por que usar CSS?" Teremos um exemplo de código contendo `body` que abre e fecha chaves `{}`, e dentro delas, escreveremos as propriedades que vamos precisar e que veremos de forma gradativa ao longo das aulas.

**Rafaella:** Em seguida, teremos a parte de "CSS resolveu um grande problema".

Antigamente, tínhamos apenas o HTML que apenas descreve o conteúdo de uma página *web*. Ao longo do tempo, aumentou a necessidade de fazer com que as telas fiquem mais visualmente agradáveis e eficientes.

Primeiramente era apenas para passar informações e **marcar** o que é cada elemento, e aos poucos as estilizações foram aumentando. Conforme está no texto,

> "O HTML NUNCA foi destinado a conter tags para formatar uma página da web!"
> 

Justamente para resolver este problema, o World Wide Web Consortium (**W3C**) removeu a formatação de estilo da página HTML e criou o CSS para essa responsabilidade.

**Guilherme:** Inclusive comenta que:

> "Quando tags como <font> e atributos de cor foram adicionados à especificação do HTML 3.2, começou um 'pesadelo' para os desenvolvedores da web"
> 

Antes, tínhamos *tags* de marcação e de estilização juntas em um único arquivo, que o deixava bem grande e confuso. Então resolveram isolar essas questões.

Um arquivo ficou responsável pelas informações e marcação do texto que vai aparecer na página, enquanto outro contém os estilos.

Mais adiante, na parte de "CSS economiza muito trabalho!", temos algo que é muito relevante:

> "As definições de estilo são normalmente salvas em arquivos .css externos".
> 

**Rafaella:** Ou seja, temos o arquivo `.html` e há outro separado com a extensão `.css`.

**Guilherme:** Também diz que "Com um arquivo de folha de estilo externo, você pode alterar a aparência de um site inteiro alterando apenas um arquivo!"

**Rafaella:** É exatamente este arquivo que trabalharemos a seguir.