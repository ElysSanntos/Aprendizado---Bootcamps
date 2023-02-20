# Aula 04 - Qual modificador? #2

E agora, qual modificador é visível nos seguintes lugares?

```
Classe   Package   Classe Filho   Qq Package
────────────────────────────────────────────
 ✔        ✔         ✘             ✘
───────────────────────────────────────────
```

*`<<package private>>`* (ausência do modificador)

A ausência do modificador, também chamado de *package private* ou *default*, o membro fica visível na classe e no package, mas é invisível fora do pacote (nem para filhos).