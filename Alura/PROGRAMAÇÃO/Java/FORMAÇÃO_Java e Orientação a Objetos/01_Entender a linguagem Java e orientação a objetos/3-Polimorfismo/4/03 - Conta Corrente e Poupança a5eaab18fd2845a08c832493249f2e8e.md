# 03 - Conta Corrente e Poupança

Anteriormente, vimos como lidar com construtores, e aprendemos que eles não são herdados.

Veremos agora como podemos manipular nossas classes `ContaPoupanca` e `ContaCorrente`.

Primeiro, criaremos uma classe para teste, chamada `TesteContas`:

```
public class TesteContas {

        public static void main(String[] args) {

        }
}COPIAR CÓDIGO
```

Criaremos um objeto `ContaCorrente`. Escreveremos `CC`, e utilizaremos o atalho "Ctrl + Espaço", o Eclipse nos mostra a opção `ContaCorrente`:

```
public class TesteContas {

        public static void main(String[] args) {

            ContaCorrente cc = new ContaCorrente(111, 111);
            cc.deposita(100.0);

        }
}COPIAR CÓDIGO
```

Criaremos também um objeto `ContaPoupanca`:

```
public class TesteContas {

        public static void main(String[] args) {

            ContaCorrente cc = new ContaCorrente(111, 111);
            cc.deposita(100.0);

            ContaPoupanca cp = new ContaPoupanca(222, 222);
            cp.deposita(200.0);

        }
}COPIAR CÓDIGO
```

Importante notar que o método `deposita()` não está presente nem na classe `ContaCorrente`, tampouco na `ContaPoupanca`. Estamos reutilizando os métodos da classe `Conta`.

Queremos então transferir dinheiro, para isso, utilizamos o método `transfere()`:

```
public class TesteContas {

        public static void main(String[] args) {

            ContaCorrente cc = new ContaCorrente(111, 111);
            cc.deposita(100.0);

            ContaPoupanca cp = new ContaPoupanca(222, 222);
            cp.deposita(200.0);

            cc.transfere(10.0, cp);

        }
}COPIAR CÓDIGO
```

O que indica que queremos transferir R$10,00, da conta corrente `111`, para a conta poupança `222`.

Executaremos a classe `TestaContas`. Temos o seguinte resultado no console:

```
O total de contas é 1
Estou criando uma conta 111
O total de contas é 2
Estou criando uma conta 222COPIAR CÓDIGO
```

Não conseguimos visualizar as operações porque não criamos os respectivos métodos de impressão, para que fosse possível visualizá-las:

```
public class TesteContas {

        public static void main(String[] args) {

            ContaCorrente cc = new ContaCorrente(111, 111);
            cc.deposita(100.0);

            ContaPoupanca cp = new ContaPoupanca(222, 222);
            cp.deposita(200.0);

            cc.transfere(10.0, cp);

            System.out.println("CC: " + cc.getSaldo());
            System.out.println("CP: " + cp.getSaldo());

        }
}COPIAR CÓDIGO
```

As saídas que observamos originam no construtor da classe mãe, confirmando que é ele quem estamos chamando. Como não queremos ver estas saídas no momento, as deixaremos em comentários:

```
public class Conta {

//Código omitido

public Conta(int agencia, int numero) {
Conta.total++;
//System.out.println("O total de contas é " + Conta.total);
this.agencia = agencia;
this.numero = numero;
this.saldo = 100;
//System.out.println("Estou criando uma conta " + this.numero);COPIAR CÓDIGO
```

Executaremos `TesteContas` mais uma vez. O console apresenta o seguinte:

```
CC: 190.0CP: 310.0COPIAR CÓDIGO
```

Mas, como podemos observar, os valores estão incorretos. Isso ocorreu porque, no construtor, inicializamos o `saldo` em 100, assim, ambos resultados parecem estar acrescidos de 100. Comentaremos esta linha também:

```
public class Conta {

//Código omitido

public Conta(int agencia, int numero) {
Conta.total++;
//System.out.println("O total de contas é " + Conta.total);
this.agencia = agencia;
this.numero = numero;
//this.saldo = 100;
//System.out.println("Estou criando uma conta " + this.numero);COPIAR CÓDIGO
```

Executando novamente, temos o seguinte resultado:

```
CC: 90.0CP: 210.0COPIAR CÓDIGO
```

Como vimos, ganhamos todas as funcionalidades da classe mãe, `Conta`.

Onde podemos observar o polimorfismo?

Temos o método `transfere` como exemplo:

```
public class Conta {

//Código omitido

public boolean transfere(double valor, Conta destino) {

    if(this.saca(valor)) {
        destino.deposita(valor);
        return true;
    } else {
        return false;
    }
}

//Restante do código omitidoCOPIAR CÓDIGO
```

Recebemos como parâmetro a `Conta`, ou seja, o tipo genérico, não sabemos ainda se é uma conta corrente, ou conta poupança. Este código funciona por causa do polimorfismo, temos a referência do tipo genérico, que pode apontar para qualquer um mais específico, no caso, tanto `ContaCorrente`, quanto `ContaPoupanca`.

Nosso chefe então nos ligou e comentou que, para a `ContaCorrente`, as regras de saque têm que ser diferentes das da `ContaPoupanca`. Qual seria a regra? Ao sacar, deve ser cobrada uma taxa de R$0,20. Este comportamento é específico da `ContaCorrente`.

Na classe mãe, `Conta`, já temos um método `saca()`, iremos redefinir o comportamento deste método, na classe `ContaCorrente`.

Como o Eclipse sabe que estamos estendendo a classe `Conta`, ao escrevermos `saca` e utilizarmos o atalho "Ctrl + Espaço", ele nos dá a opção de sobrescrever, ou reescrever, o método, isso é expressado pela palavra ***override***. Clicaremos duas vezes sobre esta opção, e temos o seguinte código:

```
public class ContaCorrente extends Conta {

        public ContaCorrente(int agencia, int numero) {
            super(agencia, numero);
        }

        @Override
        public boolean saca(double valor) {
            // TODO Auto-generated method stub
            return super.saca(valor);
        }
}COPIAR CÓDIGO
```

O Eclipse nos gerou, automaticamente, o esboço do método.

Ele utiliza o `@Override`, que chamamos de uma **anotação** na configuração do código Java. Esta configuração é para o compilador.

Quando falamos sobre as regras de sobrescrita, vimos que algumas podem ser objeto disso e outras não. Aprendemos também que a assinatura deve ser igual.

Se na classe `Conta` o modificador de visibilidade é público, na classe `ContaCorrente` ele também deve ser `public`, o mesmo para o retorno, como tínhamos um `boolean`, este também será. O nome do método também deve ser o mesmo, ou seja, se lá se chama `saca`, aqui também deverá ter este nome. Os parâmetros também devem ser idênticos.

Para que tudo isso tenha efeito, o compilador precisa saber que a intenção de sobrescrever o método existe de fato.

Para exemplificar, apagaremos o `@Override`:

```
public class ContaCorrente extends Conta {

        public ContaCorrente(int agencia, int numero) {
            super(agencia, numero);
        }

        public boolean saca(double valor) {
            // TODO Auto-generated method stub
            return super.saca(valor);
        }
}COPIAR CÓDIGO
```

Salvaremos e percebemos que o código continua funcionando. Agora, alteraremos o nome do método, para `sacar()`:

```
public class ContaCorrente extends Conta {

        public ContaCorrente(int agencia, int numero) {
            super(agencia, numero);
        }

        public boolean sacar(double valor) {
            // TODO Auto-generated method stub
            return super.saca(valor);
        }
}COPIAR CÓDIGO
```

Nossa intenção era sobrescrever o método mas, por engano, erramos o nome, de `saca` para `sacar`, por exemplo. O Eclipse não aponta um erro de compilação, isso porque interpreta como um novo método, em vez de sobrescrever.

Por isso, é importante utilizarmos o `@Override`, assim, o compilador sabe que a intenção é de sobrescrever o método:

```
public class ContaCorrente extends Conta {

        public ContaCorrente(int agencia, int numero) {
            super(agencia, numero);
        }

        @Override
        public boolean sacar(double valor) {
            // TODO Auto-generated method stub
            return super.saca(valor);
        }
}COPIAR CÓDIGO
```

Desta forma, o Eclipse aponta um erro de compilação, pois não encontrará o método `sacar` na classe mãe. Corrigiremos para o nome correto, `saca`:

```
public class ContaCorrente extends Conta {

        public ContaCorrente(int agencia, int numero) {
            super(agencia, numero);
        }

        @Override
        public boolean saca(double valor) {
            return super.saca(valor);
        }
}COPIAR CÓDIGO
```

Assim, queremos fazer a operação de saque e, ainda, subtrair os R$0,20 referentes à taxa da operação.

Criaremos uma variável `valorASacar`, que recebe o valor a ser sacado, mais a taxa:

```
public class ContaCorrente extends Conta {

        public ContaCorrente(int agencia, int numero) {
            super(agencia, numero);
        }

        @Override
        public boolean saca(double valor) {
            double valorASacar = valor + 0.2;
            return super.saca(valor);
        }
}COPIAR CÓDIGO
```

Aproveitando o código criado pelo Eclipse, chamaremos o super, ou seja, subiremos na hierarquia, para chamarmos o método `saca` da classe `Conta`, a única alteração será no `valor`, que passará a ser `valorASacar`:

```
public class ContaCorrente extends Conta {

        public ContaCorrente(int agencia, int numero) {
            super(agencia, numero);
        }

        @Override
        public boolean saca(double valor) {
            double valorASacar = valor + 0.2;
            return super.saca(valorASacar);
        }
}COPIAR CÓDIGO
```

Retornaremos à classe `TesteContas`, e a executaremos. Temos o seguinte resultado:

```
CC: 89.8CP: 210.0COPIAR CÓDIGO
```

Funcionou. Os R$10,00 foram sacados e ainda foi cobrada a taxa da operação. Isso é mais uma prova do polimorfismo. Na classe `TesteContas`:

```
public class TesteContas {

        public static void main(String[] args) {

            ContaCorrente cc = new ContaCorrente(111, 111);
            cc.deposita(100.0);

            ContaPoupanca cp = new ContaPoupanca(222, 222);
            cp.deposita(200.0);

            cc. transfere(10.0, cp);

            //Restante do código omitidoCOPIAR CÓDIGO
```

Podemos clicar no método `transfere()` e somos automaticamente redirecionados para onde ele está localizado, na classe `Conta`:

```
public class Conta {

//Código omitido

public boolean transfere(double valor, conta destino) {
    if(this.saca(valor)) {
        destino.deposita(valor);
        return true;
    } else {
        return false;
    }
}

//Código omitidoCOPIAR CÓDIGO
```

Quando utilizamos o `this.saca`, estamos chamando o método `saca` com o `valor`, pra `destino.deposita` temos a mesma coisa, é feita uma referência, o `this` é uma referência.

Na classe `TesteContas`, quando utilizamos o `cc.transfere`, o `this` tem o mesmo valor de `cc`, ou seja, o `this` é a seta que aponta para um objeto do tipo `ContaCorrente`. Qual método `saca()` é chamado então? O da classe `Conta` ou da `ContaCorrrente`?

É chamado o método mais específico, ou seja, o da `ContaCorrente`, por isso, ao executarmos a classe `TesteContas` já obtivemos o resultado desejado. Mais um exemplo de polimorfismo.

Vamos fazer os exercícios e nos vemos na próxima!