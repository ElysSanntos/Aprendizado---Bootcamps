# Aula 07 - Fazendo requisições com o Postman

> A instrutora está com a seguinte estrutura JSON na tela:
> 

```
{"Title":"Top Gun","Year":"1986","Rated":"PG","Released":"16 May 1986","Runtime":"109 min","Genre":"Action, Drama","Director":"Tony Scott","Writer":"Jim Cash, Jack Epps Jr., Ehud Yonay","Actors":"Tom Cruise, Tim Robbins, Kelly McGillis","Plot":"As students at the United States Navy's elite fighter weapons school compete to be best in the class, one daring young pilot learns a few things from a civilian instructor that are not taught in the classroom.","Language":"English","Country":"United States","Awards":"Won 1 Oscar. 11 wins & 6 nominations total","Poster":"https://m.media-amazon.com/images/M/MV5BZjQxYTA3ODItNzgxMy00N2Y2LWJlZGMtMTRlM2JkZjI1ZDhhXkEyXkFqcGdeQXVyNDk3NzU2MTQ@._V1_SX300.jpg","Ratings":[{"Source":"Internet Movie Database","Value":"6.9/10"},{"Source":"Rotten Tomatoes","Value":"58%"},{"Source":"Metacritic","Value":"50/100"}],"Metascore":"50","imdbRating":"6.9","imdbVotes":"469,093","imdbID":"tt0092099","Type":"movie","DVD":"20 Oct 1998","BoxOffice":"$180,258,178","Production":"N/A","Website":"N/A","Response":"True"}COPIAR CÓDIGO
```

**Paulo:** Jaque, podemos usar via web, mas há situações em que a query da URL começa a ficar grande. Há momentos que precisamos enviar coisas através do `post`, onde precisamos abrir o *inspect* do navegador e escrever algumas instruções em JavaScript ou outra linguagem. Deve ter ferramentas mais interessantes para fazermos isso, não?

**Jacqueline:** Exato.

Como vimos na API, podemos passar vários parâmetros na documentação. Teríamos que ficar concatenando pelo navegador e isso ficaria ruim, podemos passar o tipo e etc. Logo, vamos usar alguma ferramenta para fazermos isso.

Nesse curso, vamos usar o Postman sendo uma ferramenta bastante usada pelas pessoas desenvolvedoras. Mas há outras, como o Insomnia.

```
https://www.omdbapi.com/?t=top+gun&apikey=6585022c
```

Copiamos a URL acima e vamos fazer essa mesma requisição pelo Postman. No Postman, no canto superior esquerdo podemos selecionar o ícone de mais "+" que será aberta uma aba com um campo para inserirmos o endereço e um método para selecionarmos.

Para fazermos uma requisição HTTP do tipo `get` (verbo), colamos o nosso endereço no campo ao lado do verbo. Observe que ele já identificou dois parâmetros em "Params", sendo o que colocamos como busca e a nossa API Key:

|  | KEY | VALUE | DESCRIPTION |
| --- | --- | --- | --- |
| ☑ | t | top+gun |  |
| ☑ | apikey | 6585022c |  |
|  | Key | Value | Description |

Na URL, ao invés de `top+gun` colocamos `matrix`.

```
https://www.omdbapi.com/?t=matrix&apikey=6585022c
```

**Paulo:** Ou editando no *value* mesmo, né?

**Jacqueline:** Sim, podemos editar pelo *value* direto. Clicando no botão "Send", obtemos um JSON:

```
{
        "Title": "Matrix",
        "Year": "1993",
        "Rated", "N/A",
        "Released": "01 Mar 1993",
        "Runtime": "60 min",
        "Genre": "Action, Drama, Fantasy",
        …
}
```

Note que ele até chama essa formatação mais legível de *Pretty* (canto superior do retorno do *body*). Isso porque está um elemento abaixo do outro, com seus atributos e valores, respectivamente.

**Paulo:** O Postman é um sistema na web ou que podemos instalá-lo na nossa máquina, onde conseguimos guardar o endereço para usá-lo e alterá-lo posteriormente. Muita gente usa essa ferramenta para **debugar** (identificar e corrigir erros ou bugs).

**Jacqueline:** Exato, e conseguimos fazer isso usando o Postman. Podemos editar pelo *value*, por exemplo, ao invés de matrix colocamos divertidamente.

|  | KEY | VALUE | DESCRIPTION |
| --- | --- | --- | --- |
| ☑ | t | divertidamente |  |
| ☑ | apikey | 6585022c |  |
|  | Key | Value | Description |

Ao selecionarmos "Send", temos:

> O retorno abaixo foi parcialmente transcrito. Para conferi-lo na íntegra, execute o código na sua máquina.
> 

```
{
        "Title": "Divertidamente",
        "Year": "2018",
        "Rated", "N/A",
        "Released": "11 Mar 2018",
        "Runtime": "N/A",
        "Genre": "Action, Drama, Fantasy",
        "Director": "N/A",
        "Writer": "N/A",
        "Actors": "N/A",
        "Plot": "N/A",
        "Language": "Portuguese",
        "Country": "Portugal",
        "Awards": "N/A",
        "Poster": "N/A",
        "Ratings": [],
        "Metascore": "N/A",
        …
}
```

Não devolveu tanta informação por ser uma animação, mas ele localizou pela busca qual o filme.

Ao iniciarmos o Postman, ele estará na tela "*Create an account or sign in*" (em português, "Crie uma conta ou faça login"). Caso queira usar somente para testes, basta selecionar a opção "*Skip and go to the app*" (em português, "Pular e ir para o aplicativo") na parte inferior esquerda.

> Create your account or sign in later? Skip and go to the app
> 

Mas caso queira, pode criar a sua conta para sincronizar com os seus projetos. Fica a seu critério isso.

**Paulo:** Relembrando que a API Key é a sua própria e não a que estamos usando aqui. Você precisa substituir para não dar erro informando que não há autorização ou que a API Key não é válida.

Vamos alterar, inclusive, o número no final do endereço.

**Jacqueline:** Vou alterar aqui para "1111" e clicar no botão "Send".

```
https://www.omdbapi.com/?t=matrix&apikey=1111COPIAR CÓDIGO
```

Como retorno, obtemos:

```
{
        "Response": "False",
        "Error": "Invalid API Key!"
}COPIAR CÓDIGO
```

**Paulo:** Informa que a API Key informada não é válida, logo, você deve inserir a sua chave. Também é possível explorar bastante, como buscar pelo ano de lançamento e visualizar uma lista de filmes, quando um nome é semelhante ao outro, etc. Talvez na documentação não esteja tão claro assim, então testamos a API pelo Postman.

Isso é muito comum no cotidiano de pessoas desenvolvedoras não somente em Java. Normalmente nas empresas chamamos APIs de outras empresas ou até mesmo temos o sistema quebrado em microsserviços. O que está acontecendo por trás dessa API está encapsulado, não é, Jaque?

**Jacqueline:** Exatamente.

**Paulo:** Está escondido, não sei dizer se há um banco de dados do MySQL Oracle, ou se está em um arquivo texto ou se o OMDb pesquisa em alguma API. Repare que esse mecanismo de encapsulamento e até acoplamento, nós tentamos diminuir para encapsular.

Esses princípios da orientação a objetos ocorre em nível macro da web, como podemos observar.

**Jacqueline:** O Paulo mencionou uma palavra muito importante: **teste**. Em vários cenários estamos envolvendo a aplicação Java e achamos que o erro é no código, e na verdade, é no Postman.

Se vier manualmente e digitar o endereço no Postman, ele já gera um erro. Por isso, é importante fazermos os testes e usar as ferramentas ao nosso favor para verificar e complementar o nosso trabalho como pessoa desenvolvedora.