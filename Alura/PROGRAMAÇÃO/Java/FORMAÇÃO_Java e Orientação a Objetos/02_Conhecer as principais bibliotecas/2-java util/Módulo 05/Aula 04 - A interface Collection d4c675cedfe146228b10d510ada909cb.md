# Aula 04 - A interface Collection

Olá! Nesta aula, daremos continuidade à explicação sobre o pacote `java.util` mas, antes, faremos mais uma revisão.

Até o momento, focamos em listas e nas implementações principais, dos principais métodos das listas. Como sabemos, as listas são sequências, por isso, ela sabe em qual ordem os seus elementos foram inseridos, com isso, ao iterar, os recebemos na mesma ordem de inserção.

Vimos tipos de implementação, como a `ArrayList`, o `Vector` - que possui o *thread safe*, e o `LinkedList`, que é totalmente encadeada. O que todos eles têm em comum é que são listas, e que aceitam duplicados. Isso significa que, se uma referência já foi adicionada, ela é aceita novamente pela lista. É possível adicionarmos a mesma referência diversas vezes, em uma mesma lista.

Neste ponto, temos um aspecto que nem sempre é desejado, nem sempre queremos ter elementos duplicados em nossas listas. Por exemplo, em uma lista de contas bancárias, não tem muito sentido haver o registro duplicado de determinado elemento. Neste contexto de negócio, não queremos que isto aconteça.

Entretanto, por padrão, a lista não nos fornece nenhum mecanismo que nos ajude em relação a este aspecto.

Precisamos, primeiro, verificar se determinado elemento já é presente para, somente então, termos segurança para adicioná-lo. Por este motivo, existe um outro mundo de conjuntos, que inclui o `java.util.Set` e `java.util.HashSet`. Para entendê-los melhor, é necessário conhecer o método `hashCode()`.

Não se trata de sequências, os *sets* espalham seus elementos com base no `hashCode()`. Isto é melhor explorado em um [curso específico](https://cursos.alura.com.br/course/java-util-lambdas/task/38649), cujo foco é esse, na implementação do `HashSet` e em outras implementações importantes.

Disso tudo, podemos concluir que um `Set` não aceita elementos duplicados e que, por padrão, não é uma sequência. Entretanto, Tanto as listas quanto os *sets* compartilham um elemento em comum, que são as coleções do `java.util.Collection`. Elas podem ser tanto listas, quanto um conjunto de *sets*.

Há uma interface mãe, da `List` e da `Set`, que é a `Collection`.

Em nosso código, isso significa que, ao criarmos um `ArrayList`, podemos utilizar uma interface ainda mais genérica. Se observarmos o código da própria interface `List`, veremos que ela estende `Collection`. Por isso, se ela é capaz de implementar `List`, consequentemente, ela pode fazer o mesmo com a interface `Collection`.

Temos um problema, pois alguns métodos deixam de funcionar. Por exemplo, o `get()`, que trabalha com a ideia de índices. Os índices são aplicáveis somente ao conceito de listas e, apesar de o `Collection` contemplar tanto elas quanto *sets*, ao generalizarmos, não será possível utilizarmos este tipo de métodos, já que os índices não existem para o universo dos *sets*.

Para aprofundar-se, é recomendável acessar os [cursos específicos](https://cursos.alura.com.br/course/java-util-lambdas/task/38649) em relação a este conteúdo.