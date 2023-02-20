# Aula 01 - Capturando qualquer exceção

> Começando deste ponto? Você pode fazer o DOWNLOAD completo do projeto anterior e continuar seus estudos a partir daqui.
> 

---

Aqui está o nosso diagrama, um pouco melhorado:

![https://s3.amazonaws.com/caelum-online-public/834-java-excecoes/05/_05.01_001_runtimeexception-exception-error+2.png](https://s3.amazonaws.com/caelum-online-public/834-java-excecoes/05/_05.01_001_runtimeexception-exception-error+2.png)

À direita, temos erros que são da máquina virtual, nos quais não mexeremos, mas é importante saber que existem. À esquerda, temos as exceções.

No mundo Java, não é correto falar sobre erros com desenvolvedores, considerando que trabalhamos com *exceções*, e os erros são da máquina virtual.

O que nos interessa é o lado esquerdo do diagrama, referente às exceções. Vimos que existe diferença entre as exceções *Checked* e *Unchecked*, dependendo de qual classe estendemos. Se estendemos de `RuntimeException`, temos uma exceção do tipo *Unchecked*, ou seja, o compilador não toma atitude. Tendo `throw` ou não, ele não se importa.

Se estendermos diretamente da classe `Exception`, o compilador ficará de olho e nos obrigará a colocar `throws` na assinatura do método, para sinalizar quem chama o método, que ele é perigoso ou tratar a exceção no próprio método com o `try-catch`. Essa exceção é do tipo *checked*.

> Na hora de executar o código, não tem diferença! Todos são como bombas que caem na pilha.
> 

# **Mas, para quê serve o Checked e o Unchecked?**

Essa é uma pergunta difícil, pois o significado de Checked e Unchecked para o nosso código, mudou durante a vida do Java.

A polêmica das exceções está relacionada ao *Checked*. Hoje, existem aplicações que simplesmente não usam exceções desse tipo, e é muito comum utilizar bibliotecas que só têm exceções *Unchecked*, nas quais o compilador não nos obriga a tomar alguma atitude.

Então, para que serve *checked*, considerando que, atualmente, a maioria utiliza *Unchecked*? Mostraremos na classe `Conta`.

```
public class Conta {
    void deposita() {

    }
}COPIAR CÓDIGO
```

Na assinatura do método `deposita()`, colocaremos `throws` e a exceção criada. Lembrando que a exceção que criamos `MinhaExcecao()` é do tipo *Checked*.

```
public class Conta {
    void deposita() throws MinhaExcecao{

    }
}COPIAR CÓDIGO
```

Repare que não é necessário fazer alterações no método, e ele já compilou. Vamos criar uma nova classe, instanciar a `Conta` e chamar o método.

```
public class TestaContaComExcexaoChecked {
    public static void main(String[] args) {
        Conta c = new Conta();
        c.deposita();
    }
}COPIAR CÓDIGO
```

Como o método `deposita()` é vazio, nenhuma exceção será criada. Mas, basta colocar o `throws MinhaExcecao` na assinatura e o compilador saberá que o método tem uma exceção do tipo *Checked* na sua assinatura. Por isso, temos que tomar uma atitude: ou colocamos `throws MinhaExcecao` na assinatura de `main()`, ou utilizamos `try-catch`. Se escolhermos a segunda opção, obteremos o seguinte:

```
public class TestaContaComExcexaoChecked {
    public static void main(String[] args) {
        Conta c = new Conta();
        try {
            c.deposita();
        } catch(MinhaExcecao ex) {
            System.out.println("tratamento ......");
        }
    }
}COPIAR CÓDIGO
```

Agora, esse código compila! Mas pelo fato de `deposita()` jogar uma exceção *checked*, não tem como fugir! Quem chama o método `deposita()` sabe que ele pode ser perigoso e que pode ocasionar uma exceção. Isso não acontece com exceções *unchecked*.

Assim, entendemos essas duas categorias de exceções. Se você gosta de avisar aquele desenvolvedor que usará a sua classe, para que ele faça um tratamento, pois algumas exceções podem ocorrer, use *checked*. Se você acha que não precisa disso e que o desenvolvedor pode fazer o tratamento quando ele achar melhor, use *unchecked*.

Esse é um belo início para estar ciente da diferença entre o *checked* e o *unchecked*.

Voltaremos à classe `FluxoComErro`, pois ela possui um erro. Ele está dessa forma:

```
public static void main(String[] args) {
    System.out.println("Ini do main");
    try {
        metodo1();
    } catch(ArithmeticException | NullPointerException | MinhaExcecao ex) {
        String msg = ex.getMessage();
        System.out.println("Exception " + msg);
        ex.printStackTrace();
    }
    System.out.println("Fim do main");
}

private static void metodo1() {
    System.out.println("Ini do metodo1");
    metodo2();
    System.out.println("Fim do metodo1");
}COPIAR CÓDIGO
```

O `metodo1()` é chamado dentro de `try`, mas ele não tem `throws MinhaExcecao` na sua assinatura. Está claro para o compilador que, se é verificada, essa exceção não pode acontecer nesse código. Considerando ser impossível que ela aconteça, temos que tirá-la de `catch`.

Por último, na classe `Fluxo`, o `metodo1()` possui o `throws` em sua assinatura e, por esse motivo, o compilador nos obriga a colocar a exceção em `catch`, sem reclamar. Inclusive, nesse `catch`, temos três exceções diferentes. Será que existe alguma forma de fazer um `catch` mais genérico, que funcione para qualquer exceção? **Sim**, existe!

O que todas as exceções do mundo Java para o desenvolvedor têm em comum, é que todas estendem a classe **Exception**. Por isso, podemos fazer um *catch polimórfico*. Em vez de definir cada exceção específica, aumentando cada vez mais o `catch`, podemos fazer assim:

```
public static void main(String[] args) {
    System.out.println("Ini do main");
    try {
        metodo1();
    } catch(Exception ex) {}COPIAR CÓDIGO
```

Dessa forma, **qualquer** exceção que possa acontecer será capturada. O tópico atual é bem difícil, e ainda temos assuntos para estudar, mas a base mais sólida e conceitual para trabalhar com exceções foi criada.

Agora sim, podemos voltar à classe `Conta` do nosso projeto e arrumar o método `saca()`.