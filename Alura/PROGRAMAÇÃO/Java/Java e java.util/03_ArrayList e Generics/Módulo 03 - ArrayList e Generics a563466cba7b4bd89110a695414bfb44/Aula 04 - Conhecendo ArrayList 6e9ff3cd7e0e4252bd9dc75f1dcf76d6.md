# Aula 04 - Conhecendo ArrayList

Dando continuidade às aulas anteriores, veremos como podemos transformar o `GuardadorDeContas` em um guardador de referências genéricas, ou seja, em vez de guardarmos somente tipo `Conta`, armazenaremos qualquer tipo de `Object`.

Para exemplificar, já temos criada a classe `GuardadorDeReferencias`:

```
package br.com.bytebank.banco.modelo;

public class GuardadorDeReferencias {

        private Object[] referencias;
        private int posicaoLivre;

        public GuardadorDeReferencias() {
            this.referencias = new Object[10];
            this.posicaoLivre = 0;
        }

        public void adiciona(Object ref) {
            this.referencias[this.posicaoLivre] = ref;
            this.posicaoLivre++;
        }

        public int getQuantidadeDeElementos() {
            return this.posicaoLivre;
        }

        public Object getReferencia(int pos) {
            return this.referencias[pos];        }
}COPIAR CÓDIGO
```

Além disso, com relação à classe `GuardadorDeContas`, ela foi refatorada para alterarmos o nome, que passou a ser `GuardadorDeReferencias`.

A única diferença entre as duas é que, onde tínhamos `GuardadorDeContas` em uma, teremos na outra `GuardadorDeReferencias`, e onde havia `Conta` em uma, na outra teremos `Object`. Desta forma, a classe passou a ser capaz de armazenar referências genéricas.

Criamos também uma classe `TesteGuardadorReferencias`:

```
package br.com.bytebank.banco.test;

import br.com.bytebank.banco.modelo.Conta;

public class TesteGuardadorReferencias {

        public static void main(String[] args) {

            GuardadorDeReferencias guardador = new GuardadorDeReferencias();

            Conta cc = new ContaCorrente(22, 11);
            guardador.adiciona(cc);

            Conta cc2 = new ContaCorrente(22, 22);
            guardador.adiciona(cc2);

            int tamanho = guardador.getQuantidadeDeElementos();
            System.out.println(tamanho);

            Conta ref = (Conta) guardador.getReferencia(1);
            System.out.println(ref.getNumero());

}COPIAR CÓDIGO
```

Ela é praticamente idêntica à criada para o `GuardadorDeContas`, inclusive, estamos trabalhando com contas, uma vez que o `GuardadorDeReferencias` é genérico e, portanto, também consegue guardá-las.

O objeto `GuardadorDeReferencias` foi instanciado e, além disso, foi feito um cast do tipo `Conta` para que pudéssemos ter este retorno. Isso porque exigimos uma referência mais específica.

Nosso problema agora é a falta de dinamicidade do array, no momento estamos guardando 10 referências, mas e se quisermos guardar mais? Ao adicionarmos mais elementos deveríamos verificar a capacidade de armazenamento, criar um array maior, e copiar os elementos do antigo para este novo.

E se quisermos remover referências? Teríamos que criar um método específico. Poderíamos ter também um método que nos permitisse adicionar diversas referências de uma só vez.

Há diversas possibilidades. Mas será que outras pessoas já não pensaram nelas antes? Sim.

Certamente, existem classes que utilizam arrays mas possuem recursos de mais alto nível para não trabalharem com colchetes (`[]`), e outras especificidades dos arrays.

Com isso, podemos fechar os demais pacotes e entraremos no tópico do `java.util`.

Trata-se de um pacote específico, que você deve estudar isoladamente. Quanto maior o domínio sobre ele, mais útil será no dia-a-dia.

Para criarmos um novo pacote, podemos clicar com o botão direito sobre a pasta `src` no Eclipse e selecionaremos a opção "New > Package". Entretanto, dificilmente isso é feito na prática.

Há outra forma, mais utilizada - por ser mais fácil -, que nos permite criar não só um pacote, como também uma classe.

Criaremos uma nova classe no pacote `br.com.bytebank-banco.test`, e na tela de criação podemos alterar o pacote, na opção "Package", podemos digitar `br.com.bytebank-banco.test.util`. Assim temos o novo pacote.

A classe se chamará `Teste`, e terá um método `main()` padrão:

```
package br.com.bytebank.banco.test.util;

public class Teste {

        public static void main(String[] args) {

        }
}COPIAR CÓDIGO
```

Nosso `GuardadorDeReferencias` funciona mas, como sabemos, há uma classe mais sofisticada que existe para este mesmo propósito, ela se chama `ArrayList`. Aprenderemos aqui a primeira estrutura de dados.

Precisamos importá-la do pacote `java.util`, para isso, pousaremos o curso sobre o seu nome, e clicaremos na opção sugerida pelo Eclipse "Import `ArrayList` (java.util)". Temos o seguinte resultado:

```
package br.com.bytebank.banco.test.util;

public class Teste {

        public static void main(String[] args) {

                ArrayList lista;

        }
}COPIAR CÓDIGO
```

Criaremos um novo objeto nesta classe, utilizando o `new` e o construtor `ArrayList()`. O Eclipse deixa o código sublinhado em amarelo e, por enquanto, não nos preocuparemos com isso:

```
package br.com.bytebank.banco.test.util;

public class Teste {

        public static void main(String[] args) {

                ArrayList lista = new ArrayList();

        }
}COPIAR CÓDIGO
```

O `ArrayList()` será nosso guardador de referências, ao ser executado, internamente, ele utiliza um array com um número pré-determinado de posições, que gira em torno de 1000.

No `ArrayList` incluiremos as mesmas duas contas que havíamos criado anteriormente. A diferença é que agora guardamos em `lista` e o método tem o nome em inglês, `add`:

```
package br.com.bytebank.banco.test.util;

public class Teste {

        public static void main(String[] args) {

                ArrayList lista = new ArrayList();

                Conta cc = new ContaCorrente(22, 11);
                lista.add(cc);

                Conta cc2 = new ContaCorrente(22, 22);
                lista.add(cc2);

        }
}COPIAR CÓDIGO
```

A seguir, queremos saber do `ArrayList` quantas referências foram armazenadas até o momento. Para isso, imprimiremos o método `lista.size()`, para obtermos justamente o seu tamanho:

```
package br.com.bytebank.banco.test.util;

public class Teste {

        public static void main(String[] args) {

                ArrayList lista = new ArrayList();

                Conta cc = new ContaCorrente(22, 11);
                lista.add(cc);

                Conta cc2 = new ContaCorrente(22, 22);
                lista.add(cc2);

                System.out.println(lista.size());

        }
}COPIAR CÓDIGO
```

Executaremos a classe `Teste`, e temos o seguinte resultado:

```
2COPIAR CÓDIGO
```

O que significa que funcionou.

Podemos também criar um método para que seja exibido um dos elementos do array. Para isso, temos o `get(index)`, onde podemos passar a posição desejada entre parênteses (`()`).

Nosso retorno será do tipo `Object`, já que temos um array de referências genéricas. Assim, temos:

```
package br.com.bytebank.banco.test.util;

public class Teste {

        public static void main(String[] args) {

                ArrayList lista = new ArrayList();

                Conta cc = new ContaCorrente(22, 11);
                lista.add(cc);

                Conta cc2 = new ContaCorrente(22, 22);
                lista.add(cc2);

                System.out.println(lista.size());

                Object ref = lista.get(0);

        }
}COPIAR CÓDIGO
```

Como sabemos que, neste caso, o elemento é uma conta, podemos transformar o tipo mais genérico em específico, fazendo um *type cast* para `Conta`:

```
package br.com.bytebank.banco.test.util;

public class Teste {

        public static void main(String[] args) {

                ArrayList lista = new ArrayList();

                Conta cc = new ContaCorrente(22, 11);
                lista.add(cc);

                Conta cc2 = new ContaCorrente(22, 22);
                lista.add(cc2);

                System.out.println(lista.size());

                Conta ref = (Conta) lista.get(0);

        }
}COPIAR CÓDIGO
```

Para visualizarmos se o método funcionou, imprimiremos o número da conta, utilizando o método `getNumero()`:

```
package br.com.bytebank.banco.test.util;

public class Teste {

        public static void main(String[] args) {

                ArrayList lista = new ArrayList();

                Conta cc = new ContaCorrente(22, 11);
                lista.add(cc);

                Conta cc2 = new ContaCorrente(22, 22);
                lista.add(cc2);

                System.out.println(lista.size());

                Conta ref = (Conta) lista.get(0);

                System.out.println(ref.getNumero());

        }
}COPIAR CÓDIGO
```

Executando a classe, temos o seguinte resultado no console:

```
2
11COPIAR CÓDIGO
```

Há muitos outros métodos disponíveis, é possível, por exemplo, remover elementos do array. Para isso, utilizamos o método `remove()`.

Testaremos remover o elemento armazenado no índice `0`, e imprimiremos mais uma vez o tamanho da lista para nos certificarmos de que funcionou:

```
package br.com.bytebank.banco.test.util;

public class Teste {

        public static void main(String[] args) {

                ArrayList lista = new ArrayList();

                Conta cc = new ContaCorrente(22, 11);
                lista.add(cc);

                Conta cc2 = new ContaCorrente(22, 22);
                lista.add(cc2);

                System.out.println("Tamanho: " + lista.size());
                Conta ref = (Conta) lista.get(0);
                System.out.println(ref.getNumero());

                lista.remove(0);

                System.out.println("Tamanho: " + lista.size());

        }
}COPIAR CÓDIGO
```

Executaremos e temos o seguinte resultado:

```
Tamanho: 2
11
Tamanho: 1COPIAR CÓDIGO
```

O código funcionou. Adicionaremos mais contas:

```
package br.com.bytebank.banco.test.util;

public class Teste {

        public static void main(String[] args) {

                ArrayList lista = new ArrayList();

                Conta cc = new ContaCorrente(22, 11);
                lista.add(cc);

                Conta cc2 = new ContaCorrente(22, 22);
                lista.add(cc2);

                System.out.println(lista.size());
                Conta ref = (Conta) lista.get(0);
                System.out.println(ref.getNumero());

                lista.remove(0);

                System.out.println("Tamanho: " + lista.size());

                Conta cc3 = new ContaCorrente(33, 311);
                lista.add(cc3);

                Conta cc4 = new ContaCorrente(33, 322);
                lista.add(cc4);

        }
}COPIAR CÓDIGO
```

Assim, em ordem, nós adicionamos dois elementos, removemos um, e adicionamos mais dois. Temos um total de três elementos remanescentes.

Queremos agora acessar cada um destes elementos, dentro de um laço, ou seja, fazer a **iteração** deles. Para isso, utilizamos o `for`:

```
package br.com.bytebank.banco.test.util;

public class Teste {

        public static void main(String[] args) {

                ArrayList lista = new ArrayList();

                Conta cc = new ContaCorrente(22, 11);
                lista.add(cc);

                Conta cc2 = new ContaCorrente(22, 22);
                lista.add(cc2);

                System.out.println(lista.size());
                Conta ref = (Conta) lista.get(0);
                System.out.println(ref.getNumero());

                lista.remove(0);

                System.out.println("Tamanho: " + lista.size());

                Conta cc3 = new ContaCorrente(33, 311);
                lista.add(cc3);

                Conta cc4 = new ContaCorrente(33, 322);
                lista.add(cc4);

                for(int i = 0; i < lista.size(); i++) {

                }

        }
}COPIAR CÓDIGO
```

Dentro do laço, ele nos retornará uma referência do tipo `Object`, e é ela que imprimiremos:

```
package br.com.bytebank.banco.test.util;

public class Teste {

        public static void main(String[] args) {

                ArrayList lista = new ArrayList();

                Conta cc = new ContaCorrente(22, 11);
                lista.add(cc);

                Conta cc2 = new ContaCorrente(22, 22);
                lista.add(cc2);

                System.out.println(lista.size());
                Conta ref = (Conta) lista.get(0);
                System.out.println(ref.getNumero());

                lista.remove(0);

                System.out.println("Tamanho: " + lista.size());

                Conta cc3 = new ContaCorrente(33, 311);
                lista.add(cc3);

                Conta cc4 = new ContaCorrente(33, 322);
                lista.add(cc4);

                for(int i = 0; i < lista.size(); i++) {
                    Object oRef = lista.get(i);
                    System.out.println(oRef);
                }

        }
}COPIAR CÓDIGO
```

Lembrando que, internamente, o nosso `System.out.println()` utiliza o `toString()` da classe `ContaCorrente`.

Executando a classe, temos o seguinte resultado:

```
11
Tamanho:1
ContaCorrente, Numero: 22, Agencia: 22
ContaCorrente, Numero: 311, Agencia: 33
ContaCorrente, Numero: 322, Agencia: 33COPIAR CÓDIGO
```

Nosso código funcionou.

Entretanto, atualmente há uma forma ainda mais simples de fazermos este laço.

Temos também um `for`, que a cada iteração nos retornará um `Object`:

```
package br.com.bytebank.banco.test.util;

public class Teste {

        public static void main(String[] args) {

                ArrayList lista = new ArrayList();

                Conta cc = new ContaCorrente(22, 11);
                lista.add(cc);

                Conta cc2 = new ContaCorrente(22, 22);
                lista.add(cc2);

                System.out.println(lista.size());
                Conta ref = (Conta) lista.get(0);
                System.out.println(ref.getNumero());

                lista.remove(0);

                System.out.println("Tamanho: " + lista.size());

                Conta cc3 = new ContaCorrente(33, 311);
                lista.add(cc3);

                Conta cc4 = new ContaCorrente(33, 322);
                lista.add(cc4);

                for(int i = 0; i < lista.size(); i++) {
                    Object oRef = lista.get(i);
                    System.out.println(oRef);
                }

                for(Object o : lista)

        }
}COPIAR CÓDIGO
```

Para cada elemento do tipo `Object` desta lista, queremos que seja impresso o seu valor:

```
package br.com.bytebank.banco.test.util;

public class Teste {

        public static void main(String[] args) {

                ArrayList lista = new ArrayList();

                Conta cc = new ContaCorrente(22, 11);
                lista.add(cc);

                Conta cc2 = new ContaCorrente(22, 22);
                lista.add(cc2);

                System.out.println(lista.size());
                Conta ref = (Conta) lista.get(0);
                System.out.println(ref.getNumero());

                lista.remove(0);

                System.out.println("Tamanho: " + lista.size());

                Conta cc3 = new ContaCorrente(33, 311);
                lista.add(cc3);

                Conta cc4 = new ContaCorrente(33, 322);
                lista.add(cc4);

                for(int i = 0; i < lista.size(); i++) {
                    Object oRef = lista.get(i);
                    System.out.println(oRef);
                }

                for(Object o : lista) {
                    System.out.println(o);
                }

        }
}COPIAR CÓDIGO
```

Deveríamos ter a mesma saída para os dois métodos `for`. Para diferenciá-los, criaremos uma divisão entre eles:

```
package br.com.bytebank.banco.test.util;

public class Teste {

        public static void main(String[] args) {

                ArrayList lista = new ArrayList();

                Conta cc = new ContaCorrente(22, 11);
                lista.add(cc);

                Conta cc2 = new ContaCorrente(22, 22);
                lista.add(cc2);

                System.out.println(lista.size());
                Conta ref = (Conta) lista.get(0);
                System.out.println(ref.getNumero());

                lista.remove(0);

                System.out.println("Tamanho: " + lista.size());

                Conta cc3 = new ContaCorrente(33, 311);
                lista.add(cc3);

                Conta cc4 = new ContaCorrente(33, 322);
                lista.add(cc4);

                for(int i = 0; i < lista.size(); i++) {
                    Object oRef = lista.get(i);
                    System.out.println(oRef);
                }

                System.out.println("-------");

                for(Object o : lista) {
                    System.out.println(o);
                }

        }
}COPIAR CÓDIGO
```

Executaremos e temos o seguinte resultado:

```
11
Tamanho:1
ContaCorrente, Numero: 22, Agencia: 22
ContaCorrente, Numero: 311, Agencia: 33
ContaCorrente, Numero: 322, Agencia: 33
-------
ContaCorrente, Numero: 22, Agencia: 22
ContaCorrente, Numero: 311, Agencia: 33
ContaCorrente, Numero: 322, Agencia: 33COPIAR CÓDIGO
```

Funcionou.

Atualmente, é comum utilizarmos a segunda modalidade do `for`.