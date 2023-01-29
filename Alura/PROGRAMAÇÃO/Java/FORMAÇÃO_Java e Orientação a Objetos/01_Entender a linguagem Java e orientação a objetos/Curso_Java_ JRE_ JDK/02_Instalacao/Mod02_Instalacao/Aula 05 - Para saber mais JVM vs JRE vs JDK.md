# Aula 05 - Para saber mais: JVM vs JRE vs JDK

O mundo Java é cheio de siglas com 3 ou 4 letras começando com `J`. Você já conhece duas famosas: o **JRE** e **JDK**. O primeiro é o ambiente de execução, o segundo são as ferramentas de desenvolvimento *junto* com o ambiente de execução. Simplificando podemos dizer:

```
JDK = JRE + ferramentas de desenvolvimentoCOPIAR CÓDIGO
```

Existe uma terceira sigla, **JVM** (*Java Virtual Machine*), que também já usamos durante o curso. A responsabilidade da Java Virtual Machine é executar o Bytecode! Então qual é diferença entre JVM e JRE? Ambos executam o Bytecode, certo?

A resposta é simples: O JRE (o nosso ambiente de execução) contém a JVM, mas também possui um monte de bibliotecas embutidas. Ou seja, para rodar uma aplicação Java não basta ter apenas a JVM, também é preciso ter as bibliotecas.

Assim podemos simplificar e dizer:

```
JRE = JVM + bibliotecasCOPIAR CÓDIGO
```

É importante entender que você não pode baixar a JVM apenas. Você sempre baixa o JRE que tem a JVM e as bibliotecas em conjunto.