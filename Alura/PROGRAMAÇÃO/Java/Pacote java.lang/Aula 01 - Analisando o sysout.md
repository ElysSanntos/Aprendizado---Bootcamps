# Aula 01 - Analisando o sysout

Continuaremos nosso curso de `java.lang`, aprendendo mais sobre o pacote e suas classes.

Analisaremos rapidamente uma linha que estamos utilizando desde o início do projeto:

```
//...
System.out.println("Alura");
//...COPIAR CÓDIGO
```

Temos três partes que compõem essa linha, separadas por meio de um ponto (`.`), são elas `System`, `out` e `println`. Vamos dissecar essa linha e entender o que são cada um desses elementos.

Primeiro, o `System`.

Sabemos que se trata de uma classe, afinal a palavra se inicia com letra maiúscula, e que provém do pacote `java.lang`, portanto não é necessário importa-la.

No que diz respeito a visibilidade, a classe `System` deve ser pública, caso contrário não conseguiríamos acessa-la.

Em segundo lugar, analisaremos o `out`.

Sabemos que não se trata de uma classe, afinal não se inicia com letra maiúscula, tampouco trata-se de um método.

`out` é um atributo público para que seja acessível fora de sua classe. A próxima questão que devemos nos perguntar é: este atributo é um primitivo? Suponhamos a classe `System`:

```
public class System {

    public ???? out

}COPIAR CÓDIGO
```

Está faltando definir esse atributo. Qual seria a melhor forma de fazer isso? Inserindo `int` ou `double`? Na verdade, isso não seria nem possível pois o `out` está entre pontos. Nas aulas anteriores aprendemos que uma variável que representa um primitivo não pode conter pontos, pois um primitivo é apenas um valor que não possui um método associado a ele, pois não é baseado em um classe.

O espaço só pode ter sido preenchido por uma outra classe, `out` é uma referência. Não sabemos o tipo da referência, pois essa informação não está visível quando analisamos a linha de código.

Sabemos outro dado interessante sobre o atributo `out`; quando falamos sobre a conta no bytebank, no princípio o saldo era público, portanto criávamos uma `Conta` e, mediante uma referência, acessávamos um objeto `saldo`.

```
Conta c =  new Conta();
c.saldo = 55.5;COPIAR CÓDIGO
```

Para acessarmos o `saldo` utilizamos a referência, lembrando que `saldo` é um atributo público da classe `Conta`.

No caso, o `out` é acessado por meio de uma classe, a `System`. O que significa que há um `static` dentro da classe `System`, ou seja, temos um `public static`, mas ainda não sabemos o tipo da referência.

```
public class System {

    public static ???? out

}COPIAR CÓDIGO
```

Concluímos, então, que o nosso `out` possui acesso estático.

Já vimos esse conteúdo nas aulas anteriores, muito embora ele ainda não esteja tão sedimentado e necessita de estudo e prática.

O próximo elemento é o `println()`.

Não é uma classe, tampouco um atributo e, sim, um método. Podemos verifica-lo observando os parênteses `()`. É publico e pode ser utilizado fora do pacote de origem. Será que este método possui um acesso estático? Para respondermos a essa pergunta, devemos observar o elemento anterior na linha de código, ou seja, o `out`. Da mesma forma que olhamos para `System` ao definirmos o acesso de `out`.

Como o elemento anterior ao `println()` é uma referência, o método não possui acesso estático.

Há algumas outras informações acerca de `println()`: ele pode receber uma `String`, mas também um `int`. Aparentemente, exitem várias versões de um mesmo método, ou seja, muitas sobrecargas. Atenção, não confundam **sobrecarga** com **sobrescrita**, esta última é relacionada à herança, possui a mesma assinatura e não pode variar nos parâmetros.

Sabemos que `println()` não joga exceções do tipo `checked`, nunca fomos obrigados a fazer algum tratamento de exceção.

Observem como a linha de código `System.out.println()` é compacta, e quantas informações podemos retirar dela.

Nas próximas aulas aprenderemos novos recursos do pacote `java.lang`.