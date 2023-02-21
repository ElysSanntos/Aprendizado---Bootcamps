# Aula 09 - Mãos na massa: Lambdas

1) Ainda na classe `Teste` vamos diminuir a burocracia de nosso código. Começaremos usar uma lambda expression para substituir toda classe anônima. Altere o método `sort`:

```
lista.sort( (c1, c2) -> Integer.compare(c1.getNumero(), c2.getNumero()) );COPIAR CÓDIGO
```

2) Analogamente para o trecho de código:

```
Comparator<Conta> comp = new Comparator<Conta> {

    @Override
    public int compare(Conta c1, Conta c2) {
        String nomeC1 = c1.getTitular().getNome();
        String nomeC2 = c2.getTitular().getNome();
        return nomeC1.compareTo(nomeC2);
    }
};COPIAR CÓDIGO
```

Use o seguinte:

```
Comparator<Conta> comp = (Conta c1, Conta c2) -> {
                String nomeC1 = c1.getTitular().getNome();
                String nomeC2 = c2.getTitular().getNome();
                return nomeC1.compareTo(nomeC2);
        };COPIAR CÓDIGO
```

3) Também podemos fazer a mesma coisa para o nosso `System.out.println`, deixando-o bem mais elegante e legível.

Faça o laço do seguinte modo:

```
lista.forEach( (conta) -> System.out.println(conta + ", " + conta.getTitular().getNome()));COPIAR CÓDIGO
```

Uma vez acostumado com a sintaxe dos lambdas escrevemos menos códigos sem prejudicar a legibilidade.