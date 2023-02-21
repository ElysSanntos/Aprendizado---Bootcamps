# Aula 11 - Benefícios dos Generics

Os *generics* entraram na versão 1.5 na plataforma Java e foram levemente melhorados no Java 1.7. Quais são os principais benefícios?

Alternativa correta[x] 
O código mais legível, já que fica explícito o tipo dos elementos.
Correto, na criação da lista fica claro qual a intenção. Por exemplo, na declaração abaixo está bem claro que a lista guarda `String`s:

`ArrayList<String> nomes = new ArrayLis`

Evitar *casts* excessivos

Correto, uma vez parametrizada a lista, não precisamos mais o cast, por exemplo:

```
Cliente ref = (Cliente) lista.get(0); //
```