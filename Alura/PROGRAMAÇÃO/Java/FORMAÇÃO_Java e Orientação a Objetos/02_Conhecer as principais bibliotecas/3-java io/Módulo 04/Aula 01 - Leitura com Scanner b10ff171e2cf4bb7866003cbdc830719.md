# Aula 01 - Leitura com Scanner

> O arquivo contas.csv pode ser baixado [aqui](https://s3.amazonaws.com/caelum-online-public/857-java-io/04/contas.csv). E caso queira, você pode fazer o [download](https://s3.amazonaws.com/caelum-online-public/857-java-io/04/java7-aula4.zip) do projeto completo feito até a aula anterior.
> 

Já falamos sobre alternativas de **saída** e ,nesta aula, nosso foco será na **entrada**.

Renomearemos a classe `TesteEscrita3` para `TesteEscritaPrintStreamPrintWriter`, lembrando de renomear o arquivo para que ela continue a compilar.

Trabalharemos com um arquivo de extensão `.csv`. O "c" é para a palavra "*comma*", "s" para "*separated*", e "v" para "*values*", o que significa "valores separados por vírgulas". Dentro deste arquivo `contas.csv` temos os seguintes dados:

```
CC,22,33,Nico Steppat,210.1
CP,11,55,Luan Silva,1300.98
CC,22,44,Ana Garcias,350.40COPIAR CÓDIGO
```

Este tipo de arquivo é comumente utilizado na área de ciência de dados.

Primeiro temos o tipo de conta, `CC` para conta corrente, e `CP` para conta poupança. Em seguida temos o número da agência, conta, nome do titular, e por fim o saldo.

Inseriremos este arquivo na pasta raiz do nosso projeto, `java.io`.

Criaremos uma nova classe chamada `TesteLeitura2`. Nela, utilizaremos a classe `Scanner`, que advém do pacote `java.util`. No seu construtor, passaremos o `new File`, com cuidado para não confundirmos com o `String source` com o `String fileName`, que utilizávamos anteriormente:

```
package br.com.alura.java.io.teste;

import java.util.Scanner;

public class TesteLeitura2 {

        public static void main(String[] args) {

                Scanner scanner = new Scanner(new File);

        }
}COPIAR CÓDIGO
```

O `new File` serve para representarmos o arquivo que desejamos ler, por meio de um novo objeto. O `File` receberá o nome do arquivo `contas.csv`:

```
package br.com.alura.java.io.teste;

import java.util.Scanner;

public class TesteLeitura2 {

        public static void main(String[] args) {

                Scanner scanner = new Scanner(new File("contas.csv"));

        }
}COPIAR CÓDIGO
```

Precisamos criar o `throws` para o `Exception`, especificamente. Assim, evitamos a confusão com as demais exceções:

```
package br.com.alura.java.io.teste;

import java.util.Scanner;

public class TesteLeitura2 {

        public static void main(String[] args) throws FileNotFoundException {

                Scanner scanner = new Scanner(new File("contas.csv"));

        }
}COPIAR CÓDIGO
```

A classe `Scanner` conta com uma série de métodos de alto nível. Utilizaremos o `nextLine()`, que nos permitirá acessar a próxima linha em nosso arquivo, assim, ela nos retornará uma `String`, que imprimiremos em seguida:

```
package br.com.alura.java.io.teste;

import java.util.Scanner;

public class TesteLeitura2 {

        public static void main(String[] args) throws FileNotFoundException {

                Scanner scanner = new Scanner(new File("contas.csv"));

                String linha = scanner.nextLine();
                System.out.println(linha);

        }
}COPIAR CÓDIGO
```

Por fim, precisamos fechar o `scanner`:

```
package br.com.alura.java.io.teste;

import java.util.Scanner;

public class TesteLeitura2 {

        public static void main(String[] args) throws FileNotFoundException{

                Scanner scanner = new Scanner(new File("contas.csv"));

                String linha = scanner.nextLine();
                System.out.println(linha);

                scanner.close();

        }
}COPIAR CÓDIGO
```

Executaremos a classe, e temos o seguinte resultado no console:

```
CC,22,33,Nico Steppat,210.1COPIAR CÓDIGO
```

Funcionou, imprimimos a primeira linha com sucesso.

Nosso próximo passo será criar um laço, para imprimirmos as linhas sucessivamente. A `Scanner` conta com métodos próprios, dentre eles, um específico para saber se é possível obter uma próxima linha, chamado `hasNextLine()`. Seu retorno será do tipo `boolean`:

```
package br.com.alura.java.io.teste;

import java.util.Scanner;

public class TesteLeitura2 {

        public static void main(String[] args) throws FileNotFoundException {

                Scanner scanner = new Scanner(new File("contas.csv"));

                boolean tem = scanner.hasNextLine();
                System.out.println(tem);
                String linha = scanner.nextLine();
                System.out.println(linha);

                scanner.close();

        }
}COPIAR CÓDIGO
```

Executaremos, e teremos o seguinte resultado no console:

```
true
22,33,Nico Steppat,210.1COPIAR CÓDIGO
```

Isso significa duas coisas, primeiro, que nosso programa funcionou, já que o console exibiu a palavra `true`, e segundo, que há outras linhas a serem linhas, já que a resposta foi verdadeira.

Este método será utilizado, portanto, em nosso laço, para criar um mecanismo que funcione sempre que houver uma próxima linha a ser lida. O tipo de laço mais indicado, neste caso, é o `while`:

```
package br.com.alura.java.io.teste;

import java.util.Scanner;

public class TesteLeitura2 {

        public static void main(String[] args) throws FileNotFoundException {

                Scanner scanner = new Scanner(new File("contas.csv"));
                while(scanner.hasNextLine()) {
                        String linha = scanner.nextLine();
                        System.out.println(linha);
                }

                scanner.close();

        }
}COPIAR CÓDIGO
```

Ao executar a classe, teremos o seguinte resultado no console:

```
CC,22,33,Nico Steppat,210.1
CP,11,55,Luan Silva,1300.98
CC,22,44,Ana Garcias,350.40COPIAR CÓDIGO
```

Funcionou.

Em comparação com o código da classe `TesteLeitura`, este é mais sucinto, e eficaz da mesma forma.

Tudo foi facilitado graças à classe `Scanner`, mas ela possui ainda muitas funcionalidades que não exploramos. A seguir, veremos que, além de ler linha a linha, é possível lermos valor a valor, separadamente.