# Aula 07 - Qual é o resultado?

Veja o código:

```
public class TesteString {

    public static void main(String[] args) {

        String nome = "Mario";
        nome.replace('o', 'a');
        System.out.println(nome);
    }
}COPIAR CÓDIGO
```

Ao compilar e rodar, qual é o resultado?

*Obs: Se tiver com dúvidas, pode testar no Eclipse, claro.*

O código compila e roda. O resultado é:

`Mario`

Correto, pois o método `replace` não altera a `String` original e sim devolve uma nova `String`. Para contemplar a alteração devemos pegar o resultado do método `replace`:

```
String nome = "Mario";
nome = nome.replace('o', 'a');
System.out.println(nome);
```

- *Obs: Usando aspas simples estamos declarando uma `char`  (caractere). *