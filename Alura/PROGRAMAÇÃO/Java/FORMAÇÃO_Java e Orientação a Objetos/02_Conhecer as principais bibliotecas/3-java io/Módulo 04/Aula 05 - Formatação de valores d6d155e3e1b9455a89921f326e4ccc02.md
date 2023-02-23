# Aula 05 - Formatação de valores

Até o momento, utilizamos o `Scanner` para ler o arquivo, e para analisar a linha com o `Delimiter` - já utilizando os métodos específicos que fazem o `parseInt()`.

A seguir, falaremos sobre a formatação. Nosso foco não será no `Scanner`, tampouco no `java.io`.

Comentaremos o `System.out.println(linha)` para focarmos somente naquele que imprime os valores individualizados:

```
//Código omitido

public class TesteLeitura2 {

        public static void main(String[] args) throws Exception {

                Scanner scanner = new Scanner(new File("contas.csv"));
                while(scanner.hasNextLine()) {
                        String linha = scanner.nextLine();
//                        System.out.println(linha);

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
//                        System.out.println(valores[3]);
                }
                scanner.close();
        }
}COPIAR CÓDIGO
```

Se tentarmos separar cada um dos valores com vírgulas, nosso código ficará cada vez mais verboso, o que não é uma solução ideal. Para melhorarmos isso, podemos usar a formatação na classe `String`, com o método `format()`.

Este por sua vez recebe dois parâmetros, `format` e `args`. A ideia do primeiro é definir o formato, de forma genérica, e em seguida - no segundo - passamos os parâmetros, que no nosso caso são os valores que imprimimos acima.

Para estas regras de formatação, utilizamos apenas um `s` para representar uma `String`:

```
//Código omitido

public class TesteLeitura2 {

        public static void main(String[] args) throws Exception {

                Scanner scanner = new Scanner(new File("contas.csv"));
                while(scanner.hasNextLine()) {
                        String linha = scanner.nextLine();
//                        System.out.println(linha);

                        Scanner linhaScanner = new Scanner(linha);
                        linhaScanner.useLocale(Locale.US);
                        linhaScanner.useDelimiter(",");

                        String valor1 = linhaScanner.next();
                        int valor2 = linhaScanner.nextInt();
                        int valor3 = linhaScanner.nextInt();
                        String valor4 = linhaScanner.next();
                        double valor5 = linhaScanner.nextDouble();

                        String.format("", valor1, valor2, valor3, valor4, valor5);
                                                System.out.println(valor1 + valor2 + valor3 + valor4 + valor5);

                        linhaScanner.close();

//                        String[] valores = linha.split(",");
//                        System.out.println(valores[3]);
                }
                scanner.close();
        }
}COPIAR CÓDIGO
```

Ele nos permite, inclusive, a criação de um novo valor no próprio método. Se quiséssemos, poderíamos ter inserido um novo elemento, desde que respeitada a regra de separação.

Para definir o formato, começamos com o símbolo de porcentagem (`%`), e indicamos o tipo do valor, `String`, que neste caso é representado apenas por um `s`. Precisamos repetir tantas vezes quanto houverem valores, assim, para cinco valores, serão cinco `%s`s:

```
//Código omitido

public class TesteLeitura2 {

        public static void main(String[] args) throws Exception {

                Scanner scanner = new Scanner(new File("contas.csv"));
                while(scanner.hasNextLine()) {
                        String linha = scanner.nextLine();
//                        System.out.println(linha);

                        Scanner linhaScanner = new Scanner(linha);
                        linhaScanner.useLocale(Locale.US);
                        linhaScanner.useDelimiter(",");

                        String valor1 = linhaScanner.next();
                        int valor2 = linhaScanner.nextInt();
                        int valor3 = linhaScanner.nextInt();
                        String valor4 = linhaScanner.next();
                        double valor5 = linhaScanner.nextDouble();

                        String.format("%s %s %s %s %s", valor1, valor2, valor3, valor4, valor5);
                                                System.out.println(valor1 + valor2 + valor3 + valor4 + valor5);

                        linhaScanner.close();

//                        String[] valores = linha.split(",");
//                        System.out.println(valores[3]);
                }
                scanner.close();
        }
}COPIAR CÓDIGO
```

Ou seja, concentramos a formatação em apenas uma `String`, sem a necessidade de fazer uma série de concatenações. A legibilidade do nosso código melhora consideravelmente desta forma - concatenar muitas `String`s é sempre má prática.

O resultado de `format` é uma nova `String`, que representa a o texto completo, já com a formatação. Ele será representado pela variável `valorFormatado`, que utilizaremos para imprimirmos:

```
//Código omitido

public class TesteLeitura2 {

        public static void main(String[] args) throws Exception {

                Scanner scanner = new Scanner(new File("contas.csv"));
                while(scanner.hasNextLine()) {
                        String linha = scanner.nextLine();
//                        System.out.println(linha);

                        Scanner linhaScanner = new Scanner(linha);
                        linhaScanner.useLocale(Locale.US);
                        linhaScanner.useDelimiter(",");

                        String valor1 = linhaScanner.next();
                        int valor2 = linhaScanner.nextInt();
                        int valor3 = linhaScanner.nextInt();
                        String valor4 = linhaScanner.next();
                        double valor5 = linhaScanner.nextDouble();

                        String valorFormatado = String.format("%s %s %s %s %s", valor1, valor2, valor3, valor4, valor5);
                                                System.out.println(valorFormatado);

                        linhaScanner.close();

//                        String[] valores = linha.split(",");
//                        System.out.println(valores[3]);
                }
                scanner.close();
        }
}COPIAR CÓDIGO
```

Executaremos, e temos o seguinte resultado no console:

```
CC 22 33 Nico Steppat 210.1
CP 11 55 Luan Silva 1300.98
CC 22 44 Ana Garcias 350.4COPIAR CÓDIGO
```

Funcionou! Temos tudo separado por espaços.

Podemos separa-los por hifens (`-`), se quisermos, para melhorar a legibilidade, ou então uma vírgula (`,`), dois pontos (`:`), enfim, é possível formatarmos de maneira mais fácil:

```
//Código omitido

public class TesteLeitura2 {

        public static void main(String[] args) throws Exception {

                Scanner scanner = new Scanner(new File("contas.csv"));
                while(scanner.hasNextLine()) {
                        String linha = scanner.nextLine();
//                        System.out.println(linha);

                        Scanner linhaScanner = new Scanner(linha);
                        linhaScanner.useLocale(Locale.US);
                        linhaScanner.useDelimiter(",");

                        String valor1 = linhaScanner.next();
                        int valor2 = linhaScanner.nextInt();
                        int valor3 = linhaScanner.nextInt();
                        String valor4 = linhaScanner.next();
                        double valor5 = linhaScanner.nextDouble();

                        String valorFormatado = String.format("%s - %s-%s, %s: %s", valor1, valor2, valor3, valor4, valor5);
                                                System.out.println(valorFormatado);

                        linhaScanner.close();

//                        String[] valores = linha.split(",");
//                        System.out.println(valores[3]);
                }
                scanner.close();
        }
}COPIAR CÓDIGO
```

Executando, temos o seguinte resultado no console:

```
CC - 22-33, Nico Steppat: 210.1
CP - 11-55, Luan Silva: 1300.98
CC - 22-44, Ana Garcias: 350.4COPIAR CÓDIGO
```

E como saber que a `%s` significa `String`? Se estudarmos o Java, sabemos que esta informação pode ser encontrada na documentação. Portanto, não há necessidade de decorar as informações que serão passadas aqui, se surgir a necessidade de utilizar alguma ferramenta de formatação, basta olharmos a documentação para sabermos as abreviações aplicáveis.

Se pesquisarmos pelo termo "java printf" no [Google](http://www.google.com/), encontraremos links com a [documentação disponível](https://docs.oracle.com/javase/tutorial/java/data/numberformat.html).

Na página, encontramos uma tabela contendo as abreviações disponíveis e suas respectivas correspondências. Veremos que há um tipo específico para um inteiro decimal, que é representado pela letra `d`, sendo assim, substituiremos o `s` pelo tipo mais específico, já que estamos trabalhando com numéricos nos valores 2 e 3:

```
//Código omitido

public class TesteLeitura2 {

        public static void main(String[] args) throws Exception {

                Scanner scanner = new Scanner(new File("contas.csv"));
                while(scanner.hasNextLine()) {
                        String linha = scanner.nextLine();
//                        System.out.println(linha);

                        Scanner linhaScanner = new Scanner(linha);
                        linhaScanner.useLocale(Locale.US);
                        linhaScanner.useDelimiter(",");

                        String valor1 = linhaScanner.next();
                        int valor2 = linhaScanner.nextInt();
                        int valor3 = linhaScanner.nextInt();
                        String valor4 = linhaScanner.next();
                        double valor5 = linhaScanner.nextDouble();

                        String valorFormatado = String.format("%s - %d-%d, %s: %s", valor1, valor2, valor3, valor4, valor5);
                                                System.out.println(valorFormatado);

                        linhaScanner.close();

//                        String[] valores = linha.split(",");
//                        System.out.println(valores[3]);
                }
                scanner.close();
        }
}COPIAR CÓDIGO
```

Já o último valor é um `double`, sendo assim, utilizamos a abreviação `f`:

```
//Código omitido

public class TesteLeitura2 {

        public static void main(String[] args) throws Exception {

                Scanner scanner = new Scanner(new File("contas.csv"));
                while(scanner.hasNextLine()) {
                        String linha = scanner.nextLine();
//                        System.out.println(linha);

                        Scanner linhaScanner = new Scanner(linha);
                        linhaScanner.useLocale(Locale.US);
                        linhaScanner.useDelimiter(",");

                        String valor1 = linhaScanner.next();
                        int valor2 = linhaScanner.nextInt();
                        int valor3 = linhaScanner.nextInt();
                        String valor4 = linhaScanner.next();
                        double valor5 = linhaScanner.nextDouble();

                        String valorFormatado = String.format("%s - %d-%d, %s: %f", valor1, valor2, valor3, valor4, valor5);
                                                System.out.println(valorFormatado);

                        linhaScanner.close();

//                        String[] valores = linha.split(",");
//                        System.out.println(valores[3]);
                }
                scanner.close();
        }
}COPIAR CÓDIGO
```

Em teoria, nada deveria mudar no resultado final visualmente. Executaremos, e percebemos que funcionou.

O `%d` funciona somente se o valor for um inteiro `int`, por exemplo, se utilizarmos esta formatação no `valor1`, que é uma `String`:

```
//Código omitido

public class TesteLeitura2 {

        public static void main(String[] args) throws Exception {

                Scanner scanner = new Scanner(new File("contas.csv"));
                while(scanner.hasNextLine()) {
                        String linha = scanner.nextLine();
//                        System.out.println(linha);

                        Scanner linhaScanner = new Scanner(linha);
                        linhaScanner.useLocale(Locale.US);
                        linhaScanner.useDelimiter(",");

                        String valor1 = linhaScanner.next();
                        int valor2 = linhaScanner.nextInt();
                        int valor3 = linhaScanner.nextInt();
                        String valor4 = linhaScanner.next();
                        double valor5 = linhaScanner.nextDouble();

                        String valorFormatado = String.format("%d - %d-%d, %s: %f", valor1, valor2, valor3, valor4, valor5);
                                                System.out.println(valorFormatado);

                        linhaScanner.close();

//                        String[] valores = linha.split(",");
//                        System.out.println(valores[3]);
                }
                scanner.close();
        }
}COPIAR CÓDIGO
```

Temos um erro ao executarmos o programa, pois ele tentará interpretar o `String` como se fosse um `int`. Assim, retornaremos à formatação correta, `%s`:

```
//Código omitido

public class TesteLeitura2 {

        public static void main(String[] args) throws Exception {

                Scanner scanner = new Scanner(new File("contas.csv"));
                while(scanner.hasNextLine()) {
                        String linha = scanner.nextLine();
//                        System.out.println(linha);

                        Scanner linhaScanner = new Scanner(linha);
                        linhaScanner.useLocale(Locale.US);
                        linhaScanner.useDelimiter(",");

                        String valor1 = linhaScanner.next();
                        int valor2 = linhaScanner.nextInt();
                        int valor3 = linhaScanner.nextInt();
                        String valor4 = linhaScanner.next();
                        double valor5 = linhaScanner.nextDouble();

                        String valorFormatado = String.format("%s - %d-%d, %s: %f", valor1, valor2, valor3, valor4, valor5);
                                                System.out.println(valorFormatado);

                        linhaScanner.close();

//                        String[] valores = linha.split(",");
//                        System.out.println(valores[3]);
                }
                scanner.close();
        }
}COPIAR CÓDIGO
```

Na documentação, há outros exemplos de formatação. Vide o seguinte, em que temos um `long`:

```
//Código omitido

public class TestFormat {

        public static void main(String[] args) {
            long n = 461012;
            System.out.format("%d%n", n)  // --> "461012"
            System.out.format("%08d%n", n)  // --> "00461012"
//Código omitidoCOPIAR CÓDIGO
```

Temos um tipo de abreviação que é o `%08`, no nosso caso, vamos testar como `%04`:

```
//Código omitido

public class TesteLeitura2 {

        public static void main(String[] args) throws Exception {

                Scanner scanner = new Scanner(new File("contas.csv"));
                while(scanner.hasNextLine()) {
                        String linha = scanner.nextLine();
//                        System.out.println(linha);

                        Scanner linhaScanner = new Scanner(linha);
                        linhaScanner.useLocale(Locale.US);
                        linhaScanner.useDelimiter(",");

                        String valor1 = linhaScanner.next();
                        int valor2 = linhaScanner.nextInt();
                        int valor3 = linhaScanner.nextInt();
                        String valor4 = linhaScanner.next();
                        double valor5 = linhaScanner.nextDouble();

                        String valorFormatado = String.format("%s - %04d-%d, %s: %f", valor1, valor2, valor3, valor4, valor5);
                                                System.out.println(valorFormatado);

                        linhaScanner.close();

//                        String[] valores = linha.split(",");
//                        System.out.println(valores[3]);
                }
                scanner.close();
        }
}COPIAR CÓDIGO
```

Executaremos, e temos o seguinte resultado:

```
CC - 0022-33, Nico Steppat: 210.100000
CP - 0011-55, Luan Silva: 1300.980000
CC - 0022-44, Ana Garcias: 350.400000COPIAR CÓDIGO
```

Notamos que o `valor2` foi formatado, e ganhou duas casas à esquerda, de modo que possui quatro caracteres no total. Portanto, se o número da agência fosse composto por quatro dígitos, não teríamos problema. A seguir, faremos o mesmo com o número da conta, só que conferiremos `%08` caracteres.

Para melhorar a didática de nosso código, daremos ao `valor1` o nome de `tipoConta`, ao `valor2` o nome de `agencia`, ao `valor3` o nome de `numero`, `valor4` será o `titular` e `valor5` o `saldo`:

```
//Código omitido

public class TesteLeitura2 {

        public static void main(String[] args) throws Exception {

                Scanner scanner = new Scanner(new File("contas.csv"));
                while(scanner.hasNextLine()) {
                        String linha = scanner.nextLine();
//                        System.out.println(linha);

                        Scanner linhaScanner = new Scanner(linha);
                        linhaScanner.useLocale(Locale.US);
                        linhaScanner.useDelimiter(",");

                        String tipoConta = linhaScanner.next();
                        int agencia = linhaScanner.nextInt();
                        int numero = linhaScanner.nextInt();
                        String titular = linhaScanner.next();
                        double saldo = linhaScanner.nextDouble();

                        String valorFormatado = String.format("%s - %04d-%08d, %s: %f", tipoConta, agencia, numero, titular, saldo);
                                                System.out.println(valorFormatado);

                        linhaScanner.close();

//                        String[] valores = linha.split(",");
//                        System.out.println(valores[3]);
                }
                scanner.close();
        }
}COPIAR CÓDIGO
```

Assim, executando, temos o seguinte resultado no console:

```
CC - 0022-00000033, Nico Steppat: 210.100000
CP - 0011-00000055, Luan Silva: 1300.980000
CC - 0022-00000044, Ana Garcias: 350.400000COPIAR CÓDIGO
```

Funcionou, temos oito caracteres, em que os novos foram preenchidos com o número zero (`0`).

Em seguida, alteraremos a formatação do `saldo`, fazendo com que ganhe mais caracteres antes do ponto (`.`), bem como delimitando duas casas decimais após, fazemos isso utilizando o `010.2`, da seguinte forma:

```
//Código omitido

public class TesteLeitura2 {

        public static void main(String[] args) throws Exception {

                Scanner scanner = new Scanner(new File("contas.csv"));
                while(scanner.hasNextLine()) {
                        String linha = scanner.nextLine();
//                        System.out.println(linha);

                        Scanner linhaScanner = new Scanner(linha);
                        linhaScanner.useLocale(Locale.US);
                        linhaScanner.useDelimiter(",");

                        String tipoConta = linhaScanner.next();
                        int agencia = linhaScanner.nextInt();
                        int numero = linhaScanner.nextInt();
                        String titular = linhaScanner.next();
                        double saldo = linhaScanner.nextDouble();

                        String valorFormatado = String.format("%s - %04d-%08d, %s: %010.2f", tipoConta, agencia, numero, titular, saldo);
                                                System.out.println(valorFormatado);

                        linhaScanner.close();

//                        String[] valores = linha.split(",");
//                        System.out.println(valores[3]);
                }
                scanner.close();
        }
}COPIAR CÓDIGO
```

Neste caso, `010` representa o número total de caracteres, sendo assim, ao executarmos teremos o seguinte resultado no console:

```
CC - 0022-00000033, Nico Steppat: 0000210.10
CP - 0011-00000055, Luan Silva: 0001300.98
CC - 0022-00000044, Ana Garcias: 0000350.40COPIAR CÓDIGO
```

Podemos diminuir, e utilizar `08.2` para que não hajam tantos zeros. Da mesma forma, podemos limitar os caracteres em uma `String`, por exemplo, limitaremos o `titular` em `20` caracteres:

```
//Código omitido

public class TesteLeitura2 {

        public static void main(String[] args) throws Exception {

                Scanner scanner = new Scanner(new File("contas.csv"));
                while(scanner.hasNextLine()) {
                        String linha = scanner.nextLine();
//                        System.out.println(linha);

                        Scanner linhaScanner = new Scanner(linha);
                        linhaScanner.useLocale(Locale.US);
                        linhaScanner.useDelimiter(",");

                        String tipoConta = linhaScanner.next();
                        int agencia = linhaScanner.nextInt();
                        int numero = linhaScanner.nextInt();
                        String titular = linhaScanner.next();
                        double saldo = linhaScanner.nextDouble();

                        String valorFormatado = String.format("%s - %04d-%08d, %20s: %05.2f", tipoConta, agencia, numero, titular, saldo);
                                                System.out.println(valorFormatado);

                        linhaScanner.close();

//                        String[] valores = linha.split(",");
//                        System.out.println(valores[3]);
                }
                scanner.close();
        }
}COPIAR CÓDIGO
```

Executando, temos o seguinte resultado:

```
CC - 0022-00000033,         Nico Steppat: 00210.10
CP - 0011-00000055,         Luan Silva: 01300.98
CC - 0022-00000044,         Ana Garcias: 00350.40COPIAR CÓDIGO
```

Por fim, alteraremos a formatação para que as casas não sejam divididas por um ponto (`.`). A formatação neste caso depende da região do mundo em que estamos, contudo, trabalharemos com a hipótese de transformarmos este ponto (`.`) em uma vírgula (`,`).

O método `format()` pode receber uma `String`, ou um `Locale`. Isso significa que em uma hipótese podemos informar como parâmetro em qual região do planeta estamos programando.

Portanto, utilizaremos a classe `Locale`. Já existe uma série de constantes para ela, mas como não há uma específica para o Brasil, utilizaremos `GERMANY`:

```
//Código omitido

public class TesteLeitura2 {

        public static void main(String[] args) throws Exception {

                Scanner scanner = new Scanner(new File("contas.csv"));
                while(scanner.hasNextLine()) {
                        String linha = scanner.nextLine();
//                        System.out.println(linha);

                        Scanner linhaScanner = new Scanner(linha);
                        linhaScanner.useLocale(Locale.US);
                        linhaScanner.useDelimiter(",");

                        String tipoConta = linhaScanner.next();
                        int agencia = linhaScanner.nextInt();
                        int numero = linhaScanner.nextInt();
                        String titular = linhaScanner.next();
                        double saldo = linhaScanner.nextDouble();

                        String valorFormatado = String.format(Locale.GERMANY , "%s - %04d-%08d, %20s: %05.2f",
                                                                                                                            tipoConta, agencia, numero, titular, saldo);
                                                System.out.println(valorFormatado);

                        linhaScanner.close();

//                        String[] valores = linha.split(",");
//                        System.out.println(valores[3]);
                }
                scanner.close();
        }
}COPIAR CÓDIGO
```

Executando mais uma vez, nos é apresentado o seguinte:

```
CC - 0022-00000033,         Nico Steppat: 00210,10
CP - 0011-00000055,         Luan Silva: 01300,98
CC - 0022-00000044,         Ana Garcias: 00350,40COPIAR CÓDIGO
```

Funcionou, temos as vírgulas.

Contudo, temos que considerar que estamos no Brasil. Apesar de não haver uma constante pré-existente, é possível criarmos nossa própria, como o construtor `new`. Ele receberá um parâmetro, que é o idioma, no caso `pt`:

```
//Código omitido

public class TesteLeitura2 {

        public static void main(String[] args) throws Exception {

                Scanner scanner = new Scanner(new File("contas.csv"));
                while(scanner.hasNextLine()) {
                        String linha = scanner.nextLine();
//                        System.out.println(linha);

                        Scanner linhaScanner = new Scanner(linha);
                        linhaScanner.useLocale(Locale.US);
                        linhaScanner.useDelimiter(",");

                        String tipoConta = linhaScanner.next();
                        int agencia = linhaScanner.nextInt();
                        int numero = linhaScanner.nextInt();
                        String titular = linhaScanner.next();
                        double saldo = linhaScanner.nextDouble();

                        String valorFormatado = String.format(new Locale("pt"), "%s - %04d-%08d, %20s: %05.2f",
                                                                                                                            tipoConta, agencia, numero, titular, saldo);
                                                System.out.println(valorFormatado);

                        linhaScanner.close();

//                        String[] valores = linha.split(",");
//                        System.out.println(valores[3]);
                }
                scanner.close();
        }
}COPIAR CÓDIGO
```

Executando, temos o mesmo resultado, portanto funcionou.

Para especificarmos que se trata de português do Brasil, e não de Portugal, colocamos o país de origem logo após o idioma. No caso, o Brasil é representado pelo código `BR`:

```
//Código omitido

public class TesteLeitura2 {

        public static void main(String[] args) throws Exception {

                Scanner scanner = new Scanner(new File("contas.csv"));
                while(scanner.hasNextLine()) {
                        String linha = scanner.nextLine();
//                        System.out.println(linha);

                        Scanner linhaScanner = new Scanner(linha);
                        linhaScanner.useLocale(Locale.US);
                        linhaScanner.useDelimiter(",");

                        String tipoConta = linhaScanner.next();
                        int agencia = linhaScanner.nextInt();
                        int numero = linhaScanner.nextInt();
                        String titular = linhaScanner.next();
                        double saldo = linhaScanner.nextDouble();

                        String valorFormatado = String.format(new Locale("pt", "BR"), "%s - %04d-%08d, %20s: %05.2f",
                                                                                                                            tipoConta, agencia, numero, titular, saldo);
                                                System.out.println(valorFormatado);

                        linhaScanner.close();

//                        String[] valores = linha.split(",");
//                        System.out.println(valores[3]);
                }
                scanner.close();
        }
}COPIAR CÓDIGO
```

Para economizarmos linhas de código, podemos inserir a formatação direto no método de impressão:

```
//Código omitido

public class TesteLeitura2 {

        public static void main(String[] args) throws Exception {

                Scanner scanner = new Scanner(new File("contas.csv"));
                while(scanner.hasNextLine()) {
                        String linha = scanner.nextLine();
//                        System.out.println(linha);

                        Scanner linhaScanner = new Scanner(linha);
                        linhaScanner.useLocale(Locale.US);
                        linhaScanner.useDelimiter(",");

                        String tipoConta = linhaScanner.next();
                        int agencia = linhaScanner.nextInt();
                        int numero = linhaScanner.nextInt();
                        String titular = linhaScanner.next();
                        double saldo = linhaScanner.nextDouble();

                                                System.out.format(new Locale("pt", "BR"), "%s - %04d-%08d, %20s: %05.2f",
                                                                                                                            tipoConta, agencia, numero, titular, saldo);

                        linhaScanner.close();

//                        String[] valores = linha.split(",");
//                        System.out.println(valores[3]);
                }
                scanner.close();
        }
}COPIAR CÓDIGO
```

Ao executarmos, temos a seguinte impressão:

```
CC - 0022-00000033,         Nico Steppat: 00210,10 CP - 0011-00000055,         Luan Silva: 01300,98 CC - 0022-00000044,         Ana Garcias: 00350,40COPIAR CÓDIGO
```

Isso acontece porque o `format()` não faz a quebra de linha automaticamente. Teremos de inseri-la manualmente, por meio do `%n`:

```
//Código omitido

public class TesteLeitura2 {

        public static void main(String[] args) throws Exception {

                Scanner scanner = new Scanner(new File("contas.csv"));
                while(scanner.hasNextLine()) {
                        String linha = scanner.nextLine();
//                        System.out.println(linha);

                        Scanner linhaScanner = new Scanner(linha);
                        linhaScanner.useLocale(Locale.US);
                        linhaScanner.useDelimiter(",");

                        String tipoConta = linhaScanner.next();
                        int agencia = linhaScanner.nextInt();
                        int numero = linhaScanner.nextInt();
                        String titular = linhaScanner.next();
                        double saldo = linhaScanner.nextDouble();

                                                System.out.format(new Locale("pt", "BR"), "%s - %04d-%08d, %20s: %05.2f %n",
                                                                                                                            tipoConta, agencia, numero, titular, saldo);

                        linhaScanner.close();

//                        String[] valores = linha.split(",");
//                        System.out.println(valores[3]);
                }
                scanner.close();
        }
}COPIAR CÓDIGO
```

Com isso nossa formatação já retorna ao modelo antigo, em três linhas separadas.