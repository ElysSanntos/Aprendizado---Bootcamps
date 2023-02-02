# Aula 03 - Mão na massa: A condicional if

Chegou a hora de praticarmos nossa condicional **if**:

---

1) Crie uma classe e monte seu método main (utilize o atalho **Ctrl + Espaço**). Nessa aula escolhemos o nome "**TestaCondicional**".

2) Escreva "**Sysout**" e utilize o atalho "Ctrl + Espaço", veja que o Eclipse escreverá o `System.out.println(x);` automaticamente. No momento, nosso código é:

```
public class TestaCondicional{

    public static void main(String[] args){
        System.out.println("testando condicionais");

    }

}COPIAR CÓDIGO
```

3) Crie a variável *idade*, do tipo inteiro e inicialize com o valor 20:

```
public class TestaCondicional{

    public static void main(String[] args){
        System.out.println("testando condicionais");

        int idade = 20;
    }
}COPIAR CÓDIGO
```

4) Escreva um código que teste se a variável `idade` é maior ou igual a `18`, caso verdadeiro, exibiremos uma mensagem, caso falso (**else**), exibiremos uma outra mensagem. Nosso código deve ficar com essa cara:

```
public class TestaCondicional {

    public static void main(String[] args) {
        System.out.println("testando condicionais");

        int idade = 20;

        if (idade >= 18) {
            System.out.println("Você tem mais que 18 anos");
            System.out.println("Seja bem vindo");
        } else {
            System.out.println("Infelizmente voce nao pode entrar");
        }
    }
}COPIAR CÓDIGO
```

5) Crie uma variável *quantidadePessoas* com o valor 3.

6) Adicione mais um **if** após o **else** no nosso código para testar se essa pessoa está acompanhada ou não, ficando assim:

```
public class TestaCondicional {

    public static void main(String[] args) {
        System.out.println("testando condicionais");

        int idade = 20;
        int quantidadePessoas = 3;

        if (idade >= 18) {

            System.out.println("Você tem mais que 18 anos");
            System.out.println("Seja bem vindo");
        } else {
            if (quantidadePessoas >= 2) {
                System.out.println("voce nao tem 18, mas pode entrar, pois está acompanhado");
            } else {

                System.out.println("infelizmente voce nao pode entrar");
            }
        }
    }
}COPIAR CÓDIGO
```

Caso queira, quebre a linha do `System.out.println()` por questão de legibilidade, deixando-a dessa forma:

```
System.out.println("voce nao tem 18, mas pode entrar, "
+ "pois está acompanhado");COPIAR CÓDIGO
```

Tudo bem até agora? Sim? Então vamos lá!