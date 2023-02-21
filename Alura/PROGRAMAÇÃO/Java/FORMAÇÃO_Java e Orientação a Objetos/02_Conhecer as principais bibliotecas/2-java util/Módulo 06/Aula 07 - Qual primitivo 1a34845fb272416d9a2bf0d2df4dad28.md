# Aula 07 - Qual primitivo?

Veja o código a seguir.

```
Character cRef = new Character('A');COPIAR CÓDIGO
```

Qual é o tipo primitivo desse wrapper?

*Selecione uma alternativa*

`char`

Correto! O interessante é que o `char` é quase um tipo numérico. Ele tem dois bytes, igual o tipo `short` mas não usa o primeiro bit para guardar o sinal. Em outras palavras, o char só guarda números positivos. Isso significa que o `char` consegue guardar valores entre 0 e 65535 (2^16).

- o tipo primitivo `short`  tem dois bytes (igual a `char` ) mas possui um sinal para guardar números negativos.
- não existe um tipo `string`  (com `s`  minúsculo).
- o tipo primitivo se chama apenas `char`.