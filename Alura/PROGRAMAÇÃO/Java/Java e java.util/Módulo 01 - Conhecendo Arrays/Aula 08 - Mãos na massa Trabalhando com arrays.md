# Aula 08 - Mãos na massa: Trabalhando com arrays

Chegou a hora de você pôr em prática o que foi visto na aula. Para isso, execute os passos listados abaixo.

---

### **Arrays**

1) No projeto **bytebank-herdado-conta**, no pacote **br.com.bytebank.banco.test**, renomeie a classe **Teste** para **TesteObject**. Após isso, também no mesmo pacote, crie uma nova classe **TesteArrayDePrimitivos**, já com o método **`main`**:

```
public class TesteArrayDePrimitivos {

    public static void main(String[] args) {

    }

}COPIAR CÓDIGO
```

2) Para guardar idades, crie um **array** de inteiros, com cinco posições:

```
public class TesteArrayDePrimitivos {

    public static void main(String[] args) {

        int[] idades = new int[5];

    }

}COPIAR CÓDIGO
```

3) Em seguida, inicialize cada posição do array com uma idade:

```
public class TesteArrayDePrimitivos {

    public static void main(String[] args) {

        int[] idades = new int[5];

        idades[0] = 29;
        idades[1] = 39;
        idades[2] = 49;
        idades[3] = 59;
        idades[4] = 69;

    }

}COPIAR CÓDIGO
```

4) Ao acessar alguma posição do array, ele retorna o valor guardado nessa posição. Então, guarde o valor da quarta posição do array em uma variável e imprima-a:

```
public class TesteArrayDePrimitivos {

    public static void main(String[] args) {

        int[] idades = new int[5];

        idades[0] = 29;
        idades[1] = 39;
        idades[2] = 49;
        idades[3] = 59;
        idades[4] = 69;

        int idade4 = idades[3];

        System.out.println(idade4);

    }

}COPIAR CÓDIGO
```

5) Imprima o tamanho do array, acessando o seu atributo **`length`**:

```
public class TesteArrayDePrimitivos {

    public static void main(String[] args) {

        int[] idades = new int[5];

        idades[0] = 29;
        idades[1] = 39;
        idades[2] = 49;
        idades[3] = 59;
        idades[4] = 69;

        int idade4 = idades[3];

        System.out.println(idade4);
        System.out.println(idades.length);

    }

}COPIAR CÓDIGO
```

6) Inicialize o array dentro de um laço, mas antes apague todo o código, deixando somente a inicialização do array:

```
public class TesteArrayDePrimitivos {

    public static void main(String[] args) {

        int[] idades = new int[5];

    }

}COPIAR CÓDIGO
```

7) Agora, inicialize o array dentro de um laço, por exemplo:

```
public class TesteArrayDePrimitivos {

    public static void main(String[] args) {

        int[] idades = new int[5];

        for (int i = 0; i < idades.length; i++) {
            idades[i] = i * i;
        }

    }

}COPIAR CÓDIGO
```

8) Em seguida, faça um outro laço e imprima cada elemento do array:

```
public class TesteArrayDePrimitivos {

    public static void main(String[] args) {

        int[] idades = new int[5];

        for (int i = 0; i < idades.length; i++) {
            idades[i] = i * i;
        }

        for (int i = 0; i < idades.length; i++) {
            System.out.println(idades[i]);
        }

    }

}COPIAR CÓDIGO
```

### **Arrays de referência**

9) No projeto **bytebank-herdado-conta**, no pacote **br.com.bytebank.banco.test**, crie a classe **TesteArrayReferencias**, já com o método **`main`**:

```
public class TesteArrayReferencias {

    public static void main(String[] args) {

    }

}COPIAR CÓDIGO
```

10) Para guardar contas, crie um array de **`ContaCorrente`**, com cinco posições:

```
public class TesteArrayReferencias {

    public static void main(String[] args) {

        ContaCorrente[] contas = new ContaCorrente[5];

    }

}COPIAR CÓDIGO
```

11) Instancie duas contas e guarde-as nas duas primeiras posições do array, por exemplo:

```
public class TesteArrayReferencias {

    public static void main(String[] args) {

        ContaCorrente[] contas = new ContaCorrente[5];

        ContaCorrente cc1 = new ContaCorrente(22, 11);
        ContaCorrente cc2 = new ContaCorrente(22, 22);

        contas[0] = cc1;
        contas[1] = cc2;

    }

}COPIAR CÓDIGO
```

12) Através do array, acesse a conta da primeira posição e imprima seu número:

```
public class TesteArrayReferencias {

    public static void main(String[] args) {

        ContaCorrente[] contas = new ContaCorrente[5];

        ContaCorrente cc1 = new ContaCorrente(22, 11);
        ContaCorrente cc2 = new ContaCorrente(22, 22);

        contas[0] = cc1;
        contas[1] = cc2;

        System.out.println(contas[0].getNumero());

    }

}
```