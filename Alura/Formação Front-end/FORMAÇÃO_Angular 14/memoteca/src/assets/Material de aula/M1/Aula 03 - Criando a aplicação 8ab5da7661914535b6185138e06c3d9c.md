# Aula 03 - Criando a aplicação

Você sabe o que as aplicações *Forms*, *Gmail* e *Paypal* têm em comum? Elas foram desenvolvidas com *Angular*! Já dá para perceber como este *framework* é poderoso. Ao longo desse curso iremos entender os motivos que fazem o *Angular* ser tão utilizado em aplicações pelo mundo todo.

Para iniciar o desenvolvimento do projeto, baixaremos uma ferramenta chamada *Angular CLI*. Ela é a interface da linha de comando do *Angular*. Então, ao invés de criarmos a infraestrutura inicial manualmente, o que demandaria bastante tempo e trabalho, com algumas linhas de comandos simples no terminal criaremos o nosso projeto e partiremos para o desenvolvimento.

Para instalar a ferramenta, precisaremos ter o *NodeJS* já instalado na máquina. Para verificar se o programa está instalado, abriremos o prompt de comando do computador, digitaremos `node -v` e depois a tecla "Enter". Se o programa estiver instalado, o prompt devolverá o número da versão.

Após esse procedimento, acessaremos o site da documentação do *Angular* através do endereço web "angular.io/cli", e na seção "**Instaling Angular CLI**" copiaremos o comando `npm install -g @angular/cli`, que será responsável por instalar a ferramenta.

Dentro do prompt, colaremos o comando de instalação e digitaremos "Enter". Para confirmar a instalação e verificar a versão do programa, digitaremos o comando `ng version`e apertaremos "Enter" novamente. Saberemos que a instalação foi bem sucedida se for possível visualizar o nome *Angular CLI* em vermelho e logo abaixo a sua versão. **A versão mais recente do *Angular CLI* no momento em que este curso foi gravado era a versão 14.0.3**.

Agora que temos essa ferramenta, voltaremos ao site "angular.io/cli", onde encontraremos o comando para criar um novo projeto: `ng new`. Voltando ao prompt, digitaremos `ng new` e logo em seguida o nome do projeto, que no nosso caso será `memoteca`. Depois, apertaremos "Enter", e em seguida o *Angular CLI* já vai baixar todos os arquivos necessários para iniciarmos o projeto.

```
ng new memoteca
```

Antes de finalizar a instalação, o *Angular CLI* vai devolver algumas perguntas no terminal.

A primeira nos questiona se queremos adicionar o arquivo de rotas ("Angular routing", no original). Nós vamos utilizar esse arquivo no nosso projeto, portanto responderemos que "sim", digitando a letra "y" e depois "Enter".

Já a segunda pergunta nos questiona qual estilo ("stylesheet", no original) utilizaremos no nosso projeto. Podemos navegar com as setinhas "cima" e "baixo" do teclado para escolher entre CSS, SCSS, Sass e Less. Para este trabalho, escolheremos o CSS e apertaremos "Enter".

Nosso projeto já foi criado. Agora entraremos no projeto com o comando `cd memoteca`. Em seguida, vamos inicializar o projeto com `ng serve`.

Pronto! Nosso projeto está criado e inicializado, e podemos conferir na tela qual o nome da porta padrão, que neste caso é "localhost:4200/". Abriremos o projeto digitando o endereço da porta padrão no campo de pesquisa na parte superior do nosso navegador.

Ao darmos "Enter" podemos ver a mensagem "memoteca app is running!". Essa é a carinha inicial de um projeto *Angular*! Agora que temos um projeto criado e sendo executado, eu te espero a seguir para entendermos a estrutura de um projeto *Angular* e saber por onde começar.