# Aula 01 - Adapter para arrays

> Você pode fazer o DOWNLOAD do projeto da aula anterior.
> 

Olá!

Anteriormente, aprendemos a lidar com arrays, agora, entendemos tudo que está escrito na classe ao chamar o método `main`, inclusive o `String[]`:

```
//Código omitido, pacote e import

public class TestArrayReferencias {

        public static void main(String[] args) {

        //Código omitidoCOPIAR CÓDIGO
```

Passaremos agora a trabalhar com a sintaxe utilizada para criar um objeto comum. Até o momento, utilizamos a seguinte:

```
//Código omitido, pacote e import

public class TestArrayReferencias {

        public static void main(String[] args ) {

        //int[] iaddes = new int[5];
        Object[] referencias = new Object[5];

        ContaCorrente cc1 = new ContaCorrente(22, 11);
        referencias[0] = cc1;

        //Código omitidoCOPIAR CÓDIGO
```

Temos no lado esquerdo, a referência e o tipo, e no lado direito o `new`, que chama o construtor, com seus parâmetros, caso haja - este é o padrão para qualquer padrão que queiramos criar, exceto pelo array, que possui uma sintaxe própria.

No array, utilizamos os colchetes (`[]`), e no lado direito utilizamos o `new` e chamamos algo análogo a um construtor mas que, dentro de colchetes (`[]`), recebe o tamanho do referido array.

Outro ponto que aprendemos é que, para descobrirmos o tamanho de um array, utilizamos o `referencias.length`, que é um atributo público. Estes são geralmente considerados como uma má prática.

Além disso, normalmente, não queremos saber quantas referências um array pode guardar. No nosso exemplo, são 5, mas o importante é sabermos quantas referências um array de fato já guardou, neste caso, seriam 2, representadas por `cc1` e `cc2`.

E se criarmos um array com 5 posições, para guardar 5 referências, mas no decorrer do projeto percebermos a necessidade de guardar mais 5. O array não é dinâmico, ou seja, uma vez criado com um determinado número de posições, ele só terá aquele número. Assim, precisamos descobrir uma forma de trabalharmos com esta ferramenta mais elegantemente.

Inicialmente, criaremos um classe que esconde o acesso ao array, utilizando-o internamente, e as demais classes a utilizarão.

A nova classe se chamará `GuardadorDeContas`:

```
package br.com.bytebank.banco.modelo;

public class GuardadorDeContas {

}COPIAR CÓDIGO
```

Internamente, teremos um array de contas, e um construtor para o inicializarmos:

```
package br.com.bytebank.banco.modelo;

public class GuardadorDeContas {

        private Conta[] referencias;

        public GuardadorDeContas() {
                this.referencias = new Conta[10];
        }

}COPIAR CÓDIGO
```

No pacote `br.com.bytebank.banco.test` criaremos um novo teste, chamado `Teste`:

```
package br.com.bytebank.banco.test;

public class Teste {

        public static void main(String[] args) {
                //TODO Auto-generated method stub
        }
}COPIAR CÓDIGO
```

Utilizaremos o `GuardadorDeContas`, com a sintaxe padrão:

```
package br.com.bytebank.banco.test;

public class Teste {

        public static void main(String[] args) {

                GuardadorDeContas guardador = new GuardadorDeContas();

        }
}COPIAR CÓDIGO
```

Em seguida, utilizaremos o `guardador` para adicionarmos uma `conta`, ou seja, para passarmos uma referência. Para isso, criaremos também um objeto `Conta()`:

```
package br.com.bytebank.banco.test;

public class Teste {

        public static void main(String[] args) {

                GuardadorDeContas guardador = new GuardadorDeContas();

                Conta cc = new ContaCorrente(22, 11);

                guardador.adiciona(cc);

        }
}COPIAR CÓDIGO
```

A cada vez que quisermos guardar uma referência, chamaremos o método `adiciona`, não será necessário sabermos a posição do array, como anteriormente.

Na classe `GuardadorDeContas()` criaremos este método `adiciona`:

```
package br.com.bytebank.banco.modelo;

public class GuardadorDeContas {

        private Conta[] referencias;

        public GuardadorDeContas() {
            this.referencias = new Conta[10];
        }

        public void adiciona();

}COPIAR CÓDIGO
```

Este método deve receber uma referência do tipo `Conta`:

```
package br.com.bytebank.banco.modelo;

public class GuardadorDeContas {

        private Conta[] referencias;

        public GuardadorDeContas() {
            this.referencias = new Conta[10];
        }

        public void adiciona(Conta ref) {

        }

}COPIAR CÓDIGO
```

Assim, deve ser possível armazenarmos a referência na primeira posição disponível em nosso array. É o que inseriremos no corpo do método:

```
package br.com.bytebank.banco.modelo;

public class GuardadorDeContas {

        private Conta[] referencias;

        public GuardadorDeContas() {
            this.referencias = new Conta[10];
        }

        public void adiciona(Conta ref) {
            this.referencias[0] = ref;
        }

}COPIAR CÓDIGO
```

Isso funciona quando estamos trabalhando com uma conta, mas e se criássemos mais uma na classe `Teste`?

```
package br.com.bytebank.banco.test;

public class Teste {

        public static void main(String[] args) {

                GuardadorDeContas guardador = new GuardadorDeContas();

                Conta cc = new ContaCorrente(22, 11);
                guardador.adiciona(cc);

                Conta cc2 = new ContaCorrente(22, 22);
                guardador.adiciona(cc2);

        }
}COPIAR CÓDIGO
```

O que aconteceria se tentássemos armazená-la na próxima posição livre?

No `GuardadorDeContas` a posição `0` está fixa. isso não funcionará.

Precisaremos de uma variável auxiliar, que sempre lembrará da última posição utilizada, ela se chamará `posicaoLivre`:

```
package br.com.bytebank.banco.modelo;

public class GuardadorDeContas {

        private Conta[] referencias;
        private int posicaoLivre;

        public GuardadorDeContas() {
            this.referencias = new Conta[10];
        }

        public void adiciona(Conta ref) {
            this.referencias[0] = ref;
        }

}COPIAR CÓDIGO
```

Inicializaremos a variável `posicaoLivre` dentro do método `GuardadorDeContas()`, com o valor `0`:

```
package br.com.bytebank.banco.modelo;

public class GuardadorDeContas {

        private Conta[] referencias;
        private int posicaoLivre;

        public GuardadorDeContas() {
            this.referencias = new Conta[10];
            this.posicaoLivre = 0;
        }

        public void adiciona(Conta ref) {
            this.referencias[0] = ref;
        }

}COPIAR CÓDIGO
```

> A inicialização não é obrigatória, já que por padrão, todos os atributos do tipo int são inicializados com o valor 0.
> 

No método `adiciona()`, em vez de utilizarmos o `0`, agora teremos o `this.posicaoLivre`. Além disso, para que não tenhamos a posição fixa, incrementaremos esta variável:

```
package br.com.bytebank.banco.modelo;

public class GuardadorDeContas {

        private Conta[] referencias;
        private int posicaoLivre;

        public GuardadorDeContas() {
            this.referencias = new Conta[10];
            this.posicaoLivre = 0;
        }

        public void adiciona(Conta ref) {
            this.referencias[this.posicaoLivre] = ref;
            this.posicaoLivre++;
        }

}COPIAR CÓDIGO
```

Para testarmos se tudo está funcionando, teremos na classe `Teste` uma variável `tamanho` que receberá um método `guardador.getQuantidadeDeElementos()`, para sabermos o número de itens inicializados:

```
//Código omitido

public class Teste {

        public static void main(String[] args) {

                GuardadorDeContas guardador = new GuardadorDeContas();

                Conta cc = new ContaCorrente(22, 11);
                guardador.adiciona(cc);

                Conta cc2 = new ContaCorrente(22, 22);
                guardador.adiciona(cc2);

                int tamanho = guardador.getQuantidadeDeElementos();

        }
}COPIAR CÓDIGO
```

Como criamos duas contas, o resultado correto deve ser 2. Criaremos uma impressão do resultado:

```
//Código omitido

public class Teste {

        public static void main(String[] args) {

                GuardadorDeContas guardador = new GuardadorDeContas();

                Conta cc = new ContaCorrente(22, 11);
                guardador.adiciona(cc);

                Conta cc2 = new ContaCorrente(22, 22);
                guardador.adiciona(cc2);

                int tamanho = guardador.getQuantidadeDeElementos();
                System.out.println(tamanho);
        }
}COPIAR CÓDIGO
```

Nos resta agora criar de fato este método `getQuantidadeDeElementos()`.

No Eclipse, ao repousarmos o cursor sobre o nome do nosso método, ele nos oferece uma opção "*Create method `getQuantidadeDeElementos` in type `GuardadorDeContas`*", clicaremos nela.

Na classe `GuardadorDeContas` temos o seguinte resultado:

```
//Código omitido

public class GuardadorDeContas {

        private Conta[] referencias;
        private int posicaoLivre;

        public GuardadorDeContas() {
            this.referencias = new Conta[10];
            this.posicaoLivre = 0;
        }

        public void adiciona(Conta ref) {
            this.referencias[this.posicaoLivre] = ref;
            this.posicaoLivre++;
        }

        public int getQuantidadeDeElementos() {
            //TODO Auto-generated methos stub
        return 0;
        }

}COPIAR CÓDIGO
```

Ou seja, o método foi adicionado automaticamente na classe adequada, entretanto, sem a implementação. É o que faremos a seguir:

```
//Código omitido

public class GuardadorDeContas {

        private Conta[] referencias;
        private int posicaoLivre;

        public GuardadorDeContas() {
            this.referencias = new Conta[10];
            this.posicaoLivre = 0;
        }

        public void adiciona(Conta ref) {
            this.referencias[this.posicaoLivre] = ref;
            this.posicaoLivre++;
        }

        public int getQuantidadeDeElementos() {
            return this.posicaoLivre;
        }

}COPIAR CÓDIGO
```

Isso nos dará o número de elementos inicializados já que, a cada elemento adicionado, esta variável é incrementada.

Retornaremos à classe `Teste` e executaremos nosso código. Temos o seguinte resultado no console:

```
2COPIAR CÓDIGO
```

Já sabemos como obter a quantidade de elementos, queremos então que o programa nos devolva um elemento em si. Faremos com que seja possível receber a referência de uma conta.

Na classe `Teste`, criaremos uma `ref` do tipo `Conta` que receberá um método `guardador.getReferencia()`. O parâmetro será uma posição, e toda posição é um número inteiro, portanto, ela será inicializada em `0`:

```
//Código omitido

public class Teste {

        public static void main(String[] args) {

                GuardadorDeContas guardador = new GuardadorDeContas();

                Conta cc = new ContaCorrente(22, 11);
                guardador.adiciona(cc);

                Conta cc2 = new ContaCorrente(22, 22);
                guardador.adiciona(cc2);

                int tamanho = guardador.getQuantidadeDeElementos();
                System.out.println(tamanho);

                Conta ref = guardador.getReferencia(0);
        }
}COPIAR CÓDIGO
```

Utilizaremos o mesmo atalho apliacado anteriormente, para criarmos o método `getReferencia` na classe `GuardadorDeContas`. Como implementação, retornaremos o array `referencia` na posição `pos`, e assim acessaremos o valor lá contido:

```
//Código omitido

public class GuardadorDeContas {

        private Conta[] referencias;
        private int posicaoLivre;

        public GuardadorDeContas() {
            this.referencias = new Conta[10];
            this.posicaoLivre = 0;
        }

        public void adiciona(Conta ref) {
            this.referencias[this.posicaoLivre] = ref;
            this.posicaoLivre++;
        }

        public int getQuantidadeDeElementos() {
            return this.posicaoLivre;
        }

        public Conta getReferencia(int pos) {
            return this.referencias[pos];
        }

}COPIAR CÓDIGO
```

Retornando à classe `Teste`, vemos que o código inteiro está compilando, sem que tenhamos utilizado a sintaxe específica dos arrays:

```
//Código omitido

public class Teste {

        public static void main(String[] args) {

                GuardadorDeContas guardador = new GuardadorDeContas();

                Conta cc = new ContaCorrente(22, 11);
                guardador.adiciona(cc);

                Conta cc2 = new ContaCorrente(22, 22);
                guardador.adiciona(cc2);

                int tamanho = guardador.getQuantidadeDeElementos();
                System.out.println(tamanho);

                Conta ref = guardador.getReferencia(0);
        }
}COPIAR CÓDIGO
```

Para testarmos, imprimiremos a referência:

```
//Código omitido

public class Teste {

        public static void main(String[] args) {

                GuardadorDeContas guardador = new GuardadorDeContas();

                Conta cc = new ContaCorrente(22, 11);
                guardador.adiciona(cc);

                Conta cc2 = new ContaCorrente(22, 22);
                guardador.adiciona(cc2);

                int tamanho = guardador.getQuantidadeDeElementos();
                System.out.println(tamanho);

                Conta ref = guardador.getReferencia(0);
                System.out.println(ref.getNumero());
        }
}COPIAR CÓDIGO
```

Ele deveria nos devolver `11`. Executaremos e obtemos o seguinte resultado:

```
2
11COPIAR CÓDIGO
```

Podemos repetir o teste com outra conta, e ele funcionará igualmente. Adiante, veremos como criar um guardador capaz de armazenar qualquer tipo de referência, utilizando a classe `Object`.