# Aula 07 - Transformando while em for

Dessa vez, Clarice resolveu desafiar Fernando a transformar o código a seguir que utiliza um laço `while` em um código que utilize o `for`. Você consegue ajudar Fernando a chegar a resposta do desafio? Compare a sua resposta com a do instrutor e verifique se acertou!

```
package projeto;

public class Programa {
    public static void main(String[] args) {
        int contador = 0;
        while(contador <= 10) {
            System.out.println(contador);
            contador++;
        }
    }
}
```

Como visto na aula, o `for` oferece uma opção de declaração mais enxuta, onde precisamos informar dentro dos parênteses do `for` a inicialização da variável que irá servir de auxiliar para a condição de parada, a condição de parada que deve ser verificada como verdadeira para que o laço seja executado e, por fim, a atualização do valor da variável auxiliar. Lembrando que essas informações precisam ser separadas umas das outras por ponto e vírgula `(;)`. A resposta ao desafio ficaria assim:

```
package projeto;

public class Programa {
    public static void main(String[] args) {
        for(int contador = 0; contador <= 10; contador++) {
            System.out.println(contador);
        }
    }
}
```