# Aula 04 - Colocando o projeto no ar

**Guilherme:** Adicionamos nosso código ao GitHub e ficou incrível. Porém ainda não conseguimos visualizar nossas páginas. Até existe um sistema ou outro que existe dentro do próprio GitHub, mas queremos mostrar o que acontece na realidade, e queremos distribuir para que outras pessoas tenham acesso.

Então nosso desafio e adicionarmos esse projeto a algum lugar onde outras pessoas tenham acesso.

**Rafaela:** Para que os amigos, amigas e mães de vocês, que queiram acessar esse projeto, até pelo celular, ou vocês, quando quiserem abrir o projeto no computador.

**Guilherme:** Queremos mostrar nosso projeto para o mundo, e qualquer pessoa que digitar um endereço consiga acessar a página.

**Rafaela:** Inclusive nós dois. Se vocês postarem e mandarem o link.

**Guilherme:** Conseguiremos acessar o projeto de vocês.

Pensando nisso utilizaremos um sistema de software muito conhecido, que é o ***Vercel***. Trata-se de uma plataforma americana de serviços de nuvem, com um nome muito diferente.

Quando buscamos "*vercel*", temos até uma sugestão de "Para que serve a vercel?" e, ao expandirmos, aparece uma breve explicação.

> Para que serve a vercel?
> 
> 
> > A Vercel é uma plataforma voltada para a hospedagem de aplicações de uma forma bem simples e rápida. Ela é conhecida por ser a empresa criadora do framework Next JS, voltado para o React. Entretanto, também é possível realizar o deploy de aplicações Nuxt nesta plataforma.
> > 

Então ela é uma plataforma usada para hospedagem de uma aplicação de uma forma simples e rápida.

**Rafaela:** Porque sempre precisamos de uma máquina rodando nosso código. Estamos fazendo isso hoje com a nossa máquina, criando o *live server*, e com isso conseguimos acessar nossa aplicação através do nosso computador.

Porém, para pessoas acessarem de outras máquinas, precisamos desses serviços de hospedagem, e a *Vercel* faz isso de uma forma gratuita e rápida, por isso vamos utilizá-la.

Então eu vou clicar no primeiro link para conseguirmos acessar a **[página da *Vercel*](https://vercel.com/)** e traduzi-la para o português. Nela também precisaremos criar uma conta, clicando em "Inscreva-se" no canto superior direito da página.

Com isso somos direcionados para outra página onde, na lateral direita tem três botões com opções de login: com **GitHub**, com o **GitLab** e com **Bitbucket**. Como acabamos de criar uma conta no GitHub, vamos utilizá-la para fazer o login.

Caso vocês estiverem conectados no GitHub, como eu, ele deve se conectar automaticamente. Do contrário, basta fazerem o processo de login novamente. Quando logamos, já temos a opção de "Importar repositório Git", na metade esquerda da tela.

Então queremos disponibilizar nosso projeto e já temos nosso código dentro de um repositório do Git, portanto está tudo perfeito para subirmos o nosso projeto. Para isso, entre as opções, basta clicarmos no primeiro botão, onde está escrito "Continuar com GitHub".

**Guilherme:** Feito isso, ele listará todos os repositórios que temos na nossa conta. O último é o "portfolio", então vamos clicar no botão "Importar", que fica no canto direito do nome do repositório na lista.

Em seguida, somos direcionados para outra página onde tem o nome do projeto e algumas outras informações. Esse nome do projeto é o nome que aparece na barra de endereços.

Como estamos usando a versão gratuita, aparecerá como "vercel.com/portfolio" ou "/agregador de links" ou "/links-da-joana-santos", por exemplo. Então podemos nomear como preferimos ou deixar o padrão mesmo, certo, Rafa?

**Rafaela:** Podemos, Gui. Depois vamos clicar no botão azul escrito "Implantar", após essas informações do projeto.

**Guilherme:** Nesse momento ele está fazendo todo o processo de pegar o código, criar um computador que tem os projetos rodando, como se fosse um "live server" eterno e, quando ele termina, aparece a mensagem "Parabéns! Você acabou de um novo projeto no Vercel".

**Rafaela:** Eu só preciso fazer uma observação: no passo anterior, ele informava algo relacionado à raiz, mas é um passo que sei que muitas pessoas podem ter dificuldade. Deixando claro, só vai ter problema se você subiu no repositório do GitHub a pasta com os projetos.

Você precisa, necessariamente, **subir somente os projetos**, porque eles precisam estar na **pasta raiz**. Se você sobe uma pasta, então no repositório terá uma pasta contendo os arquivos, vocês podem ter um problema no Vercel, então cuidado com isso.

**Guilherme:** Isso vai de encontro com o passo que fizemos de deixarmos tanto o `index.html` quanto o `about.html` fora de qualquer pasta, já os arquivos de `style.css` e de *assets* dentro de uma pasta. Nós recomendamos que vocês tenham feito esse passo junto conosco.

**Rafaela:** Os arquivos HTML precisam estar por fora mesmo.

Vamos continuar. Nós acabamos de implantar o projeto e quando clicamos no preview dele que aparece abaixo da mensagem de parabéns, ele abre em uma nova página.

**Guilherme:** Nosso projeto está rodando e qualquer pessoa do planeta que escrever na barra de endereços "portfolio-git-rho-75.vercel.app" vai acessar nosso projeto.

**Rafaela:** Olha que sensacional! Vamos fazer isso do celular, Gui?

**Guilherme:** Vamos. Vou pegar meu celular agora e vou colocar esse endereço.

**Rafaela:** Sensacional! Apareceu no meu celular e no do Gui e quando clicamos no "Sobre mim" a página muda. E nosso design está adaptado para as duas telas, porque tomamos bastante cuidado com isso no CSS.

Na Home, quando clicamos no botão do "GitHub", também já vai acessar no GitHub. Está tudo funcional no nosso projeto.