# Aula 10 - Conclusão

Olá!

Chegamos ao último vídeo do curso, concluindo uma longa trilha que iniciou desde os conceitos mais básicos do Java.

Iniciamos pelos **arrays**, a primeira estrutura de dados que vimos. Com ela, aprendemos a armazenar diversos valores de uma só vez, vimos o que é um array de primitivos, com uma sintaxe incomum, que utiliza colchetes (`[]`).

Inicializamos o array, indicando a posição desejada, lembrando que ela sempre inicia do `0`, e aprendemos a acessar determinada posição, bem como a descobrir quantos elementos aquela lista é capaz de armazenar.

Assim como existem primitivos, aprendemos que podem existir arrays de referências. Ao criar o objeto, o que é armazenado é a indicação à ele, e não ele em si. De resto, o funcionamento é igual ao tipo de array visto anteriormente.

Um ponto negativo deste tipo de lista é seu número fixo de elementos, uma vez criada, ela terá aquele tamanho, sem possibilidade de alteração ou flexibilização. Além disso, apesar de ser possível sabermos esta capacidade de armazenamento, não há um método que nos permita descobrir o número de elementos armazenados.

Por este motivo, vimos que foi criado um tipo de armazenador de objetos de referência, que é o `ArrayList`. Trata-se de uma classe que, internamente, utiliza um array. Sua sintaxe é, portanto, a mesma de uma classe qualquer.

Além disso, vimos que é possível criar parâmetros nela, para indicarmos que só será possível armazenar um tipo de referência, por exemplo, do tipo `Conta`, como é o caso abaixo:

```
ArrayList<Conta> lista = new ArrayList<Conta>();

Conta cc1 = new ContaCorrente(22, 11);
lista.add(cc1);

Conta cc2 = new ContaPoupanca(22, 22);
lista.add(cc2);

System.out.println("Tamanho: " + lista.size());COPIAR CÓDIGO
```

Ela possui diversos métodos específicos que facilitam o trabalho com estrutura de dados, é o caso do `size()`, que nos permite descobrir o número de referências armazenadas.

Há ainda outros tipos de estruturas de dados, como vimos, temos: `LinkedList` e o `Vector`.

O `LinkedList` é uma lista duplamente encadeada, enquanto o `Vector` é similar ao `ArrayList`, mas é capaz de trabalhar com diversos *threads*. Como são todas listas, implementam a interface `List`. Lembrando que todas as listas são sequências, e armazenam os elementos com base em um índice, isso não impede que adicionemos duplicados, ou seja, que itens sejam repetidos.

A ideia de armazenar dados é presente no mundo Java também na `Collection`, uma interface ainda mais genérica que `List`, e nos conjuntos `Set` e `HashSet`, que por sua vez não aceitam itens duplicados.

Como não é possível guardarmos valores primitivos em um array, existe para cada um deles uma **classe wrapper** correspondente.

Esta transformação, do primitivo para o objeto, e vice-versa, é chamada de *autoboxing* e *unboxing*, e é feita automaticamente pelo Java.

Vimos uma variação dos *generics*, onde omitimos o tipo, e o código continua funcionando:

```
List<Integer> lista = new ArrayList<>();

lista.add(5);
lista.add(12);

System.out.println("Tamanho: " + lista.size());COPIAR CÓDIGO
```

Aprendemos ainda formas de ordenar nossos métodos. Temos o `sort()`, bem como a classe `Collections`, que possui uma série de métodos auxiliares estáticos.

O `sort()` recebe um critério de comparação, que é definido por meio de uma interface com um único método.

Estas classes sem atributos, que possuem uma única funcionalidade, foram trabalhadas quando tratamos das **classes anônimas e lambdas**.

Como vimos, é menos custoso criar uma classe, a partir da interface, e já criar o objeto, de forma direta, em unidade. Isso significa que, em vez de fazermos isso, que é um processo burocrático:

```
lista.sort( new Comparator<Conta>() {

        public int compare(Conta c1, Conta c2) {

                return Integer.compare(c1.getNumero(), c2.getNumero());

        }

});COPIAR CÓDIGO
```

É melhor escrevermos da seguinte forma:

```
lista.sort( (c1, c2) -> Integer.compare(c1.getNumero(), c2.getNumero()) );COPIAR CÓDIGO
```

Neste segundo caso, estamos utilizando os lambdas, que facilitam ainda mais o trabalho com funções, no caso `(c1, c2)`, e em seguida, o código com o resultado desejado, ou seja, o nosso método `compare`.

Gostaria de convidar você para o próximo curso, Java Parte 7, no qual falaremos sobre `java.io`. Aprenderemos a trabalhar com leitura de arquivos, escrita, fluxo de dados oriundos da rede, ou ainda do teclado, onde podemos envia-los, entre outros.

É um tópico importante, principalmente para aquele que têm interesse em trabalhar com a web, já que se lida bastante com a relação de input e output.

Se quiser entender este código abaixo, convido você, e agradeço por ter assistido a este curso, até a próxima!

```
class TestaEntrada {

        public static void main(String[] args) throws IOException {

                BufferedReader br =

                        new BufferedReader(

                                new InputStreamReader(

                                        new FileInputStream("arquivo.txt")));
                while (s != null) {

                        System.out.println(s);

                        s = br.readLine();

                }

                br.close;
        }
}
```