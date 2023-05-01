# Aula 06 - Conhecendo o auto layout

Chegamos ao vídeo que vamos começar a criar os espaçamentos do nosso projeto do “Design Diário”.

[00:06] Como você pode ter notado, fomos incluindo os elementos nas nossas telas de uma forma muito aleatória, não tem nenhuma padronização de como estamos criando. E nesse vídeo, vamos começar a organizar isso, para não ter essa cara de elementos jogados ao extremo. Mas antes, vamos entender um pouco sobre o Material Design.

[00:26] O Material Design fala um pouco sobre espaçamentos também, e ele comenta que os espaçamentos são elementos importantes para termos padronização das nossas telas, dos fluxos que estamos criando. Se olharmos no nosso projeto, vou ligar o *grid* e você pode ver que já estamos trabalhando um pouco com espaçamentos.

[00:45] Então, se eu criar um retângulo, podemos ver que temos a largura de 16, então nós temos um espaço entre a borda e o início do conteúdo, nós temos um espaço determinado entre as colunas de 16, no canto também de 16, então já temos um início disso, mas agora precisamos de fato ajustar todos os elementos.

[01:11] Então, se olharmos no Material Design, podemos ver que ele até recomenda você a trabalhar com o espaçamentos múltiplos de 8. Então dessa forma conseguimos criar interfaces mais padronizadas.

[01:23] Então, por exemplo, eu quero criar em um espaço pequeno, eu crio 8 de espaço entre um item e outro. Eu quero um espaço que seja o dobro disso, eu posso criar de 16 pixels, 24, 32, 40, 48, e assim por diante, o Material Design até comenta sobre isso.

[01:39] Ele fala do espaçamento de 48, todos múltiplos de 8, ou metade de 8, 4. Podemos notar que está tudo muito bem calculado, e dessa forma garantimos uma grande padronização na criação das interfaces.

[02:02] Bom, mas vamos agora começar a criar os espaçamentos do nosso projeto. E se você quiser conhecer um pouco mais sobre espaçamentos, eu vou deixar um “Para saber mais”, falando dessa padronização. É interessante você dar uma lida também, para entender um pouco melhor sobre essa padronização.

[02:20] Vamos lá! Então vamos começar criando como primeiro exemplo, esse nosso artigo e o espaço dele. Lembra que eu comentei no início do curso sobre a criação de grupos, que não é mais tão utilizada no Figma, que existem novas metodologias para a criação? É o que eu vou focar bastante nesse vídeo, que é o *auto-layout*. Mas antes disso, vamos entender um pouco sobre os grupos.

[02:50] Então, como eu poderia fazer isso antigamente no Figma? Eu selecionaria o rosto e o nome, apertaria o “Ctrl + G”, então eu tenho até uma opção, selecionando esses dois elementos, a imagem e o nome, que é o espaço que eu posso aumentar, ele dá um espaçamento padrão, posso colocar 8 e ele calcula para mim.

[03:20] Isso seria um grupo, eu poderia pegar todos os elementos, apertar um “Ctrl + G” também, e chamar de “Card”, e nesse meu “Card” nós temos o avatar, a imagem e o texto, e se eu selecionar todos, eles também têm um espaçamento padrão de 12, que eu posso mudar para 8, para 16, para 32, vamos colocar 8, só para entendermos.

[03:46] Criaríamos dessa forma antigamente no Figma. Porém, tem um pequeno problema. Não quero que esse texto tenha duas linhas, quero que tenha apenas uma, vou deletar, e vou ter que pegar o elemento, puxar para cima, segurando o “Shift”. Na verdade, tem que ser 3 linhas, então eu vou escrever, e eu vou ter que pegar de novo, puxar para baixo. Então, vou mostrar a ferramenta do *auto-layout*, que padroniza todos esses espaçamentos e também automatiza, para não termos tanta dor de cabeça nessa criação.

[04:22] Vamos deletar e vamos começar a criar. Onde eu poderia criar um grupo, eu vou selecionar a “imagem” e o “nome”, e eu posso ou clicar com o botão direito e clicar em “Add auto-layout”, ou apertar o “Shift + A”, ou ir no canto e clicar no “+” no *auto-layout*. E ele transforma para mim nesse elemento que vamos entender um pouco.

[04:50] Primeira coisa, ele me diz qual a direção. Como eles já estavam posicionados lado a lado, ele criou a direção lateral, a direção horizontal. Caso eu clique na seta para baixo, ele muda para ficar um acima do outro, no caso eu quero lateral mesmo. Essa é a primeira propriedade *do auto-layout*.

[05:10] A segunda, é o espaço entre os itens. Eu posso aumentar muito, diminuir, o mínimo seria 0, ou então aumentar bastante. No caso, ele já veio com 8, porque quando eu selecionei, eles já estavam com espaço de 8 entre eles, então o *auto-layout* já calculou que esse era o correto. Então ele já criou para mim. Essa é a segunda propriedade.

[05:33] A terceira é o *padding*, que é uma borda invisível que criamos entre os elementos, no caso nem vamos usar, mas eu poderia colocar 16, você vai entender um pouco melhor, então ele cria uma borda de 16, que é o espaço entre o topo e o meu elemento, embaixo 16, para um lado 16 e para o outro lado 16 também.

[05:55] Vou dar um “Ctrl + Z”, porque eu não vou utilizar. E por fim, nós temos qual é a direção do meu elemento. Então eu posso levá-lo para o topo, levá-lo para o rodapé, levar para o meio, para o meio centralizado, para o topo, para baixo, para a direita centralizada, para o topo, direita rodapé.

[06:18] No nosso caso, vamos trabalhar com esquerda e centralizado. E por fim, também temos a opção do “Packed” ou “Space between”. Qual é a diferença? O “Packed” calcula o espaço entre as linhas. Se eu colocar “Space between”, o espaço entre as linhas fica automático e conforme eu aumento essa caixa, ele vai sempre jogando os elementos para os cantos. Então se eu tivesse mais um elemento, ele ia calcular exatamente os espaços para fazer um espaçamento padrão.

[06:51] Se eu for juntando, ele também junta, se eu for aumentando, ele vai aumentando. E outra coisa bem legal, não sei se você reparou, mas eu dupliquei, dei um “Ctrl + C” e “Ctrl + V”, e ele já foi calculando para mim automaticamente, isso é uma coisa muito poderosa do *auto-layout*, que vamos entender um pouco melhor mais para frente. Mas por enquanto eu vou deletar, e no caso, queremos “Packed”, com o espaço 8.

[07:15] Então nós já temos esse *frame* 1, que com o “Ctrl + G”, chamaríamos de “avatar”, eu posso colocar dessa forma, nesse caso. E temos os “Constraints”, que vamos ver um pouco melhor, mas eu posso selecionar esse “Hug contents”, significa que o tamanho do meu *auto-layout* vai ser exatamente o tamanho do conteúdo que ele tem. Então, ele não vai aumentar, não vai ter um tamanho maior, ele vai ter exatamente o tamanho do meu conteúdo, que é o nome e a imagem.

[07:50] Se selecionarmos esses elementos que estão dentro, podemos ver que essa imagem, eu posso ou colocar tamanho fixo, ou posso colocar o “fill container”, que significa que se eu aumento o meu *auto-layout*, essa minha imagem, vai ocupar o meu container, o nome já diz.

[08:13] Não queremos trabalhar com isso, vamos trabalhar fixo, porque a imagem sempre vai ter tamanho fixo. E o texto, podemos trabalhar com “fill container”, sim. Nós temos a opção do “hug contents”, ou seja, ele sempre vai ter o tamanho da minha caixa, do que está contido dentro dele, tamanho fixo, ou “fill container”. No caso, vamos trabalhar com “fill container”, e a minha caixa sempre vai ocupar todo o tamanho do meu *auto-layout* maior.

[08:39] Então, se eu diminuir, a minha caixa vai para a esquerda, se eu aumentar, você vê que a minha caixa vai até o final, então eu vou deixar a minha caixa do *auto-layout* ocupando as três colunas que já produzimos.

[08:54] Criamos o *auto-layout*, vimos o motivo de usarmos ele, qual é a vantagem de utilizá-lo, e agora podemos criar *auto-layouts* dentro de *auto-layouts*. Como fazemos isso? Podemos selecionar a minha imagem, por enquanto só o texto e o avatar, apertando “shift + A”, ou indo no “+” do *auto-layout*, eu clico, e ele já cria para mim a orientação vertical, porque já estava posicionado, espaço de 12, que já estava posicionado, nesse caso eu quero trabalhar com 8, e ele diminui um pouco para mim. Então eu tenho um *auto-layout* dentro de um outro *auto-layout*.

[Aula4_video4_imagem5]

[09:38] E podemos selecionar esse texto, selecionamos como “fill container”, significando, como aprendemos, que a minha caixa de texto vai respeitar o tamanho do meu container maior. Então se eu aumentar, ele aumenta também.

[09:55] E olha que interessante, você já reparou? Eu diminuí, ele já calculou essa frase, quebrou para ficar em 3 linhas, automaticamente esse meu avatar desceu, porque dessa forma estou automatizando tudo com *auto-layout*, então não preciso ficar recalculando de acordo com o número de linhas, não acontece mais isso.

[10:20] Estamos vendo que tem um problema, que podemos selecionar o avatar, “Fill container” nele também, o elemento dentro “Fill container”, o avatar está com “Fill container”, o texto está com “Fill container”, e eu posso pegar essa imagem, vamos jogar com as 3 colunas que eu estava trabalhando, vamos pegar essa imagem e arrastar para dentro de um *auto-layout*.

[10:44] Posso jogar no meio, abaixo ou no topo. Solto no topo, e ele criou para mim. Vamos selecionar a imagem, novamente “fill container”, vamos certificar que está tudo bem com “Fill container”, bem bonito, que dessa forma, se eu aumentar para 4 colunas, tudo se aumenta.

[11:05] Muito mais fácil de trabalhar. Se eu quiser duas colunas, uma coluna, exagerado, mas funciona.

[11:12] Porque trabalhamos essa automatização. Vou chamar de “Card”, onde eu tenho esse card, ontem um avatar, um texto e uma imagem. Bem interessante. E se eu quiser, por exemplo, a minha imagem não é o meu primeiro elemento que vai aparecer, na verdade, vai ser o texto. Como fazemos?

[11:33] Primeiro eu vou mostrar como faríamos se fosse um grupo. Vamos selecionar os elementos, vou jogar para fora, e vou dar um “Ctrl + G”, que seria um grupo.

[11:41] Agora eu quero que esse meu elemento seja o primeiro, o texto e depois a imagem. Eu vou ter que jogar o texto para cima, calcular exatamente esse espaço, no caso eu andaria 8, apertando a seta para cima, eu calculo os pixels, então eu apertei 8 vezes a seta para cima, ele andou 8 pixels. Quero dessa forma, mas agora eu quero os dois elementos, jogar para baixo, e fazer a mesma coisa, jogar 8 para baixo e pronto, consertei.

[12:17] No *auto-layout*, nós selecionamos o texto, seta para cima e ele já foi, seta para baixo e vai para baixo, enfim, eu vou selecionando o elemento que eu quero, clico na seta e ele já muda. Então é muito automatizado. E estamos vendo que podemos trabalhar um *auto-layout*, dentro dele tem um outro *layout*, e agora vamos fazer mais uma jogada.

[12:42] Vamos duplicar, vou jogar ao lado para ficar colado no meu *grid*, vou selecionar os dois cards, “Shift +A”, que já aprendemos que é o comando para criar *auto-layout*, vamos chamar de “Carrossel”, e ele já criou um *auto-layout*, em que tem dois *auto-layouts* dentro, e dentro deles tem um outro *auto-layout*.

[13:07] Muito poderosa essa ferramenta, em que vamos produzindo de forma muito automática. Vamos só então finalizar essa parte dos “carrosséis”, eu vou selecionar o texto e o “carrossel”, “Shift + A” de novo, vamos colocar 8 de espaço, vamos colocar um “fill container”, os dois podem ser “fixed width”, sem problemas, porque queremos que ocupe as 3 colunas mesmo, e eu vou chamar de “área”. Então já temos uma área criada, que é esse meu “carrossel” de *cards*.

[13:45] Espero que você tenha gostado desse vídeo, em que entendemos um pouco o início do *auto-layout* e eu te espero no próximo, em que vamos continuar criando mais *auto-layouts*, para entendermos como funciona essa metodologia e fazer o início de estudo da página inicial bem elaborado. Eu te vejo no próximo vídeo.