# Aula 05 - Para saber mais: mais de uma Media Querie

Sabia que você pode ter mais de uma media querie em seu projeto? É possível definir um tamanho de tela para o celular outro para o tablet e deixar a “padrão” para o desktop.

**Exemplo:**

Podemos definir uma largura máxima de “480px” para o celular: `@media (max-width: 480px)`, e em outra media querie definir uma largura máxima de “800px” para os tablets: `@media (max-width: 800px)`, e então atribuímos os ajustes necessários dentro de cada media querie, dessa forma teremos nosso site 100% responsivo.

Podemos também definir intervalos para os tamanhos de telas com um único Media querie, atribuímos o valor mínimo e depois o valor máximo separando ele pelo atributo **and**, veja: `@media (min-width: 480px ) and (max-width: 800px)`, nesse caso os estilos serão aplicados em telas de no mínimo “480px” e de no máximo “800px”.

Lembrando que a maioria dos acessos a internet hoje em dia é através dos dispositivos móveis, portanto, não se esqueça de sempre deixar os seus projetos e sites responsivos.

Para aprender mais, visite o site da Mozilla, e leia a documentação das media queries através deste [link](https://developer.mozilla.org/pt-BR/docs/Web/CSS/Media_Queries/Using_media_queries).