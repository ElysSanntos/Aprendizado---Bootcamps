# Aula 10 - Para saber mais: Type Casting

Como foi visto nos vídeos, quando tentamos colocar um valor inteiro em uma variável do tipo double o Java não mostra erro. Quando tentamos, porém, colocar um double numa variável do tipo inteiro temos um erro de compilação.

Esta propriedade se dá porque o Java faz conversão implícita de um tipo menor para os tipos "maiores". De inteiro para double, por exemplo.

O contrário não é verdade porque existe perda de dados quando é feita a conversão. Acarretando em um "type mismatch" mostrando que esta instrução é de tipos incompatíveis.

Para fazer uma conversão onde pode haver perda de informações é necessário fazer um type casting. Veja a instrução abaixo.

```
int idade = (int) 30.0;COPIAR CÓDIGO
```

No caso acima, está explícito que será feito o cast de double para inteiro. Veja como funciona o cast implícito e explícito na tabela abaixo.

| DE/PARA | byte | short | char | int | long | float | double |
| --- | --- | --- | --- | --- | --- | --- | --- |
| byte | ---- | Impl. | (char) | Impl. | Impl. | Impl. | Impl. |
| short | (byte) | ---- | (char) | Impl. | Impl. | Impl. | Impl. |
| char | (byte) | (short) | ---- | Impl. | Impl. | Impl. | Impl. |
| int | (byte) | (short) | (char) | ---- | Impl. | Impl. | Impl. |
| long | (byte) | (short) | (char) | (int) | ---- | Impl. | Impl. |
| float | (byte) | (short) | (char) | (int) | (long) | ---- | Impl. |
| double | (byte) | (short) | (char) | (int) | (long) | (float) | ---- |

Para comparar cada tipo primitivo de forma mais clara, a tabela abaixo mostra qual o tamanho de cada um.

| TIPO | TAMANHO |
| --- | --- |
| boolean | 1 bit |
| byte | 1 byte |
| short | 2 bytes |
| char | 2 bytes |
| int | 4 bytes |
| float | 4 bytes |
| long | 8 bytes |
| double | 8 bytes |