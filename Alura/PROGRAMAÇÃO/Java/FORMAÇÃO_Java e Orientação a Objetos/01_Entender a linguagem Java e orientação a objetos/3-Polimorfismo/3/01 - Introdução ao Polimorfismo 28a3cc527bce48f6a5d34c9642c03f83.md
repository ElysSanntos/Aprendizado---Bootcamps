# 01 - Introdução ao Polimorfismo

Começando deste ponto? Você pode fazer o [DOWNLOAD](https://caelum-online-public.s3.amazonaws.com/788-java-heranca-interfaces-polimorfismo/03/java3-aula3.zip) completo do projeto anterior e continuar seus estudos a partir daqui.

---

Bem-vindo novamente ao nosso curso!

Até este ponto, vimos uma importante parte do conceito de herança, que tratou da reutilização de código. Como uma boa prática de programação, não queremos repetir código, em vez disso, estendemos a classe, utilizando o `extends` - `Gerente` estende a classe `Funcionario`.

Isso significa dizer também que `Gerente` herdou todos os atributos e características da classe `Funcionario`.

Partiremos agora para uma segunda parte conceitual de herança, igualmente importante à anterior.

Criaremos uma nova classe, chamada `TesteReferencias` e nela, criaremos um novo gerente chamado `g1`:

```
public class TesteReferencias {

        public static void main(String[] args) {

                Gerente g1 = new Gerente();

        }

}COPIAR CÓDIGO
```

Assim, podemos chamar qualquer um dos métodos definidos, primeiro, teremos o `setNome()` e, em seguida, recuperaremos o nome com o `g1.getNome`. Por fim, imprimiremos o nome:

```
public class TesteReferencias {

        public static void main(String[] args) {

                Gerente g1 = new Gerente();
                g1.setNome("Marcos");
                String nome = g1.getNome();

                System.out.println(nome);
        }
}COPIAR CÓDIGO
```

Executaremos o teste, e temos o nome `Marcos` impresso no console, o que indica que nosso código funcionou!

Até então, ao criarmos um novo objeto, utilizamos o lado direito com o `new` para chamarmos o construtor com o nome da classe, por exemplo, neste caso temos `new Gerente()`. Enquanto isso, no lado esquerdo temos o tipo da variável, seguido pelo seu nome, no caso, `Gerente g1`.

Entretanto, como todo gerente também é um funcionário, é possível declarar a variável de um tipo mais genérico, ou seja, do tipo `Funcionario`:

```
public class TesteReferencias {

        public static void main(String[] args) {

                Funcionario g1 = new Gerente();
                g1.setNome("Marcos");
                String nome = g1.getNome();

                System.out.println(nome);
        }
}COPIAR CÓDIGO
```

Agora, a variável é do tipo `Funcionario`, ela não é mais do tipo `Gerente`, e sim do tipo mais genérico. Nosso código continua compilando, e se executarmos novamente, teremos o mesmo resultado.

E o contrário? Também funcionaria?

```
//Código omitido

        public static void main(String[] args) {

                Gerente g1 = new Funcionario();

//Código omitidoCOPIAR CÓDIGO
```

Não, porque apesar de todo gerente ser um funcionário, nem todo funcionário é um gerente.

Mas para que serve, então, colocar uma referência mais genérica?

A referência `g1` é, portanto, do tipo `Funcionario`. Agora, queremos chamar, por exemplo, `g1.Autentica(2222)` e passar uma senha:

```
public class TesteReferencias {

        public static void main(String[] args) {

                Funcionario g1 = new Gerente();
                g1.setNome("Marcos");
                String nome = g1.getNome();

                g1.autentica(2222);

                System.out.println(nome);
        }
}COPIAR CÓDIGO
```

O compilador indica que isso não funciona, mas por quê? Se criamos um objeto do tipo `Gerente`? Isso não importa para o compilador. O que ele faz é analisar o tipo da referência, ou seja, `g1` - que é do tipo `Funcionario`. Como esta classe não tem o método `autentica`, o compilador indica a presença de um erro.

Qual é então a vantagem em termos esta referência mais genérica? Ela não está clara neste código, e por isso veremos um outro código nas próximas aulas.

Antes de partirmos, olhemos para o seguinte desenho:

![https://s3.amazonaws.com/caelum-online-public/788-java-heranca-interfaces-polimorfismo/03/03.01_001_diagrama-onde-temos.png](https://s3.amazonaws.com/caelum-online-public/788-java-heranca-interfaces-polimorfismo/03/03.01_001_diagrama-onde-temos.png)

Como podemos ver, o `new Gerente()` causa a criação de um objeto do tipo `Gerente`. Uma vez criado, o objeto sempre terá o mesmo tipo - digamos que na vida real, um gerente possa ser promovido, aqui, não há essa possibilidade, um objeto sempre manterá seu tipo.

O que pode variar, é o tipo da referência, aquilo que está localizado à esquerda do nome do objeto, no caso é `Funcionario`, mas como vimos, poderíamos ter definido como `Gerente` também, sem problemas.

A isso, damos o nome de polimorfismo. Temos um mesmo objeto, do tipo `Gerente`, mas há duas formas possíveis de chegarmos a este objeto, dois tipos diferentes de referência.