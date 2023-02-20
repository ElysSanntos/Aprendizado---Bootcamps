# Aula 07 - Acesso ao array

Continuando os estudos para certificação, você encontrou mais um trecho de código:

```
ContaPoupanca[] contas = new ContaPoupanca[10];
ContaPoupanca cp1 = new ContaPoupanca(11,22);
ContaPoupanca cp2 = new ContaPoupanca(33,44);

contas[0] = cp1;
contas[4] = cp2;

System.out.println(contas[1].getNumero());COPIAR CÓDIGO
```

Executando esse trecho dentro do método `main` do nosso projeto, qual é o resultado?

*Obs: Se tiver com dúvidas teste o código, sem problemas!*

`NullPointerException`

Correto, pois estamos acessando o segundo elemento do array (a posição `1`) e essa posição ainda está `null`:

```
System.out.println(contas[1].getNumero());COPIAR CÓDIGO
```

Consequentemente recebemos uma `NullPointerException`.