# 07 - Abstract no exemplo Conta

Olá! Neste vídeo, daremos conclusão à esta aula. Para isso, aplicaremos os nossos conhecimentos ao exemplo de `Conta`, `ContaPoupanca` e `ContaCorrente`.

Fecharemos o projeto com o qual estávamos trabalhando, o `bytebank-herdado`, e abriremos o `bytebank-herdado-conta`.

Falamos que, do ponto de vista prático, não deve existir um tipo de objeto que seja somente uma conta, ele deve ser ou corrente ou poupança, mas não queremos apagar a classe `Conta` pois precisamos de seus atributos e métodos.

Para isso, manteremos esta classe, na forma abstrata:

```
public abstract class Conta {

        private double saldo;
        private int agencia;
        private int numero;
        private Cliente titular;
        private static int total = 0;

//Código omitido
COPIAR CÓDIGO
```

Assim, não é possível instanciar objetos da classe `Conta`.

Para ilustrar, abriremos a classe `TesteContas` e tentaremos criar um objeto do tipo `Conta()`:

```
public class TesteContas {

        public static void main(String[] args) {

            new Conta()
//Código omitidoCOPIAR CÓDIGO
```

Nem precisamos terminar de digitar, o Eclipse já nos mostra que não é possível compilar este código. Removeremos esta linha portanto.

Uma classe abstrata pode ter atributos? Sim! São eles que serão herdados pelas classes filhas. Ela pode ter construtores? Sim! Estes construtores não são herdados diretamente, mas podem ser chamados em classes filhas por meio do `super`. A classe abstrata pode ter métodos? Sim! E os filhos herdam estas funcionalidades.

Tudo continua válido, a única vedação é o instanciamento de objetos do tipo da classe abstrata.

Para praticarmos os métodos abstratos, utilizaremos o `abstract` no método `deposita`:

```
public abstract class Conta {

        private double saldo;
        private int agencia;
        private int numero;
        private Cliente titular;
        private static int total = 0;

//Código omitido

        public abstract void deposita(double valor) {
            this.saldo = this.saldo + valor;
        }

//Código omitidoCOPIAR CÓDIGO
```

Assim que colocarmos o `abstract`, o Eclipse indicará um erro, pois não podemos fazer isso e, ao mesmo tempo, manter a implementação. Por isso, removeremos todo o corpo do método:

```
public abstract class Conta {

        private double saldo;
        private int agencia;
        private int numero;
        private Cliente titular;
        private static int total = 0;

//Código omitido

        public abstract void deposita(double valor);

//Código omitidoCOPIAR CÓDIGO
```

Agora as classes filhas serão obrigadas a implementar este método.

Na classe `ContaCorrente`:

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

O Eclipse já indica que precisamos implementar o método `deposita`. Ele nos oferece um esboço, criado automaticamente, deste código, que ficaria desta forma:

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

        @Override
        public void deposita(double valor) {
                //TODO Auto-generated method stub
        }
}COPIAR CÓDIGO
```

Nosso trabalho agora será implementar o `deposita`.

Acessaremos o `saldo` da classe mãe, com o `super`. Entretanto, ele não é visível, pois tem um modificador de visibilidade privado. Podemos alterá-lo para `protected`, liberando o atributo para os filhos:

```
public abstract class Conta {

        protected double saldo;
        private int agencia;
        private int numero;
        private Cliente titular;
        private static int total = 0;

//Código omitidoCOPIAR CÓDIGO
```

Assim, podemos acessar o método `deposita` a partir da classe `ContaCorrente`:

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

        @Override
        public void deposita(double valor) {
            super.saldo += valor;
        }
}COPIAR CÓDIGO
```

Faremos o mesmo para a classe `ContaPoupanca`:

```
public class ContaPoupanca extends Conta {

        public ContaPoupanca(int agencia, int numero) {
            super(agencia, numero);
        }

        @Override
        public void deposita(double valor) {
            super.saldo += valor;
        }
}COPIAR CÓDIGO
```

Em seguida, abriremos a classe `TesteContas`, e a executaremos. No console, temos o seguinte resultado:

```
CC: 89.8CP: 210.0COPIAR CÓDIGO
```

Tudo continua funcionando.

Mais uma vez, praticamos o conceito de `abstract` tanto para a classe, quanto para o método.