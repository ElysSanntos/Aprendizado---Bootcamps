# Aula 05 - Posicionando os ícones

**Rafaella:** Alinharemos os ícones junto a seus respectivos textos dentro dos botões de redes sociais. Consegue imaginar como faremos isso?

**Guilherme:** Teremos que alterar o alinhamento e disposição de todos os elementos localizados dentro da *tag* `<a>`.

**Rafaella:** Por que justamente na *tag* `<a>`?

**Guilherme:** Porque precisamos alinhar tanto a imagem quanto o texto.

**Rafaella:** Exatamente. São os dois elementos filhos dessa *tag*. Normalmente, no Flexbox, alteramos o contêiner com as propriedades que costumamos usar. Também existem propriedades para os elementos filhos.

Acessaremos o arquivo `style.css`, no qual encontraremos a *tag* `<a>`. Faremos isso através da busca pela classe dela: `.apresentacao__links__link{}`. Qual propriedade usaremos para iniciar o Flexbox?

**Guilherme:** Para garantir que os elementos tenham uma disposição diferente através do Flexbox, utilizamos o `display: flex`.

**Rafaella:** Perfeito. Vamos inserir o `display: flex` junto ao seu ponto e vírgula. Essa inserção será feita entre os códigos `background-color` e `border`.

```
.apresentacao__links__link {
    /* background-color: #22D4FD; */
    display: flex;
    border: 2px solid #22D4FD;
    width: 378px;
    text-align: center;
    border-radius: 8px;
    font-size: 24px;
    font-weight: 600;
    padding: 21.5px 0;
    text-decoration: none;
    color: #F6F6F6;
    font-family: 'Montserrat', sans-serif;
}COPIAR CÓDIGO
```

**Guilherme:** Se consultarmos nossa página por meio do navegador, veremos que tanto os ícones quanto os textos foram movidos para o canto esquerdo do botão.

**Rafaella:** Sim, pois este é o padrão do Flexbox.

**Guilherme:** Agora precisamos alterar o alinhamento, informando aos elementos do botão que eles devem ser centralizados.

**Rafaella:** Para isso, utilizaremos qual propriedade?

**Guilherme:** O `justify-content`.

**Rafaella:** Isso mesmo. Consultaremos a [página do Flexbox Guide (ou "Guia do Flexbox")](https://css-tricks.com/snippets/css/a-guide-to-flexbox/) conforme já fizemos anteriormente. Nela vamos até a seção "justify-content", onde encontraremos o valor que devemos utilizar dentro da propriedade `justify-content` para que o nosso conteúdo fique centralizado no eixo horizontal: `center`.

Vamos lembrar que, no Flexbox, a direção padrão é *Row* (ou seja, já é horizontal). Portanto, basta que adicionemos ao CSS dos nossos botões o comando `justify-content: center`. Essa adição será feita entre os códigos `display` e `border`.

```
.apresentacao__links__link {
    /* background-color: #22D4FD; */
    display: flex;
    justify-content: center;
    border: 2px solid #22D4FD;
    width: 378px;
    text-align: center;
    border-radius: 8px;
    font-size: 24px;
    font-weight: 600;
    padding: 21.5px 0;
    text-decoration: none;
    color: #F6F6F6;
    font-family: 'Montserrat', sans-serif;
}COPIAR CÓDIGO
```

**Guilherme:** Temos outro problema: o ícone e o texto estão grudados. Se consultarmos o Figma, veremos que existe um pequeno espaço entre eles.

**Rafaella:** Sim. Acessaremos o [Figma do projeto](https://www.figma.com/file/NrzJacC887svMVfF9oC2jM/Portfolio-Projeto-2?node-id=0%3A1&t=yCXSvRLAGJl57Pxc-0) e clicaremos em um dos ícones de botão. Em seguida, direcionaremos o cursor para o texto à sua direita. O número que aparece em laranja é o valor do espaçamento em px entre o ícone e o texto. Neste caso, o valor é `16`. Utilizaremos este valor em uma propriedade específica. Qual seria ela?

**Guilherme:** Para adicionar espaço entre todos os elementos, usaremos o `gap`.

**Rafaella:** Perfeito. Retornaremos ao arquivo CSS onde, abaixo da propriedade `justify-content`, adicionaremos um `gap: 16px`.

```
.apresentacao__links__link {
    /* background-color: #22D4FD; */
    display: flex;
    justify-content: center;
    gap: 16px;
    border: 2px solid #22D4FD;
    width: 378px;
    text-align: center;
    border-radius: 8px;
    font-size: 24px;
    font-weight: 600;
    padding: 21.5px 0;
    text-decoration: none;
    color: #F6F6F6;
    font-family: 'Montserrat', sans-serif;
}
```

Salvaremos nosso código e voltaremos à nossa página aberta pelo navegador. Veremos que os ícones e textos estão agora centralizados no interior do botão, separados por um pequeno espaço entre eles.