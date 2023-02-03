# Aula 02 - Instalação do JDK no Windows

Vamos instalar o Java e tudo aquilo de que precisamos para começarmos a trabalhar! Usando o Windows, iremos fazer uma busca no Google por "Java" para ver as opções fornecidas para download.

Um dos primeiros resultados mostrados é o [java.com](http://www.java.com/), com uma aparência um tanto ultrapassada, e o botão "Download Gratuito do Java", em português ou inglês. Indo por este caminho, você perceberá que baixará uma versão que costumamos usar para **rodar uma aplicação Java**.

Para nós, desenvolvedores, baixar isto não é o suficiente. A versão recomendada que aparece na página de download, no caso "Version 8 Update 121", é o que chamamos de ***Java Runtime Environment***, ou "ambiente de execução Java", que é necessário para **executar uma aplicação Java**.

Lembra da época dos *applets*, em que precisávamos instalar plugins e similares para serem rodados no browser, ou em aplicativos? É para estes casos que a instalação desse ambiente de execução serve, o tal do **JRE**, que vem com a *virtual machine* e as bibliotecas.

Como desenvolvedores, precisaremos do **JDK**, ou ***Java Development Kits***, o "kit para desenvolver aplicações Java".

Pesquisando no Google por "download java jdk" ou simplesmente "jdk", aí sim, cairemos em um link mais específico, como no da ***Oracle***, com diversas opções. Queremos a versão `8`, ou outra mais recente.

Na descrição, lê-se "8u112", por exemplo, em que "u" indica "*update*", ou "atualização" em português, que tem a ver com correção de *bugs*. Nesta página, estão disponíveis para download o JDK, bem como o JRE, visto no link anterior.

A opção que queremos baixar trará, além da *virtual machine* e das bibliotecas, o compilador, que pegará o código Java e o transformará em um formato que ele entenderá. Vamos fazer o download do JDK de acordo com o sistema operacional - no Mac ou no Linux pode ser que já venha instalado, ou seja mais fácil de se baixar.

Neste caso, optaremos por `jdk-8u121-windows-x64.exe`, não esquecendo de aceitar os termos da Oracle. Terminado o download, abriremos o arquivo executável, a ser salvo em um diretório apropriado seguindo os passos de instalação no modo *default*.

O JDK, o compilador, nada mais é do que uma versão menor daquilo que existe no site [java.com](http://www.java.com/), **mais** as ferramentas para o desenvolvimento de aplicações Java. Em seguida, continuaremos instalando o JRE, com a *virtual machine* e tudo o mais que é necessário para rodar esta aplicação.

Confirmaremos a instalação acessando o prompt do MS-DOS, que é algo muito similar ao terminal do Linux, Bash, Shell, e do Mac. O PowerShell da Microsoft hoje em dia é mais raro, mas ainda existe. Não se preocupe, muito em breve estaremos utilizando uma IDE, o Eclipse. Neste momento, porém, queremos enxergar o que está "por trás".

Pode-se pesquisar por "cmd" para acessar o prompt, uma tela preta em que digitaremos comandos, sendo o primeiro deles aquele que chamará o Java, `java`, seguido da tecla "Enter". Ele retorna uma mensagem dizendo para usarmos um `class`, porém ainda veremos sobre.

O comando que usaremos em seguida será `javac`, de *java compiler*, o compilador que pegará o código em Java e "traduzirá" para o que a *virtual machine* entende. Porém, ao digitarmos isso, obteremos o seguinte:

```
'javac' não é reconhecido como um comando interno ou externo, um programa operável ou um arquivo em lotes.COPIAR CÓDIGO
```

Você deve estar se perguntando o que aconteceu, já que o JDK foi instalado, e é verdade, ele deveria ser executável. O que acontece é que ele está em outro local, e por isto não está sendo encontrado.

Abrindo o explorador de arquivos, em `C:`, "Arquivos de Programas" contém a pasta "Java", que por sua vez possui dois diretórios referentes a JRE (onde se encontra a *virtual machine*) e JDK (onde está o compilador). Por *default* de instalação, a Oracle modifica os arquivos de configuração do Windows e deixa apenas o Java do JRE pronto para ser chamado em linha de comando.

Se você for usar o Java em linha de comando, como não é tão raro de acontecer, precisaremos do "jdk1.8.0_121", dentro do qual há, em "bin" (de "binário"), o arquivo `javac.exe`. Vamos selecionar o caminho do diretório onde se encontra este executável, e copiá-lo por meio do atalho "Ctrl + C" e, no Painel de Controle, informaremos ao Windows para que toda vez que inserirmos algum comando, o caminho abaixo seja consultado também:

```
C:\Program Files\Java\jdk1.8.0_121\binCOPIAR CÓDIGO
```

No Painel de Controle, portanto, selecionaremos "Sistema > Configurações avançadas do sistema" e, na nova janela, clicaremos em "Variáveis de Ambiente...", utilizável por programas como se fossem variáveis globais do Windows.

Veremos no box abaixo de "Variáveis do sistema" o "Path". Clicaremos em "Editar..." e observaremos todos os seus componentes. Queremos incluir mais um diretório nele, portanto clicaremos em "Novo" e usaremos o atalho "Ctrl + V" para colar o caminho que copiamos anteriormente. Selecionaremos "OK" em todas as janelas que ficaram abertas.

Teremos que reabrir o Prompt de Comando, após o qual digitaremos `javac`, que desta vez funcionará corretamente! Quando se instala uma nova linguagem de programação, é comum que a variável de ambiente seja alterada para que não haja necessidade de criarmos arquivos ou entrarmos em diretórios específicos para trabalhar.

A partir deste momento, então, temos não só o Java, mas o JDK, o Kit de Desenvolvimento do Java, instalado e configurado no Windows, tanto para execução quanto para compilação de uma aplicação Java!