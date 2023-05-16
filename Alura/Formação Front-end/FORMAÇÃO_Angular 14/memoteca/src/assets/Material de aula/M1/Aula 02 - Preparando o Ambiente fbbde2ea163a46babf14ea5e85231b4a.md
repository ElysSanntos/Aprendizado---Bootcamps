# Aula 02 - Preparando o Ambiente

## **Ambiente de desenvolvimento**

Neste curso, vamos conhecer vários recursos do Angular CLI, uma interface de linha de comando usada para facilitar a construção de aplicações, desde a criação de um projeto, estrutura base, criação de componentes, de serviços e com o build da aplicação.

Para instalar o Angular CLI (versão do curso 14.0) é necessário ter o [NodeJS](https://nodejs.org/) (versão do curso 16.14.2) na última versão recomendada instalado e usaremos o [VSCode](https://code.visualstudio.com/download) como editor de código.

Recomendamos fortemente que você use as mesmas versões utilizadas no curso para obter melhor aproveitamento e evitar erros por incompatibilidade.

Para instalar o Angular CLI, abra seu terminal e utilize o seguinte comando:

```
npm install -g @angular/cli@14.0.0
```

Após instalarmos a ferramenta vamos usá-la para criar o projeto [memoteca, clique aqui e acesse o figma do projeto](https://www.figma.com/file/YTSUBbe7Zgwx3L567TAzTc/Memoteca---Angular%3A-Come%C3%A7ando-com-o-Framework?node-id=148%3A26), em seguida vá até o diretório que deseja construir sua aplicação e execute o comando a seguir:

```
ng new memoteca
```

Durante a instalação, será necessário responder duas perguntas. A primeira será se deseja criar um arquivo responsável pelo gerenciamento das rotas, vamos responder sim, e a segunda será sobre qual estilo deseja usar no projeto, escolha o CSS.

Com o projeto criado, vamos ver como é a cara inicial deste projeto? Para isso, vamos usar o comando `cd memoteca` para entrar no diretório do projeto e com a ajuda do CLI, usar o comando `ng serve` para executar o projeto.

Tudo ocorreu bem? Sim? Abra seu navegador e acesse o `http://localhost:4200`.

Como nosso foco é explorar o Angular, vamos disponibilizar todo o CSS e os arquivos necessários para o projeto:

- Disponibilizar CSS e Assets do projeto [link do repositório Git ou Drive](https://github.com/alura-cursos/2438-angular-memoteca/tree/aula-6/src);
- [Imagens utilizadas para construção do background](https://caelum-online-public.s3.amazonaws.com/2438-angular-comecando-framework/01/imagens-angular.zip).