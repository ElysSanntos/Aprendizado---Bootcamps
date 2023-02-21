# Aula 06 - Leitura de arquivos

Maria resolveu se aventurar e escreveu o código a seguir!

```
public class TesteLeitura {

    public static void main(String[] args) throws IOException {

        InputStream fis = new FileInputStream("LivroDeJava.txt");
        Reader isr = new InputStreamReader(fis);
        Reader br = new BufferedReader(isr);

        String linha = br.readLine();

        while (linha != null) {
            System.out.println(linha);
            linha = br.readLine();
        }

        br.close();
    }

}COPIAR CÓDIGO
```

Marque a opção com a afirmativa correta sobre o código da nossa colega!

*Selecione uma alternativa*

O código não compila pois `br` é uma referência do tipo `Reader` e essa classe não possui o método `readLine()`.

**Muito bem, aluno!** `BufferedReader` até é uma subclasse de `Reader`, no entanto, como precisamos do método `readLine()` e `Reader` não possui esse método, então é necessário que a referência seja do tipo `BufferedReader`.