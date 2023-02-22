# Aula 05 - Escrita independente do sistema

Um desenvolvedor Java Junior escreveu o seguinte código:

```
FileWriter fw = new FileWriter("arquivo.txt");

fw.write("Lorem ipsum dolor sit amet ...");
fw.write("\n");
fw.write("tempor incididunt ut labore ...");

fw.close();COPIAR CÓDIGO
```

Você inspecionou o código e percebeu que pode ser melhorado, para garantir que funcione em todos os sistemas operacionais, como o esperado. O que pode ser feito?

Marque todas as alternativas corretas:

*Selecione 2 alternativas*

Basta substituir a linha:

`fw.write("\n")`
Por:

`fw.write(System.lineSeparator())`

Correto, ao usar `System.lineSeparator()`, garantimos que a nova linha no arquivo de texto é criada baseada nos caracteres do sistema operacional.

Troque o `FileWriter` com `PrintWriter`, sempre usando o método `println` para escrita (e sem usar `\n`).

Correto, a classe `PrintWriter` tem métodos de mais alto nível que já cuidam da nova linha, independente do sistema operacional.

- Não basta apenas combinar o `BufferedWriter`  com `FileWriter` , também devemos utilizar o método `newLine()` , da  classe `BufferedWriter` , para substituir a linha `fw.write("\n")` .