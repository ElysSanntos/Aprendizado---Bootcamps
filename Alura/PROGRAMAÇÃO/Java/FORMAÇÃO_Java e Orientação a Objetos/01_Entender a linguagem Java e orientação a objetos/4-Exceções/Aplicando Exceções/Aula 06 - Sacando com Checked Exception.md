# Aula 06 - Sacando com Checked Exception

Anteriormente, criamos a nossa própria exceção `SaldoInsuficienteException`, do tipo *Unchecked*. Ou seja, ela estende a classe `RuntimeException` e o compilador não nos obriga a fazer nenhum tratamento.

Testaremos também a mesma exceção como *Checked*. Ela estenderá diretamente da classe `Exception` e verá o tratamento. Mas, como faremos esse tratamento?

Repare que, do jeito que a exceção está agora, o compilador não reclama por não ter um tratamento, visto que ela é *unchecked*, mas não tem problema se criarmos um `try-catch`:

```
public static void main(String[] args) {
    Conta conta = new ContaCorrente(123, 321);

    conta.deposita(200.0);
    try {
        conta.saca(210.0);
    } catch(SaldoInsuficienteException ex) {
        System.out.println("Ex: " + ex.getMessage());
    }
    System.out.println(conta.getSaldo());
}COPIAR CÓDIGO
```

Sem o tratamento, a saída no console era assim:

```
Exception in thread "main" SaldoInsuficienteException
        at Conta.saca(Conta.java:25)
        at ContaCorrente.saca(ContaCorrente.java:17)
        at TesteSaca.main(TesteSaca.java:8)COPIAR CÓDIGO
```

E com o tratamento, temos a seguinte saída:

```
Ex: Saldo: 200.0, Valor: 210.2
200.0COPIAR CÓDIGO
```

Já que deu erro, no final foi impresso o valor do saldo de `200.0`. Agora, vamos mudar a classe para o tipo *checked*.

```
public class SaldoInsuficienteException extends Exception {

}COPIAR CÓDIGO
```

Depois que salvarmos essa alteração, aparecerá um problema no método `saca()`, da classe `Conta`, na qual alguém joga `SaldoInsuficienteException`. Levando isso em consideração, precisamos deixar claro na assinatura do método.

```
public void saca(double valor) throws SaldoInsuficienteException {
    if(this.saldo < valor) {
        throw new SaldoInsuficienteException("Saldo: " + this.saldo + ", Valor: " + this.valor);
    }
    this.saldo -= valor;
}COPIAR CÓDIGO
```

Ao salvar, o compilador passa a reclamar no método logo abaixo `transfere()`:

```
public void transfere(double valor, Conta destino) {
    this.saca(valor);
    destino.deposita(valor);
}COPIAR CÓDIGO
```

O `transfere()` chama o `saca()`, ou seja, se `saca()` é perigoso, `transfere()` precisa tomar uma atitude. Escolhemos a opção que deixa claro na assinatura do método que a exceção pode acontecer.

```
public void transfere(double valor, Conta destino) throws SaldoInsuficienteException {
    this.saca(valor);
    destino.deposita(valor);
}COPIAR CÓDIGO
```

Certo. Agora, podemos ver que o erro está na classe `ContaCorrente`. O método `saca()` dessa classe chama o `super.saca()` que no caso, possui o `throws` na assinatura do método dizendo que ele é perigoso. Por causa disso, temos que tomar uma atitude: fazer um `try-catch` ou deixar o `throws` explícito na assinatura.

Dentro da nossa `ContaCorrente`, não faremos o `try-catch` então, ficará assim:

```
@Override
public void saca(double valor) throws SaldoInsuficienteException{
    double valorASacar = valor + 0.2;
    super.saca(valorASacar);
}COPIAR CÓDIGO
```

Veja que uma exceção *checked* dá trabalho, pois o compilador fica verificando todas as classes que chamam o método perigoso. A classe `TesteContas` também está com problemas. Mas, como não estávamos utilizando essa classe, adicionaremos `throws` na assinatura do método `main()`.

```
public static void main(String[] args) throws SaldoInsuficienteException {}COPIAR CÓDIGO
```

Na hora de executar, nada vai mudar. Na execução, o *unchecked* é igual ao *checked*.

Então, se você ainda está com dúvida ou inseguro com esse tópico, não se desespere. É normal. Exceções é um tópico complicado e, com o tempo, praticaremos e nos sentiremos mais seguros com o código.

Ainda falta explicar mais uma ideia em nosso tratamento. Mas para isso, usaremos um outro exemplo, a seguir.