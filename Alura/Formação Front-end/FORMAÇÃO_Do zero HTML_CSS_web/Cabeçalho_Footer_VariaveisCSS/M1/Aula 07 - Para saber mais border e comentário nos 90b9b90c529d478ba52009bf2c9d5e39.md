# Aula 07 - Para saber mais: border e comentário nos códigos

Durante a aula, personalizamos a propriedade CSS chamada `border`, para adicionar a borda em volta dos botões. Essa propriedade pode ser usada para definir os valores de largura da borda, estilo da borda e cor da borda e possui alguns estilos diferentes, como o “dotted”, que conhecemos na aula através da [documentação](https://www.w3schools.com/css/css_border.asp).

Caso você queira conhecer melhor essa propriedade, que tal dar uma olhada no artigo [CSS Border: estilizando com bordas seus elementos CSS](https://www.alura.com.br/artigos/css-border-estilizando-bordas-elementos-css) e no [Alura+](https://cursos.alura.com.br/extra/alura-mais/css-border-estilizando-com-bordas-seus-elementos-css-c1486) de mesmo nome feitos pelo instrutor Luan Alves?

## **O que são comentários?**

Comentários são notas de texto que podem ser inseridas ao longo do desenvolvimento e que serão ignoradas pelo código, portanto não interferem em seu funcionamento.

## **Para que servem os comentários**

Os comentários podem ser usados para anotar informações importantes sobre o código, para salvar códigos que estivermos testando sem que haja necessidade de apagar e reescrever, para descrever alguma função específica e facilitar manutenções futuras ou até para auxiliar na organização das ideias de construção do código.

## **Como comentar em HTML e CSS**

O uso de comentários é comum em diversas linguagens e cada uma terá sua sintaxe particular. Isso também acontece em HTML e CSS, já que em cada uma temos uma maneira de adicionar comentários, que vamos conhecer a seguir:

### **HTML**

Os comentários no HTML se assemelham com uma abertura de `tag`. Abrimos um comentário com `<!--` e fazemos seu fechamento com `-->`. Tudo que estiver entre esses dois marcadores será considerado como comentário, inclusive quebras de linha:

```
<p> Isso é um parágrafo de texto e será exibido pelo navegador </p>

<!-- Isso é um comentário e será ignorado  -->

<!-- Isso é um comentário com quebra de linha

e também será ignorado  -->

<p> Isso é um parágrafo de texto e será exibido pelo navegador </p>
COPIAR CÓDIGO
```

### **CSS**

Os comentários em CSS também possuem abertura e fechamento. Abrimos esse tipo de comentário com `/*` e fechamos com `*/` e assim como no HTML, tudo que estiver entre essas marcações será considerado comentário, ainda que esteja entre mais de uma linha:

```
body{
    background-color: white;
    /* Isso é um comentário em CSS */
    /*
        Isso é um comentário em CSS com
        quebra de linha
    */
}
COPIAR CÓDIGO
```

## **Boas práticas ao comentar**

Os comentários podem ser muito úteis para facilitar o desenvolvimento, no entanto, precisamos ter atenção a algumas boas práticas para fazer seu uso adequado:

- Evite adicionar muitos comentários para não gerar uma “bagunça” em seu código;
- Evite criar comentários muito longos. Tenha em mente que apesar de não serem executados, esses comentários ocupam espaço e podem deixar seu arquivo mais pesado;
- Use os comentários a seu favor, ou seja, anote informações essenciais neles, pois isso irá facilitar com que você encontre aquilo que é realmente necessário lembrar no momento de fazer manutenções em seu código;
- Ao usar comentários para testar sua aplicação, lembre-se de apagar essas notas quando terminar, para que seu código não fique desorganizado e com partes desnecessárias;
- Por fim, lembre-se sempre que um código descritivo é mais duradouro que muitos comentários. Quando estiver trabalhando com HTML, lembre-se de usar as [Tags semânticas](https://developer.mozilla.org/pt-BR/docs/Glossary/Semantics) e ao criar suas classes CSS, adicione nomes significativos. Assim, seu código ficará naturalmente descritivo e não dependerá tanto dos comentários, que podem ser apagados ou se perderem ao longo de manutenções =) .