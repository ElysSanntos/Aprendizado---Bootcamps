# 04 - Sobrescrita

Vimos que a sobrescrita é um conceito importante na herança, pois permite redefinir um comportamento previsto na classe mãe através da classe filha.

Agora veja a classe `Veiculo` abaixo:

```
class Veiculo {

    public void liga() {
        // alguma implementação
    }
}COPIAR CÓDIGO
```

E a classe filha `Carro`:

```
class Carro extends Veiculo {
    // ????
}COPIAR CÓDIGO
```

No que aprendemos até agora, qual dos métodos abaixo inserido no lugar de **`// ????`** **sobrescreve corretamente** o método `liga`?

`public void liga() {
    // implementação
}`

Correto! Repare que o método possui a mesma *assinatura*. Isto é, a mesma *visibilidade*, mesmo *retorno*, mesmo *nome* e os mesmos *parâmetros*.

- Como regra de ouro, na sobrescrita a visibilidade não pode diminuir, deve ser a mesma ou maior!