# Aula 05 - A classe String

Uma das classes que frequentemente lidamos é a **String** . Qual das afirmativas é a correta sobre ela:

É uma classe definida em `java.lang` e por isso não há a necessidade de importar.

Correto, pois a classe `String` realmente é do pacote `java.lang`. O FQN é `java.lang.String`

- existe sim uma diferença entre a criação com `new`  e a criação com aspas duplas. Usar aspas duplas é boa prática pois a JVM pode executar várias otimizações por baixo dos panos.
- objetos da classe `String`  são **imutáveis** . Isso significa que, uma vez criado, não pode ser alterado, por isso qualquer alteração cria um novo objeto `String`.
- `String`s podem e devem ser criados usando aspas duplas:

```
String nome = "alura";
```