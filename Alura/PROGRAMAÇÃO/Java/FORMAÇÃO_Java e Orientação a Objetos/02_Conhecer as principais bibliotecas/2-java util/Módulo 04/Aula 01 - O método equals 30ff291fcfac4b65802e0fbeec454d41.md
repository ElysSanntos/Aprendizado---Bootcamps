# Aula 01 - O método equals

> Você pode fazer o [DOWNLOAD](https://caelum-online-public.s3.amazonaws.com/850-java-util/04/java6-cap4.zip) do projeto da aula anterior.
> 

Olá! Nesta aula, daremos continuidade à nossa viagem pelo pacote `java.util`, neste momento, passando pela classe `ArrayList`, integrando com a classe `Object`, e, nesta aula, com o método `equals()`.

Primeiro, renomearemos a classe `Teste`, ela passará a se chamar `TesteArrayList`. Em seguida, criaremos uma cópia sua, que se chamará `TesteArrayListEquals`.

A classe `TesteArrayListEquals` terá o seguinte conteúdo:

```
package br.com.bytebank.banco.test.util;

import java.util.ArrayList;

public class TesteArrayListEquals {

        public static void main(String[] args) {

        //Generics
        ArrayList<Conta> lista = new ArrayList<Conta>();

        Conta cc = new ContaCorrente(22, 11);
        lista.add(cc);

        Conta cc2 = new ContaCorrente(22, 22);
        lista.add(cc2);

        for(Conta conta : lista) {
                System.out.println(conta);
        }
    }
}COPIAR CÓDIGO
```

Ou seja, temos nela duas contas adicionadas, e um laço. Ao executarmos, temos o seguinte resultado no console:

```
ContaCorrente, Numero: 11, Agencia: 22
ContaCorrente, Numero: 22, Agencia: 22COPIAR CÓDIGO
```

A seguir, começaremos a trabalhar com o método `contains()`. Podemos verificar se a lista possui determinado elemento, por exemplo, `cc2`. O `contains()` nos retorna um `boolean`, `true` ou `false`, dependendo da existência deste elemento, ou não.

Para visualizarmos melhor, criaremos uma impressão desta resposta:

```
package br.com.bytebank.banco.test.util;

import java.util.ArrayList;

public class TesteArrayListEquals {

        public static void main(String[] args) {

        //Generics
        ArrayList<Conta> lista = new ArrayList<Conta>();

        Conta cc = new ContaCorrente(22, 11);
        lista.add(cc);

        Conta cc2 = new ContaCorrente(22, 22);
        lista.add(cc2);

        boolean existe = lista.contains(cc2);

        System.out.println("Já existe? " + existe);

        for(Conta conta : lista) {
                System.out.println(conta);
        }
    }
}COPIAR CÓDIGO
```

Teoricamente, teríamos que ter um resultado `true`, uma vez que sabemos que a conta `cc2` já foi adicionada. Executando a classe, temos o seguinte resultado:

```
Já existe? true
ContaCorrente, Numero: 11, Agencia: 22
ContaCorrente, Numero: 22, Agencia: 22COPIAR CÓDIGO
```

Funcionou!

A seguir, criaremos mais uma conta, antes da linha que contém o método `contains()`. Esta conta será `cc3`:

```
package br.com.bytebank.banco.test.util;

import java.util.ArrayList;

public class TesteArrayListEquals {

        public static void main(String[] args) {

        //Generics
        ArrayList<Conta> lista = new ArrayList<Conta>();

        Conta cc = new ContaCorrente(22, 11);
        lista.add(cc);

        Conta cc2 = new ContaCorrente(22, 22);
        lista.add(cc2);

        Conta cc3 = new ContaCorrente(22, 22);
        boolean existe = lista.contains(cc2);

        System.out.println("Já existe? " + existe);

        for(Conta conta : lista) {
                System.out.println(conta);
        }
    }
}COPIAR CÓDIGO
```

Entretanto, apesar de as contas `cc2` e `cc3` possuírem os mesmos números de agência e conta, não adicionamos `cc3` à lista. Alteraremos a referência do método `contains()` para que ele busque na lista a existência da conta `cc3`:

```
package br.com.bytebank.banco.test.util;

import java.util.ArrayList;

public class TesteArrayListEquals {

        public static void main(String[] args) {

        //Generics
        ArrayList<Conta> lista = new ArrayList<Conta>();

        Conta cc = new ContaCorrente(22, 11);
        lista.add(cc);

        Conta cc2 = new ContaCorrente(22, 22);
        lista.add(cc2);

        Conta cc3 = new ContaCorrente(22, 22);
        boolean existe = lista.contains(cc3);

        System.out.println("Já existe? " + existe);

        for(Conta conta : lista) {
                System.out.println(conta);
        }
    }
}COPIAR CÓDIGO
```

Como sabemos, a referência `cc3` não existe na lista, contudo, os dados da conta são exatamente os mesmos da `cc2`. Na prática, as duas referências representam uma mesma conta na vida real.

Executaremos a classe. Temos o seguinte resultado no console:

```
Já existe? false
ContaCorrente, Numero: 11, Agencia: 22
ContaCorrente, Numero: 22, Agencia: 22COPIAR CÓDIGO
```

Ele nos retornou `false`. Isso porque, na verdade, o `cc3` é uma outra referência, e o `contains()` faz um laço em cima de cada elemento do array, internamente, e verifica se a referência que está sendo guardada é igual ao que foi passado, que no caso é `cc3`. Em caso positivo, ele imprime `true`. Pormenorizado, este `for` seria escrito da seguinte forma:

```
//Código omitido

for(Conta conta : lista) {
        if(conta == cc3) {
            System.out.println("Já tenho essa conta!");
        }
}

//Código omitidoCOPIAR CÓDIGO
```

Se verificarmos novamente com o `cc2`, veremos que o retorno será `true`, ou seja, verdadeiro, uma vez que esta referência está inserida na lista.

Nosso objetivo será indicar ao programa que, na verdade, apesar de se tratarem de referências diferentes, `cc2` e `cc3` apontam para um mesmo objeto.

Primeiro, faremos isso com o laço que criamos acima. Ao utilizarmos os dois símbolos de igualdade (`==`), internamente, o Java sempre compara as referências, por isso, quando propomos que `conta == cc3` esta afirmação nunca retornará `true`. Sendo assim, não podemos utilizar o (`==`).

Precisamos implementar algo que, de alguma forma, indique que uma conta é exatamente igual a outra. A condição para que isso seja verdade é que o número de agência e conta sejam idêntico.

Isso faz parte da regra de negócio, que deve estar inserida no pacote do modelo. Ela está relacionada com a classe `Conta`, logo, é nela que a adicionaremos.

Como a regra de igualdade é a mesma tanto para a `ContaCorrente` quanto para a `ContaPoupanca`, podemos inseri-la na classe mãe, `Conta`, dessa forma ela é válida para todas as filhas.

Abriremos a classe `TesteArrayListEquals`, para adicionarmos esta funcionalidade, que chamaremos de `ehIgual`:

```
//Código omitido

for(Conta conta : lista) {
        if(conta.ehIgual(cc3)) {
                System.out.println("Já tenho essa conta!");
        }
}

//Código omitidoCOPIAR CÓDIGO
```

Falta implementarmos a regra de `ehIgual`, na classe `Conta`. Será um método público, pois queremos acessá-lo fora do pacote. Um `if` necessita de uma expressão que resulte em um retorno do tipo `boolean`, assim sendo, ele será booleano. Este método receberá como parâmetro sempre uma variável do tipo `conta`:

```
//Código omitido

public abstract class Conta extends Object {

//

        public static int getTotal() {
                return Conta.total;
        }

        public boolean ehIgual(Conta outra) {

        }

        //Código omitido, método `toString()`
    }
}COPIAR CÓDIGO
```

Em seguida, implementaremos a regra de igualdade. Criaremos um `if` que verificará se os números de agência e conta são idênticos. Esta comparação se dará na negativa, ou seja, se forem diferentes, o programa imediatamente retornará uma negativa `false`:

```
//Código omitido

public abstract class Conta extends Object {

//

        public static int getTotal() {
                return Conta.total;
        }

        public boolean ehIgual(Conta outra) {

                if(this.agencia != outra.agencia) {
                    return false;
                }

        }

        //Código omitido, método `toString()`
    }
}COPIAR CÓDIGO
```

Assim, se a execução passa para a próxima fase, já temos certeza de que o número da agência é o mesmo. O segundo `if` servirá para a verificação do número da conta:

```
//Código omitido

public abstract class Conta extends Object {

//

        public static int getTotal() {
                return Conta.total;
        }

        public boolean ehIgual(Conta outra) {

                if(this.agencia != outra.agencia) {
                    return false;
                }

                if(this.numero != outra.numero) {
                    return false;
                }

        }

        //Código omitido, método `toString()`
    }
}COPIAR CÓDIGO
```

Da mesma forma, se os números de conta forem diferentes, teremos um retorno `false`. Portanto, tendo passado por estes dois estágios da execução e os números sendo compatíveis, chegamos à conclusão de que as contas são idênticas e, finalmente, teremos um retorno `true`:

```
//Código omitido

public abstract class Conta extends Object {

//

        public static int getTotal() {
                return Conta.total;
        }

        public boolean ehIgual(Conta outra) {

                if(this.agencia != outra.agencia) {
                    return false;
                }

                if(this.numero != outra.numero) {
                    return false;
                }

                return true;

        }

        //Código omitido, método `toString()`
    }
}COPIAR CÓDIGO
```

Retornaremos à classe `TesteArrayListEquals` e vemos que ela já está compilando, uma vez que o método `ehIgual` já foi implementado.

Para facilitar o entendimento, na classe `TesteArrayListEquals` comentaremos as seguintes linhas de código:

```
//Código omitido

        public static void main(String[] args) {

                //Generics
//                ArrayList<Conta> lista = new ArrayList<Conta>();
//
//                Conta cc = new ContaCorrente(22, 11);
//                lista.add(cc);
//
//                Conta cc2 = new ContaCorrente(22, 22);
//                lista.add(cc2);
//
//                Conta cc3 = new ContaCorrente(22, 22);
//                boolean existe = lista.contains(cc3);
//
//                System.out.println("Já existe? " + existe);
//
//                for(Conta conta : lista) {
//                    if(conta.ehIgual(cc3)) {
//                        System.out.println("Já tenho essa conta!");
//                    }
//                }
//
//                for(Conta conta : lista) {
//                    System.out.println(conta);
//                }
        }
//Código omitidoCOPIAR CÓDIGO
```

O próximo passo será criarmos duas contas, diferentes:

```
//Código omitido

        public static void main(String[] args) {

                Conta cc1 = new ContaCorrente(22, 11);
                Conta cc2 = new ContaCorrente(22, 22);

                //Generics
//                ArrayList<Conta> lista = new ArrayList<Conta>();
//
//                Conta cc = new ContaCorrente(22, 11);
//                lista.add(cc);
//
//                Conta cc2 = new ContaCorrente(22, 22);
//                lista.add(cc2);
//
//                Conta cc3 = new ContaCorrente(22, 22);
//                boolean existe = lista.contains(cc3);
//
//                System.out.println("Já existe? " + existe);
//
//                for(Conta conta : lista) {
//                    if(conta.ehIgual(cc3)) {
//                        System.out.println("Já tenho essa conta!");
//                    }
//                }
//
//                for(Conta conta : lista) {
//                    System.out.println(conta);
//                }
        }
//Código omitidoCOPIAR CÓDIGO
```

Testaremos nosso método `ehIgual`, sabendo que as contas são diferentes, ou seja, esperando receber um resultado `false`:

```
//Código omitido

        public static void main(String[] args) {

                Conta cc1 = new ContaCorrente(22, 11);
                Conta cc2 = new ContaCorrente(22, 22);

                boolean igual = cc1.ehIgual(cc2);
                System.out.println(igual);

                //Generics
//                ArrayList<Conta> lista = new ArrayList<Conta>();
//
//                Conta cc = new ContaCorrente(22, 11);
//                lista.add(cc);
//
//                Conta cc2 = new ContaCorrente(22, 22);
//                lista.add(cc2);
//
//                Conta cc3 = new ContaCorrente(22, 22);
//                boolean existe = lista.contains(cc3);
//
//                System.out.println("Já existe? " + existe);
//
//                for(Conta conta : lista) {
//                    if(conta.ehIgual(cc3)) {
//                        System.out.println("Já tenho essa conta!");
//                    }
//                }
//
//                for(Conta conta : lista) {
//                    System.out.println(conta);
//                }
        }
//Código omitidoCOPIAR CÓDIGO
```

Executaremos a classe, e temos o seguinte resultado no console:

```
falseCOPIAR CÓDIGO
```

Conforme esperado, o resultado foi `false`, indicando que nosso código funcionou.

Entretanto, criaremos a seguir dois objetos que representam na prática a mesma conta:

```
//Código omitido

        public static void main(String[] args) {

                Conta cc1 = new ContaCorrente(22, 22);
                Conta cc2 = new ContaCorrente(22, 22);

                boolean igual = cc1.ehIgual(cc2);
                System.out.println(igual);

                //Generics
//                ArrayList<Conta> lista = new ArrayList<Conta>();
//
//                Conta cc = new ContaCorrente(22, 11);
//                lista.add(cc);
//
//                Conta cc2 = new ContaCorrente(22, 22);
//                lista.add(cc2);
//
//                Conta cc3 = new ContaCorrente(22, 22);
//                boolean existe = lista.contains(cc3);
//
//                System.out.println("Já existe? " + existe);
//
//                for(Conta conta : lista) {
//                    if(conta.ehIgual(cc3)) {
//                        System.out.println("Já tenho essa conta!");
//                    }
//                }
//
//                for(Conta conta : lista) {
//                    System.out.println(conta);
//                }
        }
//Código omitidoCOPIAR CÓDIGO
```

Executando a classe, temos o seguinte resultado:

```
trueCOPIAR CÓDIGO
```

Nosso método está funcionando!

Em seguida, comentaremos estas linhas que acabamos de criar, e removeremos os comentários das que havíamos marcado anteriormente:

```
//Código omitido

        public static void main(String[] args) {

//                Conta cc1 = new ContaCorrente(22, 22);
//                Conta cc2 = new ContaCorrente(22, 22);
//
//                boolean igual = cc1.ehIgual(cc2);
//                System.out.println(igual);

                //Generics
                ArrayList<Conta> lista = new ArrayList<Conta>();

                Conta cc = new ContaCorrente(22, 11);
                lista.add(cc);

                Conta cc2 = new ContaCorrente(22, 22);
                lista.add(cc2);

                Conta cc3 = new ContaCorrente(22, 22);
                boolean existe = lista.contains(cc3);

                System.out.println("Já existe? " + existe);

                for(Conta conta : lista) {
                    if(conta.ehIgual(cc3)) {
                        System.out.println("Já tenho essa conta!");
                    }
                }

                for(Conta conta : lista) {
                    System.out.println(conta);
                }
        }
}COPIAR CÓDIGO
```

Editaremos o código para liberarmos mais espaço, eliminaremos o primeiro laço `for`:

```
//Código omitido

        public static void main(String[] args) {

//                Conta cc1 = new ContaCorrente(22, 22);
//                Conta cc2 = new ContaCorrente(22, 22);
//
//                boolean igual = cc1.ehIgual(cc2);
//                System.out.println(igual);

                //Generics
                ArrayList<Conta> lista = new ArrayList<Conta>();

                Conta cc = new ContaCorrente(22, 11);
                lista.add(cc);

                Conta cc2 = new ContaCorrente(22, 22);
                lista.add(cc2);

                Conta cc3 = new ContaCorrente(22, 22);
                boolean existe = lista.contains(cc3);

                System.out.println("Já existe? " + existe);

                for(Conta conta : lista) {
                    System.out.println(conta);
                }
        }
}COPIAR CÓDIGO
```

Nosso objetivo é que o `contains()` utilize, internamente, nosso método `ehIgual()`. Apesar de já fazer uso de um método, não é aquele que desejamos. O que o `contains()` utiliza por padrão chama-se `equals()`.

Assim, para atingirmos nosso objetivo, de que ele possa identificar quando há objetos iguais ainda que tenham referências distintas, teremos que alterar o método para que siga o padrão definido pela classe `Object`.

Para lembrarmos, retornaremos à classe `Object`. Nela, vemos que já existe o método que se chama `equals()`:

```
//Código omitido

public class Object {

        //Código omitido

        public boolean equals(Object obj) {
            return (this == obj);
        }

        //Código omitido

}
COPIAR CÓDIGO
```

Assim sendo, devemos sobrescrever este método. Isso nos permitirá definir nosso próprio critério de igualdade, que neste caso, trata-se de uma regra de negócio.

Por padrão, o método `equals()` faz algo que não queremos, que é comparar as referências `this` e `obj`. Por isso, retornaremos à classe `Conta`, onde chamaremos este método:

```
//Código omitido

public abstract class Conta extends Object {

//Código omitido

        public boolean equals(Conta outra) {

            if(this.agencia != outra.agencia) {
                return false;
            }

            if(this.numero != outra.numero) {
                return false;
            }

            return true;
        }

//Código omitido

}COPIAR CÓDIGO
```

Além disso, temos que garantir, por meio da anotação `@Override`. Ela indica ao compilador que determinado método deve, justamente, sobrescrever um outro definido na classe mãe:

```
//Código omitido

public abstract class Conta extends Object {

//Código omitido

        @Override
        public boolean equals(Conta outra) {

            if(this.agencia != outra.agencia) {
                return false;
            }

            if(this.numero != outra.numero) {
                return false;
            }

            return true;
        }

//Código omitido

}COPIAR CÓDIGO
```

Feito isso, percebemos que imediatamente o código passa a não compilar.

Para solucionarmos isso, retornaremos à classe `Object`:

```
//Código omitido

public class Object {

        //Código omitido

        public boolean equals(Object obj) {
            return (this == obj);
        }

        //Código omitido

}
COPIAR CÓDIGO
```

Notamos que o método recebe um `Object`, ou seja, um tipo genérico. Portanto, retornando à classe `Conta`, vemos que o método também deveria receber algo da mesma natureza, no caso, o próprio `Object` e uma referência `ref`:

```
//Código omitido

public abstract class Conta extends Object {

//Código omitido

        @Override
        public boolean equals(Object ref) {

            if(this.agencia != outra.agencia) {
                return false;
            }

            if(this.numero != outra.numero) {
                return false;
            }

            return true;
        }

//Código omitido

}COPIAR CÓDIGO
```

Com isso, não temos mais um erro de compilação nesta linha, mas temos nas demais. Isso porque este tipo `ref` não possui atributos que se chamam `agencia` ou `numero`. Assim, transformaremos a referência genérica em uma específica, como sabemos, utilizamos o **cast**:

```
//Código omitido

public abstract class Conta extends Object {

//Código omitido

        @Override
        public boolean equals(Object ref) {

            Conta outra = (Conta) ref;

            if(this.agencia != outra.agencia) {
                return false;
            }

            if(this.numero != outra.numero) {
                return false;
            }

            return true;
        }

//Código omitido

}COPIAR CÓDIGO
```

Pronto, o código voltou a compilar, e estamos sobrescrevendo o método `equals()`, da classe `Object`.

Retornaremos à classe `TesteArrayListEquals`. Agora sabemos que o método `contains()` faz um laço internamente, e chama o método `equals()`. Entretanto ele, por padrão da classe `Object`, compara as referências. Como agora o sobrescrevemos, ele passará a funcionar conforme nossa regra de igualdade. Executando novamente a classe, temos o seguinte resultado no console:

```
Já existe? true
ContaCorrente, Numero: 11, Agencia: 22
ContaCorrente, Numero: 22, Agencia: 22COPIAR CÓDIGO
```

Onde antes o resultado era `false`, agora o retorno é `true`. O `contains()` agora é capaz de detectar que adicionamos um objeto com os mesmos valores, que indicam a igualdade entre eles.

Assim, observamos que a classe `ArrayList`, internamente, se baseia na implementação da nossa classe `Conta`. Ela faz isso graças à sobrescrita da classe `Object`.

Vamos para os exercícios, e até a próxima!