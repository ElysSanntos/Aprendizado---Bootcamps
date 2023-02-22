# Aula 04 - Saída para arquivo de texto

Veja o código abaixo, que estabelece uma saída com um arquivo de texto:

```
FileOutputStream fos = new FileOutputStream("lorem2.txt");
OutputStreamWriter osw = new OutputStreamWriter(fos);
BufferedWriter bw = new BufferedWriter(osw);COPIAR CÓDIGO
```

Quais classes abaixo são alternativas para estabelecer uma mesma saída?

*Selecione 3 alternativas*

- `java.io.PrintStream`
    
    Correto, basta usar:
    
    ```
    PrintStream out = new PrintStream("lorem2.txt");
    out.println("Lorem ipsum dolor sit amet");
    out.close();COPIAR CÓDIGO
    ```
    
    Lembrando também que utilizamos o `PrintStream` quando imprimos algo para o console:
    
    ```
    PrintStream console = System.out;
    console.println("Lorem ipsum dolor sit amet");COPIAR CÓDIGO
    ```
    
- Alternativa correta
    
    `java.io.FileWriter`
    
    Correto, a classe `FileWriter` foi criada com o propósito de estabelecer uma entrada com um arquivo de texto, por exemplo:
    
    ```
    FileWriter fw = new FileWriter("arquivo.txt");
    ```
    
    - `java.io.PrintWriter`
    
    Correto, o `PrintWriter` é parecido com o `PrintStream` e já possui vários métodos para imprimir qualquer tipo de dados:
    
    ```
    PrintWriter out = new PrintWriter("lorem2.txt");
    out.println("Lorem ipsum dolor sit amet");
    out.close();
    ```
    
    - a classe `Writer`  existe mas é "apenas" a classe-mãe para todos os *writers* , como `BufferedWriter`  ou `FileWriter` . Para estabelecer uma saída concreta, devemos instanciar uma classe concreta, como `FileWriter`  ou `PrintWriter`.
    - o `System.out`  é sempre a saída para console.