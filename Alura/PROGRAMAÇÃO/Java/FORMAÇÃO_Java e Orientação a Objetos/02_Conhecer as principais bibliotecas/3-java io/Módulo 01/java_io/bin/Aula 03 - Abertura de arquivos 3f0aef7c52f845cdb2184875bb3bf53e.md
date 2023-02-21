# Aula 03 - Abertura de arquivos

João se empolgou com a possibilidade de ler arquivos com sua linguagem de programação favorita! Então rapidamente criou o código a seguir para testar o que aprendeu em aula!

```
public class TesteLeitura {

    public static void main(String[] args) {

        FileInputStream fis = new FileInputStream("AulasAlura.txt");
        // restante do código omitido...
    }

}COPIAR CÓDIGO
```

O código compila e roda? Marque a opção correta:

*Selecione uma alternativa*

O código não compila pois faltou adicionar o `throws FileNotFoundException` ao método `main()` ou tratar a criação do `FileInputStream` com um bloco `try-catch`.

**Muito bem, aluno!** Isso é necessário uma vez que a exceção *checked* `FileNotFoundException` pode ser lançada pelo construtor da classe `FileInputStream` caso o arquivo cujo nome é informado não exista.