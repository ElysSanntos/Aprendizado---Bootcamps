# Aula 02 - Comparando Strings

Dando continuidade à aula anterior, nesta, criaremos mais um `comparator`.

Previamente, havíamos criado uma classe com o intuito de encapsular somente um método específico, cuja execução efetua a comparação utilizando os parâmetros definidos, e em seguida, fizemos sua implementação. Fizemos isto baseado em um critério numérico, entretanto, nesta aula, veremos como isso pode ser feito com base em um `String`, já que neste caso a comparação envolverá vários caracteres.

Para dar início, nossas quatro contas serão reformuladas e passarão a conter as seguintes informações:

```
//Código omitido

public class Teste {

        public static void main(String[] args) {

                        Conta cc1 = new ContaCorrente(22, 33);
                        Cliente clienteCC1 = new Cliente();
                        clienteCC1.setNome("Nico");
                        cc1.setTitular(clienteCC1);
                        cc1.deposita(333.0);

                        Conta cc2 = new ContaPoupanca(22, 44);
                        Cliente clienteCC2 = new Cliente();
                        clienteCC2.setNome("Guilherme");
                        cc2.setTitular(clienteCC2);
                        cc2.deposita(444.0);

                        Conta cc3 = new ContaCorrente(22, 11);
                        Cliente clienteCC3 = new Cliente();
                        clienteCC3.setNome("Paulo");
                        cc3.setTitular(clienteCC3);
                        cc3.deposita(111.0);

                        Conta cc4 = new ContaPoupanca(22, 22);
                        Cliente clienteCC4 = new Cliente();
                        clienteCC4.setNome("Ana");
                        cc4.setTitular(clienteCC4);
                        cc4.deposita(222.0);

                        List<Conta> lista = new ArrayList<>();
                        lista.add(cc1);
                        lista.add(cc2);
                        lista.add(cc3);
                        lista.add(cc4);

                        for (Conta conta : lista) {
                                System.out.println(conta);
                        }

                        NumeroDaContaComparator comparator = new NumeroDaContaComparator();

                        System.out.println("---------");

                        for (Conta conta : lista) {
                                System.out.println(conta);
                        }

                        lista.sort(comparator);

                        }

}

class NumeroDaContaComparator implements Comparator<Conta> {

        @Override
        public int compare(Conta c1, Conta c2) {

                if(c1.getNumero() < c2.getNumero()) {
                    return -1;
                }

                if(c1.getNumero() > c2.getNumero()) {
                    return 1;
                }

            return 0;
        }
}COPIAR CÓDIGO
```

Importaremos a classe `Cliente`, da mesma forma como vimos anteriormente. Isso porque queremos que a conta tenha um titular. Portanto, criamos os clientes, demos um nome a cada um deles, associamos a referência da conta ao titular, com o método `setTitular()`.

A seguir, definiremos mais um critério de comparação, para isso, criaremos mais uma classe, à qual daremos o nome de `TitularDaContaComparator`, que também terá como parâmetro `Conta`:

```
//Código omitido

public class Teste {

        public static void main(String[] args) {

                        Conta cc1 = new ContaCorrente(22, 33);
                        Cliente clienteCC1 = new Cliente();
                        clienteCC1.setNome("Nico");
                        cc1.setTitular(clienteCC1);
                        cc1.deposita(333.0);

                        Conta cc2 = new ContaPoupanca(22, 44);
                        Cliente clienteCC2 = new Cliente();
                        clienteCC2.setNome("Guilherme");
                        cc2.setTitular(clienteCC2);
                        cc2.deposita(444.0);

                        Conta cc3 = new ContaCorrente(22, 11);
                        Cliente clienteCC3 = new Cliente();
                        clienteCC3.setNome("Paulo");
                        cc3.setTitular(clienteCC3);
                        cc3.deposita(111.0);

                        Conta cc4 = new ContaPoupanca(22, 22);
                        Cliente clienteCC4 = new Cliente();
                        clienteCC4.setNome("Ana");
                        cc4.setTitular(clienteCC4);
                        cc4.deposita(222.0);

                        List<Conta> lista = new ArrayList<>();
                        lista.add(cc1);
                        lista.add(cc2);
                        lista.add(cc3);
                        lista.add(cc4);

                        for (Conta conta : lista) {
                                System.out.println(conta);
                        }

                        NumeroDaContaComparator comparator = new NumeroDaContaComparator();

                        System.out.println("---------");

                        for (Conta conta : lista) {
                                System.out.println(conta);
                        }

                        lista.sort(comparator);

                        }

}

class TitularDaContaComparator implements Comparator<Conta> {

}

class NumeroDaContaComparator implements Comparator<Conta> {

        @Override
        public int compare(Conta c1, Conta c2) {

                if(c1.getNumero() < c2.getNumero()) {
                    return -1;
                }

                if(c1.getNumero() > c2.getNumero()) {
                    return 1;
                }

            return 0;
        }
}COPIAR CÓDIGO
```

Temos um problema de compilação, pois ainda não implementamos o método. Assim, faremos a implementação automática sugerida pelo Eclipse, e configuraremos posteriormente:

```
//Código omitido

public class Teste {
//Código omitido
}

class TitularDaContaComparator implements Comparator<Conta> {

        @Override
        public int compare(Conta arg0, Conta arg1) {
                // TODO Auto-generated method stub
                return 0;
        }
}

class NumeroDaContaComparator implements Comparator<Conta> {

        @Override
        public int compare(Conta c1, Conta c2) {

                if(c1.getNumero() < c2.getNumero()) {
                    return -1;
                }

                if(c1.getNumero() > c2.getNumero()) {
                    return 1;
                }

            return 0;
        }
}COPIAR CÓDIGO
```

Substituiremos os argumentos por `c1` e `c2`, assim como havíamos feito anteriormente. O retorno `0` será mantido, para a hipótese de as contas serem iguais. Em seguida, criaremos os "`if`s" para compararmos os nomes dos titulares de cada conta. Em primeiro lugar, precisamos descobrir o nome do titular, utilizando o método `getTitular()`, acessando a classe `Conta`. Em cima da referência do titular, podemos utilizar o método `getNome()` imediatamente:

```
//Código omitido

public class Teste {
//Código omitido
}

class TitularDaContaComparator implements Comparator<Conta> {

        @Override
        public int compare(Conta c1, Conta c2) {

                String nomeC1 = c1.getTitular().getNome();

                return 0;
        }
}

class NumeroDaContaComparator implements Comparator<Conta> {

        @Override
        public int compare(Conta c1, Conta c2) {

                if(c1.getNumero() < c2.getNumero()) {
                    return -1;
                }

                if(c1.getNumero() > c2.getNumero()) {
                    return 1;
                }

            return 0;
        }
}COPIAR CÓDIGO
```

Este processo será repetido para a conta `c2`:

```
//Código omitido

public class Teste {
//Código omitido
}

class TitularDaContaComparator implements Comparator<Conta> {

        @Override
        public int compare(Conta c1, Conta c2) {

                String nomeC1 = c1.getTitular().getNome();
                String nomeC2 = c2.getTitular().getNome();

                return 0;
        }
}

class NumeroDaContaComparator implements Comparator<Conta> {

        @Override
        public int compare(Conta c1, Conta c2) {

                if(c1.getNumero() < c2.getNumero()) {
                    return -1;
                }

                if(c1.getNumero() > c2.getNumero()) {
                    return 1;
                }

            return 0;
        }
}COPIAR CÓDIGO
```

Agora nos resta criar o método de comparação pela ordem alfabética. A classe `String` já possui, implementado, um método de ordenação utilizando este critério.

Ao chamarmos o `nomeC1`, surgirá uma lista de métodos, dentre eles, temos o `compareTo()`, que recebe como parâmetro um outro `String`, e que resulta em um `int`. Quando os "`Strings`" forem iguais, o retorno é `0`, se um for menor que o outro, o resultado é negativo, e se um for maior que o outro, o resultado é positivo. Desta forma, temos o seguinte método:

```
//Código omitido

public class Teste {
//Código omitido
}

class TitularDaContaComparator implements Comparator<Conta> {

        @Override
        public int compare(Conta c1, Conta c2) {

                String nomeC1 = c1.getTitular().getNome();
                String nomeC2 = c2.getTitular().getNome();

                nomeC1.compareTo(nomeC2);

                return 0;
        }
}

class NumeroDaContaComparator implements Comparator<Conta> {

        @Override
        public int compare(Conta c1, Conta c2) {

                if(c1.getNumero() < c2.getNumero()) {
                    return -1;
                }

                if(c1.getNumero() > c2.getNumero()) {
                    return 1;
                }

            return 0;
        }
}COPIAR CÓDIGO
```

Já que o resultado é um `Integer`, podemos inseri-lo diretamente como retorno:

```
//Código omitido

public class Teste {
//Código omitido
}

class TitularDaContaComparator implements Comparator<Conta> {

        @Override
        public int compare(Conta c1, Conta c2) {

                String nomeC1 = c1.getTitular().getNome();
                String nomeC2 = c2.getTitular().getNome();
                return nomeC1.compareTo(nomeC2);
        }
}

class NumeroDaContaComparator implements Comparator<Conta> {

        @Override
        public int compare(Conta c1, Conta c2) {

                if(c1.getNumero() < c2.getNumero()) {
                    return -1;
                }

                if(c1.getNumero() > c2.getNumero()) {
                    return 1;
                }

            return 0;
        }
}COPIAR CÓDIGO
```

Em seguida, na classe `Teste`, criaremos um novo `comparator`:

```
//Código omitido

public class Teste {

//Código omitido

        for (Conta conta : lista) {
                System.out.println(conta);
        }

        NumeroDaContaComparator comparator = new NumeroDaContaComparator();
        TitularDaContaComparator titularComparator = new TitularDaContaComparator();
        lista.sort(comparator);

        System.out.println("---------");

        for (Conta conta : lista) {
                System.out.println(conta);
        }

}

class TitularDaContaComparator implements Comparator<Conta> {

        @Override
        public int compare(Conta c1, Conta c2) {

                String nomeC1 = c1.getTitular().getNome();
                String nomeC2 = c2.getTitular().getNome();
                return nomeC1.compareTo(nomeC2);
        }
}

class NumeroDaContaComparator implements Comparator<Conta> {

        @Override
        public int compare(Conta c1, Conta c2) {

                if(c1.getNumero() < c2.getNumero()) {
                    return -1;
                }

                if(c1.getNumero() > c2.getNumero()) {
                    return 1;
                }

            return 0;
        }
}COPIAR CÓDIGO
```

Por fim, passaremos o `titularComparator` como parâmetro para o método `sort()`:

```
//Código omitido

public class Teste {

//Código omitido

        for (Conta conta : lista) {
                System.out.println(conta);
        }

        NumeroDaContaComparator comparator = new NumeroDaContaComparator();
        TitularDaContaComparator titularComparator = new TitularDaContaComparator();
        lista.sort(titularComparator);

        System.out.println("---------");

        for (Conta conta : lista) {
                System.out.println(conta);
        }

}

class TitularDaContaComparator implements Comparator<Conta> {

        @Override
        public int compare(Conta c1, Conta c2) {

                String nomeC1 = c1.getTitular().getNome();
                String nomeC2 = c2.getTitular().getNome();
                return nomeC1.compareTo(nomeC2);
        }
}

class NumeroDaContaComparator implements Comparator<Conta> {

        @Override
        public int compare(Conta c1, Conta c2) {

                if(c1.getNumero() < c2.getNumero()) {
                    return -1;
                }

                if(c1.getNumero() > c2.getNumero()) {
                    return 1;
                }

            return 0;
        }
}COPIAR CÓDIGO
```

Executaremos nossa classe, e temos o seguinte resultado no console:

```
ContaCorrente, Numero: 33, Agencia: 22
ContaPoupanca, Numero: 44, Agencia: 22
ContaCorrente, Numero: 11, Agencia: 22
ContaPoupanca, Numero: 22, Agencia: 22
---------
ContaPoupanca, Numero: 22, Agencia: 22
ContaPoupanca, Numero: 44, Agencia: 22
ContaCorrente, Numero: 33, Agencia: 22
ContaCorrente, Numero: 11, Agencia: 22COPIAR CÓDIGO
```

Percebemos que, em relação à ordem numérica, temos uma ordenação diferente. Mas ainda não conseguimos visualizar quem é o titular de cada conta, para melhorarmos isso, no segundo laço, concatenaremos em cada impressão o nome do titular da respectiva conta:

```
//Código omitido

public class Teste {

//Código omitido

        for (Conta conta : lista) {
                System.out.println(conta);
        }

        NumeroDaContaComparator comparator = new NumeroDaContaComparator();
        TitularDaContaComparator titularComparator = new TitularDaContaComparator();
        lista.sort(titularComparator);

        System.out.println("---------");

        for (Conta conta : lista) {
                System.out.println(conta + ", " + conta.getTitular().getNome());
        }

}

class TitularDaContaComparator implements Comparator<Conta> {

        @Override
        public int compare(Conta c1, Conta c2) {

                String nomeC1 = c1.getTitular().getNome();
                String nomeC2 = c2.getTitular().getNome();
                return nomeC1.compareTo(nomeC2);
        }
}

class NumeroDaContaComparator implements Comparator<Conta> {

        @Override
        public int compare(Conta c1, Conta c2) {

                if(c1.getNumero() < c2.getNumero()) {
                    return -1;
                }

                if(c1.getNumero() > c2.getNumero()) {
                    return 1;
                }

            return 0;
        }
}COPIAR CÓDIGO
```

Executaremos novamente, e temos o seguinte resultado:

```
ContaCorrente, Numero: 33, Agencia: 22
ContaPoupanca, Numero: 44, Agencia: 22
ContaCorrente, Numero: 11, Agencia: 22
ContaPoupanca, Numero: 22, Agencia: 22
---------
ContaPoupanca, Numero: 22, Agencia: 22, Ana
ContaPoupanca, Numero: 44, Agencia: 22, Guilherme
ContaCorrente, Numero: 33, Agencia: 22, Nico
ContaCorrente, Numero: 11, Agencia: 22, PauloCOPIAR CÓDIGO
```

Como podemos observar, tudo está funcionando, as contas estão em ordem alfabética.

Adiante, veremos o método antigo de fazer esta comparação. Até a próxima!