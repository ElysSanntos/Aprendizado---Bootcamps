# Aula 04 - Estilizando os botões

**Rafaella:** Nesta aula, estilizaremos os **botões**.

**Guilherme:** Observando nosso código no VSCode, criamos o `.apresentacao__links` com `display: flex` para as duas *tags* âncoras, mas agora o processo será diferente, pois queremos estilizar os dois botões. Porém, o estilo de um é igual ao do outro.

No projeto do Figma, tanto o botão "Instagram" quanto o de "GitHub", ou ainda se criarmos mais, possuem as mesmas características: retângulo com vértices arredondados, fundo azul e usam a mesma fonte sem serifa.

**Rafaella:** Só muda o texto que definimos no HTML.

**Guilherme:** Exatamente, então uma ideia seria criarmos uma classe que será utilizada para ambos os botões.

**Rafaella:** No arquivo `index.html`, iremos à `<div>` da `class` igual a `"apresentacao__links"` e, na *tag* `<a>`, adicionaremos a nova classe chamada `"apresentacao__links__link"` antes de `href`.

Utilizaremos essa mesma `class` para a *tag* âncora seguinte.

```
//código omitido

    <main class="apresentacao">
        <section class="apresentacao__conteudo">

//código omitido

            <div class="apresentacao__links">
                <a  class="apresentacao__links__link" href="https://instagram.com/rafaballerini">Instagram</a>
                <a class="apresentacao__links__link" href="https://github.com/guilhermeonrails">Github</a>
            </div>
        </section>
        <img src="imagem.png" alt="Foto da Joana Santos programando">
    </main>
    <footer></footer>
</body>
</html>COPIAR CÓDIGO
```

**Rafaella:** Em nosso arquivo `style.css`, adicionaremos essa nova classe ao final do código para estilizarmos dentro das chaves.

**Guilherme:** Vamos começar pela cor de fundo que geralmente é feita com `background-color:`. Funciona também para a *tag* âncora?

**Rafaella:** Sim, funciona! Então podemos buscar no Figma qual é o valor hexadecimal ao clicarmos no botão, que no caso é `#22D4FD`. No arquivo CSS, adicionaremos o `background-color:` seguido deste valor que obtivemos.

Salvaremos e analisaremos o resultado no navegador.

```
//código omitido

.apresentacao__links__link {
    background-color: #22D4FD;
}COPIAR CÓDIGO
```

**Rafaella:** Com isso, já teremos a cor azul no fundo dos botões, mas ainda estão muito pequenos e diferentes do Figma.

Vamos continuar estilizando o botão pegando sua largura de `280px`. Copiaremos este valor e inseriremos na propriedade `width:` do arquivo CSS também.

**Guilherme:** O texto ainda está alinhado à esquerda, e precisamos centralizá-lo.

**Rafaella:** Para isso, teremos a propriedade `text-align:` com o valor `center` em `.apresentacao__links__link` para que fique alinhado ao centro.

Analisando o resultado no navegador, os escritos dos botões já estarão centralizados em suas áreas azuis, as quais ainda estão com as pontas em noventa graus.

**Guilherme:** Sim, pois no projeto final, esses retângulos possuem os vértices arredondados.

**Rafaella**: Têm sim, e este raio de arredondamento é estabelecido pela propriedade `border-radius:`, e no Figma veremos que seu valor é de `16px`.

Com isso, o resultado no navegador ficará mais parecido com o projeto.

**Guilherme:** Já está melhorando! Mas a fonte dos textos dos botões deve ser maior também, contendo `24px`.

**Rafaella:** Pegaremos este valor e adicionamos à propriedade `font-size:` no arquivo CSS.

**Guilherme:** Já ficou bem melhor!

**Rafaella:** Um ponto interessante que ainda está diferente do Figma é o espaço que há entre os limites do retângulo do botão e o texto central.

Lembrando do Box Model, queremos uma margem entre o conteúdo e a borda. Abriremos nosso projeto no navegador, clicaremos com o botão direito do mouse e escolheremos a opção "Inspecionar" para abrirmos a aba lateral.

Se passarmos o cursor e selecionarmos qualquer elementos, exibiremos a seleção no BoxModel da aba "Estilos". Se quisermos aumentar o espaço entre os elementos, precisaremos colocar um valor no `padding:`.

Para essa propriedade, iremos ao Figma, selecionaremos o conteúdo, apertaremos a tecla "Alt" e visualizaremos o valor das distâncias passando o mouse sobre a área que queremos alterar, que este caso será de `21.5px` em relação à base e o topo no botão "Instagram".

**Guilherme:** Vamos ver o conteúdo do "GitHub" também?

**Rafaella:** Também é `21.5px`, então adicionaremos o `padding:` com este valor.

Porém, já temos uma distância boa do texto até as bordas laterais, então não precisaremos alterá-la, e sim apenas no `top` e `bottom` relativos ao topo e à base respectivamente.

Até agora, selecionávamos apenas um valor para o `padding:`, e se escrevermos o valor de `21.5px` e salvarmos, essa distância será colocada para todos os lados da área.

Quando queremos apenas selecionar um dos eixos, inserimos dois valores: o primeiro sempre será relativo ao eixo vertical, enquanto o segundo é do horizontal. Como não alteraremos este último, deixaremos como zero mesmo.

```
//código omitido

.apresentacao__links__link {
    background-color: #22D4FD;
    width: 280px;
    text-align: center;
    border-radius: 16px;
    font-size: 24px;
    padding: 21.5px 0;
}COPIAR CÓDIGO
```

**Rafaella:** Feito isso, já veremos a diferença no projeto do navegador.

**Guilherme:** No Figma, os textos dos botões de "Instagram" e "GitHub" não estão sublinhados, diferente do que temos até agora. Vamos tirá-la também?

**Rafaella:** Esta linha abaixo dos conteúdos é um padrão quando estamos desenvolvendo, e teremos que tirar sua decoração.

**Guilherme:** Faltam duas coisas ainda: a cor do texto do botão e a fonte, pois se observarmos, a fonte está em um tom de azul um pouco mais escuro que a cor do fundo da área.

**Rafaella:** Ainda está como link clicável, então retiraremos o sublinhado da decoração com `text-decoration:` sendo `none` e daremos uma cor ao conteúdo com `color:` igual a `#000000`, cujo valor da cor preta também foi obtido do Figma.

Por fim, a fonte ainda está diferente, e descobrimos no Figma também que é a Montserrat que já importamos no projeto.

Portanto poderemos simplesmente fazer da mesma forma que aplicamos no parágrafo usando `font-family:` de `'Montserrat'` e retirando as serifas com `sans-serif`.

Como é a mesma do seletor de `.apresentacao__conteudo__texto`, apenas copiaremos a linha e colaremos na `.apresentacao__links__link`.

Com isso, nosso botão já estará bem parecido com o projeto final, muito mais bonito e interessante. Mas, se repararmos com atenção no texto dos links, notaremos que as letras deveriam ser mais grossas.

No Figma, as selecionaremos e veremos que, na aba lateral, mesmo a fonte sendo da família Montserrat na parte de "Text", perceberemos que a propriedade `font-weight:` relativa ao peso da fonte é de `600` no HTML da aba de "Inspect".

Ainda não importamos este tipo de fonte, que é um detalhe pequeno porém importante.

No navegador, buscaremos a página do Google Fonts e pesquisaremos a fonte "Montserrat" na barra de busca. Clicaremos nesta opção e, na lista mais adiante da página, procuraremos pelo peso de `600`.

Selecionaremos clicando no link de "Select SemiBold 600" ao lado da opção correta, e pegaremos o código HTML atualizado de `<style>` na parte de "Use on the web" ou "use na web" da aba lateral.

O copiaremos e o colaremos no `@import url()` do topo do arquivo CSS, colocaremos o `font-weight: 600` abaixo de `font-size` e salvaremos.

```
@import url('https://fonts.googleapis.com/css2?family=Krona+One&family=Montserrat:wght@400;600&display=swap');

//código omitido

.apresentacao__links__link {
    background-color: #22D4FD;
    width: 280px;
    text-align: center;
    border-radius: 16px;
    font-size: 24px;
    font-weight: 600;
    padding: 21.5px 0;
    text-decoration: none;
    color: #000000;
    font-family: 'Montserrat', sans-serif;
}COPIAR CÓDIGO
```

**Rafaella:** Observando o projeto no navegador, veremos se irá funcionar.

![https://cdn1.gnarususercontent.com.br/1/1319058/4053e60c-95b2-441a-a952-2f9b03a0966f.png](https://cdn1.gnarususercontent.com.br/1/1319058/4053e60c-95b2-441a-a952-2f9b03a0966f.png)

**Guilherme:** Ficou bem mais interessante, pois estava visualmente diferente.

**Rafaella:** Agora já estamos com nosso projeto bem mais parecido com o Figma.