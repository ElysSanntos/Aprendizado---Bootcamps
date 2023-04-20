# Aula 07 - Faça como eu fiz: personalizando a paleta de cores!

Nessa aula conhecemos as variáveis CSS e descobrimos seu potencial para customização do projeto.

Agora, gostaríamos de te convidar a fazer como foi feito em aula e buscar outras paletas de cores que possam ser aplicadas no projeto através das variáveis CSS que criamos.

As cores causam um grande impacto e alterando elas você pode obter um projeto com uma cara totalmente nova. Caso queira pesquisar paletas como foi feito em aula, você pode acessar o [Color Hunt](https://colorhunt.co/). Outra opção interessante é a [Roda de Cores da Adobe](https://color.adobe.com/pt/create/color-wheel).

Um atalho que pode facilitar muito o processo de alterar as cores em todo o código para atribuir em seu lugar a variável é o `ctrl + D`. Basta selecionar o que deseja mudar com o mouse e em seguida clicar em `ctrl + D` até que todos os valores que você deseja alterar estejam selecionados. Isso irá permitir mudar ao mesmo tempo todos os valores seguintes que sejam iguais ao que você selecionou com o mouse, como podemos observar no *gif* a seguir:

![https://caelum-online-public.s3.amazonaws.com/2811-html-css-cabecalho-footer-variaveis-css/aula5-img1.gif](https://caelum-online-public.s3.amazonaws.com/2811-html-css-cabecalho-footer-variaveis-css/aula5-img1.gif)

.

Se quiser relembrar esse processo de transformação da paleta do projeto, recomendamos o vídeo [Como as variáveis CSS transformam meu projeto?](https://cursos.alura.com.br/extra/alura-mais/como-as-variaveis-css-transformam-meu-projeto--c1485), onde você pode reforçar os conceitos que aprendeu em aula. Você também pode conferir outras opções de sites para escolher sua paleta de cores através do [Para saber mais: escolhendo as cores do seu projeto](https://cursos.alura.com.br/course/html-css-ambiente-arquivos-tags/task/120614) , que está no curso 1 de HTML e CSS.

Além disso, você também pode alterar outros elementos através da criação das variáveis, como o tamanho ou peso das fontes, por exemplo. Lembre-se que explorar as ferramentas novas que conhecemos em aula é um passo que enriquece muito o aprendizado =)

Por aqui, escolhemos aplicar uma paleta bem colorida, que encontramos no [Color Hunt](https://colorhunt.co/). Caso queira utilizá-la, basta clicar [aqui](https://colorhunt.co/palette/fa7070fbf2cfc6ebc5a1c298). Observe o resultado na imagem abaixo:

![https://caelum-online-public.s3.amazonaws.com/2811-html-css-cabecalho-footer-variaveis-css/aula5-img2.png](https://caelum-online-public.s3.amazonaws.com/2811-html-css-cabecalho-footer-variaveis-css/aula5-img2.png)

A paleta de cores tem o poder de transformar a identidade do projeto. A que escolhemos aqui, por exemplo, poderia tranquilamente se tornar uma página sobre uma sorveteria, pois traz cores que remetem a esse tipo de negócio. E tudo o que fizemos aqui foi adicionar as cores de acordo com a nova paleta no seletor `:root`, pois as variáveis já estavam aplicadas ao longo do projeto, bastava alterar seus valores em um único lugar, como podemos ver no código a seguir:

```
:root {
    --cor-primaria: #FA7070;
    --cor-secundaria: #C6EBC5;
    --cor-terciaria: #FBF2CF;
    --cor-hover: #A1C298;
}
COPIAR CÓDIGO
```

E assim temos um projeto transformado!

E se você também transformou o seu, fique à vontade para compartilhá-lo conosco através do fórum ou de suas redes sociais marcando a Alura. Você pode nos encontrar nas redes nos seguintes perfis:

- [Instagram](https://www.instagram.com/aluraonline);
- [Twitter](https://twitter.com/AluraOnline);
- [LinkedIn](https://www.linkedin.com/school/aluracursos).

Vamos gostar muito de conhecer seu projeto =)