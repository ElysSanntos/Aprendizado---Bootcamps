# Aula 06 - Métodos da classe String

Nesta aula, faremos mais experimentos com a classe `String`, e conheceremos mais alguns métodos importantes. Lembrando que vale a pena explorar a documentação oficial do Java para estudar melhor o funcionamento da classe em detalhes.

Na última aula fizemos uso do método `toLowerCase()`, em oposição a ele temos o método `toUpperCase()` que converte as letras para maiúsculas.

Falamos, também, que existem duas versões do método `replace()`, e os dois variam nos parâmetros, ambos recebem dois, mas os tipos são diferentes. O conceito de métodos que variam nos tipos de parâmetros é chamado de **sobrecarga**, muito comum no mundo Java.

Veremos que um dos `replace()` recebe `CharSequence` e outro um `char`; o primeiro está relacionado a conversão de um conjunto de caracteres, por exemplo:

```
String outra = nome.replace("Al", "aL");COPIAR CÓDIGO
```

A outra opção altera apenas um caractere. É importante lembrar que no mundo Java um único caractere é acompanhado de aspas simples.

```
String outra = nome.replace('A', 'a');COPIAR CÓDIGO
```

Esse tipo é chamado `char`, ou seja, uma `String` que contém apenas um caractere. Observem um exemplo ainda mais claro:

```
char c = 'A'
char d = 'a'

String outra = nome.replace(c,d);COPIAR CÓDIGO
```

Em seguida, conheceremos o método `charAt()`.

Suponhamos que você tenha uma String e queira saber qual é o caractere que ocupa uma posição específica. Faremos um exemplo com a posição `2`, e imprimiremos o resultado, observe:

```
String nome = "Alura";

char c = nome.charAt(2);
System.out.println(c);COPIAR CÓDIGO
```

Percebam que o resultado impresso foi a letra `u`, o que pode parecer um pouco estranho, uma vez que a segunda letra da String `Alura` seria `l`. Por que isso ocorreu? O Java, como quase todas as linguagens, trabalha com o numeral inicial "0", portanto:

```
A = 0
L = 1
U = 2
R = 3
A = 4COPIAR CÓDIGO
```

O próximo método que conheceremos é o `indexOf()`.

Esse método possui muitas variantes, recebendo diferentes parâmetros. Usaremos o método que recebe uma String. Para o método podemos passar uma sequencia de caracteres, passaremos `ur`. Assim feito, podemos perguntar qual é a posição dessa String dentro de `Alura`.

```
String nome = "Alura";

int pos = nome.indexOf("ur");
System.out.println(pos);COPIAR CÓDIGO
```

Será impressa a posição `2`. O método `indexOf()` opera de forma inversa ao `charAt()`, uma vez que aquele com base no caractere exibe sua posição, e este utiliza a posição para exibir o caractere.

Existe um método que possibilita a criação de uma sub-String, chamado apropriadamente de `substring()`. Este método possui duas sobrecargas. A primeira informação que vamos fornecer é a partir de que posição iniciamos a contagem; colocaremos `1`.

```
String nome = "Alura";

String sub = nome.substring(1);
System.out.println(sub);COPIAR CÓDIGO
```

Ao executarmos o código, teremos o resultado impresso de `lura`.

Muitas vezes precisamos saber qual é o tamanho de uma determinada `String`, para isso utilizamos o método `length()`.

```
String nome = "Alura";
System.out.println(nome.length());COPIAR CÓDIGO
```

O valor impresso será `5`, como o esperado. Com isso, podemos criar um laço, iniciando por `0`, e imprimirmos caractere por caractere utilizando o método `charAt()`.

```
String nome = "Alura";
System.out.println(nome.length());

for(int i = 0; i < nome.length(); i++) {
    System.out.println(nome.charAt(i));
}COPIAR CÓDIGO
```

Tereremos o seguinte resutaldo impresso:

```
5
A
l
u
r
aCOPIAR CÓDIGO
```

O próximo método que conheceremos é o `isEmpty()`, em que podemos perguntar se a String está vazia. Para testarmos esse método criaremos uma ``String` vazia; lembrando que esse objeto existe, apenas não possui nenhum caractere, em uma situação real para exemplificarmos: uma `String` vazia pode representar um campo de formulário que não foi preenchido pelo usuário.

```
String vazio = "";
System.out.println(vazio.isEmpty());COPIAR CÓDIGO
```

Recebemos como retorno um booleano, neste caso, recebemos um `true`. Se inserirmos um espaço na `String`, do ponto de vista do Java, não teremos mais uma String vazia, e o resultado será `false`.

Como do ponto de vista do usuário um espaço não é considerado um caractere, iremos utilizar outro método para anular todos os espaços em uma `String`. Esse método é chamado de `trim()`, e ele devolve uma nova apresentação, que chamaremos de `outroVazio`.

```
String vazio =" ";
String outroVazio = vazio.trim();

System.out.println(outroVazio.isEmpty());COPIAR CÓDIGO
```

O resultando é `true`, afinal, removemos todos os espaços e temos efetivamente uma `String` vazia.

Para deixarmos mais claro como o método `trim()` opera, iremos escrever `Alura` em `String vazio` e adiconaremos muitos espaços extras, tanto no começo como ao final da palavra.

```
String vazio ="    Alura    ";
String outroVazio = vazio.trim();

System.out.println(outroVazio);COPIAR CÓDIGO
```

Com o uso do método que remove os espaços da String, temos o seguinte resultado

```
AluraCOPIAR CÓDIGO
```

Reparem em como seria a impressão sem o uso do método `trim()`

```
    AluraCOPIAR CÓDIGO
```

O último método que veremos nesta aula é o `contains()`. Este método verifica se uma String possui uma sub-String. Perguntaremos se a `String vazio` possui uma sub-String `Alu`.

```
String vazio ="    Alura    ";
String outroVazio = vazio.trim();

System.out.println(vazio.contains("Alu"));COPIAR CÓDIGO
```

O valor impresso será `true`, como o esperado.

Aprendemos vários métodos relacionados a String que podem nos ajudar no dia a dia.