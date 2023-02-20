# Aula 10 - Para saber mais: Maven

Java é uma plataforma de desenvolvimento completa que se destaca com sua grande quantidade de projetos *open source*. Para a maioria dos problemas no dia a dia do desenvolvedor já existem bibliotecas para resolver. Ou seja, se você gostaria de se conectar com um banco dados, ou trabalhar no desenvolvimento web, na área de data science, criação de serviços ou Android, já existem bibliotecas para tal, muitas vezes mais do que uma.

Aí existe a necessidade de organizar, centralizar e versionar os JARs dessa biblioteca e gerenciar as dependências entre elas. Para resolver isso, foram criadas ferramentas especificas e no mundo Java se destacou o Maven. O Maven organiza os JARs (código compilado, código fonte e documentação) em um repositório central que é publico e pode ser pesquisado:

[https://mvnrepository.com/](https://mvnrepository.com/)

Lá você pode ver e até baixar os JARs, mas o melhor é que a ferramenta Maven pode fazer isso para você. Se ficou interessado em aprender o Maven que ainda tem outros recursos bem legais, dá uma olhada no nosso curso especifico:

[Maven: Build do zero a web](https://cursos.alura.com.br/course/maven-build-do-zero-a-web)

Obs: Se você é usuário Linux, o Maven é bem parecido com os gerenciadores `apt` ou `rpm`. No MacOS existe o `brew` com o mesmo propósito. No mundo .Net temos o `nuget` e a plataforma node.js usa `npm`. Gerenciar dependências é um problema do cotidiano do desenvolvedor, e cada sistema ou plataforma possui a sua solução.