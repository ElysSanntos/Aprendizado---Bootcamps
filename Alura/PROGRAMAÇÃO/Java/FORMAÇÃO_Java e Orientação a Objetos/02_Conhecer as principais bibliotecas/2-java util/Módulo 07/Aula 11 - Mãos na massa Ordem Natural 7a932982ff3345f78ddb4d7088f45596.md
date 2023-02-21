# Aula 11 - Mãos na massa: Ordem Natural

1) Agora definiremos a ordem natural de ordenação para uma `Conta`. Para isso, primeiramente abra a classe `Conta.java` e a faça implementar a interface `Comparable<Conta>`.

2) Repare que agora somos forçados a implementar o método que a interface nos impõe, `compareTo()` e vamos implementar nossa lógica de comparação:

```
@Override
public int compareTo(Conta outra) {
        return Double.compare(this.saldo, outra.saldo);
}COPIAR CÓDIGO
```

3) Agora teste utilizando o método `sort()` da classe `Collections`:

`Collections.sort(lista);`

4) Repare que agora não teremos problema pois definimos que temos um comparador padrão para a classe `Conta`.

5) Também podemos forçar a ordem natural passando `null` como parâmetro em nosso `lista.sort(null)`.