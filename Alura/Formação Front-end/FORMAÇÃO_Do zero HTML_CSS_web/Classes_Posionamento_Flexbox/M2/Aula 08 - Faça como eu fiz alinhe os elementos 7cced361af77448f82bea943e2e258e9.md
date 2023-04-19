# Aula 08 - Faça como eu fiz: alinhe os elementos

# **HTML**

Antes de alinhar os itens no CSS temos que criar a classe lá no arquivo HTML. Para isso vamos na tag `<main>` e dentro delas adicionamos a propriedade `class`. Lembrando que como qualquer outra propriedade devemos utilizar o sinal de `=` para atribuir um valor, ou neste caso um nome, e o mesmo deve estar entre aspas duplas (“”). Acompanhe o código:

```
<main class=”apresentacao”>COPIAR CÓDIGO
```

Repare que definimos o nome da classe como apresentacao e não utilizamos acento nem o cedilha, seguindo assim as boas práticas citadas anteriormente.

# **CSS**

Agora que o código HTML está pronto, vamos alinhar os elementos no CSS. Para começar, utilizamos o seletor `.apresentacao` para selecionar apenas os elementos que estão dentro da nossa classe criada no conteúdo `main`. Após abrir e fechar as chaves, estrutura básica do CSS, vamos utilizar apenas duas linhas de código para conseguir o resultado final. Segue o código abaixo:

```
.apresentacao {
    display: flex;
    align-items: center;
}COPIAR CÓDIGO
```

Repare agora que utilizamos a propriedade `display` com o valor `flex` para podermos utilizar o flexbox em nossa estilização. Aí sim, de fato, escrevemos o `align-items` com o valor `center` para alinhar os elementos, centralizando-os em relação a si mesmo. E pronto! Temos o nosso código estruturado e funcional, com os elementos alinhados.

# **HTML**

```
<!DOCTYPE html>
<html lang="pt-br">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Portifolio</title>
    <link rel="stylesheet" href="style.css">
</head>
<body>
    <header></header>
    <main class="apresentacao">
        <h1>Eleve seu negócio digital a outro nível
            <strong class="titulo-destaque">com um Front-end de qualidade!
            </strong></h1>
            <p>Olá! Sou Joana Santos, desenvolvedora
            Front-end com especialidade em React, HTML e
            CSS. Ajudo pequenos negócios e designers a
            colocarem em prática boas ideias. Vamos
            conversar?</p>
            <a href="https://instagram.com/rafaballerini">Instagram</a>
            <a href="https://github.com/guilhermeonrails">GitHub</a>
            <img src="imagem.png" alt="Foto da Joana Santos programando">
    </main>
    <footer></footer>
</body>
</html>COPIAR CÓDIGO
```

# **CSS**

```
*{
    margin: 0;
    padding: 0;
}
body{
    height: 100vh;
    box-sizing: border-box;
    background-color: #000000;
    color: #F6F6F6;
}

.titulo-destaque{
    color: #22D4FD;
}
.apresentacao{
    display: flex;
    align-items: center;
}
```