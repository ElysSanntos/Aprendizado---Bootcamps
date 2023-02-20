# Aula 09 - Mão na massa: jar

Sabemos que através de `jars` podemos facilitar o compartilhamento do nosso código entre equipes. Chegou a hora de praticar.

1 - No Eclipse, clicando com o botão direto no projeto `bytebank-herdado-conta`, selecione a opção **export**. Diversas opções de exportação serão exibidas, selecione aquela dentro do grupo **java** e dentro dele a opção **JAR File** clicando em "NEXT". Vejamos o próximo passo a seguir.

2 - No projeto `bytebank-herdado-conta`, selecione apenas a pasta `src`. Desmarque também os arquivos `.classpath` e `.project`. Certifique-se que apenas a opção "**Export generated class files and resources**" esteja marcada. Em "Jar File", selecione uma pasta de fácil acesso no qual será gravado o arquivo jar que vamos criar. Clique em `Finish` e caso algum aviso seja exibido, ignore-os totalmente.

3 - Verifique a existência do arquivo jar criado.

4 - Para testar o arquivo jar recém criado, crie um novo projeto java chamado `bytebank-biblioteca`. Feche os demais projetos para que seja mais fácil focar o novo projeto.

5 - Com o botão direito sobre o novo projeto, escolha *New -> Folder*. Como nome do diretório escolha `libs`.

6 - Copie o jar exportado para dentro da pasta `libs` recém criada.

7 - Copiar o arquivo jar para dentro de um projeto não é suficiente, ele precisa estar no *class path*. Clique com o botão direto sobre o arquivo jar dentro da pasta `libs` e escolha a opção *add to build path*. Veja se você selecionou a opção "Package Explorer". Se estiver com a opção Navigator selecionada, não irá aparecer Build Path

8 - Agora que o nosso projeto enxerga o jar criado, crie a classe `TesteBiblioteca` no pacote `br.com.alura.bytebank`. Sua finalidade é importar algumas classes do jar importado:

```
package br.com.alura.bytebank;

import br.com.bytebank.banco.modelo.Conta;
import br.com.bytebank.banco.modelo.ContaCorrente;

public class TesteBiblioteca {

    public static void main(String[] args) {
        Conta c = new ContaCorrente(123, 321);
    }
}COPIAR CÓDIGO
```

Excelente, você acaba de importar os recursos de um arquivo jar.