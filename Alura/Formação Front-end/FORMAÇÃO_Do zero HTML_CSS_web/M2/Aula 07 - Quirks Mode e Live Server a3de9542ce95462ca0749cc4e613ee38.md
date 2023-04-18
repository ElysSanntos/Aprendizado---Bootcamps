# Aula 07 - Quirks Mode e Live Server

**Rafaela:** Temos uma página Web mais bonita, com todos os nossos elementos. Porém, ainda podemos brincar com esse código.

**Guilherme:** Exatamente. Quando seguimos a documentação de uma linguagem, sentimos uma certa desconfiança: será que se tirarmos uma propriedade indicada, conseguiremos ter o mesmo resultado?

Vamos alimentar a nossa curiosidade e mexer no código, tirando e colocando elementos de volta no lugar. Por exemplo, vamos retirar a primeira linha: o `<!DOCTYPE html>`.

**Rafaela:** Vamos. Esta linha foi indicada como importante para indicar a versão do HTML.

**Guilherme:** Isso. Vamos retirá-la e salvar o código.

```
<html>
    <head>
        <title>Portfolio</title>
    </head>
    <body>
        <h1>Isso é um título</h1>
        <p>Isso é um parágrafo</p>
        <img src="html.png" alt="Logo do HTML 5">
    </body>
</html>COPIAR CÓDIGO
```

**Rafaela:** Retornaremos ao navegador e atualizaremos a nossa página. Veremos que nada foi alterado. Aparentemente tudo está funcionando.

**Guilherme:** Aparentemente, contudo, houve sim uma alteração.

Existe uma forma de verificar o código HTML e CSS de qualquer página da internet. Para isso, na tela do navegador, clicaremos com o botão direito e selecionaremos a opção "Inspecionar". Neste instante, será aberta uma aba à direita da página Web, onde existe uma barra de menus superior. Nela, selecionaremos o menu "Elements". No interior deste menu será exibido o código-fonte da nossa página `index.html`.

Vamos acessar esse código-fonte e perceber que, quando passamos o cursor por cima de uma *tag*, o navegador realça o elemento correspondente diretamente na página Web. Vamos conferir se todos os elementos que codamos estão na página: `<html>`, `<head>`, `<title>`, `<body>`, `<h1>`, `<p>` e `<img>`.

Aparentemente, está tudo igual. Ou seja, a retirada do `<!DOCTYPE html>` não mudou a parte visual da nossa página. Contudo, ***houve uma alteração na forma como o navegador enxerga essa página***. Podemos ver a alteração dentro da própria aba "Inspecionar", selecionando o ícone de balão de comentário, localizado à direita da barra de menus superior. Este ícone aponta as *issues* da página. Após a seleção, será aberta uma aba secundária denominada "*Issues*", na parte inferior da aba "Inspecionar", a qual exibirá a seguinte mensagem:

> Page layout may be unexpected due to Quirks Mode
> 

Podemos traduzi-la como "O layout da página pode ser inesperado devido ao Modo Quirks". Ou seja, a página está em "modo peculiaridades". Não sabemos o que isso significa. Vamos clicar nesta mensagem para entender mais a fundo.

Abaixo da mensagem será exibida uma explicação mais detalhada do problema apontado,a qual apresentaremos uma versão resumida e traduzida:

> Um ou mais documentos desta página foram abertos em um modo diferente do esperado. O Modo Quirks existe por razões históricas. Caso ele tenha sido acionado de forma não intencional, adicione o <!DOCTYPE html> para renderizá-la sem o Modo Quirks.
> 

***Afinal, o que é o Modo Quirks?*** Vamos acessar o link disponibilizado acima, o qual nos direcionará para uma nova página. Na parte superior dela veremos o título "A página não tem o doctype HTML, acionando assim o Modo Quirks". Esta página possui várias informações e links sobre o Modo Quirk, o modo Standards, códigos-fonte, etc. Recomendamos que você a leia posteriormente.

Vamos resumir o problema: antigamente existiam dois grandes navegadores, o NetScape e o Internet Explorer. Quando codávamos, precisávamos informar para qual navegador a página estava sendo construída. Hoje em dia isso não é mais necessário, a não ser que seja algo intencional — como em casos de projetos antigos.

Na [página sobre Quirks Mode e Standards Mode](https://developer.mozilla.org/pt-BR/docs/Web/HTML/Quirks_Mode_and_Standards_Mode) existe a seção "Como os navegadores determinam qual modo usar?", onde há uma explicação sobre a questão da determinação de modos. Nela veremos que, para informarmos ao navegador que utilizaremos o HTML5, precisamos adicionar o `<!DOCTYPE html>`.

**Rafaela:** Atualmente, todos os navegadores sabem utilizar o HTML5.

**Guilherme:** Isso mesmo. Vamos sair do modo peculiaridades.

**Rafaela:** Vamos fechar as abas de explicação e a aba "Inspecionar". Em seguida retornaremos ao VS Code.

**Guilherme:** Para sair desse modo, pressionaremos "Ctrl + Z" para recuperar o DOCTYPE que havíamos deletado.

```
<!DOCTYPE html>
<html>
    <head>
        <title>Portfolio</title>
    </head>
    <body>
        <h1>Isso é um título</h1>
        <p>Isso é um parágrafo</p>
        <img src="html.png" alt="Logo do HTML 5">
    </body>
</html>COPIAR CÓDIGO
```

Salvaremos esse código e voltaremos ao nosso projeto aberto no navegador. Nele pressionaremos "F5" para atualizar a página e abriremos novamente a aba "Inspecionar". Veremos que, à direita da barra de menus, não existe mais o ícone de *issues*.

Existe um ponto que incomoda em nossa página: ***a necessidade de atualizá-la sempre que alteramos o código***.

**Rafaela:** Vamos adicionar uma **extensão** ao nosso editor de código para que ocorram atualizações automáticas na nossa página a cada salvamento. Acessaremos a coluna lateral esquerda do nosso VS Code, onde selecionaremos o ícone "*Extensions*" ("Extensões"). Podemos acessá-lo também por meio do atalho "Ctrl + Shift + X".

Neste momento, o explorador de arquivos será substituído por um campo de busca. Nele digitaremos "*live server*" e faremos a busca. Nos resultados abaixo do campo, buscaremos a opção "*Live Server*", a qual possui milhões de *downloads*.

**Guilherme:** Muitas pessoas a utilizam.

**Rafaela:** Nós, inclusive. Após a seleção, essa extensão será aberta na tela principal do VS Code, onde clicaremos no botão "*Install*". Após o término da instalação, Ela será habilitada automaticamente. Caso contrário, basta clicar no botão "*Enable*". Em seguida fecharemos a aba dessa extensão.

Existem extensões para milhares de tarefas, inclusive para embelezar sintaxes de linguagens específicas. Podemos explorá-las e utilizá-las sempre que quisermos.

**Guilherme:** Como a extensão funciona?

**Rafaela:** Agora temos um botão na barra inferior do VS Code denominado "*Go Live*". Como o arquivo HTML selecionado, clicaremos neste botão. Uma aba de Alerta de Segurança será aberta pelo nosso sistema, na qual selecionaremos a opção "Permitir acesso". Neste momento será aberta uma aba com a nossa página HTML no nosso navegador.

**Guilherme:** Vamos manter as duas abas abertas. Veremos que ambas estão rodando de locais diferentes: a antiga está rodando no local do arquivo, enquanto a nova (com *live server* ativo) exibe a URL com um número constituído de 10 dígitos.

Retornando ao VS Code, alteraremos o parágrafo adicionando "interessante" ao final da frase.

```
        <p>Isso é um parágrafo interessante</p>COPIAR CÓDIGO
```

Salvaremos esse código e voltaremos ao navegador. Na aba nova, veremos a nossa alteração.

**Rafaela:** Na aba antiga, a mudança só aparecerá se atualizarmos a página.

**Guilherme:** A principal vantagem do *live server* é não precisar atualizar a página a todo momento.

**Rafaela:** O único passo necessário é salvar o arquivo no editor.