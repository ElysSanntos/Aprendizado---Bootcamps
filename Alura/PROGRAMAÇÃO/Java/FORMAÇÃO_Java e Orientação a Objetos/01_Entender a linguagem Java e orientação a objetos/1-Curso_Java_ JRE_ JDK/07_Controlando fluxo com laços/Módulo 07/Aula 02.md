# Aula 02 - Enquanto isso, o while...

Fernando decidiu praticar seu conhecimento sobre a estrutura de repetição `while`. Ele escreveu o seguinte programa:

```
package projeto;

public class Programa {

    public static void main(String[] args) {

        int contador = 1;

        while(contador <= 10) {

            System.out.println(contador);
        }
    }
}COPIAR CÓDIGO
```

Todavia, seu programa só imprime no console `1` infinitamente.

Consegue enxergar o problema no código de Fernando? Depois de formar uma opinião compare seu achado com a resposta do instrutor logo em seguida

O while aceita receber dois valores, `true`  e `false` . O valor `true` mantém o loop em execução, já o `false`
 o finaliza. Esses valores podem ser resultados de uma expressão como `contador <= 10` . Todavia, no código de Fernando, ele não incrementou a variável `contador`  a cada iteração do while. Devido a esse esquecimento, a variável `contador`
 sempre mantinha o valor `1`  fazendo com que o programa caísse em um loop infinito.