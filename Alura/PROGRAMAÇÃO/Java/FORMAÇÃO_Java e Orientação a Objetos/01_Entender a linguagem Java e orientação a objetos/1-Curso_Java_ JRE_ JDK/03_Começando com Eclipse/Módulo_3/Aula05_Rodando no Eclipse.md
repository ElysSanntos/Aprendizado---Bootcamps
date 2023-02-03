# Aula 05 - Nosso programa rodando no Eclipse

Vamos colocar o código do programa no Eclipse, utilizando o editor mais poderoso, o ***IDE***. Para isto, há várias opções: acessando "File > New > Class", ou clicando com o lado direito do mouse em "src" e selecionando "New > Class", o que abrirá um *wizard* mas, como dito anteriormente, focaremos mais no código em si do que nas "mágicas" que os editores fazem para nós.

O nome desta classe será "Programa", porém não se preocupe ainda com as diversas opções que aparecem nesta janela. Há até um checkbox para o caso de querermos `public static void main(String[] args)`, o que não é o caso, pois por ora queremos praticar bastante e escrever um código básico.

Clicando-se em "Finish", teremos o programa simples que escrevemos antes:

```
public class Programa {

    public static void main(String[] args){

        System.out.println("ola mundo");
    }
}COPIAR CÓDIGO
```

Conforme vamos digitando o código, o programa vai tentando completar, para nos ajudar. Na lateral esquerda, a bolinha vermelha com "**`x`**" indica erro de compilação em determinadas linhas.

> O asterisco (*) ao lado do nome do arquivo indica que ele não foi salvo!
> 

Para executarmos o código, basta acessarmos "Run > Run As > Java Application", o que abre uma *view* para Console, que abre e executa, no caso, o `javaw.exe`, uma versão do Java que não abre no Prompt do MS-DOS, utilizado internamente pelo Eclipse para chamar o nosso programa, que é o que gostaríamos de fazer neste ambiente.

Por enquanto, não há tantas vantagens em relação ao Notepad, e não é à toa que a Microsoft, quando lançou o Visual Studio, foi atrás dos recursos apresentados pelo Eclipse, com o *ReSharper*, contratando o Erich Gamma, autor de *Design Patterns: Elements of Reusable Object-Oriented Software*, para trabalhar com o IDE deles. O Eclipse foi uma inspiração para muitos, e é considerado uma ferramenta incrível.

Mas onde se encontra o "Programa.class", o *bytecode* que a *virtual machine* entende?

O "Package Explorer", que é uma *view*, esconde arquivos e diretórios que julga não serem relevantes. E faz sentido, pois no momento estamos focados no programa Java. Acessando-se "Window > Show View > Navigator", ele irá mostrar o *File System*.

Clicando em "sintaxe-basica" para abri-lo, além do "src", existem outros diretórios e arquivos, dentre os quais "Programa.class" na pasta "bin". ".classpath" e ".project" são arquivos de configuração utilizados pelo Eclipse para obter informações sobre seu projeto. Eles não devem ser editados diretamente e, clicando-se na aba "Source" na parte inferior da interface, você verá que trata-se de um `.xml`.

Não precisaremos nos preocupar com estes arquivos, pois é muito raro termos que mexer neles. Há muito tempo, só existia esta *view*, o "Navigator" (similar ao Windows Explorer). O "Package Explorer" surgiu para ajudar quem trabalha com Java, e o "Navigator", para quem trabalha com tudo, de forma geral. Na maioria das vezes, usaremos o "Package Explorer".

Se clicarmos em "src > Programa.java" com o lado direito do mouse, e em seguida em "Properties", veremos a localização exata do arquivo, possível de ser confirmado por meio do Prompt de Comando.

A partir de agora deixaremos de utilizar o prompt, pois faremos tudo no Eclipse. De qualquer forma, é importante lembrarmos que o Java pode ser usado por linhas de comando, se você preferir, o que acaba sendo até necessário em alguns casos.