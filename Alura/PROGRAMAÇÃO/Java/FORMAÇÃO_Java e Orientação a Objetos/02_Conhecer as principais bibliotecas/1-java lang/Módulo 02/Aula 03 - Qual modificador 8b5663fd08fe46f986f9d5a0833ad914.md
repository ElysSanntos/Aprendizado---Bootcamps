# Aula 03 - Qual modificador?

Qual modificador é visível nos seguintes lugares?

```
Classe   Package   Classe Filho   Qualquer Package
────────────────────────────────────────────
 ✔        ✔         ✔             ✘
────────────────────────────────────────────
```

`protected`

Correto! O modificador `protected` funciona igual ao *`<<package private>>` mas adiciona a visibilidade para os filhos (chamado de "publico para os filhos").