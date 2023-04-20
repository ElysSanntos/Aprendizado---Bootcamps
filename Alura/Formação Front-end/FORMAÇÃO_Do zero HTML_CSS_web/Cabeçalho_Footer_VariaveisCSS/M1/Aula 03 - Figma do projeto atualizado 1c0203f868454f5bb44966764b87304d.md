# Aula 03 - Figma do projeto atualizado

**Guilherme:** Iniciaremos um novo desafio: atualizar a nossa aplicação. No mundo real, geralmente desenvolvemos uma tela, assim como fizemos, e de repente precisamos atualizá-la, incluindo novas funcionalidades.

Sistemas de software, páginas Web e aplicações geralmente passam por atualizações.

**Rafaella:** Principalmente em momentos de alta nas vendas, como na Black Friday. Nestas datas, empresas de *e-commerce* enviam *landing pages* para que modifiquemos, adicionando chamadas de desconto. É bem comum recebermos no dia-a-dia pedidos de atualização de projetos.

**Guilherme:** Traremos acontecimentos do mundo real para esse curso. Não somos um *e-commerce*, mas temos uma atualização a ser implementada. O nosso projeto evoluirá um pouco mais: ***ele terá uma nova tela***.

Vamos acessar o [Figma do nosso projeto em sua nova etapa](https://www.figma.com/file/NrzJacC887svMVfF9oC2jM/Portfolio-Projeto-2?node-id=0%3A1&t=PMVfvZa872DqgZIK-0).

![https://cdn1.gnarususercontent.com.br/1/1319057/7ee7d76b-91d7-46dd-96da-b3e97e0f9613.png](https://cdn1.gnarususercontent.com.br/1/1319057/7ee7d76b-91d7-46dd-96da-b3e97e0f9613.png)

Temos botões com ícones em seu interior. O que visualmente chama mais a atenção, Rafa?

**Rafaella:** Os botões, definitivamente. Também temos o novo subtítulo "Acesse minhas redes", que antes eram completamente ciano. Agora eles possuem apenas uma borda nesta cor. Temos também ícones nos botões.

**Guilherme:** Estes elementos estão nas cores que estamos utilizando.

**Rafaella:** Exato.

**Guilherme:** Agora temos também na parte superior os menus "Home" e "Sobre mim".

**Rafaella:** Nós já desenvolvemos o `<header>`, agora vamos adicionar em seu interior todas as nossas *tags* para criar o cabeçalho de fato. Nós o adicionamos e o deixamos vazio somente para entender onde ele deveria ficar.

**Guilherme:** O mesmo vale para o `<footer>` (ou "rodapé"). Onde está escrito "Desenvolvido por Alura", você pode adicionar seu nome.

Além dessa, temos uma página nova, que será acessada quando clicarmos no menu "Sobre mim".

![https://cdn1.gnarususercontent.com.br/1/1319057/49008f5f-f397-4f16-acae-6a621d1f20d5.png](https://cdn1.gnarususercontent.com.br/1/1319057/49008f5f-f397-4f16-acae-6a621d1f20d5.png)

Nela, o cabeçalho e o rodapé continuam iguais. O que muda é o conteúdo principal, do meio da tela. Teremos a chance de criar uma biografia, onde poderemos escrever um pouco sobre nós. Por isso, o texto que incluímos no Figma e no curso é ***ilustrativo***.

**Rafaella:** É importante salientar que, quando recebemos um design para trabalhar, é comum que haja nele esse tipo de texto chamado ***Lorem ipsum***. Ele serve para nos mostrar como o texto final fica disposto na página, sem precisarmos acessar o texto verdadeiro, o qual às vezes nem foi produzido ainda.

**Guilherme:** Vamos comparar as duas páginas?

**Rafaella:** Vamos sim.

**Guilherme:** Os estilos das duas páginas são parecidos, utilizam os mesmos estilos.

**Rafaella:** Exatamente, a mudança está nas disposições e nos tamanhos do texto. A foto também é a mesma.

**Guilherme:** Com base no que já aprendemos, é possível deduzir os estilos de cada trecho: o "Sobre mim" seria um `<h1>`, e os blocos de biografia seriam dois blocos de parágrafo. Nós nos pegamos pensando se vamos utilizar um Flexbox na horizontal ou na vertical. Isso é muito comum. Com a prática, aos poucos, desenvolvemos esse tipo de percepção e passamos a aplicá-la em todas as páginas que vemos.

A seguir, começaremos a criar esta nova etapa do nosso projeto.