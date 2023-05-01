# Aula 04 - Fechando as heurísticas

Estamos de volta para continuar falando sobre as heurísticas de Nielsen. A próxima que vamos comentar é a sexta, que é o reconhecimento ao invés de memorização. Isso significa que é muito melhor utilizarmos padrões para as pessoas que estão utilizando essa plataforma que elas já conheçam, que elas reconheçam, como diz a palavra, de outros locais, ao invés de sempre ter que entrar na minha plataforma e tentar lembrar o que significa isso que ela está olhando.

[00:28] Um exemplo perfeito para entendermos, é a lupa, a lupa de pesquisa significa, como eu mesmo já falei, significa pesquisa. E não fui eu que inventei isso, isso é algo que as pessoas reconhecem, porque em todas as plataformas que utilizamos, a lupa significa pesquisa, então é algo que é reconhecido facilmente e simboliza isso.

[00:52] Dessa forma, se eu colocasse um outro elemento, um óculos, por exemplo, a pessoa ia ter que lembrar toda vez que entrasse na minha plataforma, que óculos significa pesquisa, porque a minha plataforma é a única que utiliza esse ícone. Então, é melhor utilizarmos ícones ou elementos no total, que sejam reconhecidos de outros locais, que não seja algo exclusivo da minha plataforma.

[01:17] Flexibilidade e eficiência de uso é algo que não tem tanto na nossa plataforma, vou falar um pouco sobre o que é isso. Mas é que temos que pensar que a nossa plataforma vai ser utilizada tanto pela pessoa mais leiga quanto pela pessoa mais experiente, então podemos dar atalhos e caminhos diferentes, que vão para o mesmo local, para esses dois tipos de público. Isso se aplica mais em ferramentas, não é tanto o caso da nossa plataforma, porque é um blog, não é uma ferramenta de trabalho.

[01:51] Podemos usar como exemplo o Figma mesmo, para entendermos. Por exemplo, se eu quiser criar um retângulo, eu posso clicar no retângulo, e criar um, posso ir no ícone de arquivo, “objeto”, e criar um retângulo, não sei se dá para fazer isso, mas poderia, ou eu posso apertar o “R”. Então eu tenho caminhos diferentes para realizar a mesma ação. E isso contempla usuários mais leigos e usuários mais experientes. Então é assim que trabalhamos com a flexibilidade e eficiência de uso.

[02:31] A oitava heurística é a estética e design minimalista. Isso significa que as pessoas que estão utilizando a nossa plataforma não estão muito interessadas no design do botão, no degradê do botão, elas não querem saber muito dessas questões estéticas, elas querem saber se funciona ou não.

[02:52] E o minimalismo é o nosso maior aliado para conseguirmos conduzir essa pessoa que está utilizando a nossa plataforma a realizar as ações facilmente. Então, por exemplo, a pessoa que for entrar na página inicial, vai dar logo de cara com a busca, com o artigo para ela clicar, com a pessoa para ela seguir, e isso é conduzido através do minimalismo. Dessa forma, tiramos o foco tanto na experiência estética, e damos mais o foco em ações importantes, o que a pessoa gostaria de fazer. Assim conduzimos a atenção da pessoa que está utilizando esse produto.

[03:30] Pensa no Google novamente, olha como é o site do Google, quer mais minimalista que isso? É apenas o logo, uma caixa de texto e dois botões. Fora isso, tem alguns elementos periféricos, mas o foco principal é a barra de busca. E como o Google faz isso? Utilizando design minimalista. O Google é um ótimo exemplo, porque ele é muito fácil de ser utilizado e ele utiliza o minimalismo a seu favor.

[03:57] O outro que eu vou comentar é sobre o reconhecimento de erros, que ele é um pouco parecido com a prevenção, só que a prevenção é antes do erro acontecer de fato, e o reconhecimento é posterior a isso. Então podemos dizer que na página de login, pode ter sido uma prevenção, porque eu não cheguei a avançar, mas é posterior, porque eu já estou quase terminando, e não inseri o “@”, então ele já está me dizendo que o “@” é necessário nesse local.

[04:29] Uma outra área que poderíamos incluir também é no resultado de busca. Então, se eu digitar uma busca que não acha nenhum artigo, o que vai aparecer? Então seria também um reconhecimento de erro. Podemos criar a tela rapidamente, para isso, vamos duplicar o resultado da busca, e vamos digitar um texto qualquer, que a pessoa digitou e não conseguiu encontrar nenhum resultado.

[04:55] Vamos pegar a lupa, eu vou colar na nova página. Vamos deletar esse vetor e vamos criar esse *auto-layout*. E então vamos colocar 48x48, e vamos centralizar esse elemento da lupa, e vamos colocar uma borda super arredondada. E nesse preenchimento vamos colocar um fundo azul. Só para ter uma ilustração.

[05:44] Vamos copiar o texto “Resultado da busca”, vou colar, e vamos dizer “Não encontramos nenhum artigo com esse termo”, vamos centralizar esse elemento, e dizer “Por favor, tente novamente”.

[06:12] Um texto comum. E vamos selecionar esses 3 elementos, “Shift + A”, vamos centralizá-los, vamos deixar “Fixed width” por enquanto, e vamos deixar 16, vamos chamar de “conteúdo”, e vamos colocar dentro desse elemento, em que podemos colocar um “Fill container”, e ele está centralizando tudo para mim.

[06:48] Essa página vai ter 640 de altura, que é o tamanho de um Android mesmo, e vamos colocar o espaçamento 160, para ficar um pouco mais no meio da página. Então já temos o resultado de uma busca errada.

[07:10] Então esse é o reconhecimento de erros. Eu fiz uma busca que não deu resultados e a plataforma me mostrou que não encontrou nada com esse termo. Então já incluímos mais uma tela para o nosso projeto. E por último, vamos falar da ajuda e documentação.

[07:27] É muito importante mostrarmos para a pessoa que está utilizando, alguma saída caso ela precise de ajuda. Nesse caso, não estamos trazendo nada também, então vamos incluir. Então, podemos incluir um ícone que seja de ajuda, que se a pessoa clicar, ela pode ir para uma página externa, em que vai ter aquelas perguntas mais frequentes e respostas, ou então direcionar para algum chat externo da plataforma. Dessa forma, damos uma ajuda para essa pessoa que está utilizando.

[07:58] Eu já tenho o meu Google Fonts aberto com os ícones, se eu digitar “help”, eu vou baixar o ícone de “help” e vamos jogar no nosso projeto. Está dentro do meu elemento, vou colocar na nossa cor, e então criamos também uma área, um atalho para ajuda, caso essa pessoa esteja perdida na plataforma.

[08:27] Espero que você tenha gostado desse vídeo, em que finalizamos a parte das heurísticas. Nós já vimos todas as 10 heurísticas. No próximo vídeo, vamos pegar isso tudo que criamos e começar a prototipar. Vai ser um vídeo bem legal e eu espero você lá.