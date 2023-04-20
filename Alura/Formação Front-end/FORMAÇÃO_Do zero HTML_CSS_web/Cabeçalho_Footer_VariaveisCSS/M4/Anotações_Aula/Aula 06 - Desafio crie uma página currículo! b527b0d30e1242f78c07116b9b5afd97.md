# Aula 06 - Desafio: crie uma página currículo!

Agora que você aprendeu a criar outras páginas com HTML, queremos te desafiar!

Crie mais uma página em seu projeto e construa nela o seu currículo.

Você pode seguir a estrutura dos currículos tradicionais, com suas informações no topo e sua estrutura dividida em seções, ou você pode soltar sua criatividade e fazer algo totalmente diferente, fica a seu critério.

É importante que nessa página currículo você adicione uma imagem sua e crie pelo menos uma lista HTML, que contenha suas experiências de trabalho ou estudos.

Além disso, pode ser interessante adicionar outros projetos caso você tenha.

Lembre-se: não tenha medo de personalizar esta página, afinal é o seu currículo e quanto mais tiver “a sua cara”, melhor.

Agora é sua vez de criar, topa o desafio?

Criamos a seguinte página currículo:

![https://caelum-online-public.s3.amazonaws.com/2811-html-css-cabecalho-footer-variaveis-css/aula4-img1.png](https://caelum-online-public.s3.amazonaws.com/2811-html-css-cabecalho-footer-variaveis-css/aula4-img1.png)

Para isso, criamos um novo arquivo chamado **curriculo.html** e adicionamos seu link na barra de navegação do header. Dentro desse arquivo, criamos um `<main>` entre o `<header>` e o `<footer>`, onde criamos uma seção `Experiências` e uma seção `Estudos`. Aproveitamos as classes que já usamos no `index.html` para facilitar a estilização e adicionamos tanto as experiências como os estudos através das tags `<ul>` e `<li>`, que utilizamos para criar **listas** com HTML. Também inserimos links para os certificados de cada curso através da tag `<a>`, com a propriedade `href`. Estilizamos os links adicionando um `text-decoration: none` e um `color: #22D4FD` no CSS com a classe `.apresentacao__conteudo__texto a`, para que os links ficassem sem sublinhado e com a cor secundária do projeto. Por fim, adicionamos a imagem da “Joana Santos”. O resultado em código foi o seguinte:

```
<main class="apresentacao">
        <section class="apresentacao__conteudo">
            <h1 class="apresentacao__conteudo__titulo">Currículo</h1>
            <p class="apresentacao__conteudo__texto">
                Apresentação e informações principais
            </p>
            <h2 class="apresentacao__conteudo__titulo">Experiências</h2>
            <p class="apresentacao__conteudo__texto">
            <ul class="apresentacao__conteudo__texto">
                <li> Empresa tal (2020 - 2021) - fazia isso e aquilo </li>
                <li> Empresa tal (2021 - 2023) - fazia isso e aquilo </li>
            </ul>
            </p>
            <h2 class="apresentacao__conteudo__titulo">Estudos</h2>
            <div class="apresentacao__conteudo__texto">
            <ul class="apresentacao__conteudo__texto">
                <li>Curso tal - Alura Cursos <a href="linkdocertificado">com certificado</a> </li>
                <li>Curso tal - Alura Cursos <a href="linkdocertificado">com certificado</a></li>
                <li>Curso tal - Alura Cursos <a href="linkdocertificado">com certificado</a></li>
            </ul>
            </div>
        </section>
        <img src="./assets/imagem.png" alt="Foto da Joana Santos programando">
    </main>
COPIAR CÓDIGO
```

E a única adição no CSS foi a estilização dos links de certificado, como no seguinte bloco de código:

```
.apresentacao__conteudo__texto a{
    text-decoration: none;
    color: #22D4FD;
}
COPIAR CÓDIGO
```

Caso queira entender melhor como funcionam as listas HTML, você pode consultar a [documentação](https://www.w3schools.com/HTML/html_lists.asp).

Fez esse desafio?

Compartilhe conosco através do fórum ou das redes sociais, marcando a Alura =)