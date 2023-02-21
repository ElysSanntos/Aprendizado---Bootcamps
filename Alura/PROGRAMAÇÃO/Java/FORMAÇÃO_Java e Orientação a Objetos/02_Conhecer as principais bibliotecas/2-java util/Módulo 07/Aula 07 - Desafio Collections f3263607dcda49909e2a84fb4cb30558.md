# Aula 07 - Desafio Collections

Vou te passar um desafio e fazer algumas perguntas relacionadas com listas. Para responder, investigue a documentação oficial da classe `Collections` dentro do pacote `java.util`:

- Como podemos inverter a ordem de uma lista?
- Como podemos embaralhar todos os elementos de uma lista?
- Como podemos rotacionar os elementos de uma lista?

Você consegue descobrir os métodos?

Para inverter a ordem de lista você pode usar o método `reverse` da classe `Collections`:

```
Collections.reverse(lista);COPIAR CÓDIGO
```

Para embaralhar existe o método `shuffle` e para rotacionar tem o método `rotate`:

```
Collections.shuffle(lista);
Collections.rotate(lista, 5); //rotacionar 5 posicoesCOPIAR CÓDIGO
```

Vale explorar essa classe!