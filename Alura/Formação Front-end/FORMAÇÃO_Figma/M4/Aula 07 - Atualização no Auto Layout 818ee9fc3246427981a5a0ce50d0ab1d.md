# Aula 07 - Atualização no Auto Layout

No último vídeo, estudamos a funcionalidade do *autolayout*, ferramenta muito interessante para padronizar a criação na ferramenta *Figma*.

## **Atualização no *autolayout***

Você deve ter notado que o seu autolayout está um pouco diferente em relação aos vídeos deste curso. O Figma é uma plataforma que sempre se atualiza para evoluir. Sendo assim, houve atualizações na ferramenta desde a gravação do curso até o momento atual.

Este vídeo foi feito justamente para te mostrar o que mudou e te tranquilizar quanto às atualizações. As mudanças não foram tão significativas na estrutura, de modo que você não reconheça a interface. Ocorreram apenas algumas mudanças de posição dos elementos.

Vamos utilizar uma captura do vídeo sobre autolayout deste curso para entender como era esta funcionalidade antes da atualização.

![https://cdn1.gnarususercontent.com.br/1/1310271/59a03d18-b3ec-4c6f-a492-2df9d9e435ba.png](https://cdn1.gnarususercontent.com.br/1/1310271/59a03d18-b3ec-4c6f-a492-2df9d9e435ba.png)

Note que antes tínhamos a seção "**Auto layout**" no painel Design, localizado na lateral direita da interface. Logo abaixo, ficava a seção "*Constraints and resizing*" ("Restrições e redimensionamento").

Analisando o componente "Avatar", identificamos uma mudança na localização das seguintes opções da área de restrições e redimensionamento:

- "*Left*" ("Esquerda");
- "*Fill container*" ("Preencher contêiner");
- "*Hug contents*" ("Juntar conteúdos").

> Primeiro componente "Avatar":
> 

![https://cdn1.gnarususercontent.com.br/1/1310271/9ccaf1e1-68a9-4b17-9bff-48b8b69dfa99.png](https://cdn1.gnarususercontent.com.br/1/1310271/9ccaf1e1-68a9-4b17-9bff-48b8b69dfa99.png)

Agora, em vez de estarem em uma categoria separada abaixo da antiga seção "Auto layout", essas informações estão no topo do painel Design, na seção "*Frame*" ("Quadro"). A seção "Constraints and resizing" deixou de existir.

![https://cdn1.gnarususercontent.com.br/1/1310271/5f19661a-861d-4000-ad65-4070d6937e13.png](https://cdn1.gnarususercontent.com.br/1/1310271/5f19661a-861d-4000-ad65-4070d6937e13.png)

Nos campos `X` e `Y`, temos dados relativos ao posicionamento do frame. Em `W` e `H` temos, respectivamente, informações de largura e altura. Logo abaixo, podemos definir as configurações de redimensionamento, tanto vertical quanto horizontal; temos duas opções: "Hug contents" ("Juntar conteúdos") ou "*Fixed width/Fixed height*" ("Largura fixa/Altura fixa").

Faz sentido manter as propriedades de tamanho e de posição juntas. Se quisermos, por exemplo, definir que determinado conteúdo é fixo, a lógica é que essa opção fique próxima aos campos de tamanho (`W` e `H`).

Além disso, foi criada a estrutura "Caixa", formada por um bloco retangular branco que se trata de um autolayout, contendo o componente "Avatar", também um autolayout.

Quando temos um autolayout contido em outro, o interno terá a opção "*Fill container*", além das mencionadas anteriormente. Ao ativá-la, o componente irá ocupar toda a largura da caixa. Dessa forma, podemos redimensionar a caixa para maior ou menor e o componente interno irá se adaptar.

A seção "Auto layout" também sofreu alterações. Antes ela era formada apenas por uma linha contendo dois ícones e dois campos de redimensionamento. Agora essas informações estão dispostas verticalmente à esquerda, com um caixa para alinhamento à direita. Veja abaixo a comparação:

![https://cdn1.gnarususercontent.com.br/1/1310271/4a677c64-f5ff-433e-8c50-8a193836e4a0.png](https://cdn1.gnarususercontent.com.br/1/1310271/4a677c64-f5ff-433e-8c50-8a193836e4a0.png)

Clicando no ícone de reticências no canto superior direito da seção, encontramos duas opções de modo de espaçamento: "*Packed*" ou "*Space between*". A diferença entre eles é que, no segundo modo, o espaço entre os elementos é calculado automaticamente, conforme o tamanho da caixa e a quantidade de elementos.

![https://cdn1.gnarususercontent.com.br/1/1310271/35070787-72bd-4d98-b3d8-a0ec5e436e68.png](https://cdn1.gnarususercontent.com.br/1/1310271/35070787-72bd-4d98-b3d8-a0ec5e436e68.png)

Por fim, tivemos algumas atualizações nas funcionalidades da seção de autolayout. **Por exemplo:** no segundo componente "Avatar", exibido abaixo, os elementos se sobrepõem. Isso acontece devido à possibilidade de o espaçamento entre cada um deles ser negativo.

> Também podemos definir isso na aba "Advanced auto layout settings" (ícone …), ou "Configurações avançadas de autolayout", alterando entre as opções "First on top" ("Primeiro no topo") e "Last on top" ("Último no topo") da categoria "Canvas stacking". Com essa configuração, estabelecemos os elementos que irão sobrepor e os que serão sobrepostos na camada.
> 

![https://cdn1.gnarususercontent.com.br/1/1310271/ef0db91d-c608-45e7-9015-ec9bd532031d.png](https://cdn1.gnarususercontent.com.br/1/1310271/ef0db91d-c608-45e7-9015-ec9bd532031d.png)

Por último, também na aba de configurações avançadas, temos a opção de configuração "Align text baseline" ("Alinhar a linha de base do texto"). Ao ativá-la, os itens ficam alinhados à base da caixa de texto. Esse tipo de alinhamento não existia na versão anterior da seção "Auto layout".

## **Conclusão**

Espero que você tenha gostado das atualizações na funcionalidade de autolayout. Percebeu como as mudanças não foram tão significativas?

Agora, seus olhos estão abertos para explorar novas funcionalidades da ferramenta. **Até o próximo vídeo!**