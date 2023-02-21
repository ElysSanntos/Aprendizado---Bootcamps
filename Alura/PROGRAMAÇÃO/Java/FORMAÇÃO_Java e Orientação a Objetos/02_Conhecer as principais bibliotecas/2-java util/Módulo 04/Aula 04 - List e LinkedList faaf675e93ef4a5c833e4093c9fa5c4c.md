# Aula 04 - List e LinkedList

Olá! Bem-vindo novamente. Nesta aula, continuaremos falando sobre o pacote `java.util`.

Vimos como o `ArrayList` aproveita o método `equals()` internamente, e desde que o usuário sobrescreva com seu próprio método de igualdade, ele pode fazer uso também do método `contains()`.

Além disso, vimos anteriormente que o método `toString()` foi sobrescrito, que as listas utilizam internamente o método `equals()`, e, existe ainda um outro método chamado `hashCode()`, que é utilizado em outras classes dentro do `java.util`, e não na lista. Ele não será abordado neste curso, mas há um outro que é focado especificamente nisso. Existe uma estrutura de dados que se chama conjunto, ou **set**, que utilizam este método e o `equals()` simultaneamente.

O `ArrayList` é uma lista, mas não é a única. Por que então utilizar outra?

Como qualquer outra, esta modalidade possui vantagens e desvantagens. Como lado positivo, temos as características de um array, ou seja, o acesso fácil a qualquer elemento aleatório. Se adicionamos elementos em um array, e queremos acessar qualquer posição, não há nenhum trabalho a mais para que façamos isso, esse acesso pode ser feito diretamente pelo índice de forma bastante facilitada.

Além disso, adicionar novos elementos em um array é um processo simples, desde que não seja ultrapassada sua capacidade de armazenamento. Se desejarmos adicionar um novo elemento, o `ArrayList` sabe automaticamente qual a próxima posição livre, e ele é inserido - simples. Iteração também é algo tranquilo de se fazer em um array.

Do lado negativo, temos que a sua capacidade é limitada ao seu tamanho no momento da criação, ou seja, uma vez que sua capacidade acaba, é necessária a criação de um novo array, com capacidade maior, e copiar os elementos daquele para este armazenamento. Ainda, se quisermos remover um elemento, o array não permitirá que existam "buracos" em sua lista e, sendo assim, moverá todas as referências de modo que todos os índices serão modificados. Para esse tipo de operação, o `ArrayList` não é tão eficiente.

Se o objetivo for simplesmente adicionar elementos, para depois fazer a iteração, o `ArrayList` é sem dúvida o mais indicado. É esse o tipo mais comum de situação e, normalmente, o uso mais comum. Contudo, é necessário sabermos destas ressalvas.

Qual seria, então, a alternativa ao `ArrayList`? Para isso, temos o `LinkedList`. Ele **não utiliza um array** internamente.

Isso significa que, quando falamos de `List` nem sempre estamos lidando com arrays. Uma lista significa, simplesmente, que estamos armazenando elementos em sequência, ou seja, o primeiro elemento adicionado também é o primeiro que será retornado. Além disso, temos um índice, e métodos que trabalham com ele. Por exemplo, o método `get()`, que podemos utilizar para obter determinado elemento de uma posição em particular.

No `LinkedList` temos estas mesmas características, sequência, ordem de inserção e índice. Entretanto, ela não funciona com um array internamente.

Seu funcionamento ocorre da seguinte forma: ao adicionarmos, por exemplo, `cc1` e, em seguida, `cc2`, ela se lembrará do elemento que foi adicionado anteriormente, ou seja, `cc2` se lembra de `cc1`, `cc3` de `cc2`, e assim por diante. Da mesma forma, o primeiro elemento se lembra daquele que o segue, ou seja, `cc1` lembra de `cc2`, `cc2` de `cc3`, e assim sucessivamente. A isso, damos o nome de **lista duplamente encadeada**.

Sabemos que estamos no final da lista quando atingimos um elemento que não possui um próximo.

Neste tipo de lista, apagar um elemento não causa grande impacto à ela como um todo, ela o descarta e substitui com o seguinte e o anterior. Supondo que temos `cc1`, `cc2` e `cc3`, ao apagarmos `cc2`, simplesmente `cc1` e `cc3` passarão a ser diretamente conectados.

Mas e se quisermos acessar o último elemento da lista, como podemos acessá-lo? Temos que iniciar no primeiro elemento, e verifica-los sucessivamente, até atingirmos o ponto onde não há mais continuidade. Diferentemente do array, não temos como acessar uma determinada posição diretamente. Se quisermos, por exemplo, acessar a posição 3, temos que iniciar na primeira e seguir, até atingirmos a desejada. Isso faz com que a iteração seja algo negativo na `LinkedList`.

Para adicionar elementos, a lista sabe quais são o primeiro e último elementos, e faz a inserção após o final.

Colocaremos em prática, utilizando a `LinkedList` em nossa classe `TesteArrayListEquals`. Isso será complicado, uma vez que há duplicidade de diversos métodos, como `add()`, `contains()`, `size()`, `remove()` e `equals()`.

A primeira coisa a fazermos, na classe `TesteArrayList`, será alterarmos para `LinkedList`:

```
//Código omitido

public class TesteArrayList {

        public static void main(String[] args) {

        //Generics
        LinkedList<Conta> lista = new LinkedList<Conta>();

        ArrayList<String> nomes = new ArrayList<String();

//Código omitidoCOPIAR CÓDIGO
```

Precisamos importar esta classe. Ao deixarmos o cursor sobre o seu nome, vemos a opção "*Import `LinkedList`(java.util)*", clicaremos nela. Podemos apagar a linha do `ArrayList`:

```
//Código omitido

import br.com.bytebank.banco.modelo.Conta;
import br.com.bytebank.banco.modelo.ContaCorrente;

public class TesteArrayList {

        public static void main(String[] args) {

        //Generics
        LinkedList<Conta> lista = new LinkedList<Conta>();

        ArrayList<String> nomes = new ArrayList<String();

//Código omitidoCOPIAR CÓDIGO
```

O código continua funcionando, apenas substituímos o `ArrayList` pelo `LinkedList`. Executaremos a classe, para testarmos. Temos o seguinte resultado no console:

```
Tamanho: 2
11
Tamanho: 1
ContaCorrente, Numero: 22, Agencia: 22
ContaCorrente, Numero: 311, Agencia: 33
ContaCorrente, Numero: 322, Agencia: 33
----------
ContaCorrente, Numero: 22, Agencia: 22
ContaCorrente, Numero: 311, Agencia: 33
ContaCorrente, Numero: 322, Agencia: 33COPIAR CÓDIGO
```

Funcionou!

Apesar de os funcionamentos internos terem sido diferentes, obtivemos os mesmos resultados finais no console.

Temos então duas classes, que utilizam métodos com os mesmos nomes, mas cujas implementações diferem. Contudo, percebemos que há um ponto em comum, ou seja, todos aqueles que pretendem ser uma `lista`, devem contar com um método `add()` de alguma forma, o mesmo para o `remove()`, e assim sucessivamente, conforme citado acima.

Isso nos leva à conclusão de que existe uma interface para isso, ela se chama `List`. Ao implementarmos na classe `TesteArrayList`:

```
//Código omitido

import br.com.bytebank.banco.modelo.Conta;
import br.com.bytebank.banco.modelo.ContaCorrente;

public class TesteArrayList {

        public static void main(String[] args) {

        //Generics
        List<Conta> lista = new LinkedList<Conta>();

        ArrayList<String> nomes = new ArrayList<String();

//Código omitidoCOPIAR CÓDIGO
```

Assim como anteriormente, teremos que importar esta interface. Há duas importações possíveis, uma do pacote `java.awt`, e outra do `java.util`, neste caso, escolheremos a segunda opção:

```
package br.com.bytebank.teste.util;

import java.util.ArrayList;
import java.util.LinkedList;
import.java.util.List;

import br.com.bytebank.banco.modelo.Conta;
import br.com.bytebank.banco.modelo.ContaCorrente;

public class TesteArrayList {

        public static void main(String[] args) {

        //Generics
        List<Conta> lista = new LinkedList<Conta>();

        ArrayList<String> nomes = new ArrayList<String();

//Código omitidoCOPIAR CÓDIGO
```

Ou seja, estamos utilizando a interface para definirmos o tipo da referência. Dentro da interface, podemos observar a existência de diversos métodos, uns que já conhecemos mas muitos outros que ainda nem exploramos.

Por fim, alteraremos o `LinkedList` de volta para `ArrayList`:

```
package br.com.bytebank.teste.util;

import java.util.ArrayList;
import java.util.LinkedList;
import.java.util.List;

import br.com.bytebank.banco.modelo.Conta;
import br.com.bytebank.banco.modelo.ContaCorrente;

public class TesteArrayList {

        public static void main(String[] args) {

        //Generics
        List<Conta> lista = new ArrayList<Conta>();

        ArrayList<String> nomes = new ArrayList<String();

//Código omitidoCOPIAR CÓDIGO
```

Existe ainda uma terceira implementação desta interface `List`, que se chama `java.util.Vector`, e que veremos adiante. Até a próxima!