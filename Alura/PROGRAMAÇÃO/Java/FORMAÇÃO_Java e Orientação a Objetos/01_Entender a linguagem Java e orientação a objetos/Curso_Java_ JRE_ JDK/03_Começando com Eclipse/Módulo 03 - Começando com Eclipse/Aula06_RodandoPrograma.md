# Aula 06 -  Mão na massa: Rodando nosso programa no Eclipse

Chegou a hora de rodarmos nosso código no Eclipse, siga os passos abaixo!

---

1) Ao inicializarmos o Eclipse, ele nos pedirá para selecionarmos um "workspace", que é onde ficarão armazenados seus projetos. Caso você queira personalizar isso, clique em **Browse...** e selecione sua pasta. Nesse curso usaremos a própria pasta **workspace**.

2) Feche a página de Welcome e vamos iniciar o Eclipse da maneira que encontramos ele normalmente.

3) Clique em **File** e coloque seu cursor sobre a linha **new** e veja que o Eclipse nos dará algumas opções. Escolha **Java project**.

4) Nessa janela nova, nomearemos nosso projeto, escolhemos o nome **sintaxe-basica**, lembre-se de verificar a versão do Java utilizada.

5) Repare que temos um novo projeto na **View** `Package Explorer`, guardaremos nosso projeto dentro desta pasta **src** que foi criada.

6) No diretório **src**, clique com o botão direito do mouse, coloque o cursor em **new** e escolha **class**

7) Nessa nova janela, criaremos a classe com o nome Programa, nesse momento não se preocupe com as diversas opções que o Eclipse nos oferece. Clique em **finish** e teremos nossa classe Programa.

8) Antes de colocar o tal do `System.out.println`, escreva o método main. Fique tranquilo, entenderemos melhor o `main` no decorrer do curso. Nosso código ficará assim:

```
public class Programa{

    public static void main(String[] args){

        System.out.println("ola mundo");
    }
}COPIAR CÓDIGO
```

9) Repare que durante a escrita, o Eclipse tenta inferir algumas coisas, além de fechar as aspas automaticamente.

10) Para executarmos nosso código, na parte de cima do Eclipse, clique em **Run**, e depois em **Run As** e escolha **Java Application**.