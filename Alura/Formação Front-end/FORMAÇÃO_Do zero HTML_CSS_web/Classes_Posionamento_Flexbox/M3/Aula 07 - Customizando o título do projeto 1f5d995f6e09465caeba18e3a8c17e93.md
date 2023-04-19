# Aula 07 - Customizando o título do projeto

A customização de textos, principalmente títulos, através de estilos e fontes é uma etapa importante no desenvolvimento de uma página Web, pois a experiência do usuário depende muito da parte visual. Sabendo disso, imagine que você recebeu a tarefa de estilizar o título `<h1>` de uma página, trocando a fonte padrão para a importada Roboto, aumentando seu tamanho de 16 pixels para 20 pixels e mudando sua cor de preto para azul.

Analisando o código base que você recebeu abaixo, marque a alternativa que indique corretamente o que deve ser alterado:

```
@import url('https://fonts.googleapis.com/css2?family=Roboto&display=swap');

h1 {
    font-size: 16px;
}COPIAR CÓDIGO
```

*Selecione uma alternativa*

`h1 {
font-size: 20px;
font-family: ‘Roboto’, sans-serif;
color: blue; 
}`

Correto! A sintaxe tanto das propriedades quanto dos valores correspondentes foram escritos corretamente. A unidade de medida da fonte foi o pixel, como pedido no enunciado, a família Roboto importada foi utilizada e a cor alterada para azul.