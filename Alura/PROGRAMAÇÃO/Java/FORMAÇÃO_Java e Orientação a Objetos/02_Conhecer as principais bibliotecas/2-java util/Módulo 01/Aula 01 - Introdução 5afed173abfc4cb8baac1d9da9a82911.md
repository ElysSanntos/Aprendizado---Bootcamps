# Aula 01 - Introdução

Olá! Bem-vindos ao curso de Java parte 6: Conhecendo o Java.util!

Meu nome é Nico Steppat e os acompanharei nas próximas aulas. Se você gostaria de entender o seguinte trecho de código:

```
//Código omitido

List<Conta> lista = new ArrayLista<>();
lista.add(cc1);
lista.add(cc2);
lista.add(cc3);
lista.add(cc4);

lista.sort( (c1, c2) -> Integer, compare(c1.getNumero(), c2.getNumero()) );

Comparator<Conta> comp = (Conta c1, Conta c2) -> {
        String nomeC1 = c1.getTitular().getNome();
        String.nomeC2 = c2.getTitular().getNome();
        return nomeC1.compareTo(nomeC2);
};

lista.sort( comp );

lista.forEach( (conta) -> System.out.println(conta + ", " + conta.getTitular().getNome());

//Código omitidoCOPIAR CÓDIGO
```

Então você veio ao lugar certo!

Trabalharemos com estruturas de dados, e entenderemos o seu funcionamento. Veremos como trabalhar com os métodos das listas, como ordenar, e trabalhar com classes anônimas, classes *wrapper*, incluindo o método `equals()`, que havia falado anteriormente.

Temos várias funcionalidades importantes para o dia-a-dia do desenvolvedor, trabalharemos bastante neste pacote, e espero encontrar-los nos próximos vídeos!