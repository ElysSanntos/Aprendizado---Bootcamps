# Aula 05 - Para saber mais: Padding

Observe a imagem a seguir:

![https://caelum-online-public.s3.amazonaws.com/2811-html-css-cabecalho-footer-variaveis-css/aula3-img1.png](https://caelum-online-public.s3.amazonaws.com/2811-html-css-cabecalho-footer-variaveis-css/aula3-img1.png)

A tela acima apresenta os botões que criamos em nosso projeto para acessar as redes sociais. No entanto, podemos perceber que o ícone e o texto dentro de cada botão ficou “espremido” pelas bordas, o que desfavorece o visual do projeto.

Todos os botões têm conteúdos: um ícone e o texto com o nome da rede social. Além disso, todos os botões possuem uma borda fina em azul. Portanto, precisamos adicionar alguma propriedade que faça com que haja um espaço entre o conteúdo e as bordas do botão, para obtermos o seguinte resultado:

![https://caelum-online-public.s3.amazonaws.com/2811-html-css-cabecalho-footer-variaveis-css/aula3-img2.png](https://caelum-online-public.s3.amazonaws.com/2811-html-css-cabecalho-footer-variaveis-css/aula3-img2.png)

Bem melhor não é? Mas você sabe qual propriedade nos ajudou a definir a distância entre o conteúdo e a borda?

Se você pensou no `padding`, acertou!

O Padding é responsável por definir a distância entre um conteúdo e suas bordas. No caso do nosso projeto, adicionamos um `padding: 21.5px 0`, que já foi suficiente para criar um espaço interno mais amplo nos botões. Essa propriedade é extremamente útil pois garante que exista esse espaço de “respiro” entre as bordas e o conteúdo, deixando o visual mais limpo e harmônico.

Para entender melhor ainda como o `padding` funciona, você pode consultar a [documentação](https://www.w3schools.com/csS/css_padding.asp).