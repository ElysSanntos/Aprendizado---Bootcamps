# Aula 04 - Cabeçalho responsivo

**Rafaela:** Agora já conseguimos modificar um pouco nosso estilo da página a partir do momento em que a tela fica menor, ou seja, para celulares e dispositivos com uma tela menor do que a que estamos usando. Nós conseguimos observar isso quando mudamos a largura da tela com a função disponível no inspecionar ou com o atalho "Ctrl + Shift + M".

Ao mudarmos a tela para 1200px de largura, ela muda para um design diferente. Agora vamos melhorar ainda mais esse design nos baseando no Figma que nós temos.

**Guilherme:** Uma coisa que está estranha quando eu olho, é o "Home" e o "Sobre mim" que estão na parte superior da tela. No Figma os dois estão bonitos e centralizados no mobile. Vamos fazer isso?

**Rafaela:** Vamos. Esses dois textos, no nosso `index.html`, nós chamamos pela classe `cabecalho`, que é o `<header>`. Então vamos abrir o `style.css`.

Na linha 24, nosso `.cabecalho` tem apenas um *padding*, quando nossa tela está maior. Esse padding é de 2% e o padding lateral é de 15%. Não tinha padding nem no lado direito, nem abaixo.

```
.cabecalho {
    padding: 2% 0% 0% 15%;
}COPIAR CÓDIGO
```

Nesse caso, podemos começar trocando esse espaçamento, então quando estivermos em dispositivos menores, teremos um padding diferente desse. Notamos que esse deixa nosso `header` muito para esquerda e um dos paddings acaba quebrando. O que acha que podemos fazer, Gui?

**Guilherme:** A primeira coisa é voltarmos no VS Code.

**Rafaela:** Então voltaremos para o `styles.css` e dentro do `@media` eu vou adicionar a classe `.cabecalho` na linha 123.

**Guilherme:** Estou com uma dúvida, Rafa. O apresentação geralmente vem abaixo do cabeçalho, no `@media` faz sentido mantermos?

**Rafaela:** Faz sentido.

**Guilherme:** Pensando mais em reutilizar.

Então vamos alterar o `padding`.

**Rafaela:** Quanto você acha que podemos colocar? Eu sinto que podemos definir um padding maior no topo.

**Guilherme:** Assim como no Figma.

**Rafaela:** Exatamente, ele tem bem mais espaço na parte superior da tela, depois podemos centralizar os dois elemento usando o flexbox.

**Guilherme:** Vamos colocar então 6% de padding.

**Rafaela:** Pode ser.

```
@media (max-width: 1200ox) {
    .cabecalho {
        padding: 6%;
    }

    .apresentacao {
        flex-direction: column;
    }
}COPIAR CÓDIGO
```

Salvamos e quando voltamos para nossa página, que está com a largura da tela menor que 1200px, reparamos que o padding já aumentou. Na lateral esquerda ele até diminuiu, mas como vamos alterar com o flexbox, não precisamos nos preocupar.

Acha que esse espaço é o suficiente?

**Guilherme:** Acho que podemos colocar mais.

**Rafaela:** Então vamos mudar para 10%. Quando observamos o projeto, vemos que ficou mais legal.

Agora conseguimos centralizar o "Home" e o "Sobre mim" usando o flexbox. Para isso vamos utilizar a classe da tag "pai" do Container. No caso, é o `.cabecalho__menu`, e nele usaremos o flexbox para centralizar

**Guilherme:** Esses dois elementos precisam estar juntos e centralizados, então será o `justify-content`, certo?

**Rafaela:** Perfeito.

Uma coisa muito importante quando estamos usando o *media query* é sempre analisarmos o que escrevemos anteriormente, porque se quisermos usar o flexbox, precisamos usar o `display: flex`.

Porém no `.cabecalho__menu`, que codamos na linha 28, já usamos o `display: flex` naturalmente, portanto não precisamos reescrever essa propriedade. Automaticamente ele vai obter essa informação do resto do nosso documento. Sendo assim, podemos usar apenas o `justify-content`.

```
@media (max-width: 1200px) {
    .cabecalho {
        padding: 10%;
    }

    .cabecalho__menu {
        justify-content: center;
    }

    .apresentacao {
        flex-direction: column;
    }
}COPIAR CÓDIGO
```

**Guilherme:** Notamos que o `justify-content` tem várias propriedades, como *baseline, center, end* e *first baseline*. Porém queremos o `center`.

**Rafaela:** Vamos salvar e voltar para nossa página para vermos como está.

**Guilherme:** Já ficou diferente, porque agora está centralizado.

**Rafaela:** Ficou bem legal.