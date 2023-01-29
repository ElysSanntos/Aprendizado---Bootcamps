# Aula 09 - Forma literal

Até agora vimos a forma "classica" de criar um objeto array usando a palavra chave `new`, por exemplo:

```
int[] numeros = new int[6];
numeros[0] = 1;
numeros[1] = 2;
numeros[2] = 3;
numeros[3] = 4;
numeros[4] = 5;COPIAR CÓDIGO
```

No entanto também há uma forma literal. *Literal*, nesse contexto, significa usar valores diretamente, menos burocrático, mais direito. Veja a diferença:

```
int[] refs = {1,2,3,4,5};COPIAR CÓDIGO
```

Usamos as chaves `{}` para indicar que se trata de um array e os valores já ficam declarados dentro das chaves.