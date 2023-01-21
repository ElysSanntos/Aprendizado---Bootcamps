# Aula 04 - Sacando com Unchecked Exception

Vamos retornar ao projeto final do curso anterior `bytebank-herdado-conta`, no qual temos a seguinte hierarquia:

![https://s3.amazonaws.com/caelum-online-public/834-java-excecoes/05/05.02_001_hierarquia-conta-poupanca-corrente.png](https://s3.amazonaws.com/caelum-online-public/834-java-excecoes/05/05.02_001_hierarquia-conta-poupanca-corrente.png)

A classe mãe é a `Conta`, e as contas que herdam ou estendem da classe mãe são as classes filhas `ContaCorrente` e `ContaPoupanca`. Temos interesse em mexer no método `saca()`, da classe mãe `Conta`. No entanto, o sobrescrevemos na classe `ContaCorrente` e, talvez, você tenha sobrescrito também na classe `ContaPoupanca`.

Ou seja, se alterarmos a assinatura de `saca()` na classe mãe, temos que ter cuidado para alterá-lo na classe filha. Não se esqueça que a *herança* é um relacionamento forte, e que mudanças na classe mãe afetarão as filhas.

Sabendo disso, vamos refatorar o nosso código. Na classe `Conta`, não queremos mais que o método `saca()` devolva um *boolean*. Se funcionar, OK! Se não funcionar, jogaremos uma exceção. Primeiro, esse método retornará `void`.

```
public void saca(double valor) {
    if(this.saldo >= valor) {
        this.saldo -= valor;
        return true;
    } else {
        return false;
    }
}COPIAR CÓDIGO
```

Com essa simples mudança de tipo de retorno, várias partes do código pararam de compilar, inclusive no método `transfere()` que usa o `saca()`. Para interromper o erro, voltaremos como estava, e criaremos a nossa própria exceção.

Com o botão direito no pacote, clicaremos em "New > Class". Para que essa classe, que chamaremos de `SaldoInsuficienteException`, represente uma exceção, é necessário colocá-la na hierarquia, utilizando a herança.

```
public class SaldoInsuficienteException extends RuntimeException {

}COPIAR CÓDIGO
```

Como já aprendemos, criaremos um construtor e passaremos uma mensagem como parâmetro. Depois, chamaremos o construtor da classe mãe e passaremos a mensagem.

```
public class SaldoInsuficienteException extends RuntimeException {
    public SaldoInsuficienteException(String msg) {
        super(msg);
    }
}COPIAR CÓDIGO
```

Pronto! Essa é a nossa exceção. Considerando que ela está pronta, podemos voltar à classe `Conta`, que não irá mais devolver `boolean`, mas sim `void`. Ou seja, não teremos mais retorno.

```
public void saca(double valor) {
    if(this.saldo >= valor) {
        this.saldo -= valor;
    }

}COPIAR CÓDIGO
```

O trabalho com exceções é feito no início do método. Primeiro, testamos se é possível fazer a operação. Se sim, ok. Se não, já lançamos a exceção. Por isso, inverteremos a ordem da regra de negócio.

Se o `saldo` for menor do que `valor` ou insuficiente, teremos um problema. Caso esse não seja a situação, será possível sacar. Dê uma olhada no código abaixo:

```
public void saca(double valor) {
    if(this.saldo < valor) {
        //problema
    }
    this.saldo -= valor;
}COPIAR CÓDIGO
```

Esse é um cenário muito comum! `If` no início do método para verificar se há problemas. Agora é a hora de jogar a exceção, utilizando `throw new`:

```
public void saca(double valor) {
    if(this.saldo < valor) {
        throw new SaldoInsuficienteException("");
    }
    this.saldo -= valor;
}COPIAR CÓDIGO
```

Para saber qual foi o saldo, passamos `Saldo: + this.saldo` como parâmetro da exceção e também o valor sacado.

```
throw new SaldoInsuficienteException("Saldo: " + this.saldo + ", Valor: " + valor);COPIAR CÓDIGO
```

O método `saca()` já está legal! No entanto, temos alguns erros de compilação tanto na classe `Conta`, quanto na classe `ContaCorrente`. Como vimos, o método `transfere()` usa o `saca()`, que devolvia um booleano; e o retorno era colocado em `if`. Entretanto, isso podia ser feito porque `if` recebe algo que é booleano. Agora o método `saca()` não retorna. Portanto, essa chamada não funcionará mais.

Por isso, apagaremos `if`. Se `saca()` não funcionar, será jogado como uma bomba na pilha, sairá abruptamente do método e cairá no método `transfere()`. Se nada resolver essa bomba, ela também sairá abruptamente de `transfere()`.

```
public void transfere(double valor, Conta destino) {
    this.saca(valor);
    destino.deposita(valor);
}COPIAR CÓDIGO
```

Então, só será possível depositar o dinheiro, se `saca()` funcionar. Caso não funcione, sairá abruptamente desse método. Com isso, a classe `Conta` já estará funcionando!

Agora, daremos uma olhada na `ContaCorrente`. Nessa classe, o compilador verifica se estamos sobrescrevendo o método. Vamos arrumar:

```
@Override
public void saca(double valor) {
    double valorASacar = valor + 0.2;
    super.saca(valorASacar);
}COPIAR CÓDIGO
```

Aparentemente, está compilando! Criaremos uma classe de teste `TesteSaca`. Depois, vamos criar a conta e depositar um valor para sacar.

```
public class TesteSaca {
    public static void main(String[] args) {
        Conta conta = new ContaCorrente(123, 321);

        conta.deposita(200.0);
        conta.saca(200.0);

        System.out.println(conta.getSaldo());
    }
}COPIAR CÓDIGO
```

Nesse caso, não deve acontecer nenhuma exceção. Mas, dê uma olhada no console, após ter executado o teste:

```
Exception in thread "main" SaldoInsuficienteException: Saldo: 200.0, Valor: 200.2
        at Conta.saca(Conta.java:25)
        at ContaCorrente.saca(ContaCorrente.java:13)
        at TesteSaca.main(TesteSaca.java:8)COPIAR CÓDIGO
```

Essa exceção aconteceu porque o método `saca()` adiciona um valor, e então não tem como sacar. Vamos alterar o valor do saque para `190.0` e testar novamente. O que temos no console?

```
9.8000000000011COPIAR CÓDIGO
```

Agora, vamos sacar um valor bem maior que depositamos.

```
Exception in thread "main" SaldoInsuficienteException: Saldo: 200.0, Valor: 210.2
        at Conta.saca(Conta.java:25)
        at ContaCorrente.saca(ContaCorrente.java:13)
        at TesteSaca.main(TesteSaca.java:8)COPIAR CÓDIGO
```

Essa exceção começou no método `saca()` da `Conta`. Depois, passou pelo método `saca()` da classe filha `ContaCorrente`, que também não foi resolvido. Por fim, passou pelo método `main()`, no qual não foi resolvido.

Agora, nos resta fazer o tratamento usando `try-catch` e usar uma exceção do tipo *checked*, pois do jeito que está agora, o compilador não nos obriga a fazer um tratamento.