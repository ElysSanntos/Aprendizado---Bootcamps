# Aula 08 - Imprimindo texto e números

Agora que já sabemos fazer operações com variáveis e também concatenar texto com números, use o que aprendeu para indicar todas as alternativas abaixo que mostrem o resultado "A idade de Marcos é 30!".

`int idade = 20;
System.out.println("A idade de Marcos é 30!");`

Opção correta! Neste caso não estamos usando a variável idade que recebe 20.

`double idade = 30.0;
System.out.println("A idade de Marcos é " + (int) idade + "!");`

Opção correta! Estamos fazendo o type cast no double que tem seu valor convertido para int. Desta forma não aparece a casa decimal.

`int idade = 30;
System.out.println("A idade de Marcos é " + idade + "!");`

Opção correta!