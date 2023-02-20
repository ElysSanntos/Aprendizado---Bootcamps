# Aula 01 - Conhecendo java.lang

Nesta aula, falaremos sobre as classes fundamentais do mundo Java.

Faremos um breve resumo sobre os pacotes: aprenderemos que eles são úteis para organizarmos nossas classes e evitar conflito de nomes, uma vez que Java é uma plataforma muito popular e muitos desenvolvedores utilizam Java. Para isso, organizamos os diretórios em hierarquias, de forma que eles passam a fazer parte do nome da classe.

Para utilizarmos uma classe utilizamos o `import`, ou importação, caso isso não seja feito ela não será encontrada, ou então deveremos sempre qualifica-la com seu nome completo.

A classe não utiliza mais seu nome simples no sistema de pacotes, e sim o *full qualified name*, como o exemplo de `ContaCorrente` logo abaixo:

```
import br.com.bytebank.banco.modelo.ContaCorrente;
COPIAR CÓDIGO
```

A partir desse ponto vocês não encontrarão mais classes sem pacote, e nem irão escrever classes sem pacote, afinal esta não é uma boa prática e devemos trabalhar para que isso não ocorra.

Iremos nos atentar para uma questão importante, observem uma parte do código da classe `TesteConta`:

```
public class TesteContas {

    public static void main(String[] args) throws SaldoInsuficienteExceoption{

        ContaCorrente cc = new ContaCorrente(111, 111);
        cc.deposita(100.00);

        ContaPoupança cp = new ContaPoupança(222,222);
        cp.deposita(200.0);

        cc.transfere(10.0, cp);

        System.out.println("CC: " + cc.getSaldo());
        System.out.println("CP: " + cp.getSaldo());COPIAR CÓDIGO
```

Percebam que estamos utilizando `String` e `System`, que também são classes. Falamos anteriormente que todas as classes estão dentro de um pacote, mas como lidamos com essas duas? Devemos utiliza-las a partir de um `import`, como com todas as outras classes, certo?

As classes `String` e `System` estão, sim, dentro de um pacote, mas não é necessário importa-las. O único pacote que não necessita ser importado é `java.lang`. Por ser de suma importância para o desenvolvimento de qualquer aplicação Java, ele é incluído automaticamente.

Ao observarmos o full qualified name da classe `String` nos deparamos com:

```
java.lang.String;
```