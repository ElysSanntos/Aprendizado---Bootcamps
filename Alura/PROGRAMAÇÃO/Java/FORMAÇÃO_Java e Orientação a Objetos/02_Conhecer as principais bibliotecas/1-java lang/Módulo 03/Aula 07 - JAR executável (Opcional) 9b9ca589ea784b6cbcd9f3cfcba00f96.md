# Aula 07 - JAR executável (Opcional)

Nesta aula, iremos nos aprofundar na questão das bibliotecas jar.

A forma como criamos um arquivo jar em nosso projeto será a mais comum quando utilizamos esse recurso.

Há na internet alguns repositórios de ".jar" que podem ser baixados; existem, ainda, ferramentas que podem nos auxiliar na plena utilização de ".jar", como quantas bibliotecas deste tipo precisaremos em um determinado projeto.

Há, também, ferramentas que ajudam a gerenciar as dependências que uma biblioteca ".jar" pode vir a ter, como Maven; na Alura temos [um curso](https://cursos.alura.com.br/course/maven-build-do-zero-a-web) dedicado a esta ferramenta. Quem utiliza o .NET sabe o que o Visual Studio possui um gerenciador de dependências integrado, o que não ocorre com o Eclipse.

No entanto, existem outras possíveis aplicações para a o ".jar". Na Alura, temos uma série de pastas com o nome dos professores e seus respectivos cursos. Juntamente com estas pastas temos o um arquivo ".jar" chamado `revisor-beta.jar`. Este ".jar" não foi pensado para ser uma biblioteca e ser usado através do desenvolvedor, mas sim uma ferramenta disponível para que os instrutores possam executar códigos e revisar a nomenclatura dos vídeos. Ou seja, este ".jar" foi pensado para o **usuário final** e não para o desenvolvedor.

Veremos rapidamente como esse ".jar" voltado para o usuário funciona; primeiramente, acessaremos o terminal e buscaremos por `revisor-beta.jar`

```
Last login: Fri Mar 9 11:01:12 on console
Aluras - iMac:~ alura$ cd /Volumes/Dados_MAC/
Aluras - iMac: DADOS_MAC alura$ 1s
danilo-maximo     flavio-almeida      nico steppat
fabio-chaves      leonardo-codeiro    revisor-beta.jar
Aluras-iMac:DADOS_MAC alura$COPIAR CÓDIGO
```

Para que possamos executar o ".jar", precisamos utilizar a máquina virtual. Não iremos copiar esse ".jar" e cola-lo no Eclipse, pois trata-se de uma aplicativo para o usuário final.

```
Last login: Fri Mar 9 11:01:12 on console
Aluras - iMac:~ alura$ cd /Volumes/Dados_MAC/
Aluras - iMac: DADOS_MAC alura$ 1s
danilo-maximo     flavio-almeida      nico steppat
fabio-chaves      leonardo-codeiro    revisor-beta.jar
Aluras-iMac:DADOS_MAC alura$ java -jar revistor-beta.jar
COPIAR CÓDIGO
```

Ao executarmos o ".jar", percebam que há uma interface gráfica, portanto existem classes no mundo Java que possibilitam a construção de uma caixa de diálogo com botões.

![https://s3.amazonaws.com/caelum-online-public/843-java-packages/03/3_3_26_interface+jar.png](https://s3.amazonaws.com/caelum-online-public/843-java-packages/03/3_3_26_interface+jar.png)

Faremos algo parecido para a nossa aplicação. Não criaremos uma janela com botões, pois isso demandaria outro curso que se articule, mas criaremos um ".jar" que possa ser executado.

De volta ao Eclipse, abriremos novamente o projeto `bytebank-herdado-conta` e novamente criaremos um ".jar", mas desse vez com uma finalidade diferente: a aplicação utilizada pelo cliente.

Com o projeto `bytebank-herdado-conta` selecionado, pressionaremos o botão direito e escolheremos a opção "Export". Na caixa de diálogo aberta, selecionaremos o `JAR file` dentro da pasta `Java`.

![https://s3.amazonaws.com/caelum-online-public/843-java-packages/03/3_3_27_jar+file.png](https://s3.amazonaws.com/caelum-online-public/843-java-packages/03/3_3_27_jar+file.png)

Como já sabemos, não iremos exportar os arquivos de configuração do Eclipse. Selecionaremos a pasta `src` e os três pacotes. A documentação (`doc`) também não será exportada. Modificaremos o nome do arquivo ".jar" para `bytebank-1.0-executavel`.

![https://s3.amazonaws.com/caelum-online-public/843-java-packages/03/3_3_28_configuracoes+de+exportacao+do+arquivo+jar.png](https://s3.amazonaws.com/caelum-online-public/843-java-packages/03/3_3_28_configuracoes+de+exportacao+do+arquivo+jar.png)

Assim feito, pressionaremos o botão "Next" para prosseguirmos com as configurações de exportação.

Veremos uma nova caixa de diálogo que apresenta opções a serem selecionadas, são eles "Export class files with compile errors" e "Export class files with compile warnings". As duas opções devem ser selecionadas, pressionaremos "Next".

![https://s3.amazonaws.com/caelum-online-public/843-java-packages/03/3_3_29_nova+caixa+de+dialgo+jar.png](https://s3.amazonaws.com/caelum-online-public/843-java-packages/03/3_3_29_nova+caixa+de+dialgo+jar.png)

Na próxima caixa de diálogo, veremos que na parte inferior existe o campo "Select the class of the application entry point". Nós deveríamos direcionar a entrada da aplicação; qualquer aplicação Java sendo executada mediante um ".jar" se inicia por um método `main()`, e esse método está dentro de uma classe, portanto precisamos definir de alguma forma qual será nossa classe inicial a ser enxergada pela máquina virtual como *entry point*.

Selecionaremos o botão "Browse" e serão exibidas as três classes que possuem o método `main()` no projeto, são elas `TesteContas`, `TesteSaca` e `TesteTributaveis`. Selecionaremos `TesteContas`, pois essa classe contem o `System.out.println()`, o que significa que teremos uma saída para verificar se a execução da aplicação funcionou.

![https://s3.amazonaws.com/caelum-online-public/843-java-packages/03/3_3_30_classes+que+contem+o+main.png](https://s3.amazonaws.com/caelum-online-public/843-java-packages/03/3_3_30_classes+que+contem+o+main.png)

A entrada da aplicação ou *entry point*, portanto, passou a ser `br.com.bytebank.baco.test.TesteContas`.

Para executarmos o arquivo ".jar" `bytebank-1.0-executavel`, iremos até o terminal e acionaremos o comando `java -jar`.

```
Last login: Fri Mar 9 11:01:12 on console
Aluras - iMac:~ alura$ cd /Volumes/Dados_MAC/
Aluras - iMac: DADOS_MAC alura$ 1s
danilo-maximo     flavio-almeida      nico steppat
fabio-chaves      leonardo-codeiro    revisor-beta.jar
Aluras-iMac:DADOS_MAC alura$ java -jar revistor-beta.jar
Alura -iMac:DADDOS_MAC alura$ cd
Alura- iMac: alura$ pwd
/Users/alura
Aluras-iMac:~ alura$ cd Desktop/
Aluras-iMac: Desktop alura$ 1s
Screen Shot 20-03-09 at 13-40-20-png desktop
bytebank-1.0-executavel.jar
Aluras-iMac:Desktop alura$ java -jar bytebank-1.0-executavel.jar
COPIAR CÓDIGO
```

Dentro do ".jar" existe uma configuração que se comunica com a máquina virtual indicado que a classe `TesteContas` contém o método `main()`. Ao executarmos o ".jar", perceberemos que não existe uma janela de diálogo com botões, pois não desenvolvemos nenhum tipo de interface gráfica. São exibidos apenas os valores de saída da console.

```
CC:89.0CP:210.0COPIAR CÓDIGO
```

São os mesmos valores exibidos pelo Eclipse na linha de comando quando executamos a classe `TesteConta`.

Com isso, provamos que é possível criar um ".jar" voltado para o usuário final.

Faremos um pequeno teste: Transferiremos o arquivo ".jar" que acabamos de gerar (`bytebank-1.0-executavel`) para o projeto `bytebank-biblioteca`, na pasta `libs`.

![https://s3.amazonaws.com/caelum-online-public/843-java-packages/03/3_3_31_jar+como+biblioteca.png](https://s3.amazonaws.com/caelum-online-public/843-java-packages/03/3_3_31_jar+como+biblioteca.png)

Feito isso, selecionaremos o ".jar" e pressionaremos o botão direito e escolheremos as opções "Build Path > Add to Build Path", ou seja, adicionaremos esse ".jar" como se fosse uma biblioteca.

Ao abrirmos o arquivo, veremos os pacotes do projeto como o esperado, no entanto há uma pasta `META-INF`, uma pasta de configuração que contém um arquivo denominado `MANIFES.MF`.

Dentro desse arquivo há um conteúdo muito simples, contém a versão do arquivo e seu `main` class.

```
Manifest-Version: 1.0Main-Class: br.com.bytebank.banco.test.TesteContasCOPIAR CÓDIGO
```

Vemos como seria um ".jar" executável, que apresenta algumas diferenças. Nas próximas aulas falaremos de outras bibliotecas padrão do mundo Java.