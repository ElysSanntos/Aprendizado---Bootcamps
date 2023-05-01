# Aula 05 - Entendendo como prototipar

Chegamos ao penúltimo vídeo do nosso curso. Ao longo dele, estávamos construindo essa plataforma do “Design Diário” e já temos várias telas já criadas. E ao longo dele, aprendemos a incluir formas, tipografias, ícones, cores, imagens, espaçamentos, vimos as heurísticas, e agora vamos aprender a prototipar.

[00:22] O que é um protótipo? Um protótipo é como se fosse um produto quase final, em que ele não é um produto real ainda, funcionando, porque ele não está no código, porém já conseguimos ver o seu funcionamento antes mesmo de codificar. E é o que vamos fazer nesse vídeo específico.

[00:42] A ferramenta do Figma é uma ferramenta bem legal para conseguirmos prototipar. Então logo no canto direito, nós temos essas 3 abas, uma é “Design”, em que estamos trabalhando nela o tempo inteiro, e a segunda, pelo que podemos ver, é “Prototype”, ou seja, a parte do protótipo, é onde conseguimos dentro da ferramenta do Figma fazer todas as ligações.

[01:03] Ou seja, por exemplo, clicou na parte de “Para você”, isso me leva para onde? Clicou na seta, para onde eu vou a partir dessa seta? Vou clicar no botão “Seguir”, para onde isso vai me levar? Então conseguimos criar todas as interações por meio dessa ferramenta do “Protype” do Figma, e é o que vamos aprender nesse vídeo.

[01:25] Antes de começar a fazer qualquer ligação, vamos entender como funciona. Temos a área do design, que já vimos, e agora temos do *prototype*. Primeira coisa que ele me mostra é qual é o *device* ou o dispositivo que estamos trabalhando. Podemos deixar “None” mesmo, ou podemos escolher algum especifico. Vou deixar “None”, e vamos entender o que acontece.

[01:49] Primeiro eu vou clicar na página inicial, e no topo temos a parte de “Present”, que é a seta de play. Vamos clicar nela e ver o que acontece.

[02:04] Você está vendo que ele abre uma pré-visualização, tudo bem que tem um “scroll”’, mas ele não está ideal, está preenchendo toda a minha altura da tela, não queremos exatamente isso, então já conseguimos configurar isso por meio dessa ferramenta do “prototype”, ou seja, se clicarmos fora do projeto, conseguimos definir o dispositivo, e se mudarmos para “Android small”, por exemplo, que é 360x640, que é o tamanho que já estamos trabalhando em todas as nossas telas, olha o que ele me mostra.

[02:37] Ele muda o *preview*, ele está muito grande, podemos ir na parte de “Opções > fit to screen”, que ele faz com que caiba na tela.

[02:47] Então ele já mudou tudo, ele agora está mostrando com uma casca de celular mesmo, funcionando. Então a primeira coisa que vamos selecionar, e eu posso escolher se eu quero cinza, se eu quero prateado, isso pode ser a seu critério, e podemos também selecionar um fundo. Eu gosto sempre de mudar o fundo, porque como o celular é escuro, eu gosto de deixar o fundo um pouco mais claro, só para dar contraste, mas isso também tanto faz, fica a seu critério.

[03:18] Eu acho que a tela fica melhor um pouco mais clara. E agora que já definimos qual dispositivo, vamos começar a criar as interações. Então nós temos a página inicial, vamos começar a criar algumas interações. Primeiro, como eu faço para chegar na parte do artigo?

[03:37] Se eu selecionar a área “Para você”, eu posso dizer que esse meu *card* inteiro, se eu clicar em qualquer lugar dessa área, não só na imagem, eu quero que me redirecione para a segunda tela, que é a tela do artigo. Ou podemos selecionar somente a imagem, ou o *card* inteiro. Isso fica também ao seu critério, eu vou selecionar somente a imagem. Ou seja, se clicar em qualquer parte da imagem, vai me levar para outra página.

[04:04] Então podemos ir na imagem, e criar uma interação, clicando no “+”, e ele vai dizer se vai ser no clique, se vai ser arrastando, quando eu passar o mouse por cima, quando eu tiver pressionando, se eu apertar alguma tecla específica do meu teclado, tem várias opções, em geral, vamos trabalhar sempre com essa primeira, que é o “On tap”, ou seja, “No clique”.

[04:42] E esse “None” vai ser o que ele faz quando eu clicar, navegar para, abrir um *overlay*, trocar o *overlay*, fechar, voltar, scroll, várias opções, e em geral vamos trabalhar também com “navigate to”, navegue para alguma outra página.

[04:49] No caso, pode ser o artigo, que é a segunda página. E quando eu faço isso, você pode ver que ele criou uma seta dessa minha imagem para a segunda página.

[04:59] Isso é uma forma de fazer. A outra, é ao invés de clicar no “+“ de interação, ir em “On tap”, “none”, e ir escolhendo, eu posso pegar essa bolinha na lateral da imagem, posso ir no “+”, quando eu passo o mouse em cima, ele mostra um “+”, e eu puxo e arrasto, e ele já me levou para o artigo instantaneamente.

[05:19] E eu posso selecionar qual animação que eu quero. É instantânea, eu quero um “Smart animate”.Isso é para animações mais complexas, que não vamos levar em consideração ainda nesse curso, porque é um pouco mais complicado, então vai ser instantânea, vai ser um dissolver, para ficar uma transição mais leve, vai ser movimentar para cima, para o lado, para esquerda, para baixo, enfim, tem algumas opções. Também vamos trabalhar em geral com o dissolver, e ele mostra qual o tipo de animação, de suavização, que também e algo mais complexo, vamos deixar sempre no “Ease out” 300 milissegundos.

[05:57] Por enquanto, vamos trabalhar assim, que é a forma mais simples, mais para frente, quando formos aprendendo melhor a prototipar, podemos mexer um pouco melhor nas opções.

[06:05] Já temos isso, vamos ver o que acontece. Antes de ver o que acontece, você vê que quando eu criei a minha primeira interação, ele criou esse “Flow 1”, ou seja, sempre que eu clicar nesse play, ele vai abrir primeiro essa página. E se clicarmos duas vezes, podemos mudar o nome, tem até um “Flow starting point”, é onde eu começo a interação. Podemos mudar o nome para “Fluxo completo”. E vamos clicar, se apertarmos o “R”, ele reseta.

[06:38] Eu cliquei, e ele já foi direto para minha tela de artigo, eu cliquei na seta de volta, e não está funcionando. Mas eu apertei o “R” para voltar, cliquei e ele veio na página certa. Então, nós já temos essa primeira interação criada. A segunda, vamos na seta de voltar, “Prototype”, vamos colocar o mesmo efeito de dissolver, puxar e arrastar. Vou dar um “R” no nosso projeto.

[07:05] Foi para a página certa, teve o “scroll”, clico na seta e ele volta. Então já temos produzido essa interação do clique do meu artigo para a tela do artigo de fato. Eu vou continuar só mais algumas interações, para entendermos como é, depois eu vou acelerar o vídeo novamente para terminar de incluir. Mas vamos na segunda interação.

[07:27] Você notou que quando clicamos no artigo e eu “scrollei”, esse meu topo está sumindo, eu não gostaria que acontecesse isso, eu gostaria que esse topo ficasse sempre fixo, para conforme for “scrollando”, ele sempre aparecer para eu voltar de forma fácil. Como fazemos isso?

[07:42] Como trabalhamos com *auto-layout*, quando os elementos estão todos dentro de um *auto-layout* apenas, não conseguimos criar essa interação que eu comentei de deixar esse elemento fixo. Vamos pegar esse elemento chamado topo, que é onde queremos que fique fixo, e vamos tirá-lo do nosso *auto-layout* “Elementos”. Então agora eu tenho um “Elementos” e tenho um “Topo”.

[08:04] Nesse “Elementos”, ele subiu quando eu tirei, vamos pegá-lo e jogar para baixo, para ele começar logo após o meu topo. E como o topo está fora do *auto-layout*, se formos na parte de design mesmo, “Constraints and resizing”, tem a opção “Fix position and scrolling”, ou em português, “Manter a posição fixa quando scrollar”, se selecionarmos esse elemento, e ir para a página, o topo se mantém sempre fixo.

[08:45] E podemos fazer a mesma coisa na página inicial. Vamos puxar o topo para fora dos elementos, os elementos vamos deixar começando logo após o meu topo, e vamos manter a posição fixa. E novamente, deixamos a posição fixa do nosso elemento. Vamos fazer só mais uma interação, para fixar realmente como estamos trabalhando.

[09:12] Que vai ser a seguinte, se eu clicar na pessoa, no elemento, eu vou puxar uma seta levando para o perfil. Se eu clicar nessa seta no perfil, eu volto para a página inicial, e vamos fazer a mesma coisa que fizemos antes, vamos tirar o topo dos nossos elementos e vamos deixar só um pouco mais abaixo, e vamos deixar esse elemento fixo também. Então, agora se eu for em “Pessoas” e clicar em “Luisa Silveira”, vem na página do perfil, e eu clico na seta e volto para a página inicial.

[09:57] Eu prometi que seria a última, mas vou fazer só mais uma interação, que vai ser a de clicar na lupa, me leva para o resultado da busca. E se eu clicar na seta de voltar, me leva de volta a para a página inicial, e novamente, vou pegar o topo, jogar para fora, pegar o *frame* e jogar mais para baixo.

[10:23] Então, vamos lá, cliquei na lupa, já fez a pesquisa. Mas faltou selecionar a posição fixa quando “Scrollar”, então tem a página da busca, do artigo, das pessoas, e eu vou terminar de prototipar, e fica o desafio para você também, para você terminar de prototipar também, para você fixar como é o funcionamento da ferramenta de protótipo do Figma, que é bem legal. Volto já.

[11:11] Estou de volta, para vermos quais foram as interações que foram criadas. Você pode ver que fica bem legal quando fazemos o protótipo, fica um “caminho de rato”, com várias ligações, eu acho muito legal quando isso acontece.

[11:25] Então já aprendemos na nossa página inicial a clicar no artigo, vai para o artigo, clicamos na pessoa e vai para a pessoa, e eu até criei mais uma interação, que é essa última parte, que se eu clicar eu vou para um artigo. Então temos esses artigos criados, se eu clicar na lupa, nós vamos para o resultado da busca, e se eu clicar em um elemento vai para o artigo de fato, e temos também o meu perfil, que se eu clicar eu vou para uma página com o meu nome completo, e-mail, senha.

[11:58] Faltou até uma jogada interessante, que eu posso criar uma interação, que é se eu clicar em “Sair da minha conta”, me leva para a tela de login, faz sentido isso. Então cliquei e ele me levou para a tela de login. Apertei o “R” e voltei, e eu vou mostrar uma jogada bem legal.

[12:15] Quando estamos trabalhando, eu vou deletar um elemento e fazer de novo, só para você entender como isso pode ser feito. Eu criei uma nova interação dentro do projeto, que era apenas do login. Como fazemos isso? Selecionei a página inicial do login, e temos a opção de “Flow starting point”, ou seja, começa o fluxo de um determinado ponto. Vou criar um e chamar de “login”.

[12:40] E agora, se eu voltar para o meu protótipo e clicar nessa aba “Open sidebar”, ele abre duas opções, uma é o fluxo completo, que já havíamos criado, e agora essa do login, se clicarmos no “login”, me leva como se a tela inicial fosse a que eu defini no meu projeto.

[12:59] E a partir desse ponto eu consigo criar um fluxo novo também. Então se eu clicar em “Acessar minha conta”, vai para a tela onde eu posso realizar o meu login, ou “Criar uma nova conta”, eu crio um novo cadastro. Então temos essas duas opções, tanto no login, quanto no cadastro, se eu clicar no botão, me leva para a página inicial do aplicativo. Então já temos tudo prototipado, e mostrando como é o funcionamento.

[13:27] Então, o importante do protótipo é não apenas termos as telas estáticas, mas mostrar como são, como acontece as interações dessa plataforma. E conseguimos fazer isso de uma forma muito eficiente, a partir do protótipo.

[13:41] Espero que você tenha gostado desse vídeo, e no próximo vamos concluir o nosso curso, vamos fazer uma retrospectiva de tudo que aprendemos ao longo desse curso, e ver que já saímos desse curso com um conhecimento um pouco maior de como funciona a ferramenta do Figma e de como criar o nosso primeiro site, ou aplicativo, dentro dessa ferramenta. Vai ser um vídeo bem legal e eu espero você lá.