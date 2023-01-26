# Aula 02 - Entendendo o código

Você está revisando um projeto do seu amigo e encontrou o código abaixo:

```
Conta c = new Conta();
c.CAIXA.getCodigo();
```

A classe `Conta` está dentro de um outro *package* e foi importada corretamente.

O que podemos dizer sobre a parte `CAIXA` no código acima? Marque todas as alternativas corretas:

*Selecione 3 alternativas*

`CAIXA` é um atributo da instância.

Correto, `CAIXA` é uma atributo da instância, pois usamos a referência `c` para acessar o atributo. Se fosse estático a chamada seria:

```
Conta.CAIXA.getCodigo();
```

`CAIXA` tem visibilidade pública.

Correto, pois no enunciado diz que estamos importando as classes corretamente. Isso significa que a classe `Conta` está dentro de um outro *package*.

`CAIXA` é uma referência.

Correto, pois estamos usando o `.` para chamar o método `getCodigo()`. Se `CAIXA` fosso um primitivo não seria possível chamar um método.