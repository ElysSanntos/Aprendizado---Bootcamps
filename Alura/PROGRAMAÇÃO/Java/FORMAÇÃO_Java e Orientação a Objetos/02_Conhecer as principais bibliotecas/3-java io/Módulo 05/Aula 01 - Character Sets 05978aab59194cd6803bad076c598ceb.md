# Aula 01 - Character Sets

> O novo arquivo contas.csv pode ser baixado [aqui](https://s3.amazonaws.com/caelum-online-public/857-java-io/05/contas.csv). E caso queira, você pode fazer o [download](https://s3.amazonaws.com/caelum-online-public/857-java-io/05/java7-aula5.zip) do projeto completo feito até a aula anterior.
> 

Olá! Bem-vindos novamente ao curso `java.io`.

É comum encontrarmos textos na internet onde há caracteres estranhos, que nos impedem de compreende-los por inteiro. É o caso da imagem a seguir:

![https://i.stack.imgur.com/590Tg.png](https://i.stack.imgur.com/590Tg.png)

Estes problemas estão relacionados com o pacote `java.io`, mas não são exclusivos à esta linguagem, acontecem em muitos outros casos.

Nesta aula, entenderemos o motivo pelo qual isto acontece, e o que podemos fazer para solucionarmos este tipo de erro, em Java. Isto é muito importante na vida prática de um programador.

Nas aulas anteriores, havíamos trabalhado com um arquivo no formato `.csv`, com as seguintes informações:

```
CC,22,33,Nico Steppat,232.9
CP,11,44,Paulo Silveira,2167.0
CC,22,11,Sérgio Lopes,2200.3COPIAR CÓDIGO
```

A seguir, temos a apresentação binária deste arquivo:

```
01000011 01000011 00101100 00110010 00110010 00101100
00110011 00110011 00101100 01001110 01101001 01100011
01101111 00100000 01010011 01110100 01100101 01110000
01110000 01100001 01110100 11100011 11100011 00101100
00110010 00110000 00110000 00101110 00110000 00001010COPIAR CÓDIGO
```

Onde a letra `C` é representada pela sequência binária `01000011`, e assim sucessivamente, cada caractere é convertido em uma sequência de `1` e `0`.

Há padrões de conversão de caracteres em binários, e um dos mais comuns está registrado na tabela [ASCII](https://www.asciitable.com/) (*American Standard Code for Information Interchange*). Temos a letra, e a ela há um número associado, a partir deste, é criada uma sequência binária. Por exemplo, a letra C é representada pelo número 67, e resulta na sequência `01000011`.

Contudo, temos um problema pois esta tabela engloba todos os caracteres da língua inglesa, mas como sabemos há outros além destes. Por exemplo, aqueles que são acentuados. Há ainda outros alfabetos, com símbolos diferentes.

Para solucionar este problema, foram criadas as *[codepages](http://www.ascii.ca/ascii_standard.htm)*, único formato capaz de englobar a quantidade de informação correspondente ao número de línguas e caracteres existentes.

Temos por exemplo a [página](http://www.ascii.ca/iso8859.1.htm) com a apresentação dos caracteres latinos, que contém as vogais com todos os tipos de acentuação.

Isto é útil quando estamos pensando em um sistema contido, entretanto, ao trabalharmos em rede, pode haver complicações, como a da página que vimos no começo desta aula.

Para tentar unificar os padrões, e minimizar este tipo de problemas, foi criado o ***unicode***. Trata-se de uma [tabela](https://en.wikipedia.org/wiki/List_of_Unicode_characters) cujo objetivo é de apresentar todos os caracteres existentes no mundo.

Ela também conta com um número associado a cada caractere.

Contudo, o *unicode* não define a forma como as informações devem ser armazenadas no HD, isto é tarefa dos ***encodings***. É o caso dos "UTFs", como o `UTF-8` e `UTF-16`, esta sigla significa "*Unicode Transformation Format*. Ela está vinculada desde o nascimento com a tabela de Unicode, para traduzir os *codepoints* para um formato binário.

Além do `UTF` há outros exemplos de *Encodings*, como o `ASCII` e o `Windows 1252`. Adiante, veremos como eles podem variar de acordo com o sistema operacional.