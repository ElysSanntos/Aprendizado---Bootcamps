# Aula 07 - Para saber mais: currentTimeMillis

Um pouco mais sobre **`System`**.

Nessa aula, vimos mais um método da classe `System`, o método `lineSeparator`:

```
String newLine = System.lineSeparator();COPIAR CÓDIGO
```

Essa String possui os caracteres especiais que representam uma nova linha no seu sistema operacional (no Windows é `\r\n`, no Unix é `\n`).

Além disso, a classe `System` possui outros métodos, alguns são poucos usados, outros mais. Entre os mais usados está o método `currentTimeMillis();`

```
long millis = System.currentTimeMillis();COPIAR CÓDIGO
```

Ao executar essa linha, recebemos os milissegundos que passaram desde 1 de janeiro de 1970. Essa data é considerada o início da *Era Unix* ou *Unix Epoch*, que o Java também usa. Ou seja, essa data é o marco zero no sistema de calendário usado nos sistemas operacionais UNIX.

Agora sendo mais prático, você verá esse método para medir o tempo de execução de algum trecho de código. Por exemplo, podemos medir a escrita:

```
public class TesteEscritaFileWriter {

    public static void main(String[] args) throws IOException {

        long ini = System.currentTimeMillis();

        BufferedWriter bw = new BufferedWriter(new FileWriter("lorem2.txt"));

        bw.write("Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod");
        bw.newLine();
        bw.write("tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam");

        bw.close();

        long fim = System.currentTimeMillis();

        System.out.println("Passaram " + (fim - ini) + " milissegundos");

    }
}
```