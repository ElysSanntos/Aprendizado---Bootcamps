# Aula 10 - Mão na massa: Escrevendo nosso primeiro código

Chegou a hora de escrever seu código! Para isso, siga os passos abaixo:

---

1) Como visto no vídeo, o comando utilizado para imprimir algo na tela é o `System.out.println`, mas apenas ele não será suficiente para que o programa compile. Então até o momento temos:

```
System.out.println("ola mundo");COPIAR CÓDIGO
```

2) Para que nosso código compile, primeiramente envolva-o com uma classe, ficando dessa forma:

```
public class Programa{

    System.out.println("ola mundo");
}COPIAR CÓDIGO
```

3) Nosso programa ainda não compila, para funcionar, coloque o método main, não se preocupe com o `main` agora, no decorrer do curso veremos os detalhes e entenderemos esse método. Teremos um código assim:

```
public class Programa{

    public static void main(String[] args){

        System.out.println("ola mundo");
    }
}
COPIAR CÓDIGO
```

4) Após feito isso, salve o arquivo como `Programa.java` em algum diretório. O nome deve ser exatamente igual ao nome da classe criada, inclusive as letras maiúsculas e minúsculas! Lembre-se que o Java é **case-sensitive**.

5) Agora, compile o código utilizando o compilador de Java da Oracle, chamado de `javac`. Ele nos dará o **bytecode**:

```
javac Programa.javaCOPIAR CÓDIGO
```

6) Após compilado, podemos ver que o **bytecode** foi gerado com o mesmo nome, mas com `.class` no final.

7) Execute o programa já compilado escrevendo:

```
java ProgramaCOPIAR CÓDIGO
```

Quando escrevemos apenas `java`, estamos invocando a máquina virtual para interpretar nosso programa.

Após feito isso, teremos como saída a frase `ola mundo`.