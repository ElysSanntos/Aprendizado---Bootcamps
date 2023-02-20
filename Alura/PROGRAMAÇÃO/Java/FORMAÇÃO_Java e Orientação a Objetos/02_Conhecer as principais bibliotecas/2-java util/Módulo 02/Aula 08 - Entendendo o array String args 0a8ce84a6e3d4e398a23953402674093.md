# Aula 08 - Entendendo o array String args

Olá! Nesta aula daremos continuidade à explicação sobre o `String[]`:

```
//Código omitido, pacote e imports

public class TestArrayReferencias {

        public static void main(String[] args) {

//Código omitidoCOPIAR CÓDIGO
```

Criaremos uma nova classe, chamada `TestArrayString`:

```
package br.com.bytebank.banco.test;

import br.com.bytebank.banco.modelo.Cliente;

public class TestArrayString {

        public static void main(String[] args) {

        }
}COPIAR CÓDIGO
```

Como sabemos, é possível executarmos uma aplicação Java no terminal. Lá, utilizamos a máquina virtual (JVM), seguido do nome da classe, para que possamos executá-la. Mas primeiro, é preciso acessarmos a pasta do Eclipse, digitando o comando `cd eclipse-workspace/`, assim serão listadas todas as pastas onde são guardados os projetos:

```
Aluras-iMac:~alura$ cd eclipse-workspace/Aluras-iMac:eclipse-workspace alura$ ls
bytebank-biblioteca  bytebank-herdado  java-pilha
bytebank-encapsulado  bytebank-herdado-conta  java-stack
Aluras-iMac:eclipse-workspace alura$COPIAR CÓDIGO
```

E como podemos ver, temos o nosso `bytebank-herdado-conta`. Acessaremos esta pasta, digitando o comando `cd bytebank-herdado-conta/`:

```
Aluras-iMac:~alura$ cd eclipse-workspace/Aluras-iMac:eclipse-workspace alura$ ls
bytebank-biblioteca  bytebank-herdado  java-pilha
bytebank-encapsulado  bytebank-herdado-conta  java-stack
Aluras-iMac:eclipse-workspace alura$ cd bytebank-herdado-conta/Aluras-iMac:bytebank-herdado-conta alura$COPIAR CÓDIGO
```

As classes compiladas, por sua vez, estão na pasta `bin`:

```
Aluras-iMac:bytebank-herdado-conta alura$ ls
bin   doc   src
Aluras-iMac:bytebanks-herdado-conta alura$ cd binCOPIAR CÓDIGO
```

Temos o código fonte na pasta `src`, e o Eclipse gera automaticamente a pasta `bin`. Além disso, temos também a pasta `br`:

```
Aluras-iMac:bytebank-herdado-conta alura$ ls
bin   doc   src
Aluras-iMac:bytebanks-herdado-conta alura$ cd bin
Aluras-iMac:bin alura$ ls
brCOPIAR CÓDIGO
```

Agora, podemos inicializar a máquina virtual e tentar chamar a classe `TestArrayString`. Retornando ao Eclipse, clicaremos com o botão direito sobre o seu nome, e selecionaremos a opção "Copy Qualified Name". No terminal, colaremos o nome da classe:

```
Aluras-iMac:bytebank-herdado-conta alura$ ls
bin   doc   src
Aluras-iMac:bytebanks-herdado-conta alura$ cd binAluras-iMac:bin alura$ ls
br
Aluras-iMac:bin alura$ java br.com.bytebank.banco.test.TestArrayStringCOPIAR CÓDIGO
```

Precisamos chamar a classe, sendo que é este o seu nome verdadeiro.

Retornando ao Eclipse, faremos um `System.out.println()` com a mensagem "Funcionou!!", apenas para nos certificarmos:

```
package br.com.bytebank.banco.test;

public class TestArrayString {

        public static void main(String[] args) {

                System.out.println("Funcionou!!");
        }

}COPIAR CÓDIGO
```

Salvaremos e retornaremos ao terminal. Temos o seguinte resultado:

```
Aluras-iMac:bytebank-herdado-conta alura$ ls
bin   doc   src
Aluras-iMac:bytebanks-herdado-conta alura$ cd binAluras-iMac:bin alura$ ls
br
Aluras-iMac:bin alura$ java br.com.bytebank.banco.test.TestArrayString
Funcionou!!
Aluras-iMac:bin alura$COPIAR CÓDIGO
```

Por que então existe o `String[]` ao declararmos o método `main`? Ele existe para que possamos passar parâmetros a partir do terminal, por exemplo, passaremos `1 2 oi nico java`, ou seja, 5 parâmetros:

```
Aluras-iMac:bytebank-herdado-conta alura$ ls
bin   doc   src
Aluras-iMac:bytebanks-herdado-conta alura$ cd binAluras-iMac:bin alura$ ls
br
Aluras-iMac:bin alura$ java br.com.bytebank.banco.test.TestArrayString
Funcionou!!
Aluras-iMac:bin alura$ java br.com.bytebank.banco.test.TestArrayString 1 2 oi nico javaCOPIAR CÓDIGO
```

Retornando ao Eclipse, acessaremos este string em nossa classe. Criaremos um laço `for`, em cima deste array de strings. Dentro do laço, imprimiremos o array na posição da iteração, por meio da variável `i`:

```
package br.com.bytebank.banco.test;

public class TestArrayString {

        public static void main(String[] args) {

                System.out.println("Funcionou!!");

                for(int i = 0; i < args.length; i++) {
                    System.out.println(args[i]);
                }
        }

}COPIAR CÓDIGO
```

Salvaremos e retornaremos ao terminal, testaremos a mesma linha que anteriormente, e temos o seguinte resultado:

```
Aluras-iMac:bytebank-herdado-conta alura$ ls
bin   doc   src
Aluras-iMac:bytebanks-herdado-conta alura$ cd binAluras-iMac:bin alura$ ls
br
Aluras-iMac:bin alura$ java br.com.bytebank.banco.test.TestArrayString
Funcionou!!
Aluras-iMac:bin alura$ java br.com.bytebank.banco.test.TestArrayString 1 2 oi nico java
Funcionou!!
Aluras-iMac:bin alura$ java br.com.bytebank.banco.test.TestArrayString 1 2 oi nico java
Funcionou!!
1
2
oi
nico
java
Aluras-iMac:bin alura$COPIAR CÓDIGO
```

Foram impressos todos os parâmetros que havíamos passado anteriormente.

Assim, temos uma forma de interagir com o programa Java a partir da linha de comando. Chamamos a aplicação e, simultaneamente, é possível definirmos parâmetros.

Isso tem várias utilidades. Pode servir, por exemplo, para habilitar alguma funcionalidade, entre várias outras configurações possíveis.

Assim como testamos no terminal, é possível testarmos também no Eclipse. Rodaremos a classe no programa e temos o seguinte resultado no console:

```
Funcionou!!COPIAR CÓDIGO
```

O Eclipse não passou nenhum parâmetro, e por isso nenhum foi exibido. No Eclipse, no botão verde com o símbolo de play, localizado na barra superior, há na direita uma seta menor, apontando para baixo. Clicando nela, na opção "Run Configurations" é possível manipularmos as configurações, ou seja, como a máquina virtual do Java chamará a nossa classe.

![https://caelum-online-public.s3.amazonaws.com/850-java-util/08/-transcricao-compressed_02.08_004_botao-verde.png](https://caelum-online-public.s3.amazonaws.com/850-java-util/08/-transcricao-compressed_02.08_004_botao-verde.png)

Na lateral esquerda, há uma lista com todas as *run configurations* que já foram utilizadas para rodar os programas em nossa máquina.

Na parte superior temos diversas abas, uma delas é a `Arguments`, ou seja, argumentos. Nela, podemos inserir os parâmetros:

```
1 2 oi nico java rocks e eh legalCOPIAR CÓDIGO
```

Clicamos em "Apply" e "Run". Temos o seguinte resultado no console:

```
Funcionou!!
1
2
oi
nico
java
rocks
e
eh
legalCOPIAR CÓDIGO
```

Todos os parâmetros passados.

Agora já vimos os array de strings, bem como array de referências. Adiante, criaremos um array de objetos e falaremos sobre os métodos genéricos da classe `Object`, especialmente o `equals()`.