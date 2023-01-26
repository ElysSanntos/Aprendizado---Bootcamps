# Aula 04 - Cast possível e impossível

# **Type cast explícito sempre funciona?**

A resposta é não. O cast explicito só funciona se ele for *possível*, mas há casos em que o compilador sabe que um cast é impossível e aí nem compila, nem com *type cast*. Por exemplo:

```
Cliente cliente = new Cliente();
Conta conta = (Conta) cliente; //impossível, não compilaCOPIAR CÓDIGO
```

Como o cliente não estende a classe `Conta` ou implementa uma interface do tipo `Conta`, é impossível esse *cast* funcionar, pois uma referência do tipo `Conta` jamais pode apontar para um objeto do tipo `Cliente`.

A certificação Java tem muitas dessas perguntas sobre *cast* possível, impossível, explícito e implícito. Se você pretende tirar essa certificação, vale a pena estudar esse assunto com muita calma.