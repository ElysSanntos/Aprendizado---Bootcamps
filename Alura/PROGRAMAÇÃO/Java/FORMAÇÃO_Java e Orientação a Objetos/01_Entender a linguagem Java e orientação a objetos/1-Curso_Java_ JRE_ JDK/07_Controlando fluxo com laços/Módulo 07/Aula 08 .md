# Aula 08 - Mão na massa: Laços

Finalmente, chegou a hora de praticarmos os laços!

---

## **While**

1) Crie uma classe e seu método main, no curso demos o nome de "**TestaWhile**".

2) Escreva o **while** que imprima os números de 0 a 10, lembre-se de criar sua variável **contador** com o valor 0, ficando dessa forma,

```
public class TestaWhile {

        public static void main(String[] args){

            int contador = 0;
            while(contador <= 10) {
                System.out.println(contador);
                contador = contador + 1;
            }

    }
}COPIAR CÓDIGO
```

Podemos trocar a linha que incrementa a variável **contador** por:

```
contador += 1;COPIAR CÓDIGO
```

Ou

```
contador++;  //mais usado!COPIAR CÓDIGO
```

## **For**

1) Crie uma classe e seu método main, no curso escolhemos "**TestaFor**"

2) Escreva um laço **for** que imprima os números de 0 a 10, desta forma:

```
public class TestaFor {

        public static void main(String[] args){

            for(int contador = 0; contador <= 10; contador++) {
                System.out.println(contador);
            }

    }
}COPIAR CÓDIGO
```

Repare que não podemos usar a variável **contador** fora do escopo do **for**.