# Aula 06 - O método toString()

Na última aula, fizemos uma revisão sobre polimorfismos e aproveitamento de código, e nosso foco agora é melhorar a saída impressa por `Teste.java`.

A classe `Object` nos fornece uma implementação do método `toString()`, no entanto ela não nos serve de nada neste momento. A ideia é que as classes reimplementem o método para atribuí-lo a um significado maior. Vamos lá?

Abriremos a classe `ContaCorrente` e sobrescreveremos o método `toString()`.

O Eclipse sabe que todas as classes trabalham tendo em base a classe `Object` no topo da hierarquia.

![https://s3.amazonaws.com/caelum-online-public/843-java-packages/05/5_2_33_heranca.png](https://s3.amazonaws.com/caelum-online-public/843-java-packages/05/5_2_33_heranca.png)

Ao começarmos a escrever o método `toString()`, quando chegamos a escrever `toStr` pressionaremos o atalho "Ctrl + Space" para acionarmos o *autocomplete*. O Eclipse apresenta duas sugestões: implementar o método `toStr()` ou implementar o `toString()`; escolheremos, claro, a segunda opção.

Com isso, é posta uma implementação padrão com o `@Override`, para realmente garantir que estamos sobrescrevendo o método.

```
//...
@Override
public void deposita(double valor){
    super.saldo +=valor;
}

@Override
public double getValorImposto() {
    return super.saldo * 0.01;
}

@Override
public String toString() {
    // TODO Auto-generated method stub
    return super.toString();
    }
}

//...COPIAR CÓDIGO
```

Temos na última linha da implementação o chamado `super.toString()`. Essa linha não nos interessa, pois não queremos chamar um método da classe `Object`, e sim, dar um significado maior para o método.

Apagaremos o comentário, bem como a linha, e em frente ao `return` escreveremos `ContaCorrente`.

```
//...
@Override
public void deposita(double valor){
    super.saldo +=valor;
}

@Override
public double getValorImposto() {
    return super.saldo * 0.01;
}

@Override
public String toString() {
    return "ContaCorrente";
    }
}
//...
COPIAR CÓDIGO
```

Voltaremos à classe `Teste` para testarmos nossa saída. Deixaremos como comentário os `System.out.println()`s.

```
//...

public static void main(String[] args) {

//    System.out.println("x");
//    System.out.println(3);
//    System.out.println(false);

ContaCorrente cc = new ContaCorrente(22, 33);
Object cp = new ContaPoupanca(33, 22);
Object cliente = new Cliente();

System.out.println(cc.toString());
System.out.println(cp);

<....!....>
COPIAR CÓDIGO
```

Ao executarmos o código, temos a seguinte saída:

```
ContaCorrente
br.com.bytebank.banco.modelo.ContaPoupanca@3abfe836
COPIAR CÓDIGO
```

Está diferente, nosso método `toString()` foi chamado, lembrando que temos um objeto `ContaCorrente`, e para ele será utilizado um método específico. Quem define qual método será escolhido é o objeto.

Mesmo se alterarmos a referência para `Object`, a saída no nosso código continua a mesma.

```
//...
Object cc = new ContaCorrente(22, 33);
Object cp = ContaPoupanca(33, 22);
Object cliente = new Cliente();

System.out.println(cc.toString());
Sytem.out.println(cp);
//...COPIAR CÓDIGO
```

Podemos melhorar ainda mais a nossa saída.

Em `ContaCorrente`, iremos concatenar uma informação do objeto. Nessa fase, o desenvolvedor irá definir uma informação interessante, que faz sentido e facilita a leitura e o entendimento.

Colocaremos o número da conta, acionando o método `getNumero()`.

```
//...
@Override
public void deposita(double valor) {
    super.saldo += valor;
}

@Override
public double getValorImposto() {
    return super.saldo * 0.01;
}

@Override
public String toString() {
    return "ContaCorrente: " + super.getNumero();
}
//...
COPIAR CÓDIGO
```

Novamente executaremos o código em `Teste`. Feitas as modificações, temos impresso o número da conta.

```
ContaCorrente: 33
br.com.bytebank.banco.modelo.ContaPoupanca@3abfe836COPIAR CÓDIGO
```

Podemos melhorar ainda mais a nossa saída escrevendo o texto `Numero`.

```
//...
@Override
public String toString() {
    return "ContaCorrente, Numero: " + super.getNumero();
}
//...COPIAR CÓDIGO
```

Observem o resultado da impressão ao executarmos a classe `Teste`.

```
ContaCorrente, Numero: 33
br.com.bytebank.banco.modelo.ContaPoupanca@3abfe836COPIAR CÓDIGO
```

Faremos o mesmo procedimento na classe `ContaPoupanca`, inserindo o seguinte trecho de código na classe:

```
//...
@Override
public String toString() {
    return "ContaPoupanca, Numero: " + super.getNumero();
}
//...COPIAR CÓDIGO
```

Na classe `Teste`, não precisamos evocar o `toString()` na linha do `System.out` explicitamente, sendo uma prática um pouco estranha para um desenvolvedor Java, pois o `println()` possui internamente um mecanismo que evoca o método `toString()`.

```
//...
Object cc = new ContaCorrente(22, 33);
Object cp = new ContaPoupanca(33, 22);
Object cliente = new Cliente();

System.out.println(cc);
System.out.println(cp);
//...COPIAR CÓDIGO
```

Ao executarmos o código, teremos o seguinte resultado de saída:

```
ContaCorrente, Numero: 33
ContaPoupanca, Numero: 22
COPIAR CÓDIGO
```

Com isso, realizamos uma pequena melhoria em nosso projeto, refinando o comportamento de alguns elementos.

Realizaremos mais modificações no âmbito da herança.

Entre as duas classes, `ContaCorrente` e `ContaPoupanca`, temos um trecho de código muito parecido, com exceção dos próprios nomes das classes.

```
//...
@Override
public String toString() {
    return "ContaPoupanca, Numero: " + super.getNumero();
}
//...COPIAR CÓDIGO
```

Tendo isso em vista, criaremos um método `toString()` mais genérico dentro da classe `Conta`, neste método imprimiremos o número da conta e da agência. Feito isso, iremos refinar esse método em cada filho da classe `Conta`. Portanto quando chamarmos o método na classe filha, na verdade estamos aproveitando o método mais genérico da classe `Conta`.

![https://s3.amazonaws.com/caelum-online-public/843-java-packages/05/5_3_34_metodo+tostring+na+classe+conta+e+suas+filhas.png](https://s3.amazonaws.com/caelum-online-public/843-java-packages/05/5_3_34_metodo+tostring+na+classe+conta+e+suas+filhas.png)

Na classe `Conta`, iremos reaproveitar o trecho de código utilizado nas classes `ContaCorrente` e `ContaPoupanca`, fazendo uma pequena modificação: iremos imprimir somente o `Numero`, sem especificar um ou outro tipo de conta; retiraremos o `super`, pois ele seria a classe `Object`,e utilizaremos o `this.numero`.

Portanto o `toString()`da classe `Conta` nos devolve `Numero` concatenado com o número da conta em questão.

```
//...
@Override
public String toString() {
    return "Numero: " + this.numero;
}
//...COPIAR CÓDIGO
```

Nos filhos da classe `Conta` também iremos realizar modificações.

Em `ContaCorrente` iremos retirar `Numero`, que apareceria duplicado. Também substituiremos o `super.getNumero()` por `super.toString()`

```
//...
@Override
public String toString() {
    return "ContaCorrente, " + super.toString();
}
//...COPIAR CÓDIGO
```

A mesma revisão da herança ocorre em `ContaPoupanca`.

```
//...
@Override
public String toString() {
    return "ContaPoupanca, " + super.toString();
}
//...COPIAR CÓDIGO
```

Ao executarmos o código na classe `Teste`, teremos o seguinte resultado:

```
ContaCorrente, Numero: 33
ContaPoupanca, Numero: 22
COPIAR CÓDIGO
```

É interessante destacar que caso modifiquemos o `toString()` da classe mãe, automaticamente o mesmo se dá para as classes filhas. Por exemplo, iremos concatenar a informação de `Agencia`.

```
//...
@Override
public String toString() {
    return "Numero: " + this.numero + "Agencia:" + this.agencia;
}
//...COPIAR CÓDIGO
```

Feito o acréscimo na classe mãe, ao executarmos o código em `Teste` obteremos o seguinte resultado:

```
ContaCorrente, Numero: 33, Agencia: 22
ContaPoupanca, Numero: 22  Agencia: 33

COPIAR CÓDIGO
```

Com isso está mais claro de que tipo de objeto se trata e seus valores.