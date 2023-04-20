# Aula 04 - Aplicando o REM

**Guilherme:** Agora que entendemos que codando com `rem` nós acompanhamos a unidade de medida do navegador, vamos aplicar isso para os nossos próximos textos, porque acho isso importante.

**Rafaela:** Vou abrir o nosso arquivo `styles.css`, e em todos os lugares que tivermos `font-size` faremos o cálculo da medida de pixel para rem.

**Guilherme:** Nós podemos procurar com "**Ctrl + F**", que é o atalho para encontrar uma palavra rapidamente no navegador, e pesquisamos "font-size", que já encontraremos todos.

**Rafaela:** Boa ideia! Então quando procuramos, descobrimos que temos seis resultados.

O primeiro está no `.cabecalho__menu__link`. Nós temos 24px, e ao dividirmos por 16px temos 1.5rem.

```
.cabecalho__menu__link {
    font-family: var(--font-secundaria);
    font-size: 1.5rem;
    font-weight: 600;
    color: var(--cor-terciaria);
    text-decoration: none;
}COPIAR CÓDIGO
```

Vamos salvar e vamos para o próximo, clicando na seta para baixo na barra de busca, que é o segundo ícone do lado direito. O seguinte é o título, que já tínhamos alterado. Clicando na seta para baixo novamente, temos o `.apresentacao__conteudo__texto`, com o valor de 24px novamente, ou seja, mudamos para 1.5rem.

```
.apresentacao__conteudo__texto {
    font-size: 1.5rem;
    font-family: var(--font-secundaria);
}COPIAR CÓDIGO
```

O próximo é o `.apresentacao__links__subtitulo`, que também tem 24px:

```
.apresentacao__links__subtitulo {
    font-family: var(--fonte-primaria)
    font-weight: 400;
    font-size:1.5rem;
}COPIAR CÓDIGO
```

Em seguida temos o `.apresentacao__links__link`, que é o botão com os links. Ele também tem o font-size de 24px, então mudamos para `1.5rem`. Por fim temos o rodapé, que também vamos mudar para `font-size: 1.5rem;`.

Feita essas alterações, podemos voltar para nossa página de portfólio no navegador e analisar como ficou, e se nossas mudanças fizeram sentido.

**Guilherme:** Inicialmente está igual, que é o que queríamos.

**Rafaela:** Isso. Então vamos fazer o teste se funcionou o que queríamos fazer. Vou deixar a página de portfólio ocupando apena a lateral esquerda e a página com as configurações de aparência na lateral direita.

**Guilherme:** Estamos usando o padrão recomendado no tamanho da fonte, que é o médio. Vamos deixar como "Muito grande", já exagerando mesmo no tamanho.

Quando mudamos percebemos que os textos da nossa página do portfólio se adaptam, então está tudo funcionando, certo, Rafa?

**Rafaela:** Sim, está tudo funcionando.

**Guilherme:** Vamos deixar um pouco menor, deixa apenas no "Grande". O texto já diminui. Se mudarmos para o "Médio" ele diminui mais um pouco.

**Rafaela:** E continua diminuindo quando optamos pelos tamanhos de fonte "Pequeno" e "Muito pequeno".