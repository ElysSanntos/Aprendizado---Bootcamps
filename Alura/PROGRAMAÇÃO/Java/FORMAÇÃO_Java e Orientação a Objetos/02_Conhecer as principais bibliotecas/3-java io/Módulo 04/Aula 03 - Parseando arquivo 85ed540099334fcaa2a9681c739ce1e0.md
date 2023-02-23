# Aula 03 - Parseando arquivo

Nas aulas anteriores, conseguimos estabelecer um laço para a leitura de um arquivo, linha a linha. Nesta aula, aprenderemos a ler as informações contidas em cada uma destas linhas, individualmente.

Primeiro faremos isso sem utilizar a classe `Scanner`, em seguida, veremos como é o funcionamento com o uso desta.

Como sabemos, a `linha` é do tipo `String`, sendo assim, utilizaremos o método `split()` contido nesta classe, cuja função é separar uma `String` grande em pedaços menores.

O método `split()` recebe como parâmetro uma `String` do tipo `regex`, que é um conjunto de caracteres que define regras de como analisar, ou separar, uma `String` maior. É um tópico complexo, que inclusive possui um curso dedicado exclusivamente ao seu estudo.

No nosso caso, a regra de divisão é simplesmente a vírgula:

```
//Código omitido

public class TesteLeitura2 {

        public static void main(String[] args) throws Exception {

                Scanner scanner = new Scanner(new File("contas.csv"));
                while(scanner.hasNextLine()) {
                        String linha = scanner.nextLine();
                        System.out.println(linha);

                        linha.split(",");
                }
                scanner.close();
        }
}COPIAR CÓDIGO
```

O retorno será uma `String`, com os valore contidos na linha:

```
//Código omitido

public class TesteLeitura2 {

        public static void main(String[] args) throws Exception {

                Scanner scanner = new Scanner(new File("contas.csv"));
                while(scanner.hasNextLine()) {
                        String linha = scanner.nextLine();
                        System.out.println(linha);

                        String[] valores = linha.split(",");
                }
                scanner.close();
        }
}COPIAR CÓDIGO
```

Imprimiremos, para checarmos se nosso programa funciona:

```
//Código omitido

public class TesteLeitura2 {

        public static void main(String[] args) throws Exception {

                Scanner scanner = new Scanner(new File("contas.csv"));
                while(scanner.hasNextLine()) {
                        String linha = scanner.nextLine();
                        System.out.println(linha);

                        String[] valores = linha.split(",");
                        System.out.println(valores);
                }
                scanner.close();
        }
}COPIAR CÓDIGO
```

Executaremos, e temos o seguinte resultado no console:

```
CC,22,33,Nico Steppat,210.1
[Ljava.lang.String;@47f6473
CP,11,55,Luan Silva,1300.98
[Ljava.lang.String;@15975490
CC,22,44,Ana Garcias,350.40
[Ljava.langString;@6b143ee9COPIAR CÓDIGO
```

Vemos que ele imprimiu a primeira linha, com as informações corretas, entretanto, após cada linha temos a impressão de uma saída que não faz muito sentido a primeira vista.

Para fazermos esta impressão sem a necessidade da criação de um laço, podemos utilizar a classe `Arrays`. Assim como temos a classe `Collections`, com uma porção de métodos auxiliares, temos a `Arrays`, que funciona da mesma forma, só que para o mundo dos arrays.

Desta classe, utilizaremos o método `toString()` e passaremos o array `valores` como parâmetro:

```
//Código omitido

public class TesteLeitura2 {

        public static void main(String[] args) throws Exception {

                Scanner scanner = new Scanner(new File("contas.csv"));
                while(scanner.hasNextLine()) {
                        String linha = scanner.nextLine();
                        System.out.println(linha);

                        String[] valores = linha.split(",");
                        System.out.println(Arrays.toString(valores));
                }
                scanner.close();
        }
}COPIAR CÓDIGO
```

Executaremos e temos o seguinte resultado no console:

```
CC,22,33,Nico Steppat,210.1
[CC,22,33,Nico Steppat,210.1]
CP,11,55,Luan Silva,1300.98
[CP,11,55,Luan Silva,1300.98]
CC,22,44,Ana Garcias,350.40
[CC,22,44,Ana Garcias,350.40]COPIAR CÓDIGO
```

Funcionou, temos todos os valores exibidos.

Podemos, inclusive, acessar uma posição específica no array, por exemplo `3` (o quarto elemento):

```
//Código omitido

public class TesteLeitura2 {

        public static void main(String[] args) throws Exception {

                Scanner scanner = new Scanner(new File("contas.csv"));
                while(scanner.hasNextLine()) {
                        String linha = scanner.nextLine();
                        System.out.println(linha);

                        String[] valores = linha.split(",");
                        System.out.println(valores[3]);
                }
                scanner.close();
        }
}COPIAR CÓDIGO
```

Executando, temos o seguinte resultado no console:

```
CC,22,33,Nico Steppat,210.1
Nico Steppat
CP,11,55,Luan Silva,1300.98
Luan Silva
CC,22,44,Ana Garcias,350.40
Ana GarciasCOPIAR CÓDIGO
```

Conseguimos acessar diretamente o quarto elemento, ou seja, o titular da conta.

o `split()` nos ajuda, mas podemos fazer isso de forma ainda mais eficiente com o `Scanner`. Comentaremos as linhas de código com o método e a seguinte, em que imprimimos:

```
//Código omitido

public class TesteLeitura2 {

        public static void main(String[] args) throws Exception {

                Scanner scanner = new Scanner(new File("contas.csv"));
                while(scanner.hasNextLine()) {
                        String linha = scanner.nextLine();
                        System.out.println(linha);

//                        String[] valores = linha.split(",");
//                        System.out.println(valores[1]);
                }
                scanner.close();
        }
}COPIAR CÓDIGO
```

Apesar de utilizarmos a mesma classe `Scanner`, não podemos utilizar o mesmo objeto `scanner`. Ele foi criado para ler linha a linha, nosso objetivo agora é setorizar cada uma destas linhas, e para isso deveremos criar um novo objeto.

Este novo `Scanner` se chamará `linhaScanner`, e receberá uma `String source`, ou seja, não é o nome do arquivo, mas sim a fonte que gostaríamos de analisar:

```
//Código omitido

public class TesteLeitura2 {

        public static void main(String[] args) throws Exception {

                Scanner scanner = new Scanner(new File("contas.csv"));
                while(scanner.hasNextLine()) {
                        String linha = scanner.nextLine();
                        System.out.println(linha);
                        Scanner linhaScanner = new Scanner(linha);

//                        String[] valores = linha.split(",");
//                        System.out.println(valores[1]);
                }
                scanner.close();
        }
}COPIAR CÓDIGO
```

Em seguida, precisamos indicar para o `linhaScanner` que a análise da linha deve ser feita respeitando determinando critério de separação das informações, que em nosso caso é a vírgula (`,`). Em programação, chamamos este critério de delimitador, mais especificamente `Delimiter`.

Sendo assim, utilizaremos o método `useDelimiter()`, que receberá nosso padrão, que como já foi discutido, é a vírgula (`,`):

```
//Código omitido

public class TesteLeitura2 {

        public static void main(String[] args) throws Exception {

                Scanner scanner = new Scanner(new File("contas.csv"));
                while(scanner.hasNextLine()) {
                        String linha = scanner.nextLine();
                        System.out.println(linha);

                        Scanner linhaScanner = new Scanner(linha);
                        linhaScanner.useDelimiter(",");

//                        String[] valores = linha.split(",");
//                        System.out.println(valores[1]);
                }
                scanner.close();
        }
}COPIAR CÓDIGO
```

A seguir, utilizaremos o `Scanner` para que nos retorne o próximo item do arquivo. O método utilizado para este fim é o `next()`, ele nos retornará uma `String`. Faremos este processo por seis vezes, para englobarmos todas as informações dos clientes.

Imprimiremos estes valores e, por fim, fecharemos o `linhaScanner`:

```
//Código omitido

public class TesteLeitura2 {

        public static void main(String[] args) throws Exception {

                Scanner scanner = new Scanner(new File("contas.csv"));
                while(scanner.hasNextLine()) {
                        String linha = scanner.nextLine();
                        System.out.println(linha);

                        Scanner linhaScanner = new Scanner(linha);
                        linhaScanner.useDelimiter(",");

                        String valor1 = linhaScanner.next();
                        String valor2 = linhaScanner.next();
                        String valor3 = linhaScanner.next();
                        String valor4 = linhaScanner.next();
                        String valor5 = linhaScanner.next();
                        String valor6 = linhaScanner.next();

                        System.out.println(valor1 + valor2 + valor3 + valor4 + valor5 + valor6);

                        linhaScanner.close();

//                        String[] valores = linha.split(",");
//                        System.out.println(valores[1]);
                }
                scanner.close();
        }
}COPIAR CÓDIGO
```

Executamos e temos um erro, isso aconteceu pois na verdade só há cinco valores, assim, quando foi solicitado o próximo elemento da lista, este não existe e o programa apresentou o erro. Basta removermos o `valor6`:

```
//Código omitido

public class TesteLeitura2 {

        public static void main(String[] args) throws Exception {

                Scanner scanner = new Scanner(new File("contas.csv"));
                while(scanner.hasNextLine()) {
                        String linha = scanner.nextLine();
                        System.out.println(linha);

                        Scanner linhaScanner = new Scanner(linha);
                        linhaScanner.useDelimiter(",");

                        String valor1 = linhaScanner.next();
                        String valor2 = linhaScanner.next();
                        String valor3 = linhaScanner.next();
                        String valor4 = linhaScanner.next();
                        String valor5 = linhaScanner.next();

                        System.out.println(valor1 + valor2 + valor3 + valor4 + valor5);

                        linhaScanner.close();

//                        String[] valores = linha.split(",");
//                        System.out.println(valores[1]);
                }
                scanner.close();
        }
}COPIAR CÓDIGO
```

Salvaremos e executaremos, temos o seguinte resultado:

```
CC,22,33,Nico Steppat,210.1
CC2233Nico Steppat210.1
CP,11,55,Luan Silva,1300.98
CP1155Luan Silva1300.98
CC,22,44,Ana Garcias,350.40
CC2244Ana Garcias350.40COPIAR CÓDIGO
```

Funcionou. Temos a linha impressa diretamente do texto, e logo em seguida os valores extraídos, sem as vírgulas que os separam.

As informações de agência e conta são do tipo `int`, e como os transformamos em `Strings`, precisaremos realizar um `parseInt()` - transformando o `String` em um tipo mais específico, no caso, um inteiro.

Contudo, para evitar procedimentos complicados, podemos contar com o método `nextInt()`, para trabalhar com as informações de agência e número da conta, e `nextDouble()`, para o saldo. Assim já estamos preservando o tipo específico:

```
//Código omitido

public class TesteLeitura2 {

        public static void main(String[] args) throws Exception {

                Scanner scanner = new Scanner(new File("contas.csv"));
                while(scanner.hasNextLine()) {
                        String linha = scanner.nextLine();
                        System.out.println(linha);

                        Scanner linhaScanner = new Scanner(linha);
                        linhaScanner.useDelimiter(",");

                        String valor1 = linhaScanner.next();
                        int valor2 = linhaScanner.nextInt();
                        int valor3 = linhaScanner.nextInt();
                        String valor4 = linhaScanner.next();
                        double valor5 = linhaScanner.nextDouble();

                        System.out.println(valor1 + valor2 + valor3 + valor4 + valor5);

                        linhaScanner.close();

//                        String[] valores = linha.split(",");
//                        System.out.println(valores[1]);
                }
                scanner.close();
        }
}COPIAR CÓDIGO
```

Ainda temos uma peculiaridade. No saldo, temos um ponto (`.`) separando os números inteiros dos decimais, contudo, alguns lugares convencionam o ponto, enquanto outros utilizam a vírgula (`,`) para este fim. O que determina se a máquina virtual seguirá um padrão ou outro é o sistema operacional da máquina, ela seguirá o padrão do idioma da máquina em que o código está sendo escrito.

Por exemplo, como neste curso estamos utilizando uma máquina cujo sistema está em Inglês, o padrão é o ponto (`.`), se tentarmos utilizar outro caractere, ocorrerá um erro.

Para evitar esta regra automática, podemos especificar no código a regra que queremos seguir utilizando o método `useLocale()`:

```
//Código omitido

public class TesteLeitura2 {

        public static void main(String[] args) throws Exception {

                Scanner scanner = new Scanner(new File("contas.csv"));
                while(scanner.hasNextLine()) {
                        String linha = scanner.nextLine();
                        System.out.println(linha);

                        Scanner linhaScanner = new Scanner(linha);
                        linhaScanner.useLocale(Locale);
                        linhaScanner.useDelimiter(",");

                        String valor1 = linhaScanner.next();
                        int valor2 = linhaScanner.nextInt();
                        int valor3 = linhaScanner.nextInt();
                        String valor4 = linhaScanner.next();
                        double valor5 = linhaScanner.nextDouble();

                        System.out.println(valor1 + valor2 + valor3 + valor4 + valor5);

                        linhaScanner.close();

//                        String[] valores = linha.split(",");
//                        System.out.println(valores[1]);
                }
                scanner.close();
        }
}COPIAR CÓDIGO
```

Nela, acessaremos o nome da classe, portanto `Locale`, seguida de um ponto (`.`), e o Eclipse nos mostrará uma série de opções de regras. No caso, utilizaremos `US`, que é o padrão americano:

```
//Código omitido

public class TesteLeitura2 {

        public static void main(String[] args) throws Exception {

                Scanner scanner = new Scanner(new File("contas.csv"));
                while(scanner.hasNextLine()) {
                        String linha = scanner.nextLine();
                        System.out.println(linha);

                        Scanner linhaScanner = new Scanner(linha);
                        linhaScanner.useLocale(Locale.US);
                        linhaScanner.useDelimiter(",");

                        String valor1 = linhaScanner.next();
                        int valor2 = linhaScanner.nextInt();
                        int valor3 = linhaScanner.nextInt();
                        String valor4 = linhaScanner.next();
                        double valor5 = linhaScanner.nextDouble();

                        System.out.println(valor1 + valor2 + valor3 + valor4 + valor5);

                        linhaScanner.close();

//                        String[] valores = linha.split(",");
//                        System.out.println(valores[1]);
                }
                scanner.close();
        }
}COPIAR CÓDIGO
```

Desta forma, não importa o sistema operacional, o código e a máquina virtual sempre respeitarão o padrão americano.

Salvaremos e executaremos, e o código continua funcionando perfeitamente.