# Aula 08 - Padronização com auto layout

Então agora que já entendemos essa metodologia do *auto-layout*, vamos fazer para mais alguns elementos, para pegarmos de fato a prática de como ele funciona. Vamos fazer no menu topo.

[00:13] Lembra que eu comentei no início do curso, que não criaríamos as formas com um retângulo? Indo na ferramenta do “R”, não vamos fazer dessa forma, fizemos criando *frames* ou *artboards*, porque o auto-layout só funciona com *frames*, com *artboards*. Quando eu seleciono esse topo que tem coisas dentro, ele me dá essa possibilidade do *auto-layout*.

[00:43] Não é isso que queremos agora, vamos dar uma ajeitada antes, criar de fato essa área, mas ainda bem que já criamos tudo com *frames*. Vamos começar a criar esse menu topo. Eu vou selecionar os dois ícones, o de “pesquisa” e o de “perfil”, e eu quero que eles fiquem posicionados na direita da minha interface. Então, eu quero que eles tenham entre eles um espaço padrão, mas eu quero que eles fiquem na direita. Para isso, vamos selecionar os dois, “Shift + A”, e ele já criou.

[01:14] Vamos posicioná-los no meio, não vai fazer diferença, porque os dois tem a mesma altura, então tanto faz se eles estão no topo ou no meio ou no rodapé. E vamos colocar 24 de espaço entre eles, que é um múltiplo de 8. Sempre trabalhando dessa forma.

[01:31] Então já tem os elementos criados, vou chamar de “ícones”, e podemos jogar no nosso *grid* que já criamos. Então nós já temos eles. Agora que temos esses ícones na direita, e temos esse *logo*, vamos só dar uma diminuída nesse *logo*, ele está com essa borda que não existe. Vamos fazer o seguinte, se eu diminuir ele vai ficar errado.

[02:03] Vou dar um “Ctrl + Z”, mas se eu diminuir apertando o “Ctrl”, você pode ver que ele só diminui a forma que ele está contido, sem redimensionar o meu elemento. Então vou fazer para os dois cantos, apertando o “Ctrl”, e vamos posicionar no canto do nosso *grid*.

[02:24] Então agora nós temos o *logo* e os ícones, os ícones na direita e o *logo* na esquerda. E no topo, *auto-layout*. Ele não está muito interessante por enquanto, para começar, ele está no topo, não queremos isso, queremos ele centralizado, e ele está com um número calculado automaticamente, não queremos isso também. Se eu aumentar esse meu elemento, ele vai ficar esquisito.

[02:51] Então, é uma hora perfeita para utilizarmos o que aprendemos, que é o “space between”, ou seja, cada um fica no seu canto, e ele calcula o espaço entre eles automaticamente, conforme a caixa aumenta ou diminui. Então temos o topo, que é um *auto-layout*.

[03:07] E ele tem o “Space between”, e o “padding” sendo usado, o que ele significa? Que ele tem 16 na esquerda, ou seja, exatamente esse espaço. Lembra que calculamos o nosso *grid*, que é o 16? Nós temos 16 na esquerda, na direita também temos 16, no topo e no rodapé temos 8 de espaço, ou seja, se eu criar um retângulo de 8x8 e posicioná-lo em cima do *logo*, é o espaço do topo até os meus elementos e a mesma coisa para baixo.

[03:53] Então, é isso exatamente o “Padding” que estamos trabalhando. No caso, trabalhamos no “Mixed”, porque ele tem 16 nos cantos e 8 em cima e embaixo. Então já temos o topo, vamos fazer mais um, que vai ser os dois textos. “Shift + A” novamente, sempre certificando que vamos selecionar dentro, criamos o *auto-layout* chamado “Texto topo”, sempre certificando que quando selecionamos esses dois, eles não estejam com “Fixed width”, eles estejam com “Fill container”, ou seja, sempre ocupando toda a largura, e vai ser calculado conforme o meu tamanho. Então, se eu diminuir, ele diminui, se eu aumentar, ele aumenta, e vamos fazer ocupando todas as nossas 4 colunas.

[04:38] Então já temos a área, esse texto topo, o meu topo, e já aprendemos que podem ter *auto-layouts* dentro de *auto-layouts*, agora vamos de fato expandir para entender que essas 3 áreas que eu criei, utilizando *auto-layout*, eu posso dar um “Shift + A” nelas, e transformar em um *auto-layout*, e chamar de “elementos”, que é um *auto-layout*, está calculado 53, um número bem doido, mas podemos colocar 32, e ele vai calcular corretamente para mim.

[05:13] E para isso, cuidado sempre, esses elementos internos vão colocar “fill container”, ou seja, eles sempre vão respeitar o tamanho do meu elemento maior, que eu posso dizer que ele tem esse tamanho.

[05:30] Aconteceram alguns problemas? Sim, que podemos ajustar exatamente agora. Como eu coloquei os *paddings* laterais de 16 no *logo*, ele está respeitando, mas nos textos e na imagem não, porque eu não incluí. Então, se selecionarmos o texto topo, ele está com 11, esquecemos de ajeitar, vou colocar 8, podemos ir no “Padding”, 16 na esquerda e 16 na direita, então ele calculou corretamente para mim, e nessa área da imagem eu vou colocar apenas na esquerda, porque na direita eu quero que pareça que esse elemento está vazando a área para fazer essa sensação, que eu posso “scrollar” para o lado.

[06:07] Então, nós já temos uma área chamada “Elementos”, em que temos um menu topo, temos um texto no topo, uma área, e começamos a popular e aplicar o *auto-layout* na construção dessa interface, muito interessante isso.

[06:26] E digamos agora, que queremos duplicar essa área, eu quero que tenha uma área de destaques que seja igual a “Para você”. Eu posso dar um “Ctrl + C”, “Ctrl + V”, e joguei para baixo, ou somente “Ctrl + D”, e eu duplico esse meu elemento.

[06:45] Vou chamar de “Destaques”, e perfeito, tudo muito bem produzido. Então já temos o “Para você”, temos uma área de destaques que eu criei, e se eu quiser, eu posso selecionar e mudar as imagens, e dessa forma, eu consigo ter um fluxo de trabalho muito mais eficiente, sem ter que ficar cada vez que eu mudo alguma coisa, eu tenho que reposicionar o meu elemento, calcular de novo. Dessa forma, está tudo muito mais automatizado para eu focar de fato no conteúdo, e não em ficar reposicionando meus elementos a cada mexida que eu dou na minha interface.

[07:27] Então, muito poderoso isso do *auto-layout*. E digamos que nesse caso, eu queira que tivesse um fundo, eu posso trabalhar com 32, 16 e 32, e colocar um “Fill”, e muda a cor, e ele cria essa sessão com um fundo colorido, exagerei no 32, posso colocar 16 nos cantos, e ele cria um destaque. Acho que ficou muito forte essa cor, eu coloco mais fraca e está perfeito.

[08:05] Então, dessa forma ainda podemos produzir, utilizando de fato os *paddings*. No caso, eu não quero trabalhar com isso, eu vou fazer esse elemento na parte das pessoas, mas eu quis só demonstrar para você entender o funcionamento.

[08:25] Espero que você tenha gostado e entendido sobre o *auto-layout*, e fica novamente o desafio, para você ir populando a sua interface com esses espaçamentos, porque dessa forma estamos muito bem padronizados e sem nenhum problema, porque está tudo calculado no *auto-layout*. Dessa forma, vamos fazer uma padronização de espaçamentos muito boa e automatizada.

[08:47] Então, como eu comentei, vou dar uma acelerada no vídeo para terminar, e fica o desafio para você, para você também incluir também os seus elementos. Volto já.

[09:14] Terminei de incluir, então só segui o mesmo processo de inclusão do *auto-layout*. Começar pela área de pessoas, que eu fiz a mesma coisa, incluí esses elementos, e uma jogada bem legal, é que nos botões, sempre nos botões, eu transformei o botão em si, em um *auto-layout*. Então podemos notar que dentro desse botão temos apenas um elemento, que é o texto, e ele tem o *padding* no topo e *paddings* laterais.

[09:59] Se eu quiser escrever e aumentar, não ser mais “Seguir”, ser qualquer outra palavra, ele vai se redimensionar para fazer caber. Então bem legal de trabalharmos isso, não somente em elementos lado a lado, e um *artboard* que só tem um elemento dentro. Então eu posicionei sempre no meio e fui criando o botão.

[10:20] Mesma coisa para o botão de “Acessar a conta” e “Criar nova conta”, temos um *auto-layout*, que tem os *paddings* dele e um texto dentro. Então, só seguir a mesma metodologia que eu comentei, sempre utilizando os “Fill containers”, para criarmos esses elementos do *auto-layout* e deixar bem padronizado.

[10:40] Então esse meu elemento de pessoas eu coloquei um “Padding” de 16 e coloquei um fundo colorido. Na área de destaques, a mesma coisa, eu somente repliquei, ele tinha um tamanho fixo, e ao invés de colocar um tamanho fixo, eu coloquei um “fill container”, e ele já ocupou tudo. Muito automatizado.

[11:04] O conteúdo relacionado, eu simplesmente peguei um desses elementos de destaque, copiei e colei para o lado esquerdo e só mudei o texto, ao invés de “Destaques” era “Conteúdo relacionado”, e você pode notar que muitas vezes estamos repetindo elementos.

[11:21] Os elementos se repetem pelo projeto. No caso do login, eu criei os campos de texto com um *auto-layout*, que ele tem sempre os *paddings* 16, para fazermos essa jogada de ter o *grid* correto, e 8 de espaçamento, que são os dois textos e o retângulo.

[11:46] Então, espero que você tenha gostado desse vídeo, começamos a entender o *auto-layout* e entendemos a sua facilidade, como nos ajuda a criar elementos mais automatizados no dia a dia. É uma ferramenta muito boa do Figma, para sempre termos uma padronização exata e bem automatizada.

[12:08] Espero que você tenha gostado, e eu te espero no próximo, onde vamos chegar na última aula do nosso curso, para fechar com alguns vídeos e fechar esse conteúdo que foi preparado. Eu espero você no próximo vídeo.