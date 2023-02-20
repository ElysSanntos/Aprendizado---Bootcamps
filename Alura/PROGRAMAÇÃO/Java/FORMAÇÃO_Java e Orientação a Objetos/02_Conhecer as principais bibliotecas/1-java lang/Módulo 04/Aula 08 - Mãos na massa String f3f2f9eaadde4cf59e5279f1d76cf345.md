# Aula 08 - Mãos na massa: String

Vamos conhecer melhor a classe `String` do pacote `java.lang`.

1) No pacote `br.com.bytebank.banco.test` crie uma nova classe `TesteString` já com método `main`

```
package br.com.bytebank.banco.test;

public class TesteString {

    public static void main(String[] args) {
    }
}COPIAR CÓDIGO
```

2) Dentro do método `main` use uma vez a sintaxe literal e a sintaxe normal para criar um objeto `String`:

```
public static void main(String[] args) {

    String nome = "Mario"; //object literal
    String outro = new String("Alura"); //má prática, sempre prefere a sintaxe literal
}COPIAR CÓDIGO
```

3) Pratique o método `replace` da classe `String`. Lembrando da imutabilidade de strings:

```
public static void main(String[] args) {

    String nome = "Mario"; //object literal
    String outro = new String("Alura"); //má prática, sempre prefira a sintaxe literal

    String novo = outro.replace("A", "a");

    System.out.println(novo);
}COPIAR CÓDIGO
```

4) Depois pratique os métodos `toUpperCase` e `toLowerCase` para "aumentar" e "diminuir" as letras. Adicione no método `main`:

```
String novo = nome.toLowerCase(); //também teste toUpperCase()

System.out.println(novo);COPIAR CÓDIGO
```

5) Agora teste os métodos `charAt`, `indexOf` e `substring`. No final do método `main` adicione:

```
char c = nome.charAt(3); //char i
System.out.println(c);

int pos = nome.indexOf("rio");
System.out.println(pos);

String sub = nome.substring(1);
System.out.println(sub);COPIAR CÓDIGO
```

6) Agora mostra todas as caracteres linha por linha usando um laço `for` junto com os métodos `length` e `charAt`:

```
for(int i = 0; i < nome.length(); i++) {
    System.out.println(nome.charAt(i));
}COPIAR CÓDIGO
```

7) (Opcional) Pratique mais um pouco e teste alguns outros métodos da classe `String` como `isEmpty`, `trim`, `contains` ou `split`. Para tal, verifique o javadoc:

[https://docs.oracle.com/javase/10/docs/api/java/lang/String.html](https://docs.oracle.com/javase/10/docs/api/java/lang/String.html)