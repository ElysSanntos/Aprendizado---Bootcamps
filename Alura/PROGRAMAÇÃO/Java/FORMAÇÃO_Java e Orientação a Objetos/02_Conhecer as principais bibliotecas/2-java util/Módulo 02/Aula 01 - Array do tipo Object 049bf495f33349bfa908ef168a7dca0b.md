# Aula 01 - Array do tipo Object

> Você pode fazer o [DOWNLOAD](https://caelum-online-public.s3.amazonaws.com/850-java-util/02/java6-cap2.zip) do projeto da aula anterior.
> 

Nesta aula, continuaremos a falar do `java.lang`, com foco na classe `Object`.

Na nossa classe `TestArrayReferencias` criamos um array com cinco contas correntes. Se quiséssemos guardar contas poupanças, poderíamos então criar um novo array para estas. Mas e se quiséssemos guardar contas dos dois tipos? Qual deveria ser o tipo do array nesse caso?

A primeira resposta seria `Conta[]`, que seria mais genérico, assim teríamos o seguinte código:

```
//Código omitido

public class TestArrayReferencias {

        public static void main(String[] args) {

        //int[] idades = new int[5];
        Conta[] contas = new Conta[5];

        //Código omitidoCOPIAR CÓDIGO
```

O compilador aponta um erro porque ainda precisamos importar `Conta`, é o que faremos:

```
package br.com.bytebank.banco.test;

import br.com.bytebank.banco.modelo.Conta;
import br.com.bytebank.banco.modelo.ContaCorrente;

public class TestArrayReferencias {

        public static void main(String[] args) {

        //int[] idades = new int[5];
        Conta[] contas = new Conta[5];

        //Código omitidoCOPIAR CÓDIGO
```

Assim, poderíamos apontar tanto para uma `ContaCorrente`, quanto para uma `ContaPoupanca`. Isso não influencia no restante do código, que continua compilando:

```
package br.com.bytebank.banco.test;

import br.com.bytebank.banco.modelo.Conta;
import br.com.bytebank.banco.modelo.ContaCorrente;

public class TestArrayReferencias {

        public static void main(String[] args) {

        //int[] idades = new int[5];
        Conta[] contas = new Conta[5];

        ContaCorrente cc1 = new ContaCorrente(22, 11);
        contas[0] = cc1;

        ContaCorrente cc2 = new ContaCorrente(22, 22);
        contas[1] = cc2;

        //System.out.println(cc2.getNumero());

        System.out.println( contas[1].getNumero() );

        }

}COPIAR CÓDIGO
```

Em seguida, tentaremos criar um objeto do tipo `ContaPoupanca()`:

```
package br.com.bytebank.banco.test;

import br.com.bytebank.banco.modelo.Conta;
import br.com.bytebank.banco.modelo.ContaCorrente;

public class TestArrayReferencias {

        public static void main(String[] args) {

        //int[] idades = new int[5];
        Conta[] contas = new Conta[5];

        ContaCorrente cc1 = new ContaCorrente(22, 11);
        contas[0] = cc1;

        ContaPoupanca cc2 = new ContaPoupanca(22, 22);
        contas[1] = cc2;

        //System.out.println(cc2.getNumero());

        System.out.println( contas[1].getNumero() );

        ContaCorrente ref = contas[1];
        System.out.println(cc2.getNumero());
        System.out.println(ref.getNumero());

        }

}COPIAR CÓDIGO
```

Isso também funciona, porque nosso array é do tipo mais genérico, `Conta[]`.

Entretanto, em `ContaCorrente ref = contas[1]` o compilador aponta um erro. Por que? Quais são os tipos de referências que o nosso array é capaz de armazenar? Temos que observar a linha `Conta[] contas = new Conta[5]`, a partir da qual concluímos que nosso array é capaz de armazenar referências do tipo `Conta`.

Do jeito como está em nosso código:

```
//Código omitido

ContaCorrente ref = contas[1];

//Código omitidoCOPIAR CÓDIGO
```

A posição `1` guarda uma referência do tipo `ContaCorrente`. Entretanto, a nossa referência aponta para um objeto do tipo `ContaPoupanca`. É possível referenciar um objeto do tipo `ContaPoupanca` por meio de um do tipo `ContaCorrente`? Não, isto não é possível.

Por isso o compilador reclama, em `contas`:

```
//Código omitido

        ContaCorrente ref = contas[1];

//Código omitidoCOPIAR CÓDIGO
```

O computador sabe que a referência `contas`, no array, é do tipo `Conta[]`, por esse motivo, não podemos armazená-la em um tipo `ContaCorrente`.

Para que o código possa compilar, precisamos alterar, de `ContaCorrente`, para `Conta`:

```
package br.com.bytebank.banco.test;

import br.com.bytebank.banco.modelo.Conta;
import br.com.bytebank.banco.modelo.ContaCorrente;

public class TestArrayReferencias {

        public static void main(String[] args) {

        //int[] idades = new int[5];
        Conta[] contas = new Conta[5];

        ContaCorrente cc1 = new ContaCorrente(22, 11);
        contas[0] = cc1;

        ContaPoupanca cc2 = new ContaPoupanca(22, 22);
        contas[1] = cc2;

        //System.out.println(cc2.getNumero());

        System.out.println( contas[1].getNumero() );

        Conta ref = contas[1];
        System.out.println(cc2.getNumero());
        System.out.println(ref.getNumero());

        }

}COPIAR CÓDIGO
```

Assim, o Java consegue garantir que nos devolverá uma referência do tipo `Conta`.

Testaremos o código, executando-o. Temos o seguinte seguinte resultado no console:

```
22
22
22COPIAR CÓDIGO
```

Como sabemos que a:

```
//Código omitido

        Conta ref = contas[1];

//Código omitidoCOPIAR CÓDIGO
```

Aponta para um objeto do tipo `ContaPoupanca`, se escrevêssemos:

```
package br.com.bytebank.banco.test;

import br.com.bytebank.banco.modelo.Conta;
import br.com.bytebank.banco.modelo.ContaCorrente;

public class TestArrayReferencias {

        public static void main(String[] args) {

        //int[] idades = new int[5];
        Conta[] contas = new Conta[5];

        ContaCorrente cc1 = new ContaCorrente(22, 11);
        contas[0] = cc1;

        ContaPoupanca cc2 = new ContaPoupanca(22, 22);
        contas[1] = cc2;

        //System.out.println(cc2.getNumero());

        System.out.println( contas[1].getNumero() );

        ContaPoupanca ref = contas[1];
        System.out.println(cc2.getNumero());
        System.out.println(ref.getNumero());

        }

}COPIAR CÓDIGO
```

Poderia funcionar. Entretanto, vemos que o compilador também não permite. Isso acontece porque o compilador não verifica a linha onde é criado o objeto `ContaPoupanca()`, o que ele faz é verificar o array, e buscar o tipo de referência nele contido.

É do tipo `Conta`, ou seja, mais genérica. Isso significa que ela poderia apontar tanto para `ContaCorrente`, quanto para `ContaPoupanca`. Por esse motivo o compilador aponta o erro, pois diante dessa dualidade, ele não tem certeza se a seguinte linha de código funcionará:

```
//Código omitido

ContaPoupanca ref = contas[1];

//Código omitidoCOPIAR CÓDIGO
```

Como nós estamos controlando a execução, sabemos que esta posição do array aponta para o objeto `ContaPoupanca`. `ref` é um objeto do tipo `ContaPoupanca()`, portanto, aponta para o objeto `ContaPoupanca`.

Por isso, queremos informar ao compilador que isso vai funcionar, que nós temos conhecimento de o código irá compilar. Fazemos isso por meio de um **cast** de referências. Transformamos uma referência de um tipo mais genérico, para uma de um tipo mais específico. Isso pode ser chamado também de **type cast**:

```
package br.com.bytebank.banco.test;

import br.com.bytebank.banco.modelo.Conta;
import br.com.bytebank.banco.modelo.ContaCorrente;

public class TestArrayReferencias {

        public static void main(String[] args) {

        //int[] idades = new int[5];
        Conta[] contas = new Conta[5];

        ContaCorrente cc1 = new ContaCorrente(22, 11);
        contas[0] = cc1;

        ContaPoupanca cc2 = new ContaPoupanca(22, 22);
        contas[1] = cc2;

        //System.out.println(cc2.getNumero());

        System.out.println( contas[1].getNumero() );

        ContaPoupanca ref = (ContaPoupanca) contas[1]; //type cast
        System.out.println(cc2.getNumero());
        System.out.println(ref.getNumero());

        }

}COPIAR CÓDIGO
```

Testaremos. Executaremos e temos o seguinte resultado no console:

```
22
22
22COPIAR CÓDIGO
```

Funcionou!

Como sabemos, a referência aponta para um objeto do tipo `ContaPoupanca`.

E se tivéssemos a situação contrária? em vez de `ContaPoupanca`, utilizaremos `ContaCorrente`:

```
package br.com.bytebank.banco.test;

import br.com.bytebank.banco.modelo.Conta;
import br.com.bytebank.banco.modelo.ContaCorrente;

public class TestArrayReferencias {

        public static void main(String[] args) {

        //int[] idades = new int[5];
        Conta[] contas = new Conta[5];

        ContaCorrente cc1 = new ContaCorrente(22, 11);
        contas[0] = cc1;

        ContaPoupanca cc2 = new ContaPoupanca(22, 22);
        contas[1] = cc2;

        //System.out.println(cc2.getNumero());

        System.out.println( contas[1].getNumero() );

        ContaCorrente ref = (ContaCorrente) contas[1]; //type cast
        System.out.println(cc2.getNumero());
        System.out.println(ref.getNumero());

        }

}COPIAR CÓDIGO
```

Testando, vemos que no console é exibida a exceção de ***class cast exception***.

Fizemos um *cast* de uma referência genérica para uma mais específica, entretanto, ele não funcionou. O objeto `ref` é do tipo `ContaPoupanca`, por isso nosso *cast* não funcionando, pois não direcionamos para a referência mais específica correta.

Retornaremos à versão do código que está compilando:

```
package br.com.bytebank.banco.test;

import br.com.bytebank.banco.modelo.Conta;
import br.com.bytebank.banco.modelo.ContaCorrente;

public class TestArrayReferencias {

        public static void main(String[] args) {

        //int[] idades = new int[5];
        Conta[] contas = new Conta[5];

        ContaCorrente cc1 = new ContaCorrente(22, 11);
        contas[0] = cc1;

        ContaPoupanca cc2 = new ContaPoupanca(22, 22);
        contas[1] = cc2;

        //System.out.println(cc2.getNumero());

        System.out.println( contas[1].getNumero() );

        ContaPoupanca ref = (ContaPoupanca) contas[1]; //type cast
        System.out.println(cc2.getNumero());
        System.out.println(ref.getNumero());

        }

}COPIAR CÓDIGO
```

E se quisermos inicializar um array capaz de armazenar qualquer tipo de referência? Precisaríamos do tipo mais genérico possível, neste caso, seria do tipo `Object`.

```
package br.com.bytebank.banco.test;

import br.com.bytebank.banco.modelo.Conta;
import br.com.bytebank.banco.modelo.ContaCorrente;

public class TestArrayReferencias {

        public static void main(String[] args) {

        //int[] idades = new int[5];
        Object[] contas = new Object[5];

        ContaCorrente cc1 = new ContaCorrente(22, 11);
        contas[0] = cc1;

        ContaPoupanca cc2 = new ContaPoupanca(22, 22);
        contas[1] = cc2;

        //System.out.println(cc2.getNumero());

        System.out.println( contas[1].getNumero() );

        ContaPoupanca ref = (ContaPoupanca) contas[1]; //type cast
        System.out.println(cc2.getNumero());
        System.out.println(ref.getNumero());

        }

}COPIAR CÓDIGO
```

Nesse array, podemos guardar qualquer objeto. Criaremos um `Cliente`:

```
package br.com.bytebank.banco.test;

import br.com.bytebank.banco.modelo.Conta;
import br.com.bytebank.banco.modelo.ContaCorrente;

public class TestArrayReferencias {

        public static void main(String[] args) {

        //int[] idades = new int[5];
        Object[] contas = new Object[5];

        ContaCorrente cc1 = new ContaCorrente(22, 11);
        contas[0] = cc1;

        ContaPoupanca cc2 = new ContaPoupanca(22, 22);
        contas[1] = cc2;

        Cliente cliente = new Cliente();

        //System.out.println(cc2.getNumero());

        System.out.println( contas[1].getNumero() );

        ContaPoupanca ref = (ContaPoupanca) contas[1]; //type cast
        System.out.println(cc2.getNumero());
        System.out.println(ref.getNumero());

        }

}COPIAR CÓDIGO
```

No array `contas`, no índice `2`, guardaremos a referência que se chama `cliente`:

```
package br.com.bytebank.banco.test;

import br.com.bytebank.banco.modelo.Conta;
import br.com.bytebank.banco.modelo.ContaCorrente;

public class TestArrayReferencias {

        public static void main(String[] args) {

        //int[] idades = new int[5];
        Object[] contas = new Object[5];

        ContaCorrente cc1 = new ContaCorrente(22, 11);
        contas[0] = cc1;

        ContaPoupanca cc2 = new ContaPoupanca(22, 22);
        contas[1] = cc2;

        Cliente cliente = new Cliente();
        contas[2] = cliente;

        //System.out.println(cc2.getNumero());

        System.out.println( contas[1].getNumero() );

        ContaPoupanca ref = (ContaPoupanca) contas[1]; //type cast
        System.out.println(cc2.getNumero());
        System.out.println(ref.getNumero());

        }

}COPIAR CÓDIGO
```

Entretanto, a linha:

```
//Código omitido

System.out.println( contas[1].getNumero() );

//Código omitidoCOPIAR CÓDIGO
```

Parou de funcionar. Isso porque o tipo de referência no índice `1` é `Object`, e utilizamos esta referência genérica para chamar o método `getNumero()`. Na classe `Object` existe este método? Não existe. Por esse motivo, temos um erro de compilação.

Isso só funcionará se fizermos um **cast**, ou seja, se transformarmos uma referência genérica em uma específica. Comentaremos as linhas de código referentes a esta seção que não está compilando:

```
package br.com.bytebank.banco.test;

import br.com.bytebank.banco.modelo.Conta;
import br.com.bytebank.banco.modelo.ContaCorrente;

public class TestArrayReferencias {

        public static void main(String[] args) {

        //int[] idades = new int[5];
        Object[] contas = new Object[5];

        ContaCorrente cc1 = new ContaCorrente(22, 11);
        contas[0] = cc1;

        ContaPoupanca cc2 = new ContaPoupanca(22, 22);
        contas[1] = cc2;

        Cliente cliente = new Cliente();
        contas[2] = cliente;

        //System.out.println(cc2.getNumero());

        //Object referenciaGenerica = contas[1];

        //System.out.println( referenciaGenerica.getNumero() );

        ContaPoupanca ref = (ContaPoupanca) contas[1]; //type cast
        System.out.println(cc2.getNumero());
        System.out.println(ref.getNumero());

        }

}COPIAR CÓDIGO
```

Renomearemos a variável `contas`, clicando com o botão direito do mouse sobre ela, e selecionando a opção "Refactor > Rename...", ela passará a se chamar `referencias`:

```
//Código omitido

public class TestArrayReferencias {

        public static void main(String[] args) {

        //int[] idades = new int[5];
        Object[] referencias = new Object[5];

        ContaCorrente cc1 = new ContaCorrente(22, 11);
        referencias[0] = cc1;

        ContaPoupanca cc2 = new ContaPoupanca(22, 22);
        referencias[1] = cc2;

        Cliente cliente = new Cliente();
        referencias[2] = cliente;

        //System.out.println(cc2.getNumero());

        //Object referenciaGenerica = contas[1];

        //System.out.println( referenciaGenerica.getNumero() );

        ContaPoupanca ref = (ContaPoupanca) contas[1]; //type cast
        System.out.println(cc2.getNumero());
        System.out.println(ref.getNumero());

        }

}COPIAR CÓDIGO
```

Assim, nos aproximamos do resultado final. Adiante, falaremos mais sobre o `String[]`.