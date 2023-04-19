# Aula 03 - Justificando elementos

No vídeo anterior você aprendeu como alinhar elementos através do justify-content, comando responsável por justificar, formatando o posicionamento de acordo com o requisito do desenvolvedor. Agora imagine que você recebeu um código pronto, o qual, por apresentar erros não está funcionando. Além disso, também te enviaram imagens de como está e como deveria ser o projeto.

Analise o código e as imagens abaixo e marque a alternativa que resolva o problema corretamente.

```
main {
    display: flexbox;
    justify-content: center;
}COPIAR CÓDIGO
```

Como está:

![https://caelum-online-public.s3.amazonaws.com/2810-html-css/aula3-img1.png](https://caelum-online-public.s3.amazonaws.com/2810-html-css/aula3-img1.png)

Como deveria ser:

![https://caelum-online-public.s3.amazonaws.com/2810-html-css/aula3-img2.png](https://caelum-online-public.s3.amazonaws.com/2810-html-css/aula3-img2.png)

*Selecione uma alternativa*

`main {
        display: flex;
        justify-content: space-between;
}`

Correto! Com esse código o projeto passa a ser como deveria, ou seja, com os quadrados em linha, dentro do limite do `main` e separados por um espaço no meio. Ambas as propriedades foram utilizadas dentro do padrão Flexbox e no contexto certo.