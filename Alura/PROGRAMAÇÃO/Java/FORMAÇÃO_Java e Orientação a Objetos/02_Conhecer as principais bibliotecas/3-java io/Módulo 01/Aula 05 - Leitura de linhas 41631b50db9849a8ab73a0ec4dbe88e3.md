# Aula 05 - Leitura de linhas

Mário criou um `BufferedReader` como visto em aula e tentou obter uma linha do arquivo aberto:

```
public class TesteLeitura {

    public static void main(String[] args) throws IOException {

        FileInputStream fis = new FileInputStream("arquivo.txt");
        InputStreamReader isr = new InputStreamReader(fis);
        BufferedReader br = new BufferedReader(isr);

        System.out.println(br.ready());

        br.close();
    }

}COPIAR CÓDIGO
```

O código compila e executa mas não funciona como desejado. Marque a opção que indica corretamente a situação do código do nosso colega!

*Selecione uma alternativa*

O código não está correto pois o método correto para leitura de uma linha é `readLine()`.

**Muito bem, aluno!** O método `ready()`, por outro lado, indica se o arquivo está pronto para ser lido!