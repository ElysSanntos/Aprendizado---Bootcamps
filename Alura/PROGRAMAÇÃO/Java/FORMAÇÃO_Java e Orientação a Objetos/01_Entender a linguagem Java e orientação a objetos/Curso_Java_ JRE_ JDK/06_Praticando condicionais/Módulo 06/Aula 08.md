# Aula 08 - Escopo e inicialização de variáveis

Seguindo com as condicionais, veremos os **escopos de variáveis**. Já sabemos que o `boolean` `acompanhado` passa a valer ao declararmos as variáveis. Se tentássemos usá-la antes, logo após `idade`, ocorreria erro de compilação, pois a declaração ainda não foi feita.

Vamos criar a classe `TestaEscopo`, em que colaremos o código de `TestaCondicional2` pois trabalharemos em cima dele. Comentaremos a linha com o `boolean` para entendermos melhor o `if`, não esquecendo da declaração da variável `acompanhado` antes.

Uma variável, a partir de sua declaração, passa a valer entre as chaves correspondentes, o que se denomina **escopo**. Sendo assim, tanto `acompanhado = true` quanto `acompanhado = false` são necessários, pois fazem parte de **escopos diferentes**, com a inicialização sendo feita antes, em `boolean acompanhado;`, como se vê abaixo:

```
public class TestaEscopo {
    public static void main(String[] args) {
        System.out.println("testando condicionais");

        int idade = 20;
        int quantidadePessoas = 3;

        // boolean acompanhado = quantidadePessoas >= 2;

        boolean acompanhado;

        if (quantidadePessoas >= 2) {
            acompanhado = true;
        } else {
            acompanhado = false;
        }

        System.out.println("valor de acompanhado = " + acompanhado);

        if (idade >= 18 && acompanhado) {
            System.out.println("seja bem vindo");
        } else {
            System.out.println("infelizmente você não pode entrar");
        }
    }
}COPIAR CÓDIGO
```

Qual o valor *default* de um `boolean`?

No Java, essas variáveis do tipo local, como as que estamos vendo aqui, dentro de `main`, são temporárias e não possuem valor padrão, sendo necessária sua inicialização **antes** de sua impressão, acesso, em uma operação, e assim por diante.

O Eclipse "percorre" o caminho de seus `if`s e da árvore de possibilidades, e identifica a existência de uma situação em que determinada variável pode ou não ter sido inicializada.