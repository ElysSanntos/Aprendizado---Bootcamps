# Aula 09 - Revisão e conclusão

Faremos uma pequena revisão de todo o conteúdo visto até o presente momento em nosso curso; caso você se sinta seguro, você pode pular este vídeo, pois ele não terá nenhum conteúdo inédito.

Todas as classes trabalham com a regra de que a classe `Object` está no topo da hierarquia, sendo esta a classe mãe. Não é necessário escrever `extends Object` nas classes filhas como `Cliente`, pois o compilador insere essa informação automaticamente.

É raro encontramos `extends Object`, porque todo desenvolvedor sério de Java sabe que as classes estendem a classe `Object`.

A classe `Object` foi inventada a partir do conceito de que de que tudo é um objeto. Com isso, conseguimos algumas vantagens relacionadas à herança, como **polimorfismo** e **reutilização de código**.

Nós vimos apenas um método, mas existem muitos outros que dependem da classe `Object`, vários laços foram escritos de forma dependente dessa classe, pois são utilizados alguns métodos básicos que já foram implementados dentro dessa classe, então todos as classes associadas à `Object` terão a mesma funcionalidade.

O exemplo que utilizamos no curso foi o método `println()`, que como podemos observar na classe `Teste`, funciona com qualquer tipo de referência, afinal todas são compatíveis com a classe `Object`.

```
//...
Object cc = new ContaCorrente(22, 33);
Object cp = new ContaPoupanca(33, 22);
Object cliente = new Cliente();

System.out.println(cc);
System.out.println(cp);
//...
```

Ao acessarmos `println()` utilizando a tecla "Ctrl" pressionada e clicando sobre o método, veremos em seu código fonte que ele funciona com qualquer tipo de referência, afinal, recebe a referência mais genérica o possível, que é `Object`.

```
//...
public void println(Object x) {
    String s = String.valueOff(x);
    synchronized (this) {
        print(s)
        newLine();
    }
}
//...
```

Não é possível fazer muita coisa com o `Object`, por exemplo, na classe `Teste` escreveremos `cc`, que é uma referência do tipo `Object`, e chama alguns outros métodos genéricos, como `toString()`.

```
cc.toString()
 exatamente o que acontece no `System.out.println()`, observemos o método estático da classe `String`, o `valueOf()`.
```

```
public void println(Object x) {
    String s = String.valueOf(x);
    synchronized (this) {
        print(s)
        newLine();
    }
}

```

Acessaremos esse método através do "Ctrl" pressionado, como já sabemos.

Dentro de `valueOf()` verificaremos que ele também é dependente de `Object`, o tipo mais genérico o possível. Ao longo do código existe um operador ternário - que é basicamente um `if` mais enxuto - que verifica se o objeto é nulo, caso sim, é devolvido `null` como String, se não (essa condicional é representada pelos dois pontos `:`) é devolvido `obj.toString()`.

```
public static String valueOf(Object obj) {
    return (obj == null ) ? "null" : obj.toString();
}

```

A ideia do `toString()` da classe `Object` é ser sobrescrito, assim como a maioria dos outros métodos "querem" ser sobrescritos pelos filhos, com isso eles ganham mais significado. É o que fizemos na classe `Conta`, para procurarmos rapidamente o método, acionamos o atalho "Ctrl + O" e o procuramos dentro da classe e observamos a atribuição de significado.

```
//...
public static int getotal(){
    return
}

@Override
public String toString() {
    return "Numero: " + this.numero + ", Agencia : " + this.agencia;

}
//...
```

Nós também refinamos o `toString` na classe filha, adicionando uma informação e depois a implementação da classe. Observem o código de `ContaCorrente`:

```
//...
@Override
public double getValorImposto() {
    return super.saldo *0.01;
}

@Override
public String toString() {
    return "ContaCorrente, " + super.toString();
}
//...
```

Resumindo, existe um universo com muitas classes que que se baseiam em métodos definidos na classe `Object`, e o desenvolvedor deve sobrescrever tais métodos para atribuir maior significado a eles. Analisamos o método `println()` que internamente chama `toString()`, mais genérico do que, por exemplo, o `java.lang`.

Existem no mínimo dois pacotes super importantes que veremos nos próximos cursos, como `java.util`, em que encontraremos as coleções, conjuntos e mapas. Teremos, ainda, o `java.io`, que contém as classes que se preocupam com a leitura e escrita de dados, streams, *readers* e *writers*.

Precisamos dominar a classe `Object` para conseguirmos trabalhar, principalmente, com o `java.util` e conhecermos outros métodos como `hashCode()` e `equals()` que deverão ser sobrescritos.

Nos próximos cursos, focaremos na API e aprenderemos mais classes para analisar como o Java trabalha com estrutura de dados e leitura. Muito obrigado a todos que assistiram o curso comigo, e já lhes deixo o convite para participarem do próximo. A grande parte conceitual da linguagem nós já vimos, e agora podemos nos focar nas bibliotecas oferecidas pelo Java.