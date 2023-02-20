# Aula 05 - Exceções são úteis?

De que maneira as *exceptions* podem ajudar a melhorar o código de seu programa?

**a** - Exceções tem um nome e, caso esse nome seja expressivo, documenta o problema que está ocorrendo.

**b** - Exceções podem ter uma mensagem, ou seja, o problema e o estado das variáveis podem ser descritos na mensagem.

**c** - Exceções mudam o fluxo de execução, ou seja, evitam que o problema siga o fluxo "normal" quando algo excepcional acontece.

**d** - Exceções podem ser tratadas, ou seja, podemos voltar para a execução "normal" caso o "problema" esteja resolvido.

Quais opções estão corretas?

*Selecione uma alternativa*

Todas.

Correto. Todas as opções representam uma forma de melhorar o código, principalmente a expressividade.

- As exceções podem ser tratadas (`try-catch`). Ou seja, podemos voltar para a execução "normal".
- As exceções podem sim ter uma mensagem, normalmente passado uma string no construtor. Ou seja, o problema e o estado dos variáveis podem ser descritos na mensagem.
- As exceções tem um nome que deve ser expressivo. Ou seja, o problema está documentado no nome da dessa exceção.