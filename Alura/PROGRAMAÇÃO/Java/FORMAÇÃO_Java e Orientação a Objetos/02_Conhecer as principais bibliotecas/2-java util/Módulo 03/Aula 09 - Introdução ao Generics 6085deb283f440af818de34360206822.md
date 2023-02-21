# Aula 09 - Introdução ao Generics

Nesta aula, continuaremos a trabalhar com nosso `ArrayList`.

Primeiro, resolveremos a questão das observações apontadas pelo Eclipse, evidenciadas pelas palavras sublinhadas em amarelo.

O Eclipse faz isso para nos auxiliar com problemas de tipagem, ou seja, onde estamos acessando a primeira posição do array, fazemos também um cast:

```
//Código omitido

public class Teste {

//Código omitido

                System.out.println("Tamanho: " + lista.size());
                Conta ref = (Conta) lista.get(0);
                System.out.println(ref.getNumero());

//Código omitido

}COPIAR CÓDIGO
```

Porque sabemos que o retorno é de um objeto do tipo `Conta`. Entretanto, isso não serve como uma garantia definitiva para o compilador, de que estamos corretos.

Por exemplo, comentaremos a linha de criação da primeira conta `cc`, e criaremos um novo, `cliente`, em seu lugar:

```
//Código omitido

public class Teste {

        public static void main(String[] args) {

            ArrayList lista = new ArrayList();

            //Conta cc = new ContaCorrente(22, 11);
            Cliente cliente = new Cliente();
            lista.add(cliente);

            Conta cc2 = new ContaCorrente(22, 22);
            lista.add(cc2);

//Código omitido

}COPIAR CÓDIGO
```

O código continua compilando, isso porque, como temos uma referência genérica do tipo `Object`, ela aceita também referências do tipo `Conta`, como é o caso do novo objeto que acabamos de criar.

Entretanto, ao executarmos este código, temos um erro de *class cast exception*. Ela acontece na seguinte linha em nosso código:

```
//Código omitido

Conta ref = (Conta) lista.get(0);

//Código omitidoCOPIAR CÓDIGO
```

O erro acontece pois agora ela não devolve mais uma referência compatível com `Conta`, mas sim `Cliente`.

Queremos evitar este tipo de situação. O ideal é não misturarmos dados, queremos guardar em nosso array as contas, e não clientes e contas juntos.

A liberdade de um `ArrayList` genérico é importante, mas neste caso, especificamente, não queremos misturar dados, nosso objetivo é armazenar somente objetos do tipo `Conta`.

Para limitarmos o `ArrayList` podemos utilizar a sintaxe **`<>`**, os símbolos de menor e maior e, dentro, indicar o tipo de classes e objetos que aquela lista poderá armazenar, no nosso caso, será `Conta`:

```
//Código omitido

public class Teste {

        public static void main(String[] args) {

                ArrayList<Conta> lista = new ArrayList();

//Código omitidoCOPIAR CÓDIGO
```

Normalmente, um desenvolvedor não se refere a isso como "uma lista de referências do tipo `Conta`", aqui estamos utilizando esta linguagem por motivos didáticos. É mais usual, na prático, isto ser referido como "uma lista de objetos", quando na verdade sabemos que não temos objetos de fato dentro da lista, somente as referências.

No lado direito, repetiremos a especificação, com a mesma sintaxe:

```
//Código omitido

public class Teste {

        public static void main(String[] args) {

                ArrayList<Conta> lista = new ArrayList<Conta>();

//Código omitidoCOPIAR CÓDIGO
```

Assim, o compilador sabe que, no `ArrayList` que foi criado, só pode haver referências do tipo `Conta`.

Hipoteticamente, se tentarmos criar um `Cliente` e adicioná-lo ao array, o código nem compilará.

Dessa forma, ter um erro "*class cast exception*" é impossível, pois o compilador já proíbe isso de antemão.

Além disso, o compilador já sabe que o método `get()` retornará uma referência do tipo `Conta`, pois é impossível adicionar qualquer outra coisa diferente disso.

Por esse motivo, não é necessário fazermos o cast:

```
//Código omitido

public class Teste {

//Código omitido

                System.out.println("Tamanho: " + lista.size());
                Conta ref = lista.get(0);
                System.out.println(ref.getNumero());

//Código omitido

}COPIAR CÓDIGO
```

Temos mais uma facilidade, no método `for`, podemos utilizar diretamente o tipo `Conta`:

```
//Código omitido

for(Conta conta : lista) {
    System.out.println(conta);
}

//Código omitidoCOPIAR CÓDIGO
```

Isso não funcionaria, se não tivéssemos feito a referência entre os símbolos de menor e maior (`<>`).

Ao executarmos o código, temos o seguinte resultado no console:

```
Tamanho: 2
11
Tamanho: 1
ContaCorrente, Numero: 22, Agencia: 22
ContaCorrente, Numero: 311, Agencia: 33
ContaCorrente, Numero: 322, Agencia: 33
-------
ContaCorrente, Numero: 22, Agencia: 22
ContaCorrente, Numero: 311, Agencia: 33
ContaCorrente, Numero: 322, Agencia: 33COPIAR CÓDIGO
```

Tudo está funcionando normalmente.

Estes símbolos que utilizamos (`<>`) se chamam ***generics***. Temos uma classe, ela é genérica, mas ao utilizá-la, podemos tipificar o que ela conterá, por exemplo, `String`:

```
//Código omitido

ArrayList<String> nomes = new ArrayList<String>();

//Código omitidoCOPIAR CÓDIGO
```

O que fizemos foi especificar que temos apenas referências do tipo `Conta`, no primeiro `ArrayList`, e que o segundo aceita somente `String`s. O código fica assim mais seguro, mais tipificado.

Nos vemos na próxima!