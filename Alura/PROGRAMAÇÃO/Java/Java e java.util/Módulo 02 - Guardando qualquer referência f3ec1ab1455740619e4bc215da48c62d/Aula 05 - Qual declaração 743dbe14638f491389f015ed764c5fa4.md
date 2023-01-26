# Aula 05 - Qual declaração?

Veja a hierarquia de classes:

![https://caelum-online-public.s3.amazonaws.com/850-java-util/02/hierarquia_funcionario.png](https://caelum-online-public.s3.amazonaws.com/850-java-util/02/hierarquia_funcionario.png)

E a declaração do array:

```
????[] referencias = new ????[5];

referencias[0] = new Designer();
referencias[1] = new Gerente();

Designer designer = (Designer) referencias[0];
Gerente gerente = (Gerente) referencias[1];COPIAR CÓDIGO
```

O que podemos colocar no lugar de `????` para o código compilar?

*Selecione 2 alternativas*

`Funcionario`

Correto, como os tipos `Designer` e `Gerente` são `Funcionario`s basta colocar:

```
Funcionario[] referencias = new Funcionario[5]
```

`Object`

Correto, como o tipo consegue guardar qualquer tipo `Object` de referências o código compilar:

```
Object[] referencias = new Object[5]
```