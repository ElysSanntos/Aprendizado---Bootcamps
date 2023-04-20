# Aula 04 - Buscando arquivos em pastas

Aprendemos que uma prática comum no desenvolvimento com HTML e CSS é criar uma pasta `assets` para inserir todas as imagens do projeto. No entanto, quando buscamos alguma imagem através da tag `img` no HTML, precisamos nos atentar ao caminho desse arquivo que está dentro de pastas. Com isso em mente, observe a organização das pastas do projeto à seguir:

![https://caelum-online-public.s3.amazonaws.com/2811-html-css-cabecalho-footer-variaveis-css/aula2-img1.png](https://caelum-online-public.s3.amazonaws.com/2811-html-css-cabecalho-footer-variaveis-css/aula2-img1.png)

Você precisa que o arquivo `montanha.png`, localizado dentro da pasta `assets` do projeto, seja exibido no HTML e para isso cria o código à seguir:

```
<div class="container">
<img src="montanha.png" alt="imagem de uma montanha">
</div>COPIAR CÓDIGO
```

Dado o código, assinale a afirmação correta sobre o que ocorrerá com a imagem na exibição da página:

*Selecione uma alternativa*

A imagem irá quebrada e será exibido apenas o texto alternativo, já que o link da imagem em `src` está incorreto.

O HTML não irá encontrar a imagem pois o link em `src` deveria considerar que a imagem está dentro de uma pasta, portanto o link correto deveria ser `assets/montanha.png`. Devemos sempre estar atentos à organização das pastas quando queremos buscar um arquivo através de seu caminho.