# Aula 01 - Instalando o Eclipse

Por enquanto, temos o nosso primeiro programa Java escrito, e agora passaremos a entender como declarar variáveis, fazer `if`, laços e afins. Queremos um editor um pouco melhor do que o bloco de notas, de acordo com sua preferência.

A comunidade geral do Java costuma usar não um editor, mas um IDE (*Integrated Development Environment*, que em português seria algo como "Ambiente Integrado de Desenvolvimento"). Um IDE não é simplesmente um editor pois integra em um único local a linguagem, o editor, o compilador, a biblioteca e a documentação.

Os principais IDEs utilizados por quem programa em Java são: o ***NetBeans***, da própria Oracle, o ***IntelliJ IDEA***, usado como base para Android, e também conhecido por *Android Studio*, e o ***Eclipse***, projeto em código aberto absorvido pela IBM e, hoje em dia, um consórcio de muitas empresas que tomam conta do programa, que você pode baixar [aqui](https://www.eclipse.org/downloads).

O Eclipse quer te ajudar na hora de codificar, muito mais do que focar em *wizards* e na grande quantidade de opções de menu. À primeira vista, o IDE pode parecer pequeno demais (pelo peso que possui), mas é porque há muitos plugins instaláveis para se facilitar o desenvolvimento de *features* e recursos.

Quando formos instalá-lo, aparecerá uma janela perguntando o que queremos, e escolheremos "Eclipse IDE for Java Developers". A opção "Eclipse IDE for Java EE Developers" requer um conhecimento maior, e serve para desenvolvimento de aplicativos web e softwares, e poderá ser explorada futuramente.

Após instalação e durante a execução, a primeira pergunta que o Eclipse fará tem a ver com o *workspace*, o diretório a ser utilizado para guardar todos os projetos Java. Isto pode ficar a seu critério, lembrando que iremos trabalhar sempre no Eclipse, então isso acabará não sendo tão relevante, pois você não precisará mais do Prompt de Comando para acessá-lo.

> É possível ter mais do que um workspace, um só para exercícios da Alura e outros para projetos da empresa, por exemplo.
> 

A primeira execução trará muitas janelas diferentes, mesmo se fecharmos o "Help". Vamos maximizar o Eclipse e fechar a aba "Welcome".

O IDE, ao ser aberto, pode te assustar um pouco, mas você verá que assusta menos do que outros com muito mais janelas e perguntas de *wizards*. No centro, ficam os arquivos que queremos editar, do lado direito estão os "Task List" (Lista de Tarefas), embaixo, "Problems" (Problemas). À esquerda, há "Package Explorer" (Explorador de pacotes).

O Eclipse denomina este conjunto de janelas de **perspectiva**, e cada uma delas é uma ***view***. Então, veremos diversas *views* que irão nos ajudar em diferentes situações, tanto que se clicarmos em "Window > Show View" no menu superior, há várias opções. Não nos preocuparemos com isso agora.

No momento, queremos criar um projeto Java, e veremos poucos *wizards*! Para criarmos um projeto e uma classe Java, clicaremos em "File > New > Java Project" e, na nova janela, definiremos o projeto como "sintaxe-basica".

Provavelmente o Java já está instalado em seu computador; verifique sua versão, se é `8` ou posterior, pois utilizaremos recursos desta versão. Clicando em "Finish", o projeto é criado e aparecerá em "Package Explorer", contendo um diretório "src" (onde deve estar nosso código fonte), e "JRE System Library", uma biblioteca com tudo que temos e acessível pelo Java. Todos os comandos que utilizaremos estará nestes arquivos `.jar`.

Agora, queremos colocar nosso arquivo Java, o "Programa.class", no diretório de código fonte.