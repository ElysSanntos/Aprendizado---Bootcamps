# Aula 06 - Para saber mais: as variáveis no mundo da programação

## **Um armário cheio de gavetas!**

Imagine que você trabalhe em uma sala de arquivos, que possui um armário muito grande e cheio de gavetas. Todos os dias, pessoas trazem seus objetos para que você guarde em uma gaveta para eles e para isso, te entregam uma etiqueta com um nome que será colado nessa gaveta que armazenará o objeto da pessoa.

Ana te entregou uma caneta e uma etiqueta com o nome: `canetaDaAna`, e você guardou a caneta dela em uma gaveta, onde colou a etiqueta. Ela escolheu o nome `canetaDaAna`, mas poderia ser qualquer outro nome e seu conteúdo poderia ser qualquer um também, como um livro, por exemplo, e não uma caneta.

Quando Ana precisar da caneta, ela irá te chamar e pedir pela `canetaDaAna`, e você a entregará o conteúdo da gaveta, ou seja, a caneta.

## **E como isso se relaciona com as variáveis?**

Seu armário de gavetas no exemplo acima representa a memória do computador. Quando criamos uma variável, estamos solicitando ao computador que reserve uma “gavetinha” em sua memória para que guarde algo que precisaremos usar futuramente, e fazemos isso atribuindo um nome de variável que poderemos chamar a qualquer momento e que retornará o conteúdo que guardamos dentro dela. Esse nome pode ser um nome qualquer, no entanto sempre que solicitado ele trará como resposta aquilo que você armazenou nele.

## **O que são variáveis?**

Variáveis são elementos que permitem que valores sejam manipulados ao longo da execução de seu código, através da definição de um nome para armazenar um valor que será usado repetidas vezes. Essa definição do nome e do conteúdo que será contido nele é o que nós chamamos de **declaração**.

Esse valor pode ser alterado ao longo do código, por isso o nome “váriavel”.

Observe o seguinte exemplo:

```
:root{
     --tamanho-da-fonte:  24px;
}COPIAR CÓDIGO
```

Criamos no `:root`, ou seja, no escopo global de um código, uma variável que foi declarada com o nome `--tamanho-da-fonte` e seu valor foi atribuído como `24px`. Toda vez que chamarmos pelo nome `--tamanho-da-fonte`, iremos obter como retorno o valor `24px`.

Variáveis são utilizadas diariamente pelas pessoas desenvolvedoras para que consigam manipular e reutilizar valores em seu código e estão presentes nas mais diversas linguagens de programação, pois são elementos base ao criar qualquer código que tenha a mínima funcionalidade. Portanto, conforme você evoluir em seus conhecimentos no desenvolvimento é certo que irá lidar muito com variáveis.

Para saber mais sobre as variáveis em CSS, você pode conferir a [documentação](https://developer.mozilla.org/pt-BR/docs/Web/CSS/Using_CSS_custom_properties).