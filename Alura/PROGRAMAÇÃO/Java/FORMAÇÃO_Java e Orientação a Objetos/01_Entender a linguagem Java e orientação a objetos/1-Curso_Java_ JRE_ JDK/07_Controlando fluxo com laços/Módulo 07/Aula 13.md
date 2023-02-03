# Aula 13 - Mão na massa: Aprofundando laços

Vamos um pouco mais a fundo agora.

---

1) Crie uma classe e seu método main, escolhemos o nome "**TestaLacos**"

2) Escreva um **for** encadeado que imprima a tabuada de cada número, nosso código ficará assim:

```
public class TestaLacos {

        public static void main(String[] args){

            for (int multiplicador = 1; multiplicador <= 10; multiplicador++) {
                for(int contador = 0; contador <= 10; contador++) {
                    System.out.print(multiplicador * contador);
                    System.out.print(" ");
                }
                System.out.println();
            }

    }
}
COPIAR CÓDIGO
```

Repare que usamos o `System.out.println();` para organizar melhor a impressão.

3) Vamos criar outra classe e implementar o método main, no curso escolhemos o nome "**TestaLaco2**"

4) Vamos praticar o comando **break** imprimindo uma matriz triangular, esse é o nosso código:

```
public class TestaLaco2{

        public static void main(String[] args){

            for (int linha = 0; linha < 10; linha++) {
                for(int coluna = 0; coluna < 10; coluna++) {
                    if (coluna > linha) {
                        break;
                    }
                    System.out.print("*");
                }
                System.out.println();
            }

    }
}COPIAR CÓDIGO
```

Repare que o **break** interrompe a execução do laço, fazendo com que pule para o laço mais externo.

5) Podemos melhorar nosso código, para isso faça as modificações:

```
public class TestaLaco2 {

        public static void main(String[] args){

            for (int linha = 0; linha < 10; linha++) {
                for(int coluna = 0; coluna <= linha; coluna++) {
                    System.out.print("*");
                }
                System.out.println();
            }

    }
}COPIAR CÓDIGO
```

Removemos o **if** e mudamos o critério de repetição do **for** interno:

```
coluna <= linha   //restante do for
```