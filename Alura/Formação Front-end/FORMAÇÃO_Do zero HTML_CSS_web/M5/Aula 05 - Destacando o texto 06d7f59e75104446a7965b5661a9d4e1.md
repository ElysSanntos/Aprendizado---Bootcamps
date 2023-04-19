# Aula 05 -  Destacando o texto

**Rafaella:** Olhando para o nosso *design*, já aplicamos os estilos de plano de fundo e decidimos a cor principal das nossas fontes.

Porém, o trecho "com um Front-End de qualidade!" em destaque no título está na cor azul.

Por isso definimos a *tag* `<strong>` em `index.html` para destacarmos essa parte. Como utilizaremos o CSS para estilizar com essa outra cor?

**Guilherme:** No arquivo `style.css`, pegamos a `body` que queríamos, abrimos chaves e dentro colocamos as duas propriedades.

Já que `strong` também é uma *tag*, poderemos pegá-la e indicar qual a cor iremos usar nesse trecho do texto com `color:`.

Pegaremos o valor hexadecimal dela no projeto do Figma, que é `#22D4FD` e colaremos na propriedade.

```
body {
    background-color: #000000;
    color: #F6F6F6;
}

strong {
    color: #22D4FD;
}COPIAR CÓDIGO
```

**Rafaella:** Vamos salvar e voltar à página atualizada no navegador para vermos o resultado.

![https://cdn1.gnarususercontent.com.br/1/308174/9b511153-76a7-480e-8234-b49598056d4d.png](https://cdn1.gnarususercontent.com.br/1/308174/9b511153-76a7-480e-8234-b49598056d4d.png)

**Guilherme:** Funcionou, mas se voltarmos ao Figma, notaremos que, durante todo o projeto, a maioria dos textos que aparecem possuem a cor branca `#F6F6F6`.

Já o trecho "com um Front-end de qualidade!" foi definido com `<strong>`. Mas se a colocarmos em outra parte do projeto, também irá alterar a cor?

**Rafaella:** Vamos testar para saber. No `index.html`, copiaremos a *tag* de destaque do trecho e a colaremos para destacar o trecho com as três tecnologias citadas no texto do parágrafo em `<p>`, "React, HTML e CSS". O restante ficará em branco mesmo.

```
<!DOCTYPE html>
<html lang="pt-br">

//código omitido

<body>
    <header</header>
    <main>
       <h1>Eleve seu negócio digital a outro nível <strong>com um Front-end de qualidade!</strong></h1>
        <p>Olá! Sou Joana Santos, desenvolvedora Front-end com especialidade em <strong>React, HTML e CSS</strong>. Ajudo pequenos negócios e designers a colocarem em prática boas ideias. Vamos conversar?
        </p>

//código omitido

    </main>
    <footer></footer>
</body>
</html>COPIAR CÓDIGO
```

**Rafaella:** Vamos salvar e analisar o resultado no navegador.

![https://cdn1.gnarususercontent.com.br/1/308174/364f4d67-2b19-4c64-8322-46e38a13b587.png](https://cdn1.gnarususercontent.com.br/1/308174/364f4d67-2b19-4c64-8322-46e38a13b587.png)

**Rafaella:** Veremos que a `<strong>` deixou na mesma cor azul claro que havíamos definido no CSS, portanto toda vez que ela for aplicada, terá a mesma cor.

**Guilherme:** Certo, mas não é o que queremos, pois teoricamente, se nosso projeto continuar evoluindo e o código aumentando, todas as partes de texto que tiverem essa *tag* terão a cor que definimos.

**Rafaella:** Caso queiramos depois criar um subtítulo com outro trecho em destaque em uma cor diferente, não poderemos usar a `<strong>`.

**Guilherme:** Exatamente, então precisaremos de uma forma para dizer que somente uma dessas *tags* usará o azul claro. Mas faremos isso mais adiante.