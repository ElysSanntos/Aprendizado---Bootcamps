# Cores e fontes

- [PlayGround Fonts](https://sourcefoundry.org/hack/playground.html)
- [Tabela de cores](https://celke.com.br/artigo/tabela-de-cores-html-nome-hexadecimal-rgb)

- <span style="font-family:Papyrus; font-size:2em;color: #FF4500">Papyrus</span>
<span style="font-family:Papyrus; font-size:1.2em;color: #FF4500">XXXXXX</span>

- <span style="font-family:nabla; font-size:2em;color: #A52A2A">nabla</span>

- <span style="font-family:Fira Code; font-size:2em;color: #00BFFF">Fira Code</span>

- <span style="font-family:Proggy; font-size:2em;color: #00FF7F">Proggy</span>

- <span style="font-family:DejaVu Sans Mono; font-size:2em;color: #A020F0">DejaVu Sans Mono</span>

- <span style="font-family:Terminus; font-size:2em;color: #FFFF00">Terminus</span>

- <span style="font-family: PragmataPro; font-size:2em;color: #00FF00">PragmataPro</span>

- <span style="font-family: Anonymous Pro; font-size:2em;color: #DA70D6">Anonymous Pro</span>

- <span style="font-family:Cascadia Code; font-size:2em;color: #BA55D3">Cascadia Code</span>



  * $`\textcolor{red}{\text Colocar o texto aqui}`$ 
  * $\textcolor{#BA55D3}{\text Colocar o texto aqui}$ 

### Destacar dentro do bloco de citação
- Suporta [- texto vermelho -] e [+ texto verde +], mas nenhum outro.

```diff

- IMPORTANTE!
+ IMPORTANTE!
! IMPORTANTE!
# IMPORTANTE!

```

# Links
Inline (títulos são opcionais):

Alguns [textos linkados](http://google.com/ "Título").


# Imagens
![alt text](img/alerta.jpg "Alerta")

# Listas
### Organizada, sem parágrafos: 

1. Foo
2. Bar

### Desorganizada, com parágrafos: 

* Um item de lista.    
#### Com vários parágrafos.
* Bar
Um item de lista.
Com vários parágrafos.

### Aninhado: 

* Abacus
    * absolute
* Bananas
    1. bitter
    2. bupkis
    3. burper
* Cunning

### Blocodecitação
> Colchetes angulares em estilo de e-mail são usados em blocosdecitação.
>> Você também pode aninhá-los.
>>
> * Você pode citar uma lista.
> * Etc.

> Para quebrar o blocodecitação aninhado, adicione um espaço entre as linhas.

Adicione outra linha para retomar o texto normal de parágrafo.

### Code spans
`<code>` spans são delimitados por crases.
Você pode incluir crases literais `` `assim` ``.

### Blocos de Código pré-formatados
    Recue cada linha de um Bloco de Código em pelo menos 4 espaços. Use dois pontos no final do parágrafo anterior.

#### Isso é um parágrafo normal:

    Isso é um Bloco de Código pré-formatado.
  

#### Normas horizontais
Três ou mais traços ou asteriscos: 

---

***

- - - -

# Tabelas

[1º.  Gerador on line](https://www.tablesgenerator.com/markdown_tables)
[2º. Gerador on line - SQL - Json - Etc...](https://tableconvert.com/markdown-generator)

| Tabelas    |      São       |  Legais |
|----------|:-------------:|------:|
| coluna 1 está |  left-aligned | $1600 |
| coluna 2 está |    centered   |   $12 |
| coluna 3 está | right-aligned |    $1 |