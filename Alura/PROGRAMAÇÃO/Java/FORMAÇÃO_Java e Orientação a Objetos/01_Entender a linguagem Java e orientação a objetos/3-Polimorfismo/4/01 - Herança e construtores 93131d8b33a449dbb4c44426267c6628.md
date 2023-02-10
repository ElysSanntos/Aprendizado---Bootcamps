# 01 - Herança e construtores

> Começando deste ponto? Você pode fazer o DOWNLOAD completo do projeto anterior e continuar seus estudos a partir daqui.Nesta aula, continuaremos a falar sobre herança, com base na reutilização de código e no polimorfismo. Veremos um novo exemplo de herança, antes de partirmos para novos tópicos.
> 

Voltaremos a utilizar o exemplo da classe `Conta`, com duas filhas, a `ContaCorrente` e a `ContaPoupanca`, ou seja, tipos mais específicos de uma conta.

Abriremos o Eclipse. As classes utilizadas neste projeto estão disponíveis para [download](https://caelum-online-public.s3.amazonaws.com/788-java-heranca-interfaces-polimorfismo/04/java3-aula4.zip).

O primeiro passo será criarmos um novo projeto, selecionando "New > Project...". O nome será `bytebank-herdado-conta`. As classes `Cliente` e `Conta` copiaremos do projeto `bytebank-encapsulado`.

Em seguida, clicaremos com o botão direito do mouse sobre o projeto, e selecionaremos a opção "Close Unrelated Projects", para garantir que todos os arquivos não relacionados ao projeto serão fechados.

Na classe `Conta`, temos:

```
public class Conta {

    private double saldo;
    private int agencia;
    private int numero;
    private Cliente titular;
    private static int total = 0;

    public Conta(int agencia, int numero){
        Conta.total++;
        System.out.println("O total de contas é " + Conta.total);
        this.agencia = agencia;
        this.numero = numero;
        this.saldo = 100;
        System.out.println("Estou criando uma conta " + this.numero);
    }

    public void deposita(double valor) {
        this.saldo = this.saldo + valor;
    }

    public boolean saca(double valor) {
        if(this.saldo >= valor) {
            this.saldo -= valor;
            return true;
        } else {
            return false;
        }
    }

    public boolean transfere(double valor, Conta destino) {
        if(this.saca(valor)) {
                destino.deposita(valor);
                return true;
        } else {
                return false;
        }
    }

    public double getSaldo(){
        return this.saldo;
    }

    public int getNumero(){
        return this.numero;
    }

    public void setNumero(int numero){
        if(numero <= 0) {
            System.out.println("Nao pode valor menor igual a 0");
            return;
        }
        this.numero = numero;
    }

    public int getAgencia(){
        return this.agencia;
    }

    public void setAgencia(int agencia){
       if(agencia <= 0) {
           System.out.println("Nao pode valor menor igual a 0");
           return;
       }
       this.agencia = agencia;
    }

    public void setTitular(Cliente titular){
        this.titular = titular;
    }

    public Cliente getTitular(){
        return this.titular;
    }

    public static int getTotal(){
        return Conta.total;
    }

}COPIAR CÓDIGO
```

Nosso objetivo é, então, criar dois tipos mais específicos de contas. Se pensarmos em um banco, temos contas-poupança ou conta-corrente.

Clicaremos com o botão direito sobre o `(default package)`, e selecionaremos "New > Class". Nomearemos a classe como `ContaCorrente`.

Vemos que, no momento da criação, já é possível definir qual é a classe mãe, na opção "Superclass". Clicaremos em "Browse", e selecionaremos a classe `Conta`. Para concluir, clicaremos em "Finish".

A classe `ContaCorrente` ficou da seguinte forma:

```
public class ContaCorrente extends Conta {

}COPIAR CÓDIGO
```

Já temos o `extends Conta`.

Diferentemente dos nossos exemplos anteriores, o Eclipse nos informa que este código não compila. Qual o problema?

Estamos falando sobre a reutilização de código. Estendendo a `Conta` os atributos e métodos são herdados, entretanto, **os construtores não são herdados**. Os construtores pertencem somente à sua própria classe.

Temos este construtor específico, na classe `Conta`:

```
//Código omitido

    public Conta(int agencia, int numero){
        Conta.total++;
        System.out.println("O total de contas é " + Conta.total);
        this.agencia = agencia;
        this.numero = numero;
        this.saldo = 100;
        System.out.println("Estou criando uma conta " + this.numero);
    }

//Código omitidoCOPIAR CÓDIGO
```

Mas ele não é automaticamente disponível para a classe filha `ContaCorrente`. Por isso, temos que escrever, na classe `ContaCorrente`, nosso próprio construtor:

```
public class ContaCorrente extends Conta {

        public ContaCorrente() {

        }

}COPIAR CÓDIGO
```

O Eclipse aponta um erro. Ao criarmos um objeto, por exemplo `new ContaCorrente()`, seria chamado este construtor, sem parâmetros. Contudo, como estamos utilizando herança, o Java tenta chamar o construtor da classe mãe.

Como estamos utilizando o construtor padrão, ele tenta chamar o construtor padrão da classe mãe.

Neste caso, o compilador insere, automaticamente, uma chamada para o construtor padrão da classe mãe:

```
public class ContaCorrente extends Conta {

        public ContaCorrente() {
            super();
        }
}COPIAR CÓDIGO
```

O `super` significa que subimos na hierarquia, para chamar um método ou atributo da classe mãe. Mas existe um construtor padrão na classe mãe, neste caso? não, porque criamos um construtor específico.

Adicionaremos o construtor `Conta()` na classe `Conta`:

```
public class Conta {

    private double saldo;
    private int agencia;
    private int numero;
    private Cliente titular;
    private static int total = 0;

    public Conta() {

    }COPIAR CÓDIGO
```

Retornaremos à classe `ContaCorrente` e podemos observar que o código voltou a compilar.

O `super` sempre fará com que o Java busque o construtor padrão, mas podemos utilizá-lo para chamar um construtor específico. Apagaremos o construtor `Conta()` que acabamos de criar.

Na classe `ContraCorrente`, definiremos parâmetros para o construtor:

```
public class ContaCorrente extends Conta {

        public ContaCorrente(int agencia, int numero) {
            super();
        }
}COPIAR CÓDIGO
```

Na chamada do construtor específico, passaremos as informações de `agencia` e `numero`:

```
public class ContaCorrente extends Conta {

        public ContaCorrente(int agencia, int numero) {
            super(agencia, numero);
        }
}COPIAR CÓDIGO
```

Salvaremos.

Ou seja, podemos utilizar o `super` para chamar um construtor específico, passando os parâmetros específicos para ele.

Faremos isso também para a `ContaPoupanca`. Primeiro, criaremos esta classe, e já informaremos que ela estenderá a classe `Conta`:

```
public class ContaPoupanca extends Conta {

}COPIAR CÓDIGO
```

Temos o mesmo problema que anteriormente:

```
Implicit super constructor Conta() is undefined for default constructor. Must define an explicit constructorCOPIAR CÓDIGO
```

Ou seja, o construtor implícito, aquele criado pelo Java (e corresponde ao construtor padrão), não está definido na classe `Conta`.

Para resolvermos, criaremos o construtor específico:

```
public class ContaPoupanca extends Conta {

        public ContaPoupanca(int agencia, int numero) {
            super(agencia, numero);
        }

}COPIAR CÓDIGO
```

Passando os parâmetros do construtor específico, para que possamos chamá-lo. Assim, é possível reaproveitá-lo ainda que não seja herdado automaticamente.

Adiante, reforçaremos o conceito de polimorfismo.