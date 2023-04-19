# Aula 06 - Para saber mais: destacando o texto

**Para saber mais: destacando o texto**

Você aprendeu a destacar o texto utilizando a tag `<strong>`, porém existe outra tag que também é muito utilizada para isso que é a tag `<span>`, diferente da strong a span não deixa em negrito por padrão mas é uma ótima forma de marcar trechos do texto em HTML. Veja:

**HTML:**

```
<h1>Formação de <span>Front-end</span></h1>COPIAR CÓDIGO
```

**CSS:**

```
h1{
            font-weight: bold;
}

span{
            color: #22D4FD;
            border: 1px solid #22D4FD;
            padding: 10px;
}COPIAR CÓDIGO
```

**Explicando o código acima:**

font-weight: bold; (Texto em negrito)

color: #22D4FD; (Cor do texto azul)

border: 1px solid #22D4FD; (Borda com 1 px de largura, do tipo sólida e cor da borda azul)

padding: 10px; (Espaçamento interno de 10px)

**RESULTADO:**

![https://caelum-online-public.s3.amazonaws.com/2808-html-css-ambiente-arquivos-tags/aula5-img5.png](https://caelum-online-public.s3.amazonaws.com/2808-html-css-ambiente-arquivos-tags/aula5-img5.png)