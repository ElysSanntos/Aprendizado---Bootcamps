# Aula 05 - Sobre Object

A classe **Object** é a classe raiz do Java, sobre ela é correto afirmar:

Alternativa correta[x] 
Qualquer objeto pode ser referenciado pelo tipo `Object`, já que ela é a principal.
Correto, o tipo `Object` é a forma mais genérica de referenciar um objeto.

Não é preciso deixar explícito na declaração de uma classe que ela deve herdar de `Object`, porque isso é automático.

Correto, não é preciso herda do `Object` explicitamente, o compilador automaticamente insere a declaração.

- na herança você sempre herda o comportamento de todas classes na hierarquia. Se o `Gerente`  herda do `Funcionario`
 e `Funcionario`  herda do `Objeto` , ambos `Gerente`  e `Funcionario`  são objetos e herdam as funcionalidades da classe `Object`.