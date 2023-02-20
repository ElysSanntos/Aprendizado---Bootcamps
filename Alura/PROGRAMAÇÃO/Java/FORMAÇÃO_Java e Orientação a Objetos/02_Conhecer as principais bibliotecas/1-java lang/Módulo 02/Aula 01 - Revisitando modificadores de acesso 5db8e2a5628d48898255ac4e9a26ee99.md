# Aula 01 - Revisitando modificadores de acesso

Continuaremos estudando os modificadores de acesso/visibilidade. Por meio dos pacotes conseguimos explicar todos os modificadores e quais são suas diferenças. Se observarmos o seguinte esquema, veremos que está organizado na ordem do "mais visível" ao "menos visível", sendo o `public` visível em todas as áreas e `private` visível somente dentro da classe.

```

| Modificadores de Acesso/Visibilidade |
|--------------------------------------|
| public                               |
| protected                            |
| <<package private>>                  |
| private                              |
COPIAR CÓDIGO
```

Temos em vista um termo novo, o `<<package private>>`. Veremos como esse modificador de visibilidade atua. Abriremos a classe `Conta`, localizada no pacote `br.com.bytebank.banco.modelo`.

```
package br.com.bytebank.banco.modelo;

public abstract class Conta {

    protected double saldo;
    private int agencia;
    private int numero;
    private Cliente titular;
    private static int total = 0;
//...COPIAR CÓDIGO
```

Percebem que essa classe possui o modificador `public`, isso significa, como já sabemos, que ela é visível em todos os espaços dentro e fora do pacote. No código de `TesteSaca`, localizado no pacote `br.com.bytebank.banco.test`, há uma referência a classe `Conta`.

```
package br.com.bytebank.banco.test;

import br.com.bytebank.banco.modelo.Conta;

public class TesteSaca {

    public static void main(String[] args) {

        Conta conta = new ContaCorrente(123, 321);
COPIAR CÓDIGO
```

Essa referência só pode ser feita porque a classe `Conta` é pública e pode ser acessada por elementos que estão fora de seu pacote, como é `TesteSaca`. Caso o `public` do código da classe `Conta` seja apagado, imediatamente o código de `TesteSaca` apresenta erros em sua compilação. As outras classes que compartilham o mesmo pacote de `Conta` operam normalmente.

Abriremos a classe `ContaCorrente`, observemos que há o modificador `public` em frente ao construtor `ContaCorrente`.

```
package br.com.bytebank.banco.modelo;

public class ContaCorrente extends Conta implements Tributavel {

    public ContaCorrente(int agencia, int numero) {
        super(agencia, numero);
    }
COPIAR CÓDIGO
```

Se `public` for removido, a classe será visível, mas não o construtor. Consequentemente haverá a ocorrência de erros na classe `TesteSaca`, que faz referência ao construtor `ContaCorrente`. Podemos definir a visibilidade para a classe, construtor, atributo, método e qualquer outro membro do código.

Quando não expressamos diretamente um modificador de visibilidade como `public`, a classe se torna visível apenas dentro de seu próprio pacote, isso significa `<<package private>>`, não se trata de uma palavra utilizada no mundo Java, mas a condição de uma classe nos termos de visibilidade, caso não especifiquemos essa condição.

Temos, ainda, o `protected`. Vamos entender esse conceito. Observemos o código da classe `Conta`:

```
package br.com.bytebank.banco.modelo;

public abstract class Conta {

    protected double saldo;
    private int agencia;
    private int numero;
    private Cliente titular;
    private static int total = 0;
COPIAR CÓDIGO
```

Ao removermos o `protected` de `double saldo`, não percebemos nenhum erro de compilação no código, ou seja, não há nenhuma modificação aparente. Para compreendermos essa suposta "inalteração", criaremos uma nova classe que chamaremos de `ContaEspecial`, que irá estender a classe `Conta`, portanto, na opção "Superclass" no painel de criação de classes, escolheremos a classe `Conta`.

Na opção "Package", criaremos um novo pacote para essa classe, que chamaremos de `br.com.bytebank.banco.especial`. Percebam que basta assinalarmos um novo pacote no painel de criação de classes que o Eclipse criará, também, um novo pacote para armazenar essa classe.

![https://s3.amazonaws.com/caelum-online-public/843-java-packages/02/2_1_14_cira%C3%A7%C3%A3o+de+classe+especial.png](https://s3.amazonaws.com/caelum-online-public/843-java-packages/02/2_1_14_cira%C3%A7%C3%A3o+de+classe+especial.png)

Vejamos o código da classe `ContaEspecial`:

```
package br.com.bytebank.banco.especial;

import br.com.bytebank.banco.modelo.Conta;

public class ContaEspecial extends Conta {

    @Override
    public void deposita(double valor) {
        // TODO auto-generated method stub

    }
}

COPIAR CÓDIGO
```

Há uma extensão de `Conta` mas existe um erro de compilação. Precisamos implementar o construtor específico da classe `Conta`. Tentaremos fazer de uma forma mais rápida e copiaremos o construtor de `ContaCorrente`.

```
package br.com.bytebank.banco.modelo;

//new ContaCorrente()
public class ContaCorrente extends Conta implements Tributavel {

    public ContaCorrente(int agencia, int numero) {
        super(agencia, numero);
    }
}
COPIAR CÓDIGO
```

Colaremos o construtor na classe `ContaEspecial` fazendo as devidas renomeações.

```
package br.com.bytebank.banco.especial;

import br.com.bytebank.banco.modelo.Conta;

public class ContaEspecial extends Conta {

    public ContaEspecial(int agencia, int numero) {
        super(agencia, numero);
    }

    @Override
    public void deposita(double valor) {
        // TODO auto-generated method stub

    }
}
COPIAR CÓDIGO
```

A implementação da classe `ContaEspecial` não é foco da explicação, e sim o modificador `protected`, então não vamos investir muito tempo nesse processo. De volta a classe `Conta`, lembre-se que retiramos o `protected` de `double saldo`, isso significa que na questão de visibilidade este atributo passa a ser `<<package private>>`, ou seja, apenas visível dentro de seu próprio pacote.

```
package br.com.bytebank.banco.modelo;

public abstract class Conta {

    double saldo;
    private int agencia;
    private int numero;
    private Cliente titular;
    private static int total = 0;
COPIAR CÓDIGO
```

A classe `ContaEspecial`, mesmo que sendo uma filha da classe `Conta`, não possui acesso ao atributo `saldo`, pois este não se encontra visível fora de seu pacote. As duas classes possuem relacionamentos íntimos, sendo classe `Conta` a mãe e `ContaEspecial` a filha. O modificador de visibilidade `protected` torna elementos públicos para as **classes filhas**.

Mesmo que a classe filha esteja em outro pacote, o atributo `saldo` em `Conta` será visível caso seja acompanhado por `protected`. O acesso ao atributo `saldo` da classe `Conta` não é possível de nenhum outro local, apenas da classe filha.

Caso criemos em `TesteContas` uma `ContaEspecial` e chamássemos seu `saldo`, o código não seria compilado e o Eclipse sugere utilizar o `getSaldo()`.

```
package br.com.bytebank.banco.test;

import br.com.bytebank.banco.especial.ContaEspecial;

public class TesteContas {

    public statid void main(String[] args) throws SaldoInsuficienteException{

                ContaEspecial ce = new ContaEspecial(123, 5555);
        ce.saldo
//...COPIAR CÓDIGO
```

Com isso, aprendemos sobre os modificadores de acesso/visibilidade, e temos que:

- **public**:visível em todos os espaços
- **protected**: visível dentro do pacote e público para os filhos
- **package private**: visível apenas dentro do pacote
- **private**: visível apenas dentro da classe