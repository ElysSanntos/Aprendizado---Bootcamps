# Aula 14 - Desafio Opcional: Múltiplos de 3

Segue mais um exercício para praticar o laço `for`!

---

**Utilize um laço do tipo `for` para imprimir todos os múltiplos de 3, entre 1 e 100.**

Dica: Existem duas maneiras tradicionais de resolver este problema. Uma delas consiste em fazer o `for`, e utilizar `numero % 3` para descobrir o resto da divisão de um número por 3 (o operador `%` se chama de *módulo*). Se o resto for zero, ele é divisível por 3. Como em:

```
if(numero % 3 == 0) {
  // faça algo
}COPIAR CÓDIGO
```

Outra abordagem é fazer um laço um pouco diferente, que pula já direto pelos múltiplos de três. Existem outras abordagens, escolha a sua e faça a implementação em uma nova classe!

A abordagem que utiliza o resto da divisão é:

```
class MultiplosDeTresAteCem {
    public static void main (String[] args) {
        for (int i = 1; i < 100; i++ ){
            if (i % 3 == 0)    {
                System.out.println(i);
            }
        }
    }
}COPIAR CÓDIGO
```

ou, entre outras tantas opções, a mais simples:

```
class MultiplosDeTresAteCem {
    public static void main (String[] args) {
        for (int i = 3; i < 100; i += 3 ){
            System.out.println(i);
        }
    }
}
```