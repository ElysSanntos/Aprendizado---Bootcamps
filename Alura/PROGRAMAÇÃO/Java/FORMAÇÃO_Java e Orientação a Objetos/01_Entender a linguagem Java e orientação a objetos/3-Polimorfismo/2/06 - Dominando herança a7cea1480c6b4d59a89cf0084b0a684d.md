# 06 - Dominando herança

Sobre herança em Java, julgue as seguintes afirmativas:

1) Uma classe pode ter várias filhas, mas apenas uma mãe.

2) A partir de uma instância de uma classe filha, podemos chamar qualquer método público que tenha sido declarado na classe mãe.

3) Na classe filha, podemos escolher o que herdar da classe mãe.

4) No exemplo abaixo, `Cachorro` também herda tudo da classe `Animal`:

```
class Animal {
    // atributos e métodos
}

class Mamifero extends Animal {
    // atributos e métodos
}

class Cachorro extends Mamifero {
    // atributos e métodos
}COPIAR CÓDIGO
```

Quais afirmativas estão corretas?

Apenas as afirmativas 1, 2 e 4 estão corretas.

Pode-se sim chamar qualquer método da classe mãe. Uma classe pode ter diversas "filhas e netas" (que herdam umas das outras) mas não podemos escolher o que será herdado.

- não podemos escolher o que pode ser herdado por outra classe.