# Aula 03 - Interfaces

Se possuímos um aparelho de 220 volts em casa, podemos utilizá-lo somente em uma rede de 220 volts — caso contrário, ele não funcionará corretamente. Da mesma forma, um aparelho com um plugue de três pinos não pode ser encaixado em uma tomada de dois encaixes. Na aplicação, ***o formato também deve ser respeitado***.

Podemos perceber que os objetos possuem vários atributos, e cada um deles possui um formato. O back-end espera receber os dados nos formatos configurados — e é nossa responsabilidade fazer com que os dados cadastrados sejam enviados de forma correta.

Por exemplo, se tivéssemos um atributo `data`, a base de dados correria o risco de ser desordenada, pois existem várias maneiras diferentes de escrever datas — há pessoas que escrevem com barras, com traços, outras abreviam o ano, e assim por diante.

Para evitar que ocorram erros na base de dados e garantir a sua integridade, devemos criar ***um modelo de retorno*** da API. No *Angular*, chamamos este modelo de "interface", ou "tipagem estrutural".

Criaremos uma interface diretamente no explorador à esquerda. Dentro da pasta `pensamentos`, damos um clique com o botão direito e criamos um novo arquivo chamado `pensamento.ts`. Também é possível criar a interface pelo terminal, mas não faremos isso.

Dentro de `pensamento.ts`, criaremos uma `interface` de nome `Pensamento`, com inicial maiúscula. Nesta interface, colocaremos todos os atributos e os respectivos formatos esperados. Também incluiremos a classe `export`, para tornar essa interface acessível à outras classes.

```
export interface Pensamento {
    id: number
    conteudo: string
    autoria: string
    modelo: string
}
```

Se houvessem outros atributos em nosso `package.json`, eles também seriam incluídos na interface.

A interface ou tipagem que construímos é como um contrato que deve ser seguido por ambas as partes — front-end e back-end.

> Como a interface que inserimos ajuda dentro da aplicação? Se tivéssemos incluído um atributo com o formato errado ou se esquecêssemos de informar algum atributo, o VS Code sinalizaria o erro.
> 

Vamos listar dois exemplos de erro:

- se deixarmos de passar o atributo `id`, o *VS Code* fará uma sinalização sublinhando o nome da classe de vermelho e abrindo uma caixa de mensagem com a descrição do erro.
- se passarmos o dado do `id` do tipo errado (uma `string` em vez de um `number`), o *VS Code* fará o sublinhando no nome do atributo e abrirá também uma caixa de erro.

Acessaremos três arquivos *typescript* e dentro deles vamos inserir a variável `Pensamento`, que deve receber a tipagem de `Pensamento`. Após o "Enter", a aplicação fará o `import` automático dessa variável.

- A primeira inclusão será feita no arquivo `pensamento.component.ts.`.

```
@Input() pensamento: Pensamento = {
    id: 0, // colocamos o valor 0 pois os dados reais do `id` virão do componente "pai".
    conteudo: 'I love Angular',
    autoria: 'Nay',
    modelo: 'modelo3'
}
```

- A segunda inclusão será feita no arquivo `criar-pensamento.component.ts`.

```
    pensamento: Pensamento = {
        id: 1,
        conteudo: 'Aprendendo Angular'
        autoria: 'Dev',
        modelo: 'modelo1'
    }
```

- A terceira inclusão será feita no arquivo `listar-pensamento.component.ts`.

Dentro do arranjo `listaPensamentos[]` vamos incluir a variável `Pensamento` como um arranjo de pensamentos adicionando colchetes `[]`. Depois vamos deletar quaisquer dados manuais que inserimos anteriormente dentro de `listaPensamentos[]`. Manteremos os dois arranjos vazios, já que o conteúdo de ambos virá do back-end.

```
    listaPensamentos: Pensamento[] = [];
```

Agora estamos utilizando o modelo da interface nos três arquivos.

Nós vimos os benefícios de criar uma interface e utilizar a sua tipagem. A seguir criaremos o arquivo que conterá todas as requisições ao back-end.