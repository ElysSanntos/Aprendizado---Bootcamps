# Aula 05 - Um erro de compilação...

Clarice, amiga de Fernando, percebeu que ele está com dificuldade na implementação de um loop feito com `while`. Seu objetivo é imprimir no console os números de `1` a `10`. No entanto, o código não compilava. Vejamos seu código:

```
package projeto;

public class Programa {

    public static void main(String[] args) {

        while (contador <= 10) {
            int contador = 1;
            System.out.println(contador);
            contador++;
        }
    }
}COPIAR CÓDIGO
```

Se você estivesse com Clarice agora, como explicaria o problema do código para ela? Depois de pensar em uma explicação, compare-a com a do instrutor a seguir.

Fernando sabiamente se preocupou em incrementar a variável `contador` a cada iteração do while para que o loop chegasse ao fim e não caísse em um loop infinito. Todavia, ele declarou a variável `contador` dentro do bloco do `while`. Por uma questão de escopo, essa variável só existirá dentro do bloco while. Para piorar as contas, a expressão `contador <= 10` tenta acessar uma variável que ainda não foi declarada, razão principal do erro de compilação que esta enfrentado.

Corrigindo o código temos:

```
package projeto;

public class Programa {

    public static void main(String args[]) {

        int contador = 1;

        while (contador <= 10) {
            System.out.println(contador);
            contador++;
        }
    }
}
```