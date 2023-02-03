# Aula 03 - Mão na massa: utilizando o tipo int

Está na hora de praticarmos o uso de tipos primitivos, para isso, siga os passos abaixo!

---

1) Crie um projeto, lembre-se que para fazer isso usamos o **new** e escolhemos **Java project**.

2)Nessa janela, nomeie seu projeto. No curso, escolhemos "**sintaxe-variaveis-e-fluxo**".

3) Agora crie uma classe, utilizando novamente o **new**, só que dessa vez, escolha **class** dentre as opções do Eclipse.

4) Na janela, nomeie sua classe. No curso usamos o nome "**TestaVariaveis**"

5) Escreva um código semelhante ao nosso anterior, ficando dessa forma.

```
public class TestaVariaveis{

    public static void main(String [] args){

        System.out.println("ola novo teste");
    }
}COPIAR CÓDIGO
```

6) Crie uma variável com nome idade, do tipo **int** e atribua um valor:

- **** Podemos fazer de duas formas, criando a variável e depois inicializando-a:

```
int idade;
idade = 37;COPIAR CÓDIGO
```

- **** ou, criando a variável e inicializando-a na mesma linha

```
int idade = 37;COPIAR CÓDIGO
```

7) Imprima a variável idade, nosso código deve ficar assim:

```
public class TestaVariaveis{

    public static void main(String [] args){

        System.out.println("ola novo teste");

        int idade = 37;

        System.out.println(idade);
    }
}COPIAR CÓDIGO
```

Repare que quando queremos imprimir o **valor** que está guardado na variável, não devemos usar as aspas.

8) Perceba que podemos usar operadores aritméticos:

`+` para Soma

- `` para Subtração
- `` para Multiplicação

`/` para Divisão

9) Podemos concatenar valores no `System.out.println` usando o sinal **+**, dessa forma faça:

```
public class TestaVariaveis{

    public static void main(String [] args){

        System.out.println("ola novo teste");

        int idade = 37;

        System.out.println("a idade é "+ idade + ", parabéns!");
    }
}
```