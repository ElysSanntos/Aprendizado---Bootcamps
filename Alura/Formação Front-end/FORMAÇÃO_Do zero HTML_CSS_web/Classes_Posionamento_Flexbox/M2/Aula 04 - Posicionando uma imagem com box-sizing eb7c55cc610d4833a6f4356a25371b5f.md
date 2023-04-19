# Aula 04 - Posicionando uma imagem com box-sizing

Você aprendeu no vídeo anterior que a propriedade box-sizing é responsável por como a largura e a altura totais de um elemento são calculadas. Diante disso, imagine que você está criando um projeto e se depara com um erro: a imagem utilizada está passando do limite do elemento pai. Em outras palavras, você quer que a imagem, elemento filho, “encolha” e se adeque ao conteúdo, elemento pai.

Utilize a imagem abaixo como exemplo da situação e marque a alternativa que resolva corretamente o problema:

![https://caelum-online-public.s3.amazonaws.com/2810-html-css/aula2-img1.png](https://caelum-online-public.s3.amazonaws.com/2810-html-css/aula2-img1.png)

*Selecione uma alternativa*

`box-sizing: border-box;
width: 100%;
padding: 5px;`

Correto! Neste caso a imagem (elemento filho) “encolheria” e se adequaria ao tamanho do conteúdo (elemento pai). Isso acontece porque o border-box informa ao navegador para contabilizar qualquer borda e preenchimento nos valores especificados para a largura e a altura de um elemento.