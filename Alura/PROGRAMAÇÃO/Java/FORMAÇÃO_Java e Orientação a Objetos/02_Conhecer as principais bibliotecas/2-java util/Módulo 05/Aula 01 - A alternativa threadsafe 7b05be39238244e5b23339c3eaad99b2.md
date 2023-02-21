# Aula 01 - A alternativa threadsafe

> Você pode fazer o [DOWNLOAD](https://caelum-online-public.s3.amazonaws.com/850-java-util/05/java6-cap5.zip) do projeto da aula anterior.
> 

Olá!

Anteriormente, falamos sobre a `java.util.LinkedList` e faltou abordarmos o `java.util.Vector`, que juntamente com o `java.util.ArrayList` são as principais implementações da interface `java.util.List`.

No que o `Vector` difere das demais? Ele, na verdade, é igual a um `ArrayList`. Internamente, ele também utiliza um array. O Java nasceu com um `Vector` e, posteriormente, as demais implementações foram adicionadas.

O `Vector` tem uma diferença importante em relação ao `ArrayList`, ele é o que chamamos de ***thread safe***.

Como vimos, qualquer programa em Java inicia com um método `main`, que forma uma "pilha" e, a partir dele, podemos ter uma nova "pilha". Dessa forma, elas podem ser executadas em paralelo. O Java permite a criação de inúmeros métodos `main`.

Quando temos esse tipo de situação, e desejamos que as execuções sejam feitas em paralelo, em cima de uma mesma lista, utilizamos o `java.util.Vector`. Este tipo de operação só funciona dessa forma, o `ArrayList` e o `LinkedList` não servem.

Apesar disso, o `Vector` é utilizado como exceção. As ocasiões em que ele é necessário são raras, ou seja, é difícil termos situações como a citada acima, onde são compartilhadas entre duas ou mais "pilhas" uma mesma lista.

Mas e se usássemos o `Vector` como uma medida preventiva? Caso ele fosse ser necessário futuramente? Isso também não funcionaria, já que a utilização dele, em si, tem um custo em desempenho. Assim, se não for estritamente necessário, é melhor utilizar outros tipos de lista, como o `ArrayList`, que é mais eficiente.

Para saber mais sobre isso, há dois cursos dedicados especificamente a este tópico, o primeiro, em que é falado sobre as *threads* e as implementações, e o segundo, onde é criado um servidor que utiliza estes recursos.

> Os cursos citados acima são citados na atividade 3, da aula 05.
> 

Retornaremos ao código da classe `TesteArrayList`, onde temos implementado o `Vector`:

```
//Código omitido

public class TesteArrayList {

        public static void main(String[] args) {

                //Generics
                List<Conta> lista = new Vector<Conta>();//thread safe

                Conta cc = new ContaCorrente(22, 11);
                lista.add(cc);

                Conta cc2 = new ContaCorrente(22, 22);
                lista.add(cc2);

//Código omitidoCOPIAR CÓDIGO
```

A interface `List` permanece inalterada, mas estamos utilizando a nova classe `Vector`, que é aquilo que chamamos de ***thread safe***. Neste curso, a *thread safety* não é algo estritamente necessário, isso porque não estamos trabalhando com mais de um método `main`, ou "pilhas", como chamamos.

Ao executarmos a classe, temos o seguinte resultado no console:

```
Tamanho: 2
11
Tamanho: 1
ContaCorrente, Numero: 22, Agencia: 22
ContaCorrente, Numero: 311, Agencia: 33
ContaCorrente, Numero: 322, Agencia: 33
---------
ContaCorrente, Numero: 22, Agencia: 22
ContaCorrente, Numero: 311, Agencia: 33
ContaCorrente, Numero: 322, Agencia: 33COPIAR CÓDIGO
```

Tudo continua funcionando normalmente.

Com isso, temos três opções de listas disponíveis para uso: `LinkedList`, `ArrayList`, ou `Vector`. Por mais que troquemos a implementação, o corpo do código permanece o mesmo, e funciona com qualquer um dos três tipos, graças ao polimorfismo. Por enquanto, manteremos em `ArrayList`:

```
//Código omitido

public class TesteArrayList {

        public static void main(String[] args) {

                //Generics
                List<Conta> lista = new ArrayList<Conta>();//thread safe

                Conta cc = new ContaCorrente(22, 11);
                lista.add(cc);

                Conta cc2 = new ContaCorrente(22, 22);
                lista.add(cc2);

//Código omitidoCOPIAR CÓDIGO
```

Adiante, veremos mais sobre o pacote `java.util`. Vale lembrar sobre os cursos específicos para as *threads*, mencionados acima. Até a próxima!