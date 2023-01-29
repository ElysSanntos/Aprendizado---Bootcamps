# Aula 08 - De Array para List

A partir de agora vamos usar as listas para fugir das desvantagens do array. No entanto, se lembra do nosso array `String[]` do método `main`? Com certeza, e não podemos mudar a assinatura do método `main` pois a JVM não aceita isso. Bom, já que não podemos alterar a assinatura será que não tem uma forma de transformar uma array em uma lista? Claro que existe, e para tal, existe já uma classe que ajuda nessa tarefa: `java.util.Arrays`

A classe `java.util.Arrays` possui vários métodos estáticos auxiliares para trabalhar com arrays. Veja como fica simples de transformar um array para uma lista:

```
public class Teste {

  public static void main(String[] args) {
    List<String> argumentos = Arrays.asList(args);
  }
}COPIAR CÓDIGO
```

Vamos ver ainda outras funcionalidades da classe `java.util.Arrays`