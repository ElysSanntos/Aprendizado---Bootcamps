# Aula 10 - Mão na massa: Escopo de variáveis

Prosseguindo, vamos agora dar uma olhada nos **escopos**.

---

1) Crie uma classe e estruture seu método main, no curso demos o nome de "**TestaEscopo**"

2) Quebre a sua declaração da variável booleana, usando um **if**, deixando o código assim:

```
public class TestaEscopo {

        public static void main(String[] args){
            System.out.println("testando condicionais");

            int idade = 20;
            int quantidadePessoas = 3;
            //boolean acompanhado = true;

            if (quantidadePessoas >= 2) {
                boolean acompanhado = true;
            }else {
                boolean acompanhado = false;
            }

            if (idade >=18 || acompanhado){

                System.out.println("Seja bem vindo");
            } else {
                System.out.println("infelizmente voce nao pode entrar");
        }

    }
}COPIAR CÓDIGO
```

Repare que nosso código deixa de compilar, já que nossa variável é criada dentro do **if**, quando chegamos ao final do **if**, ela deixa de existir.

3) Modifique seu código para que ele compile, nosso código deve ficar assim:

```
public class TestaEscopo {

        public static void main(String[] args){
            System.out.println("testando condicionais");

            int idade = 20;
            int quantidadePessoas = 3;
            boolean acompanhado;

            if (quantidadePessoas >= 2) {
                acompanhado = true;
            }else {
                acompanhado = false;
            }

            if (idade >=18 || acompanhado){

                System.out.println("Seja bem vindo");
            } else {
                System.out.println("infelizmente voce nao pode entrar");
        }

    }
}
```