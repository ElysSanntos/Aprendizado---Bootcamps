# Aula 02 - Sobre o FileWriter

Todas as afirmações abaixo sobre a classe **`java.io.FileWriter`** estão corretas, exceto:

*Selecione uma alternativa*

`FileWriter` é um `OutputStream`.

Não é verdade, pois o `FileWriter` é um `Writer` e não um `OutputStream`.

Para ser mais específico, a classe `FileWriter` estende a classe `OutputStreamWriter`, que por sua vez estende a classe `Writer`. Então o `FileWriter` é um `OutputStreamWriter` e é um `Writer`.

- `FileWriter`  pode ser combinado com outros `Writer`s, como `BufferedWriter`.
    - podemos passar o `FileWriter` para o `BufferedWriter`:

```java
	Writer bw = new BufferedWriter(new FileWriter("arquivo.txt")
```

- É usado para escrever caracteres. Faz parte da categoria de *Reader*  e *Writer* , que trabalham com caracteres.
- É usado para estabelecer uma saída com um arquivo.
    - tanto que o construtor do `FileWriter`  recebe o nome do arquivo.