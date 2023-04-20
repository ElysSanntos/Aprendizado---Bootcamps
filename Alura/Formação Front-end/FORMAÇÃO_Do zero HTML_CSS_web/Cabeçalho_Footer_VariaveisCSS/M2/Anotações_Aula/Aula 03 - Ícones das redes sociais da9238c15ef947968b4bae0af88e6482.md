# Aula 03 - Ícones das redes sociais

**Guilherme:** Vamos inserir os ***ícones*** em nossos links. Em nosso código, temos links de duas redes: o Instagram e o Github.

**Rafaella:** Isso. Já no Figma, temos três: Github, LinkedIn e Twitch. Vamos atualizar com base no Figma. Contudo, você pode atualizar com as suas próprias redes!

Voltando ao VS Code, acessaremos novamente o arquivo `index.html` para trazer as imagens dos ícones, considerando que já sabemos como criar a *tag* `<img>`.

Primeiro, vamos realizar os passos abaixo:

- deletar a *tag* `<a>` correspondente ao Github;
- alterar o texto do primeiro `<a>`, de "Instagram" para "Github", substituindo o endereço do Instagram por um endereço de Github;
- separar a *tag* de abertura `<a>`, o texto "Github" e a *tag* de fechamento `</a>`, pressionando "Enter" entre elas, deixando uma linha vazia acima do texto.

Nesta linha vazia adicionaremos a *tag* `<img>`.

```
//código omitido

    <main class="apresentacao">
        <section class="apresentacao__conteudo">

//código omitido

            <div class="apresentacao__links">
                <h2 class="apresentacao__links__subtitulo">Acesse minhas redes:</h2>
                <a  class="apresentacao__links__link" href="https://github.com/rafaballerini">
                    <img>
                    Github
                </a>
            </div>
        </section>
        <img src="imagem.png" alt="Foto da Joana Santos programando">
    </main>
    <footer></footer>
</body>
</html>COPIAR CÓDIGO
```

O que faremos para trazer a nossa imagem?

**Guilherme:** Precisamos especificar o local em que essa imagem está. Já fizemos o download de todas as imagens com os ícones das redes que precisamos.

**Rafaella:** Inclusive de alguns que não utilizaremos no projeto, mas que disponibilizamos para que sejam utilizados.

**Guilherme:** Acessaremos o explorador do nosso sistema operacional. Abriremos a pasta onde se encontram as imagens, e em seguida vamos selecioná-las e arrastá-las para o explorador do VS Code. Neste momento, todas as imagens serão coladas no projeto e ficarão dispostas aleatoriamente entre os arquivos.

Como boa prática, criaremos uma pasta para isolar todas as imagens do restante dos arquivos.

**Rafaella:** No topo do explorador, clicaremos no ícone de pasta denominado "New Folder" (ou "Novo Arquivo"). No campo de texto que será aberto, digitaremos o nome da nova pasta. Vamos nomeá-la "assets" pois é um nome muito utilizado nos projetos reais.

Pelo explorador, arrastaremos cada uma das imagens para dentro da pasta "assets".

> Observação: A imagem que já havíamos utilizado, denominada imagem.png, será realocada. Portanto, precisamos informar no código o novo local em que ela se encontra. Para isso, acessaremos a linha dessa <img> e substituiremos dentro de src o local antigo ("imagem.png") pelo local novo: "./assets/imagem.png".
> 

```
//código omitido

        </section>
        <img src=".assets/imagem.png" alt="Foto da Joana Santos programando">
    </main>
    <footer></footer>
</body>
</html>COPIAR CÓDIGO
```

**Guilherme:** Informaremos o caminho da imagem que vamos inserir — ou seja, o ícone do Github. Voltaremos à nova *tag* `<img>` e antes do sinal de menor adicionaremos um `src=""`, o qual possuirá entre as aspas duplas o endereço `.assets/github.png`.

```
//código omitido

    <main class="apresentacao">
        <section class="apresentacao__conteudo">

//código omitido

            <div class="apresentacao__links">
                <h2 class="apresentacao__links__subtitulo">Acesse minhas redes:</h2>
                <a  class="apresentacao__links__link" href="https://github.com/rafaballerini">
                <img src=".assets/github.png">
                Github
                </a>
            </div>
        </section>
        <img src=".assets/imagem.png" alt="Foto da Joana Santos programando">
    </main>
    <footer></footer>
</body>
</html>COPIAR CÓDIGO
```

**Rafaella:** Para adicionar os outros ícones e botões, copiaremos a estrutura da *tag* `<a>` e colaremos duas vezes, uma embaixo da outra, já que utilizaremos a mesma classe, `apresentacao__links__link`, para as três.

Em seguida modificaremos o conteúdo de `href`, de `src` e do texto para que correspondam à cada rede social: acima o Github, no meio o LinkedIn, e embaixo a Twitch.

> Atenção ao endereço de cada rede social, pois elas possuem padrões diferentes. Por exemplo, o endereço base do LinkedIn é "linkedin.com/in/nome-da-pessoa".
> 

```
//código omitido

    <main class="apresentacao">
        <section class="apresentacao__conteudo">

//código omitido

            <div class="apresentacao__links">
                <h2 class="apresentacao__links__subtitulo">Acesse minhas redes:</h2>
                <a  class="apresentacao__links__link" href="https://github.com/rafaballerini">
                    <img src=".assets/github.png">
                    Github
                </a>
                <a  class="apresentacao__links__link" href="https://linkedin.com/in/rafaellaballerini">
                    <img src=".assets/linkedin.png">
                    LinkedIn
                </a>
                <a  class="apresentacao__links__link" href="https://twitch.tv/guilimadev">
                    <img src=".assets/twitch.png">
                    Twitch
                </a>
            </div>
        </section>
        <img src=".assets/imagem.png" alt="Foto da Joana Santos programando">
    </main>
    <footer></footer>
</body>
</html>COPIAR CÓDIGO
```

Salvaremos o nosso código e retornaremos ao navegador, onde veremos nossa página com os três botões, "Github", "LinkedIn" e "Twitch", com seus respectivos ícones à esquerda. Entretanto, eles estão desalinhados em relação ao texto (alguns para cima, outros para baixo). Precisamos ***modificar a estilização de posicionamento dos nossos dois elementos*** que estão dentro de cada botão.

**Guilherme:** Faremos isso na sequência.